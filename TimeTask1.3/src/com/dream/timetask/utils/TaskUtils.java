package com.dream.timetask.utils;

import java.util.Calendar;

import android.content.Context;

import com.dream.timetask.alarm.SetAlarm;
import com.dream.timetask.domin.InterceptTask;

/**
 * �������񹤾���
 * 
 * @author ������
 * 
 */
public class TaskUtils {
	/**
	 * ������ʼ�ͽ�������������
	 * 
	 * @param _id
	 *            ���������id��
	 * @param task
	 *            ��������Ķ���
	 */
	public static void setStartAndEndAlarm(Context context, long _id,
			InterceptTask task) {
		long startInterval = getInterval.get(task.getRepet(),
				task.getStartHour(), task.getStartMinute());

		long endInterval = getInterval.get(task.getRepet(), task.getEndHour(),
				task.getEndMinute());

		SetAlarm.set(context, startInterval, false, (int) _id);
		SetAlarm.set(context, endInterval, true, (int) _id);
	}

	/**
	 * ������ʼ�ͽ�������������
	 * 
	 * @param task
	 *            ��������Ķ���
	 */
	public static void setStartAndEndAlarm(Context context, InterceptTask task) {
		setStartAndEndAlarm(context, task.get_id(), task);
	}
	
	/**
	 * ��ʼ���񣬼�������Ϊ��������ģʽ�ҽ��豸��Ϊ����ģʽ
	 */
	public static void startTask(Context context) {
		SoundsUtils.setSilent(context);
	}
	
	/**
	 * �Ƿ�����Ӧ�ô��ھ���+���ص�״̬,�Ƿ����ھ�Ӧ������Ϊ����+������������
	 * 
	 * @return
	 */
	public static boolean isNow(InterceptTask task) {
		boolean isNow = false;
		Calendar calendar = Calendar.getInstance();

		if (calendar.get(Calendar.DAY_OF_WEEK) == task.getRepet()) {
			int hour = calendar.get(Calendar.HOUR_OF_DAY);
			int minute = calendar.get(Calendar.MINUTE);
			if (hour > task.getStartHour() && hour < task.getEndHour()) {
				isNow =  true;
			} else if (hour == task.getStartHour() && hour < task.getEndHour()) {
				if (minute > task.getStartMinute()
						|| minute == task.getStartMinute())
					isNow =  true;
			} else if (hour == task.getStartHour() && hour == task.getEndHour()) {
				if (minute == task.getStartMinute()
						|| (minute > task.getStartMinute() && minute < task
								.getEndMinute())) {
					isNow = true;
				}
			}
		}
		return isNow;
	}
}
