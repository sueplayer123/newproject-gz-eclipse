package com.example.bottommenu_vp_imgv_tv.fragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.bottommenu_vp_imgv_tv.PingjiaActivity;
import com.example.bottommenu_vp_imgv_tv.R;
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

	private String[] names = new String[] { "程启忠", "杨红伟", "张世煌", "吴东槐", "毛振海", "张豪", "韩强", "黄小军", "陈锦涛", "潘海涛", "周志标",
			"曲少军", "崔海伟", "马爱光", "顾元利", "孔庆江", "向青松", "刘广田", "杨俊昌", "芦青海", "刘云云", "蔡昶", "薛滨", "侯永杰", "黄建国", "邵明汝",
			"朱跃华", "王勇", "田巍", "刘伟", "齐建华", "宁志海", "葛建军", "白松", "丁建强", "张秀会", "杨振涛", "郭成云", "苏超" };
	private String[] descs = new String[] { "变压器设计制造", "变电站故障处理", "变电开关", "线路设计及故障处理", "线路设计及故障处理", "变电二次系统", "变电二次系统",
			"变电开关", "变电二次系统", "变电二次系统", "变电站故障处理", "高压试验", "变电二次系统", "线路故障处理", "线路故障分析", "线路故障处理", "变电站故障处理", "变电站故障处理",
			"变电开关", "变电站故障处理", "变电站故障处理", "变电站故障处理", "线路设计及故障处理", "电网运行、继电保护", "继电保护", "继电保护", "变电站故障处理", "高压电气试验",
			"变电二次系统", "低压配电", "配网运行", "低压配电", "低压配电", "电网运行、继电保护", "电网运行、变电站故障处理", "继电保护", "继电保护、计算机故障", "电网经济运行、电能计量",
			"计算机软硬件系统" };

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
					intent.putExtra("xinxi1", names[0]);
					intent.putExtra("xinxi2", descs[0]);
					intent.putExtra("telphone", "18632739220");
					startActivity(intent);
					break;
				case 1:
					Intent intent1 = new Intent(getActivity(), zhuanjia.class);
					intent1.putExtra("xinxi1", names[1]);
					intent1.putExtra("xinxi2", descs[1]);
					intent1.putExtra("telphone", "15803273829");
					startActivity(intent1);
					break;
				case 2:
					Intent intent2 = new Intent(getActivity(), zhuanjia.class);
					intent2.putExtra("xinxi1", names[2]);
					intent2.putExtra("xinxi2", descs[2]);
					intent2.putExtra("telphone", "13473731830");
					startActivity(intent2);
					break;
				case 3:
					Intent intent3 = new Intent(getActivity(), zhuanjia.class);
					intent3.putExtra("xinxi1", names[3]);
					intent3.putExtra("xinxi2", descs[3]);
					intent3.putExtra("telphone", "13463738269");
					startActivity(intent3);
					break;
				case 4:
					Intent intent4 = new Intent(getActivity(), zhuanjia.class);
					intent4.putExtra("xinxi1", names[4]);
					intent4.putExtra("xinxi2", descs[4]);
					intent4.putExtra("telphone", "13582761698");
					startActivity(intent4);
					break;
				case 5:
					Intent intent5 = new Intent(getActivity(), zhuanjia.class);
					intent5.putExtra("xinxi1", names[5]);
					intent5.putExtra("xinxi2", descs[5]);
					intent5.putExtra("telphone", "18531723100");
					startActivity(intent5);
					break;
				case 6:
					Intent intent6 = new Intent(getActivity(), zhuanjia.class);
					intent6.putExtra("xinxi1", names[6]);
					intent6.putExtra("xinxi2", descs[6]);
					intent6.putExtra("telphone", "15803273896");
					startActivity(intent6);
					break;
				case 7:
					Intent intent7 = new Intent(getActivity(), zhuanjia.class);
					intent7.putExtra("xinxi1", names[7]);
					intent7.putExtra("xinxi2", descs[7]);
					intent7.putExtra("telphone", "15831778208");
					startActivity(intent7);
					break;
				case 8:
					Intent intent8 = new Intent(getActivity(), zhuanjia.class);
					intent8.putExtra("xinxi1", names[8]);
					intent8.putExtra("xinxi2", descs[8]);
					intent8.putExtra("telphone", "15930798452");
					startActivity(intent8);
					break;
				case 9:
					Intent intent9 = new Intent(getActivity(), zhuanjia.class);
					intent9.putExtra("xinxi1", names[9]);
					intent9.putExtra("xinxi2", descs[9]);
					intent9.putExtra("telphone", "13102730033");
					startActivity(intent9);
					break;
				case 10:
					Intent intent10 = new Intent(getActivity(), zhuanjia.class);
					intent10.putExtra("xinxi1", names[10]);
					intent10.putExtra("xinxi2", descs[10]);
					intent10.putExtra("telphone", "13131770778");
					startActivity(intent10);
					break;
				case 11:
					Intent intent11 = new Intent(getActivity(), zhuanjia.class);
					intent11.putExtra("xinxi1", names[11]);
					intent11.putExtra("xinxi2", descs[11]);
					intent11.putExtra("telphone", "13931757914");
					startActivity(intent11);
					break;
				case 12:
					Intent intent12 = new Intent(getActivity(), zhuanjia.class);
					intent12.putExtra("xinxi1", names[12]);
					intent12.putExtra("xinxi2", descs[12]);
					intent12.putExtra("telphone", "13582762681");
					startActivity(intent12);
					break;
				case 13:
					Intent intent13 = new Intent(getActivity(), zhuanjia.class);
					intent13.putExtra("xinxi1", names[13]);
					intent13.putExtra("xinxi2", descs[13]);
					intent13.putExtra("telphone", "13231719007");
					startActivity(intent13);
					break;
				case 14:
					Intent intent14 = new Intent(getActivity(), zhuanjia.class);
					intent14.putExtra("xinxi1", names[14]);
					intent14.putExtra("xinxi2", descs[14]);
					intent14.putExtra("telphone", "15841515127");
					startActivity(intent14);
					break;
				case 15:
					Intent intent15 = new Intent(getActivity(), zhuanjia.class);
					intent15.putExtra("xinxi1", names[15]);
					intent15.putExtra("xinxi2", descs[15]);
					intent15.putExtra("telphone", "15803273630");
					startActivity(intent15);
					break;
				case 16:
					Intent intent16 = new Intent(getActivity(), zhuanjia.class);
					intent16.putExtra("xinxi1", names[16]);
					intent16.putExtra("xinxi2", descs[16]);
					intent16.putExtra("telphone", "13102736315");
					startActivity(intent16);
					break;
				case 17:
					Intent intent17 = new Intent(getActivity(), zhuanjia.class);
					intent17.putExtra("xinxi1", names[17]);
					intent17.putExtra("xinxi2", descs[17]);
					intent17.putExtra("telphone", "18632732827");
					startActivity(intent17);
					break;
				case 18:
					Intent intent18 = new Intent(getActivity(), zhuanjia.class);
					intent18.putExtra("xinxi1", names[18]);
					intent18.putExtra("xinxi2", descs[18]);
					intent18.putExtra("telphone", "18632762750");
					startActivity(intent18);
					break;
				case 19:
					Intent intent19 = new Intent(getActivity(), zhuanjia.class);
					intent19.putExtra("xinxi1", names[19]);
					intent19.putExtra("xinxi2", descs[19]);
					intent19.putExtra("telphone", "13703172034");
					startActivity(intent19);
					break;
				case 20:
					Intent intent20 = new Intent(getActivity(), zhuanjia.class);
					intent20.putExtra("xinxi1", names[20]);
					intent20.putExtra("xinxi2", descs[20]);
					intent20.putExtra("telphone", "15231782553");
					startActivity(intent20);
					break;
				case 21:
					Intent intent21 = new Intent(getActivity(), zhuanjia.class);
					intent21.putExtra("xinxi1", names[21]);
					intent21.putExtra("xinxi2", descs[21]);
					intent21.putExtra("telphone", "13784750300");
					startActivity(intent21);
					break;
				case 22:
					Intent intent22 = new Intent(getActivity(), zhuanjia.class);
					intent22.putExtra("xinxi1", names[22]);
					intent22.putExtra("xinxi2", descs[22]);
					intent22.putExtra("telphone", "15803273898");
					startActivity(intent22);
					break;
				case 23:
					Intent intent23 = new Intent(getActivity(), zhuanjia.class);
					intent23.putExtra("xinxi1", names[23]);
					intent23.putExtra("xinxi2", descs[23]);
					intent23.putExtra("telphone", "13582764405");
					startActivity(intent23);
					break;
				case 24:
					Intent intent24 = new Intent(getActivity(), zhuanjia.class);
					intent24.putExtra("xinxi1", names[24]);
					intent24.putExtra("xinxi2", descs[24]);
					intent24.putExtra("telphone", "15028752072");
					startActivity(intent24);
					break;
				case 25:
					Intent intent25 = new Intent(getActivity(), zhuanjia.class);
					intent25.putExtra("xinxi1", names[25]);
					intent25.putExtra("xinxi2", descs[25]);
					intent25.putExtra("telphone", "13633171226");
					startActivity(intent25);
					break;
				case 26:
					Intent intent26 = new Intent(getActivity(), zhuanjia.class);
					intent26.putExtra("xinxi1", names[26]);
					intent26.putExtra("xinxi2", descs[26]);
					intent26.putExtra("telphone", "13785739783");
					startActivity(intent26);
					break;
				case 27:
					Intent intent27 = new Intent(getActivity(), zhuanjia.class);
					intent27.putExtra("xinxi1", names[27]);
					intent27.putExtra("xinxi2", descs[27]);
					intent27.putExtra("telphone", "15132716200");
					startActivity(intent27);
					break;
				case 28:
					Intent intent28 = new Intent(getActivity(), zhuanjia.class);
					intent28.putExtra("xinxi1", names[28]);
					intent28.putExtra("xinxi2", descs[28]);
					intent28.putExtra("telphone", "15803273705");
					startActivity(intent28);
					break;
				case 29:
					Intent intent29 = new Intent(getActivity(), zhuanjia.class);
					intent29.putExtra("xinxi1", names[29]);
					intent29.putExtra("xinxi2", descs[29]);
					intent29.putExtra("telphone", "13831777568");
					startActivity(intent29);
					break;
				case 30:
					Intent intent30 = new Intent(getActivity(), zhuanjia.class);
					intent30.putExtra("xinxi1", names[30]);
					intent30.putExtra("xinxi2", descs[30]);
					intent30.putExtra("telphone", "15075751291");
					startActivity(intent30);
					break;
				case 31:
					Intent intent31 = new Intent(getActivity(), zhuanjia.class);
					intent31.putExtra("xinxi1", names[31]);
					intent31.putExtra("xinxi2", descs[31]);
					intent31.putExtra("telphone", "13932734868");
					startActivity(intent31);
					break;
				case 32:
					Intent intent32 = new Intent(getActivity(), zhuanjia.class);
					intent32.putExtra("xinxi1", names[32]);
					intent32.putExtra("xinxi2", descs[32]);
					intent32.putExtra("telphone", "13930763033");
					startActivity(intent32);
					break;
				case 33:
					Intent intent33 = new Intent(getActivity(), zhuanjia.class);
					intent33.putExtra("xinxi1", names[33]);
					intent33.putExtra("xinxi2", descs[33]);
					intent33.putExtra("telphone", "15231715919");
					startActivity(intent33);
					break;
				case 34:
					Intent intent34 = new Intent(getActivity(), zhuanjia.class);
					intent34.putExtra("xinxi1", names[34]);
					intent34.putExtra("xinxi2", descs[34]);
					intent34.putExtra("telphone", "13785751212");
					startActivity(intent34);
					break;
				case 35:
					Intent intent35 = new Intent(getActivity(), zhuanjia.class);
					intent35.putExtra("xinxi1", names[35]);
					intent35.putExtra("xinxi2", descs[35]);
					intent35.putExtra("telphone", "13483813440");
					startActivity(intent35);
					break;
				case 36:
					Intent intent36 = new Intent(getActivity(), zhuanjia.class);
					intent36.putExtra("xinxi1", names[36]);
					intent36.putExtra("xinxi2", descs[36]);
					intent36.putExtra("telphone", "13932749604");
					startActivity(intent36);
					break;
				case 37:
					Intent intent37 = new Intent(getActivity(), zhuanjia.class);
					intent37.putExtra("xinxi1", names[37]);
					intent37.putExtra("xinxi2", descs[37]);
					intent37.putExtra("telphone", "13931758305");
					startActivity(intent37);
					break;
				case 38:
					Intent intent38 = new Intent(getActivity(), zhuanjia.class);
					intent38.putExtra("xinxi1", names[38]);
					intent38.putExtra("xinxi2", descs[38]);
					intent38.putExtra("telphone", "13831746275");
					startActivity(intent38);
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
				case 2:
					Intent intent2 = new Intent(getActivity(), PingjiaActivity.class);
					intent2.putExtra("namestring", names[2]);
					startActivity(intent2);
					break;
				case 3:
					Intent intent3 = new Intent(getActivity(), PingjiaActivity.class);
					intent3.putExtra("namestring", names[3]);
					startActivity(intent3);
					break;
				case 4:
					Intent intent4 = new Intent(getActivity(), PingjiaActivity.class);
					intent4.putExtra("namestring", names[4]);
					startActivity(intent4);
					break;
				case 5:
					Intent intent5 = new Intent(getActivity(), PingjiaActivity.class);
					intent5.putExtra("namestring", names[5]);
					startActivity(intent5);
					break;
				case 6:
					Intent intent6 = new Intent(getActivity(), PingjiaActivity.class);
					intent6.putExtra("namestring", names[6]);
					startActivity(intent6);
					break;
				case 7:
					Intent intent7 = new Intent(getActivity(), PingjiaActivity.class);
					intent7.putExtra("namestring", names[7]);
					startActivity(intent7);
					break;
				case 8:
					Intent intent8 = new Intent(getActivity(), PingjiaActivity.class);
					intent8.putExtra("namestring", names[8]);
					startActivity(intent8);
					break;
				case 9:
					Intent intent9 = new Intent(getActivity(), PingjiaActivity.class);
					intent9.putExtra("namestring", names[9]);
					startActivity(intent9);
					break;
				case 10:
					Intent intent10 = new Intent(getActivity(), PingjiaActivity.class);
					intent10.putExtra("namestring", names[10]);
					startActivity(intent10);
					break;
				case 11:
					Intent intent11 = new Intent(getActivity(), PingjiaActivity.class);
					intent11.putExtra("namestring", names[11]);
					startActivity(intent11);
					break;
				case 12:
					Intent intent12 = new Intent(getActivity(), PingjiaActivity.class);
					intent12.putExtra("namestring", names[12]);
					startActivity(intent12);
					break;
				case 13:
					Intent intent13 = new Intent(getActivity(), PingjiaActivity.class);
					intent13.putExtra("namestring", names[13]);
					startActivity(intent13);
					break;
				case 14:
					Intent intent14 = new Intent(getActivity(), PingjiaActivity.class);
					intent14.putExtra("namestring", names[14]);
					startActivity(intent14);
					break;
				case 15:
					Intent intent15 = new Intent(getActivity(), PingjiaActivity.class);
					intent15.putExtra("namestring", names[15]);
					startActivity(intent15);
					break;
				case 16:
					Intent intent16 = new Intent(getActivity(), PingjiaActivity.class);
					intent16.putExtra("namestring", names[16]);
					startActivity(intent16);
					break;
				case 17:
					Intent intent17 = new Intent(getActivity(), PingjiaActivity.class);
					intent17.putExtra("namestring", names[17]);
					startActivity(intent17);
					break;
				case 18:
					Intent intent18 = new Intent(getActivity(), PingjiaActivity.class);
					intent18.putExtra("namestring", names[18]);
					startActivity(intent18);
					break;
				case 19:
					Intent intent19 = new Intent(getActivity(), PingjiaActivity.class);
					intent19.putExtra("namestring", names[19]);
					startActivity(intent19);
					break;
				case 20:
					Intent intent20 = new Intent(getActivity(), PingjiaActivity.class);
					intent20.putExtra("namestring", names[20]);
					startActivity(intent20);
					break;
				case 21:
					Intent intent21 = new Intent(getActivity(), PingjiaActivity.class);
					intent21.putExtra("namestring", names[21]);
					startActivity(intent21);
					break;
				case 22:
					Intent intent22 = new Intent(getActivity(), PingjiaActivity.class);
					intent22.putExtra("namestring", names[22]);
					startActivity(intent22);
					break;
				case 23:
					Intent intent23 = new Intent(getActivity(), PingjiaActivity.class);
					intent23.putExtra("namestring", names[23]);
					startActivity(intent23);
					break;
				case 24:
					Intent intent24 = new Intent(getActivity(), PingjiaActivity.class);
					intent24.putExtra("namestring", names[24]);
					startActivity(intent24);
					break;
				case 25:
					Intent intent25 = new Intent(getActivity(), PingjiaActivity.class);
					intent25.putExtra("namestring", names[25]);
					startActivity(intent25);
					break;
				case 26:
					Intent intent26 = new Intent(getActivity(), PingjiaActivity.class);
					intent26.putExtra("namestring", names[26]);
					startActivity(intent26);
					break;
				case 27:
					Intent intent27 = new Intent(getActivity(), PingjiaActivity.class);
					intent27.putExtra("namestring", names[27]);
					startActivity(intent27);
					break;
				case 28:
					Intent intent28 = new Intent(getActivity(), PingjiaActivity.class);
					intent28.putExtra("namestring", names[28]);
					startActivity(intent28);
					break;
				case 29:
					Intent intent29 = new Intent(getActivity(), PingjiaActivity.class);
					intent29.putExtra("namestring", names[29]);
					startActivity(intent29);
					break;
				case 30:
					Intent intent30 = new Intent(getActivity(), PingjiaActivity.class);
					intent30.putExtra("namestring", names[30]);
					startActivity(intent30);
					break;
				case 31:
					Intent intent31 = new Intent(getActivity(), PingjiaActivity.class);
					intent31.putExtra("namestring", names[31]);
					startActivity(intent31);
					break;
				case 32:
					Intent intent32 = new Intent(getActivity(), PingjiaActivity.class);
					intent32.putExtra("namestring", names[32]);
					startActivity(intent32);
					break;
				case 33:
					Intent intent33 = new Intent(getActivity(), PingjiaActivity.class);
					intent33.putExtra("namestring", names[33]);
					startActivity(intent33);
					break;
				case 34:
					Intent intent34 = new Intent(getActivity(), PingjiaActivity.class);
					intent34.putExtra("namestring", names[34]);
					startActivity(intent34);
					break;
				case 35:
					Intent intent35 = new Intent(getActivity(), PingjiaActivity.class);
					intent35.putExtra("namestring", names[35]);
					startActivity(intent35);
					break;
				case 36:
					Intent intent36 = new Intent(getActivity(), PingjiaActivity.class);
					intent36.putExtra("namestring", names[36]);
					startActivity(intent36);
					break;
				case 37:
					Intent intent37 = new Intent(getActivity(), PingjiaActivity.class);
					intent37.putExtra("namestring", names[37]);
					startActivity(intent37);
					break;
				case 38:
					Intent intent38 = new Intent(getActivity(), PingjiaActivity.class);
					intent38.putExtra("namestring", names[38]);
					startActivity(intent38);
					break;

				default:
					break;
				}
				return false;
			}
		});
	}

}
