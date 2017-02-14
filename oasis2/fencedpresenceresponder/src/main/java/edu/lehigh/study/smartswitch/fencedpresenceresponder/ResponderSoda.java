package edu.lehigh.study.smartswitch.fencedpresenceresponder;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

import java.util.List;

import edu.umich.oasis.common.IDynamicAPI;
import edu.umich.oasis.common.OASISContext;
import edu.umich.oasis.common.smartthings.ISmartSwitchAPI;
import edu.umich.oasis.common.smartthings.SmartThingsDevice;


public class ResponderSoda implements Parcelable
{
    private static final String LOC_KEY = "location";
    private static final String TAG = "ResponderSoda";


    public ResponderSoda()
    {

    }

    public static void pollPresenceAndCompute(String presence)
    {
        Log.d(TAG, "receive event data from presencebasedcontrolChannel");
        Log.i(TAG, presence);

        /*
        * write code here.
        * This function will poll String value in presenceUpdateChannel and switch on smart switch when presence is 'home' or switch
        * off smart switch when presence is 'away'.
        * Please refer to MainActivity and SmartThingsSoda in oasis.study.skeleton.
        * */
    }


    //boiler-plate parcel serialize/deserialize
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i)
    {

    }

    public static final Parcelable.Creator<ResponderSoda> CREATOR = new Parcelable.Creator<ResponderSoda>()
    {
        public ResponderSoda createFromParcel(Parcel in) {
            return new ResponderSoda(in);
        }

        public ResponderSoda[] newArray(int size) {
            return new ResponderSoda[size];
        }
    };

    private ResponderSoda(Parcel in)
    {

    }
}
