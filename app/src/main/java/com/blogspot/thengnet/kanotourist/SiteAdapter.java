package com.blogspot.thengnet.kanotourist;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class SiteAdapter extends FragmentPagerAdapter {

    private Context mContext;

    public SiteAdapter (FragmentManager fm, Context theContext) {
        super(fm);
        mContext = theContext;
    }

    @Override
    public Fragment getItem (int i) {
        switch (i) {
            case 0:
                return GatesFragment.newInstance();
            case 1:
                return HistoricalsFragment.newInstance();
            case 2:
                return HotelsFragment.newInstance();
            case 3:
                return SupermarketsFragment.newInstance();
            default:
                return null;
        }
    }

    @Override
    public int getCount () {
        return 4;
    }
}
