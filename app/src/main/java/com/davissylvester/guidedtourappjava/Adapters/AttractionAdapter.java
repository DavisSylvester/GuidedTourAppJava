package com.davissylvester.guidedtourappjava.Adapters;


import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.content.Context;
import android.widget.TextView;

import com.davissylvester.guidedtourappjava.Activities.MainActivity;
import com.davissylvester.guidedtourappjava.DomainClasses.ApplicationConstants;
import com.davissylvester.guidedtourappjava.DomainClasses.AttractionData;
import com.davissylvester.guidedtourappjava.Fragments.AlamoFragment;
import com.davissylvester.guidedtourappjava.Fragments.NaturalFragment;
import com.davissylvester.guidedtourappjava.Fragments.RipleyFragment;
import com.davissylvester.guidedtourappjava.Fragments.RiverWalkFragment;
import com.davissylvester.guidedtourappjava.R;

import java.util.ArrayList;

public class AttractionAdapter extends RecyclerView.Adapter<AttractionAdapter.ViewHolder> {

    private Context context;
    private ArrayList<AttractionData> data;



    public AttractionAdapter(Context ctx, ArrayList<AttractionData> list) {

        context = ctx;
        data = list;


    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(context).inflate(R.layout.attraction_list_item, parent, false);

        ViewHolder vh = new AttractionAdapter.ViewHolder(v);
        return vh;

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.bindItem(data.get(position), context);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView attrName;


        public ViewHolder(View itemView) {
            super(itemView);

            attrName = itemView.findViewById(R.id.txtAttractionName);


        }

        public void bindItem(final AttractionData att, final Context context) {

            attrName.setText("" + att.Name);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    Fragment frag = getSelectedFragment(att.Name);

                    Log.d("HELP", att.Name);
                    // MainActivity ma = new MainActivity();

                    //ma.startFragmentNow(frag);

                    FragmentManager manager = ((AppCompatActivity) context).getSupportFragmentManager();

                    manager.beginTransaction()
                            .replace(R.id.clMainContent, frag)
                            .commit();
                }
            });

        }

        private Fragment getSelectedFragment(String actName) {

            switch(actName) {

                case ApplicationConstants.ALAMO:
                    return new AlamoFragment();

                case ApplicationConstants.RIPLEY:
                    return new RipleyFragment();

                case ApplicationConstants.RIVERWALK:
                    return new RiverWalkFragment();

                case ApplicationConstants.WILDLIFE_RANCH:
                    return new NaturalFragment();

            }
            return new AlamoFragment();
        }



    }

}
