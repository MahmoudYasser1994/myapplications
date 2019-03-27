package com.example.daleel.Activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.SearchView;
import android.widget.TextView;

import com.example.daleel.Adapters.CompaniesAdapter;
import com.example.daleel.Fragments.CompanyFragments.CompaniesFragment;
import com.example.daleel.Fragments.Info.profilefragment;
import com.example.daleel.Interfaces.Communicator;
import com.example.daleel.Interfaces.ListAllClickListener;
import com.example.daleel.Models.CompaniesModel.Datum;
import com.example.daleel.R;
import com.example.daleel.SharedPreference.SharedPreferenceConfig;
import com.example.daleel.application.ExampleDialog;
import com.example.daleel.application.MyContextWrapper;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.Objects;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import butterknife.BindView;
import butterknife.ButterKnife;

public class CompaniesActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, ListAllClickListener, Communicator {

    CompaniesAdapter companiesAdapter;
    Communicator communicator;

    @BindView(R.id.nav_view)
    NavigationView navigationView;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawer;
    TextView txtnameregistered;
    TextView txtemailregistered;
    SharedPreferenceConfig sharedPreferenceConfig;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_navigation_drawer);
        ButterKnife.bind (this);
        setLayoutLanguage ();
        setSupportActionBar (toolbar);
        sharedPreferenceConfig = new SharedPreferenceConfig ( );
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle (this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener (toggle);
        toggle.syncState ( );

        View headerview = navigationView.getHeaderView (0);
        txtnameregistered = (TextView) headerview.findViewById (R.id.txtnameregistered);
        txtemailregistered = (TextView) headerview.findViewById (R.id.txtemailregistered);

        txtnameregistered.setText (sharedPreferenceConfig.readName ( ));
        txtemailregistered.setText (sharedPreferenceConfig.readEmail ( ));


        navigationView.setNavigationItemSelectedListener (this);

        companiesAdapter = new CompaniesAdapter (new ArrayList<Datum> ( ), this);

        getSupportFragmentManager ( ).beginTransaction ( ).replace (R.id.container_1, new CompaniesFragment ( )).commit ( );

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById (R.id.drawer_layout);
        if (drawer.isDrawerOpen (GravityCompat.START)) {
            drawer.closeDrawer (GravityCompat.START);
        } else {
            super.onBackPressed ( );
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater ( ).inflate (R.menu.navigation_drawer, menu);
        MenuItem searchitem = menu.findItem (R.id.search);
        SearchView searchView = (SearchView) searchitem.getActionView ( );

        searchView.setOnQueryTextListener (new SearchView.OnQueryTextListener ( ) {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                companiesAdapter.getFilter ( ).filter (newText);
                return true;
            }
        });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId ( );

        //noinspection SimplifiableIfStatement
        if (id == R.id.search) {
            return true;
        }

        return super.onOptionsItemSelected (item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        String s = String.valueOf (item.getTitle ( ));
        // Handle navigation view item clicks here.
        switch (item.getItemId ( )) {
            case R.id.logout_button:
                Intent myintent = new Intent (this, LoginSystemActivity.class);
                startActivity (myintent);
                finish ( );
                sharedPreferenceConfig.writeLoginStatus (false);break;

            case R.id.profile:
                getSupportFragmentManager ( ).beginTransaction ( ).replace (R.id.container_1, new profilefragment ( ), null).addToBackStack (null).commit ( );break;
            case R.id.change_lang:
                openDialog ( );break;

        }


        DrawerLayout drawer = findViewById (R.id.drawer_layout);
        drawer.closeDrawer (GravityCompat.START);
        return true;
    }

    private void openDialog() {
        ExampleDialog exampleDialog = new ExampleDialog ( );
        exampleDialog.show (getSupportFragmentManager ( ), "example dialog");
    }

    @Override
    public void onItemClick(Datum datumList, int pos) {

    }


    @Override
    public void passData(String name) {
        Objects.requireNonNull (getSupportActionBar ( )).setTitle (name);
    }

    @Override
    public void passData1(String name, String email) {

    }

    public void setLayoutLanguage() {
        if (sharedPreferenceConfig.getLanguage ( ).equals ("ar"))
            getWindow ( ).getDecorView ( ).setLayoutDirection (View.LAYOUT_DIRECTION_RTL);
        else getWindow ( ).getDecorView ( ).setLayoutDirection (View.LAYOUT_DIRECTION_LTR);
    }

    @Override
    public void attachBaseContext(Context newBase) {
        sharedPreferenceConfig = new SharedPreferenceConfig ( );
        super.attachBaseContext (MyContextWrapper.wrap (newBase, sharedPreferenceConfig.getLanguage ( )));
    }


//    public void setActionBarTitle(String title) {
//        Objects.requireNonNull (getSupportActionBar ( )).setTitle(title);
//    }
}
