package com.davissylvester.guidedtourappjava.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.davissylvester.guidedtourappjava.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SanAntonioFragment extends Fragment {



    public SanAntonioFragment() {


    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_san_antonio, container, false);
    }

    public void showAttractions(View view) {

    Log.d("HELP", "showAttractions");
       //  startFragment(new AttractionList());
    }





}
