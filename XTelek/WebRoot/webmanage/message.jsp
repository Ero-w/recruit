<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="utf-8"%>
	<style type="text/css">
		.mytext {width:150px;}
	</style>
	<script type="text/javascript">
		$(document).ready(function(){		
		$("#messageGridDlg-buttons-enter").click(function(){
				var list=$("#messagelist").val();
				var content=$("#content").val();
				

				
				if(content!=""){
				$.ajax({  
                    type : "POST",  //提交方式  
                    url : "../proxy.action?targetAction=sendMessageAction",  
                    data : {list:list,content:content},//数据，这里使用的是Json格式进行传输  
                    success : function(result) {//返回数据根据结果进行相应的处理  
                        if (result) {
                        	$("#messageGridDlg").dialog("close");
                        	$.messager.show({title:"发送成功",msg:"信息已成功给这."+result+"位同学",showType:"show"});
                        } else {  
                           $.messager.show({title:"发送失败",msg:"服务器异常..",showType:"show"});
                        }  
                    }  
                });  
				}else{
				  $.messager.show({title:"发送失败",msg:"请输入发送信息...",showType:"show"});
				}
		});
		
		$("#messageGridDlg-buttons-close").click(function(){
			$("#messageGridDlg").dialog("close");
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
	function messageDataGridDlg(list){ 
		//$("#infoGridDlg-formPanel").form({url:"../proxy.action?targetAction=addTStation"});
		$("#messageGridDlg").dialog({title:"短信通知"});
		$("#messageGridDlg").dialog("open");
		$("#messagelist").val(list);
	}

	</script>
	<div id="messageGridDlg" class="easyui-dialog" style="width:420px;height:190px;padding:10px;" data-options="closed:true">
		<div style="padding:0px 0px 0px 0px;">
			<form id="msgGridDlg-formPanel" class="easyui-form" method="post">
				<input  type="hidden" id="messagelist" name="messagelist" ></input>
				<table cellpadding="5">
	    			<tr>
	    				<td>发送内容:</td>
	    				<td colspan="3"><input class="easyui-textbox mytext" style="width:300px;height:70px;" type="text" id="content" name=""content"" data-options="required:true,multiline:true"></input></td>
	    			</tr>
	    		</table>
			</form>
			<br/>
			<div id="dataGridDlg-button" align=center>
	    		<a id="messageGridDlg-buttons-enter" href="javascript:void(0)" class="easyui-linkbutton" style="width:80px;">确 认</a>
	    		<a id="messageGridDlg-buttons-close" href="javascript:void(0)" class="easyui-linkbutton" style="width:80px;">取 消</a>
	    	</div>
		</div>
	</div>