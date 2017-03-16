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

			<style type="text/css">
.wrapper {
	width: 730px;
	height: 365px;
	margin: 12px 38px;
	overflow: hidden;
	position: relative;
}

.iframe {
	width: 1024px;
	height: 768px;
	position: absolute;
	top: -150px;
	left: -1px;
}
</style>

			<div class="row h45">
				<ol class="breadcrumb">
					<li><a href="telek.jsp">首页</a>
					</li>
					<li class="active">公司简介</li>
				</ol>
			</div>
			<div class="row main">
				<div class="col-md-3 nop">
					<div class="col-md-14 bgw sub menu">
						<h4>
							<span class="glyphicon glyphicon-minus"></span>应届生招聘
						</h4>
						<ul class="nav nav-pills nav-stacked" role="tablist">
							<li class="divider"></li>
							<li class="active"><a href="company.jsp"><span
									class="glyphicon glyphicon-chevron-right"></span>公司简介</a>
							</li>
							<li><a href="proxy.action?targetAction=getStationList"><span
									class="glyphicon glyphicon-chevron-right"></span>招聘岗位</a>
							</li>
							<li class="divider"></li>
						</ul>
					</div>

				</div>

				<div class="col-md-11 nop">
					<div class="col-md-14 bgw sub2">
						<b><span
							style="color: red; font-family: 宋体; font-size: 12pt; mso-bidi-font-family: 宋体; mso-font-kerning: 0pt;">公司简介</span>
						</b>
						</p>
						<p align="left" class="MsoNormal"
							style="background: white; text-align: left; line-height: 22pt; text-indent: 24.1pt; mso-char-indent-count: 2.0; mso-pagination: widow-orphan; mso-line-height-rule: exactly;">
							<b><span
								style="color: black; font-family: 宋体; font-size: 12pt; mso-bidi-font-family: 宋体; mso-font-kerning: 0pt;">杭州天丽科技有限公司是国内领先的电网发展管理、智能电网用户侧解决方案提供商，拥有近<span
									lang="EN-US">200</span>名员工，其中，本科及以上学历占<span lang="EN-US">97.8%</span>，专业技术人员占<span
									lang="EN-US">95%</span>。我们秉承&ldquo;助您做得更好&rdquo;的企业宗旨，围绕客户需求，持续研究和创新，在电力企业综合管理业务、前期管理业务、投资管理业务、统计管理业务、智能电网用户侧等领域构筑了全面的竞争优势，近几年来，公司经营业绩增长迅速，呈现出蓬勃的发展势态。</span>
							</b>
						</p>
						<p align="left" class="MsoNormal"
							style="background: white; text-align: left; line-height: 22pt; text-indent: 24.1pt; mso-char-indent-count: 2.0; mso-pagination: widow-orphan; mso-line-height-rule: exactly;">
							<b><span lang="EN-US"
								style="color: black; font-family: 宋体; font-size: 12pt; mso-bidi-font-family: 宋体; mso-font-kerning: 0pt;">&nbsp;</span>
							</b>
						</p>
						<p align="left" class="MsoNormal"
							style="background: white; text-align: left; line-height: 22pt; mso-pagination: widow-orphan; mso-line-height-rule: exactly;">
							<b><span
								style="color: red; font-family: 宋体; font-size: 12pt; mso-bidi-font-family: 宋体; mso-font-kerning: 0pt;">电网发展事业部简介</span>
							</b>
						</p>
						<p align="left" class="MsoNormal"
							style="background: white; text-align: left; line-height: 22pt; text-indent: 24.1pt; mso-char-indent-count: 2.0; mso-pagination: widow-orphan; mso-line-height-rule: exactly;">
							<b><span
								style="color: black; font-family: 宋体; font-size: 12pt; mso-bidi-font-family: 宋体; mso-font-kerning: 0pt;">电网发展事业部经营多元化的电力业务，致力于发电、输电、配电环节的电力行业，为发电集团、电网公司提供项目投资管理解决方案。电网发展事业部分为杭州公司、北京分公司，现有<span
									lang="EN-US">3</span>个产品部门、五大经营片区，其目标是为客户提供持续的经营绩效改善，促进电力行业的发展。</span>
							</b>
						</p>
						<p align="left" class="MsoNormal"
							style="background: white; text-align: left; line-height: 22pt; mso-pagination: widow-orphan; mso-line-height-rule: exactly;">
							<b><span
								style="color: red; font-family: 宋体; font-size: 12pt; mso-bidi-font-family: 宋体; mso-font-kerning: 0pt;">能源互联网事业部简介</span>
							</b>
						</p>
						<p align="left" class="MsoNormal"
							style="background: white; text-align: left; line-height: 22pt; text-indent: 24.1pt; mso-char-indent-count: 2.0; mso-pagination: widow-orphan; mso-line-height-rule: exactly;">
							<b><span
								style="color: black; font-family: 宋体; font-size: 12pt; mso-bidi-font-family: 宋体; mso-font-kerning: 0pt;">能源互联网事业部成立于<span
									lang="EN-US">2011</span>年，起源于公司对智能电网的研究。致力于让更多的清洁能源接入电网，主要从事内容：智能电网用户侧硬件、软件以及云服务运营工作。共<span
									lang="EN-US">40</span>多人团队，分别从事硬件、<span lang="EN-US">App</span>、云端开发以及运营推广工作。我们的产品：赫马智能控制器、赫马烟气报警器、赫马智能空调</span>
							</b>
						</p>
						<p align="left" class="MsoNormal"
							style="background: white; text-align: left; line-height: 22pt; mso-pagination: widow-orphan; mso-line-height-rule: exactly;">
							<b><span lang="EN-US"
								style="color: red; font-family: 宋体; font-size: 12pt; mso-bidi-font-family: 宋体; mso-font-kerning: 0pt;">&nbsp;</span>
							</b>
						</p>
						<p align="left" class="MsoNormal"
							style="background: white; text-align: left; line-height: 22pt; mso-pagination: widow-orphan; mso-line-height-rule: exactly;">
							<b><span
								style="color: red; font-family: 宋体; font-size: 12pt; mso-bidi-font-family: 宋体; mso-font-kerning: 0pt;">荣誉资质</span>
							</b>
						</p>
						<p align="left" class="MsoNormal"
							style="background: white; text-align: left; line-height: 22pt; text-indent: 24.1pt; mso-char-indent-count: 2.0; mso-pagination: widow-orphan; mso-line-height-rule: exactly;">
							<b><span lang="EN-US"
								style="color: black; font-family: 宋体; font-size: 12pt; mso-bidi-font-family: 宋体; mso-font-kerning: 0pt;">1)<span
									style="mso-tab-count: 1;"> </span> </span> </b><b><span
								style="color: black; font-family: 宋体; font-size: 12pt; mso-bidi-font-family: 宋体; mso-font-kerning: 0pt;">国家电网公司信息化<span
									lang="EN-US">SG186</span>工程优秀合作单位</span> </b>
						</p>
						<p align="left" class="MsoNormal"
							style="background: white; text-align: left; line-height: 22pt; text-indent: 24.1pt; mso-char-indent-count: 2.0; mso-pagination: widow-orphan; mso-line-height-rule: exactly;">
							<b><span lang="EN-US"
								style="color: black; font-family: 宋体; font-size: 12pt; mso-bidi-font-family: 宋体; mso-font-kerning: 0pt;">2)<span
									style="mso-tab-count: 1;"> </span> </span> </b><b><span
								style="color: black; font-family: 宋体; font-size: 12pt; mso-bidi-font-family: 宋体; mso-font-kerning: 0pt;">国家电网公司信息化<span
									lang="EN-US">SG-ERP</span>支撑&ldquo;三集五大&rdquo;体系建设合作厂商</span> </b>
						</p>
						<p align="left" class="MsoNormal"
							style="background: white; text-align: left; line-height: 22pt; text-indent: 24.1pt; mso-char-indent-count: 2.0; mso-pagination: widow-orphan; mso-line-height-rule: exactly;">
							<b><span lang="EN-US"
								style="color: black; font-family: 宋体; font-size: 12pt; mso-bidi-font-family: 宋体; mso-font-kerning: 0pt;">3)<span
									style="mso-tab-count: 1;"> </span> </span> </b><b><span
								style="color: black; font-family: 宋体; font-size: 12pt; mso-bidi-font-family: 宋体; mso-font-kerning: 0pt;">浙江省首批认证高新技术企业、软件企业</span>
							</b>
						</p>
						<p align="left" class="MsoNormal"
							style="background: white; text-align: left; line-height: 22pt; text-indent: 24.1pt; mso-char-indent-count: 2.0; mso-pagination: widow-orphan; mso-line-height-rule: exactly;">
							<b><span lang="EN-US"
								style="color: black; font-family: 宋体; font-size: 12pt; mso-bidi-font-family: 宋体; mso-font-kerning: 0pt;">4)<span
									style="mso-tab-count: 1;"> </span>CMMI</span> </b><b><span
								style="color: black; font-family: 宋体; font-size: 12pt; mso-bidi-font-family: 宋体; mso-font-kerning: 0pt;">成熟度三级认证</span>
							</b>
						</p>
						<p align="left" class="MsoNormal"
							style="background: white; text-align: left; line-height: 22pt; text-indent: 24.1pt; mso-char-indent-count: 2.0; mso-pagination: widow-orphan; mso-line-height-rule: exactly;">
							<b><span lang="EN-US"
								style="color: black; font-family: 宋体; font-size: 12pt; mso-bidi-font-family: 宋体; mso-font-kerning: 0pt;">5)<span
									style="mso-tab-count: 1;"> </span>ISO9001</span> </b><b><span
								style="color: black; font-family: 宋体; font-size: 12pt; mso-bidi-font-family: 宋体; mso-font-kerning: 0pt;">质量管理体系、<span
									lang="EN-US">ISO27001</span>信息安全管理</span> </b>
						</p>
						<p align="left" class="MsoNormal"
							style="background: white; text-align: left; line-height: 22pt; text-indent: 24.1pt; mso-char-indent-count: 2.0; mso-pagination: widow-orphan; mso-line-height-rule: exactly;">
							<b><span lang="EN-US"
								style="color: black; font-family: 宋体; font-size: 12pt; mso-bidi-font-family: 宋体; mso-font-kerning: 0pt;">6)<span
									style="mso-tab-count: 1;"> </span> </span> </b><b><span
								style="color: black; font-family: 宋体; font-size: 12pt; mso-bidi-font-family: 宋体; mso-font-kerning: 0pt;">大学生见习训练基地</span>
							</b>
						</p>
					</div>

					<div class="col-md-11 nop">
						<div class="alert alert-info col-md-8"
							style="margin:0 20px;padding:0 15px" role="alert">
							<strong><span class="glyphicon glyphicon-info-sign"></span>
								联系方式：</strong> <br> <strong>人力资源部：</strong>蒋先生 马小姐 陈小姐 <br> <strong>联系电话：</strong>88398100
							<br> <strong>地 址：</strong>杭州滨江区滨盛路1509号天恒大厦16楼1601室 <br>
							<strong>简历投递邮箱：</strong>hr@smtp.telek.com.cn邮件主题命名格式:“姓名-学校-专业
							-应聘岗位”
						</div>
					</div>
				</div>

			</div>



			<script>
$('#modalZb').click(function(){
	$('#zbIframe').attr('src','http://square.ys7.com/square/play.action?cameraId=37806');
	$('#myModalZb').modal();
});
$('#clossZb').click(function(){
	$('#zbIframe').attr('src','');
});
</script>
		</div>

		<link href="./files/ui-dialog.css" rel="stylesheet">
		<script type="text/javascript" src="./files/bootstrap.min.js"></script>
		<script type="text/javascript" src="./files/dialog-min.js"></script>
		<style>
.iwxt {
	position: absolute;
	width: 158px;
	height: 181px;
	top: 55px;
	left: -28px;
	z-index: 9999999;
	overflow: hidden;
	z-index: 99999;
}

.iwxt1 {
	background:
		url(http://dealer-static.hikvision.com/hr/images/iweixing.jpg)
		no-repeat;
	width: 158px;
	height: 181px;
	position: relative;
}

#weixinlogoc {
	right: 7px;
	bottom: 3px;
	width: 11px;
	height: 18px;
	display: block;
	position: absolute;
}

.xgy1 {
	background:
		url("http://dealer-static.hikvision.com/hr/images/xgpic7.jpg")
		no-repeat left;
	padding-left: 26px;
	height: 30px;
}

.xgy1 span {
	font-size: 18px;
}

.xgy1 a {
	font-size: 18px;
	line-height: 30px;
	color: #3b3b3b;
}

.xgy1 a:hover {
	text-decoration: underline;
	color: #C4271E;
}
</style>
		<script type="text/javascript">
$(document).ready(function(){
$("#weixinlogo").click(function(){
	$(".iwxt").show();
});
$("#weixinlogoc").click(function(){
	$(".iwxt").hide();
});
});
</script>

		<script src="./files/ie10-viewport-bug-workaround.js"></script>

	</div>
</body>
</html>