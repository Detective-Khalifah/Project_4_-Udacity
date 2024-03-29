package com.blogspot.thengnet.kanotourist;

import android.content.Intent;
import android.os.Bundle;
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
 * Use the {@link HotelsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HotelsFragment extends Fragment {

    private ArrayList<Site> mHotelsList;

    public HotelsFragment () {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment HotelsFragment.
     */
    public static HotelsFragment newInstance () {
        return new HotelsFragment();
    }

    @Override
    public void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mHotelsList = new ArrayList<>();
        mHotelsList.add(new Site(getString(R.string.hotel_1)));
        mHotelsList.add(new Site(getString(R.string.hotel_2)));
        mHotelsList.add(new Site(getString(R.string.hotel_3)));
        mHotelsList.add(new Site(getString(R.string.hotel_4)));
        mHotelsList.add(new Site(getString(R.string.hotel_5)));
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

        TextView txtHotelsIntro = (TextView) view.findViewById(R.id.location_intro);
        txtHotelsIntro.setText(getString(R.string.hotels_intro));

        final ListView listView = view.findViewById(R.id.list_sites);
        listView.setAdapter(new SiteAdapter(getContext(), mHotelsList));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick (AdapterView<?> parent, View view, int position, long id) {
                Site theSite = mHotelsList.get(position);
                Intent immerse = new Intent(getActivity(), ImmersiveViewerActivity.class);
                immerse.putExtra("SUMMARY", theSite.getSiteSummary()); // always available

                if (theSite.hasImage())
                    immerse.putExtra("IMG", theSite.getImageResourceId());
                if (theSite.hasLink())
                    immerse.putExtra("LINK", mHotelsList.get(position).getSiteLink());
                startActivity(immerse);
            }
        });
    }
}