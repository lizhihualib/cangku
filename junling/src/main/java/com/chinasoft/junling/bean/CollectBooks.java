package com.chinasoft.junling.bean;

public class CollectBooks {
	private int colId;
	private int users_uId;
	private int books_bId;
	public int getColId() {
		return colId;
	}
	public void setColId(int colId) {
		this.colId = colId;
	}
	public int getUsers_uId() {
		return users_uId;
	}
	public void setUsers_uId(int users_uId) {
		this.users_uId = users_uId;
	}
	public int getBooks_bId() {
		return books_bId;
	}
	public void setBooks_bId(int books_bId) {
		this.books_bId = books_bId;
	}
	@Override
	public String toString() {
		return "CollectBooks [colId=" + colId + ", users_uId=" + users_uId + ", books_bId=" + books_bId + "]";
	}
	
	
}
