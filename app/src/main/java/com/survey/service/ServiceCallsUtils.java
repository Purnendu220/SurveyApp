package com.survey.service;

import android.content.Context;
import android.util.Log;


import com.survey.AppPreference;
import com.survey.CollectionPageTableModel;
import com.survey.RefrenceWrapper;

import java.io.File;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by cpu505 on 17/9/15.
 */
public class ServiceCallsUtils {
    private RefrenceWrapper refrenceWrapper;
    public void userRegistration(final Context mContext, final CollectionPageTableModel model) {
        refrenceWrapper = RefrenceWrapper.getRefrenceWrapper(mContext);
        Call<ServiceResponse> userSignUpCall = refrenceWrapper.getService().loginUser(
                model.getFamily_bissiness(),
                model.getFamily_cast(),
                model.getFamily_date(),
                model.getFamily_education(),
                model.getFamily_house_no(),
                model.getFamily_member_count(),
                model.getFamily_members_detail(),
                model.getFamily_mobile_no(),
                model.getFamily_no(),
                model.getFamily_owner_name(),
                model.getFamily_time());
        userSignUpCall.enqueue(new CustomCallBacks<ServiceResponse>(mContext, false) {
            @Override
            public void onSucess(Call<ServiceResponse> call, Response<ServiceResponse> response) {
                Log.e("TAG","Service---Success->"+response.body().getStatus());
                   if(!response.body().getStatus()){
                       AppPreference.getInstance().setStatus(model.getFamily_time()+""+model.getFamily_time());

                   }
            }

            @Override
            public void onFailure(Throwable arg0) {
                Log.e("TAG","Service---failure->");
                arg0.printStackTrace();
            }
        });

    }









}
