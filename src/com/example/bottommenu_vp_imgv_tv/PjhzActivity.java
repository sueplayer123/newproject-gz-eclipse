package com.example.bottommenu_vp_imgv_tv;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class PjhzActivity extends Activity {
	private TextView textVie1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_pjhz);
		textVie1 = (TextView) this.findViewById(R.id.textVie1);
		Bundle bundle = getIntent().getExtras();
		String pjdataString = bundle.getString("pingjia");
		textVie1.setText(pjdataString);
		/*
		 * MeFragment myFragment = new MeFragment(); Bundle bundle1 = new Bundle();
		 * bundle1.putString("DATA", pjdataString); myFragment.setArguments(bundle1);
		 */

	}
}
