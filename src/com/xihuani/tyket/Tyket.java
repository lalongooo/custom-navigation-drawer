package com.xihuani.tyket;

import android.app.Application;

import com.parse.Parse;

public class Tyket extends Application {

	static final String TAG = "Tyket";

	@Override
	public void onCreate() {
		super.onCreate();

		Parse.initialize(this,
				getString(R.string.parse_application_id),
				getString(R.string.parse_client_key)
		);
	}
}