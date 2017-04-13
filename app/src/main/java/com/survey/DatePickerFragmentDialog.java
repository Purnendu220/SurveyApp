package com.survey;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Spinner;


/**
 * Created by Mobikasa on 2/8/2017.
 */

public class DatePickerFragmentDialog extends Dialog implements  View.OnClickListener {

    private DatePicker mDatePicker;
    private Button mButtonOK;
    private DateSelectionListener dateSelectionListener;

    public DatePickerFragmentDialog(Context context) {
        super(context);
        Init();
    }

    public interface DateSelectionListener{
        public void onDateSelected(String date);
    }

    public void setDateSelectionListener(DateSelectionListener dateSelectionListener) {
        this.dateSelectionListener = dateSelectionListener;
    }

    private void Init(){
        setContentView(R.layout.dialog_date_picker);
        setCancelable(false);
        WindowManager.LayoutParams lp = getWindow().getAttributes();
        lp.dimAmount = 0.3f; // Dim level. 0.0 - no dim, 1.0 - completely opaque
        getWindow().setAttributes(lp);
        setCanceledOnTouchOutside(false);
        mDatePicker=(DatePicker)findViewById(R.id.date_picker);
        mButtonOK = (Button)findViewById(R.id.okBTN);
        mButtonOK.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.okBTN:
                getDate();
                dismiss();
                break;
        }
    }

    public String getDate(){
        int month=mDatePicker.getMonth()+1;
        int year=mDatePicker.getYear();
        int day=mDatePicker.getDayOfMonth();
      //  LogUtils.debug("Date_picker--->>>" + month+"/"+year);
        setTimeDate(year+"-"+ String.format("%02d", month)+"-"+ String.format("%02d", day));
        return year+"-"+ String.format("%02d", month)+"-"+ String.format("%02d", day);
    }


    public Button getDateButton(){
        return mButtonOK;
    }

    private void setTimeDate(String date){
        dateSelectionListener.onDateSelected(date);
    }

}
