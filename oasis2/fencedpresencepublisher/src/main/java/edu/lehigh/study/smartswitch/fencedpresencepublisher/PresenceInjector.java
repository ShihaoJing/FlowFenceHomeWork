package edu.lehigh.study.smartswitch.fencedpresencepublisher;


import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;
import edu.umich.oasis.client.OASISConnection;

public class PresenceInjector extends Service {


    private static final String TAG = "PresenceInjector";
    OASISConnection oconn = null;
    /* your code here */

    public PresenceInjector()
    {
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        connectToOASIS();

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

    private void onOASISConnect(OASISConnection conn)
    {
        oconn = conn;
        Toast t = Toast.makeText(getApplicationContext(), "connected to OASIS", Toast.LENGTH_SHORT);
        t.show();

        /* your code here */
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
