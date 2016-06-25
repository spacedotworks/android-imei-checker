package space.works.id.check;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.widget.TextView;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class IdcheckActivity extends Activity {

    public void onBackPressed(){
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

        AdView mAdView = (AdView) findViewById(R.id.adView1);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        AdView mAdView2 = (AdView) findViewById(R.id.adView2);
        AdRequest adRequest2 = new AdRequest.Builder().build();
        mAdView2.loadAd(adRequest2);

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