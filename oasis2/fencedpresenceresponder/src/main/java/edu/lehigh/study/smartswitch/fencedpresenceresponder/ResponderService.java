package edu.lehigh.study.smartswitch.fencedpresenceresponder;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import edu.umich.oasis.client.OASISConnection;
import edu.umich.oasis.client.Soda;

public class ResponderService extends Service {
    private static final String TAG = "ResponderService";

    OASISConnection oconn = null;
    Soda.S1<String, Void> pollPresence = null;

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
            try {
                pollPresence = oconn.resolveStatic(void.class, ResponderSoda.class, "pollPresenceAndCompute", String.class);

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
        setupListener();
    }

    void setupListener()
    {
        /*
        * write code here.
        * This function will set up listener in ResponderSoda and poll String value in presenceUpdateChannel.
        * Please refer to MainActivity in oasis.study.skeleton and see how to set up listern for EventListener Soda.
        * */
    }


    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
