package com.survey;

import android.app.Application;

import android.database.sqlite.SQLiteDatabase;


public class FlowersApp extends Application {
    private static DatabaseHelper mDatabaseHelper;
    @Override
    public void onCreate() {
        super.onCreate();
        final AppContext context = AppContext.getInstance();
        context.setContext(this);
        mDatabaseHelper = DatabaseHelper.getIntance(this);

    }




    @Override
    public void onLowMemory() {
        super.onLowMemory();
        System.exit(0);
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }

    public static SQLiteDatabase getDatabase() {
        return mDatabaseHelper.getWritableDatabase();
    }

    public enum TrackerName {
        APP_TRACKER, // Tracker used only in this app.
        GLOBAL_TRACKER, // Tracker used by all the apps from a company. eg:
        // roll-up tracking.
        ECOMMERCE_TRACKER, // Tracker used by all ecommerce transactions from a
        // company.
    }




}
