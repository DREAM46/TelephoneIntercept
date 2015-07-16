package com.dream.timetask.utils;

import android.content.Context;
import android.database.Cursor;
import android.provider.ContactsContract;

/**
 * ͨѶ¼������
 * 
 * @author ������
 * 
 */
public class ContactUtils {

	/**
	 * ���ݵ绰����ȡ����ϵ������
	 */
	public static String getContactNameByPhoneNumber(Context context,
			String address) {
		String[] projection = { ContactsContract.PhoneLookup.DISPLAY_NAME,
				ContactsContract.CommonDataKinds.Phone.NUMBER };

		// ���Լ���ӵ� msPeers ��
		Cursor cursor = context.getContentResolver().query(
				ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
				projection,
				ContactsContract.CommonDataKinds.Phone.NUMBER + " = '"
						+ address + "'", null, null);

		if (cursor == null) {
			return "";
		}
		for (int i = 0; i < cursor.getCount(); i++) {
			cursor.moveToPosition(i);

			// ȡ����ϵ������
			int nameFieldColumnIndex = cursor
					.getColumnIndex(ContactsContract.PhoneLookup.DISPLAY_NAME);
			String name = cursor.getString(nameFieldColumnIndex);
			return name;
		}
		return "";
	}

}
