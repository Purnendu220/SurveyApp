package com.survey;

import com.google.gson.annotations.SerializedName;

/**
 * Created by purnendu on 4/14/2017.
 */

public class CollectionPageTableModel {
    @SerializedName("family_house_no")
    String family_house_no;
    @SerializedName("family_no")
    String family_no;
    @SerializedName("family_members_detail")
    String family_members_detail ;
    @SerializedName("family_cast")
    String family_cast;
    @SerializedName("family_education")
    String family_education;
    @SerializedName("family_bissiness")
    String family_bissiness ;
    @SerializedName("family_mobile_no")
    String family_mobile_no ;
    @SerializedName("family_date")
    String family_date ;
    @SerializedName("family_member_count")
    String family_member_count ;
    @SerializedName("family_owner_name")
    String family_owner_name;
    @SerializedName("family_time")
    String family_time;

    public CollectionPageTableModel(String family_house_no, String family_no, String family_members_detail, String family_cast, String family_education, String family_bissiness, String family_mobile_no, String family_date, String family_member_count, String family_owner_name, String family_time) {
        this.family_house_no = family_house_no;
        this.family_no = family_no;
        this.family_members_detail = family_members_detail;
        this.family_cast = family_cast;
        this.family_education = family_education;
        this.family_bissiness = family_bissiness;
        this.family_mobile_no = family_mobile_no;
        this.family_date = family_date;
        this.family_member_count = family_member_count;
        this.family_owner_name = family_owner_name;
        this.family_time = family_time;
    }

    public CollectionPageTableModel() {
    }

    public String getFamily_house_no() {
        return family_house_no;
    }

    public void setFamily_house_no(String family_house_no) {
        this.family_house_no = family_house_no;
    }

    public String getFamily_no() {
        return family_no;
    }

    public void setFamily_no(String family_no) {
        this.family_no = family_no;
    }

    public String getFamily_members_detail() {
        return family_members_detail;
    }

    public void setFamily_members_detail(String family_members_detail) {
        this.family_members_detail = family_members_detail;
    }

    public String getFamily_cast() {
        return family_cast;
    }

    public void setFamily_cast(String family_cast) {
        this.family_cast = family_cast;
    }

    public String getFamily_education() {
        return family_education;
    }

    public void setFamily_education(String family_education) {
        this.family_education = family_education;
    }

    public String getFamily_bissiness() {
        return family_bissiness;
    }

    public void setFamily_bissiness(String family_bissiness) {
        this.family_bissiness = family_bissiness;
    }

    public String getFamily_mobile_no() {
        return family_mobile_no;
    }

    public void setFamily_mobile_no(String family_mobile_no) {
        this.family_mobile_no = family_mobile_no;
    }

    public String getFamily_date() {
        return family_date;
    }

    public void setFamily_date(String family_date) {
        this.family_date = family_date;
    }

    public String getFamily_member_count() {
        return family_member_count;
    }

    public void setFamily_member_count(String family_member_count) {
        this.family_member_count = family_member_count;
    }

    public String getFamily_owner_name() {
        return family_owner_name;
    }

    public void setFamily_owner_name(String family_owner_name) {
        this.family_owner_name = family_owner_name;
    }

    public String getFamily_time() {
        return family_time;
    }

    public void setFamily_time(String family_time) {
        this.family_time = family_time;
    }
}
