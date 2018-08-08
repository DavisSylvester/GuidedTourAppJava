package com.davissylvester.guidedtourappjava.DomainClasses;

import android.content.Context;

import com.davissylvester.guidedtourappjava.R;

import java.util.ArrayList;
import java.util.jar.Attributes;


public class DataService {

    private Context context;

    public DataService(Context ctx) {
        context = ctx;

        this.Data = new ArrayList<>();

        loadData();

    }

    public ArrayList<AttractionData> getData() {
        return Data;
    }

    ArrayList<AttractionData> Data;

    private void loadData() {



        Data.add(new AttractionData(ApplicationConstants.WILDLIFE_RANCH,
                context.getString(R.string.wildlife_address),
                context.getString(R.string.wildlife_desc),
                context.getString(R.string.wildlid_price),
                "witte_museum"));

        Data.add(new AttractionData(ApplicationConstants.RIVERWALK,
                context.getString(R.string.riverwalk_address),
                context.getString(R.string.riverwalk_desc),
                context.getString(R.string.riverwalk_price),
                "riverwalk"));

        Data.add(new AttractionData(ApplicationConstants.ALAMO,
                context.getString(R.string.alamo_address),
                context.getString(R.string.alamo_desc),
                context.getString(R.string.alamo_price),
                "alamo"));

        Data.add(new AttractionData(ApplicationConstants.RIPLEY,
                context.getString(R.string.riplpey_address),
                context.getString(R.string.ripley_desc),
                context.getString(R.string.ripley_price),
                "ripleys_museum"));


    }
}
