<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登陆</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/login/login.action" method="post">
<table>
     <tr> <td>用户名：<input name="uName"/></td></tr><br>
     <tr> <td>  密码：<input name="uPwd"/> </td></tr> <br>
<tr>
        <td height="30" align="right" >身份：</td>
         <td align="left"><select name="uType" id="uType">
          <option value="">请选择</option>
          <option value="1">系统管理员</option>
          <option value="2">作者</option>
          <option value="3">读者</option>
          </select></td>
  </tr>
  <input type="submit" value="登录" /> 
 
   
</table> 
</form>
</body>
</html>