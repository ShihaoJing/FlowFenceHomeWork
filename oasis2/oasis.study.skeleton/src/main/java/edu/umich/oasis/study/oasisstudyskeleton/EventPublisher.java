package edu.umich.oasis.study.oasisstudyskeleton;

import android.content.ComponentName;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

import edu.umich.oasis.common.IEventChannelAPI;
import edu.umich.oasis.common.OASISContext;
import edu.umich.oasis.common.TaintSet;

public class EventPublisher implements Parcelable {

    private static final String TAINT_TAG = "edu.umich.oasis.study.oasisstudyskeleton/testValueTaint";
    private static final String CHANNEL_NAME = "edu.umich.oasis.study.oasisstudyskeleton/testValuePublishChannel";
    private static final ComponentName PRESENCE_UPDATE_CHANNEL = ComponentName.unflattenFromString(CHANNEL_NAME);
    private static final TaintSet PRESENCE_TAINT = new TaintSet.Builder().addTaint(TAINT_TAG).build();

    //non-state
    private static final String TAG = "EventPublisher";

    public EventPublisher() {
        Log.d(TAG, "create instance of EventPublisher");
    }


    public static void putVal(String val)
    {
        IEventChannelAPI eventApi = (IEventChannelAPI) OASISContext.getInstance().getTrustedAPI("event");
        eventApi.fireEvent(PRESENCE_TAINT, PRESENCE_UPDATE_CHANNEL, val);
        Log.i(TAG, "publish value " + val + "with taint and fired channel event");
    }

    //boiler-plate parcel serialize/deserialize
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {

    }

    public static final Parcelable.Creator<EventPublisher> CREATOR = new Parcelable.Creator<EventPublisher>()
    {
        public EventPublisher createFromParcel(Parcel in) {
            return new EventPublisher(in);
        }

        public EventPublisher[] newArray(int size) {
            return new EventPublisher[size];
        }
    };

    private EventPublisher(Parcel in)
    {

    }
}
