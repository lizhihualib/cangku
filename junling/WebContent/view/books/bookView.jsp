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
<link rel="stylesheet" href="/junling/css/bookView.css">
<script type="text/javascript">
	$(function(){
		//删除操作
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
		
		
		//上传按钮相应
		$("#upload").click(function(){
			$("#uploadDlg").dialog("open").dialog("setTitle","文件上传");
			
		})
		
		

		//修改操作
		 $("#update").click(function(){
			var row=$("#table").datagrid("getSelected");
		    if(row<1){
		    	alert("请勾选要修改的数据条目！！！");
		    	return;
		    }
		    //打开修改信息窗口
			$("#updateDlg").dialog("open").dialog("setTitle","修改用户信息");
			//直接将row里面的数据一次性赋值给有name属性的标签，并且name属性必须与row里面的属性想对应
			$("#updateForm").form("load",row);
		});
	
	})
	
	function update(){
		$.ajax({
			url:"/junling/book/updatebooks.action",
			type:"post",
			dataType:"json",
			data:{
				"bId":$("#bId").val(),
	        	"bName":$("#bName").val(),
	        	"bType":$("#bType").val(),
	        	"bState":$("#bState").val(),
	        	"bIntro":$("#bIntro").val(),
	        	"bClicks":$("#bClicks").val(),
	        	"bDownloads":$("#bDownloads").val(),
	        	"bEdittime":$("#bEdittime").val(),
	        	"bOverTime":$("#bOverTime").val(),
			},
			success:function(data){
				alert("成功修改该条信息！");
				$("#table").datagrid("reload");
				$("#updateDlg").dialog("close");
			}	
		})
	}
	
	
	
	
	function closeDlg(){
		$("#updateForm").form("clear");
		$("#updateDlg").dialog("close");
		 
	}
	//修改datetime显示格式
	function ww4(date){  
            var y = date.getFullYear();  
            var m = date.getMonth()+1;  
            var d = date.getDate();  
            var h = date.getHours();  
            var min = date.getMinutes();  
            var sec = date.getSeconds();  
            var str = y+'-'+(m<10?('0'+m):m)+'-'+(d<10?('0'+d):d)+'-'+' '+(h<10?('0'+h):h)+':'+(min<10?('0'+min):min)+':'+(sec<10?('0'+sec):sec);  
            return str;  
        }  
        function w4(s){  
            if (!s) return new Date();  
            var y = s.substring(0,4);  
            var m =s.substring(5,7);  
            var d = s.substring(8,10);  
            var h = s.substring(11,14);  
            var min = s.substring(15,17);  
            var sec = s.substring(18,20);  
            if (!isNaN(y) && !isNaN(m) && !isNaN(d) && !isNaN(h) && !isNaN(min) && !isNaN(sec)){  
                return new Date(y,m-1,d,h,min,sec);  
            } else {  
                return new Date();  
            }  
        }
        
</script>
</head>
<body>
	<table id="table" width=100%  class="easyui-datagrid"  url="/junling/book/querybooks.action"   method="post">
	    <thead>
			<tr>
			    <th field="ck" checkbox="true" width="80"></th>
				<th data-options="field:'bId',width:100">小说ID</th>
				<th data-options="field:'bName',width:100">小说名</th>
				<th data-options="field:'users',width:100,formatter:function(users){
				return users.uPenName;}">作者</th>
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
	
	<!-- easyui上传文件文本框 -->
	<!-- <div style="margin:20px 0;"></div>
	<div class="easyui-panel" title="文件上传" style="width:400px;padding:30px 70px 50px 70px">
		<div style="margin-bottom:20px">
			<div>文件名:</div>
			<input class="easyui-textbox" style="width:100%">
		</div>

		<div style="margin-bottom:20px">
			<div>文件:</div>
			<input class="easyui-filebox" name="file" data-options="prompt:'选择一个文件...'" style="width:100%">
		</div>
		<div>
			<a href="#" class="easyui-linkbutton" style="width:100%">确认上传</a>
		</div>
	</div> -->
	
	
	<div id="updateDlg" class="easyui-dialog" style="width:360px;height:300px" closed="true">
		<form id="updateForm" method="post" style="width:100%;height:100%" buttons="#update-dlg-btns">
			<table align="center">
				<tr >
					<td><label >小说ID：</label></td>
					<td><input  class="easyui-textbox" name="bId" id="bId"   required="true" readonly="true"/><span class="span">*不可更改</span></td>
				</tr>
				<tr>
					<td><label>小说名：</label></td>
					<td><input class="easyui-textbox" name="bName" id="bName"  required="true"/></td>
				</tr>
				
				<tr>
					<td><label>小说类型：</label></td>
					<td><input class="easyui-textbox" name="bType"  id="bType" required="true"  /></td>
				</tr>
				<tr>
					<td><label>小说状态：</label></td>
					<td><select   name="bState"  id="bState"  required="true" >
						<option>连载中</option><option>已完结</option>
					</select></td>
				</tr>
				<tr>
					<td><label>简介：</label></td>
					<td><input class="easyui-textbox"  name="bIntro"  id="bIntro"  /></td>
				</tr>
				<tr>
					<td><label>点击量：</label></td>
					<td><input class="easyui-textbox"  name="bClicks"  id="bClicks"  readonly="true"/><span class="span">*不可更改</span></td>
				</tr>
				<tr>
					<td><label>下载量：</label></td>
					<td><input class="easyui-textbox"  name="bDownloads"  id="bDownloads"  readonly="true"/><span class="span">*不可更改</span></td>
				</tr>
				<tr>
					<td><label>最近上传时间：</label></td>
					<td><input class="easyui-textbox" data-options="formatter:ww4,parser:w4" editable="false" name="bEdittime"  id="bEdittime" readonly="true" /><span class="span">*不可更改</span></td>
				</tr>
				<tr>
					<td><label>完结时间：</label></td>
					<td><input class="easyui-datetimebox"  data-options="formatter:ww4,parser:w4" editable="false" name="bOverTime"  id="bOverTime"  /></td>
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
	
	
	<div id="uploadDlg" class="easyui-dialog" style="width:300px;height:300px" closed="true">
		<form  action="/junling/book/insertbooks.action" method="post" enctype="multipart/form-data" style="width:100%;height:100%" >
			
			<div>选择文件：<input type="file" name="file" /></div>
			<table align="center">
			<tr>
				<td><label>小说名：</label></td>
				<td><input class="easyui-textbox" name="bName" id="lbName"  required="true"/></td>
			</tr>
			
			<tr>
				<td><label>作者：</label></td>
				<td><input class="easyui-textbox" name="uPenName"  id="luPenName" value=默认当前登陆账号  readonly="true"/></td>
			</tr>
			<tr>
				<td><label>小说类型：</label></td>
				<td><input class="easyui-textbox" name="bType"  id="lbType" required="true"/></td>
			</tr>
			<tr>
				<td><label>小说状态：</label></td>
				<td><input class="easyui-textbox"  name="bState"  id="lbState"  required="true"/></td>
			</tr>
			<tr>
				<td><label>简介：</label></td>
				<td><input class="easyui-textbox"  name="bIntro"  id="lbIntro"  /></td>
			</tr>
			<tr>
				<td><label>点击量：</label></td>
				<td><input class="easyui-textbox"  name="bClicks"  id="lbClicks"  value=0  readonly="true" /></td>
			</tr>
			<tr>
				<td><label>下载量：</label></td>
				<td><input class="easyui-textbox"  name="bDownloads"  id="lbDownloads"  value=0 readonly="true"/></td>
			</tr>
			<tr>
				<td><label>最近上传时间：</label></td>
				<td><input class="easyui-datetimebox"  data-options="formatter:ww4,parser:w4" editable="false" name="bEdittime"  id="lbEdittime" /></td>
			</tr>
			<tr>
				<td><label>完结时间：</label></td>
				<td><input class="easyui-datetimebox"  data-options="formatter:ww4,parser:w4" editable="false" name="bOverTime"  id="lbOverTime"  /></td>
			</tr>
			  

		    </table>
			<div id="update-dlg-btns" align="center">
			<input type="submit" value="提交">
			
			</div>
		</form>
		
	</div>
	
	
</body>
</html>