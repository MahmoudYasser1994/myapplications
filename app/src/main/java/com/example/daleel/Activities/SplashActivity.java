package com.example.daleel.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.daleel.R;
import com.example.daleel.SharedPreference.SharedPreferenceConfig;

public class SplashActivity extends AppCompatActivity {

    private final int SPLASH_DISPLAY_LENGTH = 2000;
    SharedPreferenceConfig preference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_splash);
        preference = new SharedPreferenceConfig (getApplicationContext ( ));

        new Handler ( ).postDelayed (new Runnable ( ) {
            @Override
            public void run() {

                if (preference.readLoginStatus ()) {

                    Intent myintent = new Intent (SplashActivity.this, CompaniesActivity.class);
                    startActivity (myintent);
                    finish ( );
                }
                else{
                    Intent myintent = new Intent (SplashActivity.this, CompaniesActivity.class);
                    startActivity (myintent);
                    finish ( );

                }
            }
        }, SPLASH_DISPLAY_LENGTH);




    }
}
