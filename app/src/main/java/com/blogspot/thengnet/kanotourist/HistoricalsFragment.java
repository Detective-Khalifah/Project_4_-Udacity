package com.blogspot.thengnet.kanotourist;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HistoricalsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HistoricalsFragment extends Fragment {

    public HistoricalsFragment () {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment HistoricalsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HistoricalsFragment newInstance () {
        return new HistoricalsFragment();
    }

    @Override
    public void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container,
                              Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_historical, container, false);
    }
}