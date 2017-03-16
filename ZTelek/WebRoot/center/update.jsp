<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="utf-8"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!--网页使用的W3C规范-->

<html xmlns="http://www.w3.org/1999/xhtml">
<!--网页开始-->
<head>
<!--网页头部开始-->
<base href="<%=basePath%>" />
<!-- 相对路径转绝对路径(如果没有该标签，系统将会参考浏览器女地址栏的路径作为转换的标准，否则就是用base标签作为转换的标准) -->
<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
<!--说明浏览器读取文件的格式，以及所使用的字符集-->
<title>网申平台</title>
<meta http-equiv="pragma" content="no-cache" />
<!-- 进制浏览器从本地计算机的缓存中访问页面内容 -->
<meta http-equiv="cache-control" content="no-cache" />
<!-- 禁止请求或相应的信息不能缓存 -->
<meta http-equiv="expires" content="0" />
<!-- 设置网页的到期时间，默认为0 -->
<link href="./files/bootstrap.min.css" rel="stylesheet">
<link href="./files/base.css" rel="stylesheet">
<link href="./files/style2.css" rel="stylesheet">
<script src="./files/jquery-1.7.2.min.js"></script>
<script src="./files/jquery.easing.1.3.js"></script>
<script src="./files/jquery.hoverIntent.minified.js"></script>
<script src="./files/jquery.naviDropDown.js"></script>

<script type="text/javascript">
	window.onload=function(){
		function changeState(){
			var email = '<%=session.getAttribute("email")%>';
			var realname = '<%=session.getAttribute("realname")%>';
			var state = '<%=session.getAttribute("state")%>';
		
			if(realname=="null"){
				$("#div2").hide();

			}else{
				$("#div1").hide();
				$("#sessionname").html(realname);
			}
		}
		changeState();
		
		
			function valiOldPass(){
				var password = $("#password").val();
				if (password == "") {
					$("#oldmsg").html("原密码不为空.");
					return false;
				} else {
					$("#oldmsg").html("");
					return true;
				}
			}
	
			function valiNewPass() {
				var newpass = $("#newpass").val();
				if (newpass == "") {
					$("#newmsg").html("新密码不为空.");
					return false;
				} else {
					$("#newmsg").html("");
					return true;
				}
			}
			
			function valiUserWord() {
				var password = $("#newpass").val();
				var password2=$("#newpassz").val();
					if (password2 == "") {
						$("#newmsgz").html("重复密码不为空.");
						return false;
					}else if(password!=password2){
						$("#newmsgz").html("密码输入不一致.");
						return false;
					}else{
						$("#newmsgz").html("");
						true;
					}
			}
			
		
		$("#password").blur(function() {
			valiOldPass();
		});
		$("#newpass").blur(function() {
			valiNewPass();
		});
		$("#newpassz").blur(function() {
			valiUserWord();
		});
			
		
		
		
		
		
		
		 $("#submit").click(function(){
		 
		 			if(valiOldPass()&&valiNewPass&&valiUserWord){
		 			
	                var email='<%=session.getAttribute("email")%>';
	                var password=$("#password").val();
	                var newpass=$("#newpass").val();
					$.ajax({  
                    type : "POST",  //提交方式  
                    url : "proxy.action?targetAction=changeUserPassAction",  
                    data : {email:email,password:password,newpass:newpass},//数据，这里使用的是Json格式进行传输  
                    success : function(result) {//返回数据根据结果进行相应的处理  
                        if (result=="true") {
                        	location.href="proxy.action?targetAction=logoutAction";
                        	$("#msg").html("修改成功");
                        	setTimeout(yourFunction,2000);
                        	function yourFunction(){$("#msg").html("");
                        }}
                        if (result=="false") {
                        	$("#msg").html("修改失败");
                        	setTimeout(yourFunction,2000);
                        	function yourFunction(){$("#msg").html("");
                        }}
                        if (result=="error") {
                        	$("#msg").html("修改失败,密码错误");
                        	setTimeout(yourFunction,2000);
                        	function yourFunction(){$("#msg").html("");
                        }}
                          
                    }  
                });  
                
                
                }
 			});
		
		
	};
</script>
</head>
<body>
	<div class="row-fluid bgw">
		<div class="top">
			<div class="logo">
				<img src="./files/logo.png">
			</div>
			<div class="follow" style="position: relative;">
				<span></span>
				<div class="iwxt" style="display: none;">
					<div class="iwxt1">
						<a id="weixinlogoc" href="javascript:void(0);"></a>
					</div>
				</div>
			</div>
			<div id="div1" class="sign">
				<a href="login.jsp" class="btn btn-link btn-xs">登录</a><span>|</span><a
					href="register.jsp" class="btn btn-link btn-xs">注册</a>
			</div>
			<div id="div2" class="sign">
				<span>欢迎您，</span><a id="sessionname" href="center/myposition.jsp"
					class="btn btn-link btn-xs"></a><span>|</span><a
					href="proxy.action?targetAction=logoutAction"
					class="btn btn-link btn-xs">退出</a>
			</div>
		</div>
	</div>
	<!-- Static navbar -->
	<div class="navbar-hik navbar-static-top" role="navigation"
		id="navigation_horiz">
		<div class="container-hik">
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav" style="float: left; padding-left: 0;">
					<li class="navnewli clearfix"><a class="navnewoa"
						href="telek.jsp">首页</a></li>
					<li class="navnewli clearfix"><a class="navnewoa"
						href="proxy.action?targetAction=getStationList" id="pr">应届生招聘</a>
						<div class="dropdown xlbg"
							onmouseover="$(&#39;#pr&#39;).attr(&#39;class&#39;,&#39;navnewdq&#39;)"
							onmouseout="$(&#39;#pr&#39;).attr(&#39;class&#39;,&#39;navnewoa&#39;)"
							style="width: auto; display: none;">
							<div
								style="height: 5px; width: 486px; margin-left: 6px; overflow: hidden; background: #D2332F;">
							</div>
							<div class="xldh clearfix">
								<div class="xldh1">
									<div class="xldh5">
										<a href="company.jsp">公司简介</a>
									</div>
									<div class="xldh5">
										<a href="proxy.action?targetAction=getStationList">招聘岗位</a>
									</div>
								</div>
							</div>
						</div>
			</div>
			</li>

			</ul>
		</div>
		<!--/.nav-collapse -->
	</div>
	</div>

	<script type="text/javascript">
    $(function () {
        $('#navigation_horiz').naviDropDown({
        
        });
    });
</script>
	<div class="container">
		<div class="row h45">
			<ol class="breadcrumb">
				<li><a href="telek.jsp">首页</a>
				</li>
				<li><a href="center/myposition.jsp">个人中心</a>
				</li>
				<li class="active">修改密码</li>
			</ol>
		</div>
		<div class="row main">
			<div class="col-md-4 nop">
				<div class="col-md-14 bgw sub menu">
					<h4>
						<span class="glyphicon glyphicon-minus"></span> 个人中心
					</h4>
					<ul class="nav nav-pills nav-stacked" role="tablist">
						<li><a href="center/myposition.jsp"><span
								class="glyphicon glyphicon-chevron-right"></span>我的职位</a></li>
						<li><a href="center/basic.jsp"><span
								class="glyphicon glyphicon-chevron-right"></span>基本信息</a></li>
						<li><a href="center/detail.jsp"><span
								class="glyphicon glyphicon-chevron-right"></span>详细信息</a></li>
						<li><a href="center/manage.jsp"><span
								class="glyphicon glyphicon-chevron-right"></span>附件管理</a></li>

						<li class="active"><a href="center/update.jsp"><span
								class="glyphicon glyphicon-chevron-right"></span>修改密码</a></li>
					</ul>
				</div>
			</div>
			<div class="col-md-10 nop">
				<div class="col-md-14 bgw sub">
					<h4>
						<span class="glyphicon glyphicon-user"></span> 修改密码
					</h4>
				</div>
			</div>
			<div class="col-md-10 nop">
				<div class="col-md-14 bgw sub">
					<form class="form-horizontal" role="form">
						<div class="form-group  has-feedback">
							<label class="col-sm-3 control-label">原密码</label>
							<div class="col-sm-4">
								<input type="password" id="password" name=password
									class="form-control" placeholder="原密码" maxlength="15">
							</div>
							<span id="oldmsg"  style="color:red" class="help-block"></span>
						</div>
						<div class="form-group  has-feedback">
							<label class="col-sm-3 control-label">新密码</label>
							<div class="col-sm-4">
								<input type="password" id="newpass" name="newpass"
									class="form-control" placeholder="新密码" maxlength="15">
							</div>
							<span id="newmsg" style="color:red" class="help-block"></span>
						</div>
						<div class="form-group  has-feedback">
							<label class="col-sm-3 control-label">重复新密码</label>
							<div class="col-sm-4">
								<input type="password" id="newpassz" name="newpassz"
									class="form-control" placeholder="重复新密码" maxlength="15">
							</div>
							<span id="newmsgz" style="color:red" class="help-block"></span>
						</div>
						<div class="form-group">
							<div class="col-sm-offset-3 col-sm-3">
								<button id="submit" type="button" class="btn btn-primary">保存</button>
								<span id="msg" style="color:red" class="help-block"></span>
							</div>
						</div>
					</form>

				</div>
			</div>
		</div>

	</div>
	<link href="./files/ui-dialog.css" rel="stylesheet">

	<script src="./files/ie10-viewport-bug-workaround.js"></script>
</body>
</html>