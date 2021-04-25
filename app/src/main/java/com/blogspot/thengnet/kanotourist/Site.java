package com.blogspot.thengnet.kanotourist;

public class Site {

    private String mSiteName;
    private int mImageResourceId;

    public Site (String mSiteName, int mImageResourceId) {
        this.mSiteName = mSiteName;
        this.mImageResourceId = mImageResourceId;
    }

    public Site setSiteName (String mSiteName) {
        this.mSiteName = mSiteName;
        return this;
    }

    public Site setImageResourceId (int mImageResourceId) {
        this.mImageResourceId = mImageResourceId;
        return this;
    }
}