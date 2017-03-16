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
	
	<style type="text/css"> 
 * { 
  padding: 0px; 
  margin: 0px; 
 } 
 a { 
  text-decoration: none; 
 } 
 ul { 
  list-style: outside none none; 
 } 
 .slider, .slider-panel img, .slider-extra { 
  width: 400px; 
  height: 500px; 
 } 
 .slider { 
  text-align: center; 
  margin: 10px auto; 
  position: relative; 
 } 
 .slider-panel, .slider-nav, .slider-pre, .slider-next { 
  position: absolute; 
  z-index: 8; 
 } 
 .slider-panel { 
  position: absolute; 
 } 
 .slider-panel img { 
  border: none; 
 } 
 .slider-extra { 
  position: relative; 
 } 
 .slider-nav { 
  margin-left: -51px; 
  position: absolute; 
  left: 50%; 
  bottom: 4px; 
 } 
 .slider-nav li { 
  background: #3e3e3e; 
  border-radius: 50%; 
  color: #fff; 
  cursor: pointer; 
  margin: 0 2px; 
  overflow: hidden; 
  text-align: center; 
  display: inline-block; 
  height: 18px; 
  line-height: 18px; 
  width: 18px; 
 } 
 .slider-nav .slider-item-selected { 
  background: blue; 
 } 
 .slider-page a{ 
  background: rgba(0, 0, 0, 0.2); 
  filter: progid:DXImageTransform.Microsoft.gradient(startColorstr=#33000000,endColorstr=#33000000); 
  color: #fff; 
  text-align: center; 
  display: block; 
  font-family: "simsun"; 
  font-size: 22px; 
  width: 28px; 
  height: 62px; 
  line-height: 62px; 
  margin-top: -31px; 
  position: absolute; 
  top: 50%; 
 } 
 .slider-page a:HOVER { 
  background: rgba(0, 0, 0, 0.4); 
  filter: progid:DXImageTransform.Microsoft.gradient(startColorstr=#66000000,endColorstr=#66000000); 
 } 
 .slider-next { 
  left: 100%; 
  margin-left: -28px; 
 } 
 
 
 .box1{background:url(files/ppt.jpg)} 
</style> 
<script type="text/javascript"> 
 $(document).ready(function() { 
  var length, 
   currentIndex = 0, 
   interval, 
   hasStarted = false, //是否已经开始轮播 
   t = 3000; //轮播时间间隔 
  length = $('.slider-panel').length; 
  //将除了第一张图片隐藏 
  $('.slider-panel:not(:first)').hide(); 
  //将第一个slider-item设为激活状态 
  $('.slider-item:first').addClass('slider-item-selected'); 
  //隐藏向前、向后翻按钮 
  $('.slider-page').hide(); 
  //鼠标上悬时显示向前、向后翻按钮,停止滑动，鼠标离开时隐藏向前、向后翻按钮，开始滑动 
  $('.slider-panel, .slider-pre, .slider-next').hover(function() { 
   stop(); 
   $('.slider-page').show(); 
  }, function() { 
   $('.slider-page').hide(); 
   start(); 
  }); 
  $('.slider-item').hover(function(e) { 
   stop(); 
   var preIndex = $(".slider-item").filter(".slider-item-selected").index(); 
   currentIndex = $(this).index(); 
   play(preIndex, currentIndex); 
  }, function() { 
   start(); 
  }); 
  $('.slider-pre').unbind('click'); 
  $('.slider-pre').bind('click', function() { 
   pre(); 
  }); 
  $('.slider-next').unbind('click'); 
  $('.slider-next').bind('click', function() { 
   next(); 
  }); 
  /** 
   * 向前翻页 
   */
  function pre() { 
   var preIndex = currentIndex; 
   currentIndex = (--currentIndex + length) % length; 
   play(preIndex, currentIndex); 
  } 
  /** 
   * 向后翻页 
   */
  function next() { 
   var preIndex = currentIndex; 
   currentIndex = ++currentIndex % length; 
   play(preIndex, currentIndex); 
  } 
  /** 
   * 从preIndex页翻到currentIndex页 
   * preIndex 整数，翻页的起始页 
   * currentIndex 整数，翻到的那页 
   */
  function play(preIndex, currentIndex) { 
   $('.slider-panel').eq(preIndex).fadeOut(500) 
    .parent().children().eq(currentIndex).fadeIn(1000); 
   $('.slider-item').removeClass('slider-item-selected'); 
   $('.slider-item').eq(currentIndex).addClass('slider-item-selected'); 
  } 
  /** 
   * 开始轮播 
   */
  function start() { 
   if(!hasStarted) { 
    hasStarted = true; 
    interval = setInterval(next, t); 
   } 
  } 
  /** 
   * 停止轮播 
   */
  function stop() { 
   clearInterval(interval); 
   hasStarted = false; 
  } 
  //开始轮播 
  start(); 
 }); 
</script> 
	
	
  </head>
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
						<div class="xldh clearfix">
                            <div class="xldh1">
                                <div class="xldh5"><a href="company.jsp">公司简介</a></div>
                                <div class="xldh5"><a href="proxy.action?targetAction=getStationList">招聘岗位</a></div>
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
<div  class="box1">
	
	<img src="./files/ppt.jpg" height="500px" width="100%">   

	 <!-- 轮播图-->
	<div class="slider" style="margin-left:86px;display:none"> 
  <ul class="slider-main"> 
   <li class="slider-panel"> 
    <a target="_blank"><img src="files/l1.png"></img></a> 
   </li> 
   <li class="slider-panel"> 
    <a target="_blank"><img src="files/l2.png"></img></a> 
   </li> 
   <li class="slider-panel"> 
    <a  target="_blank"><img src="files/l3.png"></img></a> 
   </li> 
  </ul> 
  <div class="slider-extra"> 
   <ul class="slider-nav"> 
    <li class="slider-item">1</li> 
    <li class="slider-item">2</li> 
    <li class="slider-item">3</li> 
   </ul> 
   <div class="slider-page"> 
    <a class="slider-pre" href="javascript:;;"><</a> 
    <a class="slider-next" href="javascript:;;">></a> 
   </div> 
  </div> 
 </div> 
	  
</div> 
<div class="row sc" style="margin-right: 0;">
	<a>
	<div class="xxx w1">
        <div class="s"></div>
        <div class="d"></div>
	</div>
    </a>
	<a>
	<div class="xxx w1">
		<div class="s"></div>
        <div class="d"></div>
	</div>
	</a>
</div>

</div

<link href="./files/ui-dialog.css" rel="stylesheet">
<script type="text/javascript" src="./files/bootstrap.min.js"></script>
<script type="text/javascript" src="./files/dialog-min.js"></script>

<!--[if lt IE 9]>
	<script src="/static/ie/html5shiv.min.js"></script>
	<script src="/static/ie/respond.min.js"></script>		
<![endif]-->
<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<script src="./files/ie10-viewport-bug-workaround.js"></script>

</div>
  </body>
</html>