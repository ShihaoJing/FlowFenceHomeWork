package edu.lehigh.study.smartswitch.fencedpresenceresponder;

import android.os.Parcel;
import android.os.Parcelable;


public class ResponderSoda implements Parcelable
{
    private static final String LOC_KEY = "location";
    private static final String TAG = "ResponderSoda";

    public ResponderSoda() {}

    public static void pollPresenceAndCompute(String presence)
    {
        /*your code here*/
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
