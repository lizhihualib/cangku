package com.chinasoft.junling.bean;

import java.util.Date;

public class Chapter {
	private int cId;
	private String cNumber;
	private String cName;
	private String cContents;
	private Date cUploadTime;
	private int book_bId;
	public int getcId() {
		return cId;
	}
	public void setcId(int cId) {
		this.cId = cId;
	}
	public String getcNumber() {
		return cNumber;
	}
	public void setcNumber(String cNumber) {
		this.cNumber = cNumber;
	}
	public String getcName() {
		return cName;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}
	public String getcContents() {
		return cContents;
	}
	public void setcContents(String cContents) {
		this.cContents = cContents;
	}
	public Date getcUploadTime() {
		return cUploadTime;
	}
	public void setcUploadTime(Date cUploadTime) {
		this.cUploadTime = cUploadTime;
	}
	public int getBook_bId() {
		return book_bId;
	}
	public void setBook_bId(int book_bId) {
		this.book_bId = book_bId;
	}
	@Override
	public String toString() {
		return "Chapter [cId=" + cId + ", cNumber=" + cNumber + ", cName=" + cName + ", cContents=" + cContents
				+ ", cUploadTime=" + cUploadTime + ", book_bId=" + book_bId + "]";
	}
	
	
}
