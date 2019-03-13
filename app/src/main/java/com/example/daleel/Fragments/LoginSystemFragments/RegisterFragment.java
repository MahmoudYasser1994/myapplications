package com.example.daleel.Fragments.LoginSystemFragments;


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
import android.widget.Toast;

import com.example.daleel.Api.RetrofitInstance;
import com.example.daleel.Models.Register.RegisterModel;
import com.example.daleel.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class RegisterFragment extends Fragment implements View.OnClickListener {
    @BindView(R.id.edittextusername)
    EditText txtusername;
    @BindView(R.id.edittextemail)
    EditText txtemail;
    @BindView(R.id.edittextphone)
    EditText txtphone;
    @BindView(R.id.edittextpassword)
    EditText txtpassword;
    @BindView(R.id.edittextconfirmpassword)
    EditText txtpasswordconfirm;
    @BindView(R.id.buttoncreate)
    Button btncreate;


    public RegisterFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate (R.layout.fragment_register, container, false);
        ButterKnife.bind (this, view);
        btncreate.setOnClickListener (this);
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId ( )) {
            case R.id.buttoncreate:
                userSignUp ( );
                break;
        }

    }

    private void userSignUp() {
        String name = txtusername.getText ( ).toString ( );
        String email = txtemail.getText ( ).toString ( );
        String ph_number = txtphone.getText ( ).toString ( );
        String password = txtpassword.getText ( ).toString ( );
        String password_confirmation = txtpasswordconfirm.getText ( ).toString ( );

        if (name.isEmpty ( )) {
            txtusername.setError ("Name is Required");
            txtusername.requestFocus ( );
            return;
        }
        if (email.isEmpty ( )) {
            txtemail.setError ("Email is Required");
            txtemail.requestFocus ( );
            return;
        }

        if (ph_number.isEmpty ( )) {
            txtphone.setError ("Phone is Required");
            txtphone.requestFocus ( );
            return;
        }
        if (password.isEmpty ( )) {
            txtpassword.setError ("password is Required");
            txtpassword.requestFocus ( );
            return;
        }
        if (password.length ( ) < 6) {
            txtpassword.setError ("password must be greater than 8 letters ");
            txtpassword.requestFocus ( );
            return;
        }

        if (password_confirmation.isEmpty ( )) {
            txtpasswordconfirm.setError ("password is Required");
            txtpasswordconfirm.requestFocus ( );
            return;
        }

        Call<RegisterModel> call = RetrofitInstance.getInstance ( ).getApi ( ).register (name, email, ph_number, password, password_confirmation);
        call.enqueue (new Callback<RegisterModel> ( ) {
            @Override
            public void onResponse(Call<RegisterModel> call, Response<RegisterModel> response) {
                String s = response.body ( ).getStatus ( ).getTitle ( );
                Toast.makeText (getActivity ( ), s, Toast.LENGTH_SHORT).show ( );

                LoginFragment loginFragment = new LoginFragment ( );
                getFragmentManager ( ).beginTransaction ( ).replace (R.id.container, loginFragment ).commit();
            }

            @Override
            public void onFailure(Call<RegisterModel> call, Throwable t) {
                t.printStackTrace ( );

            }
        });


    }

}
