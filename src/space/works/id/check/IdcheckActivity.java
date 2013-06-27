package space.works.id.check;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.widget.TextView;

//import com.google.ads.*;

import com.appbrain.AppBrain;

public class IdcheckActivity extends Activity {
    /** Called when the activity is first created. */

	//private AdView adView;
    public void onBackPressed(){
    	
    	AppBrain.getAds().showInterstitial(this);
        finish();
    }
	
	public void onResume()
	{
	    super.onResume();
	}
	
	public void onPause()
	{
	    super.onPause();
	}
	
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        AppBrain.initApp(this);
        
         	
        
        //IMEI////////////////////////////////// 
        TelephonyManager telephonyManager = (TelephonyManager)getSystemService(Context.TELEPHONY_SERVICE);
        String imeino = telephonyManager.getDeviceId();       
        TextView imei = (TextView) findViewById(R.id.imei);
        imei.setText(imeino);
        imei.setKeyListener(null);
        
        //NETWORK////////////////////////////////        
        String soft = telephonyManager.getNetworkCountryIso();
        String soft2 = telephonyManager.getNetworkOperatorName();
        Boolean soft3 = telephonyManager.isNetworkRoaming();
        TextView uuid = (TextView) findViewById(R.id.uuid);
        uuid.setText(soft2 + " (" + soft + ") / Network roaming=" + soft3 );
        uuid.setKeyListener(null);
        
        //SIM///////////////////////////////
        String sim1 = telephonyManager.getSimCountryIso();
        String sim2 = telephonyManager.getSimOperatorName();
        String sim3 = telephonyManager.getSimSerialNumber();
        TextView sim = (TextView) findViewById(R.id.sim);
        sim.setText(sim2 + " (" + sim1 + ") / Serial No.= " + sim3);
        sim.setKeyListener(null);
        
        //SUBSCRIBER/////////////////////////
        String sub1 = telephonyManager.getSubscriberId();
        String sub2 = telephonyManager.getVoiceMailNumber();
        TextView sub = (TextView) findViewById(R.id.subs);
        sub.setText("ID=" + sub1 + " / Voicemail No.=" + sub2);
        sub.setKeyListener(null);
        
        //ANDROID ID
        String android_id = Secure.getString(getBaseContext().getContentResolver(),
                                                                Secure.ANDROID_ID); 
        TextView serialno = (TextView) findViewById(R.id.serial);
        serialno.setText(android_id);
        serialno.setKeyListener(null);

        
    }
}