package com.chinasoft.junling.bean;

import java.util.Date;

public class Books {
	private int bId;
	private String bName;
	private String bType;
	private String bState;
	private String bIntro;
	private int bClicks;
	private String bDownloads;
	private Date bEdittime;
	private Date bOverTime;
	private int users_uId;
	public int getbId() {
		return bId;
	}
	public void setbId(int bId) {
		this.bId = bId;
	}
	public String getbName() {
		return bName;
	}
	public void setbName(String bName) {
		this.bName = bName;
	}
	public String getbType() {
		return bType;
	}
	public void setbType(String bType) {
		this.bType = bType;
	}
	public String getbState() {
		return bState;
	}
	public void setbState(String bState) {
		this.bState = bState;
	}
	public String getbIntro() {
		return bIntro;
	}
	public void setbIntro(String bIntro) {
		this.bIntro = bIntro;
	}
	public int getbClicks() {
		return bClicks;
	}
	public void setbClicks(int bClicks) {
		this.bClicks = bClicks;
	}
	public String getbDownloads() {
		return bDownloads;
	}
	public void setbDownloads(String bDownloads) {
		this.bDownloads = bDownloads;
	}
	public Date getbEdittime() {
		return bEdittime;
	}
	public void setbEdittime(Date bEdittime) {
		this.bEdittime = bEdittime;
	}
	public Date getbOverTime() {
		return bOverTime;
	}
	public void setbOverTime(Date bOverTime) {
		this.bOverTime = bOverTime;
	}
	public int getUsers_uId() {
		return users_uId;
	}
	public void setUsers_uId(int users_uId) {
		this.users_uId = users_uId;
	}
	@Override
	public String toString() {
		return "Books [bId=" + bId + ", bName=" + bName + ", bType=" + bType + ", bState=" + bState + ", bIntro="
				+ bIntro + ", bClicks=" + bClicks + ", bDownloads=" + bDownloads + ", bEdittime=" + bEdittime
				+ ", bOverTime=" + bOverTime + ", users_uId=" + users_uId + "]";
	}
	
	
}