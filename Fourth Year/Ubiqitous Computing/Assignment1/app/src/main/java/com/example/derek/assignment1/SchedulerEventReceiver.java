package com.example.derek.assignment1;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class SchedulerEventReceiver extends android.content.BroadcastReceiver {

    /*
     * Calls the rss service class
     */
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d("SER101","SER Broadcast");
        //get the url from the intent
        String uri = intent.getStringExtra("uri");
        Log.d("SER101","URL = " + uri);
        //create an intent
        Intent eventService = new Intent(context, RssService.class);
        //add the url to the intent
        eventService.putExtra("uri",uri);
        //start the service
        context.startService(eventService);
    }//end onReceieve
}//end class
