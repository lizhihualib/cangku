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
<title>Insert title here</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>个人信息</title>
<script type="text/javascript" src="/junling/jquery-easyui-1.5.2/jquery.min.js"></script>
<script type="text/javascript" src="/junling/jquery-easyui-1.5.2/jquery.easyui.min.js"></script>
<link  rel="stylesheet" href="/junling/jquery-easyui-1.5.2/themes/icon.css">
<link rel="stylesheet" href="/junling/jquery-easyui-1.5.2/themes/metro/easyui.css">
<link rel="stylesheet" href="/junling/css/main.css">
<script type="text/javascript">

	$.ajax({
		url:"<%=basePath%>UserHandle/personalInformation.action",
		type:"post",
		dataType:"json",
		data:{
			lID:"${sessionScope.loginBean.getlID()}"
		},
		success:function(data){
			//var json=eval("("+data+")");
			$("#uName").val(data.login.uName);
			$("#uRealName").val(data.uRealName);
			$("#uSex").val(data.uSex);
		
			$("#uPhone").val(data.uPhone);
			$("#uEmail").val(data.uEmail);
			$("#uPenName").val(data.uPenName);
			$("#uBankCard").val(data.uBankCard);
			$('#uBirthday').datebox('setValue', data.uBirthday);	
		}
	})

	

</script>
</head>
<body>
	<form id="myInfo">
		<div style="margin-left: 400px;margin-top: 150px; ">
			<table>
				<tr>
					<td><label>用&nbsp;&nbsp;户&nbsp;&nbsp;名：</label></td>
					<td><input id="uName" ></td>
				</tr>
				<tr style="height: 15px;"></tr>
				<tr>
					<td><label>性&nbsp;&nbsp;&nbsp;&nbsp;别：</label></td>
					<td><input id="uSex" ></td>
				</tr>
				<tr style="height: 15px;"></tr>
				<tr>
					<td><label>生&nbsp;&nbsp;&nbsp;&nbsp;日：</label></td>
					<td><input id="uBirthday" class="easyui-datebox" required="required"></td>
				</tr>
				<tr style="height: 15px;"></tr>
				<tr>
					<td><label>电话号码：</label></td>
					<td><input id="uPhone"></td>
				</tr>
				<tr style="height: 15px;"></tr>
				<tr>
					<td><label>Email：</label></td>
					<td><input id="uEmail"></td>
				</tr>
				<tr style="height: 15px;"></tr>
				<tr>
					<td><label>笔&nbsp;&nbsp;&nbsp;&nbsp;名：</label></td>
					<td><input id="uPenName"></td>
				</tr>
				<tr style="height: 15px;"></tr>
				<tr>
					<td><label>银行卡号：</label></td>
					<td><input id="uBankCard"></td>
				</tr>
				<tr style="height: 15px;"></tr>
			</table>
			<input type="button" value="提交" 
				   style="margin-left: 100px;
				   background-color: green;
				   width: 80px;
				   height: 40px;
				   font-size: 20px;">
		</div>
	</form>
</body>
</html>