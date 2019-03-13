package com.example.daleel.Fragments.CompanyFragments;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnClick;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.daleel.Interfaces.ListAllClickListener;
import com.example.daleel.Models.CompaniesModel.Datum;
import com.example.daleel.R;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class CompaniesDetailsFragment extends Fragment implements ListAllClickListener {


    @BindViews ({R.id.textViewnamedetails,R.id.textviewcountrydetails,R.id.textviewmohafzadetails,
            R.id.textviewcitydetails,R.id.textviewzonedetails,R.id.textviewsectiondetails,
            R.id.textviewtasnifdetails,R.id.textviewaddressdetails,R.id.textviewphonenumberdetails,
            R.id.textviewresnamedetails,R.id.textviewmobilenumberdetails,R.id.textviewwhatsnumberdetails,
            R.id.textviewemaildetails})
    List<TextView> textList;
    TextView txtNamedetails,txtCountrydetails,txtMohafzadetails,txtcitydetails,
            txtzonedetails, txtsectiondetails, txttasnifdetails,txtaddressdetails,
            txtphonenumberdetails,txtresnamedetails,txtmobilenumberdetails,
            txtwhatsnumberdetails,txtemaildetails;



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


    public CompaniesDetailsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        Bundle b = getArguments ( );
        if (b != null) {
            compname = b.getString ("name");
            compCountry = b.getString ("country");
            compMohafza = b.getString ("mohafza");
            compCity = b.getString ("city");
            compZone = b.getString ("zone");
            compSection = b.getString ("section");
            compTasnif = b.getString ("tasnif");
            compAddress = b.getString ("address");
            compPhonenumber = b.getString ("phonenumber");
            compResname = b.getString ("resname");
            compMobilenumber = b.getString ("mobilenumber");
            compWhatsnumber = b.getString ("whats");
            compEmail = b.getString ("email");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate (R.layout.fragment_companies_details, container, false);
        ButterKnife.bind (this,view);
        views ( );
        return view;

    }

    @Override
    public void onItemClick(Datum datumList, int pos) {

    }

    public void views() {

        txtNamedetails=textList.get (0);
        txtCountrydetails=textList.get (1);
        txtMohafzadetails=textList.get (2);
        txtcitydetails=textList.get (3);
        txtzonedetails=textList.get (4);
        txtsectiondetails=textList.get (5);
        txttasnifdetails=textList.get (6);
        txtaddressdetails=textList.get (7);
        txtphonenumberdetails=textList.get (8);
        txtresnamedetails=textList.get (9);
        txtmobilenumberdetails=textList.get (10);
        txtwhatsnumberdetails=textList.get (11);
        txtemaildetails=textList.get (12);

        txtNamedetails.setText (compname);
        txtCountrydetails.setText (compCountry);
        txtMohafzadetails.setText (compMohafza);
        txtsectiondetails.setText (compCity);
        txtcitydetails.setText (compZone);
        txtzonedetails.setText (compSection);
        txttasnifdetails.setText (compTasnif);
        txtaddressdetails.setText (compAddress);
        txtphonenumberdetails.setText (compPhonenumber);
        txtresnamedetails.setText (compResname);
        txtmobilenumberdetails.setText (compMobilenumber);
        txtwhatsnumberdetails.setText (compWhatsnumber);
        txtemaildetails.setText (compEmail);

    }

//    @OnClick({})
//    void onB(Button button){
//        switch (button.getId ()){
//            case
//        }

    }



