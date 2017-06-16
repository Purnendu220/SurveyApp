package com.survey;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by purnendu on 4/14/2017.
 */

public class MemberDetailDao extends AbsDAO<MemberdetailTableModel> {
    public MemberDetailDao(SQLiteDatabase database) {
        super(database);
    }

    @Override
    public List<MemberdetailTableModel> createList(Cursor cursor) {
        List<MemberdetailTableModel> list = new ArrayList<MemberdetailTableModel>();
        Syso.debug(TAG, "cursor size = " + cursor.getCount());
        for (int i = 0; i < cursor.getCount(); i++) {
            list.add(createObject(cursor));
            cursor.moveToNext();
        }
        return list;
    }

    @Override
    public MemberdetailTableModel createObject(Cursor cursor) {
        MemberdetailTableModel data = new MemberdetailTableModel();
        if (cursor != null) {
            data.setId(cursor.getInt(cursor.getColumnIndex(MemberDetailTable.MemberDetailTableColumns._ID))+"");

            data.setFamily_house_no(cursor.getString(cursor.getColumnIndex(MemberDetailTable.MemberDetailTableColumns.family_house_no)));
            data.setFamily_no(cursor.getString(cursor.getColumnIndex(MemberDetailTable.MemberDetailTableColumns.family_no)));
            data.setMember_name(cursor.getString(cursor.getColumnIndex(MemberDetailTable.MemberDetailTableColumns.member_name)));
            data.setMember_sex(cursor.getString(cursor.getColumnIndex(MemberDetailTable.MemberDetailTableColumns.member_sex)));

            data.setMember_femail_type(cursor.getString(cursor.getColumnIndex(MemberDetailTable.MemberDetailTableColumns.member_femail_type)));
            data.setMember_relation(cursor.getString(cursor.getColumnIndex(MemberDetailTable.MemberDetailTableColumns.member_relation)));
            data.setMember_education(cursor.getString(cursor.getColumnIndex(MemberDetailTable.MemberDetailTableColumns.member_education)));
            data.setMember_age(cursor.getString(cursor.getColumnIndex(MemberDetailTable.MemberDetailTableColumns.member_age)));

            data.setMember_dob(cursor.getString(cursor.getColumnIndex(MemberDetailTable.MemberDetailTableColumns.member_dob)));
            data.setMember_aadhar(cursor.getString(cursor.getColumnIndex(MemberDetailTable.MemberDetailTableColumns.member_aadhar)));
            data.setMember_time(cursor.getString(cursor.getColumnIndex(MemberDetailTable.MemberDetailTableColumns.member_time)));

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
        Cursor cursor = db.query(MemberDetailTable.NAME,
                new String[] { id }, null, null, null, null, null);
        cursor.moveToFirst();
        return cursor;
    }

    @Override
    public Cursor getCursor() {
        Cursor cursor = db.query(MemberDetailTable.NAME, null, null, null,
                null, null, null);
        cursor.moveToFirst();
        return cursor;
    }

    @Override
    public List<MemberdetailTableModel> getList() {
        Cursor cursor = getCursor();
        return createList(cursor);
    }

    @Override
    public int getSize() {
        return getCursor().getCount();
    }

    @Override
    public long insert(MemberdetailTableModel data) {
        try {
            Syso.debug(TAG, "insert data = " + data);
            ContentValues cv = new ContentValues();
            cv.put(MemberDetailTable.MemberDetailTableColumns.family_house_no,
                    data.getFamily_house_no());
            cv.put(MemberDetailTable.MemberDetailTableColumns.family_no,
                    data.getFamily_no());
            cv.put(MemberDetailTable.MemberDetailTableColumns.member_name,
                    data.getMember_name());
            cv.put(MemberDetailTable.MemberDetailTableColumns.member_sex,
                    data.getMember_sex());

            cv.put(MemberDetailTable.MemberDetailTableColumns.member_femail_type,
                    data.getMember_femail_type());
            cv.put(MemberDetailTable.MemberDetailTableColumns.member_relation,
                    data.getMember_relation());
            cv.put(MemberDetailTable.MemberDetailTableColumns.member_education,
                    data.getMember_education());
            cv.put(MemberDetailTable.MemberDetailTableColumns.member_age,
                    data.getMember_age());
            cv.put(MemberDetailTable.MemberDetailTableColumns.member_dob,
                    data.getMember_dob());
            cv.put(MemberDetailTable.MemberDetailTableColumns.member_aadhar,
                    data.getMember_aadhar());
            cv.put(MemberDetailTable.MemberDetailTableColumns.member_time,
                    data.getMember_time());
            long result = db.insert(MemberDetailTable.NAME, null, cv);
            return result;
        } catch (Exception e) {
            Syso.error(TAG, "insert error = " + e.getMessage());
            return -1;
        }
    }

    @Override
    public void insertBulk(List<MemberdetailTableModel> list) {
        for (int i=0;i<list.size();i++){

            insert(list.get(i));
        }
    }

    @Override
    public void insertOrUpdate(MemberdetailTableModel data) {

    }
}
