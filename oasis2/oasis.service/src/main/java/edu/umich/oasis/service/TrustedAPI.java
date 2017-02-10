/*
 * Copyright (C) 2017 The Regents of the University of Michigan
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package edu.umich.oasis.service;

import android.content.ComponentName;
import android.util.Log;
import android.widget.Toast;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import edu.umich.oasis.common.TaintSet;
import edu.umich.oasis.common.smartthings.SmartThingsDevice;
import edu.umich.oasis.events.IEventChannelSender;
import edu.umich.oasis.internal.ITrustedAPI;
import edu.umich.oasis.kvs.IRemoteSharedPrefs;
import edu.umich.oasis.policy.Policy;
import edu.umich.oasis.policy.Sink;
import edu.umich.oasis.policy.SinkRequest;
import edu.umich.oasis.smartthings.SmartThingsService;

public final class TrustedAPI extends ITrustedAPI.Stub {
    private static final String TAG = "OASIS.TrustedAPI";
    private static final boolean localLOGV = Log.isLoggable(TAG, Log.VERBOSE);
    private static final boolean localLOGD = Log.isLoggable(TAG, Log.DEBUG);

    private final OASISApplication mApplication;

    private static TrustedAPI g_mInstance = null;
    private static final OkHttpClient g_mHttpClient = new OkHttpClient();

    private TrustedAPI() {
        mApplication = OASISApplication.getInstance();
    }

    public static synchronized TrustedAPI getInstance() {
        if (g_mInstance == null) {
            g_mInstance = new TrustedAPI();
        }
        return g_mInstance;
    }

    private Sandbox callerSandbox() {
        return Sandbox.getCallingSandbox();
    }

    private CallRecord callerRecord() {
        CallRecord record = callerSandbox().getRunningCallRecord();
        if (record == null) {
            throw new IllegalStateException("Sandbox not running a SODA");
        }
        return record;
    }

    private String callerPackageName() {
        String packageName = callerSandbox().getAssignedPackage();
        if (packageName == null) {
            throw new IllegalStateException("Callout from resolve");
        }
        return packageName;
    }

    @Override
    public synchronized IRemoteSharedPrefs openSharedPrefs(String packageName, String storeName,
                                                           int mode) {
        if (localLOGD) {
            Log.d(TAG, "openSharedPrefs(" + packageName + "/" + storeName + ")");
        }
        String callerPackage = callerPackageName();
        if (packageName == null) {
            packageName = callerPackage;
        }
        return new KVSSharedPrefs(callerSandbox(), packageName, callerPackage, storeName, mode);
    }

    static {
        Sink.registerBasicSink("TOAST");
        Sink.registerBasicSink("PUSH");
        Sink.registerBasicSink("NETWORK");
        Sink.registerBasicSink(SmartThingsService.SINK_SMARTSWITCH);
        Sink.registerBasicSink(SmartThingsService.SINK_SMARTLOCK);
    }

    public static void registerSinks() {
        // Does nothing, but ensures that the static initializer block has run.
    }

    @Override
    public void showToast(final CharSequence text, final int duration) {
        if (Policy.checkCallerSink(new SinkRequest("TOAST"))) {
            mApplication.getUIHandler().post(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(mApplication, text, duration).show();
                }
            });
        }
    }

    @Override
    public void taintSelf(TaintSet taint) {
        callerSandbox().addTaint(taint);
    }

    @Override
    public TaintSet removeTaints(TaintSet toRemove) {
        return callerSandbox().removeTaint(toRemove, Collections.singleton(callerPackageName()));
    }

    //private static final String PUSH_ENDPOINT = "https://api.pushbullet.com/v2/pushes";
    private static final String PUSH_ENDPOINT = "http://192.168.0.4:5000/upload";
    private static final String API_KEY = "aoINfE6LHxf1w9lJw0Oed4a35PdcGf3f";
    private static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    @Override
    public String sendPush(String title, String body) {
        if (localLOGD) {
            Log.d(TAG, "Sending push with title '" + title + "'");
        }
        if (Policy.checkCallerSink(new SinkRequest("NETWORK"))) {
            try {
                JSONObject push = new JSONObject();
                push.put("type", "note");
                push.put("title", title);
                push.put("body", body);

                RequestBody reqBody = RequestBody.create(JSON, push.toString());
                Request req = new Request.Builder()
                        .url(PUSH_ENDPOINT)
                       // .addHeader("Access-Token", API_KEY)
                        .post(reqBody)
                        .build();

                Response response = g_mHttpClient.newCall(req).execute();
                String s = response.body().string();
                Log.i(TAG, "Push returned: " + s);
                return s;

            } catch (IOException | JSONException e) {
                Log.w(TAG, e);
                return null;
            }
        } else {
            return null;
        }
    }

    @Override
    public String HTTPRequest(String address, String key, String value) {
        if (localLOGD) {
            Log.d(TAG, "make http request to " + address);
        }
        if (Policy.checkCallerSink(new SinkRequest("NETWORK"))) {
            try {
                JSONObject json = new JSONObject();
                json.put(key, value);
                RequestBody body = RequestBody.create(JSON, json.toString());
                Request request = new Request.Builder()
                        .url(address)
                        .post(body)
                        .build();
                Response response = g_mHttpClient.newCall(request).execute();
                return response.body().string();

            } catch (IOException | JSONException e) {
                Log.w(TAG, e);
                return null;
            }
        } else {
            return null;
        }
    }

    //SmartThings bridge API
    public List<SmartThingsDevice> getSwitches()
    {
        return SmartThingsService.getInstance().getSwitches();
    }

    public void switchOp(String op, String switchId)
    {
        if(Policy.checkCallerSink(new SinkRequest(SmartThingsService.SINK_SMARTSWITCH))) {
            Log.i(TAG, "switchOp: " + op + ", " + switchId);
            SmartThingsService.getInstance().switchOp(op, switchId);
        }
    }

    @Override
    public synchronized IEventChannelSender getEventChannel(ComponentName channelName) {
        return mApplication.getChannel(channelName).getSender();
    }
}
