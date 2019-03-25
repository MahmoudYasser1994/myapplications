package com.example.daleel.Fragments.CompanyFragments;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.daleel.Activities.CompaniesActivity;
import com.example.daleel.Adapters.CompaniesAdapter;
import com.example.daleel.AlertDialog.MyAlertDialog;
import com.example.daleel.Api.RetrofitInstance;
import com.example.daleel.Interfaces.Communicator;
import com.example.daleel.Interfaces.ListAllClickListener;
import com.example.daleel.Models.CompaniesModel.CompaniesModel;
import com.example.daleel.Models.CompaniesModel.Datum;
import com.example.daleel.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class CompaniesFragment extends Fragment implements ListAllClickListener , SwipeRefreshLayout.OnRefreshListener  {
    @BindView (R.id.swipe)
    SwipeRefreshLayout swipeRefreshLayout;
    @BindView(R.id.recyclerview)
    RecyclerView recyclerView;
    @BindView (R.id.progress)
    ProgressBar progressBar;
    RecyclerView.LayoutManager layoutManager;
    private CompaniesAdapter companiesAdapter;
    private List<Datum> getdata;


    private String compname;
    private String compCountry;
    private String compMohafza;
    private String compCity;
    private String compZone;
    private String compSection;
    private String compTasnif;
    private String compAddress;
    private String compPhonenumber;
    private String compResname;
    private String compMobilenumber;
    private String compWhatsnumber;
    private String compEmail;


    Communicator communicator;


    public CompaniesFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach (context);
        communicator = (Communicator) context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate (R.layout.fragment_companies, container, false);
        ButterKnife.bind (this,view);

        getdata = new ArrayList<> ( );
        companiesAdapter = new CompaniesAdapter (new ArrayList<Datum> ( ), this);
        GridLayoutManager gridLayoutManager = new GridLayoutManager (getActivity ( ), 1);
        recyclerView.setLayoutManager (gridLayoutManager);
        recyclerView.setItemAnimator (new DefaultItemAnimator ( ));
        recyclerView.setAdapter (companiesAdapter);

        communicator.passData ("Companies");

        swipeRefreshLayout.setOnRefreshListener(this);
        swipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary,
                android.R.color.holo_green_dark,
                android.R.color.holo_orange_dark,
                android.R.color.holo_blue_dark);
        onCall ( );
        return view;

    }

    private void onCall() {


        progressBar.setVisibility (View.VISIBLE);
        Call<CompaniesModel> call = RetrofitInstance.getInstance ( ).getApi ( ).getCompanies ( );
        call.enqueue (new Callback<CompaniesModel> ( ) {
            @Override
            public void onResponse(Call<CompaniesModel> call, Response<CompaniesModel> response) {

                companiesAdapter.replaceData (response.body ( ).getData ( ).getData ( ));
                progressBar.setVisibility (View.GONE);

            }

            @Override
            public void onFailure(Call<CompaniesModel> call, Throwable t) {
                progressBar.setVisibility (View.GONE);
            }
        });
    }

    @Override
    public void onItemClick(Datum datumList, int pos) {

        CompaniesDetailsFragment companiesDetailsFragment = new CompaniesDetailsFragment ( );
        compname = String.valueOf (datumList.getName ( ));
        compCountry = String.valueOf (datumList.getCountry ( ).getArabicName ());
        compMohafza = String.valueOf (datumList.getMohafza ( ).getArabicName ( ));
        compCity = String.valueOf (datumList.getCity ( ).getArabicName ( ));
        compZone = String.valueOf (datumList.getZone ( ).getArabicName ( ));
        compSection = String.valueOf (datumList.getSection ( ).getArabicName ( ));
        compTasnif = String.valueOf (datumList.getTasnif ( ).getArabicName ( ));
        compAddress = String.valueOf (datumList.getAddress ( ));
        compPhonenumber = String.valueOf (datumList.getPhoneNumber ( ));
        compResname = String.valueOf (datumList.getResName ( ));
        compMobilenumber = String.valueOf (datumList.getMobileNumber ( ));
        compWhatsnumber = String.valueOf (datumList.getWhatsappNumber ( ));
        compEmail = String.valueOf (datumList.getEmail ( ));

        Bundle b = new Bundle ( );
        b.putString ("name", compname);
        b.putString ("country", compCountry);
        b.putString ("mohafza", compMohafza);
        b.putString ("city", compCity);
        b.putString ("zone", compZone);
        b.putString ("section", compSection);
        b.putString ("tasnif", compTasnif);
        b.putString ("address", compAddress);
        b.putString ("phonenumber", compPhonenumber);
        b.putString ("resname", compResname);
        b.putString ("mobilenumber", compMobilenumber);
        b.putString ("whats", compWhatsnumber);
        b.putString ("email", compEmail);
        companiesDetailsFragment.setArguments (b);

        getFragmentManager ( ).beginTransaction ( ).replace (R.id.container_1, companiesDetailsFragment, "details").addToBackStack (null).commit ( );

    }

    @Override
    public void onRefresh() {
        new Handler ().postDelayed (new Runnable ( ) {
            @Override
            public void run() {
                swipeRefreshLayout.setRefreshing (false);
                getFragmentManager ( ).beginTransaction ( ).replace (R.id.container_1, new CompaniesFragment(), "details").addToBackStack (null).commit ( );

            }
        }, 2000);

    }




//    public void onResume(){
//        super.onResume();
//
//        ((CompaniesActivity) getActivity())
//                .setActionBarTitle("Companies");
//
//    }
}
