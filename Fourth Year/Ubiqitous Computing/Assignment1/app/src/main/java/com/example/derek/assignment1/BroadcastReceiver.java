package com.example.derek.assignment1;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Vibrator;
import android.util.Log;
import android.widget.Toast;

import java.util.Calendar;

public class BroadcastReceiver extends android.content.BroadcastReceiver {
    //interval time of 1 minute
    private static final int EXEC_INTERVAL = 60 * 1000;

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d("BR101","SER Broadcast");
        //get the url from the intent
        String uri = intent.getStringExtra("uri");
        Log.d("BR101"," URL = " + uri);
        //create an alarm
        AlarmManager alarmManager = (AlarmManager) context
                .getSystemService(Context.ALARM_SERVICE);
        //initialise intent
        Intent i = new Intent(context, SchedulerEventReceiver.class);
        //add the url and flag to the intent
        intent.putExtra("uri",uri);
        intent.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
        //create a pending intent
        PendingIntent intentExecuted = PendingIntent.getBroadcast(context, 1, i,
                PendingIntent.FLAG_UPDATE_CURRENT);
        //get the time
        Calendar now = Calendar.getInstance();
        //add 2 seconds to the time
        now.add(Calendar.SECOND, 2);
        //start a repeating alarm
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,
                now.getTimeInMillis(), EXEC_INTERVAL, intentExecuted);
    }//end onRecieve
}//end class
