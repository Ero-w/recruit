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
<base href="<basePathth%>
" />
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
	function valiUserName() {
		var email = $("#email").val();
		if (email == "") {
			$("#userNameMsg").html("用户名称不为空.");
			return false;
		}
		if(!isEmail(email)){
			$("#userNameMsg").html("请输入正确的邮箱格式");
			return true;
		}else{
			$.ajax({  
                    type : "POST",  //提交方式  
                    url : "proxy.action?targetAction=checkNameAction",  
                    data : {email:email},//数据，这里使用的是Json格式进行传输  
                    success : function(result) {//返回数据根据结果进行相应的处理  
                        if (result=="true") {  
							$("#userNameMsg").html("");
                        } else {  
							$("#userNameMsg").html("该邮箱已经存在");
                        }  
                    }  
                });  
			return true;
		}
		};

	
	 function isEmail(str){
       var reg = /^(\w)+(\.\w+)*@(\w)+((\.\w+)+)$/;
       return reg.test(str);
   }
	
	function valiUserPass() {
		var password = $("#password").val();
		if (password == "") {
			$("#userPassMsg").html("用户密码不为空.");
			return false;
		} else {
			$("#userPassMsg").html("");
			return true;
		}
	}
	function valiUserWord() {
	var password = $("#password").val();
	var passwordz=$("#password2").val();
		if (password == "") {
			$("#userWordMsg").html("确认密码不为空.");
			return false;
		} else if (password!=passwordz) {
			$("#userWordMsg").html("两次输入的密码不一致.");
			return false;
		} else {
			$("#userWordMsg").html("");
			return true;
		}
	}
	
	function valiMobile(){
		var number=$("#mobile").val();
		if(number.length!=11){
			$("#usermobile").html("请输入正确得手机号码");
			return false;
		}else{
			$("#usermobile").html("");
			return true;
		}
	}
	
	
	window.onload = function() { //document无onload事件
		
		$("#email").focus(function() {
			$("#userNameMsg").html("请输入用户名称.");
		});
		$("#email").blur(function() {
			valiUserName();
		});
		$("#password").focus(function() {
			$("#userPassMsg").html("");
		});
		$("#password").blur(function() {
			valiUserPass();
		});
		$("#password2").focus(function() {
			$("#userWordMsg").html("请输入确认密码.");
		});
		$("#password2").blur(function() {
			valiUserWord();
		});
		$("#mobile").blur(function() {
			valiMobile();
		});
		
		$("#submit").live('click',function(){
			if(valiUserName()&&valiUserPass()&&valiUserWord()){
				return true;
			}else{
				return false;
			}
		});
		
		
		
		
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
<div id="div1" class="sign"><a href="login.jsp" class="btn btn-link btn-xs">登录</a><span>|</span><a href="register.jsp" class="btn btn-link btn-xs">注册</a></div>
			<div id="div2" class="sign"><span>欢迎您，</span><a id="sessionname" href="#" class="btn btn-link btn-xs"></a><span>|</span><a href="proxy.action?targetAction=logoutAction" class="btn btn-link btn-xs">退出</a></div>
		</div>
		<!-- Static navbar -->
		<div class="navbar-hik navbar-static-top" role="navigation"
			id="navigation_horiz">
			<div class="container-hik">
				<div class="navbar-collapse collapse">
					<ul class="nav navbar-nav" style="float: left; padding-left: 0;">
						<li class="navnewli clearfix"><a class="navnewoa" href="telek.jsp">首页</a>
						</li>
						<li class="navnewli clearfix"><a class="navnewoa" href="proxy.action?targetAction=getStationList"
							id="pr">应届生招聘</a>
							<div class="dropdown xlbg" style="width: auto; display: none;">
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
						</li>
						</li>
					</ul>
				</div>
				<!--/.nav-collapse -->
			</div>
		</div>

		<div class="container">
			<div class="row h45">
				<ol class="breadcrumb">
					<li><a href="telek.jsp">首页</a></li>
					<li class="active">注册</li>
				</ol>
			</div>
			<div class="row main">
				<div class="col-md-offset-2 col-md-10 nop">
					<div class="col-md-14 bgw sub">
						<h4>
							<span class="glyphicon glyphicon-user"></span> 注册
						</h4>
					</div>
				</div>
				<div class="col-md-offset-2 col-md-10 nop">
					<div class="col-md-14 bgw sub2">
						<ul class="nav nav-wizard">
							<li class="active"><a href="javascript:;">第一步：账号信息</a></li>
							<li class="disabled"><a href="javascript:;">第二步：基本资料</a></li>
							<li class="disabled"><a href="javascript:;">第三步：简历信息</a></li>
							<li class="disabled"><a href="javascript:;">完成</a></li>
						</ul>
					</div>
					<div class="col-md-14 bgw sub">
						<form class="form-horizontal" role="form" action="proxy.action?targetAction=registerAction" method="post">
							<input name="_csrf_token" type="hidden" value="6bB7YnGRUQ5j27">
							<input type="hidden" name="action" value="UserAction">
							<div class="form-group  has-feedback">
								<label class="col-sm-3 control-label">用户名(Email)</label>
								<div class="col-sm-6">
									<input type="email" id="email" name="email" value="" 
										class="form-control" placeholder="用户名(Email)" maxlength="50">
								</div>
								<span id="userNameMsg"  style="color:red" class="help-block"></span>
							</div>
							<div class="form-group  has-feedback">
								<label class="col-sm-3 control-label">密码</label>
								<div class="col-sm-4">
									<input type="password" id="password" name="password" value=""
										class="form-control" placeholder="密码" maxlength="15">
								</div>
									<span id="userPassMsg" style="color:red" class="help-block"></span>
							</div>
							<div class="form-group  has-feedback">
								<label class="col-sm-3 control-label">重复密码</label>
								<div class="col-sm-4">
									<input type="password" id="password2" name="password2" value=""
										class="form-control"  placeholder="重复密码" maxlength="15">
								</div>
								<span id="userWordMsg" style="color:red" class="help-block"></span>
							</div>
							<div class="form-group  has-feedback">
								<label class="col-sm-3 control-label">真实姓名</label>
								<div class="col-sm-5">
									<input type="text" id="realname" name="realname" value=""
										class="form-control" placeholder="真实姓名" maxlength="30">
								</div>
							</div>
							<div class="form-group  has-feedback">
								<label class="col-sm-3 control-label">手机号码</label>
								<div class="col-sm-5">
									<input type="number" id="mobile" name="mobile" value=""
										class="form-control" placeholder="手机号码"  maxlength="11">
								</div>
								<span id="usermobile" style="color:red" class="help-block"></span>
							</div>
							<div class="form-group ">
								<label class="col-sm-3 control-label">性别</label>
								<div class="col-sm-5">
									<label class="radio-inline"> <input type="radio"
										name="sex" value="0" checked=""> 男 </label> <label
										class="radio-inline"> <input type="radio"
										name="sex" value="1"> 女 </label>
								</div>
							</div>
							<div class="form-group ">
								<label class="col-sm-3 control-label">学校</label>
								<div class="col-sm-5">
									<input type="text" name="school" value=""
										class="form-control" placeholder="学校" maxlength="30">
								</div>
							</div>
							<div class="form-group ">
								<label class="col-sm-3 control-label">专业</label>
								<div class="col-sm-5">
									<input type="text" name="major" value=""
										class="form-control" placeholder="专业" maxlength="30">
								</div>
							</div>
							<div class="form-group">
								<div class="col-sm-offset-3 col-sm-10">
									<button id="submit" type="submit" class="btn btn-primary"
										name="event_submit_doCreate" value="any">提交注册</button>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
			<script charset="utf-8" src="./files/jquery.upload-1.0.2.min.js"></script>
			<link href="./files/ui-dialog.css" rel="stylesheet">
			<script type="text/javascript" src="./files/bootstrap.min.js"></script>
			<script type="text/javascript" src="./files/dialog-min.js"></script>
			<script src="./files/ie10-viewport-bug-workaround.js"></script>
			</div>
</body>
</html>