package com.example.derek.assignment1;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class RssReader extends AsyncTask<Void, Void, Void> {

    //global scope variable
    private static final String TAG = "RssReader";
    Context mContext;
    String address = "";
    ProgressDialog progressDialog;
    ArrayList<RssItems> rssItems;
    ListView listView;
    URL url;
    RssItems currentItem;
    public String timestamp;

    /*
     * Constructor
     */
    public RssReader(Context mContext, ListView listView, String address) {
        Log.d(TAG,"Onpost Execute: List view Id : " + listView.getId());
        this.listView = listView;
        this.mContext = mContext;
        this.address = address;
        //create a loading dialog
        progressDialog = new ProgressDialog(mContext);
        progressDialog.setMessage("Loading...");
    }//end constructor

    /*
     * Constructor
     */
    public RssReader(Context mContext, String address) {
        this.address = address;
        this.mContext = mContext;
        //start the parsing of the xml
        doInBackground();
    }//end constructor

    //before fetching of rss starts show progress to user
    @Override
    protected void onPreExecute() {
        progressDialog.show();
        super.onPreExecute();
    }//end onPreExecute

    //this method will execute in background so in this method download rss feeds
    @Override
    protected Void doInBackground(Void... params) {
        try {
            //url of rss feed
            url = new URL(address);
            //create a connection to the feed
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            InputStream inputStream = connection.getInputStream();
            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = builderFactory.newDocumentBuilder();
            Document xmlDoc = builder.parse(inputStream);
            //parse the xml
            ProcessXml(xmlDoc);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }//end catch
        //call process xml method to process document we downloaded from getData() method
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        //remove the loading dialog
        progressDialog.dismiss();
        //create an adapter for the list view
        RssListAdapter adapter = new RssListAdapter(mContext, R.layout.list_line_view, rssItems);
        Log.d(TAG,"On post Execute: List view Id : " + listView);
        Log.d(TAG,"Adapter : " + adapter);
        //add an on click to the list
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d(TAG,"Position ---------------- " + position);
                //get the url from the feed
                Uri uri = Uri.parse(rssItems.get(position).getLink());
                //open the url in the devices browser
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                mContext.startActivity(intent);
            }//end onItemClick
        });
        //set the adapter to the list view
        listView.setAdapter(adapter);
    }//end onPost execute

    //process Rss feed document
    private void ProcessXml(Document data) {
        //if there's data in the feed
        if (data != null) {
            //create an arraylist to hold the items
            rssItems = new ArrayList<>();
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
                        } else if (cureent.getNodeName().equalsIgnoreCase("link")) {
                            item.setLink(cureent.getTextContent());
                        } else if (cureent.getNodeName().equalsIgnoreCase("media:thumbnail")) {
                            //this will return us thumbnail url
                            String url = cureent.getAttributes().item(0).getTextContent();
                            item.setThumbnailUrl(url);
                        }//end else if
                    }//end for
                    rssItems.add(item);
                }//end if
            }//end for
            writeToFile(rssItems.get(0).getPublishedDate(),mContext);
        }//end if
    }//end processXml

    public Document Getdata() {
        try {
            url = new URL(address);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            InputStream inputStream = connection.getInputStream();
            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = builderFactory.newDocumentBuilder();
            Document xmlDoc = builder.parse(inputStream);
            return xmlDoc;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }//end catch
    }//end getData

    /**
     * Write the most recent date to a text file
     * @param data Most recent Date
     * @param context Context
     */
    private void writeToFile(String data,Context context) {
        try {
            Log.d("FileWritten", "File write success");
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(context.openFileOutput("date1.txt", Context.MODE_PRIVATE));
            outputStreamWriter.write(data);
            outputStreamWriter.close();
        }//end try
        catch (IOException e) {
            Log.e("Exception", "File write failed: " + e.toString());
        }//end catch
    }//end writeToFile
}//end class
