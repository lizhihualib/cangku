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
<title>小说排行榜</title>
<script type="text/javascript" src="/junling/jquery-easyui-1.5.2/jquery.min.js"></script>
<script type="text/javascript" src="/junling/jquery-easyui-1.5.2/jquery.easyui.min.js"></script>
<script type="text/javascript" src="/junling/jquery-easyui-1.5.2/plugins/jquery.validatebox.js"></script>
<script type="text/javascript" src="/junling/jquery-easyui-1.5.2/plugins/jquery.pagination.js"></script>
<script type="text/javascript" src="/junling/jquery-easyui-1.5.2/locale/easyui-lang-zh_CN.js"></script>
<link rel="stylesheet" href="/junling/jquery-easyui-1.5.2/themes/default/easyui.css">
<link rel="stylesheet" href="/junling/jquery-easyui-1.5.2/themes/icon.css">
<script type="text/javascript">
function myclick(that){
	var clicks=$(that).parent().prev().prev().html();
	alert(clicks)
	location.href='';
}
$(function(){
	$.ajax({
		url:"<%=basePath%>user/queryRanking.action",
		type:"post",
		dataType:"json",
		success:function(data){
			
			var html='';
			 $.each(data, function(commentIndex,books){
					html+="<tr>"+
					"<td style='display:none;'>"+books.bId+"</td>"+
					"<td>"+(commentIndex+1)+"</td>"+
        	   		"<td><a id='(commentIndex+1)' href='javascript:void(0);' onclick=myclick(this)>"+books.bName+"</a></td>"+
        	   		"<td>"+books.bType+"</td>"+
        	   		"<td>"+books.bState+"</td>"+
        	   		"<td>"+books.bClicks+"</td>"+
        	   		"</tr>"
		})
		 $('#tbody').html(html);
		}
		
})

})
</script>
</head>
<body>
	<table id="table" style="text-align: center;">
	<thead>
			<tr>
				<th >排名</th>
				<th >书名</th>
				<th >类型</th>
				<th >状态</th>
				<th >点击量</th>
			</tr>
	</thead>
	<tbody id="tbody">
			
	</tbody>
	</table>
</body>

</html>