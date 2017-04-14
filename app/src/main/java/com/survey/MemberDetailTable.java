package com.survey;

import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

/**
 * Created by purnendu on 4/14/2017.
 */

public class MemberDetailTable {
    public static final String NAME = "MemberDetailTable";

    public interface MemberDetailTableColumns extends BaseColumns {

        String family_house_no = "family_house_no";
        String family_no = "family_no";
        String member_name = "member_name";
        String member_sex = "member_sex";
        String member_femail_type = "member_femail_type";
        String member_relation = "member_relation";
        String member_education = "member_education";
        String member_age = "member_age";
        String member_dob = "member_dob";
        String member_aadhar = "member_aadhar";
        String member_time="member_time";
    }

    public static void createTable(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE "
                + MemberDetailTable.NAME
                + '('
                + MemberDetailTable.MemberDetailTableColumns._ID
                + " INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, "
                + MemberDetailTable.MemberDetailTableColumns.family_house_no
                + " TEXT, "
                + MemberDetailTable.MemberDetailTableColumns.family_no
                + " TEXT, "
                + MemberDetailTable.MemberDetailTableColumns.member_name
                + " TEXT, "
                + MemberDetailTable.MemberDetailTableColumns.member_sex
                + " TEXT, "
                + MemberDetailTable.MemberDetailTableColumns.member_femail_type
                + " TEXT, "
                + MemberDetailTable.MemberDetailTableColumns.member_relation
                + " TEXT, "
                + MemberDetailTable.MemberDetailTableColumns.member_education
                + " TEXT, "
                + MemberDetailTable.MemberDetailTableColumns.member_age
                + " TEXT, "
                + MemberDetailTable.MemberDetailTableColumns.member_dob
                + " TEXT, "
                + MemberDetailTable.MemberDetailTableColumns.member_aadhar
                + " TEXT, "
                + MemberDetailTable.MemberDetailTableColumns.member_time
                + " TEXT "+ ");");
    }

    public static void dropTable(SQLiteDatabase db) {

        db.execSQL("DROP TABLE IF EXISTS " + MemberDetailTable.NAME);
    }
}
