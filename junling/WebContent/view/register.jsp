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
<title>注册</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/jquery-easyui-1.5.2/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/jquery-easyui-1.5.2/jquery.easyui.min.js"></script> 
<script type="text/javascript" src="<%=basePath%>jquery-easyui-1.5.2/plugins/jquery.validatebox.js"></script>
<script type="text/javascript" src="<%=basePath%>jquery-easyui-1.5.2/plugins/jquery.pagination.js"></script>
<script type="text/javascript" src="<%=basePath%>jquery-easyui-1.5.2/locale/easyui-lang-zh_CN.js"></script>
<link rel="stylesheet" href="<%=basePath%>jquery-easyui-1.5.2/themes/default/easyui.css">
<link rel="stylesheet" href="<%=basePath%>jquery-easyui-1.5.2/themes/icon.css">
 <script type="text/javascript"> 	
	//添加修改的保存按钮

		function update(){
             
		    if($("#uuPwd").val()!=$("#uuPwd2").val()){
		    	
		             alert("两次输入密码不一致")
		             return false;
		    }
		    
		//进入添加操作
		   $.ajax({
	           type:"post",
	           url:"<%=basePath%>login/insertLogin.action",
	           data:{
	        	   "uName":$("#uuName").val(),
	          
	               "uPwd":$("#uuPwd").val(),
	               "uType":$("#uuType").val(),
	     },
	           success:function(data){
	        	
				  alert(data.tip);
				  if(data.status==3) return false;
				  document.location = "<%=basePath%>view/login.jsp";
	      
	           }
	         })  
	    
		}

	function closeDlg(){
		$("#updateForm").form("clear");

	}
 </script> 

</head>
<body>
<div id="updateDlg" class="easyui-dialog" title="用户注册" style="width:400px;height:300px" >
	
		<form id="updateForm" method="post" style="width:100%;height:100%" buttons="#update-dlg-btns">
		
			<table align="center">
				<tr>
					<td><label>用户名：</label></td>
					<td><input class="easyui-textbox" name="uName" id="uuName" data-options="required:true"/></td>
				</tr>
				<tr>
					<td><label>输入密码：</label></td>
					<td><input class="easyui-textbox" name="uPwd2" id="uuPwd"  required="true"/></td>
				</tr>
					<tr>
					<td><label>再次输入密码：</label></td>
					<td><input class="easyui-textbox" name="uPwd" id="uuPwd2"  required="true"/></td>
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
					iconCls="icon-cancel" onclick="closeDlg();" style="width:100px;height:30px">重置</a>
					<a href="javascript:void(0);" class="easyui-linkbutton" 
					iconCls="icon-back" onclick="javascript:history.back(-1);" style="width:100px;height:30px">返回上页</a>
					
			</div>
		</form>
		
	</div>
</body>
</html>