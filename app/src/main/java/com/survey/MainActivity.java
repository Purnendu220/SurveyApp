package com.survey;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Environment;
import android.provider.ContactsContract;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,CallbackInterface {
    TextInputLayout input_layout_edt_house_no,input_layout_edt_family_no,input_layout_edt_mobilenumber;
    EditText edt_house_no,edt_family_no,edt_mobile_no;
    Button button_add_member,btn_register;
    LinearLayout familymemberlist;
    RelativeLayout family_cast_layout,family_siksha_layout,family_bussiness_layout;
    Spinner spinner_family_cast,spinner_family_siksha,spinner_family_bussiness;
    ArrayList<FamilyMemberDetail> memberdetail=new ArrayList<>();
    ArrayList<MemberdetailTableModel> memberdetailtabledata=new ArrayList<MemberdetailTableModel>();
    int mSelectedCast=0,mSelectedSiksha=0,mSelectecbussiness=0;
    private ArrayAdapter<String> adapterBussiness,adapterCast,adapterEducation;
    private List<String> mArrayListBussiness,mArraryListEducation,myArrayListCast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myArrayListCast = Arrays.asList(getResources().getStringArray(R.array.cast_type));
        mArraryListEducation = Arrays.asList(getResources().getStringArray(R.array.education_list));
        mArrayListBussiness = Arrays.asList(getResources().getStringArray(R.array.bussiness_type));
        adapterCast = new ArrayAdapter<String>(this, R.layout.adaptor_spinner_row,R.id.spinnerTV, myArrayListCast);
        adapterEducation = new ArrayAdapter<String>(this, R.layout.adaptor_spinner_row,R.id.spinnerTV, mArraryListEducation);
        adapterBussiness = new ArrayAdapter<String>(this, R.layout.adaptor_spinner_row,R.id.spinnerTV, mArrayListBussiness);


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
        spinner_family_cast.setAdapter(adapterCast);
        spinner_family_siksha.setAdapter(adapterEducation);
        spinner_family_bussiness.setAdapter(adapterBussiness);
        button_add_member.setOnClickListener(this);
        btn_register.setOnClickListener(this);
        setListener();

        Intent i=new Intent(getApplicationContext(),YourService.class);
        startService(i);
        openContacts();

    }
    private void setListener() {
        spinner_family_cast.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                mSelectedCast = position;

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinner_family_siksha.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                mSelectedSiksha = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spinner_family_bussiness.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                mSelectecbussiness = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



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
                if(ValidateForm()){

                    finish();
                    startActivity(getIntent());
                }
                break;

        }
    }

    private boolean ValidateForm(){
     String Houseno=edt_house_no.getText().toString();
        String familyno=edt_family_no.getText().toString();
        String mobile_no=edt_mobile_no.getText().toString();
        String cast="",education="",bussiness="",memberdetailstring="",ownername="";
        if(StringUtils.isEmpty(Houseno)){
            AlertUtils.getInstance().showToast(this,Constants.FILL_HOUSE_NO);
            return false;
        }
        if(StringUtils.isEmpty(familyno)){
            AlertUtils.getInstance().showToast(this,Constants.FILL_FAMILY_MEMBER);
            return false;
        }
        if(StringUtils.isEmpty(mobile_no)){
            AlertUtils.getInstance().showToast(this,Constants.FILL_MOBILE_NO);
            return false;
        }
        if(mSelectedCast<1){
            AlertUtils.getInstance().showToast(this,Constants.FILL_CAST);
            return false;
        }
        else{
            cast=spinner_family_cast.getSelectedItem().toString();
        }
        if(mSelectedSiksha<1){
            AlertUtils.getInstance().showToast(this,Constants.FILL_EDUCATION);
            return false;
        }
        else{
            education=spinner_family_siksha.getSelectedItem().toString();
        }
        if(mSelectecbussiness<1){
            AlertUtils.getInstance().showToast(this,Constants.FILL_BUSSINESS);
            return false;
        }
        else{
            bussiness=spinner_family_bussiness.getSelectedItem().toString();
        }
        if(memberdetail.size()==0){
            AlertUtils.getInstance().showToast(this,Constants.FILL_FAMILY_MEMBER);
            return false;
        }else{
           for(int i=0;i<memberdetail.size();i++){
               FamilyMemberDetail detail=memberdetail.get(i);
               memberdetailstring=memberdetailstring+GsonManager.toJSON(detail)+",";
               MemberdetailTableModel data=new MemberdetailTableModel();
               data.setFamily_house_no(Houseno);
               data.setFamily_no(familyno);
               data.setMember_name(detail.getmMemberName());
               data.setMember_sex(detail.getmMemberSex());

               data.setMember_femail_type(detail.getmMemberFemailType());
               data.setMember_relation(detail.getmMemberRelationWithOwner());
               data.setMember_education(detail.getmMemberEducation());
               data.setMember_age(detail.getmMemberAge());

               data.setMember_dob(detail.getmMemberDob());
               data.setMember_aadhar(detail.getmMemberAadharNo());
               data.setMember_time(System.currentTimeMillis()+"");
               memberdetailtabledata.add(data);
           }

        }
        try{
            ownername=memberdetail.get(0).getmMemberName();
        }catch (Exception e){
            e.printStackTrace();
        }
        try{
            CollectionPageTableModel collectionPageTableModel=new CollectionPageTableModel(Houseno,familyno,memberdetailstring,cast,education,bussiness,mobile_no,DateUtils.getDateTime(System.currentTimeMillis(),DateUtils.FORMAT1)+"",memberdetail.size()+"",ownername,System.currentTimeMillis()+"");
            CollectionPageTableDao collectionPageTableDao=new CollectionPageTableDao(DatabaseHelper.getDatabase());
            collectionPageTableDao.insert(collectionPageTableModel);
            MemberDetailDao memberDetailDao=new MemberDetailDao(DatabaseHelper.getDatabase());
            memberDetailDao.insertBulk(memberdetailtabledata);
            if(checkInternet()){
                senddatatask task=new senddatatask(collectionPageTableModel);
                task.execute();
            }


        }catch (Exception e){
            e.printStackTrace();
            return false;
        }


        return true;
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
        familymemberlist.removeAllViews();
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
                text_education.setText(detail.getmMemberEducation());
            familymemberlist.addView(childView);
        }
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(Constants.ARE_YOU_SURE)
                .setCancelable(false)
                .setPositiveButton(Constants.YES, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        //finish();
                        MainActivity.this.onSuperBackPressed();
                        //super.onBackPressed();
                    }
                })
                .setNegativeButton(Constants.NO, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();
    }
    public void onSuperBackPressed(){
        super.onBackPressed();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.item_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        super.onOptionsItemSelected(item);

        switch(item.getItemId()){
            case R.id.phone:
                Intent i=new Intent(this,SurveyDetail.class);
                startActivity(i);
                break;
        }
        return true;

    }

    class senddatatask extends AsyncTask<Void,Void,Void>{

        CollectionPageTableModel message;

        public senddatatask(CollectionPageTableModel message) {
            this.message = message;
        }

        @Override
        protected Void doInBackground(Void... params) {
            RefrenceWrapper.getRefrenceWrapper(MainActivity.this).getmServiceCallHandler().userRegistration(MainActivity.this,message);
            return null;
        }
    }
/*    class sendmemberdatatask extends AsyncTask<Void,Void,Void>{
        ArrayList<MemberdetailTableModel> memberdetailtabledata;

        public sendmemberdatatask(ArrayList<MemberdetailTableModel> memberdetailtabledata) {
            this.memberdetailtabledata=memberdetailtabledata;
        }

        @Override
        protected Void doInBackground(Void... params) {
            for(int i=0;i<memberdetailtabledata.size();i++){
                RefrenceWrapper.getRefrenceWrapper(MainActivity.this).getmServiceCallHandler().memberdetail(MainActivity.this,memberdetailtabledata.get(i));

            }
            return null;
        }
    }*/
    public void requestPermission(final Context context, final String permission, String mess) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            ActivityCompat.requestPermissions((Activity) context, new String[]{permission}, Constants.REQUEST_ENABLE);
            ActivityCompat.shouldShowRequestPermissionRationale((Activity) context, permission);
        }
    }
    private void openContacts() {
        if (checkPermissionFor(Constants.READ_PHONE_STATE)) {
            requestPermission(MainActivity.this, Manifest.permission.READ_PHONE_STATE, "Allow Survey to " + "\n" + "access your phone?");
        }
    }
    public boolean checkPermissionFor(String permission) {
        if (permission.equalsIgnoreCase(Constants.READ_PHONE_STATE)) {
            return (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP_MR1 && checkSelfPermission(android.Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED);
        }
        return false;
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        if (requestCode == Constants.REQUEST_ENABLE) {


        }

    }

    public boolean checkInternet() {
        try {
            if (NetworkUtils.isConnectingToInternet(MainActivity.this)) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            Syso.error(e);
            return false;
        }
    }
}
