package com.davissylvester.guidedtourappjava.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.davissylvester.guidedtourappjava.Adapters.AttractionAdapter;
import com.davissylvester.guidedtourappjava.DomainClasses.AttractionData;
import com.davissylvester.guidedtourappjava.DomainClasses.DataService;
import com.davissylvester.guidedtourappjava.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class AttractionList extends Fragment {

    ArrayList<AttractionData> data;
    private RecyclerView mRecycleView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mlayoutManager;


    public AttractionList() {
        // Required empty public constructor
        data = getData();



    }

    private ArrayList<AttractionData> getData() {

        return DataService.getInstance().getData();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_attraction_list, container, false);

        mRecycleView = v.findViewById(R.id.rvAttractionList);

        setDefaults(v);



        return v;
    }

    private void setDefaults(View view) {


        mAdapter = new AttractionAdapter(getContext(), data);

        mlayoutManager = new LinearLayoutManager(getContext());

        mRecycleView.setAdapter(mAdapter);

        mRecycleView.hasFixedSize();

        mRecycleView.setLayoutManager(mlayoutManager);

    }



}
