package com.dream.timetask.domin;

/**
 * ���ŷ���������
 * 
 * @author ������
 * 
 */
public class SmsTask extends TimeTask {

	public String content;

	public SmsTask(int startHour, int startMinute, String content) {
		super(startHour, startMinute);
		this.content = content;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
