package com.dream.timetask.boot;

import java.util.Iterator;
import java.util.List;

import com.dream.timetask.dao.TimeTaskDao;
import com.dream.timetask.domin.InterceptTask;
import com.dream.timetask.utils.TaskUtils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;

public class BootReceiver extends BroadcastReceiver {

	private TimeTaskDao dao;

	@Override
	public void onReceive(Context context, Intent intent) {
		System.out.println("boot receiver");
		
		dao = new TimeTaskDao(context);
		
		new LoadTask(context).execute();
	}

	private class LoadTask extends AsyncTask<Void, Void, List<InterceptTask>> {

		private Context context;

		public LoadTask(Context context) {
			this.context = context;
		}

		@Override
		protected List<InterceptTask> doInBackground(Void... params) {
			return dao.findAll();
		}

		@Override
		protected void onPostExecute(List<InterceptTask> tasks) {
			// TODO Auto-generated method stub
			super.onPostExecute(tasks);
			for (Iterator<InterceptTask> iterator = tasks.iterator(); iterator
					.hasNext();) {

				InterceptTask task = iterator.next();
				task.toString();
				
				isNow(task);

				TaskUtils.setStartAndEndAlarm(context, task);
			}
		}

		/**
		 * �ж��ǲ���������������
		 * 
		 * @param task
		 *            �������
		 */
		private void isNow(InterceptTask task) {
			if (TaskUtils.isNow(task))
				TaskUtils.startTask(context);
		}

	}

}
