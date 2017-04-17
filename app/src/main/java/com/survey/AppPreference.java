package com.survey;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;


import java.util.ArrayList;

public class AppPreference {


    private String TAG = this.getClass().getSimpleName();
    private SharedPreferences mPrefs;
    private Editor mPrefsEditor;
    private static AppPreference INSTANCE;



    private AppPreference(Context context) {
        this.mPrefs = context.getSharedPreferences(TAG, Context.MODE_PRIVATE);
        this.mPrefsEditor = mPrefs.edit();
    }

    public static AppPreference getInstance() {

        if (INSTANCE == null) {
            INSTANCE = new AppPreference(AppContext.getInstance().getContext());
        }
        return INSTANCE;
    }

public void ClearPRef(){
    mPrefsEditor.clear();
    mPrefsEditor.commit();
}
    public boolean getstatus(String key) {
        return mPrefs.getBoolean(key, false);
    }

    public void setStatus(String key) {
        mPrefsEditor.putBoolean(key, true);
        mPrefsEditor.commit();
    }




}
