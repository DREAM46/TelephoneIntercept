package com.dream.timetask.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * ʱ���������ݿ��openHelper
 * 
 * @author ������
 * 
 */
public class TimeTaskDBOpenHelper extends SQLiteOpenHelper {

	public TimeTaskDBOpenHelper(Context context) {
		super(context, DBInfo.DB.DB_NAME, null, DBInfo.DB.VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(DBInfo.Table.CREATE_USER_TABLE);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

	}

}
