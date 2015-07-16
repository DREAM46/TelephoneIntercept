package com.dream.timetask;

import java.util.Calendar;
import java.util.List;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.dream.timetask.dao.TimeTaskDao;
import com.dream.timetask.domin.InterceptTask;
import com.dream.timetask.utils.NumberUtils;
import com.dream.timetask.view.CustomProgressDialog;

/**
 * ���б����ʽ�г����е�ʱ������
 * 
 * @author ������
 * 
 */
public class ListAllTaskFragment extends ListFragment {

	private static ListAllTaskFragment instance;

	/**
	 * ����ListAllTaskFragment������
	 * 
	 * @return ListAllTaskFragment����
	 */
	public static ListAllTaskFragment getInstance() {
		if (instance == null)
			instance = new ListAllTaskFragment();
		return instance;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		new LoadTask().execute();
	}

	/**
	 * �첽�����ѯʱ���������ݿ��е�����
	 * 
	 * @author ������
	 * 
	 */
	private class LoadTask extends AsyncTask<Void, Void, List<InterceptTask>> {

		/**
		 * �Զ���Ľ��ȶԻ���
		 */
		private CustomProgressDialog dialog;

		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			dialog = new CustomProgressDialog(getActivity()).setMsg("��ȴ�");
			dialog.show();
		}

		@Override
		protected List<InterceptTask> doInBackground(Void... params) {
			return new TimeTaskDao(getActivity()).findAll();
		}

		@Override
		protected void onPostExecute(List<InterceptTask> result) {
			super.onPostExecute(result);
			dialog.dismiss();

			setListAdapter(new MyAdapter(result));
		}

	}

	@Override
	public void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
	}

	private class MyAdapter extends BaseAdapter {

		private List<InterceptTask> tasks;

		private MyAdapter(List<InterceptTask> tasks) {
			this.tasks = tasks;
		}

		@Override
		public int getCount() {
			return tasks.size();
		}

		@Override
		public Object getItem(int position) {
			return tasks.get(position);
		}

		@Override
		public long getItemId(int position) {
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			View view = null;

			if (convertView == null) {
				view = View
						.inflate(getActivity(), R.layout.view_listtask, null);
			} else {
				view = convertView;
			}

			InterceptTask task = tasks.get(position);

			TextView tv_task = (TextView) view.findViewById(R.id.tv_task);

			String day = null;

			switch (task.getRepet()) {
			case Calendar.SUNDAY:
				day = "������\t";
				break;
			case Calendar.MONDAY:
				day = "����һ\t";
				break;
			case Calendar.TUESDAY:
				day = "���ڶ�\t";
				break;
			case Calendar.WEDNESDAY:
				day = "������\t";
				break;
			case Calendar.THURSDAY:
				day = "������\t";
				break;
			case Calendar.FRIDAY:
				day = "������\t";
				break;
			case Calendar.SATURDAY:
				day = "������\t";
				break;
			}

			tv_task.setText(day + NumberUtils.formatNumber(task.getStartHour())
					+ ":" + NumberUtils.formatNumber(task.getStartMinute())
					+ " - " + NumberUtils.formatNumber(task.getEndHour()) + ":"
					+ NumberUtils.formatNumber(task.getEndMinute()));
			return view;
		}

	}

}
