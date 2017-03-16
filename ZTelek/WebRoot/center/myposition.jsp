<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
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
		var email = '<%=session.getAttribute("email")%>';
		var realname = '<%=session.getAttribute("realname")%>';
		var state = '<%=session.getAttribute("state")%>';
		var userid = '<%=session.getAttribute("userid")%>';
	window.onload=function(){
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
				if(state=="0"){
					$("#td5").hide();
				}
				if(state=="1"){
					$("#td5").show();
				}
				$.ajax({  
                type : "POST",  //提交方式  
                url : "proxy.action?targetAction=getStationAction",  
                data : {userid:userid,email:email},//数据，这里使用的是Json格式进行传输  
                dataType :"json" ,
                success : function(result) {//返回数据根据结果进行相应的处理  
                if (result) {
						$("#td1").html(result.stationname);
						$("#td2").html(result.type);
						$("#td3").html(result.address);
						if(result.state=="0"){
							$("#td4").html("正在处理..");
						}
						if(result.state=="1"){
							$("#td4").html("已通过筛选..");
							$("#back").attr('disabled',"true"); 
						}if(result.state=="2"){
							$("#td4").html("已录取..");
							$("#back").attr('disabled',"true"); 
						}if(result.state=="3"){
							$("#td4").html("已录取..");
							$("#back").attr('disabled',"true"); 
						}
                        } else {  
                        }  
                    }  
                });  
		}
		init();
		
		
		
		$('#back').click(function(){
				var b=$(this);
				dialog({
					id:'a',
			        title: '提示',
					content: '您确认退回该岗位吗？',
					okValue: '确认',
					ok:function(){
								$.ajax({  
			                    type : "POST",  //提交方式  
			                    url : "proxy.action?targetAction=backAction",  
			                    data : {userid:userid},//数据，这里使用的是Json格式进行传输  
			                    success : function(result) {//返回数据根据结果进行相应的处理  
			                        if (result=="11") {  
										location.href="center/myposition.jsp";
			                        } else {  
										alert("数据异常");
			                        };
			                    },
			                });  
					},
					cancelValue: '取消',
					cancel:true,
			    }).show();
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
				<li class="active">我的职位</li>
			</ol>
		</div>
		<div class="row main">
			<div class="col-md-4 nop">
				<div class="col-md-14 bgw sub menu">
					<h4>
						<span class="glyphicon glyphicon-minus"></span> 个人中心
					</h4>
					<ul class="nav nav-pills nav-stacked" role="tablist">
						<li class="active"><a href="center/myposition.jsp"><span
								class="glyphicon glyphicon-chevron-right"></span>我的职位</a>
						</li>
						<li><a href="center/basic.jsp"><span
								class="glyphicon glyphicon-chevron-right"></span>基本信息</a>
						</li>
						<li><a
							href="center/detail.jsp"><span
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
						<span class="glyphicon glyphicon-th-list"></span> 我的职位
					</h4>
				</div>
			</div>
			<div class="col-md-10 nop">
				<div class="col-md-14 bgw sub result">
					<table class="table table-striped table-hover">
						<thead>
							<tr>
								<th>职位</th>
								<th>职位性质</th>
								<th>工作地点</th>
								<th>状态</th>
								<th>操作</th>
							</tr>
						</thead>
						<tbody>
						<tr>
						<td id="td1"></td>
						<td id="td2"></td>
						<td id="td3"></td>
						<td id="td4"></td>
						<td id="td5"><button id="back" type="button" class="btn btn-primary btn-sm">退档</button></td>
						</tr>
						</tbody>
					</table>

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
		<script type="text/javascript">
$('a.J_cancel').click(function(){
	$('#J_form #J_event').attr('name','event_submit_doCancelApply')
	var b=$(this).parent();
	dialog({
		id:'a',
        title: '提示',
		content: '您确认取消应聘职位：【'+$(b).attr('data-t')+'】吗？',
		okValue: '确认取消',
		ok:function(){
			$('#J_form #J_id').val($(b).attr('data-aid'));
			$('#J_form').submit()
		},
		cancelValue: '不取消',
		cancel:true
    }).show();
})
$('a.J_exam').click(function(){
	$('#J_form #J_event').attr('name','event_submit_doStartExam')
	var b=$(this).parent();
	dialog({
		id:'b',
        title: '提示',
		content: '您确认开始职位：【'+$(b).attr('data-t')+'】的考试吗？',
		okValue: '开始考试',
		ok:function(){
			jQuery.getJSON('/member/positions/check_exam_time.json?t='+new Date().getTime(),
				{id:$(b).attr('data-aid')},
    			function(json){
    				if(json.success){
            			$('#J_form #J_id').val($(b).attr('data-aid'));
            			$('#J_form').submit()
    				}else{
    					dialog({
                    		id:'t',
                            title: '提示',
                    		content: '【'+$(b).attr('data-t')+'】的考试起止时间是：<br/><strong>'+json.from+'</strong>至<strong>'+json.to+'</strong>',
                    		okValue: '确定',
							ok:true
                        }).showModal();
    				}
    			}
			);
		},
		cancelValue: '取消',
		cancel:true
    }).show();
})
</script>
	</div>
	<link href="./files/ui-dialog.css" rel="stylesheet">
	<script type="text/javascript" src="./files/bootstrap.min.js"></script>
	<script type="text/javascript" src="./files/dialog-min.js"></script>

	<script src="./files/ie10-viewport-bug-workaround.js"></script>
</body>
</html>