package com.example.daleel.application;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

import com.example.daleel.Activities.CompaniesActivity;
import com.example.daleel.R;
import com.example.daleel.SharedPreference.SharedPreferenceConfig;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;

public class ExampleDialog extends AppCompatDialogFragment {

    SharedPreferenceConfig sharedPreferenceConfig;
    Activity activity ;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        activity = new CompaniesActivity ();
        sharedPreferenceConfig = new SharedPreferenceConfig ( );
        AlertDialog.Builder builder = new AlertDialog.Builder (getActivity ( ));
        builder.setTitle (R.string.languagesetting).setMessage (R.string.languageselect)
                .setPositiveButton ("yes", new DialogInterface.OnClickListener ( ) {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (sharedPreferenceConfig.getLanguage ( ).equals ("ar")) {
                    sharedPreferenceConfig.setLang ("en");
                } else {
                    sharedPreferenceConfig.setLang ("ar");
                }
                Toast.makeText (activity, "you have to restart your application", Toast.LENGTH_SHORT).show ( );

            }


        }).setNegativeButton ("No", new DialogInterface.OnClickListener ( ) {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel ( );
            }
        });
        return builder.create ( );

    }




}
