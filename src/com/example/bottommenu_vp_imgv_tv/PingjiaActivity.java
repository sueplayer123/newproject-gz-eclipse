package com.example.bottommenu_vp_imgv_tv;

import java.io.FileOutputStream;
import java.io.PrintStream;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.RatingBar.OnRatingBarChangeListener;
import android.widget.TextView;
import android.widget.Toast;

public class PingjiaActivity extends Activity {
	private RatingBar ratingBar1;
	private TextView tex1;
	private Button btn1;
	private Button btn2;
	private EditText ed1;
	public static final String FILE_NAME3 = "file.txt";
	public static String rateString = "";
	public static String dataString = "";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_pingjia);
		ratingBar1 = (RatingBar) this.findViewById(R.id.ratingBar1);
		tex1 = (TextView) this.findViewById(R.id.tex1);
		btn1 = (Button) this.findViewById(R.id.btn1);
		btn2 = (Button) this.findViewById(R.id.btn2);
		ed1 = (EditText) this.findViewById(R.id.ed1);
		Bundle bundle = getIntent().getExtras();
		tex1.setText(bundle.getString("namestring"));
		ratingBar1.setOnRatingBarChangeListener(new OnRatingBarChangeListener() {

			@Override
			public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
				Toast.makeText(PingjiaActivity.this, "你的评价得分为" + String.valueOf(rating * 20) + "分", Toast.LENGTH_LONG)
						.show();
				rateString = String.valueOf(rating * 20);

			}
		});
		btn1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				dataString = tex1.getText().toString() + "\n" + ed1.getText().toString() + "\n" + "你的评价得分为" + rateString
						+ "分";
				write(dataString);
			}
		});
		btn2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(PingjiaActivity.this, PjhzActivity.class);
				intent.putExtra("pingjia", dataString);
				startActivity(intent);
			}
		});
	}

	private void write(String content) {
		try {
			FileOutputStream fos = openFileOutput(FILE_NAME3, Context.MODE_APPEND);
			PrintStream ps = new PrintStream(fos);
			ps.println(content);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
