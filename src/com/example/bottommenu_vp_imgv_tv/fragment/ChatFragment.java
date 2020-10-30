package com.example.bottommenu_vp_imgv_tv.fragment;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.example.bottommenu_vp_imgv_tv.R;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.FileProvider;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

public class ChatFragment extends Fragment {

	private static final int Request_take_photo = 100;
	private Button button1;
	private Button button2;
	private Button button3;
	private Button button4;
	private Button btn6;
	private Button main_btn;
	private TextView main_tv;
	private ImageView imgv1;
	private EditText editText1;
	private WebView webView1;
	public static SQLiteDatabase database;
	private static String stString1;
	private static String stString2;
	private static String stString3;
	private Uri mImageUri;
	private File imageFile;
	private String path = Environment.getExternalStorageDirectory().getAbsolutePath() + "/capture/";
	private String fileName;

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

		button1 = (Button) getActivity().findViewById(R.id.button1);
		button2 = (Button) getActivity().findViewById(R.id.button2);
		button3 = (Button) getActivity().findViewById(R.id.button3);
		button4 = (Button) getActivity().findViewById(R.id.button4);
		main_btn = (Button) getActivity().findViewById(R.id.main_btn);
		btn6 = (Button) getActivity().findViewById(R.id.btn6);
		main_tv = (TextView) getActivity().findViewById(R.id.main_tv);
		imgv1 = (ImageView) getActivity().findViewById(R.id.imgv1);
		editText1 = (EditText) getActivity().findViewById(R.id.editText1);
		webView1 = (WebView) getActivity().findViewById(R.id.webView1);

		database = openDatabase();

		button1.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

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

		btn6.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {

					File file = new File(path);
					if (!file.exists()) {
						file.mkdir();
					}
					fileName = String.valueOf(System.currentTimeMillis()) + ".jpg";
					imageFile = new File(path + fileName);
					Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
					intent.addCategory(Intent.CATEGORY_DEFAULT);
					if (imageFile != null) {
						if (Build.VERSION.SDK_INT >= 24) {
							intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
							mImageUri = FileProvider.getUriForFile(getActivity(),
									"cn.fonxnickel.officialcamerademo.fileprovider", imageFile);
						} else {

							mImageUri = Uri.fromFile(imageFile);
						}

					}
					intent.putExtra(MediaStore.Images.Media.ORIENTATION, 0);
					intent.putExtra(MediaStore.EXTRA_OUTPUT, mImageUri);
					startActivityForResult(intent, Request_take_photo);

				} else {
					Toast.makeText(getActivity(), "没有检测到SD卡", Toast.LENGTH_LONG).show();
				}
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

	private void galleryAddPic(Uri uri) {
		Intent mediaScanIntent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
		mediaScanIntent.setData(uri);
		getActivity().sendBroadcast(mediaScanIntent);
	}

	private void takePhoto() {
		Intent takePhotoIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
		if (takePhotoIntent.resolveActivity(getActivity().getPackageManager()) != null) {

			imageFile = createImageFile();
			if (imageFile != null) {
				if (Build.VERSION.SDK_INT >= 24) {
					takePhotoIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
					mImageUri = FileProvider.getUriForFile(getActivity(),
							"cn.fonxnickel.officialcamerademo.fileprovider", imageFile);
				} else {

					mImageUri = Uri.fromFile(imageFile);
				}
				takePhotoIntent.putExtra(MediaStore.EXTRA_OUTPUT, mImageUri);
				startActivityForResult(takePhotoIntent, Request_take_photo);
			}
		}
	}

	private File createImageFile() {
		if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
			String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
			String imageFileName = "JPEG_" + timeStamp + "_";
			String storagePath = Environment.getExternalStorageDirectory().getAbsolutePath() + "/capture/";

			File storageDir = new File(storagePath);
			if (!storageDir.exists()) {
				storageDir.mkdirs();
			}

			try {
				imageFile = File.createTempFile(imageFileName, ".jpg", storageDir);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			Toast.makeText(getActivity(), "没有检测到SD卡", Toast.LENGTH_LONG).show();
		}
		return imageFile;

	}

	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {

		super.onActivityResult(requestCode, resultCode, data);
		if (requestCode == Request_take_photo && resultCode == Activity.RESULT_OK) {
			try {

				Bitmap bitmap = BitmapFactory
						.decodeStream(getActivity().getContentResolver().openInputStream(mImageUri));
				imgv1.setImageBitmap(bitmap);
				galleryAddPic(mImageUri);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}

	}

	private void readHtmlFormAssets() {
		WebSettings webSettings = webView1.getSettings();
		webSettings.setLoadWithOverviewMode(true);
		webSettings.setUseWideViewPort(true);
		webView1.getSettings().setTextZoom(180);
		webView1.setBackgroundColor(Color.TRANSPARENT);
		webView1.loadUrl("file:///android_asset/html/all2.html");
	}
}
