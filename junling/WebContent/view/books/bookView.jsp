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
<script type="text/javascript">
	$(function(){
		$("#delete").click(function(){
			var rows=$("#table").datagrid("getSelections");
			if(rows.length>0){
				var idArr=new Array();
				$.each(rows,function(index,row){
					idArr.push(row.bId);	
				})
				alert("选中的bId："+idArr);
				$.ajax({
					url:"/junling/book/deletebooks.action",
					type:"post",
					dataType:"json",
					data:{
						ids:idArr.toString()
					},
					success:function(data){
						alert("成功删除"+data+"行数据！")
						$("#table").datagrid("reload");	
					}
				})
			}else{
				alert("请勾选要删除的数据！")
			}
		})	
	})	
</script>
</head>
<body>
	<table id="table" width=100%  class="easyui-datagrid"  url="/junling/book/querybooks.action"   method="post">
	    <thead>
			<tr>
			    <th field="ck" checkbox="true" width="80"></th>
				<th data-options="field:'bId',width:100">小说ID</th>
				<th data-options="field:'bName',width:100">小说名</th>
				<th data-options="field:'uPenName',width:100">作者</th>
				<th data-options="field:'bType',width:100">小说类型</th>
				<th data-options="field:'bState',width:100">小说状态</th>
				<th data-options="field:'bIntro',width:100">简介</th>
				<th data-options="field:'bClicks',width:100">点击量</th>
				<th data-options="field:'bDownloads',width:100">下载量</th>
				<th data-options="field:'bEdittime',width:100">最近上传时间</th>
				<th data-options="field:'bOverTime',width:100">完结时间</th>
			</tr>
	    </thead>
	</table>
	
	<input type="button" value="修改小说信息" id="update">
	<input type="button" value="上传我的小说" id="upload">
	<input type="button" value="删除我的小说" id="delete">
	
</body>
</html>