package com.dream.timetask.db;

/**
 * ���ݿ���Ϣ�࣬�������ݿ���������ݿ�汾�š����ݿ�������������������
 * 
 * @author ������
 * 
 */
public class DBInfo {

	public static class DB {

		/**
		 * ���ݿ�����
		 */
		public static final String DB_NAME = "TimeTask.db";

		/**
		 * ���ݿ�汾
		 */
		public static final int VERSION = 1;

	}

	public static class Table {

		/**
		 * ���������
		 */
		public static final String TASK_TABLE = "TimeTask";

		/**
		 * ����
		 */
		public static final String _ID = "_id";

		/**
		 * ����ʼʱ��Сʱ
		 */
		public static final String START_HOUR = "startHour";

		/**
		 * ����ʼʱ�����
		 */
		public static final String START_MINUTE = "startMinute";

		/**
		 * �������ʱ��Сʱ
		 */
		public static final String END_HOUR = "endHour";

		/**
		 * �������ʱ�����
		 */
		public static final String END_MINUTE = "endMinute";

		/**
		 * �ظ�ʱ��
		 */
		public static final String REPET = "repet";

		/**
		 * ��������
		 */
		public static final String CREATE_USER_TABLE = "create table "
				+ TASK_TABLE + "(" + _ID
				+ " integer primary key autoincrement," + START_HOUR
				+ " integer," + START_MINUTE + " integer," + END_HOUR
				+ " integer," + END_MINUTE + " integer," + REPET + " integer"
				+ ");";

	}

}
