package com.example.daleel.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.daleel.Fragments.CompanyFragments.CompaniesFragment;
import com.example.daleel.Fragments.LoginSystemFragments.LoginFragment;
import com.example.daleel.R;

public class CompaniesActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_companies);

        CompaniesFragment companiesFragment = new CompaniesFragment ();
        getSupportFragmentManager ().beginTransaction ().replace (R.id.container_1,companiesFragment).commit ();


    }
}
