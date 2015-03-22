package com.iitresourcemanager.iitiresourcemanager;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by aayushi on 13/3/15.
 */
public  class MySQLiteHelper extends SQLiteOpenHelper {
    private static final String databaseName="IITIResources.db";
    private static int databaseVersion=1;
    public static final String TABLE_HISTORY = "History";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_ROLLNUMBER = "RollNumber";
    public static final String COLUMN_ITEM = "Item";
    public static final String COLUMN_TIME = "Time";
    public static final String COLUMN_DATE = "Date";
    public static final String COLUMN_TYPE = "Type";
    private static final String historyCreate = "create table "+ TABLE_HISTORY +" ("+
            COLUMN_ID +" integer primary key autoincrement, " +
            COLUMN_ROLLNUMBER +" text not null, "+
            COLUMN_ITEM +" text not null, " +
            COLUMN_TIME +" text not null, " +
            COLUMN_DATE +" text not null, " +
            COLUMN_TYPE +" text not null);";
    public MySQLiteHelper(Context context){
        super(context,databaseName,null,databaseVersion);
    }
    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL(historyCreate);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        Log.w("Upgraded","Upgraded");
        onCreate(db);
    }

}
