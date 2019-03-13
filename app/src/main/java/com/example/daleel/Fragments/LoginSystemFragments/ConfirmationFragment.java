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
import com.example.daleel.Models.Confirmation.ConfirmationModel;
import com.example.daleel.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ConfirmationFragment extends Fragment implements View.OnClickListener {
    @BindView(R.id.textcode)
    EditText edittxtcode;
    @BindView(R.id.buttonconfirm)
    Button btnconfirm;
    String email;
    String code;


    public ConfirmationFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate (R.layout.fragment_confirmation, container, false);
        ButterKnife.bind (this, view);
        btnconfirm.setOnClickListener (this);
        return view;
    }

    private void ConfirmCode() {

        code=edittxtcode.getText ().toString ();
        Bundle b = this.getArguments ( );
        email = b.getString ("email");


        Call<ConfirmationModel> confirm = RetrofitInstance.getInstance ( ).getApi ( ).confirm (code, email);

        confirm.enqueue (new Callback<ConfirmationModel> ( ) {
            @Override
            public void onResponse(Call<ConfirmationModel> call, Response<ConfirmationModel> response) {

            }

            @Override
            public void onFailure(Call<ConfirmationModel> call, Throwable t) {

            }
        });

        ChangePasswordFragment changePasswordFragment = new ChangePasswordFragment ( );
        getFragmentManager ().beginTransaction ().replace (R.id.container, changePasswordFragment,null).addToBackStack (null).commit ();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId ()){
            case R.id.buttonconfirm:
                ConfirmCode ();
                break;
        }

    }
}
