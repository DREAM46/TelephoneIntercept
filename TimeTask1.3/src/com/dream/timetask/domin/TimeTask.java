package com.dream.timetask.domin;

/**
 * ���о���������ĸ��࣬��Ա��������id�ţ���ʼʱ�䣬��Ҫ���ڼ̳�
 * 
 * @author ������
 * 
 */
public class TimeTask {

	protected int _id;
	protected int startHour;
	protected int startMinute;

	public TimeTask() {
		super();
	}

	public TimeTask(int startHour, int startMinute) {
		this.startHour = startHour;
		this.startMinute = startMinute;
	}

	public void set_id(int _id) {
		this._id = _id;
	}

	public int get_id() {
		return _id;
	}

	public void setStartHour(int startHour) {
		this.startHour = startHour;
	}

	public int getStartHour() {
		return startHour;
	}

	public int getStartMinute() {
		return startMinute;
	}

	public void setStartMinute(int startMinute) {
		this.startMinute = startMinute;
	}

}
