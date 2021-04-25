package com.blogspot.thengnet.kanotourist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class SiteAdapter extends ArrayAdapter<Site> {

    public SiteAdapter (Context context, ArrayList<Site> sites) {
        super(context, 0, sites);
    }

    @Override
    public View getView (int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.site, parent, false);
        }

        Site theSite = getItem(position);
        ImageView imgSite = (ImageView) convertView.findViewById(R.id.img_site);
        TextView txtSummary = (TextView) convertView.findViewById(R.id.txt_summary);

        imgSite.setImageResource(theSite.getmImageResourceId());
        txtSummary.setText(theSite.getmSiteSummary());

        return convertView;
    }
}