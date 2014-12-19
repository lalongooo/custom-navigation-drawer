package com.xihuani.tyket.ui;

import java.util.Timer;
import java.util.TimerTask;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.TextView;

import com.xihuani.tyket.R;
import com.xihuani.tyket.config.Config;

public class SplashActivity extends ActionBarActivity {

	TextView myInput;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash);
		
		TimerTask task = new TimerTask() {

			@Override
			public void run() {
				Intent mainIntent = new Intent().setClass(SplashActivity.this, ActivityLogin.class);
				startActivity(mainIntent);
			}

		};

		Timer timer = new Timer();
		timer.schedule(task, Config.SPLASH_SCREEN_DELAY);
	}

}
