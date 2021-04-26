package com.blogspot.thengnet.kanotourist;

public class Site {

    private String mSiteSummary;
    private String mSiteLink;
    private int mImageResourceId = -1;

    public Site (String mSiteSummary) {
        this.mSiteSummary = mSiteSummary;
    }

    /**
     * For tourist sites with @param mSiteSummary & @param mImageResourceId only.
     */
    public Site (String mSiteSummary, int mImageResourceId) {
        this.mSiteSummary = mSiteSummary;
        this.mImageResourceId = mImageResourceId;
    }

    /**
     * For tourist sites with @param mSiteSummary, @param mImageResourceId and @param mSiteLink.
     */
    public Site (String mSiteSummary, int mImageResourceId, String mSiteLink) {
        this.mSiteSummary = mSiteSummary;
        this.mSiteLink = mSiteLink;
        this.mImageResourceId = mImageResourceId;
    }

    /**
     * For tourist sites with @param siteSummary & @param siteLink only.
     */
    public Site (String siteSummary, String siteLink) {
        mSiteSummary = siteSummary;
        mSiteLink = siteLink;
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
        return (mSiteLink == null ? false : true);
    }
}