package com.rakesh.alarmmanagerexample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PowerManager;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.widget.Toast;

public class AlarmManagerBroadcastReceiver extends BroadcastReceiver {

	final public static String ONE_TIME = "onetime";
	GPSTracker gps;
	InputStream is = null;
	
	
	@Override
	public void onReceive(Context context, Intent intent) {
	/*	 PowerManager pm = (PowerManager) context.getSystemService(Context.POWER_SERVICE);
         PowerManager.WakeLock wl = pm.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK, "YOUR TAG");
         //Acquire the lock
         wl.acquire();

         //You can do the processing here update the widget/remote views.
         Bundle extras = intent.getExtras();
         StringBuilder msgStr = new StringBuilder();
         
         if(extras != null && extras.getBoolean(ONE_TIME, Boolean.FALSE)){
        	 msgStr.append("One time Timer : ");
         }
         
         Format formatter = new SimpleDateFormat("hh:mm:ss a");
         msgStr.append(formatter.format(new Date()));

         Toast.makeText(context, msgStr, Toast.LENGTH_LONG).show();
       */
         
         gps = new GPSTracker(context);
          
         // check if GPS enabled		
         if(gps.canGetLocation()){
	        	
	        	String latitude  = Double.toString(gps.getLatitude());
	        	String longitude = Double.toString(gps.getLongitude());
	        	
	        	// String res = POST("http://192.168.12.180/android_connect/tutorial.php", latitude, longitude) ;
	         	//String res = POST("http://10.0.2.2/android_connect/tutorial.php", latitude, longitude) ;
	        		
	            System.out.println(latitude + "   "+ longitude) ;
	            
	            // Asyn mode... 
	            
	            
	            
	            
	            // Localbroadcast...
	            
	            //Intent it = new Intent(context, Sender.class);
	            //startActivity(it);

	            
	            
/*	         	
	         	try {
	         	GetText("http://10.0.2.2/android_connect/tutorial.php", latitude, longitude) ;
	         	} catch (Exception e) {
		            System.out.println("Error: " + e) ;
	         	}
	         	
	*/         	
	        	//System.out.println("result: " + res) ;
	        	
	        /*	
	        	List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
	            nameValuePairs.add(new BasicNameValuePair("latitude", latitude));
	            nameValuePairs.add(new BasicNameValuePair("longitude", longitude));
	            
	            System.out.println(latitude + "   "+ longitude) ;
	            
	            
	            
	            try{
	                HttpClient httpClient = new DefaultHttpClient();
	                HttpPost httpPost =  new HttpPost("http://192.168.12.180/android_connect/tutorial.php");
	
	                System.out.println("0. " + " ") ;
	                httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
	                System.out.println("1. " + " ") ;
	                HttpResponse response = httpClient.execute(httpPost);
	                
	                System.out.println("2. " + " " + response) ;
	                
	                
	                HttpEntity entity = response.getEntity();
	                
	                System.out.println("3. " + " " + entity) ;
	                is = entity.getContent();
	
	                System.out.println("4. " + " " + is) ;

	                
	                String msg = "Data Entered Successfully";
	                Toast.makeText(context,msg,Toast.LENGTH_LONG).show();
	
	                 //Toast.makeText(getApplicationContext(),"Your Location is -\nLat: " + latitude + "\nLog: " + longitude + "\nCS: " + currentspeed + "\nCS: " + currentspeed + "\nAlt: " + altitude + "\nAcc: " + accuracy + "\nBearing" +bearing, Toast.LENGTH_LONG).show();
	
	
	                 //Toast.makeText(getApplicationContext(),"Your Location is -\nLat: " + latitude + "\nLong: " + longitude + "\nDate: " + strdate1 + "\nTime: " + strdate2 + "\nSpeed: " + sp[0], Toast.LENGTH_LONG).show();
	             } catch (ClientProtocolException e) {
	            	 System.out.println("ClientProtocolException : " + e)  ;
	            	 e.printStackTrace();
	             } catch (UnsupportedEncodingException e) {
	            	 System.out.println("UnsupportedEncodingException: " + e)  ;
	                 e.printStackTrace();
	             } catch (IOException e) {
	            	 System.out.println("IOException: " + e)  ;

	                 e.printStackTrace();
	             }
	            catch (Exception e) {
	            	 System.out.println("Exception: " + e)  ;

	                 e.printStackTrace();
	             }
	        	
	        	
	        	
	        	
	        // \n is for new line
	        Toast.makeText(context, "Your Location is - \nLat: " + latitude + "\nLong: " + longitude, Toast.LENGTH_LONG).show();	
	     }
         else
         {
        	 //Toast.makeText(context, "else mai aaagaya", Toast.LENGTH_LONG).show();
         }
         
         //Release the lock
         //wl.release();
         */
         }
	}
	
	
	
	public  void  GetText(String u, String lat, String lon)  throws  UnsupportedEncodingException
    {
        
         // Create data variable for sent values to server  
         
          String data = URLEncoder.encode("latitude", "UTF-8") + "=" + URLEncoder.encode(lat, "UTF-8"); 

          data += "&" + URLEncoder.encode("longitude", "UTF-8") + "=" + URLEncoder.encode(lon, "UTF-8"); 
          
          System.out.println(data) ;
          
          
          String text = "";
          BufferedReader reader=null;

          // Send data 
        try
        { 
          
            // Defined URL  where to send data
           URL url = new URL(u);
             
         // Send POST data request

          URLConnection conn = url.openConnection(); 
          conn.setDoOutput(true); 
          OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream()); 
          wr.write( data ); 
          wr.flush(); 
      
          // Get the server response 
           
        reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        StringBuilder sb = new StringBuilder();
        String line = null;
        
        // Read Server Response
        while((line = reader.readLine()) != null)
            {
                   // Append server response in string
                   sb.append(line + "\n");
            }
            
            
            text = sb.toString();
        }
        catch(Exception ex)
        {
             
        }
        finally
        {
            try
            {
 
                reader.close();
            }

            catch(Exception ex) {}
        }
              
        // Show response on activity
        //content.setText( text  );
        
    }
 

	
	
	
	public static String POST(String url, String lat, String lon){
        InputStream inputStream = null;
        String result = "";
        try {
 
            // 1. create HttpClient
            HttpClient httpclient = new DefaultHttpClient();
 
            // 2. make POST request to the given URL
            HttpPost httpPost = new HttpPost(url);
 
            String json = "";
 
            // 3. build jsonObject
            JSONObject jsonObject = new JSONObject();
            jsonObject.accumulate("latitude", lat);
            jsonObject.accumulate("longitude", lon);
       
 
            // 4. convert JSONObject to JSON to String
            json = jsonObject.toString();
 
            // ** Alternative way to convert Person object to JSON string usin Jackson Lib 
            // ObjectMapper mapper = new ObjectMapper();
            // json = mapper.writeValueAsString(person); 
 
            // 5. set json to StringEntity
            StringEntity se = new StringEntity(json);
 
            // 6. set httpPost Entity
            httpPost.setEntity(se);
 
            // 7. Set some headers to inform server about the type of the content   
            httpPost.setHeader("Accept", "application/json");
            httpPost.setHeader("Content-type", "application/json");
 
            // 8. Execute POST request to the given URL
            HttpResponse httpResponse = httpclient.execute(httpPost);
 
            // 9. receive response as inputStream
            inputStream = httpResponse.getEntity().getContent();
 
            // 10. convert inputstream to string
            if(inputStream != null)
                result = convertInputStreamToString(inputStream);
            else
                result = "Did not work!";
 
        } catch (Exception e) {
            Log.d("InputStream", e.getLocalizedMessage());
        }
 
        // 11. return result
        return result;
    }
	
    public static String convertInputStreamToString(InputStream inputStream) throws IOException{
        BufferedReader bufferedReader = new BufferedReader( new InputStreamReader(inputStream));
        String line = "";
        String result = "";
        while((line = bufferedReader.readLine()) != null)
            result += line;
 
        inputStream.close();
        return result;
 
    }   
	
	PendingIntent pi;
	
	public void SetAlarm(Context context)
    {
        AlarmManager am=(AlarmManager)context.getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(context, AlarmManagerBroadcastReceiver.class);
        intent.putExtra(ONE_TIME, Boolean.FALSE);
        pi = PendingIntent.getBroadcast(context, 0, intent, 0);
        
        //Toast.makeText(context, "set alarm mai aagaya", Toast.LENGTH_LONG).show();
        //After after 30 seconds
        am.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis(), 1000 * 5 , pi); 
    }

   /* public void CancelAlarm(Context context)
    {
        Intent intent = new Intent(context, AlarmManagerBroadcastReceiver.class);
        PendingIntent sender = PendingIntent.getBroadcast(context, 0, intent, 0);
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        alarmManager.cancel(sender);
    }*/
    
    public void CancelAlarm(Context context)
    {
        Intent intent = new Intent(context, AlarmManagerBroadcastReceiver.class);
        //PendingIntent sender = PendingIntent.getBroadcast(context, 0, intent, 0);
        pi = PendingIntent.getBroadcast(context, 0, intent, 0);
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        alarmManager.cancel(pi);
        Toast.makeText(context, "Cancel", Toast.LENGTH_LONG).show();
    }
    
    public void setOnetimeTimer(Context context){
    	AlarmManager am=(AlarmManager)context.getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(context, AlarmManagerBroadcastReceiver.class);
        intent.putExtra(ONE_TIME, Boolean.TRUE);
        PendingIntent pi = PendingIntent.getBroadcast(context, 0, intent, 0);
        am.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis(), pi);
    }
}
