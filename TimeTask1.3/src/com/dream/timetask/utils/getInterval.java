package com.dream.timetask.utils;

import java.util.Calendar;

import android.app.AlarmManager;

/**
 * ��ȡӦ�ù��೤ʱ���Ҫ�������ӣ���Ϊ27���������
 * 
 * @author ������
 * 
 */
public class getInterval {

	public static long get(int day, int hour, int min) {
		
		Calendar calendar = Calendar.getInstance();

		int curDay = calendar.get(Calendar.DAY_OF_WEEK);
		int curHour = calendar.get(Calendar.HOUR_OF_DAY);
		int curMin = calendar.get(Calendar.MINUTE);

		int dayMin = day - curDay;
		int hourMin = hour - curHour;
		int minMin = min - curMin;

		if (dayMin == 0 && hourMin == 0 && minMin == 0)
			return 0;

		// 1�����������
		if (dayMin == 0) {
			// 1.1��Сʱ����ͬ����������ͬ
			if (hourMin == 0) {
				// 1.1.1�����Ӳ�����ڵ�С��˵��ʱ���ѹ���ֻ�ܵ���һ����
				if (minMin < 0) {
					dayMin = 6;
					hourMin = 23;
					minMin += 60;
					// 1.1.2�������������ڵĴ�˵��ʱ��δ�������켴��ʵ��
				} else if (minMin > 0) {
					dayMin = 0;
					hourMin = 0;
				}
			}// 1.2�����Сʱ�������ڴ�˵��ʱ��δ��
			else if (hourMin > 0) {
				dayMin = 0;
				if (minMin < 0) {
					hourMin--;
					minMin += 60;
				}
				// 1.3���Сʱ��������С��˵��ʱ���ѹ���ֻ�ܵ��¸�����
			} else if (hourMin < 0) {
				dayMin = 6;
				hourMin += 24;
				if (minMin < 0) {
					hourMin--;
					minMin += 60;
				}
			}
			// 2����������������ڴ�˵��ʱ��δ�������Եȴ�
		} else if (dayMin > 0) {
			// 2.1��Сʱ�������ڴ�����
			if (hourMin == 0) {
				// 2.1.1������������С�����
				if (minMin < 0) {
					dayMin--;
					hourMin = 23;
					minMin += 60;
				}
			} // 2.2 Сʱ��������С�����
			else if (hourMin > 0) {
				if (minMin < 0) {
					hourMin--;
					minMin += 60;
				}

			}// 2.3Сʱ��������С�����
			else if (hourMin < 0) {
				dayMin--;
				hourMin += 24;
				if (minMin < 0) {
					hourMin--;
					minMin += 60;
				}
			}
			// 3������������С
		} else if (dayMin < 0) {
			dayMin += 7;
			// 3.1Сʱ�����
			if (hourMin == 0) {
				// 3.1��������������С
				if (minMin < 0) {
					dayMin--;
					hourMin = 23;
					minMin += 60;
				}

			} // 3.2��Сʱ�������ڴ�
			else if (hourMin > 0) {
				if (minMin < 0) {
					hourMin--;
					minMin += 60;
				}
			}// 3.3��Сʱ��������С
			else if (hourMin < 0) {
				dayMin--;
				hourMin += 24;
				if (minMin < 0) {
					dayMin--;
					hourMin--;
					minMin += 60;
				}
			}
		}

		long mill = dayMin * AlarmManager.INTERVAL_DAY + hourMin
				* AlarmManager.INTERVAL_HOUR + minMin * (60 * 1000)
				- calendar.get(Calendar.SECOND) * 1000;
		return mill;
	}

}
