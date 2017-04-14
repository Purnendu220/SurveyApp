package com.survey;

import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

public class CollectionPageTable {

	public static final String NAME = "FamilyPageTable";

	public interface CollectionPageColumns extends BaseColumns {

		String family_house_no = "family_house_no";
		String family_no = "family_no";
		String family_members_detail = "family_members_detail";
		String family_cast = "family_cast";
		String family_education = "family_education";
		String family_bissiness = "family_bissiness";
		String family_mobile_no = "family_mobile_no";
		String family_date = "family_date";
		String family_member_count = "family_member_count";
		String family_owner_name = "family_owner_name";
		String family_time="family_time";
	}

	public static void createTable(SQLiteDatabase db) {

		db.execSQL("CREATE TABLE "
				+ CollectionPageTable.NAME
				+ '('
				+ CollectionPageColumns._ID
				+ " INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, "
				+ CollectionPageColumns.family_house_no
				+ " TEXT, "
				+ CollectionPageColumns.family_no
				+ " TEXT, "
				+ CollectionPageColumns.family_members_detail
				+ " TEXT, "
				+ CollectionPageColumns.family_cast
				+ " TEXT, "
				+ CollectionPageColumns.family_education
				+ " TEXT, "
				+ CollectionPageColumns.family_bissiness
				+ " TEXT, "
				+ CollectionPageColumns.family_mobile_no
				+ " TEXT, "
				+ CollectionPageColumns.family_date
				+ " TEXT, "
				+ CollectionPageColumns.family_member_count
				+ " TEXT, "
				+ CollectionPageColumns.family_owner_name
				+ " TEXT, "
				+ CollectionPageColumns.family_time
				+ " TEXT "+ ");");
	}

	public static void dropTable(SQLiteDatabase db) {

		db.execSQL("DROP TABLE IF EXISTS " + CollectionPageTable.NAME);
	}
}
