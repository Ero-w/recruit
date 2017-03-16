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
                			$("#userid").val(result.userid);
                        	$("#place").val(result.place);
                        	$("#political").val(result.political);
                        	$("#birthday").val(result.birthday);
                        	$("#degree").val(result.degree);
                        	$("#cet").val(result.cet);
                        	$("#spring").val(result.spring);
                        	$("#project").val(result.project);
                        	$("#practice").val(result.practice);
                        } else {  
                            alert("数据异常~");
                        }  
                    }  
                });  
		}
		init();
		
		
		
		$("#submit").click(function(){
               		var userid=$("#userid").val();
                    var place=$("#place").val();
                    var political=$("#political").val();
                    var birthday=$("#birthday").val();
                    var degree=$("#degree").val();
                    var cet=$("#cet").val();
                    var spring=$("#spring").val();
                    var project=$("#project").val();
                    var practice=$("#practice").val();
					$.ajax({  
                    type : "POST",  //提交方式  
                    url : "proxy.action?targetAction=changeDetailAction",  
                    data : {userid:userid,place:place,political:political,birthday:birthday,degree:degree,cet:cet,spring:spring,project:project,practice:practice},//数据，这里使用的是Json格式进行传输  
                    success : function(result) {//返回数据根据结果进行相应的处理  
                        if (result=="true") {
                        	$("#msg").html("保存成功");
                        	setTimeout(yourFunction,2000);
                        	function yourFunction(){$("#msg").html("");
									}
                        } else {  
                           $("#msg").html("保存失败");
                            setTimeout(yourFunction,2000);
                        	function yourFunction(){$("#msg").html("");
									}
                        }  
                    }  
                });  
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
<div id="div1" class="sign"><a href="login.jsp" class="btn btn-link btn-xs">登录</a><span>|</span><a href="register.jsp" class="btn btn-link btn-xs">注册</a></div>
			<div id="div2" class="sign"><span>欢迎您，</span><a id="sessionname" href="center/myposition.jsp" class="btn btn-link btn-xs"></a><span>|</span><a href="proxy.action?targetAction=logoutAction" class="btn btn-link btn-xs">退出</a></div>
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
						</div></li>
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
				<li><a>个人中心</a>
				</li>
				<li class="active">详细信息</li>
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
						<li class="active"><a href="center/detail.jsp"><span
								class="glyphicon glyphicon-chevron-right"></span>详细信息</a>
						</li>
						<li><a href="center/manage.jsp"><span
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
						<span class="glyphicon glyphicon-th-list"></span> 详细信息
					</h4>
				</div>
			</div>
			<div class="col-md-10 nop">
				<div class="col-md-14 bgw sub result">
					<form class="form-horizontal" role="form">
						<div class="form-group  has-feedback"  style="display: none">
							<label class="col-sm-3 control-label"></label>
							<div class="col-sm-6">
								<input type="text"  id="userid" name="userid" value="" 
									class="form-control" readonly="">
							</div>
						</div>
						<div class="form-group  has-feedback">
							<label class="col-sm-3 control-label">籍贯</label>
							<div class="col-sm-4">
								<input type="text" id="place" name="place" value=""
									class="form-control" placeholder="籍贯" maxlength="15">
							</div>
						</div>
						<div class="form-group  has-feedback">
							<label class="col-sm-3 control-label">政治面貌</label>
							<div class="col-sm-4">
								<select class="form-control" id="political" name="political">
									<option value="">-请选择-</option>
									<option value="群众">群众</option>
									<option value="团员">团员</option>
									<option value="党员">党员</option>
								</select>
							</div>
						</div>
						<div class="form-group  has-feedback">
							<label class="col-sm-3 control-label">生日</label>
							<div class="col-sm-4">
								<input type="date" id="birthday" name="birthday" value=""
									class="form-control"  maxlength="15">
							</div>
						</div>
						<div class="form-group  has-feedback">
							<label class="col-sm-3 control-label">学历</label>
							<div class="col-sm-4">
								<select class="form-control" id="degree" name="degree">
									<option value="">-请选择-</option>
									<option value="专科">专科</option>
									<option value="本科">本科</option>
									<option value="硕士">硕士</option>
									<option value="博士">博士</option>
								</select>
							</div>
						</div>
						<div class="form-group  has-feedback">
							<label class="col-sm-3 control-label">英语等级</label>
							<div class="col-sm-4">
								<select class="form-control" id="cet" name="cet">
									<option value="">-请选择-</option>
									<option value="四级">四级</option>
									<option value="六级">六级</option>
									<option value="无">无</option>
								</select>
							</div>
						</div>
						<div class="form-group  has-feedback">
							<label class="col-sm-3 control-label">健康状态</label>
							<div class="col-sm-4">
								<select class="form-control" id="spring" name="spring">
									<option value="">-请选择-</option>
									<option value="健康">健康</option>
									<option value="一般">一般</option>
									<option value="较弱">较弱</option>
								</select>
							</div>
						</div>
						<div class="form-group  has-feedback">
							<label class="col-sm-3 control-label">身高</label>
							<div class="col-sm-4">
								<input type="email" id="project" name="project" value=""
									class="form-control" placeholder="身高" maxlength="100">
							</div>
						</div>
						<div class="form-group  has-feedback">
							<label class="col-sm-3 control-label">居住地</label>
							<div class="col-sm-4">
								<input type="email" id="practice" name="practice" value=""
									class="form-control" placeholder="居住地" maxlength="100">
							</div>
						</div>
						<div class="form-group">
							<div class="col-sm-offset-3 col-sm-10">
								<button id="submit" type="button" class="btn btn-primary"
									name="event_submit_doCreate" value="any">保存</button>
									<span id="msg" style="color:red" class="help-block"></span>
							</div>
						</div>
					</form>



				</div>
			</div>
		</div>
		<form method="post" id="J_form">
			<input name="_csrf_token" type="hidden"
				value="xHf5EWpqhWKFSFnwjOBku5"> <input type="hidden"
				name="action" value="PositionAction"> <input type="hidden"
				name="_fm.p._0.i" value="" id="J_id"> <input type="hidden"
				name="event_submit_doCancelApply" value="any" id="J_event">
		</form>
	</div>
	<link href="./files/ui-dialog.css" rel="stylesheet">
	<script type="text/javascript" src="./files/dialog-min.js"></script>

	<script src="./files/ie10-viewport-bug-workaround.js"></script>
</body>
</html>