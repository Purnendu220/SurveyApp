package com.survey;

import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,CallbackInterface {
    TextInputLayout input_layout_edt_house_no,input_layout_edt_family_no,input_layout_edt_mobilenumber;
    EditText edt_house_no,edt_family_no,edt_mobile_no;
    Button button_add_member,btn_register;
    LinearLayout familymemberlist;
    RelativeLayout family_cast_layout,family_siksha_layout,family_bussiness_layout;
    Spinner spinner_family_cast,spinner_family_siksha,spinner_family_bussiness;
    ArrayList<FamilyMemberDetail> memberdetail=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        input_layout_edt_house_no=(TextInputLayout)findViewById(R.id.input_layout_edt_house_no);
        input_layout_edt_family_no=(TextInputLayout)findViewById(R.id.input_layout_edt_family_no);
        input_layout_edt_mobilenumber=(TextInputLayout)findViewById(R.id.input_layout_edt_mobilenumber);
        //
        edt_house_no=(EditText)findViewById(R.id.edt_house_no);
        edt_family_no=(EditText)findViewById(R.id.edt_family_no);
        edt_mobile_no=(EditText)findViewById(R.id.edt_mobile_no);
        //
        button_add_member=(Button)findViewById(R.id.button_add_member);
        btn_register=(Button)findViewById(R.id.btn_register);
        //
        familymemberlist=(LinearLayout)findViewById(R.id.familymemberlist);
        //
        family_cast_layout=(RelativeLayout)findViewById(R.id.family_cast_layout);
        family_siksha_layout=(RelativeLayout)findViewById(R.id.family_siksha_layout);
        family_bussiness_layout=(RelativeLayout)findViewById(R.id.family_bussiness_layout);
        //
        spinner_family_cast=(Spinner)findViewById(R.id.spinner_family_cast);
        spinner_family_siksha=(Spinner)findViewById(R.id.spinner_family_siksha);
        spinner_family_bussiness=(Spinner)findViewById(R.id.spinner_family_bussiness);
        button_add_member.setOnClickListener(this);






    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button_add_member:
                FamilyDetailDialog dailog=new FamilyDetailDialog(this);
                dailog.Setcallback(this);
                dailog.show();
                break;
            case R.id.btn_register:
                break;

        }
    }

    private void ValidateForm(){

    }

    @Override
    public void onSuccess(FamilyMemberDetail memberDetail) {
        memberdetail.add(memberDetail);
        loadJobDetail();
    }

    @Override
    public void onFailure(String Message) {

    }
    private void loadJobDetail() {
        for (int i = 0; i < memberdetail.size(); i++) {
            FamilyMemberDetail detail=memberdetail.get(i);
            final View childView = LayoutInflater.from(this).inflate(R.layout.memberdetailfilled, null);
            TextView text_name = (TextView) childView.findViewById(R.id.text_name);
            TextView text_gender = (TextView) childView.findViewById(R.id.text_gender);
            TextView text_relation = (TextView) childView.findViewById(R.id.text_relation);
            TextView text_age = (TextView) childView.findViewById(R.id.text_age);
            TextView text_dob = (TextView) childView.findViewById(R.id.text_dob);
            TextView text_aadhar = (TextView) childView.findViewById(R.id.text_aadhar);
            TextView text_education = (TextView) childView.findViewById(R.id.text_education);
            if(detail.getmMemberName()!=null&&detail.getmMemberName().length()>0)
            text_name.setText(detail.getmMemberName());
            if(detail.getmMemberSex()!=null&&detail.getmMemberSex().length()>0)
                text_gender.setText(detail.getmMemberSex());

            if(detail.getmMemberRelationWithOwner()!=null&&detail.getmMemberRelationWithOwner().length()>0)
                text_relation.setText(detail.getmMemberRelationWithOwner());
            if(detail.getmMemberAge()!=null&&detail.getmMemberAge().length()>0)
                text_age.setText(detail.getmMemberAge());

            if(detail.getmMemberDob()!=null&&detail.getmMemberDob().length()>0)
                text_dob.setText(detail.getmMemberDob());
            if(detail.getmMemberAadharNo()!=null&&detail.getmMemberAadharNo().length()>0)
                text_aadhar.setText(detail.getmMemberAadharNo());
            if(detail.getmMemberEducation()!=null&&detail.getmMemberEducation().length()>0)
                text_education.setText(detail.getmMemberAadharNo());


            familymemberlist.addView(childView);
        }
    }

}
