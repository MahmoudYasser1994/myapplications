package com.example.daleel.Fragments.Info;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.daleel.Activities.CompaniesActivity;
import com.example.daleel.Fragments.CompanyFragments.CompaniesFragment;
import com.example.daleel.Interfaces.Communicator;
import com.example.daleel.R;

import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 */
public class profilefragment extends Fragment {

    private Communicator communicator;

    public profilefragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        communicator = (Communicator) getActivity ( );
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate (R.layout.fragment_about_us, container, false);
        communicator.passData ("About Us");
        return view;
    }

//    public void onResume(){
//        super.onResume();
//
//        ((CompaniesActivity) Objects.requireNonNull (getActivity ( )))
//                .setActionBarTitle("About us");
//
//    }
}
