package com.example.daleel.Fragments.LoginSystemFragments;


import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.daleel.Activities.CompaniesActivity;
import com.example.daleel.AlertDialog.MyAlertDialog;
import com.example.daleel.Api.RetrofitInstance;
import com.example.daleel.Models.ChangePassword.ChangePasswordModel;
import com.example.daleel.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ChangePasswordFragment extends Fragment implements View.OnClickListener {
    @BindView(R.id.edittxtemailconfirm)
    EditText edittxtemailconfirm;
    @BindView(R.id.edittxtpass1)
    EditText edittxtpass1;
    @BindView(R.id.edittxtpass2)
    EditText edittxtpass2;
    @BindView(R.id.buttonconfirmpass)
    Button btnconfirmpass;
    String email, password, passconfirm;

   @BindView (R.id.progress)
    ProgressBar progressBar;

    public ChangePasswordFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate (R.layout.fragment_change_password, container, false);
        ButterKnife.bind (this, view);
        btnconfirmpass.setOnClickListener (this);
        return view;
    }

    private void changepassword() {
        email = edittxtemailconfirm.getText ( ).toString ( );
        password = edittxtpass1.getText ( ).toString ( );
        passconfirm = edittxtpass2.getText ( ).toString ( );


    progressBar.setVisibility (View.VISIBLE);
        Call<ChangePasswordModel> call = RetrofitInstance.getInstance ( ).getApi ( ).ChangePassword (email, password, passconfirm);
        call.enqueue (new Callback<ChangePasswordModel> ( ) {
            @Override
            public void onResponse(Call<ChangePasswordModel> call, Response<ChangePasswordModel> response) {
                String s = response.body ( ).getStatus ( ).getTitle ( );
                Toast.makeText (getActivity ( ), s, Toast.LENGTH_SHORT).show ( );
                progressBar.setVisibility (View.GONE);
            }

            @Override
            public void onFailure(Call<ChangePasswordModel> call, Throwable t) {
                progressBar.setVisibility (View.GONE);
            }
        });

        Intent myintent = new Intent (getActivity ( ), CompaniesActivity.class);
        startActivity (myintent);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId ( )) {
            case R.id.buttonconfirmpass:
                changepassword ( );
                break;
        }
    }
}
