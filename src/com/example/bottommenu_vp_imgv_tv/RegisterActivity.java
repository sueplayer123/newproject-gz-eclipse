package com.example.bottommenu_vp_imgv_tv;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class RegisterActivity extends Activity implements View.OnClickListener {

	private String realCode;
	private DBOpenHelper mDBOpenHelper;
	private Button mBtRegisteractivityRegister;
	private RelativeLayout mRlRegisteractivityTop;
	private ImageView mIvRegisteractivityBack;
	private LinearLayout mLlRegisteractivityBody;
	private EditText mEtRegisteractivityUsername;
	private EditText mEtRegisteractivityPassword1;
	private EditText mEtRegisteractivityPassword2;
	private EditText mEtRegisteractivityPhonecodes;
	private ImageView mIvRegisteractivityShowcode;
	private RelativeLayout mRlRegisteractivityBottom;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register);

		initView();

		mDBOpenHelper = new DBOpenHelper(this);

		mIvRegisteractivityShowcode.setImageBitmap(Code.getInstance().createBitmap());
		realCode = Code.getInstance().getCode().toLowerCase();
	}

	private void initView() {
		mBtRegisteractivityRegister = findViewById(R.id.bt_registeractivity_register);
		mRlRegisteractivityTop = findViewById(R.id.rl_registeractivity_top);
		mIvRegisteractivityBack = findViewById(R.id.iv_registeractivity_back);
		mLlRegisteractivityBody = findViewById(R.id.ll_registeractivity_body);
		mEtRegisteractivityUsername = findViewById(R.id.et_registeractivity_username);
		mEtRegisteractivityPassword1 = findViewById(R.id.et_registeractivity_password1);
		mEtRegisteractivityPassword2 = findViewById(R.id.et_registeractivity_password2);
		mEtRegisteractivityPhonecodes = findViewById(R.id.et_registeractivity_phoneCodes);
		mIvRegisteractivityShowcode = findViewById(R.id.iv_registeractivity_showCode);
		mRlRegisteractivityBottom = findViewById(R.id.rl_registeractivity_bottom);

		mIvRegisteractivityBack.setOnClickListener(this);
		mIvRegisteractivityShowcode.setOnClickListener(this);
		mBtRegisteractivityRegister.setOnClickListener(this);
	}

	public void onClick(View view) {
		switch (view.getId()) {
		case R.id.iv_registeractivity_back:
			Intent intent1 = new Intent(this, loginActivity.class);
			startActivity(intent1);
			finish();
			break;
		case R.id.iv_registeractivity_showCode:
			mIvRegisteractivityShowcode.setImageBitmap(Code.getInstance().createBitmap());
			realCode = Code.getInstance().getCode().toLowerCase();
			break;
		case R.id.bt_registeractivity_register:
			String username = mEtRegisteractivityUsername.getText().toString().trim();
			String password = mEtRegisteractivityPassword2.getText().toString().trim();
			String phoneCode = mEtRegisteractivityPhonecodes.getText().toString().toLowerCase();
			if (!TextUtils.isEmpty(username) && !TextUtils.isEmpty(password) && !TextUtils.isEmpty(phoneCode)) {
				if (phoneCode.equals(realCode)) {
					mDBOpenHelper.add(username, password);
					Intent intent2 = new Intent(this, loginActivity.class);
					startActivity(intent2);
					finish();
					Toast.makeText(this, "验证通过，注册成功", Toast.LENGTH_SHORT).show();
				} else {
					Toast.makeText(this, "验证码错误,注册失败", Toast.LENGTH_SHORT).show();
				}
			} else {
				Toast.makeText(this, "未完善信息，注册失败", Toast.LENGTH_SHORT).show();
			}
			break;
		}
	}
}
