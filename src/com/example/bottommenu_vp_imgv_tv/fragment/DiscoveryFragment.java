package com.example.bottommenu_vp_imgv_tv.fragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.bottommenu_vp_imgv_tv.PingjiaActivity;
import com.example.bottommenu_vp_imgv_tv.R;
import com.example.bottommenu_vp_imgv_tv.Zhuanjia1Activity;
import com.example.bottommenu_vp_imgv_tv.zhuanjia;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class DiscoveryFragment extends Fragment {
	private ListView list_view;

	private String[] names = new String[] { "����", "����", "����", "����", "�ڻ�", "����", "����", "����", "��", "����", "����", "����",
			"����", "С��", "����", "����" };
	private String[] descs = new String[] { "�̵籣��", "���λ�·", "�ߵ�ѹ", "��Ե����", "������·", "�ӵ�װ��", "��ŵ����", "���ƻ�·", "���ϴ���",
			"����ͨѶ", "��������", "���μ���", "��ѹ������", "�ŵ���", "����", "���վ����" };

	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
			@Nullable Bundle savedInstanceState) {
		View view = View.inflate(getActivity(), R.layout.fragment_discovery, null);
		return view;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		list_view = (ListView) getActivity().findViewById(R.id.list_view);
		List<Map<String, Object>> listItems = new ArrayList<Map<String, Object>>();
		for (int i = 0; i < names.length; i++) {
			Map<String, Object> listItem = new HashMap<String, Object>();

			listItem.put("personname", names[i]);
			listItem.put("descs", descs[i]);
			listItems.add(listItem);
		}
		SimpleAdapter simpleAdapter = new SimpleAdapter(getActivity(), listItems, R.layout.simple_item,
				new String[] { "personname", "descs" }, new int[] { R.id.name, R.id.desc });
		list_view.setAdapter(simpleAdapter);
		list_view.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				switch (position) {
				case 0:
					Intent intent = new Intent(getActivity(), zhuanjia.class);
					startActivity(intent);
					break;
				case 1:
					Intent intent1 = new Intent(getActivity(), Zhuanjia1Activity.class);
					startActivity(intent1);
					break;
				default:
					break;
				}
			}
		});
		list_view.setOnItemLongClickListener(new OnItemLongClickListener() {

			@Override
			public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

				switch (position) {
				case 0:
					Intent intent = new Intent(getActivity(), PingjiaActivity.class);
					intent.putExtra("namestring", names[0]);
					startActivity(intent);
					break;
				case 1:
					Intent intent1 = new Intent(getActivity(), PingjiaActivity.class);
					intent1.putExtra("namestring", names[1]);
					startActivity(intent1);
					break;
				default:
					break;
				}
				return false;
			}
		});
	}

}
