package edu.lehigh.study.smartswitch.fencedpresencepublisher;

import android.os.Parcel;
import android.os.Parcelable;

public class PresenceSoda implements Parcelable
{

    private static final String TAG = "PresenceSoda";

    /* your code here */



    public PresenceSoda()
    {
    }

    public static void putLoc(String val)
    {

        /* your code here */
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

    public static final Parcelable.Creator<PresenceSoda> CREATOR = new Parcelable.Creator<PresenceSoda>()
    {
        public PresenceSoda createFromParcel(Parcel in) {
            return new PresenceSoda(in);
        }

        public PresenceSoda[] newArray(int size) {
            return new PresenceSoda[size];
        }
    };

    private PresenceSoda(Parcel in)
    {
    }
}

