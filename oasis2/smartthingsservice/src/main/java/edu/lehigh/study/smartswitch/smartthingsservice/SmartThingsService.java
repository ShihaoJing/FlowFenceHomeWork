package edu.lehigh.study.smartswitch.smartthingsservice;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;


public final class SmartThingsService
{
    private static final String TAG = "SmartThingsService";

    //short-circuiting the OAuthToken handling process.
    private String OAuthToken = "Bearer 80019c76-29c8-4c7d-9856-b19834b94a7b";

    //a list of device-ids of all switches the user authorized during OAuth flow.
    private ArrayList<SmartThingsDevice> devices = new ArrayList<SmartThingsDevice>();

    private final OkHttpClient httpClient = new OkHttpClient();

    private static SmartThingsService mSelf = null;

    private final String endpointsURL = "https://graph.api.smartthings.com/api/smartapps/endpoints";
    private String installationURL;

    private final String DEVICE_TYPE_URI_SWITCH = "switches";
    private final String DEVICE_TYPE_URI_LOCKS = "locks";
    private final String DEVICE_TYPE_URI_SENSORS = "sensors";
    private final String DEVICE_TYPE_CTRL_SWITCH = "switchcontrol";
    private final String DEVICE_TYPE_CTRL_LOCK = "lockcontrol";
    private final String DEVICE_TYPE_STATE_SWITCH = "switchstate";
    private final String DEVICE_TYPE_STATE_SENSOR = "sensorstate";

    public static final String DEVICE_OPERATION_ON = "on";
    public static final String DEVICE_OPERATION_OFF = "off";

    public static final String SINK_SMARTSWITCH = "SmartThings.SmartSwitch";
    public static final String SINK_SMARTLOCK = "SmartThings.SmartLock";

    private SmartThingsService()
    {
        fetchInstallationURL();
        pullDevices(DEVICE_TYPE_URI_SWITCH);
        //pullDevices(DEVICE_TYPE_URI_LOCKS);
        pullDevices(DEVICE_TYPE_URI_SENSORS);
    }

    public static SmartThingsService getInstance()
    {
        if(mSelf == null) {
            mSelf = new SmartThingsService();
        }

        return mSelf;
    }

    private void fetchInstallationURL() {
        try {
            Request request = new Request.Builder()
                    .url(endpointsURL)
                    .addHeader("Authorization", OAuthToken)
                    .build();
            Response response = httpClient.newCall(request).execute();
            String jsonStr = response.body().string();
            JSONArray jobj = new JSONArray(jsonStr);
            installationURL  = jobj.getJSONObject(0).getString("uri");
        } catch (IOException | JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private void pullDevices(String deviceTypeStr)
    {
        try {
            //now get all devices
            String getDevicesURL = installationURL + "/" + deviceTypeStr;
            Request getDevices = new Request.Builder()
                    .url(getDevicesURL)
                    .addHeader("Authorization", OAuthToken)
                    .build();
            Response Resp = httpClient.newCall(getDevices).execute();


            String jsonResp = Resp.body().string();
            JSONObject switchObj = new JSONObject(jsonResp);

            int dType = -1;
            if(deviceTypeStr.equals(DEVICE_TYPE_URI_SWITCH))
                dType = SmartThingsDevice.TYPE_SWITCH;
            else if(deviceTypeStr.equals(DEVICE_TYPE_URI_LOCKS))
                dType = SmartThingsDevice.TYPE_LOCK;
            else if(deviceTypeStr.equals(DEVICE_TYPE_URI_SENSORS))
                dType = SmartThingsDevice.TYPE_SENSOR;

            Iterator<String> iter = switchObj.keys();

            while(iter.hasNext())
            {
                String switchName = iter.next();
                String switchId = switchObj.getString(switchName);
                SmartThingsDevice aSwitch = new SmartThingsDevice(switchName, switchId, dType);
                devices.add(aSwitch);
            }

        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (JSONException jsone) {
            jsone.printStackTrace();
        }
    }

    public ArrayList<SmartThingsDevice> getSwitches()
    {
        ArrayList<SmartThingsDevice> switches = new ArrayList<SmartThingsDevice>();

        for(SmartThingsDevice dev : devices)
        {
            if(dev.getType() == SmartThingsDevice.TYPE_SWITCH)
                switches.add(dev);
        }
        return switches;
    }

    public ArrayList<SmartThingsDevice> getLocks()
    {
        ArrayList<SmartThingsDevice> locks = new ArrayList<SmartThingsDevice>();

        for(SmartThingsDevice dev : devices)
        {
            if(dev.getType() == SmartThingsDevice.TYPE_LOCK)
                locks.add(dev);
        }

        return locks;
    }

    public ArrayList<SmartThingsDevice> getSensors()
    {
        ArrayList<SmartThingsDevice> locks = new ArrayList<SmartThingsDevice>();

        for(SmartThingsDevice dev : devices)
        {
            if(dev.getType() == SmartThingsDevice.TYPE_SENSOR)
                locks.add(dev);
        }

        return locks;
    }

    public void switchOp(String op, String switchId)
    {
        devOp(op, switchId, DEVICE_TYPE_CTRL_SWITCH);
    }

    public void lockOp(String op, String lockId)
    {
        devOp(op, lockId, DEVICE_TYPE_CTRL_LOCK);
    }

    private void devOp(String op, String id, String controlURIPart)
    {
        try {
            String controlURL = installationURL + "/" + controlURIPart + "/" + id + "/" + op;
            Request ctrl = new Request.Builder()
                    .url(controlURL)
                    .addHeader("Authorization", OAuthToken)
                    .put(RequestBody.create(null, new byte[0]))
                    .build();
            httpClient.newCall(ctrl).execute();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    private String devState(String id, String stateURLPart)
    {
        String state = "unkown state";
        try {
            String controlURL = installationURL + "/" + stateURLPart + "/" + id;
            Request ctrl = new Request.Builder()
                    .url(controlURL)
                    .addHeader("Authorization", OAuthToken)
                    .build();
            Response response = httpClient.newCall(ctrl).execute();
            String jsonResp = response.body().string();
            JSONObject switchObj = new JSONObject(jsonResp);
            state = switchObj.getString(id);
            return state;
        } catch(IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return state;
    }

    public String getSwitchState(String switchId)
    {
        return devState(switchId, DEVICE_TYPE_STATE_SWITCH);
    }

    public String getSensorState(String sensorId)
    {
        return devState(sensorId, DEVICE_TYPE_STATE_SENSOR);
    }
}
