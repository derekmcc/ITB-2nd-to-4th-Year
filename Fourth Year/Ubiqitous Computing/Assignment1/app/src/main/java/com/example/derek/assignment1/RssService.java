package com.example.derek.assignment1;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.util.Log;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;


public class RssService extends Service {
    //global scope variables
    Context context;
    Handler handler;
    String address = "http://feeds.skynews.com/feeds/rss/home.xml";
    String concatDates="";
    URL url;
    private boolean isRunning;

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if(!this.isRunning) {
            this.isRunning = true;
            Log.d("RssService","StartCommand");
            //get the Intent that started this activity
            String aaddress = intent.getStringExtra("uri");
            Log.d("RssService","Address = " + aaddress);
            RssServiceThread t = new RssServiceThread(this,intent, this);
            t.start();
        }
        return Service.START_STICKY;
    }

    @Override
    public void onDestroy() {
        this.isRunning = false;
    }

    public class RssServiceThread extends Thread {
        Service service;
        Intent intent;
        Context context;
        Handler handler;

        public RssServiceThread(Service service, Intent intent, Context context) {
            this.service = service;
            this.intent = intent;
            this.context = context;
        }

        public void run() {
            doInBackgroun();
        }//end run

        private void runOnUiThread(Runnable runnable) {
            handler.post(runnable);
        }

        //This method will execute in background so in this method download rss feeds
        protected Void doInBackgroun() {
            Log.d("RssService", "Do in background");
            try {
                url = new URL(address);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
                InputStream inputStream = connection.getInputStream();
                DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder builder = builderFactory.newDocumentBuilder();
                Document xmlDoc = builder.parse(inputStream);
                ProcessXml(xmlDoc);

            } catch (Exception e) {
                e.printStackTrace();
               // return null;
            }
            //call process xml method to process document we downloaded from getData() method
            return null;
        }
        // In this method we will process Rss feed  document we downloaded to parse useful information from it
        private void ProcessXml(Document data) {
            int counter = 0;
            Log.d("Ras", "Process XML");
            if (data != null) {
                Element root = data.getDocumentElement();
                Node channel = root.getChildNodes().item(1);
                NodeList items = channel.getChildNodes();
                for (int i = 0; i < items.getLength(); i++) {
                    Node cureentchild = items.item(i);
                    if (cureentchild.getNodeName().equalsIgnoreCase("item")) {
                        RssItems item = new RssItems();
                        NodeList itemchilds = cureentchild.getChildNodes();
                        for (int j = 0; j < itemchilds.getLength(); j++) {
                            Node cureent = itemchilds.item(j);
                            if (cureent.getNodeName().equalsIgnoreCase("title")) {
                                item.setTitle(cureent.getTextContent());
                            } else if (cureent.getNodeName().equalsIgnoreCase("description")) {
                                item.setDescription(cureent.getTextContent());
                            } else if (cureent.getNodeName().equalsIgnoreCase("pubDate")) {
                                item.setPublishedDate(cureent.getTextContent());
                                //counter to get the most recent date
                                if (counter == 0) {
                                    //get the date
                                    concatDates = cureent.getTextContent();
                                }//end if
                                counter++;
                            } else if (cureent.getNodeName().equalsIgnoreCase("link")) {
                                item.setLink(cureent.getTextContent());
                            } else if (cureent.getNodeName().equalsIgnoreCase("media:thumbnail")) {
                                //this will return us thumbnail url
                                String url = cureent.getAttributes().item(0).getTextContent();
                                item.setThumbnailUrl(url);
                            }//end else if
                        }//end for
                    }//end if
                }//end for
            }//end if
            Log.d("Ras", "Before Write to file");
            writeToFile(concatDates,context);
        }

        private void writeToFile(String data,Context context) {
            try {
                Log.d("Ras", "File write done: ");
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(context.openFileOutput("date2.txt", Context.MODE_PRIVATE));
                outputStreamWriter.write(data);
                outputStreamWriter.close();
            }
            catch (IOException e) {
                Log.e("Exception", "File write failed: " + e.toString());
            }
            checkTimeStamps();
        }
        public String readFiles(String fileName){
            String date = "";
            try {
                InputStream inputStream = context.openFileInput(fileName);

                if ( inputStream != null ) {
                    InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                    BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                    String receiveString = "";
                    StringBuilder stringBuilder = new StringBuilder();

                    while ( (receiveString = bufferedReader.readLine()) != null ) {
                        stringBuilder.append(receiveString);
                    }

                    inputStream.close();
                    date = stringBuilder.toString();
                }
            }
            catch (FileNotFoundException e) {
                Log.e("Exception", "File not found: " + e.toString());
            } catch (IOException e) {
                Log.e("Exception", "Can not read file: " + e.toString());
            }
            Log.d("RssService","Date = " + date);
            return date;
        }
        public void checkTimeStamps(){
            String date1 = readFiles("date1.txt");
            String date2 = readFiles("date2.txt");
            if (!date1.matches(date2)){
                Notification.Builder builder = new Notification.Builder(context)
                                .setSmallIcon(R.drawable.icon)
                                .setContentTitle("RSS Reader")
                                .setContentText("New Feed");
                Notification notification = builder.build();
                int NOTIFICATION_ID = 12345;

                Intent targetIntent = new Intent(context, RSSActivity.class);
                PendingIntent contentIntent = PendingIntent.getActivity(context, 0, targetIntent, PendingIntent.FLAG_UPDATE_CURRENT);
                builder.setContentIntent(contentIntent);
                NotificationManager nManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                assert nManager != null;
                nManager.notify(NOTIFICATION_ID, notification);
            }
        }
    }//inner class
}//end outer class
