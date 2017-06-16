<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查询作者</title>
<script type="text/javascript" src="/junling/jquery-easyui-1.5.2/jquery.min.js"></script>
<script type="text/javascript" src="/junling/jquery-easyui-1.5.2/jquery.easyui.min.js"></script>
<script type="text/javascript" src="/junling/jquery-easyui-1.5.2/plugins/jquery.validatebox.js"></script>
<script type="text/javascript" src="/junling/jquery-easyui-1.5.2/plugins/jquery.pagination.js"></script>
<script type="text/javascript" src="/junling/jquery-easyui-1.5.2/locale/easyui-lang-zh_CN.js"></script>
<link rel="stylesheet" href="/junling/jquery-easyui-1.5.2/themes/default/easyui.css">
<link rel="stylesheet" href="/junling/jquery-easyui-1.5.2/themes/icon.css">
<script type="text/javascript">
$(function(){
	$("#table").datagrid({
		pagination:true
	});
	var p=$("#table").datagrid('getPager');
	 $(p).pagination({
		total:200,
		pageSize:10,
		pageList:[10,20,30,50],
		beforePageText:'第',
		afterPageText:'页   共{pages}页',
		displayMsg: '当前显示 {from} - {to} 条记录   共 {total} 条记录',
		onSelectPage:function(pageNumber,pageSize){
			
			alert("当前页："+pageNumber+"每页条数:"+pageSize)
		}
		
	}) 
	$("#update").click(function(){
			//获取选中行，如果选中了多行，则获取的是第一个选中行
			var row=$("#table").datagrid("getSelected");
			$("#uusername").textbox({
				readonly:true
			});
			$("#updateDlg").dialog("open").dialog("setTitle","修改用户信息");
			$("#saveUrl").val("/junling/user/updateUser");
			/* 
			//1.为每一个输入框赋值
			$("#uusername").textbox("setValue",row.username);
			$("#uuserpwd").textbox("setValue",row.userpwd);
			$("#urealname").textbox("setValue",row.realname); */
			
			//直接将row里面的数据一次性赋值给有name属性的标签，并且name属性必须与row里面的属性想对应
			$("#updateForm").form("load",row);
		})
	
	
	
	
	$("#delete").click(function(){
			var rows=$("#table").datagrid("getSelections");
			if(rows.length>0){
				var idArr=new Array();
				$.each(rows,function(index,row){
					//将值放入数组里面
					idArr.push(row.uId);
				})
				
				$.ajax({
					url:"/junling/user/deleteUser.action",
					type:"post",
					dataType:"json",
					data:{
						uId:idArr.toString()
					},
					success:function(data){
						alert(data.tip);
						$("#table").datagrid("reload");
					}
							
				})
			}else{
				alert("are you delete");
			}
		})
})


</script>
</head>
<body>
	<input type="button" value="修改" id="update">
	<input type="button" value="增加" id="add">
	<input type="button" value="删除" id="delete">
<table id="table" singleSelect="true" class="easyui-datagrid"  url="/junling/user/queryUsers.action"   method="post">
		<thead>
			<tr>
				<th field="ck" checkbox="true" width="80"></th>
				<th field="uId"  width="80">id</th>
				<th field="uRealName"  width="80">真实名</th>
				<th field="uSex"  width="80">性别</th>
				<th field="uBirthday"  width="80">出生日期</th>
				<th field="uPhone"  width="80">手机号码</th>
				<th field="uEmail"  width="80">邮箱</th>
				<th field="uPenName"  width="80">著名</th>
				<th field="uBeans"  width="80">阅豆</th>
				<th field="uBankCard"  width="80">银行卡号</th>
				<th field="uSignState"  width="80">签到状态</th>
				<th field="uUploadNumbers"  width="80">可上传本数</th>
			</tr>
		</thead>
	</table>
</body>
</html>