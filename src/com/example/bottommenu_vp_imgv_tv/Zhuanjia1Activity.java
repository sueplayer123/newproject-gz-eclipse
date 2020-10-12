package com.example.bottommenu_vp_imgv_tv;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class Zhuanjia1Activity extends Activity {
	private TextView textView1;
	private TextView textView2;
	private TextView textView3;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_zhuanjia1);
		textView1 = (TextView) findViewById(R.id.textView1);
		textView2 = (TextView) findViewById(R.id.textView2);
		textView3 = (TextView) findViewById(R.id.textView3);
		textView1.setText("李四");
		textView2.setText("二次回路");
		textView3.setText("13847264564");
	}
}
