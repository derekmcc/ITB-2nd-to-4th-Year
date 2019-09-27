package com.example.derek.assignment1;

/**
 * RSS object class to create RSS objects
 */
public class RssItems {

    //global scope variables
    private String title;
    private String link;
    private String description;
    private String publishedDate;
    private String thumbnailUrl;

    /**
     * Get the title of the rss feed
     * @return The title of the rss feed
     */
    public String getTitle() {
        //return the title
        return title;
    }//end getTitle

    /**
     * Set the title of the rss feed
     * @param title
     */
    public void setTitle(String title) {
        //assign the passed title to the global title
        this.title = title;
    }//end setTitle

    /**
     * Get the url link of the rss feed
     * @return The url link of the rss feed
     */
    public String getLink() {
        //return the url link
        return link;
    }//end getLink

    /**
     * Set the url link of the rss feed
     * @param link
     */
    public void setLink(String link) {
        //assign the passed url link to the global url link
        this.link = link;
    }//end setLink

    /**
     * Get the description of the rss feed
     * @return The description of the rss feed
     */
    public String getDescription() {
        //return the description
        return description;
    }//end getDescription

    /**
     * Set the description of the rss feed
     * @param description String variable to hold the description
     */
    public void setDescription(String description) {
        //assign the passed description to the global description
        this.description = description;
    }//end setDescription

    /**
     * Get the date of the rss feed
     * @return The date of the rss feed
     */
    public String getPublishedDate() {
        //return the date
        return publishedDate;
    }//end getDate

    /**
     * Set the date of the rss feed
     * @param publishedDate String variable to hold the date
     */
    public void setPublishedDate(String publishedDate) {
        //assign the passed date to the global date
        this.publishedDate = publishedDate;
    }//end setDate

    /**
     * Get the image of the rss feed
     * @return The image Url
     */
    public String getThumbnailUrl() {
        //return the image url
        return thumbnailUrl;
    }//end getThumbnailUrl

    /**
     * Set the image of the rss feed
     * @param thumbnailUrl String variable to hold the image Url
     */
    public void setThumbnailUrl(String thumbnailUrl) {
        //assign the passed image url to the global image url
        this.thumbnailUrl = thumbnailUrl;
    }//end setThumbnailUrl
}//emd class
