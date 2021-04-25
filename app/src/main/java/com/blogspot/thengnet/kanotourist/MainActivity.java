package com.blogspot.thengnet.kanotourist;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SiteAdapter siteAdapter = new SiteAdapter(getSupportFragmentManager(), this);

        ViewPager sitePager = (ViewPager) findViewById(R.id.site_pager);
        sitePager.setAdapter(siteAdapter);

        TabLayout siteTabs = (TabLayout) findViewById(R.id.site_tab);
        siteTabs.setupWithViewPager(sitePager);
    }
}