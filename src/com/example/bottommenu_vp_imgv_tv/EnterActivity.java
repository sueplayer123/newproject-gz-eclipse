package com.example.bottommenu_vp_imgv_tv;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class EnterActivity extends Activity implements View.OnClickListener {

	private EditText editPerson, editCode;
	private TextView textViewR;
	private Button btn;
	private boolean autoLogin = false;
	public static String currentUsername;
	private String currentPassword;
	private boolean progressShow;
	private ImageView qq, weixin, weibo;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login_enter_activity);
		init();
	}

	private void init() {
		btn = (Button) findViewById(R.id.bn_common_login);
		btn.setOnClickListener(this);
		editCode = (EditText) findViewById(R.id.et_password);
		editPerson = (EditText) findViewById(R.id.et_username);
		textViewR = (TextView) findViewById(R.id.tv_register);
		qq = (ImageView) findViewById(R.id.iv_qq_login);
		weixin = (ImageView) findViewById(R.id.iv_weixin_login);
		weibo = (ImageView) findViewById(R.id.iv_sina_login);
		qq.setOnClickListener(this);
		weixin.setOnClickListener(this);
		weibo.setOnClickListener(this);
		textViewR.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.bn_common_login:
			login(v);
			break;
		case R.id.tv_register:
			Intent intent = new Intent(this, RegisterActivity.class);
			startActivity(intent);
			finish();
			break;
		case R.id.iv_qq_login:
			Toast.makeText(this, "QQ登录", Toast.LENGTH_SHORT).show();
			break;
		case R.id.iv_weixin_login:
			Toast.makeText(this, "微信登录", Toast.LENGTH_SHORT).show();
			break;
		case R.id.iv_sina_login:
			Toast.makeText(this, "微博登录", Toast.LENGTH_SHORT).show();
			break;

		}
	}

	@Override
	protected void onResume() {
		super.onResume();
		if (autoLogin) {
			return;
		}
	}

	public void login(View view) {

		currentUsername = editPerson.getText().toString().trim();
		currentPassword = editCode.getText().toString().trim();

		if (TextUtils.isEmpty(currentUsername)) {
			Toast.makeText(this, R.string.User_name_cannot_be_empty, Toast.LENGTH_SHORT).show();
			return;
		}
		if (TextUtils.isEmpty(currentPassword)) {
			Toast.makeText(this, R.string.Password_cannot_be_empty, Toast.LENGTH_SHORT).show();
			return;
		}

		progressShow = true;
		final ProgressDialog pd = new ProgressDialog(EnterActivity.this);

		pd.setCanceledOnTouchOutside(false);
		pd.setOnCancelListener(new DialogInterface.OnCancelListener() {

			@Override
			public void onCancel(DialogInterface dialog) {
				progressShow = false;
			}
		});
		pd.setMessage("正在登录....");
		pd.show();

		new Thread(new Runnable() {
			public void run() {

				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
				}

				pd.dismiss();
				Intent intent = new Intent(EnterActivity.this, MainActivity.class);
				startActivity(intent);
				finish();
			}
		}).start();

	}

}
