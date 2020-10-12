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

	private String[] names = new String[] { "张三", "李四", "王二", "麻子", "壁虎", "凯撒", "老罗", "韩寒", "柴静", "马云", "李彦", "老周",
			"朝阳", "小夏", "老王", "张磊" };
	private String[] descs = new String[] { "继电保护", "二次回路", "高电压", "绝缘材料", "电子线路", "接地装置", "充放电测试", "控制回路", "故障处理",
			"光纤通讯", "电气工程", "修饰检修", "变压器故障", "放电缆", "立杆", "变电站建设" };

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
