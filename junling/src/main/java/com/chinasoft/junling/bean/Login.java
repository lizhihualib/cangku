package com.chinasoft.junling.bean;

public class Login {
private int lID;
private String uName;
private String uPwd;
private String uType;

private int users_uId;

public int getlID() {
	return lID;
}
public void setlID(int lID) {
	this.lID = lID;
}
public String getuName() {
	return uName;
}
public void setuName(String uName) {
	this.uName = uName;
}
public String getuPwd() {
	return uPwd;
}
public void setuPwd(String uPwd) {
	this.uPwd = uPwd;
}
public String getuType() {
	return uType;
}
public void setuType(String uType) {
	this.uType = uType;
}

@Override
public String toString() {
	return "Login [id=" + lID + ", uName=" + uName + ", uPwd=" + uPwd + ", uType=" + uType + ", users_uId=" + users_uId
			+ "]";
}

}
