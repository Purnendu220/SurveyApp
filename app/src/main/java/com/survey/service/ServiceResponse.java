package com.survey.service;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Mobikasa on 2/22/2017.
 */

public class ServiceResponse implements Parcelable
{

    @SerializedName("error")
    @Expose
    private Boolean error;
    @SerializedName("msg")
    @Expose
    private String msg;

    public final static Parcelable.Creator<ServiceResponse> CREATOR = new Creator<ServiceResponse>() {


        @SuppressWarnings({
                "unchecked"
        })
        public ServiceResponse createFromParcel(Parcel in) {
            ServiceResponse instance = new ServiceResponse();
            instance.error = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
            instance.msg = ((String) in.readValue((String.class.getClassLoader())));
            return instance;
        }

        public ServiceResponse[] newArray(int size) {
            return (new ServiceResponse[size]);
        }

    }
            ;

    public Boolean getStatus() {
        return error;
    }

    public void setStatus(Boolean status) {
        this.error = error;
    }

    public String getMessage() {
        return msg;
    }

    public void setMessage(String message) {
        this.msg = msg;
    }
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(error);
        dest.writeValue(msg);
    }

    public int describeContents() {
        return 0;
    }

}
