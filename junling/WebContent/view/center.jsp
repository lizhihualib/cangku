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
<title>主界面</title>
<script type="text/javascript" src="/junling/jquery-easyui-1.5.2/jquery.min.js"></script>
<script type="text/javascript" src="/junling/jquery-easyui-1.5.2/jquery.easyui.min.js"></script>
<link  rel="stylesheet" href="/junling/jquery-easyui-1.5.2/themes/icon.css">
<link rel="stylesheet" href="/junling/jquery-easyui-1.5.2/themes/metro/easyui.css">
<link rel="stylesheet" href="/junling/css/main.css">
<script type="text/javascript">
	function add(title,url){
		if($('#tabs').tabs('exists',title)){
			$('#tabs').tabs('select',title);
		}else{
			var content='<iframe scrolling="auto" frameborder="0" src="'+url+'" style="width:100%;height:100%;"></iframe>';
			$('#tabs').tabs('add',{
				title:title,
				content:content,
				closable:true,	
			});
		}
	}
	function PI() {
		add('个人收藏','<%=basePath%>view/UserHandle/collect.jsp');
	}
	function SignIn() {
			$.ajax({
				url:"<%=basePath%>UserHandle/personalInformation.action",
				type:"post",
				dataType:"json",
				data:{
					lID:"${sessionScope.loginBean.getlID()}"
				},
				success:function(data){
					var userId=data.uId;
					$.ajax({
						url:"<%=basePath%>UserHandle/updateSignIn.action",
						type:"post",
						dataType:"json",
						data:{
							id:userId
						},
						success:function(data){
			
							if(data.result==1){
								alert("签到成功！");	
							}else{
								alert("签到失败！");
							}
							alert(data.tip);
						}
					})
				}
			})
		}
</script>
</head>
<body>
	<div id="cc" class="easyui-layout" style="width: 100%; height: 800px;">
		<div data-options="region:'north'" style="height:100px;">
		 <lable style="font-size: 20px">欢迎您:<span style="color: green">${loginBean.uName}</span></lable>
		      <c:if test="${loginBean!=null}"> 
        <a href="${pageContext.request.contextPath }/login/logout.action">退出</a> 
               </c:if> 
		</div>
		<div  data-options="region:'west',title:'君临天下'" style="width:110px;">
			<div  class="easyui-accordion" style="width:110px;height:300px;">
				
				<div class="left" title="用户操作">
					<a class="top" href="javascript:void(0);" onclick="SignIn()">签到</a><br>
					<a href="javascript:void(0);" onclick="add('个人信息','<%=basePath%>view/UserHandle/personalInformation.jsp')">个人信息</a><br>
					<a href="javascript:void(0);" onclick="add('修改信息','<%=basePath%>view/UserHandle/updateInformation.jsp')">修改信息</a><br>
					<a>阅豆充值</a><br>
					<a>晋升作者</a><br>
					<a>在线阅读</a><br>
					<a href="javascript:void(0);" onclick="PI()">个人收藏</a><br>
					<a>上传小说</a><br>
					<a>个人写书管理</a><br>
				</div>

				<div class="left" title="用户管理">
					<a class="top" href="javascript:void(0);" onclick="add('作者管理','../view/queryAuthors.jsp')">作者管理</a><br>
					<a class="top" href="javascript:void(0);" onclick="add('读者管理','../view/queryReaders.jsp')">读者管理</a><br>
					
				</div>
								
				<div class="left" title="账号管理">
					<a class="top" href="javascript:void(0);" onclick="add('账号操作','/junling/view/allLogins.jsp')" >账号操作</a><br>
		
				</div>
				
				<div class="left" title="图书管理">
					<a class="top" href="javascript:void(0);" onclick="add('展示书架','/junling/view/books/bookView.jsp')" >图书操作</a><br>
				</div>
				<div class="left" title="排行榜">
					<a class="top" href="javascript:void(0);" onclick="add('小说排行榜','../view/Ranking.jsp')" >小说周人气排行榜</a><br>
					<a>小说周月气排行榜</a><br>
					<a>作者打赏总榜</a><br>
				</div>
				<div class="left" title="好友列表">
				</div>
			</div>
		</div>
		<div data-options="region:'center',split:true" style="width:300px;">
			<div id="tabs" class="easyui-tabs" style="width: 100%;height: 100%">
			</div>
		</div>
	</div>
	
</body>
</html>