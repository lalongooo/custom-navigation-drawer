package com.kentzi.ui;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;

import com.kentzi.R;
import com.kentzi.adapter.AppOverviewAdapter;
import com.viewpagerindicator.CirclePageIndicator;
import com.viewpagerindicator.PageIndicator;

public class ActivityAppOverview extends Activity {

	private PageIndicator indicator;
	private ViewPager viewPager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.activity_overview);
		setUI();
	}

	private void setUI() {
		
		viewPager = (ViewPager) findViewById(R.id.pager);
		indicator = (CirclePageIndicator) findViewById(R.id.indicator);
		
		AppOverviewAdapter adapter = new AppOverviewAdapter(this);
		viewPager.setAdapter(adapter);
		indicator.setViewPager(viewPager);
		
	}

}
