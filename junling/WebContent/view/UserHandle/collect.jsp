<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script type="text/javascript" src="/junling/jquery-easyui-1.5.2/jquery.min.js"></script>
<script type="text/javascript" src="/junling/jquery-easyui-1.5.2/jquery.easyui.min.js"></script>
<script type="text/javascript" src="/junling/jquery-easyui-1.5.2/plugins/jquery.validatebox.js"></script>
<script type="text/javascript" src="/junling/jquery-easyui-1.5.2/plugins/jquery.pagination.js"></script>
<script type="text/javascript" src="/junling/jquery-easyui-1.5.2/locale/easyui-lang-zh_CN.js"></script>
<link rel="stylesheet" href="/junling/jquery-easyui-1.5.2/themes/default/easyui.css">
<link rel="stylesheet" href="/junling/jquery-easyui-1.5.2/themes/icon.css">
<script type="text/javascript">
	$(function(){
		$("#add").click(function(){
			alert("hahah");
			});
	})
</script>
</head>
<body>
	<input id="add" type="button" value="添加" style="margin-bottom: 5px;">
	<input id="update" type="button" value="修改">
	<input id="delete" type="button" value="删除">
	<table class="easyui-datagrid" style="width:1000px;height:250px;"
    data-options="url:'/junling/UserHandle/queryCollectBooks.action'">
    <thead>
		<tr>
			<th data-options="field:'ck',width:100" checkbox="true"></th>
			<th data-options="field:'bId',width:100">id</th>
			<th data-options="field:'bName',width:100">书名</th>
			<th data-options="field:'bType',width:100">类型</th>
			<th data-options="field:'bState',width:100">状态</th>
			<th data-options="field:'bIntro',width:100">描述</th>
			<th data-options="field:'bClicks',width:100">点击量</th>
			<th data-options="field:'bDownloads',width:100">下载量</th>
			<th data-options="field:'bEdittime',width:100">上传时间</th>
			<th data-options="field:'bOverTime',width:100">完结时间</th>
			<th data-options="field:'users_uId',width:100">用户id</th>
			
		</tr>
    </thead>
    

		


</body>
</html>