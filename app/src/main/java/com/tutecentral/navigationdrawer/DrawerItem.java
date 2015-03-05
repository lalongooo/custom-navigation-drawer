package com.tutecentral.navigationdrawer;


public class DrawerItem {

	String ItemName;
	int imgResID;
	String title;
	boolean isProfileSection;

	public DrawerItem(String itemName, int imgResID) {
		ItemName = itemName;
		this.imgResID = imgResID;
	}

	public DrawerItem(String itemName, boolean isProfileSection) {
		this(null, 0);
		ItemName = itemName;
		this.isProfileSection = isProfileSection;
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

}
