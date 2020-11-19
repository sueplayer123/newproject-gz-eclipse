package com.example.bottommenu_vp_imgv_tv;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;

public class SplashActivity extends Activity {
	private ImageView welcomeImg;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);
		welcomeImg = (ImageView) this.findViewById(R.id.welcomeImg);
		AlphaAnimation anima = new AlphaAnimation(0.3f, 1.0f);
		anima.setDuration(3000);// ���ö�����ʾʱ��
		welcomeImg.startAnimation(anima);
		anima.setAnimationListener(new AnimationImpl());
	}

	private class AnimationImpl implements AnimationListener {

		public void onAnimationStart(Animation animation) {
			welcomeImg.setBackgroundResource(R.drawable.welcome_image);
		}

		public void onAnimationEnd(Animation animation) {
			skip(); // ������������ת�����ҳ��
		}

		public void onAnimationRepeat(Animation animation) {

		}

	}

	private void skip() {
		startActivity(new Intent(SplashActivity.this, EnterActivity.class));
		finish();
	}
}
