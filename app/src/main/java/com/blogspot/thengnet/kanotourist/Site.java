package com.blogspot.thengnet.kanotourist;

public class Site {

    private String mSiteSummary;
    private String mSiteLink;
    private int mImageResourceId = -1;

    public Site (String mSiteSummary) {
        this.mSiteSummary = mSiteSummary;
    }

    public Site (String mSiteSummary, int mImageResourceId) {
        this.mSiteSummary = mSiteSummary;
        this.mImageResourceId = mImageResourceId;
    }

    public Site (String mSiteSummary, int mImageResourceId, String mSiteLink) {
        this.mSiteSummary = mSiteSummary;
        this.mSiteLink = mSiteLink;
        this.mImageResourceId = mImageResourceId;
    }

    public String getSiteSummary () {
        return mSiteSummary;
    }

    public String getSiteLink () {
        return mSiteLink;
    }

    public int getImageResourceId () {
        return mImageResourceId;
    }

    public boolean hasImage() {
        return (mImageResourceId != -1 ? true : false );
    }

    public boolean hasLink() {
        return (mSiteLink.equals("") ? false : true);
    }
}