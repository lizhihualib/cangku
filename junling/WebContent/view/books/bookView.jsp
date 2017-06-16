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
	
	
	
	<table class="easyui-datagrid" style="width:400px;height:250px"
	    data-options="url:'datagrid_data.json',fitColumns:true,singleSelect:true">
	    <thead>
			<tr>
				<th data-options="field:'code',width:100">Code</th>
				<th data-options="field:'name',width:100">Name</th>
				<th data-options="field:'price',width:100">Price</th>
			</tr>
	    </thead>
	</table>
</body>
</html>