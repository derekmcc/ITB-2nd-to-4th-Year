package com.example.derek.assignment1;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.cache.memory.impl.WeakMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;

import java.util.ArrayList;

/**
 * Adapter class to create a custom list view
 */
public class RssListAdapter extends ArrayAdapter<RssItems> {

    //log tag
    private static final String TAG = "RssListAdapter";

    //global scope variables and components
    private Context mContext;
    private int mResource;
    private int lastPostiion = -1;
    private ArrayList<RssItems> rssItems;

    /**
     * Constructor to initialise components
     * @param mContext Represents environment data
     * @param textViewResourceId ID of the text view resource
     * @param items Array list of Rss Items
     */
    public RssListAdapter(Context mContext, int textViewResourceId, ArrayList items) {
        super(mContext, textViewResourceId, items);
        //initialise components
        this.mContext = mContext;
        this.mResource = textViewResourceId;
    }//end clonstructor

    /**
     * holds variables in a View
     */
    private static class ViewHolder {
        //components that's part of the view
        TextView title;
        TextView description;
        TextView date;
        ImageView image;
    }//end viewHolder

    /**
     * Displays the data at the specified position in the array list
     * @param position The current items position in the array list
     * @param convertView Basic building block of interface
     * @param parent Container to hold Views
     * @return View object
     */
    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //sets up the image loader library
        setupImageLoader();

        //get the rss information
        String title = getItem(position).getTitle();
        String description = getItem(position).getDescription();
        String date = getItem(position).getPublishedDate();
        String imgUrl = getItem(position).getThumbnailUrl();

        //create the view result
        final View result;

        //viewHolder object
        ViewHolder holder;

        //check to see if the view is null
        if(convertView == null){
            //create a layout inflater and instantiate the layout view
            LayoutInflater inflater = LayoutInflater.from(mContext);
            convertView = inflater.inflate(mResource, parent, false);

            //create a new holder to hold the components in the views
            holder= new ViewHolder();

            //add the components to the holder
            holder.title = (TextView) convertView.findViewById(R.id.title_text);
            holder.description = (TextView) convertView.findViewById(R.id.description_text);
            holder.date = (TextView) convertView.findViewById(R.id.date_text);
            holder.image = (ImageView) convertView.findViewById(R.id.thumb_img);

            //-----------------------------------------------------
            result = convertView;
            //-----------------------------------------------------CHECK IF STILLUSING--------

            //add the holder to the layout inflater
            convertView.setTag(holder);
        }//end if

        //else if the view is not null
        else{
            //get the view and assign it to the view holder
            holder = (ViewHolder) convertView.getTag();
            //-------------------------------------------CHECK IF STILL USING
            result = convertView;
            //-------------------------------------------CHECK IF STILL USING
        }//end else

        //set the title of the view holder from the rss title
        holder.title.setText(title);
        //set the description of the view holder from the rss description
        holder.description.setText(description);
        //set the date of the view holder from thr rss pubDate
        holder.date.setText(date);
        //create the image loader object to reduce rendering time of images
        ImageLoader imageLoader = ImageLoader.getInstance();

        //create a default image for rss feeds that dont contain images
        int defaultImage = mContext.getResources().getIdentifier("@drawable/ic_action_name",null,mContext.getPackageName());

        //create display options for the image loader
        DisplayImageOptions options = new DisplayImageOptions.Builder().cacheInMemory(true)
                //add the image to the memory cache
                .cacheOnDisc(true).resetViewBeforeLoading(true)
                //set default image for rss feeds without an image
                .showImageForEmptyUri(defaultImage)
                //set default image for rss feeds if the image fails to load
                .showImageOnFail(defaultImage)
                //set the image from the rss feed
                .showImageOnLoading(defaultImage).build();

        //download and display image from url
        imageLoader.displayImage(imgUrl, holder.image, options);

        //return the view
        return convertView;
    }//end getView

    /**
     * Required for setting up the Universal Image loader Library
     */
    private void setupImageLoader(){
        //create display options for the image loader
        DisplayImageOptions defaultOptions = new DisplayImageOptions.Builder()
                //add the image to the memory cache
                .cacheOnDisc(true).cacheInMemory(true)
                //scale the image to the image view size
                .imageScaleType(ImageScaleType.EXACTLY)
                //add a fade animation to images in the rss feed
                .displayer(new FadeInBitmapDisplayer(300)).build();
        //create and set the configuration for the image loader
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(
                mContext)
                //set the display image to the to that of the display options image
                .defaultDisplayImageOptions(defaultOptions)
                //use a weak reference to store the bitmap in memory
                .memoryCache(new WeakMemoryCache())
                //set the size of image cache
                .discCacheSize(100 * 1024 * 1024).build();
        //get an instance of the image loader
        ImageLoader.getInstance().init(config);
    }//end setupImageLoader
}//end class
