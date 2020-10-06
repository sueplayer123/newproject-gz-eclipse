package com.example.bottommenu_vp_imgv_tv.fragment;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import com.example.bottommenu_vp_imgv_tv.R;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddressBookFragment extends Fragment {

	private Button save;
	private Button show;
	private EditText edit1;
	private EditText edit2;

	SQLiteDatabase database;
	public static final String FILE_NAME1 = "out1.txt";
	public static final String FILE_NAME2 = "out2.txt";

	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
			@Nullable Bundle savedInstanceState) {
		View view = View.inflate(getActivity(), R.layout.fragment_addressbook, null);
		return view;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		save = (Button) getActivity().findViewById(R.id.save);
		show = (Button) getActivity().findViewById(R.id.show);
		edit1 = (EditText) getActivity().findViewById(R.id.edit1);
		edit2 = (EditText) getActivity().findViewById(R.id.edit2);
		database = openDatabase();
		String sql1 = "select * from liucheng";
		Cursor cursor1 = database.rawQuery(sql1, null);
		String querydata = "";
		while (cursor1.moveToNext()) {
			String cname = cursor1.getString(cursor1.getColumnIndex("liucheng"));
			querydata = querydata + "\n" + cname;
		}
		edit1.setText(querydata);
		edit1.setMovementMethod(new ScrollingMovementMethod());
		cursor1.close();
		String sql2 = "select * from guzhang";
		Cursor cursor2 = database.rawQuery(sql2, null);
		String queryString = "";
		while (cursor2.moveToNext()) {
			String cString = cursor2.getString(cursor2.getColumnIndex("gzcl"));
			queryString = queryString + "\n" + cString;
		}
		edit2.setText(queryString);
		edit2.setMovementMethod(new ScrollingMovementMethod());
		cursor2.close();

		save.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				String textString1 = edit1.getText().toString();
				String textString2 = edit2.getText().toString();

				write1(textString1);
				write2(textString2);
				Toast.makeText(getActivity(), "±£´æ³É¹¦", Toast.LENGTH_SHORT).show();
			}
		});
		show.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				edit1.setText(read1());
				edit2.setText(read2());
				ContentValues values = new ContentValues();
				values.put("liucheng", read1());
				database.update("liucheng", values, "id = 1", null);
				ContentValues values2 = new ContentValues();
				values2.put("gzcl", read2());
				database.update("guzhang", values2, "id = 1", null);
			}

		});

	}

	private void write1(String content) {
		try {
			FileOutputStream fos = getActivity().openFileOutput(FILE_NAME1, Context.MODE_PRIVATE);
			PrintStream ps = new PrintStream(fos);
			ps.println(content);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void write2(String content) {
		try {
			FileOutputStream fos = getActivity().openFileOutput(FILE_NAME2, Context.MODE_PRIVATE);
			PrintStream ps = new PrintStream(fos);
			ps.println(content);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private String read1() {
		try {
			FileInputStream fis = getActivity().openFileInput(FILE_NAME1);
			byte[] buffer = new byte[1024];
			int hasRead = 0;
			StringBuilder sb = new StringBuilder("");
			while ((hasRead = fis.read(buffer)) > 0) {
				sb.append(new String(buffer, 0, hasRead));
			}
			return sb.toString();
		}

		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private String read2() {
		try {
			FileInputStream fis = getActivity().openFileInput(FILE_NAME2);
			byte[] buffer = new byte[1024];
			int hasRead = 0;
			StringBuilder sb = new StringBuilder("");
			while ((hasRead = fis.read(buffer)) > 0) {
				sb.append(new String(buffer, 0, hasRead));
			}
			return sb.toString();
		}

		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private SQLiteDatabase openDatabase() {

		try {
			String databasefilename = getActivity().getFilesDir().toString() + "/testsu2.db";
			if (!(new File(databasefilename).exists())) {
				InputStream is = getResources().openRawResource(R.raw.testsu2);
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
}
