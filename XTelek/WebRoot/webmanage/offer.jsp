<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="utf-8"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/webmanage/";
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
<title>模板</title>
<meta http-equiv="pragma" content="no-cache" />
<!-- 进制浏览器从本地计算机的缓存中访问页面内容 -->
<meta http-equiv="cache-control" content="no-cache" />
<!-- 禁止请求或相应的信息不能缓存 -->
<meta http-equiv="expires" content="0" />
<!-- 设置网页的到期时间，默认为0 -->
<link href="easyui-css/icons/iconUI.ico" type="image/x-icon"rel="shortcut icon" />
<link rel="stylesheet" type="text/css" href="easyui-css/easyui.css" />
<link rel="stylesheet" type="text/css" href="easyui-css/icon.css" />
<link rel="stylesheet" type="text/css" href="mainFrame/default.css" />
<script type="text/javascript" src="../jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="easyui-js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="easyui-js/easyui-lang-zh_CN.js"></script>
<script type="text/javascript">
$(document).ready(function(){
		//表格控件初始化
		var school=$("#school").val();
		
		$("#list_data").datagrid({
			collapsible:false,
			fit:true,fitColumns:false,
			border:false,striped:true,
			loadMsg:'数据加载中,请等待...',
			url:"../proxy.action?targetAction=getDelivery2Action",
			method:"post",
			queryParams:form2Json("form_search"),
			singleSelect:true,checkOnSelect:false,selectOnCheck:false,
			frozenColumns:[[
				{field:'ck',checkbox:true}
			]],
			pagePosition:'bottom'/*分页显示位置*/,
			pagination:true/*分页是否显示，默认值*/,
			pageNumber:1/*当使用分页组件时，设置初始化的分页页码,该设置会自动传递到分页组件*/,
			pageSize:10/*当使用分页组件时，设置初始化的分页大小,该设置会自动传递到分页组件*/,
			pageList:[10,20,30]/*当使用分页组件时，设置初始化页面尺寸的选择列表,该设置会自动传递到分页组件*/,
			//添加按钮或分割线
			toolbar:"#toolbar",
		});
		
		//分页控件的初始化
		var pager=$("#list_data").datagrid("getPager");//获取datagrid中自带的分页（pager）对象
		pager.pagination({
			layout:['list','sep','first','prev','links','next','last','sep','refresh']/*设置分页布局*/,
			displayMsg:"当前显示 {from} 到 {to} 条数据,共{total} 条数据."
		});
		
		function form2Json(id) {
		var arr = $("#"+id).serializeArray();
		var jsonStr = "";
		jsonStr += '{';
		for (var i = 0; i < arr.length; i++) { 
			jsonStr += '"' + arr[i].name + '":"' + arr[i].value + '",';
		}
		jsonStr = jsonStr.substring(0, (jsonStr.length - 1));
		jsonStr += '}';
		var json = JSON.parse(jsonStr);
		return json;
	}
		
		$("#submit_search").click(function(){
			$("#list_data").datagrid("load",form2Json("form_search"));
		});
		
		
		
		
				//消息发送通知
		$("#toolber_msg").click(function(){
			var rows=$("#list_data").datagrid("getChecked");//获取当前选中行
			if (rows!=null && rows.length>0) { 
				var list="[";
				$.each(rows,function(index,item) { 
					list=list+rows[index].email;
					if (index+1<rows.length) {
						list=list+",";
					} else {
						list=list+"]";
					}
				});
				
				msgDataGridDlg(list);
				
				
			} else { //$.messager.alert("系统提示","<div style='margin-top:10px;'>无法删除,请先选中要删除的行.</div>","info");
				$.messager.show({title:"系统提示",msg:"请先选中相应得名单.",showType:"show"});
			}
		});
		
		
				//消息发送通知
		$("#toolber_message").click(function(){
			var rows=$("#list_data").datagrid("getChecked");//获取当前选中行
			if (rows!=null && rows.length>0) { 
				var list="[";
				$.each(rows,function(index,item) { 
					list=list+rows[index].mobile;
					if (index+1<rows.length) {
						list=list+",";
					} else {
						list=list+"]";
					}
				});
				messageDataGridDlg(list);
				
			} else { //$.messager.alert("系统提示","<div style='margin-top:10px;'>无法删除,请先选中要删除的行.</div>","info");
				$.messager.show({title:"系统提示",msg:"请先选中相应得名单.",showType:"show"});
			}
		});
		
		
		

	});
	
	
	
	
	
	</script>
</head>

<body>
	<table id="list_data" class="easyui-datagrid"
		style="width:100%;height:320px">
		<thead>
			<tr>
				<th data-options="field:'stationname',align:'center',width:'150px'">岗位名称</th>
				<th data-options="field:'address',align:'center',sortable:false" style="width:120px;">工作地点</th>
				<th data-options="field:'email',width:'100px',align:'center',width:'200px'">用户名</th>
				<th data-options="field:'realname',width:'100px',align:'center',width:'150px'">真实姓名</th>
				<th data-options="field:'mobile',width:'100px',align:'center',width:'200px'">手机号</th>
			</tr>
		</thead>
	</table>
	<div id="toolbar" class="datagrid-toolbar">
		<table style="width:100%" cellpadding="0" cellspacing="0">
			<tbody>
				<tr>
					<td style="text-align:left;">
						<table cellpadding="0" cellspacing="0">
							<tbody>
								<tr>
									<td style="width:80px">
										<a id="toolber_msg" href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true">邮件通知</a>
									</td>
									<td style="width:8px"><div class="datagrid-btn-separator"></div></td>
									<td style="width:80px">
										<a id="toolber_message" href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true">短信通知</a>
									</td>
								</tr>
							</tbody>
						</table>
					</td>
					<td style="text-align:right;">
						<form id="form_search" name="form_search" method="post" action="">
							<input id="stationname" name="stationname" type="text"
								class="easyui-textbox" style="width:200px;height:26px;"
								data-options="prompt:'岗位名称'" /> <a id="submit_search"
								href="javascript:void(0);" class="easyui-linkbutton"
								data-options="iconCls:'icon-search',plain:true">查询</a>
						</form></td>
				</tr>
			</tbody>
		</table>
	</div>
	<%@ include file="msg.jsp"%>
	<%@ include file="message.jsp"%>
</body>
</html>