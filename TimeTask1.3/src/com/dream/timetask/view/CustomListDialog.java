package com.dream.timetask.view;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;

import com.dream.timetask.R;

/**
 * �Զ���List�Ի�����
 * 
 * @author ������
 * 
 */
public class CustomListDialog extends Dialog implements
		android.view.View.OnClickListener, OnItemClickListener {

	private Context context;
	private int mPosition = -1;// �ϴ�ѡ�е�λ��
	private ArrayList<HashMap<String, Object>> arrayList;
	private String item;
	private ListDialogAdapter mAdapter;

	private TextView view;

	public CustomListDialog(Context context, String[] items, TextView view) {
		super(context, R.style.dialo_style);

		setContentView(R.layout.view_radiobutton_dialog);

		this.context = context;
		this.view = view;

		arrayList = new ArrayList<HashMap<String, Object>>();

		// ��ʼ��ArrayList���ϸ����Ƿ�ѡ�е�״̬
		for (int i = 0; i < items.length; i++) {
			HashMap<String, Object> hashMap = new HashMap<String, Object>();
			hashMap.put("item", items[i]);
			hashMap.put("checked", false);
			arrayList.add(hashMap);
		}

		// ��ʼ��ListView����ΪListView��������
		ListView listView = (ListView) this
				.findViewById(R.id.view_lv_radioButton);
		mAdapter = new ListDialogAdapter(context, arrayList);
		listView.setAdapter(mAdapter);

		listView.setOnItemClickListener(this);
	}

	/**
	 * ���öԻ��������
	 * 
	 * @param title
	 *            �Ի������������
	 * @return �Ի�����
	 */
	public CustomListDialog setTitle(String title) {
		TextView view_dialog_title = (TextView) this
				.findViewById(R.id.view_dialog_title);
		view_dialog_title.setText(title);
		return this;
	}

	@Override
	public void onClick(View v) {
		this.dismiss();
	}

	public String getItem() {
		return item;
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view1, int pPosition,
			long id) {
		// mPosition��Ϊ�ϴ�ѡ�е�������ظ�ѡ���򲻶�ListView���д���
		if (mPosition == pPosition) {
			this.dismiss();
			return;
		} else if (-1 != mPosition) {
			// ������ѡ�е���������ArrayList�д洢��״̬
			HashMap<String, Object> map = arrayList.get(mPosition);
			map.put("checked", false);
		}
		// ����ѡ�еĸ��Ǿ�ѡ�е�
		mPosition = pPosition;
		HashMap<String, Object> map = arrayList.get(mPosition);
		map.put("checked", true);
		// ȡ���������ĸ���ѡ��
		item = (String) map.get("item");
		view.setText(item);
		mAdapter.notifyDataSetChanged();
		this.dismiss();
	}

}
