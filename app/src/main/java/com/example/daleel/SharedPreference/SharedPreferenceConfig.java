package com.example.daleel.SharedPreference;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

import com.example.daleel.application.MyApp;
import com.example.daleel.R;

public class SharedPreferenceConfig {

    private SharedPreferences sharedPreferences;
    private Editor editor;

    public SharedPreferenceConfig() {
        Context context = MyApp.getContext ( ).getApplicationContext ( );
        sharedPreferences = context.getSharedPreferences (context.getResources ().getString (R.string.login_preferences), Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        editor.apply ();
    }

    public void writeLoginStatus(boolean status) {

        SharedPreferences.Editor editor= sharedPreferences.edit ();
        editor.putBoolean ("login",status);
        editor.apply ();
    }

    public boolean readLoginStatus() {
        boolean status;
        status =sharedPreferences.getBoolean ("login",false);
        return status;
    }


    public void writeName(String name) {

        SharedPreferences.Editor editor= sharedPreferences.edit ();
        editor.putString ("name",name);
        editor.apply ();
    }

    public String readName() {
        String status;
        status =sharedPreferences.getString ("name",null);
        return status;
    }

    public void writeEmail(String email) {

        SharedPreferences.Editor editor= sharedPreferences.edit ();
        editor.putString ("email",email);
        editor.apply ();
    }

    public String readEmail() {
        String status;
        status =sharedPreferences.getString ("email",null);
        return status;
    }

    public void setLang(String lang) {
        editor.putString("lang", lang).apply();
    }


    public String getLanguage() {
        return sharedPreferences.getString("lang", "en");
    }
}
