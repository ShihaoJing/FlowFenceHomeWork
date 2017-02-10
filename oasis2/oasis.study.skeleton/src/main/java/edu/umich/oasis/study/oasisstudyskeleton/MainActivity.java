package edu.umich.oasis.study.oasisstudyskeleton;

import android.app.Activity;
import android.content.ComponentName;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import edu.umich.oasis.client.OASISConnection;
import edu.umich.oasis.client.Sealed;
import edu.umich.oasis.client.Soda;
import edu.umich.oasis.common.SodaDescriptor;


public class MainActivity extends Activity {

    //our connection to the OASIS system
    OASISConnection oconn = null;

    //static Soda handler
    Soda.S1<String, Void> eventPublisherSoda;
    Soda.S1<String, Void> eventListenerSoda;

    //instance Soda handler
    Soda.S0<SmartThingsSoda> smartThingsSodaS0;
    Sealed<SmartThingsSoda> smartThingsSodaSealed;

    Button cmdConnect, cmdSodaOps, smartSwitch;

    private static final String TAG = "OASIS.skeleton/Main";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cmdConnect = (Button) findViewById(R.id.cmdConnect);
        cmdSodaOps = (Button) findViewById(R.id.cmdSodaOps);
        smartSwitch = (Button) findViewById(R.id.SmartSwitch);

        cmdConnect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                connectToOASIS();
            }
        });

        cmdSodaOps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                putValueInEventChannel("hello oasis");
            }
        });


        smartSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operateSwitchInSoda();
            }
        });


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
        if (oconn != null) {
            try {

                //implicit "this", param1Type, RetType = resolve(ReturnType, Clazz, methodAsString, param1Type
                //get static method of putVal
                eventPublisherSoda = oconn.resolveStatic(Void.class, EventPublisher.class, "putVal", String.class);

                //get static method of pollTestValue
                eventListenerSoda = oconn.resolveStatic(Void.class, EventListener.class, "pollTestValue", String.class);
                SodaDescriptor sd = eventListenerSoda.getDescriptor();
                ComponentName cn = new ComponentName("edu.umich.oasis.study.oasisstudyskeleton", "testValuePublishChannel");
                try {
                    //make eventListenerSoda listen to testValuePublishChannel
                    oconn.getRawInterface().unsubscribeEventChannel(cn,sd);
                    oconn.getRawInterface().subscribeEventChannel(cn, sd);
                } catch (Exception e)
                {
                    Log.e(TAG, "error subscribeEventChannel: " + e);
                }

                //get instance of smartThingsSoda class
                smartThingsSodaS0 = oconn.resolveConstructor(SmartThingsSoda.class);
                smartThingsSodaSealed = smartThingsSodaS0.call();


            } catch(Exception e)
            {
                Log.i(TAG, "error: " + e);
            }
        }
        Toast t = Toast.makeText(getApplicationContext(), "connected to OASIS", Toast.LENGTH_SHORT);
        t.show();
    }

    private void putValueInEventChannel(String value)
    {
        if(eventPublisherSoda != null)
        {
            try {
                eventPublisherSoda.arg(value).call();
            } catch(Exception e)
            {
                Log.i(TAG, "error: " + e);
            }
        }
    }


    private void operateSwitchInSoda()
    {
        if(oconn != null)
        {
            try {
                //get instance of switchOp method
                Soda.S2<SmartThingsSoda, String, Void> smartThingsStatic = oconn.resolveInstance(Void.class, SmartThingsSoda.class, "switchOp", String.class);
                smartThingsStatic.arg(smartThingsSodaSealed).arg("on").call();
            }
            catch(Exception e)
            {
                Log.i(TAG, "error: " + e);
            }
        }
    }

}
