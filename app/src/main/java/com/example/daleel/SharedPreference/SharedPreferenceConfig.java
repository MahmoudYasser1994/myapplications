package com.example.daleel.SharedPreference;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.daleel.R;

public class SharedPreferenceConfig {

    private SharedPreferences sharedPreferences;
    private Context context;

    public SharedPreferenceConfig(Context context) {
        this.context = context;

        sharedPreferences = context.getSharedPreferences (context.getResources ().getString (R.string.login_preferences), Context.MODE_PRIVATE);
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

    public boolean readEmail() {
        boolean status;
        status =sharedPreferences.getBoolean ("email",false);
        return status;
    }
}
