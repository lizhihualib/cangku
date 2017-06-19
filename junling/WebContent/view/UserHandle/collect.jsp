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
		$("#delete").click(function(){
			var rows=$("#table").datagrid("getSelections");
			var idArr=new Array();
			$.each(rows,function(index,row){
				//将值放入数组里面
				idArr.push(row.bId);
			})
			if(rows.length>0){
				$.messager.confirm('温馨提示','亲，你确定要删除这些已收藏的吗?',function(r){
				    if (r){
    	  		  		$.ajax({
							url:"<%=basePath%>UserHandle/deleteCollectBooks.action",
							type:"post",
							dataType:"json",
							data:{
								ids:idArr.toString()
							},
							success:function(data){
								//var json=eval("("+data+")");
								alert(data.tip);
								$("#table").datagrid("reload");
							}
								
						})   
				    }
				});
			}else{
				$.messager.alert('温馨提示','亲，你还没有选择你想要删除的收藏诶。。。');
			}
		});
	})
</script>
</head>
<body>
	<input id="delete" type="button" value="删除" style="margin-bottom: 5px;">
	<table id="table" class="easyui-datagrid" style="width:1000px;height:250px;"
    data-options="url:'<%=basePath%>UserHandle/queryCollectBooks.action?lID=${sessionScope.loginBean.getlID()}'">
	    <thead>
			<tr>
				<th data-options="field:'ck',width:100" checkbox="true"></th>
				<th data-options="field:'bId',width:100" hidden="true">id</th>
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
	</table>
</body>
</html>