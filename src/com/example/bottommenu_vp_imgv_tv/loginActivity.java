package com.example.bottommenu_vp_imgv_tv;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class loginActivity extends Activity implements View.OnClickListener {

	private DBOpenHelper mDBOpenHelper;
	private TextView mTvLoginactivityRegister;
	private RelativeLayout mRlLoginactivityTop;
	private EditText mEtLoginactivityUsername;
	private EditText mEtLoginactivityPassword;
	private LinearLayout mLlLoginactivityTwo;
	private Button mBtLoginactivityLogin;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);

		initView();

		mDBOpenHelper = new DBOpenHelper(this);
	}

	private void initView() {
		mBtLoginactivityLogin = findViewById(R.id.bt_loginactivity_login);
		mTvLoginactivityRegister = findViewById(R.id.tv_loginactivity_register);
		mRlLoginactivityTop = findViewById(R.id.rl_loginactivity_top);
		mEtLoginactivityUsername = findViewById(R.id.et_loginactivity_username);
		mEtLoginactivityPassword = findViewById(R.id.et_loginactivity_password);
		mLlLoginactivityTwo = findViewById(R.id.ll_loginactivity_two);

		mBtLoginactivityLogin.setOnClickListener(this);
		mTvLoginactivityRegister.setOnClickListener(this);
	}

	public void onClick(View view) {
		switch (view.getId()) {
		case R.id.tv_loginactivity_register:
			startActivity(new Intent(this, RegisterActivity.class));
			finish();
			break;

		case R.id.bt_loginactivity_login:
			String name = mEtLoginactivityUsername.getText().toString().trim();
			String password = mEtLoginactivityPassword.getText().toString().trim();
			if (!TextUtils.isEmpty(name) && !TextUtils.isEmpty(password)) {
				ArrayList<User> data = mDBOpenHelper.getAllData();
				boolean match = false;
				for (int i = 0; i < data.size(); i++) {
					User user = data.get(i);
					if (name.equals(user.getName()) && password.equals(user.getPassword())) {
						match = true;
						break;
					} else {
						match = false;
					}
				}
				if (match) {
					Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show();
					Intent intent = new Intent(this, MainActivity.class);
					startActivity(intent);
					finish();
				} else {
					Toast.makeText(this, "用户名或密码不正确，请重新输入", Toast.LENGTH_SHORT).show();
				}
			} else {
				Toast.makeText(this, "请输入你的用户名或密码", Toast.LENGTH_SHORT).show();
			}
			break;
		}
	}
}
