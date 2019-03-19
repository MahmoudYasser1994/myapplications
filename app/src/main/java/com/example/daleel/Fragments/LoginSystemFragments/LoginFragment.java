package com.example.daleel.Fragments.LoginSystemFragments;


import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
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
import android.widget.Toast;

import com.example.daleel.Activities.CompaniesActivity;
import com.example.daleel.AlertDialog.MyAlertDialog;
import com.example.daleel.Api.RetrofitInstance;
import com.example.daleel.Models.Login.LoginModel;
import com.example.daleel.R;
import com.example.daleel.SharedPreference.SharedPreferenceConfig;

/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment implements View.OnClickListener {

    @BindView(R.id.edittextemail)
    EditText txtemail;
    @BindView(R.id.edittextpasswordlogin)
    EditText txtpassword;
    @BindView(R.id.buttonforget)
    Button btnforget;
    @BindView(R.id.buttonlogin)
    Button btnlogin;
    @BindView(R.id.buttonregister)
    Button btnregister;

    SharedPreferenceConfig sharedPreferenceConfig;
    AlertDialog alertDialog;
    MyAlertDialog myAlertDialog;


    public LoginFragment() {

    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate (R.layout.fragment_login, container, false);
        ButterKnife.bind (this, view);
        btnregister.setOnClickListener (this);
        btnforget.setOnClickListener (this);
        btnlogin.setOnClickListener (this);
        myAlertDialog = new MyAlertDialog (alertDialog);
        sharedPreferenceConfig = new SharedPreferenceConfig (getContext ());
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId ( )) {
            case R.id.buttonlogin:
                userLogin ( );
                break;
            case R.id.buttonforget:
                goToForgetScreen ( );
                break;
            case R.id.buttonregister:
                goToRegisterScreen ( );

        }

    }

    public void goToForgetScreen() {

        CheckMailFragment checkMailFragment = new CheckMailFragment ( );
        getFragmentManager ( ).beginTransaction ( ).replace (R.id.container, checkMailFragment, null).addToBackStack (null).commit ( );

//        fragmentTransaction.addToBackStack (null);

    }

    public void goToRegisterScreen() {

        RegisterFragment registerFragment = new RegisterFragment ( );
        getFragmentManager ( ).beginTransaction ( ).replace (R.id.container, registerFragment, null).addToBackStack (null).commit ( );

//        fragmentTransaction.addToBackStack (null);

    }

    private void userLogin() {

        final String email = txtemail.getText ( ).toString ( );
        final String password = txtpassword.getText ( ).toString ( );

        if (email.isEmpty ( )) {
            txtemail.setError ("Email is Required");
            txtemail.requestFocus ( );
            return;
        }


        if (password.isEmpty ( )) {
            txtpassword.setError ("password is Required");
            txtpassword.requestFocus ( );
            return;
        }
        if (txtpassword.length ( ) < 6) {
            txtpassword.setError ("password must be greater than 8 letters ");
            txtpassword.requestFocus ( );
            return;
        }


        myAlertDialog.showDialogue (getActivity ( ));
        Call<LoginModel> call = RetrofitInstance.getInstance ( ).getApi ( ).login (email, password);
        call.enqueue (new Callback<LoginModel> ( ) {
            @Override
            public void onResponse(Call<LoginModel> call, Response<LoginModel> response) {
                String s = response.body ( ).getStatus ( ).getTitle ( );
                Toast.makeText (getActivity ( ), s, Toast.LENGTH_SHORT).show ( );
                Intent myintent = new Intent (getActivity ( ), CompaniesActivity.class);
                startActivity (myintent);
                sharedPreferenceConfig.writeLoginStatus (true);
                myAlertDialog.cancell ();

            }

            @Override
            public void onFailure(Call<LoginModel> call, Throwable t) {
                myAlertDialog.cancell ();

            }
        });



    }


}
