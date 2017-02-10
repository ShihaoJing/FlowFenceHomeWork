package edu.lehigh.study.smartswitch.fencedpresenceresponder;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import edu.umich.oasis.client.OASISConnection;

public class ResponderService extends Service {
    private static final String TAG = "ResponderService";

    OASISConnection oconn = null;
    /* your code here */

    public ResponderService()
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

    public void resolve()
    {
        if(oconn != null)
        {
            /* your code here */
        }
    }

    private void onOASISConnect(OASISConnection conn)
    {
        oconn = conn;
        Toast t = Toast.makeText(getApplicationContext(), "connected to OASIS", Toast.LENGTH_SHORT);
        t.show();

        resolve();
        setupListener();
    }

    void setupListener()
    {
        /* your code here */
    }


    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
