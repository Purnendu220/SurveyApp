package com.survey;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Purnendu Mishra on 4/13/2017.
 */

public class FamilyMemberDetail {

    @SerializedName("mMemberName")
    String mMemberName;
    @SerializedName("mMemberRelationWithOwner")
    String mMemberRelationWithOwner;
    @SerializedName("mMemberSex")
    String mMemberSex;
    @SerializedName("mMemberAge")
    String mMemberAge;
    @SerializedName("mMemberDob")
    String mMemberDob;
    @SerializedName("mMemberEducation")
    String mMemberEducation;
    @SerializedName("mMemberAadharNo")
    String mMemberAadharNo;
    @SerializedName("mMemberFemailType")
    String mMemberFemailType;

    public FamilyMemberDetail(String mMemberName, String mMemberRelationWithOwner, String mMemberSex, String mMemberAge, String mMemberDob, String mMemberEducation, String mMemberAadharNo,String mMemberFemailType) {
        this.mMemberName = mMemberName;
        this.mMemberRelationWithOwner = mMemberRelationWithOwner;
        this.mMemberSex = mMemberSex;
        this.mMemberAge = mMemberAge;
        this.mMemberDob = mMemberDob;
        this.mMemberEducation = mMemberEducation;
        this.mMemberAadharNo = mMemberAadharNo;
        this.mMemberFemailType=mMemberFemailType;
    }

    public String getmMemberFemailType() {
        return mMemberFemailType;
    }

    public void setmMemberFemailType(String mMemberFemailType) {
        this.mMemberFemailType = mMemberFemailType;
    }

    public String getmMemberName() {
        return mMemberName;
    }

    public void setmMemberName(String mMemberName) {
        this.mMemberName = mMemberName;
    }

    public String getmMemberRelationWithOwner() {
        return mMemberRelationWithOwner;
    }

    public void setmMemberRelationWithOwner(String mMemberRelationWithOwner) {
        this.mMemberRelationWithOwner = mMemberRelationWithOwner;
    }

    public String getmMemberSex() {
        return mMemberSex;
    }

    public void setmMemberSex(String mMemberSex) {
        this.mMemberSex = mMemberSex;
    }

    public String getmMemberAge() {
        return mMemberAge;
    }

    public void setmMemberAge(String mMemberAge) {
        this.mMemberAge = mMemberAge;
    }

    public String getmMemberDob() {
        return mMemberDob;
    }

    public void setmMemberDob(String mMemberDob) {
        this.mMemberDob = mMemberDob;
    }

    public String getmMemberEducation() {
        return mMemberEducation;
    }

    public void setmMemberEducation(String mMemberEducation) {
        this.mMemberEducation = mMemberEducation;
    }

    public String getmMemberAadharNo() {
        return mMemberAadharNo;
    }

    public void setmMemberAadharNo(String mMemberAadharNo) {
        this.mMemberAadharNo = mMemberAadharNo;
    }
}
