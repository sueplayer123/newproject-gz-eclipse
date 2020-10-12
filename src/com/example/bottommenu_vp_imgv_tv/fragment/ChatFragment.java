package com.example.bottommenu_vp_imgv_tv.fragment;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import com.example.bottommenu_vp_imgv_tv.R;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TabHost;

public class ChatFragment extends Fragment {
	// private TextView textView2;
	private Button button1;
	private Button button2;
	private Button button3;
	private Button button4;
	private EditText editText1;
	private WebView webView1;
	public static SQLiteDatabase database;
	private static String stString1;
	private static String stString2;
	private static String stString3;

	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
			@Nullable Bundle savedInstanceState) {
		View view = View.inflate(getActivity(), R.layout.fragment_chat, null);
		return view;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		TabHost tabHost = (TabHost) getActivity().findViewById(R.id.tabhost);
		tabHost.setup();
		tabHost.addTab(tabHost.newTabSpec("tab1")
				.setIndicator("查询流程", getResources().getDrawable(R.drawable.ic_launcher)).setContent(R.id.view1));
		tabHost.addTab(tabHost.newTabSpec("tab2")
				.setIndicator("信息更新", getResources().getDrawable(R.drawable.ic_launcher)).setContent(R.id.view2));
		tabHost.addTab(tabHost.newTabSpec("tab3")
				.setIndicator("咨询专家", getResources().getDrawable(R.drawable.ic_launcher)).setContent(R.id.view3));
		tabHost.addTab(tabHost.newTabSpec("tab4")
				.setIndicator("记录评价", getResources().getDrawable(R.drawable.ic_launcher)).setContent(R.id.view4));
		// textView2 = (TextView) getActivity().findViewById(R.id.textView2);
		button1 = (Button) getActivity().findViewById(R.id.button1);
		button2 = (Button) getActivity().findViewById(R.id.button2);
		button3 = (Button) getActivity().findViewById(R.id.button3);
		button4 = (Button) getActivity().findViewById(R.id.button4);
		editText1 = (EditText) getActivity().findViewById(R.id.editText1);
		webView1 = (WebView) getActivity().findViewById(R.id.webView1);
		database = openDatabase();
		button1.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				/*
				 * InputStream inputStream = getResources().openRawResource(R.raw.sue); String
				 * string = getString(inputStream);
				 * 
				 * textView2.setText(string); textView2.setMovementMethod(new
				 * ScrollingMovementMethod());
				 */
				readHtmlFormAssets();
			}
		});
		button2.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				String sql = "select * from liucheng where liucheng like ?";

				Cursor cursor = database.rawQuery(sql, new String[] { "%" + editText1.getText().toString() + "%" });
				while (cursor.moveToNext()) {

					stString1 = cursor.getString(cursor.getColumnIndex("liucheng"));
				}
				cursor.close();
				Intent intent = new Intent();
				intent.setClass(getActivity(), com.example.bottommenu_vp_imgv_tv.LiuchengActivity.class);
				intent.putExtra("data1", stString1);
				startActivity(intent);

			}
		});
		button3.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				String sql = "select * from guzhang where name like ?";

				Cursor cursor = database.rawQuery(sql, new String[] { "%" + editText1.getText().toString() + "%" });
				while (cursor.moveToNext()) {

					stString2 = cursor.getString(cursor.getColumnIndex("gzcl"));
				}
				cursor.close();
				Intent intent2 = new Intent();
				intent2.setClass(getActivity(), com.example.bottommenu_vp_imgv_tv.DemoActivity.class);
				intent2.putExtra("data2", stString2);
				startActivity(intent2);

			}
		});
		button4.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				String sql = "select * from casetest where name like ?";
				Cursor cursor = database.rawQuery(sql, new String[] { "%" + editText1.getText().toString() + "%" });

				while (cursor.moveToNext()) {

					stString3 = cursor.getString(cursor.getColumnIndex("content"));
				}
				cursor.close();
				Intent intent3 = new Intent();
				intent3.setClass(getActivity(), com.example.bottommenu_vp_imgv_tv.CaseActivity.class);
				intent3.putExtra("data3", stString3);
				startActivity(intent3);

			}
		});
	}

	@Override
	public void onDestroy() {

		super.onDestroy();
		if (!(database == null)) {
			database.close();
		}
	}

	private SQLiteDatabase openDatabase() {

		try {
			String databasefilename = getActivity().getFilesDir().toString() + "/testsu.db";
			if (!(new File(databasefilename).exists())) {
				InputStream is = getResources().openRawResource(R.raw.testsu);
				FileOutputStream fos = new FileOutputStream(databasefilename);
				byte[] buffer = new byte[8192];
				int count = 0;
				while ((count = is.read(buffer)) > 0)

				{
					fos.write(buffer, 0, count);

				}
				fos.close();

				is.close();
			}
			SQLiteDatabase database = SQLiteDatabase.openOrCreateDatabase(databasefilename, null);
			return database;
		} catch (Exception e) {

		}
		return null;
	}

	public static String getString(InputStream inputStream) {
		InputStreamReader inputStreamReader = null;
		try {
			inputStreamReader = new InputStreamReader(inputStream, "gbk");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		BufferedReader reader = new BufferedReader(inputStreamReader);
		StringBuffer sb = new StringBuffer("");
		String line;
		try {
			while ((line = reader.readLine()) != null) {
				sb.append(line);
				sb.append("\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sb.toString();
	}

	private void readHtmlFormAssets() {
		WebSettings webSettings = webView1.getSettings();
		webSettings.setLoadWithOverviewMode(true);
		webSettings.setUseWideViewPort(true);
		webView1.getSettings().setTextZoom(180);
		webView1.setBackgroundColor(Color.TRANSPARENT);
		webView1.loadUrl("file:///android_asset/html/all.html");
	}
}
