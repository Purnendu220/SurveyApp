package com.survey;

import android.app.Dialog;
import android.content.Context;
import android.support.design.widget.TextInputLayout;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;

/**
 * Created by Purnendu Mishra on 4/13/2017.
 */

public class FamilyDetailDialog extends Dialog implements DatePickerFragmentDialog.DateSelectionListener {

CallbackInterface callbackInterface;
    TextInputLayout input_layout_edt_membername,input_layout_edt_memberage,input_layout_edt_memberdob,input_layout_edt_memberaadhar;
    EditText edt_membername,edt_memberage,edt_memberdob,edt_memberaadhar;
    RelativeLayout member_gender_layout,member_female_layout,member_relation_layout,member_education_layout;
    Spinner spinner_member_gender,spinner_member_female,spinner_member_relation,spinner_education_relation;
    Button btn_cancel,btn_submit;
    Context mContext;
    public FamilyDetailDialog(Context context) {
        super(context, R.style.AdvanceDialogTheme);
        this.mContext=context;
        Init();
    }
    public FamilyDetailDialog(Context context, int themeResId) {
        super(context, R.style.AdvanceDialogTheme);
        Init();
    }
    public void Setcallback(CallbackInterface callbackInterface){
        this.callbackInterface=callbackInterface;
    }
    private void Init(){
        setContentView(R.layout.family_member_detail);
        setCancelable(false);

        WindowManager.LayoutParams lp = getWindow().getAttributes();
        lp.dimAmount = 0.3f; // Dim level. 0.0 - no dim, 1.0 - completely opaque
        getWindow().setAttributes(lp);
        setCanceledOnTouchOutside(false);
        input_layout_edt_membername=(TextInputLayout)findViewById(R.id.input_layout_edt_membername);
        input_layout_edt_memberage=(TextInputLayout)findViewById(R.id.input_layout_edt_memberage);
        input_layout_edt_memberdob=(TextInputLayout)findViewById(R.id.input_layout_edt_memberdob);
        input_layout_edt_memberaadhar=(TextInputLayout)findViewById(R.id.input_layout_edt_memberaadhar);
        //
        edt_membername=(EditText)findViewById(R.id.edt_membername);
        edt_memberage=(EditText)findViewById(R.id.edt_memberage);
        edt_memberdob=(EditText)findViewById(R.id.edt_memberdob);
        edt_memberaadhar=(EditText)findViewById(R.id.edt_memberaadhar);

        //
        btn_cancel=(Button)findViewById(R.id.btn_cancel);
        btn_submit=(Button)findViewById(R.id.btn_submit);
        //

        member_gender_layout=(RelativeLayout)findViewById(R.id.member_gender_layout);
        member_female_layout=(RelativeLayout)findViewById(R.id.member_female_layout);
        member_relation_layout=(RelativeLayout)findViewById(R.id.member_relation_layout);
        member_education_layout=(RelativeLayout)findViewById(R.id.member_education_layout);
        //
        spinner_member_gender=(Spinner)findViewById(R.id.spinner_member_gender);
        spinner_member_female=(Spinner)findViewById(R.id.spinner_member_female);
        spinner_member_relation=(Spinner)findViewById(R.id.spinner_member_relation);
        spinner_education_relation=(Spinner)findViewById(R.id.spinner_education_relation);

        DatePickerFragmentDialog newFragment = new DatePickerFragmentDialog(mContext);
        newFragment.setDateSelectionListener(this);

        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               dismiss();
            }
        });

        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              dismiss();
            }
        });
        input_layout_edt_memberdob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerFragmentDialog newFragment = new DatePickerFragmentDialog(mContext);
                newFragment.setDateSelectionListener(FamilyDetailDialog.this);
                newFragment.show();
            }
        });
    }

    @Override
    public void onDateSelected(String date) {
        edt_memberdob.setText(date);
    }
}
