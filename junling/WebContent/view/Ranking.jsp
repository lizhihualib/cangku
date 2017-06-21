<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>小说排行榜</title>
<script type="text/javascript" src="/junling/jquery-easyui-1.5.2/jquery.min.js"></script>
<script type="text/javascript" src="/junling/jquery-easyui-1.5.2/jquery.easyui.min.js"></script>
<script type="text/javascript" src="/junling/jquery-easyui-1.5.2/plugins/jquery.validatebox.js"></script>
<script type="text/javascript" src="/junling/jquery-easyui-1.5.2/plugins/jquery.pagination.js"></script>
<script type="text/javascript" src="/junling/jquery-easyui-1.5.2/locale/easyui-lang-zh_CN.js"></script>
<link rel="stylesheet" href="/junling/jquery-easyui-1.5.2/themes/default/easyui.css">
<link rel="stylesheet" href="/junling/jquery-easyui-1.5.2/themes/icon.css">
</head>
<body>
	<table id="table"  class="easyui-datagrid"  url="/junling/user/queryRanking.action" pagination="true"   method="post">
		<thead>
			<tr>
				<th field="bName"  width="80">小说名</th>
				<th field="bType"  width="80">类型</th>
				<th field="bState"  width="80">状态</th>
				<th field="bClicks"  width="76">点击量</th>
			</tr>
		</thead>
	</table>
</body>
</html>