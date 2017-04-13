package com.survey;

/**
 * Created by Purnendu Mishra on 4/13/2017.
 */

public class FamilyMemberDetail {
    String mMemberName;
    String mMemberRelationWithOwner;
    String mMemberSex;
    String mMemberAge;
    String mMemberDob;
    String mMemberEducation;
    String mMemberAadharNo;

    public FamilyMemberDetail(String mMemberName, String mMemberRelationWithOwner, String mMemberSex, String mMemberAge, String mMemberDob, String mMemberEducation, String mMemberAadharNo) {
        this.mMemberName = mMemberName;
        this.mMemberRelationWithOwner = mMemberRelationWithOwner;
        this.mMemberSex = mMemberSex;
        this.mMemberAge = mMemberAge;
        this.mMemberDob = mMemberDob;
        this.mMemberEducation = mMemberEducation;
        this.mMemberAadharNo = mMemberAadharNo;
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
