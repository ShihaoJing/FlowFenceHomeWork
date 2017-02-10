package edu.umich.oasis.study.oasisstudyskeleton;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

import java.util.List;

import edu.umich.oasis.common.OASISContext;
import edu.umich.oasis.common.smartthings.ISmartSwitchAPI;
import edu.umich.oasis.common.smartthings.SmartThingsDevice;

public class SmartThingsSoda implements Parcelable{
    private static final String TAG = "SmartThingsSoda";

    public SmartThingsSoda()
    {
        Log.i(TAG, "SmartThingsSoda ctor");
    }

    public void switchOp(String op) {
        Log.i(TAG, op);
        if (op != null) {
            if (op.equals("on")) {
                Log.i(TAG, "let there be light!");
            } else if (op.equals("on")) {
                Log.i(TAG, "lights off!");
            } else {
                Log.i(TAG, "illegal operation");
                return;
            }
            ISmartSwitchAPI switchAPI = (ISmartSwitchAPI) OASISContext.getInstance().getTrustedAPI("smartswitch");
            List<SmartThingsDevice> switches = switchAPI.getSwitches();
            if (switches != null) {
                for (SmartThingsDevice ssw : switches) {
                    switchAPI.switchOp(op, ssw.getId());
                }
            } else {
                Log.e(TAG, "no switches available");
            }

        }
        Log.i(TAG, "null operation");
    }


    //boiler-plate parcel serialize/deserialize
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {

    }

    public static final Parcelable.Creator<SmartThingsSoda> CREATOR = new Parcelable.Creator<SmartThingsSoda>()
    {
        public SmartThingsSoda createFromParcel(Parcel in) {
            return new SmartThingsSoda(in);
        }

        public SmartThingsSoda[] newArray(int size) {
            return new SmartThingsSoda[size];
        }
    };

    private SmartThingsSoda(Parcel in)
    {

    }
}
