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

	private String[] names = new String[] { "������", "�����", "���ΰ", "������", "�ⶫ��", "ë��", "�ź�", "��ǿ", "��С��", "�½���", "�˺���",
			"��־��", "���پ�", "�޺�ΰ", "����", "��Ԫ��", "���콭", "������", "������", "���", "¬�ຣ", "������", "����", "Ѧ��", "������", "�ƽ���",
			"������", "��Ծ��", "����", "��Ρ", "��ΰ", "�뽨��", "��־��", "�𽨾�", "����", "����ǿ", "�����", "������", "����ǿ", "�봺Ӱ", "��ϣ��", "������",
			"�ճ�", "��ѩ��", "���Ӵ�" };
	private String[] descs = new String[] { "�����Ʒ�������", "�����Ʒ�������", "���վ���ϴ���", "��翪��", "��·��Ƽ����ϴ���", "��·��Ƽ����ϴ���",
			"������ϵͳ", "������ϵͳ", "��翪��", "������ϵͳ", "������ϵͳ", "���վ���ϴ���", "��ѹ����", "������ϵͳ", "��·���ϴ���", "��·���Ϸ���", "��·���ϴ���",
			"���վ���ϴ���", "���վ���ϴ���", "��翪��", "���վ���ϴ���", "���վ���ϴ���", "���վ���ϴ���", "��·��Ƽ����ϴ���", "�������С��̵籣��", "�̵籣��", "�̵籣��",
			"���վ���ϴ���", "��ѹ����", "������ϵͳ", "��ѹ���", "��������", "��ѹ���", "��ѹ���", "�������С��̵籣��", "�������С����վ���ϴ���", "�̵籣��",
			"�̵籣�������������", "�������С��̵籣��", "Զ��ͨ��", "���ܼ�������", "�����������С����ܼ���", "�������Ӳ��ϵͳ", "��·ʩ������������Ԥ�����", "������·���" };

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
					intent.putExtra("xinxi3", "��");
					intent.putExtra("xinxi4", "47��");
					intent.putExtra("xinxi5", "�����豸��");
					intent.putExtra("xinxi6", "�߹���һ����");
					intent.putExtra("telphone", "18632739220");
					startActivity(intent);
					break;
				case 1:
					Intent intent1 = new Intent(getActivity(), zhuanjia.class);
					intent1.putExtra("xinxi1", names[1]);
					intent1.putExtra("xinxi2", descs[1]);
					intent1.putExtra("xinxi3", "��");
					intent1.putExtra("xinxi4", "43��");
					intent1.putExtra("xinxi5", "�����豸��");
					intent1.putExtra("xinxi6", "�߹���������");
					intent1.putExtra("telphone", "15075735868");
					startActivity(intent1);
					break;
				case 2:
					Intent intent2 = new Intent(getActivity(), zhuanjia.class);
					intent2.putExtra("xinxi1", names[2]);
					intent2.putExtra("xinxi2", descs[2]);
					intent2.putExtra("xinxi3", "��");
					intent2.putExtra("xinxi4", "54��");
					intent2.putExtra("xinxi5", "���𹩵繤��");
					intent2.putExtra("xinxi6", "�͹�˾�繤����ר��");
					intent2.putExtra("telphone", "15803273829");
					startActivity(intent2);
					break;
				case 3:
					Intent intent3 = new Intent(getActivity(), zhuanjia.class);
					intent3.putExtra("xinxi1", names[3]);
					intent3.putExtra("xinxi2", descs[3]);
					intent3.putExtra("xinxi3", "��");
					intent3.putExtra("xinxi4", "51��");
					intent3.putExtra("xinxi5", "���𹩵繤��");
					intent3.putExtra("xinxi6", "�͹�˾�繤����ר��");
					intent3.putExtra("telphone", "13473731830");
					startActivity(intent3);
					break;
				case 4:
					Intent intent4 = new Intent(getActivity(), zhuanjia.class);
					intent4.putExtra("xinxi1", names[4]);
					intent4.putExtra("xinxi2", descs[4]);
					intent4.putExtra("xinxi3", "��");
					intent4.putExtra("xinxi4", "57��");
					intent4.putExtra("xinxi5", "���𹩵繤��");
					intent4.putExtra("xinxi6", "�߹���������");
					intent4.putExtra("telphone", "13463738269");
					startActivity(intent4);
					break;
				case 5:
					Intent intent5 = new Intent(getActivity(), zhuanjia.class);
					intent5.putExtra("xinxi1", names[5]);
					intent5.putExtra("xinxi2", descs[5]);
					intent5.putExtra("xinxi3", "��");
					intent5.putExtra("xinxi4", "58��");
					intent5.putExtra("xinxi5", "���𹩵繤��");
					intent5.putExtra("xinxi6", "��ʦ");
					intent5.putExtra("telphone", "13582761698");
					startActivity(intent5);
					break;
				case 6:
					Intent intent6 = new Intent(getActivity(), zhuanjia.class);
					intent6.putExtra("xinxi1", names[6]);
					intent6.putExtra("xinxi2", descs[6]);
					intent6.putExtra("xinxi3", "��");
					intent6.putExtra("xinxi4", "36��");
					intent6.putExtra("xinxi5", "���𹩵繤��");
					intent6.putExtra("xinxi6", "���ơ��߹�");
					intent6.putExtra("telphone", "18531723100");
					startActivity(intent6);
					break;
				case 7:
					Intent intent7 = new Intent(getActivity(), zhuanjia.class);
					intent7.putExtra("xinxi1", names[7]);
					intent7.putExtra("xinxi2", descs[7]);
					intent7.putExtra("xinxi3", "��");
					intent7.putExtra("xinxi4", "50��");
					intent7.putExtra("xinxi5", "���𹩵繤��");
					intent7.putExtra("xinxi6", "�͹�˾�繤����ר��");
					intent7.putExtra("telphone", "15803273896");
					startActivity(intent7);
					break;
				case 8:
					Intent intent8 = new Intent(getActivity(), zhuanjia.class);
					intent8.putExtra("xinxi1", names[8]);
					intent8.putExtra("xinxi2", descs[8]);
					intent8.putExtra("xinxi3", "��");
					intent8.putExtra("xinxi4", "47��");
					intent8.putExtra("xinxi5", "���𹩵繤��");
					intent8.putExtra("xinxi6", "�͹�˾�繤����ר��");
					intent8.putExtra("telphone", "15831778208");
					startActivity(intent8);
					break;
				case 9:
					Intent intent9 = new Intent(getActivity(), zhuanjia.class);
					intent9.putExtra("xinxi1", names[9]);
					intent9.putExtra("xinxi2", descs[9]);
					intent9.putExtra("xinxi3", "��");
					intent9.putExtra("xinxi4", "40��");
					intent9.putExtra("xinxi5", "�����ֳ�");
					intent9.putExtra("xinxi6", "���ơ��߹�");
					intent9.putExtra("telphone", "15930798452");
					startActivity(intent9);
					break;
				case 10:
					Intent intent10 = new Intent(getActivity(), zhuanjia.class);
					intent10.putExtra("xinxi1", names[10]);
					intent10.putExtra("xinxi2", descs[10]);
					intent10.putExtra("xinxi3", "��");
					intent10.putExtra("xinxi4", "50��");
					intent10.putExtra("xinxi5", "�����ֳ�");
					intent10.putExtra("xinxi6", "����ʦ");
					intent10.putExtra("telphone", "13102730033");
					startActivity(intent10);
					break;
				case 11:
					Intent intent11 = new Intent(getActivity(), zhuanjia.class);
					intent11.putExtra("xinxi1", names[11]);
					intent11.putExtra("xinxi2", descs[11]);
					intent11.putExtra("xinxi3", "��");
					intent11.putExtra("xinxi4", "52��");
					intent11.putExtra("xinxi5", "�����ֳ�");
					intent11.putExtra("xinxi6", "��ʦ");
					intent11.putExtra("telphone", "13131770778");
					startActivity(intent11);
					break;
				case 12:
					Intent intent12 = new Intent(getActivity(), zhuanjia.class);
					intent12.putExtra("xinxi1", names[12]);
					intent12.putExtra("xinxi2", descs[12]);
					intent12.putExtra("xinxi3", "��");
					intent12.putExtra("xinxi4", "50��");
					intent12.putExtra("xinxi5", "�����ֳ�");
					intent12.putExtra("xinxi6", "��ʦ");
					intent12.putExtra("telphone", "13931757914");
					startActivity(intent12);
					break;
				case 13:
					Intent intent13 = new Intent(getActivity(), zhuanjia.class);
					intent13.putExtra("xinxi1", names[13]);
					intent13.putExtra("xinxi2", descs[13]);
					intent13.putExtra("xinxi3", "Ů");
					intent13.putExtra("xinxi4", "54��");
					intent13.putExtra("xinxi5", "�����ֳ�");
					intent13.putExtra("xinxi6", "����ʦ��һ����");
					intent13.putExtra("telphone", "13582762681");
					startActivity(intent13);
					break;
				case 14:
					Intent intent14 = new Intent(getActivity(), zhuanjia.class);
					intent14.putExtra("xinxi1", names[14]);
					intent14.putExtra("xinxi2", descs[14]);
					intent14.putExtra("xinxi3", "��");
					intent14.putExtra("xinxi4", "42��");
					intent14.putExtra("xinxi5", "�����ֳ�");
					intent14.putExtra("xinxi6", "��ʦ");
					intent14.putExtra("telphone", "13231719007");
					startActivity(intent14);
					break;
				case 15:
					Intent intent15 = new Intent(getActivity(), zhuanjia.class);
					intent15.putExtra("xinxi1", names[15]);
					intent15.putExtra("xinxi2", descs[15]);
					intent15.putExtra("xinxi3", "��");
					intent15.putExtra("xinxi4", "39��");
					intent15.putExtra("xinxi5", "�����ֳ�");
					intent15.putExtra("xinxi6", "����ʦ");
					intent15.putExtra("telphone", "15841515127");
					startActivity(intent15);
					break;
				case 16:
					Intent intent16 = new Intent(getActivity(), zhuanjia.class);
					intent16.putExtra("xinxi1", names[16]);
					intent16.putExtra("xinxi2", descs[16]);
					intent16.putExtra("xinxi3", "��");
					intent16.putExtra("xinxi4", "45��");
					intent16.putExtra("xinxi5", "�����ֳ�");
					intent16.putExtra("xinxi6", "����ʦ");
					intent16.putExtra("telphone", "15803273630");
					startActivity(intent16);
					break;
				case 17:
					Intent intent17 = new Intent(getActivity(), zhuanjia.class);
					intent17.putExtra("xinxi1", names[17]);
					intent17.putExtra("xinxi2", descs[17]);
					intent17.putExtra("xinxi3", "��");
					intent17.putExtra("xinxi4", "46��");
					intent17.putExtra("xinxi5", "�����ֳ�");
					intent17.putExtra("xinxi6", "�߼���ʦ");
					intent17.putExtra("telphone", "13102736315");
					startActivity(intent17);
					break;
				case 18:
					Intent intent18 = new Intent(getActivity(), zhuanjia.class);
					intent18.putExtra("xinxi1", names[18]);
					intent18.putExtra("xinxi2", descs[18]);
					intent18.putExtra("xinxi3", "��");
					intent18.putExtra("xinxi4", "56��");
					intent18.putExtra("xinxi5", "�����ֳ�");
					intent18.putExtra("xinxi6", "�͹�˾�繤����ר��");
					intent18.putExtra("telphone", "18632732827");
					startActivity(intent18);
					break;
				case 19:
					Intent intent19 = new Intent(getActivity(), zhuanjia.class);
					intent19.putExtra("xinxi1", names[19]);
					intent19.putExtra("xinxi2", descs[19]);
					intent19.putExtra("xinxi3", "��");
					intent19.putExtra("xinxi4", "50��");
					intent19.putExtra("xinxi5", "�ϲ����繤��");
					intent19.putExtra("xinxi6", "��ʦ");
					intent19.putExtra("telphone", "18632762750");
					startActivity(intent19);
					break;
				case 20:
					Intent intent20 = new Intent(getActivity(), zhuanjia.class);
					intent20.putExtra("xinxi1", names[20]);
					intent20.putExtra("xinxi2", descs[20]);
					intent20.putExtra("xinxi3", "��");
					intent20.putExtra("xinxi4", "59��");
					intent20.putExtra("xinxi5", "�ϲ����繤��");
					intent20.putExtra("xinxi6", "�͹�˾�繤����ר��");
					intent20.putExtra("telphone", "13703172034");
					startActivity(intent20);
					break;
				case 21:
					Intent intent21 = new Intent(getActivity(), zhuanjia.class);
					intent21.putExtra("xinxi1", names[21]);
					intent21.putExtra("xinxi2", descs[21]);
					intent21.putExtra("xinxi3", "Ů");
					intent21.putExtra("xinxi4", "45��");
					intent21.putExtra("xinxi5", "�ϲ����繤��");
					intent21.putExtra("xinxi6", "�͹�˾�繤����ר��");
					intent21.putExtra("telphone", "15231782553");
					startActivity(intent21);
					break;
				case 22:
					Intent intent22 = new Intent(getActivity(), zhuanjia.class);
					intent22.putExtra("xinxi1", names[22]);
					intent22.putExtra("xinxi2", descs[22]);
					intent22.putExtra("xinxi3", "��");
					intent22.putExtra("xinxi4", "53��");
					intent22.putExtra("xinxi5", "�������繤��");
					intent22.putExtra("xinxi6", "����ʦ");
					intent22.putExtra("telphone", "13784750300");
					startActivity(intent22);
					break;
				case 23:
					Intent intent23 = new Intent(getActivity(), zhuanjia.class);
					intent23.putExtra("xinxi1", names[23]);
					intent23.putExtra("xinxi2", descs[23]);
					intent23.putExtra("xinxi3", "��");
					intent23.putExtra("xinxi4", "55��");
					intent23.putExtra("xinxi5", "�������繤��");
					intent23.putExtra("xinxi6", "��ʦ");
					intent23.putExtra("telphone", "15803273898");
					startActivity(intent23);
					break;
				case 24:
					Intent intent24 = new Intent(getActivity(), zhuanjia.class);
					intent24.putExtra("xinxi1", names[24]);
					intent24.putExtra("xinxi2", descs[24]);
					intent24.putExtra("xinxi3", "��");
					intent24.putExtra("xinxi4", "37��");
					intent24.putExtra("xinxi5", "�������繤��");
					intent24.putExtra("xinxi6", "����ʦ");
					intent24.putExtra("telphone", "13582764405");
					startActivity(intent24);
					break;
				case 25:
					Intent intent25 = new Intent(getActivity(), zhuanjia.class);
					intent25.putExtra("xinxi1", names[25]);
					intent25.putExtra("xinxi2", descs[25]);
					intent25.putExtra("xinxi3", "��");
					intent25.putExtra("xinxi4", "48��");
					intent25.putExtra("xinxi5", "�������繤��");
					intent25.putExtra("xinxi6", "��ʦ");
					intent25.putExtra("telphone", "15028752072");
					startActivity(intent25);
					break;
				case 26:
					Intent intent26 = new Intent(getActivity(), zhuanjia.class);
					intent26.putExtra("xinxi1", names[26]);
					intent26.putExtra("xinxi2", descs[26]);
					intent26.putExtra("xinxi3", "��");
					intent26.putExtra("xinxi4", "59��");
					intent26.putExtra("xinxi5", "�������繤��");
					intent26.putExtra("xinxi6", "�͹�˾�繤����ר��");
					intent26.putExtra("telphone", "13633171226");
					startActivity(intent26);
					break;
				case 27:
					Intent intent27 = new Intent(getActivity(), zhuanjia.class);
					intent27.putExtra("xinxi1", names[27]);
					intent27.putExtra("xinxi2", descs[27]);
					intent27.putExtra("xinxi3", "��");
					intent27.putExtra("xinxi4", "53��");
					intent27.putExtra("xinxi5", "�������繤��");
					intent27.putExtra("xinxi6", "����ʦ");
					intent27.putExtra("telphone", "13785739783");
					startActivity(intent27);
					break;
				case 28:
					Intent intent28 = new Intent(getActivity(), zhuanjia.class);
					intent28.putExtra("xinxi1", names[28]);
					intent28.putExtra("xinxi2", descs[28]);
					intent28.putExtra("xinxi3", "��");
					intent28.putExtra("xinxi4", "47��");
					intent28.putExtra("xinxi5", "���̴��");
					intent28.putExtra("xinxi6", "�͹�˾�繤����ר��");
					intent28.putExtra("telphone", "15132716200");
					startActivity(intent28);
					break;
				case 29:
					Intent intent29 = new Intent(getActivity(), zhuanjia.class);
					intent29.putExtra("xinxi1", names[29]);
					intent29.putExtra("xinxi2", descs[29]);
					intent29.putExtra("xinxi3", "��");
					intent29.putExtra("xinxi4", "48��");
					intent29.putExtra("xinxi5", "���̴��");
					intent29.putExtra("xinxi6", "�͹�˾�繤����ר��");
					intent29.putExtra("telphone", "15803273705");
					startActivity(intent29);
					break;
				case 30:
					Intent intent30 = new Intent(getActivity(), zhuanjia.class);
					intent30.putExtra("xinxi1", names[30]);
					intent30.putExtra("xinxi2", descs[30]);
					intent30.putExtra("xinxi3", "��");
					intent30.putExtra("xinxi4", "44��");
					intent30.putExtra("xinxi5", "��������");
					intent30.putExtra("xinxi6", "����ʦ");
					intent30.putExtra("telphone", "13831777568");
					startActivity(intent30);
					break;
				case 31:
					Intent intent31 = new Intent(getActivity(), zhuanjia.class);
					intent31.putExtra("xinxi1", names[31]);
					intent31.putExtra("xinxi2", descs[31]);
					intent31.putExtra("xinxi3", "��");
					intent31.putExtra("xinxi4", "47��");
					intent31.putExtra("xinxi5", "��������");
					intent31.putExtra("xinxi6", "����ʦ��������");
					intent31.putExtra("telphone", "15075751291");
					startActivity(intent31);
					break;
				case 32:
					Intent intent32 = new Intent(getActivity(), zhuanjia.class);
					intent32.putExtra("xinxi1", names[32]);
					intent32.putExtra("xinxi2", descs[32]);
					intent32.putExtra("xinxi3", "��");
					intent32.putExtra("xinxi4", "49��");
					intent32.putExtra("xinxi5", "��������");
					intent32.putExtra("xinxi6", "�͹�˾�繤����ר��");
					intent32.putExtra("telphone", "13932734868");
					startActivity(intent32);
					break;
				case 33:
					Intent intent33 = new Intent(getActivity(), zhuanjia.class);
					intent33.putExtra("xinxi1", names[33]);
					intent33.putExtra("xinxi2", descs[33]);
					intent33.putExtra("xinxi3", "��");
					intent33.putExtra("xinxi4", "44��");
					intent33.putExtra("xinxi5", "�õ������");
					intent33.putExtra("xinxi6", "�͹�˾�繤����ר��");
					intent33.putExtra("telphone", "13930763033");
					startActivity(intent33);
					break;
				case 34:
					Intent intent34 = new Intent(getActivity(), zhuanjia.class);
					intent34.putExtra("xinxi1", names[34]);
					intent34.putExtra("xinxi2", descs[34]);
					intent34.putExtra("xinxi3", "��");
					intent34.putExtra("xinxi4", "37��");
					intent34.putExtra("xinxi5", "������������");
					intent34.putExtra("xinxi6", "����ʦ");
					intent34.putExtra("telphone", "15231715919");
					startActivity(intent34);
					break;
				case 35:
					Intent intent35 = new Intent(getActivity(), zhuanjia.class);
					intent35.putExtra("xinxi1", names[35]);
					intent35.putExtra("xinxi2", descs[35]);
					intent35.putExtra("xinxi3", "��");
					intent35.putExtra("xinxi4", "46��");
					intent35.putExtra("xinxi5", "������������");
					intent35.putExtra("xinxi6", "����ʦ");
					intent35.putExtra("telphone", "13785751212");
					startActivity(intent35);
					break;
				case 36:
					Intent intent36 = new Intent(getActivity(), zhuanjia.class);
					intent36.putExtra("xinxi1", names[36]);
					intent36.putExtra("xinxi2", descs[36]);
					intent36.putExtra("xinxi3", "Ů");
					intent36.putExtra("xinxi4", "48��");
					intent36.putExtra("xinxi5", "������������");
					intent36.putExtra("xinxi6", "�߹���������");
					intent36.putExtra("telphone", "13483813440");
					startActivity(intent36);
					break;
				case 37:
					Intent intent37 = new Intent(getActivity(), zhuanjia.class);
					intent37.putExtra("xinxi1", names[37]);
					intent37.putExtra("xinxi2", descs[37]);
					intent37.putExtra("xinxi3", "��");
					intent37.putExtra("xinxi4", "41��");
					intent37.putExtra("xinxi5", "������������");
					intent37.putExtra("xinxi6", "��ʦ");
					intent37.putExtra("telphone", "13932749604");
					startActivity(intent37);
					break;
				case 38:
					Intent intent38 = new Intent(getActivity(), zhuanjia.class);
					intent38.putExtra("xinxi1", names[38]);
					intent38.putExtra("xinxi2", descs[38]);
					intent38.putExtra("xinxi3", "��");
					intent38.putExtra("xinxi4", "54��");
					intent38.putExtra("xinxi5", "������������");
					intent38.putExtra("xinxi6", "�߹���һ����");
					intent38.putExtra("telphone", "13785700267");
					startActivity(intent38);
					break;
				case 39:
					Intent intent39 = new Intent(getActivity(), zhuanjia.class);
					intent39.putExtra("xinxi1", names[39]);
					intent39.putExtra("xinxi2", descs[39]);
					intent39.putExtra("xinxi3", "Ů");
					intent39.putExtra("xinxi4", "48��");
					intent39.putExtra("xinxi5", "������������");
					intent39.putExtra("xinxi6", "�߹���һ����");
					intent39.putExtra("telphone", "13722749391");
					startActivity(intent39);
					break;
				case 40:
					Intent intent40 = new Intent(getActivity(), zhuanjia.class);
					intent40.putExtra("xinxi1", names[40]);
					intent40.putExtra("xinxi2", descs[40]);
					intent40.putExtra("xinxi3", "��");
					intent40.putExtra("xinxi4", "55��");
					intent40.putExtra("xinxi5", "�����豸��");
					intent40.putExtra("xinxi6", "�߹���������");
					intent40.putExtra("telphone", "13603337011");
					startActivity(intent40);
					break;
				case 41:
					Intent intent41 = new Intent(getActivity(), zhuanjia.class);
					intent41.putExtra("xinxi1", names[41]);
					intent41.putExtra("xinxi2", descs[41]);
					intent41.putExtra("xinxi3", "��");
					intent41.putExtra("xinxi4", "59��");
					intent41.putExtra("xinxi5", "�õ������");
					intent41.putExtra("xinxi6", "�߹�����ϯ��");
					intent41.putExtra("telphone", "13931758305");
					startActivity(intent41);
					break;
				case 42:
					Intent intent42 = new Intent(getActivity(), zhuanjia.class);
					intent42.putExtra("xinxi1", names[42]);
					intent42.putExtra("xinxi2", descs[42]);
					intent42.putExtra("xinxi3", "��");
					intent42.putExtra("xinxi4", "36��");
					intent42.putExtra("xinxi5", "��ˮά��վ");
					intent42.putExtra("xinxi6", "����ʦ");
					intent42.putExtra("telphone", "13831746275");
					startActivity(intent42);
					break;
				case 43:
					Intent intent43 = new Intent(getActivity(), zhuanjia.class);
					intent43.putExtra("xinxi1", names[43]);
					intent43.putExtra("xinxi2", descs[43]);
					intent43.putExtra("xinxi3", "Ů");
					intent43.putExtra("xinxi4", "44��");
					intent43.putExtra("xinxi5", "���̴��");
					intent43.putExtra("xinxi6", "�߹���������");
					intent43.putExtra("telphone", "13931730302");
					startActivity(intent43);
					break;
				case 44:
					Intent intent44 = new Intent(getActivity(), zhuanjia.class);
					intent44.putExtra("xinxi1", names[44]);
					intent44.putExtra("xinxi2", descs[44]);
					intent44.putExtra("xinxi3", "��");
					intent44.putExtra("xinxi4", "46��");
					intent44.putExtra("xinxi5", "���������");
					intent44.putExtra("xinxi6", "����ʦ��������");
					intent44.putExtra("telphone", "15231782552");
					startActivity(intent44);
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
				case 39:
					Intent intent39 = new Intent(getActivity(), PingjiaActivity.class);
					intent39.putExtra("namestring", names[39]);
					startActivity(intent39);
					break;
				case 40:
					Intent intent40 = new Intent(getActivity(), PingjiaActivity.class);
					intent40.putExtra("namestring", names[40]);
					startActivity(intent40);
					break;
				case 41:
					Intent intent41 = new Intent(getActivity(), PingjiaActivity.class);
					intent41.putExtra("namestring", names[41]);
					startActivity(intent41);
					break;
				case 42:
					Intent intent42 = new Intent(getActivity(), PingjiaActivity.class);
					intent42.putExtra("namestring", names[42]);
					startActivity(intent42);
					break;
				case 43:
					Intent intent43 = new Intent(getActivity(), PingjiaActivity.class);
					intent43.putExtra("namestring", names[43]);
					startActivity(intent43);
					break;
				case 44:
					Intent intent44 = new Intent(getActivity(), PingjiaActivity.class);
					intent44.putExtra("namestring", names[44]);
					startActivity(intent44);
					break;

				default:
					break;
				}
				return false;
			}
		});
	}

}
