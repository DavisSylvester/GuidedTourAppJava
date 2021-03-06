package com.davissylvester.guidedtourappjava.Activities;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.davissylvester.guidedtourappjava.DomainClasses.AttractionData;
import com.davissylvester.guidedtourappjava.DomainClasses.DataService;
import com.davissylvester.guidedtourappjava.Fragments.AlamoFragment;
import com.davissylvester.guidedtourappjava.Fragments.AttractionList;
import com.davissylvester.guidedtourappjava.Fragments.NaturalFragment;
import com.davissylvester.guidedtourappjava.Fragments.RipleyFragment;
import com.davissylvester.guidedtourappjava.Fragments.RiverWalkFragment;
import com.davissylvester.guidedtourappjava.Fragments.SanAntonioFragment;
import com.davissylvester.guidedtourappjava.R;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    FragmentManager gls;
    ArrayList<AttractionData> data;
    Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = getApplicationContext();

        gls = getSupportFragmentManager();

        data = new DataService(context).getData();

        Toolbar toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        startFragment(new SanAntonioFragment());
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_beaches) {

            // Arrays.stream(data.toArray()).filter(x -> x. == "alamo");x
            startFragment(new NaturalFragment());
        }
        else if (id == R.id.nav_Attractions) {
            AlamoFragment frag = new AlamoFragment();
            startFragment(frag);
        }
        else if (id == R.id.nav_museums) {
            RipleyFragment frag = new RipleyFragment();
            startFragment(frag);
    }

        else if (id == R.id.nav_restaurant) {
            RiverWalkFragment frag = new RiverWalkFragment();
            startFragment(frag);
        }

        else if (id == R.id.nav_attractions_list) {
            AttractionList frag = new AttractionList();
            startFragment(frag);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void showAttractions(View view) {


        startFragment(new AttractionList());
    }

    public <T extends Fragment>  void startFragment(T frag) {

        gls.beginTransaction()
                .replace(R.id.clMainContent, frag)
                .addToBackStack("myFrags")
                .commit();
    }

    public void backNavigate(View view) {

        startFragment(new AttractionList());
    }


}
