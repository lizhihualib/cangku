package com.chinasoft.junling.bean;

public class Inform {
	private int iId;
	private String iContent;
	private int users_uId;
	public int getiId() {
		return iId;
	}
	public void setiId(int iId) {
		this.iId = iId;
	}
	public String getiContent() {
		return iContent;
	}
	public void setiContent(String iContent) {
		this.iContent = iContent;
	}
	public int getUsers_uId() {
		return users_uId;
	}
	public void setUsers_uId(int users_uId) {
		this.users_uId = users_uId;
	}
	@Override
	public String toString() {
		return "Inform [iId=" + iId + ", iContent=" + iContent + ", users_uId=" + users_uId + "]";
	}
	
}
