<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%  
String path = request.getContextPath();  
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  
%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>用户列表</title>  
<script type="text/javascript" src="${pageContext.request.contextPath}/jquery-easyui-1.5.2/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/jquery-easyui-1.5.2/jquery.easyui.min.js"></script> 
<script type="text/javascript" src="<%=basePath%>jquery-easyui-1.5.2/plugins/jquery.validatebox.js"></script>
<script type="text/javascript" src="<%=basePath%>jquery-easyui-1.5.2/plugins/jquery.pagination.js"></script>
<script type="text/javascript" src="<%=basePath%>jquery-easyui-1.5.2/locale/easyui-lang-zh_CN.js"></script>
<link rel="stylesheet" href="<%=basePath%>jquery-easyui-1.5.2/themes/default/easyui.css">
<link rel="stylesheet" href="<%=basePath%>jquery-easyui-1.5.2/themes/icon.css">

      
    <script type="text/javascript">  
   $(function(){
		//通过table标签得的一个分页插件
		var pp=$("#table").datagrid("getPager");
		$(pp).pagination({			
			pageSize:10,
			pageList:[2,3,5,10],
			beforePageText:"第",	
			afterPageText:"页    共{pages}页",
			displayMsg: '当前显示 {from} - {to} 条记录   共 {total} 条记录',  
			onSelectPage:function(curPage,pageSize){
				var data={
					/* 	curPage:curPage,
						pageSize:pageSize, */
						"uType":$("#quserType").val(),
					
					
				}
				//发送ajax请求
				//$("#table").datagrid("reload",data);
				$.ajax({
					url:"<%=basePath%>login/getAllLogins.action",
					type:"post",
					dataType:"json",
					data:data,
					success:function(respData){
						$("#table").datagrid("loadData",respData)
					}
					
				});
				
			}
		});
	   
	   $("#update").click(function(){
			//获取选中行，如果选中了多行，则获取的是第一个选中行
			var row=$("#table").datagrid("getSelected");
			$("#uusername").textbox({
				readonly:true
			});
			$("#updateDlg").dialog("open").dialog("setTitle","修改用户信息");
			$("#saveUrl").val("<%=basePath%>login/updateLogin.action");
		
			//1.为每一个输入框赋值
		//$("#uusername").textbox("setValue",row.username);
			
			//直接将row里面的数据一次性赋值给有name属性的标签，并且name属性必须与row里面的属性想对应
			$("#updateForm").form("load",row);
		})
		  $("#add").click(function(){
			$("#updateForm").form("clear");
			$("#updateDlg").dialog("open").dialog("setTitle","增加用户");
			$("#saveUrl").val("<%=basePath%>login/insertLogin.action");
			$("#uuName").textbox({
				readonly:false,
				
			});
			$("#uusers_uId").textbox({
				required:false
			})
			
		});
	   //按身份查询
		$("#query").click(function(){
			var data={
					/* curPage:$("#pp").pagination("options").pageNumber,
					pageSize:$("#pp").pagination("options").pageSize, */
					"uType":$("#quserType").val(),
					
				
			}
			//发送ajax请求
			$("#table").datagrid("load",data);
		})
		//删除用户
		$("#delete").click(function(){
			var rows=$("#table").datagrid("getSelections");
			if(rows.length>0){
				var idArr=new Array();
				$.each(rows,function(index,row){
					//将值放入数组里面
					idArr.push(row.lID);
				})
				$.messager.confirm("提示",'Are you sure you want to delete ?',function(r){
                     if (r){
                    		$.ajax({
            					url:"<%=basePath%>login/deleteLogin.action",
            					type:"post",
            					dataType:"json",
            					data:{
            						"ids":idArr.toString(),
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
				alert("请选择要删除的数据");
			}
		})
   })
//添加修改的保存按钮
   	function update(){
	//如果Id不为空进入修改操作
	   if($("#uid").val()!=""){
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
	//如果ID为空进入添加操作
	   $.ajax({
           type:"post",
           url:$("#saveUrl").val(),
           data:{
        	   "uName":$("#uuName").val(),
          
               "uPwd":$("#uuPwd").val(),
               "uType":$("#uuType").val(),
     },
           success:function(data){
        	
			  alert(data.tip);
			$("#updateDlg").dialog("close"); 
             $('#table').datagrid('reload');
      
           }
         })  
		
	}

   	function closeDlg(){
		$("#updateForm").form("clear");
		$("#updateDlg").dialog("close");
	}
    </script>
</head>
<body>
	<form id="queryForm">
		<label>身份</label><input class="easyui-textbox" name="userType" id="quserType">
		
	</form>
    <input type="button" value="查询" id="query">
	<input type="button" value="修改" id="update">
	<input type="button" value="增加" id="add">
	<input type="button" value="删除" id="delete">
	<table id="table" class="easyui-datagrid"  url="<%=basePath%>login/getAllLogins.action" pagination="true"  method="post">
		<thead>
			<tr>
				<th field="ck" checkbox="true"></th>
				<th field="id" style="display: none" ></th>
				<th field="uName"  width="80">用户名</th>
				<th field="uPwd"  width="80">用户密码</th>
				<th field="uType"  width="80">类型</th>
	
			</tr>
		</thead>
	</table>
		<div id="updateDlg" class="easyui-dialog" style="width:300px;height:300px" closed="true">
		<input type="hidden" id="saveUrl">
		<form id="updateForm" method="post" style="width:100%;height:100%" buttons="#update-dlg-btns">
			<input type="hidden" name="id" id="uid">
			<table align="center">
				<tr>
					<td><label>用户名：</label></td>
					<td><input class="easyui-textbox" name="uName" id="uuName" data-options="readonly:'readonly', required:true"/></td>
				</tr>
				<tr>
					<td><label>用户密码：</label></td>
					<td><input class="easyui-textbox" name="uPwd" id="uuPwd"  required="true"/></td>
				</tr>
				
				<tr>
					<td><label>类型：</label></td>
					<td><input class="easyui-textbox" name="uType"  id="uuType" required="true"/></td>
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