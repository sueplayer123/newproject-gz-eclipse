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

import com.example.bottommenu_vp_imgv_tv.R;

import android.Manifest;
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

public class ChatFragment extends Fragment {
	private static final int REQ_THUMB = 222;
	// private static final int REQ_GALLERY = 333;
	// private static final String TAG = "MainActivity";
	private static final int REQ_TAKE_PHOTO = 444;
	Button mThumbnail, mFullSize;
	ImageView mImageView;
	// private Uri photoURI3;
	// private static final int Request_take_photo = 100;
	private Button button1;
	private Button button2;
	private Button button3;
	private Button button4;
	// private Button btn6;
	private Button main_btn;
	private TextView main_tv;
	// private ImageView imgv1;
	private EditText editText1;
	private WebView webView1;
	public static SQLiteDatabase database;
	private static String stString1;
	private static String stString2;
	private static String stString3;
	// private Uri mImageUri;
	// private File imageFile;
	// private String path =
	// Environment.getExternalStorageDirectory().getAbsolutePath() + "/capture/";
	// private String fileName;
	/*
	 * private String cameraPath =
	 * 
	 * Environment.getExternalStorageDirectory() + File.separator +
	 * Environment.DIRECTORY_DCIM + File.separator + "Camera" + File.separator;
	 */

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
				.setIndicator("��ѯ����", getResources().getDrawable(R.drawable.ic_launcher)).setContent(R.id.view1));
		tabHost.addTab(tabHost.newTabSpec("tab2")
				.setIndicator("���շ���", getResources().getDrawable(R.drawable.ic_launcher)).setContent(R.id.view2));
		tabHost.addTab(tabHost.newTabSpec("tab3")
				.setIndicator("�Խ�΢��", getResources().getDrawable(R.drawable.ic_launcher)).setContent(R.id.view3));
		tabHost.addTab(tabHost.newTabSpec("tab4")
				.setIndicator("�������", getResources().getDrawable(R.drawable.ic_launcher)).setContent(R.id.view4));

		button1 = (Button) getActivity().findViewById(R.id.button1);
		button2 = (Button) getActivity().findViewById(R.id.button2);
		button3 = (Button) getActivity().findViewById(R.id.button3);
		button4 = (Button) getActivity().findViewById(R.id.button4);
		main_btn = (Button) getActivity().findViewById(R.id.main_btn);
		// btn6 = (Button) getActivity().findViewById(R.id.btn6);
		main_tv = (TextView) getActivity().findViewById(R.id.main_tv);
		// imgv1 = (ImageView) getActivity().findViewById(R.id.imgv1);
		editText1 = (EditText) getActivity().findViewById(R.id.editText1);
		webView1 = (WebView) getActivity().findViewById(R.id.webView1);

		database = openDatabase();
		init();
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

		/*
		 * btn6.setOnClickListener(new OnClickListener() {
		 * 
		 * @Override public void onClick(View v) { if
		 * (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
		 * SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss"); Date date =
		 * new Date(System.currentTimeMillis()); fileName = format.format(date);
		 * 
		 * File path =
		 * Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM);
		 * File outputImage = new File(path, fileName + ".jpg"); try { if
		 * (outputImage.exists()) { outputImage.delete(); } outputImage.createNewFile();
		 * } catch (IOException e) { e.printStackTrace(); } Intent intent = new
		 * Intent(MediaStore.ACTION_IMAGE_CAPTURE);
		 * intent.addCategory(Intent.CATEGORY_DEFAULT); if (outputImage != null) { if
		 * (Build.VERSION.SDK_INT >= 24) {
		 * intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION); mImageUri =
		 * FileProvider.getUriForFile(getActivity(),
		 * "cn.fonxnickel.officialcamerademo.fileprovider", outputImage); } else {
		 * 
		 * mImageUri = Uri.fromFile(outputImage); }
		 * 
		 * } intent.putExtra(MediaStore.Images.Media.ORIENTATION, 0);
		 * intent.putExtra(MediaStore.EXTRA_OUTPUT, mImageUri);
		 * startActivityForResult(intent, Request_take_photo);
		 * 
		 * }
		 * 
		 * else { Toast.makeText(getActivity(), "û�м�⵽SD��", Toast.LENGTH_LONG).show(); }
		 * } });
		 */

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

	/*
	 * private void galleryAddPic(Uri uri) { Intent mediaScanIntent = new
	 * Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE); mediaScanIntent.setData(uri);
	 * getActivity().sendBroadcast(mediaScanIntent); }
	 */

	/*
	 * private void takePhoto() { Intent takePhotoIntent = new
	 * Intent(MediaStore.ACTION_IMAGE_CAPTURE); if
	 * (takePhotoIntent.resolveActivity(getActivity().getPackageManager()) != null)
	 * {
	 * 
	 * imageFile = createImageFile(); if (imageFile != null) { if
	 * (Build.VERSION.SDK_INT >= 24) {
	 * takePhotoIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION); mImageUri =
	 * FileProvider.getUriForFile(getActivity(),
	 * "cn.fonxnickel.officialcamerademo.fileprovider", imageFile); } else {
	 * 
	 * mImageUri = Uri.fromFile(imageFile); }
	 * takePhotoIntent.putExtra(MediaStore.EXTRA_OUTPUT, mImageUri);
	 * startActivityForResult(takePhotoIntent, Request_take_photo); } } }
	 */

	/*
	 * private File createImageFile() { if
	 * (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
	 * String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new
	 * Date()); String imageFileName = "JPEG_" + timeStamp + "_"; String storagePath
	 * = Environment.getExternalStorageDirectory().getAbsolutePath() + "/capture/";
	 * 
	 * File storageDir = new File(storagePath); if (!storageDir.exists()) {
	 * storageDir.mkdirs(); }
	 * 
	 * try { imageFile = File.createTempFile(imageFileName, ".jpg", storageDir); }
	 * catch (IOException e) { e.printStackTrace(); } } else {
	 * Toast.makeText(getActivity(), "û�м�⵽SD��", Toast.LENGTH_LONG).show(); } return
	 * imageFile;
	 * 
	 * }
	 */

	/*
	 * @Override public void onActivityResult(int requestCode, int resultCode,
	 * Intent data) {
	 * 
	 * super.onActivityResult(requestCode, resultCode, data); if (requestCode ==
	 * Request_take_photo && resultCode == Activity.RESULT_OK) { try {
	 * 
	 * Bitmap bitmap = BitmapFactory
	 * .decodeStream(getActivity().getContentResolver().openInputStream(mImageUri));
	 * imgv1.setImageBitmap(bitmap); galleryAddPic(mImageUri); } catch
	 * (FileNotFoundException e) { e.printStackTrace(); } }
	 * 
	 * }
	 */
	private void init() {
		if (Build.VERSION.SDK_INT >= 23) {
			requestPermissions(new String[] { Manifest.permission.WRITE_EXTERNAL_STORAGE,
					Manifest.permission.RECORD_AUDIO, Manifest.permission.CAMERA }, 200);
		}

		mThumbnail = (Button) getActivity().findViewById(R.id.thumbnail);
		mFullSize = (Button) getActivity().findViewById(R.id.fullSize);
		// mAddGallery = (Button) getActivity().findViewById(R.id.addGallery);
		mImageView = (ImageView) getActivity().findViewById(R.id.imageView);

		mThumbnail.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
				if (takePictureIntent.resolveActivity(getActivity().getPackageManager()) != null) {// �ж��Ƿ������Ӧ��
					startActivityForResult(takePictureIntent, REQ_THUMB);
				}
			}
		});

		mFullSize.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
				// Ensure that there's a camera activity to handle the intent
				if (takePictureIntent.resolveActivity(getActivity().getPackageManager()) != null) {// �ж��Ƿ������Ӧ��
					// Create the File where the photo should go
					File photoFile = null;
					try {
						photoFile = createImageFile();// ������ʱͼƬ�ļ�

					} catch (IOException ex) {
						ex.printStackTrace();
					}
					// Continue only if the File was successfully created
					if (photoFile != null) {
						// FileProvider ��һ������� ContentProvider �����࣬
						// ��ʹ�� content:// Uri ������ file:/// Uri. �����������Ұ�ȫ��Ϊ��һ��app�����ļ�
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
		// .getExternalFilesDir()�������Ի�ȡ�� SDCard/Android/data/���Ӧ�õİ���/files/
		// Ŀ¼��һ���һЩ��ʱ�䱣�������
		File storageDir = getActivity().getExternalFilesDir(Environment.DIRECTORY_PICTURES);
		// ������ʱ�ļ�,�ļ�ǰ׺�������������ַ�,��׺���Ϊ��Ĭ��δ".tmp"
		File image = File.createTempFile(imageFileName, /* ǰ׺ */
				".jpg", /* ��׺ */
				storageDir /* �ļ��� */
		);
		mCurrentPhotoPath = image.getAbsolutePath();
		return image;
	}

	/*
	 * String mPublicPhotoPath;
	 * 
	 * private File createPublicImageFile() throws IOException { File path =
	 * Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM); //
	 * Create an image file name
	 * 
	 * String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss",
	 * Locale.CHINA).format(new Date()); String imageFileName = "JPEG_" + timeStamp;
	 * File image = File.createTempFile(imageFileName, ǰ׺ ".jpg", ��׺ path �ļ��� );
	 * mPublicPhotoPath = image.getAbsolutePath(); return image; }
	 */
	/*
	 * private void galleryAddPic() { Intent mediaScanIntent = new
	 * Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE); File f = new
	 * File(mPublicPhotoPath); Uri photoURI3 =
	 * FileProvider.getUriForFile(getActivity(), "com.youga.fileprovider", f);
	 * mediaScanIntent.setData(photoURI3);
	 * getActivity().sendBroadcast(mediaScanIntent); }
	 */

	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		switch (requestCode) {
		case REQ_THUMB:// ���ؽ��
			if (resultCode != Activity.RESULT_OK)
				return;
			Bundle extras = data.getExtras();
			Bitmap imageBitmap = (Bitmap) extras.get("data");
			mImageView.setImageBitmap(imageBitmap);
			break;
		case REQ_TAKE_PHOTO:// ���ؽ��
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
			// galleryAddPic(photoURI3);
			MediaStore.Images.Media.insertImage(getActivity().getContentResolver(), bitmap, null, null);
			break;

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
