<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%  
String path = request.getContextPath();  
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  
%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>上传下载</title>
</head>
<body>
    <form action="<%=basePath%>file/upload.action" method="post" enctype="multipart/form-data">  
        选择文件:<input type="file" name="file"  width="120px">  
        <input type="submit" value="上传">  
    </form>  
    <hr>  
    <form action="<%=basePath%>file/down.action" method="get"> 
        <input type="file" name="file"  width="120px"> 
        <input type="submit" value="下载">  
    </form> 
</body>
</html>