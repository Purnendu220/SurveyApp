package com.survey;

import android.app.Dialog;
import android.content.Context;
import android.support.design.widget.TextInputLayout;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Purnendu Mishra on 4/13/2017.
 */

public class FamilyDetailDialog extends Dialog implements DatePickerFragmentDialog.DateSelectionListener {

    CallbackInterface callbackInterface;
    TextInputLayout input_layout_edt_membername, input_layout_edt_memberage, input_layout_edt_memberdob, input_layout_edt_memberaadhar;
    EditText edt_membername, edt_memberage, edt_memberdob, edt_memberaadhar;
    RelativeLayout member_gender_layout, member_female_layout, member_relation_layout, member_education_layout;
    Spinner spinner_member_gender, spinner_member_female, spinner_member_relation, spinner_education_relation;
    Button btn_cancel, btn_submit;
    Context mContext;
    List<String> myArrayListGender, mArraryListFemale, mArrayListRelation, mArrayListEducation;
    ArrayAdapter<String> adapterGender, adapterFemale, adapterRelation, adapterEducation;
    private int mSelectedGender = 0, mSelectedFemaleType = 0, mSelectedRelation = 0, mSelectedEducation = 0;
    FamilyMemberDetail detail;
    boolean showdatepicker=true;
    DatePickerFragmentDialog newFragment;

    public FamilyDetailDialog(Context context) {
        super(context, R.style.AdvanceDialogTheme);
        this.mContext = context;
        myArrayListGender = Arrays.asList(context.getResources().getStringArray(R.array.gender_list));
        mArraryListFemale = Arrays.asList(context.getResources().getStringArray(R.array.female_type));
        mArrayListRelation = Arrays.asList(context.getResources().getStringArray(R.array.relation_list));
        mArrayListEducation = Arrays.asList(context.getResources().getStringArray(R.array.education_list));
        adapterGender = new ArrayAdapter<String>(context, R.layout.adaptor_spinner_row,R.id.spinnerTV, myArrayListGender);
        adapterFemale = new ArrayAdapter<String>(context, R.layout.adaptor_spinner_row,R.id.spinnerTV, mArraryListFemale);
        adapterRelation = new ArrayAdapter<String>(context, R.layout.adaptor_spinner_row,R.id.spinnerTV, mArrayListRelation);
        adapterEducation = new ArrayAdapter<String>(context, R.layout.adaptor_spinner_row,R.id.spinnerTV, mArrayListEducation);
        Init();
    }

    public FamilyDetailDialog(Context context, int themeResId) {
        super(context, R.style.AdvanceDialogTheme);
        Init();
    }

    public void Setcallback(CallbackInterface callbackInterface) {
        this.callbackInterface = callbackInterface;
    }

    private void Init() {
        setContentView(R.layout.family_member_detail);
        setCancelable(false);
        WindowManager.LayoutParams lp = getWindow().getAttributes();
        lp.dimAmount = 0.3f; // Dim level. 0.0 - no dim, 1.0 - completely opaque
        getWindow().setAttributes(lp);
        setCanceledOnTouchOutside(false);
        input_layout_edt_membername = (TextInputLayout) findViewById(R.id.input_layout_edt_membername);
        input_layout_edt_memberage = (TextInputLayout) findViewById(R.id.input_layout_edt_memberage);
        input_layout_edt_memberdob = (TextInputLayout) findViewById(R.id.input_layout_edt_memberdob);
        input_layout_edt_memberaadhar = (TextInputLayout) findViewById(R.id.input_layout_edt_memberaadhar);
        //
        edt_membername = (EditText) findViewById(R.id.edt_membername);
        edt_memberage = (EditText) findViewById(R.id.edt_memberage);
        edt_memberdob = (EditText) findViewById(R.id.edt_memberdob);
        edt_memberaadhar = (EditText) findViewById(R.id.edt_memberaadhar);

        //
        btn_cancel = (Button) findViewById(R.id.btn_cancel);
        btn_submit = (Button) findViewById(R.id.btn_submit);
        //

        member_gender_layout = (RelativeLayout) findViewById(R.id.member_gender_layout);
        member_female_layout = (RelativeLayout) findViewById(R.id.member_female_layout);
        member_relation_layout = (RelativeLayout) findViewById(R.id.member_relation_layout);
        member_education_layout = (RelativeLayout) findViewById(R.id.member_education_layout);
        //
        spinner_member_gender = (Spinner) findViewById(R.id.spinner_member_gender);
        spinner_member_female = (Spinner) findViewById(R.id.spinner_member_female);
        spinner_member_relation = (Spinner) findViewById(R.id.spinner_member_relation);
        spinner_education_relation = (Spinner) findViewById(R.id.spinner_education_relation);
        spinner_member_gender.setAdapter(adapterGender);
        spinner_member_female.setAdapter(adapterFemale);
        spinner_member_relation.setAdapter(adapterRelation);
        spinner_education_relation.setAdapter(adapterEducation);
         newFragment = new DatePickerFragmentDialog(mContext);
        newFragment.setDateSelectionListener(FamilyDetailDialog.this);
        setListener();


        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Validate()&&detail!=null){
                callbackInterface.onSuccess(detail);
                    dismiss();
                }
                else{
                    callbackInterface.onFailure(Constants.TRY_AGAIN);
                }

            }
        });


        edt_memberdob.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {

                if(hasFocus&&!newFragment.isShowing()){
                    newFragment.show();
                }
                else{
                    if(newFragment.isShowing()){
                        newFragment.dismiss();
                    }
                }
            }
        });



    }

    @Override
    public void onDateSelected(String date) {
        edt_memberdob.setText(date);
        edt_memberaadhar.requestFocus();
        if(newFragment.isShowing()){
            newFragment.dismiss();
        }
    }

    private void setListener() {
        spinner_member_gender.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                mSelectedGender = position;
                if (position == 2) {
                    member_female_layout.setVisibility(View.VISIBLE);
                } else {
                    member_female_layout.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinner_member_female.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                mSelectedFemaleType = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spinner_member_relation.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                mSelectedRelation = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spinner_education_relation.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                mSelectedEducation = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }

    private boolean Validate() {
        String name = edt_membername.getText().toString();
        String age = edt_memberage.getText().toString();
        String dob = edt_memberdob.getText().toString();
        String aadhar = edt_memberaadhar.getText().toString();
        String gender = "", femaletype = "", relation = "", education = "";
        if (StringUtils.isEmpty(name)) {
            AlertUtils.getInstance().showToast(mContext,Constants.FILL_MEMBER_NAME);
            return false;
        }
        if (StringUtils.isEmpty(age) && StringUtils.isEmpty(dob)) {
            AlertUtils.getInstance().showToast(mContext,Constants.FILL_DOB_OR_AGE);
            return false;
        }
        if (mSelectedGender < 1) {
            AlertUtils.getInstance().showToast(mContext,Constants.FILL_SEX);
            return false;
        } else {
            gender = spinner_member_gender.getSelectedItem().toString();
            if (mSelectedGender == 2) {
                if (mSelectedFemaleType < 1) {
                    AlertUtils.getInstance().showToast(mContext,Constants.FILL_FEMALE_TYPE);
                    return false;
                } else {
                    femaletype = spinner_member_female.getSelectedItem().toString();

                }
            }
        }
        if (mSelectedRelation < 1) {
            AlertUtils.getInstance().showToast(mContext,Constants.FILL_RELATION);
            return false;
        } else {
            relation = spinner_member_relation.getSelectedItem().toString();
        }
        if (mSelectedEducation < 1) {
            education="";
        } else {
            education = spinner_education_relation.getSelectedItem().toString();

        }
         detail=new FamilyMemberDetail(name,relation,gender,age,dob,education,aadhar,femaletype);

        return true;
    }

}
