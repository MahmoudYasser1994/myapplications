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
        editor.putBoolean (context.getResources ().getString (R.string.login_status_preferences),status);
        editor.apply ();
    }

    public boolean readLoginStatus() {
        boolean status;
        status =sharedPreferences.getBoolean (context.getResources ().getString (R.string.login_status_preferences),false);
        return status;
    }
}
