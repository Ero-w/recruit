<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="utf-8"%>
	<style type="text/css">
		.mytext {width:150px;}
	</style>
	<script type="text/javascript">
		$(document).ready(function(){		
						
		$("#infoGridDlg-buttons-enter").click(function(){
				var list=$("#list").val();
				var subject=$("#subject").val();
				var time=$("#time").val();
				var locale=$("#locale").val();
				var comment=$("#comment").val();

				if(subject!=""&&time!=""&&locale!=""){
				$.ajax({  
                    type : "POST",  //提交方式  
                    url : "../proxy.action?targetAction=infoEmailAction",  
                    data : {list:list,subject:subject,time:time,locale:locale,comment:comment},//数据，这里使用的是Json格式进行传输  
                    success : function(result) {//返回数据根据结果进行相应的处理  
                        if (result=="11") {
                        	$("#infoGridDlg").dialog("close");
                        	$.messager.show({title:"发送成功",msg:"笔试通知已成功发送..",showType:"show"});
                        } else {  
                           $.messager.show({title:"发送失败",msg:"服务器异常..",showType:"show"});
                        }  
                    }  
                });  
				}else{
				  $.messager.show({title:"发送失败",msg:"请输入主题.时间。地点",showType:"show"});
				}
		});
		
		$("#infoGridDlg-buttons-close").click(function(){
			$("#infoGridDlg").dialog("close");
		});
		
		
		});
		
		function ajaxLoading() { 
	        $("<div style=\"z-index:9998\" class=\"datagrid-mask\"></div>").css({display:"block",width:"100%",height:$(window).height()}).appendTo("body");   
	        $("<div style=\"z-index:9999\" class=\"datagrid-mask-msg\"></div>").html("正在处理,请稍后……&nbsp;&nbsp;").appendTo("body").css({display:"block",left:($(document.body).outerWidth(true) - 190) / 2,top:($(window).height() - 45) / 2});   
    		}
   		function ajaxLoadEnd() { 
	        $(".datagrid-mask").remove();   
	        $(".datagrid-mask-msg").remove();               
  		 }
		
		function ajaxProxy(valiItem,url,param){
		//record:AJAX输入值,result:AJAX返回值
		var json=valiItem.attr("data-ajax")==undefined?{record:"",result:false}:$.parseJSON("{"+valiItem.attr("data-ajax").replace(/\'/g,"\"")+"}");
		if (json.record==param.val) {
			return json.result; //新值等于原值则，直接返回上一次处理结果
		} else {
			console.log("AJAX执行");
			$.ajax({
				type:"POST",//请求方式
				url:url,//请求URL
				async:false,//同步或异步操作
				cache:false,//是否使用缓存
				data:param,//传递的参数值
				dataType:"json",//服务端返回给客户端的数据格式
				success:function(data){
					json.result=data;
					json.record=param.val;
				}
			});
			valiItem.attr("data-ajax","'record':'"+json.record+"','result':"+json.result);
			return json.result;
		}}
	</script>
	
	<script type="text/javascript">
	function infoDataGridDlg(list){ 
		//$("#infoGridDlg-formPanel").form({url:"../proxy.action?targetAction=addTStation"});
		$("#infoGridDlg").dialog({title:"笔试通知"});
		$("#infoGridDlg").dialog("open");
		$("#list").val(list);
	}

	</script>
	<div id="infoGridDlg" class="easyui-dialog" style="width:500px;height:245px;padding:10px;" data-options="closed:true">
		<div style="padding:0px 0px 0px 0px;">
			<form id="infoGridDlg-formPanel" class="easyui-form" method="post">
				<input  type="hidden" id="list" name="list" ></input>
				<table cellpadding="5">
	    			<tr>
	    				<td>主题:</td>
	    				<td><input class="easyui-textbox mytext" type="text" id="subject" name="subject" data-options="required:true,missingMessage:'必填项.'" value="笔试通知"></input></td>
	    			</tr>
	    			<tr>
	    				<td>时间:</td>
	    				<td><input class="easyui-textbox mytext" type="text" id="time" name="time" data-options="required:true,missingMessage:'必填项.'"></input></td>
	    				<td>地点:</td>
	    				<td><input class="easyui-textbox mytext" type="text" id="locale" name="locale" data-options="required:true,missingMessage:'必填项.'"></input></td>
	    			</tr>
	    			<tr>
	    				<td>备注:</td>
	    				<td colspan="3"><input class="easyui-textbox mytext" style="width:385px;height:70px;" type="text" id="comment" name="comment" data-options="multiline:true"></input></td>
	    			</tr>
	    		</table>
			</form>
			<div id="dataGridDlg-button" align=center>
	    		<a id="infoGridDlg-buttons-enter" href="javascript:void(0)" class="easyui-linkbutton" style="width:80px;">确 认</a>
	    		<a id="infoGridDlg-buttons-close" href="javascript:void(0)" class="easyui-linkbutton" style="width:80px;">取 消</a>
	    	</div>
		</div>
	</div>