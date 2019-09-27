package com.example.derek.assignment1;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Calendar;

public class RSSActivity extends MainActivity {

    //log tag
    private static final String TAG = "RSSActivity";

    //variable to hold defined key of intent
    public static final String EXTRA_MESSAGE = "RssActivity";

    //global scope variables and components
    ListView listView;
    ArrayList<RssItems> rssItems;
    String address;
    String time;
    RssReader readRss,readRss1;

    /**
     * initialise the rss activity
     * @param savedInstanceState Reference to the object passed into the onCreate
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rss);

        //toolbar for returning to the parent activity
        Toolbar myChildToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        //add the toolbar to the supported action bar
        setSupportActionBar(myChildToolbar);

        //get a support ActionBar corresponding to this toolbar
        ActionBar ab = getSupportActionBar();

        //assume ab is not null
        assert ab != null;
        //enable the Up button
        ab.setDisplayHomeAsUpEnabled(true);

        //get the Intent that started this activity
        Intent intent = getIntent();

        //extract the string from the intent
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        //placeholder to hold the extracted string data
        address = message;

        //assign the list view component to a variable list view
        listView = findViewById(R.id.rssListView);

        rssItems = new ArrayList<RssItems>();//DOUBL CHECK IF NEEDED-------------------------------------------

        //create an instance of the rss reader class
        readRss = new RssReader(this,listView, address);

        //start the rss class
        readRss.execute();
    }//end on create

    /**
     * Responds to menu clicks
     * @param item The selected item from the tool bar
     * @return To the parent activity or the same activity
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            //respond to the action bar's Up/Home button
            case android.R.id.home:
                //navigate up from this activity
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }//end switch case
        return super.onOptionsItemSelected(item);
    }//end onOptionsItemSelected

    /**
     * Method to run backgroud services
     * Does'nt work fully
     */
    public void onPause() {
        super.onPause();
        //create an intent
//        Intent intent = new Intent(this, BroadcastReceiver.class);
//        //add the url to the intent
//        intent.putExtra("uri",address);
//        intent.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
//        //create an alarm service
//        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
//        //initalise the pending intent
//        PendingIntent pendingIntent = PendingIntent.getBroadcast(
//                this.getApplicationContext(), 1, intent,  PendingIntent.FLAG_UPDATE_CURRENT);
//        //get the current date
//        Calendar calendar = Calendar.getInstance();
//        //set the time
//        calendar.setTimeInMillis(System.currentTimeMillis());
//        //assertion
//        assert alarmManager != null;
//        //set the repeating alarm
//        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),
//                1000 * 60 * 10, pendingIntent);
    }//end onPause
}//end class