<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %> 
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%  
String path = request.getContextPath();  
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  
%> 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>个人信息</title>
<script type="text/javascript" src="/junling/jquery-easyui-1.5.2/jquery.min.js"></script>
<script type="text/javascript" src="/junling/jquery-easyui-1.5.2/jquery.easyui.min.js"></script>
<link  rel="stylesheet" href="/junling/jquery-easyui-1.5.2/themes/icon.css">
<link rel="stylesheet" href="/junling/jquery-easyui-1.5.2/themes/metro/easyui.css">
<link rel="stylesheet" href="/junling/css/main.css">
<script type="text/javascript">
$(function(){
	$.ajax({
		url:"<%=basePath%>UserHandle/personalInformation.action",
		type:"post",
		dataType:"json",
		data:{
			lID:"${sessionScope.loginBean.getlID()}"
		},
		success:function(data){
			//var json=eval("("+data+")");
			$("#uName").html(data.login.uName);
			$("#uRealName").html(data.uRealName);
			$("#uSex").html(data.uSex);
			$("#uBirthday").html(data.uBirthday);
			$("#uPhone").html(data.uPhone);
			$("#uEmail").html(data.uEmail);
			$("#uPenName").html(data.uPenName);
			$("#uBeans").html(data.uBeans);
			$("#uBankCard").html(data.uBankCard);
			$("#uUploadNumbers").html(data.uUploadNumbers);
			$("#uType").html(data.login.uType);
		}
	})
})
</script>
</head>
<body>
	<form id="myInfo">
		<div style="padding-top: 30px;">
			<label>用&nbsp;&nbsp;户&nbsp;&nbsp;名：</label>
			<span id="uName" style="margin-left: 18px;color: blue;"></span>
			<br/><br/>
			<label>真实姓名：</label>
			<span id="uRealName" style="margin-left: 20px;color: blue;"></span>
			<br/><br/>
			<label>性&nbsp;&nbsp;&nbsp;&nbsp;别：</label>
			<span id="uSex" style="margin-left: 32px;color: blue;"></span>
			<br/><br/>
			<label>生&nbsp;&nbsp;&nbsp;&nbsp;日：</label>
			<span id="uBirthday" style="margin-left: 33px;color: blue;"></span>
			<br/><br/>
			<label>电话号码：</label>
			<span id="uPhone" style="margin-left: 21px;color: blue;"></span>
			<br/><br/>
			<label>Email：</label>
			<span id="uEmail" style="margin-left: 43px;color: blue;"></span>
			<br/><br/>
			<label>笔&nbsp;&nbsp;&nbsp;&nbsp;名：</label>
			<span id="uPenName" style="margin-left: 33px;color: blue;"></span>
			<br/><br/>
			<label>阅豆数量：</label>
			<span id="uBeans" style="margin-left: 20px;color: blue;"></span>
			<br/><br/>
			<label>银行卡号：</label>
			<span id="uBankCard" style="margin-left: 20px;color: blue;"></span>
			<br/><br/>
			<label>可上传数量：</label>
			<span id="uUploadNumbers" style="margin-left: 4px;color: blue;"></span>
			<br/><br/>
			<label>用户类型：</label>
			<span id="uType" style="margin-left: 20px;color: blue;"></span>
			<br/><br/>
		</div>	
	</form>
</body>
</html>