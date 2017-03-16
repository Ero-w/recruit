<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>  
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
	<link href="./files/style2.css" rel="stylesheet">
	<script src="./files/jquery-1.7.2.min.js"></script>
	<script src="./files/jquery.easing.1.3.js"></script>
	<script src="./files/jquery.hoverIntent.minified.js"></script>
	<script src="./files/jquery.naviDropDown.js"></script>
  </head>
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
  <body>
 	<div class="row-fluid bgw">
	<div class="top">
		<div class="logo"><img src="./files/logo.png"></div>
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
<div class="navbar-hik navbar-static-top" role="navigation" id="navigation_horiz">
	<div class="container-hik">
        <div class="navbar-collapse collapse">
			<ul class="nav navbar-nav" style="float: left; padding-left: 0;">
                <li class="navnewli clearfix"><a class="navnewoa" href="telek.jsp">首页</a> </li>
                <li class="navnewli clearfix"><a class="navnewoa" href="proxy.action?targetAction=getStationList" id="pr">应届生招聘</a>
                    <div class="dropdown xlbg" onmouseover="$(&#39;#pr&#39;).attr(&#39;class&#39;,&#39;navnewdq&#39;)" onmouseout="$(&#39;#pr&#39;).attr(&#39;class&#39;,&#39;navnewoa&#39;)" style="width: auto; display: none;">
                        <div style="height: 5px; width: 486px; margin-left: 6px; overflow: hidden; background: #D2332F;">
                        </div>
                </li>
                      <div class="dropdown xlbg" onmouseover="$(&#39;#fax16&#39;).attr(&#39;class&#39;,&#39;navnewdq&#39;)" onmouseout="$(&#39;#fax16&#39;).attr(&#39;class&#39;,&#39;navnewoa&#39;)" style="width: auto; display: none;">
                        <div style="height: 5px; width: 486px; margin-left: 6px; overflow: hidden; background: #D2332F;">
                        </div>
                        </div>
                    </div>
                </li>
				        </ul>
        </div><!--/.nav-collapse -->
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
		<li><a>首页</a></li>
		<li class="active">校招职位</li>
	</ol>
</div>
<div class="row main">
	<div class="col-md-3 nop">
	<div class="col-md-14 bgw sub menu">
				<h4><span class="glyphicon glyphicon-minus"></span>应届生招聘</h4>
		<ul class="nav nav-pills nav-stacked" role="tablist">
			<li class="divider"></li>
			<li><a href="company.jsp"><span class="glyphicon glyphicon-chevron-right"></span>公司简介</a></li>
			<li class="active"><a href="#"><span class="glyphicon glyphicon-chevron-right"></span>招聘岗位</a></li>
			<li class="divider"></li>
		</ul>
			</div>
</div>
	<div class="col-md-11 nop">
		<div class="col-md-14 bgw sub2">
			<div class="row search">
				<form class="form-inline" action="proxy.action" method="post">
				<input type="hidden" name="targetAction" value="getStationList" />
				
				<div class="form-group-sm col-xs-4">
					<label>职位性质</label>
					<select class="form-control" name="nature">
						<option value="">-请选择-</option>
									<option value="技术类">技术类</option>
									<option value="文职类">文职类</option>
	
					</select>
				</div>
				<div class="form-group-sm col-xs-4">
					<label class="sr-only" for="keyword">职位关键字</label>
					<input type="text" class="form-control" id="keyword" name="keyword" value="" placeholder="请岗位名称">
				</div>
				<button type="submit" class="btn btn-danger btn-sm">搜索职位</button>
				</form>
			</div>				
		</div>
	</div>
	<div class="col-md-11 nop">
		<div class="col-md-14 bgw sub result">
			<table class="table table-striped table-hover">
				<thead>
					<tr>
						<th>职位名称</th>
						<th>职位性质</th>
						<th>工作地点</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${list}" var="item" varStatus="status"> 
					<tr>
						<td><a href="proxy.action?targetAction=getPositionAction&id=${item.stationid}">${item.stationname}</a></td>
						<td>${item.type}</td>
						<td>${item.address}</td>
					</tr>
				</c:forEach>
					</tbody>
			</table>
		</div>
	</div>
</div>
</div>
  </body>
</html>