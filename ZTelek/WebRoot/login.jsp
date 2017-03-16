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
    <title>网申平台</title>
	<meta http-equiv="pragma" content="no-cache"/><!-- 进制浏览器从本地计算机的缓存中访问页面内容 -->
	<meta http-equiv="cache-control" content="no-cache"/><!-- 禁止请求或相应的信息不能缓存 -->
	<meta http-equiv="expires" content="0"/><!-- 设置网页的到期时间，默认为0 -->
	<link href="./files/bootstrap.min.css" rel="stylesheet">
	<link href="./files/base.css" rel="stylesheet">
	<script type="text/javascript" src="files/jquery-1.7.2.min.js"></script>
	<script type="text/javascript">
	window.onload = function() { 
	
 	$(function(){ 
 		$("#submit").click(function(){
 				
 		var email = $("#username").val();
		var password = $("#password").val();
		if(email == '' || password ==''){
				$("#error").html("用户名或密码不能为空~");
		} else {
					$.ajax({  
                    type : "POST",  //提交方式  
                    url : "proxy.action?targetAction=loginAction",  
                    data : {email:email,password:password},//数据，这里使用的是Json格式进行传输  
                    success : function(result) {//返回数据根据结果进行相应的处理  
                        if (result=="11") {
                        	location.href="center/myposition.jsp";
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
 <div class="row-fluid bgw">
	<div class="top">
		<div class="logo"><img src="./files/logo.png"></div>		
	</div>
</div>
<!-- Static navbar -->
<div class="navbar-hik navbar-static-top" role="navigation">
	<div class="container-hik">
        <div class="navbar-collapse collapse">
          	<ul class="nav navbar-nav" id="ul_nav_header">
            	<li><a href="telek.jsp">首页</a></li>
        	</ul>
        </div><!--/.nav-collapse -->
	</div>
</div>
<div class="container">
<div class="row h45">
	<ol class="breadcrumb">
		<li><a href="telek.jsp">首页</a></li>
		<li class="active">登录</li>
	</ol>
</div>
<div class="row main">
	<div class="col-md-offset-2 col-md-10 nop">
		<div class="col-md-14 bgw sub">
			<h4><span class="glyphicon glyphicon-user"></span> 登录</h4>				
		</div>
	</div>
	<div class="col-md-offset-2 col-md-10 nop">
		<div class="col-md-14 bgw sub">
			<form id="formPanel" class="form-horizontal fm-v clearfix">
			<div class="form-group">
				<label class="col-sm-3 control-label">用户名(Email)</label>
				<div class="col-sm-6">
					<input id="username" name="email" class="form-control text vam" tabindex="1" placeholder="用户名(Email)" type="email" value="" maxlength="50" autocomplete="false">
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label">密码</label>
				<div class="col-sm-4">
					<input id="password" name="password" class="form-control text vam" tabindex="2" placeholder="密码" type="password" value="" maxlength="15" autocomplete="off">
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-3 col-sm-10">
				</div>
			</div>
			
			<div class="form-group">
				<div class="col-sm-offset-3 col-sm-10">
					<button id="submit" type="button" class="btn btn-primary" tabindex="4">登录</button>
					<span id="error" style="color:red" class="help-block"></span>
				</div>
			</div>
			</form>
		</div>
	</div>
</div>
</div>
  </body>
</html>