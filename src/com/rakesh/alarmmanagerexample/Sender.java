package com.rakesh.alarmmanagerexample;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

public class Sender extends Activity {
	
	@Override
	public void onCreate(Bundle savedInstanceState) {

		
		  
	      //   sendMessage();
	      
	}

	/*
	public void sendMessage() {
		  Log.d("sender", "Broadcasting message");
		  Intent intent = new Intent("custom-event-name");
		  // You can also include some extra data.
		  intent.putExtra("message", "This is my message!");
		  LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
	}
	*/
}
