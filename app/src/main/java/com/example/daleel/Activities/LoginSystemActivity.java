package com.example.daleel.Activities;

import android.os.Bundle;

import com.example.daleel.Fragments.LoginSystemFragments.LoginFragment;
import com.example.daleel.Fragments.LoginSystemFragments.RegisterFragment;
import com.example.daleel.R;

import androidx.appcompat.app.AppCompatActivity;

public class LoginSystemActivity extends AppCompatActivity  {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_loginsystem);



        LoginFragment loginFragment = new LoginFragment ();
        getSupportFragmentManager ().beginTransaction ().replace (R.id.container,loginFragment).commit ();

    }


}

//    @OnClick(R.id.buttonlogin)
//    void onLoginBtnClick(){
//
//    }

//    public void btncreate(View view) {
//        Intent myintent = new Intent (this,RegisterActivity.class);
//        startActivity (myintent);
//    }

