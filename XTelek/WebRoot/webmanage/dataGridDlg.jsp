<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
	<style type="text/css">
		.mytext {width:150px;}
	</style>
	<script type="text/javascript">
		$(document).ready(function(){
					$("#type").combobox({
						url:'type.json',
						method:'get',
						valueField:'id',
						textField:'text',
						panelHeight:'auto'
					});
					
		$("#dataGridDlg-formPanel").form({
			onSubmit:function(param){ //请求处理前
				$(this).form("enableValidation");
			    var result=$(this).form("validate");//进行表单字段验证，当全部字段都有效时返回true。
			    if (result) {
			    	ajaxLoading();
			    }
			    return result;
			},
			success:function(data){ //请求处理结束
				ajaxLoadEnd();//alert(json.message);
				if (data="11") { 
					var messageinfo="岗位信息"+($("#stationid").val()==0?"添加":"修改")+"成功.";
					$("#dataGridDlg").dialog("close");
					$.messager.show({title:"执行结果",msg:messageinfo,showType:"show"});
					$("#dataGridDlg-formPanel").form('clear');
					$("#list_data").datagrid("load",form2Json("form_search"));
				} else { 
					var messageinfo="岗位信息"+($("#stationid").val()==0?"添加":"修改")+"失败.";
					$.messager.show({title:"执行结果",msg:messageinfo,showType:"show"});
				}
			}
		});
		
						
		$("#dataGridDlg-buttons-enter").click(function(){
				var address=$("#address").val();
				var stationname=$("#stationname2").val();
				if($("#stationid").val()==0){
				$.ajax({  
                    type : "POST",  //提交方式  
                    url : "../proxy.action?targetAction=checkTStation",  
                    data : {stationname:stationname,address:address},//数据，这里使用的是Json格式进行传输  
                    success : function(result) {//返回数据根据结果进行相应的处理  
                        if (result=="11") {
                        	$("#dataGridDlg-formPanel").form("submit");//提交表单数据
                        } else {  
                          $.messager.show({title:"添加失败",msg:"该岗位已存在,请重新输入",showType:"show"});
                        }  
                    }  
                });  
				}else{
				$("#dataGridDlg-formPanel").form("submit");//提交表单数据
				}
		});
		
		$("#dataGridDlg-buttons-close").click(function(){
			$("#dataGridDlg").dialog("close");
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
	function addDataGridDlg(){ 
		$("#dataGridDlg-formPanel").form({url:"../proxy.action?targetAction=addTStation"});
		$("#dataGridDlg").dialog({title:"添加岗位"});
		$("#dataGridDlg-formPanel").form('clear');
		$("#dataGridDlg").dialog("open");
	}
	
	function updateDataGridDlg(stationid,stationname,type,address,pnumber,responsibility,require){
		$("#stationid").val(stationid);
		$("#stationname2").textbox('setValue',stationname);
		$("#type").combobox('setValue',type);
		$("#address").textbox('setValue',address);
		$("#pnumber").textbox('setValue',pnumber);
		$("#responsibility").textbox('setValue',responsibility);
		$("#require").textbox('setValue',require);
		$("#dataGridDlg-formPanel").form(
		{url:"../proxy.action?targetAction=updateTStation",
		});		
		$("#dataGridDlg").dialog({title:"修改岗位"});
		$("#dataGridDlg").dialog("open");
	}
	
	</script>
	<div id="dataGridDlg" class="easyui-dialog" style="width:500px;height:325px;padding:10px;" data-options="closed:true">
		<div style="padding:0px 0px 0px 0px;">
			<form id="dataGridDlg-formPanel" class="easyui-form" method="post">
				<input  type="hidden" id="stationid" name="stationid" ></input>
				<table cellpadding="5">
	    			<tr>
	    				<td>岗位名称:</td>
	    				<td><input class="easyui-textbox mytext" type="text" id="stationname2" name="stationname2" data-options="required:true,missingMessage:'必填项.'"></input></td>
	    				<td>岗位性质:</td>
	    				<td><select class="easyui-combobox mytext"  id="type" name="type" data-options="required:true,missingMessage:'必填项.'"></select></td>
	    			</tr>
	    			<tr>
	    				<td>工作地点:</td>
	    				<td><input class="easyui-textbox mytext" type="text" id="address" name="address" data-options="required:true,missingMessage:'必填项.'"></input></td>
	    				<td>招聘人数:</td>
	    				<td><input class="easyui-numberbox" type="text" id="pnumber" name="pnumber" data-options="required:true,missingMessage:'必填项.'"></input></td>
	    			</tr>
	    			<tr>
	    				<td>工作职责:</td>
	    				<td colspan="3"><input class="easyui-textbox" style="width:385px;height:70px;" type="text" id="responsibility" name="responsibility" data-options="multiline:true"></input></td>
	    			</tr>
	    			<tr>
	    				<td>岗位要求:</td>
	    				<td colspan="3"><input class="easyui-textbox" style="width:385px;height:70px;" type="text" id="require" name="require" data-options="multiline:true"></input></td>
	    			</tr>
	    		</table>
			</form>
			<div id="dataGridDlg-button" align=center>
	    		<a id="dataGridDlg-buttons-enter" href="javascript:void(0)" class="easyui-linkbutton" style="width:80px;">确 认</a>
	    		<a id="dataGridDlg-buttons-close" href="javascript:void(0)" class="easyui-linkbutton" style="width:80px;">取 消</a>
	    	</div>
		</div>
	</div>