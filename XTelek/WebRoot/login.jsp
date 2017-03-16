<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd"><!--网页使用的W3C规范-->

<html xmlns="http://www.w3.org/1999/xhtml"><!--网页开始-->
  <head><!--网页头部开始-->
    <base href="<%=basePath%>"/><!-- 相对路径转绝对路径(如果没有该标签，系统将会参考浏览器女地址栏的路径作为转换的标准，否则就是用base标签作为转换的标准) -->
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8"/><!--说明浏览器读取文件的格式，以及所使用的字符集-->
    <title>后台管理系统</title>
	<meta http-equiv="pragma" content="no-cache"/><!-- 进制浏览器从本地计算机的缓存中访问页面内容 -->
	<meta http-equiv="cache-control" content="no-cache"/><!-- 禁止请求或相应的信息不能缓存 -->
	<meta http-equiv="expires" content="0"/><!-- 设置网页的到期时间，默认为0 -->
	<link href="css/login.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="jquery-1.7.2.min.js"></script>
	<script type="text/javascript">
	
	window.onload = function() { 
	
		$(function(){ 
 		$("#login").click(function(){
 		var name = $("#username").val();
		var password = $("#password").val();
		if(name == '' || password ==''){
				$("#error").html("用户名或密码不能为空~");
		} else {
					$.ajax({  
                    type :"POST",  //提交方式  
                    url : "proxy.action?targetAction=loginAction",  
                    data : {name:name,password:password},//数据，这里使用的是Json格式进行传输  
                    success : function(result) {//返回数据根据结果进行相应的处理  
                        if (result=="11") {
                        	location.href="webmanage/mainFrame.html";
                        } else {  
                           $("#error").html("用户名或密码验证失败~");
                        }  
                    }  
                });  
		}		
 		});
 		
 	});
	
	};
		
	</script>

	

</head>
  <body>
<div class="main-login">

	<div class="login-content">	
	<h2>用户登录</h2>
	
    <form id="login-form" name="login-form">
    <div class="login-info">
	<span class="user">&nbsp;</span>
	<input name="username" id="username" type="text"  value="" class="login-input"/>
	</div>
    <div class="login-info">
	<span class="pwd">&nbsp;</span>
	<input name="password" id="password" type="password"  value="" class="login-input"/>
	</div>
	<div class="login-oper">
	<span id="error" style="color:red"></span>
	</div>
    <div class="login-oper">
	<input id="login" name="login" type="button" value="登 录" class="login-btn"/>
	<input name="" type="submit" value="重 置" class="login-reset"/>
	</div>
    </form>
    </div>
</div> 

  </body>

</html>