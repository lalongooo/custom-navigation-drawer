package com.tutecentral.navigationdrawer;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.xihuani.tyket.R;

public class CustomSpinnerAdapter extends ArrayAdapter<UserProfileDrawerItem> {

	Context context;
	int layoutResID;
	List<UserProfileDrawerItem> profileData;

	public CustomSpinnerAdapter(Context context, int layoutResourceID, int textViewResourceId, List<UserProfileDrawerItem> spinnerDataList) {
		super(context, layoutResourceID, textViewResourceId, spinnerDataList);
		this.context = context;
		this.layoutResID = layoutResourceID;
		this.profileData = spinnerDataList;

	}

	public CustomSpinnerAdapter(Context context, int layoutResourceID, List<UserProfileDrawerItem> spinnerDataList) {
		super(context, layoutResourceID, spinnerDataList);
		this.context = context;
		this.layoutResID = layoutResourceID;
		this.profileData = spinnerDataList;

	}
	
	private static class SpinnerHolder {
		ImageView userImage;
		TextView name, email;
	}

	public View getCustomView(int position, View convertView, ViewGroup parent) {

		View row = convertView;
		SpinnerHolder holder;

		if (row == null) {
			LayoutInflater inflater = ((Activity) context).getLayoutInflater();

			row = inflater.inflate(layoutResID, parent, false);
			holder = new SpinnerHolder();

			holder.userImage = (ImageView) row.findViewById(R.id.left_pic);
			holder.name = (TextView) row.findViewById(R.id.text_main_name);
			holder.email = (TextView) row.findViewById(R.id.sub_text_email);

			row.setTag(holder);
		} else {
			holder = (SpinnerHolder) row.getTag();

		}

		UserProfileDrawerItem profileItem = profileData.get(position);

		holder.userImage.setImageDrawable(row.getResources().getDrawable(profileItem.getDrawableResID()));
		holder.name.setText(profileItem.getName());
		holder.email.setText(profileItem.getEmail());

		return row;

	}
	
	@Override
	public View getDropDownView(int position, View convertView, ViewGroup parent) {
		return getCustomView(position, convertView, parent);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		return getCustomView(position, convertView, parent);
	}
}
