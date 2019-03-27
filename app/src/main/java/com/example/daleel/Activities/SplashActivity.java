package com.example.daleel.Activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

import com.example.daleel.application.MyContextWrapper;
import com.example.daleel.R;
import com.example.daleel.SharedPreference.SharedPreferenceConfig;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;

public class SplashActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.buttonenglish)
    Button english;
    @BindView(R.id.buttonarabic)
    Button arabic;

    private final int SPLASH_DISPLAY_LENGTH = 2000;
    SharedPreferenceConfig preference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_splash);
        ButterKnife.bind (this);
        english.setOnClickListener (this);
        arabic.setOnClickListener (this);
        preference = new SharedPreferenceConfig ();

        new Handler ( ).postDelayed (new Runnable ( ) {
            @Override
            public void run() {

                if (preference.readLoginStatus ( )) {

                    Intent myintent = new Intent (SplashActivity.this, CompaniesActivity.class);
                    startActivity (myintent);
                    finish ( );
                } else {
                    Intent myintent1 = new Intent (SplashActivity.this, LoginSystemActivity.class);
                    startActivity (myintent1);
                    finish ( );

                }
            }
        }, SPLASH_DISPLAY_LENGTH);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId ( )) {
            case R.id.buttonarabic:
                setLayoutLanguage ();
                recreate ();
            case R.id.buttonenglish:

                break;
        }
    }

    private void setLayoutLanguage() {
        if (preference.getLanguage ( ).equals ("ar"))
            getWindow ( ).getDecorView ( ).setLayoutDirection (View.LAYOUT_DIRECTION_RTL);
        else getWindow ( ).getDecorView ( ).setLayoutDirection (View.LAYOUT_DIRECTION_LTR);
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        preference = new SharedPreferenceConfig ( );
        super.attachBaseContext (MyContextWrapper.wrap (newBase, preference.getLanguage ( )));
    }


}
