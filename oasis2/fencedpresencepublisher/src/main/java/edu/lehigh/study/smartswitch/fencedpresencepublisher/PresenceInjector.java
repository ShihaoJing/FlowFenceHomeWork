package edu.lehigh.study.smartswitch.fencedpresencepublisher;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import edu.umich.oasis.client.OASISConnection;
import edu.umich.oasis.client.Soda;

public class PresenceInjector extends Service {

    private static final String TAG = "PresenceInjector";

    private static String LOC_KEY = "location";
    FirebaseDatabase firebaseRef;
    DatabaseReference databaseRef;

    OASISConnection oconn = null;
    // handler of PrensenceSoda
    Soda.S1<String, Void> putLocStatic = null;

    public PresenceInjector()
    {
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        connectToOASIS();
        init();
        rx();

        // If we get killed, after returning from here, restart
        return START_STICKY;
    }

    public void connectToOASIS()
    {
        Log.i(TAG, "Binding to OASIS...");
        OASISConnection.bind(this, new OASISConnection.Callback() {
            @Override
            public void onConnect(OASISConnection conn) throws Exception {
                Log.i(TAG, "Bound to OASIS");
                onOASISConnect(conn);
            }
        });
    }

    public void resolve()
    {
        if(oconn != null)
        {
            try {
                putLocStatic = oconn.resolveStatic(void.class, PresenceSoda.class, "putLoc", String.class);
            } catch(Exception e)
            {
                Log.e(TAG, "error: " + e);
            }
        }
    }

    private void onOASISConnect(OASISConnection conn)
    {
        oconn = conn;
        Toast t = Toast.makeText(getApplicationContext(), "connected to OASIS", Toast.LENGTH_SHORT);
        t.show();

        resolve();
    }

    // initialization of Firebase instance
    private void init()
    {
        firebaseRef = FirebaseDatabase.getInstance();
        databaseRef = firebaseRef.getReference(LOC_KEY);
    }

    private void rx()
    {
        /*
        * Write your code here.
        * This function will listen to value change in Firebase realtime database and invoke updateOasisKV() below.
        * */

    }

    private void updateOasisKV(String newloc)
    {
        if(putLocStatic != null)
        {
            /*
            * Write code here.
            * This function will pass 'newloc' to PresenceSoda by invoking pubLoc() function that putLocStatic holds.
            * Please refer to MainActivity in oasis.study.skeleton and see how to invoking functions in Soda.
            * */

        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
