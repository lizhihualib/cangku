package com.chinasoft.junling.bean;

import java.util.Date;

public class Comments {
	private int coId;
	private String coContents;
	private Date coTime;
	private int coParentComments;
	private int book_bId;
	private int comments_coId;
	private int users_uId;
	public int getCoId() {
		return coId;
	}
	public void setCoId(int coId) {
		this.coId = coId;
	}
	public String getCoContents() {
		return coContents;
	}
	public void setCoContents(String coContents) {
		this.coContents = coContents;
	}
	public Date getCoTime() {
		return coTime;
	}
	public void setCoTime(Date coTime) {
		this.coTime = coTime;
	}
	public int getCoParentComments() {
		return coParentComments;
	}
	public void setCoParentComments(int coParentComments) {
		this.coParentComments = coParentComments;
	}
	public int getBook_bId() {
		return book_bId;
	}
	public void setBook_bId(int book_bId) {
		this.book_bId = book_bId;
	}
	public int getComments_coId() {
		return comments_coId;
	}
	public void setComments_coId(int comments_coId) {
		this.comments_coId = comments_coId;
	}
	public int getUsers_uId() {
		return users_uId;
	}
	public void setUsers_uId(int users_uId) {
		this.users_uId = users_uId;
	}
	@Override
	public String toString() {
		return "Comments [coId=" + coId + ", coContents=" + coContents + ", coTime=" + coTime + ", coParentComments="
				+ coParentComments + ", book_bId=" + book_bId + ", comments_coId=" + comments_coId + ", users_uId="
				+ users_uId + "]";
	}
	
	
}
