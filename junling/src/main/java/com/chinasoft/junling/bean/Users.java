package com.chinasoft.junling.bean;

import java.util.Date;

public class Users {
 private int uId;
 private String uRealName;
 private String uSex;
 private Date uBirthday;
 private String uPhone;
 private String uEmail;
 private String uPenName;
 private String uBeans;//月豆
 private String uBankCard;
 private String uSignState;//签到状态
 private String uUploadNumbers;//上传数量
public int getuId() {
	return uId;
}
public void setuId(int uId) {
	this.uId = uId;
}
public String getuRealName() {
	return uRealName;
}
public void setuRealName(String uRealName) {
	this.uRealName = uRealName;
}
public String getuSex() {
	return uSex;
}
public void setuSex(String uSex) {
	this.uSex = uSex;
}
public Date getuBirthday() {
	return uBirthday;
}
public void setuBirthday(Date uBirthday) {
	this.uBirthday = uBirthday;
}
public String getuPhone() {
	return uPhone;
}
public void setuPhone(String uPhone) {
	this.uPhone = uPhone;
}
public String getuEmail() {
	return uEmail;
}
public void setuEmail(String uEmail) {
	this.uEmail = uEmail;
}
public String getuPenName() {
	return uPenName;
}
public void setuPenName(String uPenName) {
	this.uPenName = uPenName;
}
public String getuBeans() {
	return uBeans;
}
public void setuBeans(String uBeans) {
	this.uBeans = uBeans;
}
public String getuBankCard() {
	return uBankCard;
}
public void setuBankCard(String uBankCard) {
	this.uBankCard = uBankCard;
}
public String getuSignState() {
	return uSignState;
}
public void setuSignState(String uSignState) {
	this.uSignState = uSignState;
}
public String getuUploadNumbers() {
	return uUploadNumbers;
}
public void setuUploadNumbers(String uUploadNumbers) {
	this.uUploadNumbers = uUploadNumbers;
}
@Override
public String toString() {
	return "Users [uId=" + uId + ", uRealName=" + uRealName + ", uSex=" + uSex + ", uBirthday=" + uBirthday
			+ ", uPhone=" + uPhone + ", uEmail=" + uEmail + ", uPenName=" + uPenName + ", uBeans=" + uBeans
			+ ", uBankCard=" + uBankCard + ", uSignState=" + uSignState + ", uUploadNumbers=" + uUploadNumbers + "]";
}
 
}
