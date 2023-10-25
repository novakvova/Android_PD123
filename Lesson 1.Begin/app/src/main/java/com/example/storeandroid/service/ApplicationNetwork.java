package com.example.storeandroid.service;

import com.example.storeandroid.network.CategorriesApi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApplicationNetwork {
    private static ApplicationNetwork instance;

    private Retrofit retrofit;

    public ApplicationNetwork() {
        retrofit = new Retrofit.Builder()
                .baseUrl("https://pipi.itstep.click")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static ApplicationNetwork getInstance() {
        if(instance==null)
            instance=new ApplicationNetwork();
        return instance;
    }
    public CategorriesApi getCategoriesApi() {
        return retrofit.create(CategorriesApi.class);
    }
}
