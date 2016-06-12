package com.rakesh.alarmmanagerexample;

import com.rakesh.alarmmanagerexample.R;

import android.os.Bundle;
import android.os.Process;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.support.v4.app.NavUtils;
import android.support.v4.content.LocalBroadcastManager;
import android.telephony.TelephonyManager;

public class AlarmManagerActivity extends Activity {

	//GPSTracker gps;
	
	private AlarmManagerBroadcastReceiver alarm;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm_manager);
        alarm = new AlarmManagerBroadcastReceiver();
        
        LocalBroadcastManager.getInstance(this).registerReceiver(mMessageReceiver, new IntentFilter("custom-event-name"));
    }
    
    
    private BroadcastReceiver mMessageReceiver = new BroadcastReceiver() {
    	  @Override
    	  public void onReceive(Context context, Intent intent) {
    	    // Get extra data included in the Intent
    	    String message = intent.getStringExtra("message");
    	    Log.d("receiver", "Got message: " + message);
    	  }
    	};
    
    	@Override
    	protected void onDestroy() {
    	  // Unregister since the activity is about to be closed.
    	  LocalBroadcastManager.getInstance(this).unregisterReceiver(mMessageReceiver);
    	  super.onDestroy();
    	}	
    	
    	
    @Override
	protected void onStart() {
		super.onStart();
	}

    public void startRepeatingTimer(View view) {
    	Context context = this.getApplicationContext();
    	if(alarm != null){
    		alarm.SetAlarm(context);
    		//gps = new GPSTracker(AlarmManagerActivity.this);
    	}else{
    		Toast.makeText(context, "Alarm is null", Toast.LENGTH_SHORT).show();
    	}
    }
    
    public void cancelRepeatingTimer(View view){
    	Context context = this.getApplicationContext();
    	if(alarm != null){
    		alarm.CancelAlarm(context);
    	}else{
    		Toast.makeText(context, "Alarm is null", Toast.LENGTH_SHORT).show();
    	}
    }
  
    
    public void onetimeTimer(View view){
    	Context context = this.getApplicationContext();
    	if(alarm != null){
    		alarm.setOnetimeTimer(context);
    	}else{
    		Toast.makeText(context, "Alarm is null", Toast.LENGTH_SHORT).show();
    	}
    }
    
	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_widget_alarm_manager, menu);
        return true;
    }

    
}
