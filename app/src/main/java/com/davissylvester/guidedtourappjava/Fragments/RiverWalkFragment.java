package com.davissylvester.guidedtourappjava.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.davissylvester.guidedtourappjava.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class RiverWalkFragment extends Fragment {


    public RiverWalkFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_river_walk, container, false);
    }

}
