package com.chinasoft.junling.bean;

public class Login {
private int id;
private String uName;
private String uPwd;
private String uType;
private int users_uId;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
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
public int getUsers_uId() {
	return users_uId;
}
public void setUsers_uId(int users_uId) {
	this.users_uId = users_uId;
}
@Override
public String toString() {
	return "Login [id=" + id + ", uName=" + uName + ", uPwd=" + uPwd + ", uType=" + uType + ", users_uId=" + users_uId
			+ "]";
}

}