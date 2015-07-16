package com.dream.timetask.dao;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.dream.timetask.db.DBInfo;
import com.dream.timetask.db.TimeTaskDBOpenHelper;
import com.dream.timetask.domin.TimeTask;
import com.dream.timetask.domin.InterceptTask;

/**
 * ���ݿ�DAO������
 * 
 * @author ������
 * 
 */
public class TimeTaskDao {

	private TimeTaskDBOpenHelper helper;

	public TimeTaskDao(Context context) {
		this.helper = new TimeTaskDBOpenHelper(context);
	}

	/**
	 * �����ݿ��в���һ��TimeTask��¼
	 * 
	 * @param task
	 *            Ҫ�����TimeTask��¼
	 * @return ���������TimeTask��¼��id��
	 */
	public long insert(TimeTask task1) {
		long _id = -1;

		SQLiteDatabase db = openDB();
		ContentValues values = new ContentValues();

		if (task1 instanceof InterceptTask) {
			InterceptTask task = (InterceptTask) task1;
			values.put(DBInfo.Table.START_HOUR, task.getStartHour());
			values.put(DBInfo.Table.START_MINUTE, task.getStartMinute());
			values.put(DBInfo.Table.END_HOUR, task.getEndHour());
			values.put(DBInfo.Table.END_MINUTE, task.getEndMinute());
			values.put(DBInfo.Table.REPET, task.getRepet());
		}

		_id = db.insert(DBInfo.Table.TASK_TABLE, null, values);

		processDBLast(db);

		return _id;
	}

	/**
	 * ��ѯ���ݿ�������TimeTask
	 * 
	 * @return TimeTask����
	 */
	public List<InterceptTask> findAll() {
		List<InterceptTask> tasks = new ArrayList<InterceptTask>();
		SQLiteDatabase db = helper.getReadableDatabase();

		Cursor cursor = db.query(DBInfo.Table.TASK_TABLE, null, null, null,
				null, null, null);

		int indexOfId = cursor.getColumnIndex(DBInfo.Table._ID);
		int indexOfStartHour = cursor.getColumnIndex(DBInfo.Table.START_HOUR);
		int indexOfStartMin = cursor.getColumnIndex(DBInfo.Table.START_MINUTE);
		int indexOfEndHour = cursor.getColumnIndex(DBInfo.Table.END_HOUR);
		int indexOfEndMin = cursor.getColumnIndex(DBInfo.Table.END_MINUTE);
		int indexOfRepet = cursor.getColumnIndex(DBInfo.Table.REPET);

		while (cursor.moveToNext()) {

			if (indexOfRepet != -1) {
				InterceptTask task = new InterceptTask();
				task.set_id(cursor.getInt(indexOfId));
				task.setStartHour(cursor.getInt(indexOfStartHour));
				task.setStartMinute(cursor.getInt(indexOfStartMin));
				task.setEndHour(cursor.getInt(indexOfEndHour));
				task.setEndMinute(cursor.getInt(indexOfEndMin));
				task.setRepet(cursor.getInt(indexOfRepet));
				tasks.add(task);
			}
		}
		cursor.close();
		db.close();
		return tasks;
	}

	/**
	 * ɾ�����ݿ��е�����TimeTask
	 */
	public void deleteAll() {
		SQLiteDatabase db = openDB();
		db.delete(DBInfo.Table.TASK_TABLE, null, null);
		processDBLast(db);
	}

	/**
	 * �����ݿ�
	 * 
	 * @return SQLiteDataBase
	 */
	private SQLiteDatabase openDB() {
		SQLiteDatabase db = helper.getWritableDatabase();
		db.beginTransaction();
		return db;
	}

	/**
	 * ���ݿ�ִ����β�������ر����ݿ�,��������ɹ�����������Ȳ���
	 * 
	 * @param db
	 *            ���ݿ����
	 */
	private void processDBLast(SQLiteDatabase db) {
		db.setTransactionSuccessful();
		db.endTransaction();
		db.close();
	}

}
