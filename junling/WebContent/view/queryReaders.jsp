<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>读者管理</title>
<script type="text/javascript" src="/junling/jquery-easyui-1.5.2/jquery.min.js"></script>
<script type="text/javascript" src="/junling/jquery-easyui-1.5.2/jquery.easyui.min.js"></script>
<script type="text/javascript" src="/junling/jquery-easyui-1.5.2/plugins/jquery.validatebox.js"></script>
<script type="text/javascript" src="/junling/jquery-easyui-1.5.2/plugins/jquery.pagination.js"></script>
<script type="text/javascript" src="/junling/jquery-easyui-1.5.2/locale/easyui-lang-zh_CN.js"></script>
<link rel="stylesheet" href="/junling/jquery-easyui-1.5.2/themes/default/easyui.css">
<link rel="stylesheet" href="/junling/jquery-easyui-1.5.2/themes/icon.css">
<script type="text/javascript">
$(function(){
	//通过table标签得的一个分页插件
	var pp=$("#table").datagrid("getPager");
	$(pp).pagination({			
		pageSize:2,
		pageList:[2,3,5,10],
		beforePageText:"第",	
		afterPageText:"页    共{pages}页",
		displayMsg: '当前显示 {from} - {to} 条记录   共 {total} 条记录',  
		onSelectPage:function(curPage,pageSize){
			var data={
					curPage:curPage,
					pageSize:pageSize, 
					
				
				
			}
	        alert(curPage+" "+pageSize)
			//发送ajax请求
			//$("#table").datagrid("reload",data);
			$.ajax({
				url:"/junling/user/queryReaders.action",
				type:"post",
				dataType:"json",
				data:data,
				success:function(respData){
					$("#table").datagrid("loadData",respData)
				}
				
			});
			
		}
	});
	$("#add").click(function(){
			$("#updateForm").form("clear");
			$("#updateDlg").dialog("open").dialog("setTitle","增加用户信息");
			$("#saveUrl").val("/junling/user/insertUser.action");
			
		});
	 $("#update").click(function(){
			//获取选中行，如果选中了多行，则获取的是第一个选中行
				var row=$("#table").datagrid("getSelected");
				$("#updateDlg").dialog("open").dialog("setTitle","修改用户信息");
				$("#saveUrl").val("/junling/user/updateUser.action");
				//直接将row里面的数据一次性赋值给有name属性的标签，并且name属性必须与row里面的属性想对应
				$("#updateForm").form("load",row);
			});
	
	$("#delete").click(function(){
			var rows=$("#table").datagrid("getSelections");
			if(rows.length>0){
				var idArr=new Array();
				$.each(rows,function(index,row){
					//将值放入数组里面
					idArr.push(row.uId);
				})
				$.messager.confirm("提示",'确认删除选中作者吗?',function(a){
                 if (a){
                		$.ajax({
        					url:"/junling/user/deleteUser.action",
        					type:"post",
        					dataType:"json",
        					data:{
        						uId:idArr.toString(),
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
				alert("are you delete");
			}
		})
})
function update(){
	//如果Id不为空进入修改操作
	   if($("#uuId").val()!=""){
	$("#updateForm").form("submit",
			{
				url:$("#saveUrl").val(),
				onSubmit:function(){
			
					return $(this).form('validate');
				},
				success:function(data){
					var json=eval("("+data+")");
					alert(json.tip);
					$("#updateDlg").dialog("close");
					$("#table").datagrid("reload");
				}
		
			});
	   }
	   else{
	$.ajax({
        type:"post",
        url:$("#saveUrl").val(),
        data:{
        	"uRealName":$("#uRealName").val(),
        	"uSex":$("#uSex").val(),
        	"uBirthday":$("#uBirthday").val(),
        	"uPhone":$("#uPhone").val(),
        	"uEmail":$("#uEmail").val(),
        	"uPenName":$("#uPenName").val(),
        	"uBeans":$("#uBeans").val(),
        	"uBankCard":$("#uBankCard").val(),
        	"uSignState":$("#uSignState").val(),
        	"uUploadNumbers":$("#uUploadNumbers").val(),
        	"login_lID":$("#login_lID").val(),
  },
        success:function(data){
     	
        	var json=eval("("+data+")");
			alert(json.tip);
			$("#updateDlg").dialog("close"); 
          $('#table').datagrid('reload');
   
        }
      })  
	}
}
function closeDlg(){
	$("#updateForm").form("clear");
	$("#updateDlg").dialog("close");
}

</script>
</head>
<body>
	<input type="button" value="修改读者信息" id="update">
	<input type="button" value="增加读者" id="add">
	<input type="button" value="删除读者" id="delete">
<table id="table"  class="easyui-datagrid"  url="/junling/user/queryReaders.action"  pagination="true"  method="post">
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
				<th field="login_lID"  width="80">登陆id</th>
			</tr>
		</thead>
	</table>
	
	<div id="updateDlg" class="easyui-dialog" style="width:300px;height:300px" closed="true">
		<input type="hidden" id="saveUrl">
		<form id="updateForm" method="post" style="width:100%;height:100%" buttons="#update-dlg-btns">
			<input type="hidden" name="uId" id="uuId">
			<table align="center">
				<tr>
					<td><label>真实名：</label></td>
					<td><input class="easyui-textbox" name="uRealName" id="uRealName"  required="true"/></td>
				</tr>
				<tr>
					<td><label>性别：</label></td>
					<td><input class="easyui-textbox" name="uSex" id="uSex"  required="true"/></td>
				</tr>
				
				<tr>
					<td><label>出生日期：</label></td>
					<td><input class="easyui-datebox" name="uBirthday"  id="uBirthday" required="true"/></td>
				</tr>
				<tr>
					<td><label>手机号码：</label></td>
					<td><input class="easyui-textbox" name="uPhone"  id="uPhone" required="true"/></td>
				</tr>
				<tr>
					<td><label>邮箱：</label></td>
					<td><input class="easyui-textbox"  name="uEmail"  id="uEmail" /></td>
				</tr>
				<tr>
					<td><label>著名：</label></td>
					<td><input class="easyui-textbox"  name="uPenName"  id="uPenName"  /></td>
				</tr>
				<tr>
					<td><label>阅豆：</label></td>
					<td><input class="easyui-textbox"  name="uBeans"  id="uBeans"  /></td>
				</tr>
				<tr>
					<td><label>银行卡号：</label></td>
					<td><input class="easyui-textbox"  name="uBankCard"  id="uBankCard" /></td>
				</tr>
				<tr>
					<td><label>签到状态：</label></td>
					<td><input class="easyui-textbox"  name="uSignState"  id="uSignState"  /></td>
				</tr>
				<tr>
					<td><label>可上传本数：</label></td>
					<td><input class="easyui-textbox"  name="uUploadNumbers"  id="uUploadNumbers"  /></td>
				</tr>
				<tr>
					<td><label>登陆id：</label></td>
					<td><input class="easyui-textbox"  name="login_lID"  id="login_lID"  /></td>
				</tr>
			</table>
			
			<div id="update-dlg-btns" align="center">
				<a href="javascript:void(0);" class="easyui-linkbutton" 
					iconCls="icon-ok" onclick="update();" style="width:100px;height:30px" >保存</a>
					<a href="javascript:void(0);" class="easyui-linkbutton" 
					iconCls="icon-cancel" onclick="closeDlg();" style="width:100px;height:30px">取消</a>
			</div>
		</form>
		
	</div>
</body>
</html>