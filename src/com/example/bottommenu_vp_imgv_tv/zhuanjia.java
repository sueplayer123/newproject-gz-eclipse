package com.example.bottommenu_vp_imgv_tv;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class zhuanjia extends Activity {
	private TextView textView1;
	private TextView textView2;
	private TextView textView3;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.zhangsan);
		textView1 = (TextView) findViewById(R.id.textView1);
		textView2 = (TextView) findViewById(R.id.textView2);
		textView3 = (TextView) findViewById(R.id.textView3);
		Bundle bundle = getIntent().getExtras();
		textView1.setText(bundle.getString("xinxi1"));
		textView2.setText(bundle.getString("xinxi2"));
		textView3.setText(bundle.getString("telphone"));

	}

}
