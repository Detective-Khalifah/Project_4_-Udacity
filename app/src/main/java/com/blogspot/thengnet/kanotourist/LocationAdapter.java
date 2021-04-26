package com.blogspot.thengnet.kanotourist;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class LocationAdapter extends FragmentPagerAdapter {

    private Context mContext;

    public LocationAdapter (FragmentManager fm, Context theContext) {
        super(fm);
        mContext = theContext;
    }

    @Override
    public int getCount () {
        return 6;
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
                return RestaurantsFragment.newInstance();
            case 4:
                return MarketsFragment.newInstance();
            case 5:
                return EventsFragment.newInstance();
            default:
                return null;
        }
    }

    @Override
    public CharSequence getPageTitle (int position) {
        switch (position) {
            case 0:
                return mContext.getString(R.string.fragment_gates);
            case 1:
                return mContext.getString(R.string.fragment_historicals);
            case 2:
                return mContext.getString(R.string.fragment_hotels);
            case 3:
                return mContext.getString(R.string.fragment_restaurants);
            case 4:
                return mContext.getString(R.string.fragment_markets);
            case 5:
                return mContext.getString(R.string.fragment_events);
            default:
                return super.getPageTitle(position);
        }
    }
}
