package com.tutecentral.navigationdrawer;

public class DrawerItem {

	String ItemName;
	int imgResID;
	String title;
	boolean isProfileSection;
	UserProfileDrawerItem userProfileDrawerItem;
	

	public DrawerItem(String itemName, int imgResID) {
		ItemName = itemName;
		this.imgResID = imgResID;
	}

	public DrawerItem(String itemName, boolean isSpinner, UserProfileDrawerItem userProfileDrawerItem) {
		this(null, 0);
		ItemName = itemName;
		this.isProfileSection = isSpinner;
		this.userProfileDrawerItem = userProfileDrawerItem;
	}

	public DrawerItem(String title) {
		this(null, 0);
		this.title = title;
	}

	public String getItemName() {
		return ItemName;
	}

	public void setItemName(String itemName) {
		ItemName = itemName;
	}

	public int getImgResID() {
		return imgResID;
	}

	public void setImgResID(int imgResID) {
		this.imgResID = imgResID;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public boolean isProfileSection() {
		return isProfileSection;
	}

	public UserProfileDrawerItem getUserProfileDrawerItem() {
		return userProfileDrawerItem;
	}

	public void setUserProfileDrawerItem(UserProfileDrawerItem userProfileDrawerItem) {
		this.userProfileDrawerItem = userProfileDrawerItem;
	}

}
