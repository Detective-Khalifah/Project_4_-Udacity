package com.blogspot.thengnet.kanotourist;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RestaurantsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RestaurantsFragment extends Fragment {

    private ArrayList<Site> mRestaurantsList;

    public RestaurantsFragment () {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment RestaurantsFragment.
     */
    public static RestaurantsFragment newInstance () {
        return new RestaurantsFragment();
    }

    @Override
    public void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mRestaurantsList = new ArrayList<>();
        mRestaurantsList.add(new Site(getString(R.string.restaurant_1)));
        mRestaurantsList.add(new Site(getString(R.string.restaurant_2)));
        mRestaurantsList.add(new Site(getString(R.string.restaurant_3)));
        mRestaurantsList.add(new Site(getString(R.string.restaurant_4)));
        mRestaurantsList.add(new Site(getString(R.string.restaurant_5)));

    }

    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container,
                              Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.site_listview, container, false);
    }

    @Override
    public void onViewCreated (View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView txtRestaurantsIntro = (TextView) view.findViewById(R.id.location_intro);
        txtRestaurantsIntro.setText(getString(R.string.restaurants_intro));

        final ListView listView = view.findViewById(R.id.list_sites);
        listView.setAdapter(new SiteAdapter(getContext(), mRestaurantsList));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick (AdapterView<?> parent, View view, int position, long id) {
                Site theSite = mRestaurantsList.get(position);
                Intent immerse = new Intent(getActivity(), ImmersiveViewerActivity.class);
                immerse.putExtra("SUMMARY", theSite.getSiteSummary()); // always available

                if (theSite.hasImage())
                    immerse.putExtra("IMG", theSite.getImageResourceId());
                if (theSite.hasLink())
                    immerse.putExtra("LINK", mRestaurantsList.get(position).getSiteLink());
                startActivity(immerse);
            }
        });
    }
}