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
<title>登陆</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/jquery-easyui-1.5.2/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/jquery-easyui-1.5.2/jquery.easyui.min.js"></script> 
<script type="text/javascript" src="<%=basePath%>jquery-easyui-1.5.2/plugins/jquery.validatebox.js"></script>
<script type="text/javascript" src="<%=basePath%>jquery-easyui-1.5.2/plugins/jquery.pagination.js"></script>
<script type="text/javascript" src="<%=basePath%>jquery-easyui-1.5.2/locale/easyui-lang-zh_CN.js"></script>
<link rel="stylesheet" href="<%=basePath%>jquery-easyui-1.5.2/themes/default/easyui.css">
<link rel="stylesheet" href="<%=basePath%>jquery-easyui-1.5.2/themes/icon.css">
    <script type="text/javascript">
        document.onkeydown = function (e) {
            var event = e || window.event;
            var code = event.keyCode || event.which || event.charCode;
            if (code == 13) {
                login();
            }
        }
        $(function () {
            $("input[name='login']").focus();
        });
        function cleardata() {
            $('#loginForm').form('clear');
        }
        function login() {
            if ($("input[name='uName']").val() == "" || $("input[name='uPwd']").val() == "") {
                $("#showMsg").html("用户名或密码为空，请输入");
                $("input[name='uName']").focus();
            } else {
                //ajax异步提交
                $.ajax({
                    type: "POST",   //post提交方式默认是get
                    url: "<%=basePath%>login/login.action",
                    data: $("#loginForm").serialize(),   //序列化
                    error: function (request) {      // 设置表单提交出错
                        $("#showMsg").html(request);  //登录错误提示信息
                    },
                    success: function (data) {
                       document.location = "toCenter.acion";
                    }
                });
            }
        }
    </script>
</head>
<body>
    <div id="loginWin" class="easyui-window" title="登录" style="width:350px;height:188px;padding:5px;"
         minimizable="false" maximizable="false" resizable="false" collapsible="false">
        <div class="easyui-layout" fit="true">
            <div region="center" border="false" style="padding:5px;background:#fff;border:1px solid #ccc;">
                <form id="loginForm" method="post">
                   <div style="padding:5px 0;">
                   <label for="login">身份:</label>
                    <select name="uType" id="uType">
                    <option value="">请选择</option>
                    <option value="1">系统管理员</option>
                    <option value="2">作者</option>
                   <option value="3">读者</option>
                    </select>
 
                    </div>
                    <div style="padding:5px 0;">
                        <label for="login">帐号:</label>
                        <input type="text" name="uName" style="width:260px;" />
                    </div>
                    <div style="padding:5px 0;">
                        <label for="password">密码:</label>
                        <input type="password" name="uPwd" style="width:260px;" />
                    </div>
                    <div style="padding:5px 0;text-align: center;color: red;" id="showMsg"></div>
                </form>
            </div>
            <div region="south" border="false" style="text-align:right;padding:5px 0;">
                <a class="easyui-linkbutton" iconcls="icon-ok" href="javascript:void(0)" onclick="login()">登录</a>
                 <a class="easyui-linkbutton" iconcls="icon-help" href="javascript:void(0)" >忘记密码</a>
            </div>
        </div>
    </div>
</head>
<body>

</body>
</html>