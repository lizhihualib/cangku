<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>网页书籍管理</title>
<script type="text/javascript" src="/junling/jquery-easyui-1.5.2/jquery.min.js"></script>
<script type="text/javascript" src="/junling/jquery-easyui-1.5.2/jquery.easyui.min.js"></script>
<link rel="stylesheet" href="/junling/jquery-easyui-1.5.2/themes/icon.css">
<link rel="stylesheet" href="/junling/jquery-easyui-1.5.2/themes/metro/easyui.css">
</head>
<body>
	
	
	
	<table id="table" singleSelect="true" class="easyui-datagrid"  url="/junling/book/querybooks.action"   method="post">
	    <thead>
			<tr>
			    <th field="ck" checkbox="true" width="80"></th>
				<th data-options="field:'bId',width:100">小说ID</th>
				<th data-options="field:'bName',width:100">小说名</th>
				
				<th data-options="field:'bType',width:100">小说类型</th>
				<th data-options="field:'bState',width:100">小说状态</th>
				<th data-options="field:'bIntro',width:100">简介</th>
				<th data-options="field:'bClicks',width:100">点击量</th>
				<th data-options="field:'bDownloads',width:100">下载量</th>
				<th data-options="field:'bEdittime',width:100">最近上传时间</th>
				<th data-options="field:'bOverTime',width:100">完结时间</th>
				<th data-options="field:'uPenName',width:100">作者</th>
				
			</tr>
	    </thead>
	</table>
</body>
</html>