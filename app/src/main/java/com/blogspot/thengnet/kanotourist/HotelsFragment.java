package com.blogspot.thengnet.kanotourist;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HotelsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HotelsFragment extends Fragment {

    public HotelsFragment () {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment HotelsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HotelsFragment newInstance () {
        return new HotelsFragment();
    }

    @Override
    public void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container,
                              Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_hotels, container, false);
    }
}