<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html;charset=UTF-8"%>
	<style type="text/css">
		.mytext {width:150px;}
	</style>
	<script type="text/javascript">		
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
	function resumeDataGridDlg(filepath,realname){ 
		if(filepath!=null){
		$("#resumeGridDlg").dialog({title:realname+"的简历"});
		$("#resumeGridDlg").dialog("open");
				$.ajax({  
                    type : "POST",  //提交方式  
                    url : "../proxy.action?targetAction=readResumeAction",  
                    data : {filepath:filepath},//数据，这里使用的是Json格式进行传输  
                    success : function(result) {//返回数据根据结果进行相应的处理  
                        if (result) {
                        	$("#resume").html(result);
                        } else {  
                           $.messager.show({title:"发送失败",msg:"服务器异常..",showType:"show"});
                        }  
                    }  
                });  
				
		
		}else{
			$.messager.show({title:"无法查看",msg:"该同学未上传简历",showType:"show"});
		}
		
		
	}

	</script>
	<div id="resumeGridDlg" class="easyui-dialog" style="width:800px;height:500px;padding:10px;" data-options="closed:true">
		<div style="padding:0px 0px 0px 0px;">
			
			<p id="resume"></p>
			
		</div>
	</div>