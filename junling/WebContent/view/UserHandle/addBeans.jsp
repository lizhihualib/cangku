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
<title>阅豆充值</title>
</head>
<body>
	<div id="dd" 
		 class="easyui-dialog" 
		 title="My Dialog" 
		 style="width:400px;height:200px;"
    	 data-options="iconCls:'icon-save',resizable:true,modal:true">
	    <label>充值金额</label>
	    <input id="num" type="text" value="50">
	</div>

</body>
</html>