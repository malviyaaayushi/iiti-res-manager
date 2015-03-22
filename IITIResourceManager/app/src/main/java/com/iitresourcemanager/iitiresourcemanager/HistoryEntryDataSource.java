package com.iitresourcemanager.iitiresourcemanager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aayushi on 16/3/15.
 */
public class HistoryEntryDataSource {
    public static final String history="History";
    public static final String columnId="Id";
    public static final String rollNumber="RollNumber";
    public static final String item="Item";
    public static final String time="Time";
    public static final String date="Date";
    public static final String type="Type";
    private SQLiteDatabase database;
    private MySQLiteHelper dbHelper;
    private String[] allColumns={MySQLiteHelper.COLUMN_ID,MySQLiteHelper.COLUMN_ROLLNUMBER,MySQLiteHelper.COLUMN_ITEM,MySQLiteHelper.COLUMN_TIME,
    MySQLiteHelper.COLUMN_DATE,MySQLiteHelper.COLUMN_TYPE};

    public HistoryEntryDataSource(Context context){
        dbHelper=new MySQLiteHelper(context);
    }

    public void open() throws SQLException{
        database = dbHelper.getWritableDatabase();
    }

    public void close(){
        dbHelper.close();
    }

    public HistoryEntryData insert(String rn,String it,String tm,String dt,String tp){
        ContentValues values=new ContentValues();
        values.put(MySQLiteHelper.COLUMN_ROLLNUMBER,rn);
        values.put(MySQLiteHelper.COLUMN_ITEM,it);
        values.put(MySQLiteHelper.COLUMN_TIME,tm);
        values.put(MySQLiteHelper.COLUMN_DATE,dt);
        values.put(MySQLiteHelper.COLUMN_TYPE,tp);
        long insertId=database.insert(MySQLiteHelper.TABLE_HISTORY,null,values);
        Cursor cursor=database.query(MySQLiteHelper.TABLE_HISTORY,allColumns,MySQLiteHelper.COLUMN_ID +"="+insertId,null,null,null,null);
        cursor.moveToFirst();
        HistoryEntryData p=cursorToHistoryEntryData(cursor);
        cursor.close();
        return p;
    }

    public int delete(String id){
        return database.delete(MySQLiteHelper.TABLE_HISTORY, MySQLiteHelper.COLUMN_ID+"="+id,null);
    }


    public List<HistoryEntryData> getAllHistoryEntryData(){
        List<HistoryEntryData> all=new ArrayList<HistoryEntryData>();
        Cursor cursor = database.query(MySQLiteHelper.TABLE_HISTORY,
                allColumns, null, null, null, null, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            HistoryEntryData p=cursorToHistoryEntryData(cursor);
            all.add(p);
            cursor.moveToNext();
        }
        cursor.close();
        return all;
    }
    public HistoryEntryData cursorToHistoryEntryData(Cursor cursor){
        HistoryEntryData p=new HistoryEntryData();
        p.setColumnId(cursor.getLong(0));
        p.setRollNumber(cursor.getString(1));
        p.setItem(cursor.getString(2));
        p.setTime(cursor.getString(3));
        p.setDate(cursor.getString(4));
        p.setType(cursor.getString(5));
        return p;
    }


}
