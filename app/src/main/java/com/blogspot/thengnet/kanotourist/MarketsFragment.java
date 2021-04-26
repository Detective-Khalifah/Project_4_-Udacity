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

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MarketsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MarketsFragment extends Fragment {

    private ArrayList<Site> mMarketsList;

    public MarketsFragment () {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment MarketsFragment.
     */
    public static MarketsFragment newInstance () {
        return new MarketsFragment();
    }

    @Override
    public void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mMarketsList = new ArrayList<>();
        mMarketsList.add(new Site("'Yankaba"));
        mMarketsList.add(new Site("Bachirawa"));
        mMarketsList.add(new Site("Dawanau"));
        mMarketsList.add(new Site("Galadima"));
        mMarketsList.add(new Site("Ƙofar Ruwa"));
        mMarketsList.add(new Site("Kurmi"));
        mMarketsList.add(new Site("Rimi"));
        mMarketsList.add(new Site("Sabon Gari"));
        mMarketsList.add(new Site("Ujile"));
        mMarketsList.add(new Site("Wafa"));
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
        final ListView listView = view.findViewById(R.id.list_sites);
        listView.setAdapter(new SiteAdapter(getContext(), mMarketsList));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick (AdapterView<?> parent, View view, int position, long id) {
                Site theSite = mMarketsList.get(position);
                Intent immerse = new Intent(getActivity(), ImmersiveViewerActivity.class);
                immerse.putExtra("SUMMARY", theSite.getSiteSummary()); // always available

                if (theSite.hasImage())
                    immerse.putExtra("IMG", theSite.getImageResourceId());
                if (theSite.hasLink())
                    immerse.putExtra("LINK", mMarketsList.get(position).getSiteLink());
                startActivity(immerse);
            }
        });
    }
}