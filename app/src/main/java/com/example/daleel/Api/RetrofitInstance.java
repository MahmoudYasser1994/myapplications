package com.example.daleel.Api;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {

    private static final String BASE_URL = "http://sa3dni.org/api/";
    private static Retrofit retrofit;
    private static RetrofitInstance obj;

    private static OkHttpClient getClient() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor ();
        interceptor.setLevel (HttpLoggingInterceptor.Level.BODY);
        return new OkHttpClient.Builder ().addInterceptor (interceptor).build ();
    }

    private RetrofitInstance() {
        retrofit = new Retrofit.Builder ()
                .baseUrl (BASE_URL)
                .addConverterFactory (GsonConverterFactory.create ())
                .client (getClient ())
                .build ();
    }

    public static RetrofitInstance getInstance() {
        if (obj == null) {
            obj = new RetrofitInstance ();
        }
        return obj;
    }

    public ApiInterface getApi() {
        return retrofit.create (ApiInterface.class);

    }

}
