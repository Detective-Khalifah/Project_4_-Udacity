package com.blogspot.thengnet.kanotourist;

public class Site {

    private String mSiteSummary;
    private int mImageResourceId;

    public Site (String mSiteSummary, int mImageResourceId) {
        this.mSiteSummary = mSiteSummary;
        this.mImageResourceId = mImageResourceId;
    }

    public String getmSiteSummary () {
        return mSiteSummary;
    }

    public int getmImageResourceId () {
        return mImageResourceId;
    }
}