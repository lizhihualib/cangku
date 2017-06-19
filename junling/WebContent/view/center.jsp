<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>主界面</title>
<script type="text/javascript" src="/junling/jquery-easyui-1.5.2/jquery.min.js"></script>
<script type="text/javascript" src="/junling/jquery-easyui-1.5.2/jquery.easyui.min.js"></script>
<link  rel="stylesheet" href="/junling/jquery-easyui-1.5.2/themes/icon.css">
<link rel="stylesheet" href="/junling/jquery-easyui-1.5.2/themes/metro/easyui.css">
<link rel="stylesheet" href="/junling/css/main.css">
<script type="text/javascript">
	function add(title,url){
		if($('#tabs').tabs('exists',title)){
			$('#tabs').tabs('select',title);
		}else{
			var content='<iframe scrolling="auto" frameborder="0" src="'+url+'" style="width:100%;height:100%;"></iframe>';
			$('#tabs').tabs('add',{
				title:title,
				content:content,
				closable:true,	
			});
		}
	}


</script>
</head>
<body>
	<div id="cc" class="easyui-layout" style="width: 100%; height: 800px;">
		<div data-options="region:'north'" style="height:100px;"></div>
		<div  data-options="region:'west',title:'君临天下'" style="width:110px;">
			<div  class="easyui-accordion" style="width:110px;height:300px;">
				
				<div class="left" title="用户操作">
					<a class="top" href="javascript:void(0);" onclick="">签到</a><br>
					<a href="javascript:void(0);" onclick="add()">个人信息</a><br>
					<a>修改信息</a><br>
					<a>阅豆充值</a><br>
					<a>晋升作者</a><br>
					<a>在线阅读</a><br>
					<a href="javascript:void(0);" onclick="add('个人收藏','/junling/view/UserHandle/collect.jsp')">个人收藏</a><br>
					<a>上传小说</a><br>
					<a>个人写书管理</a><br>
				</div>
				<div class="left" title="用户管理">
					<a class="top" href="javascript:void(0);" onclick="add('作者管理','../view/queryAuthors.jsp')">作者管理</a><br>
					<a class="top" href="javascript:void(0);" onclick="add('读者管理','../view/queryReaders.jsp')">读者管理</a><br>
					
				</div>
				
				<div class="left" title="图书管理">
					<a class="top" href="javascript:void(0);" onclick="add('展示书架','books/bookView.jsp')" >查询图书</a><br>
					<a>添加图书</a><br>
					<a>修改图书</a><br>
					<a>删除图书</a><br>
				</div>
				<div class="left" title="排行榜">
					<a class="top">小说周人气排行榜</a><br>
					<a>小说周月气排行榜</a><br>
					<a>作者打赏总榜</a><br>
				</div>
				<div class="left" title="好友列表">
				</div>
			</div>
		</div>
		<div data-options="region:'center',split:true" style="width:300px;">
		<div id="tabs" class="easyui-tabs" style="width: 100%;height: 100%">
			</div>
		</div>
	</div>
	
</body>
</html>