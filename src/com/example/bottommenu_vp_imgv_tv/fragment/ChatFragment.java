package com.example.bottommenu_vp_imgv_tv.fragment;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import com.example.bottommenu_vp_imgv_tv.PlatformUtil;
import com.example.bottommenu_vp_imgv_tv.R;

import android.Manifest;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
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
import android.support.v4.widget.DrawerLayout;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.Toast;

public class ChatFragment extends Fragment {
	private static final int REQ_THUMB = 222;
	private static final int REQ_TAKE_PHOTO = 444;
	Button mFullSize;
	ImageView mImageView;
	Uri uri1;
	private Button button1;
	private Button button2;
	private Button button3;
	private Button button4;
	private Button btn_sharetext;
	private Button btn_sharefriend;
	private Button btn_sharecircle;
	private Button btn_sharetoding;
	private Button btn_sharetoqq;
	private Button btn_jump;
	private Button btn_clear;
	private EditText et_wechat_id;
	private EditText share_text;
	private EditText editText1;
	private WebView webView1;
	public static SQLiteDatabase database;
	private static String stString1;
	private static String stString2;
	private static String stString3;
	private String[] item = new String[] { "菜单一", "菜单二", "菜单三", "菜单四" };

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
				.setIndicator("拍照分享", getResources().getDrawable(R.drawable.ic_launcher)).setContent(R.id.view2));
		tabHost.addTab(tabHost.newTabSpec("tab3")
				.setIndicator("对接微信", getResources().getDrawable(R.drawable.ic_launcher)).setContent(R.id.view3));
		tabHost.addTab(tabHost.newTabSpec("tab4")
				.setIndicator("更多待定", getResources().getDrawable(R.drawable.ic_launcher)).setContent(R.id.view4));

		button1 = (Button) getActivity().findViewById(R.id.button1);
		button2 = (Button) getActivity().findViewById(R.id.button2);
		button3 = (Button) getActivity().findViewById(R.id.button3);
		button4 = (Button) getActivity().findViewById(R.id.button4);
		btn_sharetext = (Button) getActivity().findViewById(R.id.btn_sharetext);
		btn_sharecircle = (Button) getActivity().findViewById(R.id.btn_sharecircle);
		btn_sharefriend = (Button) getActivity().findViewById(R.id.btn_sharefriend);
		btn_sharetoding = (Button) getActivity().findViewById(R.id.btn_sharetoding);
		btn_sharetoqq = (Button) getActivity().findViewById(R.id.btn_sharetoqq);

		btn_clear = (Button) getActivity().findViewById(R.id.btn_clear);
		btn_jump = (Button) getActivity().findViewById(R.id.btn_jump);
		et_wechat_id = (EditText) getActivity().findViewById(R.id.et_wechat_id);
		editText1 = (EditText) getActivity().findViewById(R.id.editText1);
		webView1 = (WebView) getActivity().findViewById(R.id.webView1);
		share_text = (EditText) getActivity().findViewById(R.id.share_text);
		database = openDatabase();
		init();
		ListView listView = (ListView) getActivity().findViewById(R.id.listView);

		ArrayAdapter adapter = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, item);
		listView.setAdapter(adapter);
		listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				switch (position) {
				case 0:
					Toast.makeText(getActivity(), "你点击的是菜单一", Toast.LENGTH_SHORT).show();
					break;
				case 1:
					Toast.makeText(getActivity(), "你点击的是菜单二", Toast.LENGTH_SHORT).show();
					break;
				case 2:
					Toast.makeText(getActivity(), "你点击的是菜单三", Toast.LENGTH_SHORT).show();
					break;
				case 3:
					Toast.makeText(getActivity(), "你点击的是菜单四", Toast.LENGTH_SHORT).show();
					break;
				default:
					break;
				}
			}
		});
		DrawerLayout drawerLayout = (DrawerLayout) getActivity().findViewById(R.id.view4);
		drawerLayout.setDrawerListener(new DrawerLayout.DrawerListener() {
			@Override
			public void onDrawerSlide(View drawerView, float slideOffset) {
			}

			@Override
			public void onDrawerOpened(View drawerView) {
				Toast.makeText(getActivity(), "抽屉菜单已打开！", Toast.LENGTH_SHORT).show();
			}

			@Override
			public void onDrawerClosed(View drawerView) {
				Toast.makeText(getActivity(), "抽屉菜单已关闭！", Toast.LENGTH_SHORT).show();
			}

			@Override
			public void onDrawerStateChanged(int newState) {
			}
		});
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

		btn_jump.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent();
				ComponentName cmp = new ComponentName("com.tencent.mm", "com.tencent.mm.ui.LauncherUI");
				intent.setAction(Intent.ACTION_MAIN);
				intent.addCategory(Intent.CATEGORY_LAUNCHER);
				intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				intent.setComponent(cmp);
				getActivity().startActivity(intent);
			}
		});

		btn_clear.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				et_wechat_id.setText("");
			}
		});
		btn_sharefriend.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				shareToFriend(uri1);

			}
		});
		btn_sharecircle.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				shareToFriendsLine(uri1);

			}
		});
		btn_sharetext.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				shareWechatFriend(getActivity(), share_text.getText().toString());
			}
		});
		btn_sharetoding.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				shareText(getActivity(), share_text.getText().toString());
			}
		});
		btn_sharetoqq.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				shareQQ(getActivity(), share_text.getText().toString());
			}
		});
	}

	public static void shareText(Context context, String extraText) {
		Intent intent = new Intent(Intent.ACTION_SEND);
		intent.setType("text/plain");
		intent.putExtra(Intent.EXTRA_SUBJECT, "标题");
		intent.putExtra(Intent.EXTRA_TEXT, extraText);
		intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		context.startActivity(Intent.createChooser(intent, "标题"));
	}

	public static void shareQQ(Context mContext, String content) {
		if (PlatformUtil.isInstallApp(mContext, PlatformUtil.PACKAGE_MOBILE_QQ)) {
			Intent intent = new Intent("android.intent.action.SEND");
			intent.setType("text/plain");
			intent.putExtra(Intent.EXTRA_SUBJECT, "分享");
			intent.putExtra(Intent.EXTRA_TEXT, content);
			intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			intent.setComponent(
					new ComponentName("com.tencent.mobileqq", "com.tencent.mobileqq.activity.JumpActivity"));
			mContext.startActivity(intent);
		} else {
			Toast.makeText(mContext, "您需要安装QQ客户端", Toast.LENGTH_LONG).show();
		}
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

	private void init() {
		if (Build.VERSION.SDK_INT >= 23) {
			requestPermissions(new String[] { Manifest.permission.WRITE_EXTERNAL_STORAGE,
					Manifest.permission.RECORD_AUDIO, Manifest.permission.CAMERA, Manifest.permission.ACCESS_WIFI_STATE,
					Manifest.permission.READ_CONTACTS, Manifest.permission.READ_PHONE_STATE,
					Manifest.permission.RECEIVE_SMS, Manifest.permission.READ_SMS, Manifest.permission.GET_TASKS,
					Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_NETWORK_STATE,
					Manifest.permission.INTERNET, Manifest.permission.READ_EXTERNAL_STORAGE }, 200);
		}

		mFullSize = (Button) getActivity().findViewById(R.id.fullSize);

		mImageView = (ImageView) getActivity().findViewById(R.id.imageView);

		mFullSize.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
				// Ensure that there's a camera activity to handle the intent
				if (takePictureIntent.resolveActivity(getActivity().getPackageManager()) != null) {// 判断是否有相机应用
					// Create the File where the photo should go
					File photoFile = null;
					try {
						photoFile = createImageFile();// 创建临时图片文件

					} catch (IOException ex) {
						ex.printStackTrace();
					}
					// Continue only if the File was successfully created
					if (photoFile != null) {
						// FileProvider 是一个特殊的 ContentProvider 的子类，
						// 它使用 content:// Uri 代替了 file:/// Uri. ，更便利而且安全的为另一个app分享文件
						Uri photoURI = FileProvider.getUriForFile(getActivity(), "com.youga.fileprovider", photoFile);

						takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);
						startActivityForResult(takePictureIntent, REQ_TAKE_PHOTO);
					}
				}
			}
		});

	}

	String mCurrentPhotoPath;

	private File createImageFile() throws IOException {
		// Create an image file name
		String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.CHINA).format(new Date());
		String imageFileName = "JPEG_" + timeStamp + "_";
		// .getExternalFilesDir()方法可以获取到 SDCard/Android/data/你的应用的包名/files/
		// 目录，一般放一些长时间保存的数据
		File storageDir = getActivity().getExternalFilesDir(Environment.DIRECTORY_PICTURES);
		// 创建临时文件,文件前缀不能少于三个字符,后缀如果为空默认未".tmp"
		File image = File.createTempFile(imageFileName, /* 前缀 */
				".jpg", /* 后缀 */
				storageDir /* 文件夹 */
		);
		mCurrentPhotoPath = image.getAbsolutePath();
		return image;
	}

	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		switch (requestCode) {
		case REQ_THUMB:// 返回结果
			if (resultCode != Activity.RESULT_OK)
				return;
			Bundle extras = data.getExtras();
			Bitmap imageBitmap = (Bitmap) extras.get("data");
			mImageView.setImageBitmap(imageBitmap);
			break;
		case REQ_TAKE_PHOTO:// 返回结果
			if (resultCode != Activity.RESULT_OK)
				return;

			// Get the dimensions of the View
			int targetW = mImageView.getWidth();
			int targetH = mImageView.getHeight();

			// Get the dimensions of the bitmap
			BitmapFactory.Options bmOptions = new BitmapFactory.Options();
			bmOptions.inJustDecodeBounds = true;
			BitmapFactory.decodeFile(mCurrentPhotoPath, bmOptions);
			int photoW = bmOptions.outWidth;
			int photoH = bmOptions.outHeight;

			// Determine how much to scale down the image
			int scaleFactor = Math.min(photoW / targetW, photoH / targetH);

			// Decode the image file into a Bitmap sized to fill the View
			bmOptions.inJustDecodeBounds = false;
			bmOptions.inSampleSize = scaleFactor;
			bmOptions.inPurgeable = true;

			Bitmap bitmap = BitmapFactory.decodeFile(mCurrentPhotoPath, bmOptions);
			mImageView.setImageBitmap(bitmap);
			MediaStore.Images.Media.insertImage(getActivity().getContentResolver(), bitmap, null, null);
			uri1 = Uri
					.parse(MediaStore.Images.Media.insertImage(getActivity().getContentResolver(), bitmap, null, null));
			break;

		}
	}

	private void shareToFriend(Uri uri) {

		Intent intent = new Intent();
		ComponentName comp = new ComponentName("com.tencent.mm", "com.tencent.mm.ui.tools.ShareImgUI");
		intent.setComponent(comp);
		intent.setAction("android.intent.action.SEND");
		intent.setType("image/*");

		intent.putExtra(Intent.EXTRA_STREAM, uri);
		startActivity(intent);
	}

	private void shareToFriendsLine(Uri uri) {
		Intent intent = new Intent();
		ComponentName comp = new ComponentName("com.tencent.mm", "com.tencent.mm.ui.tools.ShareToTimeLineUI");
		intent.setComponent(comp);
		intent.setAction("android.intent.action.SEND");
		intent.setType("image/*");

		intent.putExtra(Intent.EXTRA_STREAM, uri);
		startActivity(intent);
	}

	public void shareWechatFriend(Context context, String content) {
		if (PlatformUtil.isInstallApp(context, PlatformUtil.PACKAGE_WECHAT)) {
			Intent intent = new Intent();
			ComponentName cop = new ComponentName("com.tencent.mm", "com.tencent.mm.ui.tools.ShareImgUI");
			intent.setComponent(cop);
			intent.setAction(Intent.ACTION_SEND);
			intent.putExtra("android.intent.extra.TEXT", content);
			intent.putExtra("Kdescription", !TextUtils.isEmpty(content) ? content : "");
			intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			context.startActivity(intent);
		} else {
			Toast.makeText(context, "您需要安装微信客户端", Toast.LENGTH_LONG).show();
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
