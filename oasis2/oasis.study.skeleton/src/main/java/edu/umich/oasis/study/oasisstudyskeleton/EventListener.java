package edu.umich.oasis.study.oasisstudyskeleton;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

import edu.umich.oasis.common.IDynamicAPI;
import edu.umich.oasis.common.OASISContext;

public class EventListener implements Parcelable {

    private static final String TAG = "EventListener";

    public EventListener() {
        Log.d(TAG, "create instance of EventListener");
    }

    public static void pollTestValue(String val) {
        Log.d(TAG, "receive test value" + val + "from EventPublisher");
    }

    //boiler-plate parcel serialize/deserialize
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {

    }

    public static final Parcelable.Creator<EventListener> CREATOR = new Parcelable.Creator<EventListener>()
    {
        public EventListener createFromParcel(Parcel in) {
            return new EventListener(in);
        }

        public EventListener[] newArray(int size) {
            return new EventListener[size];
        }
    };

    private EventListener(Parcel in)
    {

    }
}
