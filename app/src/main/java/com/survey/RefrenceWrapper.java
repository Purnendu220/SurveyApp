package com.survey;

import android.content.Context;
import android.content.pm.PackageInfo;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.survey.service.RestAPI;
import com.survey.service.ServiceCallsUtils;
import com.survey.service.ServiceConstants;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class RefrenceWrapper {

    public static RefrenceWrapper refrenceWrapper;
    private Context context;

    private ServiceCallsUtils mServiceCallHandler;
    private RestAPI service;
    private AlertUtils mAlertUtils;


    public RefrenceWrapper(Context activity) {
        this.context = activity;
    }

    public static RefrenceWrapper getRefrenceWrapper(Context context) {
        if (refrenceWrapper == null) {
            refrenceWrapper = new RefrenceWrapper(context);
        }
        return refrenceWrapper;
    }

    public void destroyInstance() {
        if (refrenceWrapper != null) {
            refrenceWrapper = null;
        }
    }

    public RestAPI getService() {
        return (service == null) ? setService() : service;
    }

    private RestAPI setService() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder httppClient=new OkHttpClient.Builder();
        httppClient.addInterceptor(interceptor);
        OkHttpClient client=httppClient.build();
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(ServiceConstants.WebConstants.BASE_URL_CONSTANT)
                .addConverterFactory(GsonConverterFactory.create(gson))
                ;
        Retrofit retrofit = builder.client(client).build();
        service = retrofit.create(RestAPI.class);
        return service;

    }

    public Retrofit getRetrofit(){
        Retrofit.Builder builder = new Retrofit.Builder().baseUrl(ServiceConstants.WebConstants.BASE_URL_CONSTANT).addConverterFactory(GsonConverterFactory.create());
        Retrofit retrofit = builder.client(new OkHttpClient.Builder().build()).build();
        return retrofit;
    }



    public ServiceCallsUtils getmServiceCallHandler() {
        if (mServiceCallHandler == null) {
            mServiceCallHandler = new ServiceCallsUtils();
        }
        return mServiceCallHandler;
    }



    public AlertUtils getmAlertUtils() {
        if (mAlertUtils == null) {
            mAlertUtils = new AlertUtils();
        }
        return mAlertUtils;
    }






    public String getApplicationPackage(Context ctx) {
        String version = "";
        try {
            PackageInfo pInfo = ctx.getPackageManager().getPackageInfo(ctx.getPackageName(), 0);
            version = pInfo.packageName;
        } catch (Exception e) {
            version = "";
        }
        return version;
    }



}