package com.kentzi.ui;

import java.util.Arrays;
import java.util.List;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;

import com.kentzi.R;
import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseFacebookUtils;
import com.parse.ParseUser;
import com.tutecentral.navigationdrawer.MainActivity;

public class ActivityLogin extends ActionBarActivity {

	private Dialog progressDialog;
	private String TAG = ActivityLogin.class.getName();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);

		/*
		 * Check if there is a currently logged in
		 * user and it's linked to a Facebook account.
		 */
		
		ParseUser currentUser = ParseUser.getCurrentUser();
		if ((currentUser != null) && ParseFacebookUtils.isLinked(currentUser)) {
			goToMainActivity();
		}
	}

	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		ParseFacebookUtils.finishAuthentication(requestCode, resultCode, data);
	}

	public void onFacebookLoginClick(View v) {
		progressDialog = ProgressDialog.show(ActivityLogin.this, "", "Logging in...", true);

		/*
		 * NOTE: for extended permissions, like "user_about_me", your app must
		 * be reviewed by the Facebook team
		 * (https://developers.facebook.com/docs/facebook-login/permissions/) 
		 * */
		
		List<String> permissions = Arrays.asList("public_profile", "email");

		ParseFacebookUtils.logIn(permissions, this, new LogInCallback() {
			@Override
			public void done(ParseUser user, ParseException err) {
				progressDialog.dismiss();
				if (user == null) {
					Log.d(TAG, "Uh oh. The user cancelled the Facebook login.");
				} else if (user.isNew()) {
					Log.d(TAG, "User signed up and logged in through Facebook!");
					goToMainActivity();
				} else {
					Log.d(TAG, "User logged in through Facebook!");
					goToMainActivity();
				}
			}
		});
	}
	
	private void goToMainActivity() {
		Intent intent = new Intent(this, MainActivity.class);
		startActivity(intent);
		finish();
	}

}
