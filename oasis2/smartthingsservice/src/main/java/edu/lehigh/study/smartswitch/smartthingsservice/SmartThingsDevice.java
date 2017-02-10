package edu.lehigh.study.smartswitch.smartthingsservice;

import android.os.Parcel;
import android.os.Parcelable;

public final class SmartThingsDevice implements Parcelable
{
    private final String devName;
    private final String devId;
    private final int type;

    public static final int TYPE_SWITCH = 1;
    public static final int TYPE_LOCK = 2;
    public static final int TYPE_SENSOR = 3;

    public SmartThingsDevice()
    {
        devId = "";
        devName = "";
        type = -1;
    }

    public SmartThingsDevice(String _name, String _id, int _type)
    {
        devId = _id;
        devName = _name;
        type = _type;
    }

    public String toString()
    {
        return devName + "," + devId;
    }

    public String getId()
    {
        return devId;
    }

    public String getName()
    {
        return devName;
    }

    public int getType() { return type; }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(devName);
        parcel.writeString(devId);
        parcel.writeInt(type);
    }

    public static final Parcelable.Creator<SmartThingsDevice> CREATOR = new Parcelable.Creator<SmartThingsDevice>() {
        @Override
        public SmartThingsDevice createFromParcel(Parcel source) {
            return new SmartThingsDevice(source);
        }

        @Override
        public SmartThingsDevice[] newArray(int size) {
            return new SmartThingsDevice[size];
        }
    };

    private SmartThingsDevice(Parcel src)
    {
        devName = src.readString();
        devId = src.readString();
        type = src.readInt();
    }
}

