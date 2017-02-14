package edu.lehigh.study.smartswitch.fencedpresencepublisher;

import android.content.ComponentName;
import android.os.Parcel;
import android.os.Parcelable;

import edu.umich.oasis.common.TaintSet;

public class PresenceSoda implements Parcelable
{
    private static final String TAG = "PresenceSoda";

    private static final String TAINT_TAG = "edu.lehigh.study.smartswitch.fencedpresencepublisher/presenceTaint";
    private static final String CHANNEL_NAME = "edu.lehigh.study.smartswitch.fencedpresencepublisher/presenceUpdateChannel";
    private static final ComponentName PRESENCE_UPDATE_CHANNEL = ComponentName.unflattenFromString(CHANNEL_NAME);
    private static final TaintSet PRESENCE_TAINT = new TaintSet.Builder().addTaint(TAINT_TAG).build();

    public PresenceSoda()
    {
    }

    public static void putLoc(String val)
    {

        /*
        * Write your code here
        * This function will add taint to String 'val', and fired channel event to broadcast 'val'.
        * Channel name and taint set are class member.
        * Please refer to EventPublisher in oasis.study.skeleton and see how to fire an event channel in Soda.
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

