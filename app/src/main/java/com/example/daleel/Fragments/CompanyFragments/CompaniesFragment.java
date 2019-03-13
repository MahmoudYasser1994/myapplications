package com.example.daleel.Fragments.CompanyFragments;


import android.app.AlertDialog;
import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.daleel.Adapters.CompaniesAdapter;
import com.example.daleel.Api.RetrofitInstance;
import com.example.daleel.Interfaces.ListAllClickListener;
import com.example.daleel.Models.CompaniesModel.CompaniesModel;
import com.example.daleel.Models.CompaniesModel.Datum;
import com.example.daleel.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class CompaniesFragment extends Fragment implements ListAllClickListener {
    @BindView(R.id.recyclerview)
    RecyclerView recyclerView;
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


    public CompaniesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate (R.layout.fragment_companies, container, false);
        getdata = new ArrayList<> ( );
        companiesAdapter = new CompaniesAdapter (new ArrayList<Datum> ( ), this);
        recyclerView = view.findViewById (R.id.recyclerview);
        GridLayoutManager gridLayoutManager = new GridLayoutManager (getActivity ( ), 1);
        recyclerView.setLayoutManager (gridLayoutManager);
        recyclerView.setItemAnimator (new DefaultItemAnimator ( ));
        recyclerView.setAdapter (companiesAdapter);

        onCall ( );
        return view;

    }

    private void onCall() {

        Call<CompaniesModel> call = RetrofitInstance.getInstance ( ).getApi ( ).getCompanies ( );
        call.enqueue (new Callback<CompaniesModel> ( ) {
            @Override
            public void onResponse(Call<CompaniesModel> call, Response<CompaniesModel> response) {

                companiesAdapter.replaceData (response.body ( ).getData ( ).getData ( ));
            }

            @Override
            public void onFailure(Call<CompaniesModel> call, Throwable t) {

            }
        });
    }

    @Override
    public void onItemClick(Datum datumList, int pos) {

        CompaniesDetailsFragment companiesDetailsFragment = new CompaniesDetailsFragment ();
         compname = String.valueOf (datumList.getName ( ));
        compCountry= String.valueOf (datumList.getCountry ().getEnglishName ());
        compMohafza= String.valueOf (datumList.getMohafza ().getEnglishName ());
        compCity= String.valueOf (datumList.getCity ().getEnglishName ());
        compZone= String.valueOf (datumList.getZone ().getEnglishName ());
        compSection= String.valueOf (datumList.getSection ().getEnglishName ());
        compTasnif= String.valueOf (datumList.getTasnif ().getEnglishName ());
        compAddress= String.valueOf (datumList.getAddress ());
        compPhonenumber= String.valueOf (datumList.getPhoneNumber ());
        compResname= String.valueOf (datumList.getResName ());
        compMobilenumber= String.valueOf (datumList.getMobileNumber ());
        compWhatsnumber= String.valueOf (datumList.getWhatsappNumber ());
        compEmail= String.valueOf (datumList.getEmail ());

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

        getFragmentManager ().beginTransaction ()
                .replace (R.id.container_1,companiesDetailsFragment,null)
                .addToBackStack (null).commit ();

    }
}
