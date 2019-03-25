package com.example.daleel.Fragments.LoginSystemFragments;


import android.app.AlertDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
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

import com.example.daleel.AlertDialog.MyAlertDialog;
import com.example.daleel.Api.RetrofitInstance;
import com.example.daleel.Models.Check.CheckModel;
import com.example.daleel.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class CheckMailFragment extends Fragment implements View.OnClickListener {
    @BindView(R.id.textemailsend)
    EditText edittxtemailsend;
    @BindView(R.id.buttonhavecode)
    Button btnhave;
    @BindView(R.id.buttonsendemail)
    Button btnsend;
    @BindView (R.id.progress)
    ProgressBar progressBar;


    public CheckMailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate (R.layout.fragment_check_mail, container, false);
        ButterKnife.bind (this, view);
        btnhave.setOnClickListener (this);
        btnsend.setOnClickListener (this);
        return view;
    }


    private void CheckButton() {

        String mail = edittxtemailsend.getText ( ).toString ( );

        progressBar.setVisibility (View.VISIBLE);

        Call<CheckModel> call = RetrofitInstance.getInstance ( ).getApi ( ).check (mail);
        call.enqueue (new Callback<CheckModel> ( ) {
            @Override
            public void onResponse(Call<CheckModel> call, Response<CheckModel> response) {

                String s = String.valueOf (response.body ( ).getStatus ( ).getTitle ( ));
                Toast.makeText (getActivity ( ), s, Toast.LENGTH_SHORT).show ( );
                progressBar.setVisibility (View.GONE);

            }

            @Override
            public void onFailure(Call<CheckModel> call, Throwable t) {
                progressBar.setVisibility (View.GONE);
            }
        });

        ConfirmationFragment confirmationFragment = new ConfirmationFragment ( );
        getFragmentManager ( ).beginTransaction ( ).replace (R.id.container, confirmationFragment, null).addToBackStack (null).addToBackStack (null).commit ( );
        Bundle b = new Bundle ( );
        b.putString ("email", mail);
        confirmationFragment.setArguments (b);



    }

    @Override
    public void onClick(View v) {
        switch (v.getId ( )) {
            case R.id.buttonhavecode:
                ConfirmationFragment confirmationFragment = new ConfirmationFragment ( );
                getFragmentManager ( ).beginTransaction ( ).replace (R.id.container, confirmationFragment, null).addToBackStack (null).commit ( );
                break;

            case R.id.buttonsendemail:
                CheckButton ( );
                break;

        }
    }
}
