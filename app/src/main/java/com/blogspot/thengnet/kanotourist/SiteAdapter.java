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

        TextView txtSummary = (TextView) convertView.findViewById(R.id.txt_summary);
        txtSummary.setText(theSite.getSiteSummary());

        if (theSite.hasImage()) {
            ImageView imgSite = (ImageView) convertView.findViewById(R.id.img_site);
            imgSite.setImageResource(theSite.getImageResourceId());
            imgSite.setVisibility(View.VISIBLE);
        }
        if (theSite.hasLink()) {
            TextView txtLink = (TextView) convertView.findViewById(R.id.txt_link);
            txtLink.setText(theSite.getSiteLink());
            txtLink.setVisibility(View.VISIBLE);
        }

        return convertView;
    }
}