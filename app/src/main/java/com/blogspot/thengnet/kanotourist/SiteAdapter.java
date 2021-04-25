package com.blogspot.thengnet.kanotourist;

public class SiteAdapter {

    private String mSiteName;
    private int mImageResourceId;

    public SiteAdapter (String mSiteName, int mImageResourceId) {
        this.mSiteName = mSiteName;
        this.mImageResourceId = mImageResourceId;
    }

    public SiteAdapter setSiteName (String mSiteName) {
        this.mSiteName = mSiteName;
        return this;
    }

    public SiteAdapter setImageResourceId (int mImageResourceId) {
        this.mImageResourceId = mImageResourceId;
        return this;
    }
}