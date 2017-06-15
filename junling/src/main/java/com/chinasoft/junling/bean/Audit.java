package com.chinasoft.junling.bean;

public class Audit {
	private int aId;
	private String uIdCard;
	private String uImg;
	private String uProduction;
	private String aResult;
	private int users_uId;
	public int getaId() {
		return aId;
	}
	public void setaId(int aId) {
		this.aId = aId;
	}
	public String getuIdCard() {
		return uIdCard;
	}
	public void setuIdCard(String uIdCard) {
		this.uIdCard = uIdCard;
	}
	public String getuImg() {
		return uImg;
	}
	public void setuImg(String uImg) {
		this.uImg = uImg;
	}
	public String getuProduction() {
		return uProduction;
	}
	public void setuProduction(String uProduction) {
		this.uProduction = uProduction;
	}
	public String getaResult() {
		return aResult;
	}
	public void setaResult(String aResult) {
		this.aResult = aResult;
	}
	public int getUsers_uId() {
		return users_uId;
	}
	public void setUsers_uId(int users_uId) {
		this.users_uId = users_uId;
	}
	@Override
	public String toString() {
		return "Audit [aId=" + aId + ", uIdCard=" + uIdCard + ", uImg=" + uImg + ", uProduction=" + uProduction
				+ ", aResult=" + aResult + ", users_uId=" + users_uId + "]";
	}
	
	
}
