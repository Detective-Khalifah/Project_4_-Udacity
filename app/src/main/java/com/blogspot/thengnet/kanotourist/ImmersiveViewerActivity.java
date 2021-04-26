package com.blogspot.thengnet.kanotourist;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ImmersiveViewerActivity extends AppCompatActivity {

    private int mSiteImage;
    private String mSiteLink;
    private String mSiteSummary;

    private ImageView siteImage;
    private TextView siteLink, siteSummary;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_immersive_viewer);

        Intent site = getIntent();
        if (site != null) {
            Bundle data = site.getExtras();
            mSiteSummary = data.getString("SUMMARY");
            mSiteLink = data.getString("LINK");
            mSiteImage = data.getInt("IMG");

            siteSummary = (TextView) findViewById(R.id.site_summary);
            siteSummary.setText(mSiteSummary);

            if (mSiteLink != null) {
                siteLink = (TextView) findViewById(R.id.site_link);
                siteLink.setText(mSiteLink);
                siteLink.setVisibility(View.VISIBLE);
                siteLink.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick (View v) {
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(mSiteLink)));
                    }
                });
            }

            if (mSiteImage > 0) {
                siteImage = (ImageView) findViewById(R.id.site_image);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
                    siteImage.setImageDrawable(getDrawable(mSiteImage));
                siteImage.setVisibility(View.VISIBLE);
            }
        }
    }
}