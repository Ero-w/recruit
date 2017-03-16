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
			var email = '<%=session.getAttribute("email")%>';
			var realname = '<%=session.getAttribute("realname")%>';
			var state = '<%=session.getAttribute("state")%>';
		
		function changeState(){

			if(realname=="null"){
				$("#div2").hide();

			}else{
				$("#div1").hide();
				$("#sessionname").html(realname);
			}
		}
		changeState();
		
		function init(){
			$.ajax({  
                type : "POST",  //提交方式  
                url : "proxy.action?targetAction=getUserAction",  
                data : {email:email},//数据，这里使用的是Json格式进行传输  
                dataType :"json" ,
                success : function(result) {//返回数据根据结果进行相应的处理  
                if (result) {
						if(result.remark=="0"){
							$("#J_file").hide();
						}
						if(result.remark=="1"){
							$("#J_file").show();
							$("#resumesubmit").html("修改");
						}
                        if(result.html=="0"){
                       		 $("#img").hide();
                        }
                        if(result.html=="1"){
                        	$("#img").show();
                        	$("#img").attr('src',result.java); 
                        	$("#picturesubmit").html("修改");
                        }

                        
                        } else {  
                            alert("数据异常~");
                        }  
                    }  
                });  
		}
		init();
		
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
						href="telek.jsp">首页</a>
					</li>
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
										<a href="company.jsp">招聘动态</a>
									</div>
									<div class="xldh5">
										<a href="proxy.action?targetAction=getStationList">招聘岗位</a>
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
				<li><a
					href="telek.jsp">首页</a>
				</li>
				<li><a
					href="proxy.action?targetAction=getStationList">个人中心</a>
				</li>
				<li class="active">简历管理</li>
			</ol>
		</div>
		<div class="row main">
			<div class="col-md-4 nop">
				<div class="col-md-14 bgw sub menu">
					<h4>
						<span class="glyphicon glyphicon-minus"></span> 个人中心
					</h4>
					<ul class="nav nav-pills nav-stacked" role="tablist">
						<li><a
							href="center/myposition.jsp"><span
								class="glyphicon glyphicon-chevron-right"></span>我的职位</a>
						</li>
						<li><a href="center/basic.jsp"><span
								class="glyphicon glyphicon-chevron-right"></span>基本信息</a>
						</li>
						<li><a href="center/detail.jsp"><span
								class="glyphicon glyphicon-chevron-right"></span>详细信息</a>
						</li>
						<li class="active"><a href="center/manage.jsp"><span
								class="glyphicon glyphicon-chevron-right"></span>附件管理</a>
						</li>

						<li><a href="center/update.jsp"><span
								class="glyphicon glyphicon-chevron-right"></span>修改密码</a>
						</li>
					</ul>
				</div>
			</div>
			<div class="col-md-10 nop">
				<div class="col-md-14 bgw sub">
					<h4>
						<span class="glyphicon glyphicon-user"></span> 简历管理
					</h4>
				</div>
			</div>
			<div class="col-md-10 nop">
			<div class="col-md-14 bgw sub" >
					<div class="panel panel-default" id="jlWord" >
						<div class="panel-heading">
							<h3 class="panel-title">照片</h3>
						</div>
						<div class="panel-body">
							<form class="form-inline" role="form" action="proxy.action?targetAction=pictureAction" method="post" enctype="multipart/form-data" >
								<div class="form-group">
									<input class="form-control" id="email" name="email" style="display:none;" value="<%=session.getAttribute("email")%>">
									<input type="file" accept=".jpg"
										class="form-control" id="fileUpload" name="fileUpload" style="width:100px">
									<div class="form-group">
									<div class="col-sm-3 nop">
										<button id="picturesubmit" type="submit" class="btn btn-primary btn-sm">上传</button>
									</div>
									</div>
									<div class="form-group">
									<div class="col-sm-3 nop">
										<img id="img" width="100px" heigth="200px"></img>
									</div>
									</div>
								</div>
							</form>
						</div>
					</div>
					<div class="panel panel-default" id="jlWord">
						<div class="panel-heading">
							<h3 class="panel-title">简历上传</h3>
						</div>
						<div class="panel-body">
							<form class="form-inline" role="form" action="proxy.action?targetAction=uploadAction" method="post" enctype="multipart/form-data" >
								<div class="form-group">
									<label class="">简历本地位置</label> 
									<input class="form-control" id="email" name="email" style="display:none;" value="<%=session.getAttribute("email")%>">
									<input type="file" accept=".docx,.doc"
										class="form-control" id="fileUpload" name="fileUpload">
									<div class="form-group">
									<div class="col-sm-3 nop">
										<button id="resumesubmit" type="submit" class="btn btn-primary btn-sm">上传</button>
									</div>
									</div>
									<p class="help-block">word文档请不要超过2M</p>
								</div>
							</form>
							<div class="col-sm-3">
									<a id="J_file"
										href="proxy.action?targetAction=downAction&email=<%=session.getAttribute("email")%>"
										target="_blank">已上传请下载简历</a>
							</div>

						</div>
					</div>
					<div class="col-md-offset-5 col-md-3"></div>
				</div>		
			<!--  -->
				
				
			</div>
		</div>
	</div>
	<link href="./files/ui-dialog.css" rel="stylesheet">
	<script type="text/javascript" src="./files/bootstrap.min.js"></script>
	<script type="text/javascript" src="./files/dialog-min.js"></script>
	<script>
$('div.main').on('click','input.form_date',function(){
	WdatePicker()
})
$('div.main').on('click','span.form_date',function(){
	WdatePicker({el:$(this).prev('input').attr('id')})
});
</script>
	<script src="./files/ie10-viewport-bug-workaround.js"></script>
</body>
</html>