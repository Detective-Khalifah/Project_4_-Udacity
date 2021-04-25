package com.blogspot.thengnet.kanotourist;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

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
        mGateSites.add(new Site("Kofar Nassarawa", R.drawable.kofar_nasarawa_2));
        mGateSites.add(new Site("Kofar Rumfa", R.drawable.kofar_rumfa_or_fada_3));
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container,
                              Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_gates, container, false);
    }

    @Override
    public void onViewCreated (View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ListView listView = view.findViewById(R.id.list_gates);
        listView.setAdapter(new SiteAdapter(getContext(), mGateSites));
    }
}