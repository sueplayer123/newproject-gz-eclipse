package com.example.bottommenu_vp_imgv_tv;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class zhuanjia extends Activity {
	private TextView textView1;
	private TextView textView2;
	private TextView textView3;
	private TextView textView4;
	private TextView textView5;
	private TextView textView6;
	private TextView textView7;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.zhangsan);
		textView1 = (TextView) findViewById(R.id.textView1);
		textView2 = (TextView) findViewById(R.id.textView2);
		textView3 = (TextView) findViewById(R.id.textView3);
		textView4 = (TextView) findViewById(R.id.textView4);
		textView5 = (TextView) findViewById(R.id.textView5);
		textView6 = (TextView) findViewById(R.id.textView6);
		textView7 = (TextView) findViewById(R.id.textView7);
		textView1.setTextSize(20);
		textView2.setTextSize(20);
		textView3.setTextSize(20);
		textView4.setTextSize(20);
		textView5.setTextSize(20);
		textView6.setTextSize(20);
		textView7.setTextSize(20);
		Bundle bundle = getIntent().getExtras();
		textView1.setText(bundle.getString("xinxi1"));
		textView2.setText(bundle.getString("xinxi2"));
		textView4.setText(bundle.getString("xinxi3"));
		textView5.setText(bundle.getString("xinxi4"));
		textView6.setText(bundle.getString("xinxi5"));
		textView7.setText(bundle.getString("xinxi6"));
		textView3.setText(bundle.getString("telphone"));

	}

}
