package com.dream.timetask.utils;

/**
 * ������ʾ����
 * 
 * @author ������
 * 
 */
public class NumberUtils {

	/**
	 * ��ʽ���ַ�����һλ�������ֱ����λ��������ʮλ��λ+0
	 * 
	 * @param data
	 * @return ��ʽ������ַ���
	 */
	public static String formatNumber(int data) {
		if (data < 10)
			return "0" + data;
		return data + "";
	}
}
