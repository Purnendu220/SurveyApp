package com.survey;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by purnendu on 4/14/2017.
 */

public class CollectionPageTableDao extends AbsDAO<CollectionPageTableModel> {
    public CollectionPageTableDao(SQLiteDatabase database) {
        super(database);
    }

    @Override
    public List<CollectionPageTableModel> createList(Cursor cursor) {
        List<CollectionPageTableModel> list = new ArrayList<CollectionPageTableModel>();
        Syso.debug(TAG, "cursor size = " + cursor.getCount());
        for (int i = 0; i < cursor.getCount(); i++) {
            list.add(createObject(cursor));
            cursor.moveToNext();
        }
        return list;
    }

    @Override
    public CollectionPageTableModel createObject(Cursor cursor) {
        CollectionPageTableModel data = new CollectionPageTableModel();
        if (cursor != null) {
            data.setFamily_house_no(cursor.getString(cursor.getColumnIndex(CollectionPageTable.CollectionPageColumns.family_house_no)));
            data.setFamily_no(cursor.getString(cursor.getColumnIndex(CollectionPageTable.CollectionPageColumns.family_no)));
            data.setFamily_members_detail(cursor.getString(cursor.getColumnIndex(CollectionPageTable.CollectionPageColumns.family_members_detail)));
            data.setFamily_cast(cursor.getString(cursor.getColumnIndex(CollectionPageTable.CollectionPageColumns.family_cast)));

            data.setFamily_education(cursor.getString(cursor.getColumnIndex(CollectionPageTable.CollectionPageColumns.family_education)));
            data.setFamily_bissiness(cursor.getString(cursor.getColumnIndex(CollectionPageTable.CollectionPageColumns.family_bissiness)));
            data.setFamily_mobile_no(cursor.getString(cursor.getColumnIndex(CollectionPageTable.CollectionPageColumns.family_mobile_no)));
            data.setFamily_date(cursor.getString(cursor.getColumnIndex(CollectionPageTable.CollectionPageColumns.family_date)));

            data.setFamily_member_count(cursor.getString(cursor.getColumnIndex(CollectionPageTable.CollectionPageColumns.family_member_count)));
            data.setFamily_owner_name(cursor.getString(cursor.getColumnIndex(CollectionPageTable.CollectionPageColumns.family_owner_name)));
            data.setFamily_time(cursor.getString(cursor.getColumnIndex(CollectionPageTable.CollectionPageColumns.family_time)));

        }
        return data;
    }

    @Override
    public void delete() {

    }

    @Override
    public void delete(String id) {

    }

    @Override
    public Cursor getCursor(String id) {
        Cursor cursor = db.query(CollectionPageTable.NAME,
                new String[] { id }, null, null, null, null, null);
        cursor.moveToFirst();
        return cursor;
    }

    @Override
    public Cursor getCursor() {
        Cursor cursor = db.query(CollectionPageTable.NAME, null, null, null,
                null, null, null);
        cursor.moveToFirst();
        return cursor;
    }

    @Override
    public List<CollectionPageTableModel> getList() {
        Cursor cursor = getCursor();
        return createList(cursor);
    }

    @Override
    public int getSize() {
        return getCursor().getCount();
    }

    @Override
    public long insert(CollectionPageTableModel data) {
        try {
            Syso.debug(TAG, "insert data = " + data);
            ContentValues cv = new ContentValues();
            cv.put(CollectionPageTable.CollectionPageColumns.family_house_no,
                    data.getFamily_house_no());
            cv.put(CollectionPageTable.CollectionPageColumns.family_no,
                    data.getFamily_no());
            cv.put(CollectionPageTable.CollectionPageColumns.family_members_detail,
                    data.getFamily_members_detail());
            cv.put(CollectionPageTable.CollectionPageColumns.family_cast,
                    data.getFamily_cast());

            cv.put(CollectionPageTable.CollectionPageColumns.family_education,
                    data.getFamily_education());
            cv.put(CollectionPageTable.CollectionPageColumns.family_bissiness,
                    data.getFamily_bissiness());
            cv.put(CollectionPageTable.CollectionPageColumns.family_mobile_no,
                    data.getFamily_mobile_no());
            cv.put(CollectionPageTable.CollectionPageColumns.family_date,
                    data.getFamily_date());
            cv.put(CollectionPageTable.CollectionPageColumns.family_member_count,
                    data.getFamily_member_count());
            cv.put(CollectionPageTable.CollectionPageColumns.family_owner_name,
                    data.getFamily_owner_name());
            cv.put(CollectionPageTable.CollectionPageColumns.family_time,
                    data.getFamily_time());


            long result = db.insert(CollectionPageTable.NAME, null, cv);
            return result;
        } catch (Exception e) {
            Syso.error(TAG, "insert error = " + e.getMessage());
            return -1;
        }
    }

    @Override
    public void insertBulk(List<CollectionPageTableModel> list) {
        for (int i=0;i<list.size();i++){

            insert(list.get(i));
        }

    }

    @Override
    public void insertOrUpdate(CollectionPageTableModel data) {

    }
}
