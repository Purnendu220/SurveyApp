package com.survey;

/**
 * Created by purnendu on 4/14/2017.
 */

public class MemberdetailTableModel {
    String family_house_no ;
    String family_no ;
    String member_name ;
    String member_sex ;
    String member_femail_type ;
    String member_relation ;
    String member_education ;
    String member_age ;
    String member_dob;
    String member_aadhar;
    String member_time;

    public MemberdetailTableModel(String family_house_no, String family_no, String member_name, String member_sex, String member_femail_type, String member_relation, String member_education, String member_age, String member_dob, String member_aadhar, String member_time) {
        this.family_house_no = family_house_no;
        this.family_no = family_no;
        this.member_name = member_name;
        this.member_sex = member_sex;
        this.member_femail_type = member_femail_type;
        this.member_relation = member_relation;
        this.member_education = member_education;
        this.member_age = member_age;
        this.member_dob = member_dob;
        this.member_aadhar = member_aadhar;
        this.member_time = member_time;
    }

    public MemberdetailTableModel() {
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

    public String getMember_name() {
        return member_name;
    }

    public void setMember_name(String member_name) {
        this.member_name = member_name;
    }

    public String getMember_sex() {
        return member_sex;
    }

    public void setMember_sex(String member_sex) {
        this.member_sex = member_sex;
    }

    public String getMember_femail_type() {
        return member_femail_type;
    }

    public void setMember_femail_type(String member_femail_type) {
        this.member_femail_type = member_femail_type;
    }

    public String getMember_relation() {
        return member_relation;
    }

    public void setMember_relation(String member_relation) {
        this.member_relation = member_relation;
    }

    public String getMember_education() {
        return member_education;
    }

    public void setMember_education(String member_education) {
        this.member_education = member_education;
    }

    public String getMember_age() {
        return member_age;
    }

    public void setMember_age(String member_age) {
        this.member_age = member_age;
    }

    public String getMember_dob() {
        return member_dob;
    }

    public void setMember_dob(String member_dob) {
        this.member_dob = member_dob;
    }

    public String getMember_aadhar() {
        return member_aadhar;
    }

    public void setMember_aadhar(String member_aadhar) {
        this.member_aadhar = member_aadhar;
    }

    public String getMember_time() {
        return member_time;
    }

    public void setMember_time(String member_time) {
        this.member_time = member_time;
    }
}
