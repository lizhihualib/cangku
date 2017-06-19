package com.chinasoft.junling.bean;

public class Page {
private int curPage=1;
private int pageSize=2;
private int star;
 
public int getCurPage() {
	return curPage;
}
public void setCurPage(int curPage) {
	this.curPage = curPage;
}
public int getPageSize() {
	return pageSize;
}
public void setPageSize(int pageSize) {
	this.pageSize = pageSize;
}
public int getStar() {
	return (curPage-1)*pageSize;
}
public void setStar(int star) {
	this.star =star;
}
@Override
public String toString() {
	return "Page [curPage=" + curPage + ", pageSize=" + pageSize + ", star=" + star + "]";
}



}
