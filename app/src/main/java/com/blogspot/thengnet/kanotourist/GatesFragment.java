package com.blogspot.thengnet.kanotourist;

import android.content.Intent;
import android.net.Uri;
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
 * Use the {@link GatesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GatesFragment extends Fragment {

    private ArrayList<Site> mGateSites;

    public GatesFragment () {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment GatesFragment.
     */
    public static GatesFragment newInstance () {
        return new GatesFragment();
    }

    @Override
    public void onCreate (Bundle savedInstanceState) {
        mGateSites = new ArrayList<>();
        mGateSites.add(new Site(getString(R.string.gate_1), R.drawable.kofar_kansakali_1,
                getString(R.string.gate_1_link)));
        mGateSites.add(new Site(getString(R.string.gate_2), getString(R.string.gate_2_link)));
        mGateSites.add(new Site(getString(R.string.gate_3), R.drawable.kofar_dawanau_3,
                getString(R.string.gate_3_link)));
        mGateSites.add(new Site(getString(R.string.gate_4), R.drawable.kofar_ruwa_4,
                getString(R.string.gate_4_link)));
        mGateSites.add(new Site(getString(R.string.gate_5), R.drawable.kofar_mazugal_5,
                getString(R.string.gate_5_link)));
        mGateSites.add(new Site(getString(R.string.gate_6), R.drawable.kofar_wambai_6,
                getString(R.string.gate_6_link)));
        mGateSites.add(new Site(getString(R.string.gate_7), R.drawable.kofar_mata_7,
                getString(R.string.gate_7_link)));
        mGateSites.add(new Site(getString(R.string.gate_8), R.drawable.kofar_dan_agundi_8_partially_collapsed,
                getString(R.string.gate_8_link)));
        mGateSites.add(new Site(getString(R.string.gate_9), R.drawable.kofar_nasarawa_9,
                getString(R.string.gate_9_link)));
        mGateSites.add(new Site(getString(R.string.gate_10), R.drawable.kofar_naisa_10,
                getString(R.string.gate_10_link)));
        mGateSites.add(new Site(getString(R.string.gate_11), R.drawable.kofar_gadon_kaya_11,
                getString(R.string.gate_11_link)));
        mGateSites.add(new Site(getString(R.string.gate_12), R.drawable.kanokdukawuya_12,
                getString(R.string.gate_12_link)));
        mGateSites.add(new Site(getString(R.string.gate_13), R.drawable.kanokkabuga_13,
                getString(R.string.gate_13_link)));
        mGateSites.add(new Site(getString(R.string.gate_14), R.drawable.kanokfamfo_14,
                getString(R.string.gate_14_link)));
        mGateSites.add(new Site(getString(R.string.gate_15), R.drawable.sabuwar_kofa_15,
                getString(R.string.gate_15_link)));
        mGateSites.add(new Site(getString(R.string.gate_16), getString(R.string.gate_16_link)));
        mGateSites.add(new Site(getString(R.string.gate_17), R.drawable.kofar_fada_17));

        super.onCreate(savedInstanceState);
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

        TextView txtGatesIntro = (TextView) view.findViewById(R.id.location_intro);
        txtGatesIntro.setText(getString(R.string.gates_intro));

        final TextView txtGatesInfo = (TextView) view.findViewById(R.id.location_info);
        txtGatesInfo.setText(getString(R.string.gates_further_read));
        txtGatesInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.gates_link))));
            }
        });

        final ListView listView = view.findViewById(R.id.list_gates);
        listView.setAdapter(new SiteAdapter(getContext(), mGateSites));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick (AdapterView<?> parent, View view, int position, long id) {
                Site theSite = mGateSites.get(position);
                Intent immerse = new Intent(getActivity(), ImmersiveViewerActivity.class);
                immerse.putExtra("SUMMARY", theSite.getSiteSummary()); // always available

                if (theSite.hasImage())
                    immerse.putExtra("IMG", theSite.getImageResourceId());
                if (theSite.hasLink())
                    immerse.putExtra("LINK", mGateSites.get(position).getSiteLink());
                startActivity(immerse);
            }
        });
    }
}