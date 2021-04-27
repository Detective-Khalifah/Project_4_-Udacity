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
 * Use the {@link HistoricalsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HistoricalsFragment extends Fragment {

    private ArrayList<Site> historicSitesList;

    public HistoricalsFragment () {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment HistoricalsFragment.
     */
    public static HistoricalsFragment newInstance () {
        return new HistoricalsFragment();
    }

    @Override
    public void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        historicSitesList = new ArrayList<>();
        historicSitesList.add(new Site(getString(R.string.historic_1)));
        historicSitesList.add(new Site(getString(R.string.historic_2)));
        historicSitesList.add(new Site(getString(R.string.historic_3)));
        historicSitesList.add(new Site(getString(R.string.historic_4)));
        historicSitesList.add(new Site(getString(R.string.historic_5)));
        historicSitesList.add(new Site(getString(R.string.historic_6)));
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

        TextView txtHistoricSitesIntro = (TextView) view.findViewById(R.id.location_intro);
        txtHistoricSitesIntro.setText(getString(R.string.historicals_intro));

        final ListView listView = view.findViewById(R.id.list_sites);
        listView.setAdapter(new SiteAdapter(getContext(), historicSitesList));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick (AdapterView<?> parent, View view, int position, long id) {
                Site theSite = historicSitesList.get(position);
                Intent immerse = new Intent(getActivity(), ImmersiveViewerActivity.class);
                immerse.putExtra("SUMMARY", theSite.getSiteSummary()); // always available

                if (theSite.hasImage())
                    immerse.putExtra("IMG", theSite.getImageResourceId());
                if (theSite.hasLink())
                    immerse.putExtra("LINK", historicSitesList.get(position).getSiteLink());
                startActivity(immerse);
            }
        });
    }
}