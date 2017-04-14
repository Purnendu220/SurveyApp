package com.survey;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "survey.db";
    public static final int DATABASE_VERSION = 2;

    private static DatabaseHelper INSTANCE;

    private DatabaseHelper(Application context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public static DatabaseHelper getIntance(Application context) {
        if (INSTANCE == null) {
            INSTANCE = new DatabaseHelper(context);
        }
        return INSTANCE;
    }

    public static SQLiteDatabase getDatabase() {
        getIntance(AppContext.getInstance().getContext());
        return INSTANCE.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        synchronized (getClass()) {
            createTables(db);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        dropTables(db);
        createTables(db);

    }

    public void resetAllTables(SQLiteDatabase db) {
        dropTables(db);
        createTables(db);

    }

    private void createTables(SQLiteDatabase db) {

        CollectionPageTable.createTable(db);
        MemberDetailTable.createTable(db);


    }

    private void dropTables(SQLiteDatabase db) {

        CollectionPageTable.dropTable(db);
        MemberDetailTable.dropTable(db);

    }


}
