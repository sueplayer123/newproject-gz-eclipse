package com.example.bottommenu_vp_imgv_tv;

import android.app.Activity;
import android.os.Bundle;
import android.widget.RatingBar;
import android.widget.RatingBar.OnRatingBarChangeListener;
import android.widget.TextView;
import android.widget.Toast;

public class RatingActivity extends Activity {
	private RatingBar ratingBar1;
	private TextView textView1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_rating);
		ratingBar1 = (RatingBar) this.findViewById(R.id.ratingBar1);
		textView1 = (TextView) this.findViewById(R.id.textView1);
		Bundle bundle = getIntent().getExtras();
		textView1.setText(bundle.getString("name1"));
		ratingBar1.setOnRatingBarChangeListener(new OnRatingBarChangeListener() {

			@Override
			public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
				Toast.makeText(RatingActivity.this, "你的评价得分为" + String.valueOf(rating * 20) + "分", Toast.LENGTH_LONG)
						.show();
			}
		});

	}
}
