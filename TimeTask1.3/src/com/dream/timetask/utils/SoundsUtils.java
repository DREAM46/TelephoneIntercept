package com.dream.timetask.utils;

import com.dream.timetask.MainActivity;

import android.content.Context;
import android.media.AudioManager;

/**
 * ���ƾ�����Ǿ���
 * 
 * @author ������
 * 
 */
public class SoundsUtils {

	/**
	 * �����豸�����ظ�����
	 */
	public static void setNormal(Context context) {
		AudioManager manager = (AudioManager) context
				.getSystemService(Context.AUDIO_SERVICE);
		manager.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
		NotificationUtils.notify1(context, "�رվ���");
		VibratorUtils.vibrator(context);
		MainActivity.isIntercept = false;
	}

	/**
	 * �����豸����
	 */
	public static void setSilent(Context context) {
		AudioManager manager = (AudioManager) context
				.getSystemService(Context.AUDIO_SERVICE);
		manager.setRingerMode(AudioManager.RINGER_MODE_SILENT);
		NotificationUtils.notify1(context, "��������");
		VibratorUtils.vibrator(context);
		MainActivity.isIntercept = true;
	}

}
