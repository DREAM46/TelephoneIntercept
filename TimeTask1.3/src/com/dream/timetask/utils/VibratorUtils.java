package com.dream.timetask.utils;

import android.app.Service;
import android.content.Context;
import android.os.Vibrator;

/**
 * �ֻ��񶯹�����
 * 
 * @author ������
 * 
 */
public class VibratorUtils {
	/**
	 * �ֻ���
	 * 
	 * @param context
	 */
	public static void vibrator(Context context) {
		Vibrator vibrator = (Vibrator) context
				.getSystemService(Service.VIBRATOR_SERVICE);
		vibrator.vibrate(1500);
	}
}
