<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %> 
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
 当前用户:${username} 
 <c:if test="${username!=null}"> 
  <a href="${pageContext.request.contextPath }/login/logout.action">退出</a> 
 </c:if> 
 ${message}
  <a href="${pageContext.request.contextPath }/login/getAllLogins.action">查询</a>
</body>
</html>