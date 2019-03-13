package com.example.daleel.Api;

import com.example.daleel.Models.ChangePassword.ChangePasswordModel;
import com.example.daleel.Models.Check.CheckModel;
import com.example.daleel.Models.CompaniesModel.CompaniesModel;
import com.example.daleel.Models.Confirmation.ConfirmationModel;
import com.example.daleel.Models.Login.LoginModel;
import com.example.daleel.Models.Register.RegisterModel;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiInterface {

    @FormUrlEncoded
    @POST("auth/login")
    Call<LoginModel> login(@Field("email") String email, @Field("password") String password);

    @FormUrlEncoded
    @POST("auth/register")
    Call<RegisterModel> register(@Field("name") String name, @Field("email") String email, @Field("ph_number") String ph_number, @Field("password") String password, @Field("password_confirmation") String password_confirmation);

    @FormUrlEncoded
    @POST("auth/check-email")
    Call<CheckModel> check(@Field("email") String email);

    @FormUrlEncoded
    @POST("auth/code-confirmation")
    Call<ConfirmationModel> confirm (@Field("code") String code, @Field("email") String email);

    @FormUrlEncoded
    @POST("auth/pass-change")
    Call<ChangePasswordModel> ChangePassword (@Field("email") String email, @Field("password") String password,@Field("password_confirmation") String password_confirmation );

    @GET("get-companies")
    Call <CompaniesModel> getCompanies();
}
