<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html;charset=UTF-8"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/webmanage/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>" />
<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
<title>-学生信息-</title>
<link href="easyui-css/icons/iconUI.ico" type="image/x-icon"
	rel="shortcut icon" />
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
			url:"../proxy.action?targetAction=getUserList",
			method:"post",
			queryParams:form2Json("form_search"),
			singleSelect:true,checkOnSelect:false,selectOnCheck:false,
			pagePosition:'bottom'/*分页显示位置*/,
			pagination:true/*分页是否显示，默认值*/,
			pageNumber:1/*当使用分页组件时，设置初始化的分页页码,该设置会自动传递到分页组件*/,
			pageSize:3/*当使用分页组件时，设置初始化的分页大小,该设置会自动传递到分页组件*/,
			pageList:[1,2,3]/*当使用分页组件时，设置初始化页面尺寸的选择列表,该设置会自动传递到分页组件*/,
			//添加按钮或分割线
			toolbar:"#toolbar",
			onDblClickRow :function(rowIndex,rowData){
   				var filepath=rowData.filepath;
				var realname=rowData.realname; 				
   				resumeDataGridDlg(filepath,realname);
 				 }
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
		
		
	});
	
		function showImg(val,row){
			return "<img style=\"height: 120px;width: 100px;\" src=\""+"\.\.\\"+row.java+"\"/>";
		}
	</script>
</head>
<body>
	<table id="list_data" class="easyui-datagrid" style="width:100%;height:320px">
		<thead>
			<tr>
				<th data-options="field:'java',width:'80px',align:'center',title:'照片',formatter:showImg,width:'100px'"></th>
				<th data-options="field:'email'">用户名(email)</th>
				<th data-options="field:'realname',align:'center',sortable:false" style="width:70px;">真实姓名</th>
				<th data-options="field:'place',width:'100px',align:'center'" >籍贯</th>
				<th data-options="field:'political',width:'60px',align:'center'" >政治面貌</th>
				<th data-options="field:'birthday',width:'100px',align:'center'" >生日</th>
				<th data-options="field:'mobile',width:'100px',align:'center'">联系电话</th>
				<th data-options="field:'school',width:'130px',align:'center'" >学校</th>
				<th data-options="field:'major',width:'100px',align:'center'" >专业</th>
				<th data-options="field:'degree',width:'50px',align:'center'" >学位</th>
				<th data-options="field:'spring',width:'100px',align:'center'" >住址</th>
				<th data-options="field:'project',width:'70px',align:'center'" >健康状态</th>
				<th data-options="field:'practice',width:'50px',align:'center'" >身高</th>
			</tr>
		</thead>
	</table>
	<div id="toolbar" class="datagrid-toolbar">
		<table style="width:100%" cellpadding="0" cellspacing="0">
			<tbody>
				<tr>
					<td style="text-align:right;">
						<form id="form_search" name="form_search" method="post" action="">
							<input id="school" name="school" type="text" class="easyui-textbox" style="width:200px;height:26px;" data-options="prompt:'学校'"/>
							<a id="submit_search" href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true">查询</a>
						</form>
					</td>
				</tr>
			</tbody>
		</table>
	</div>
	<%@ include file="resume.jsp"%>
</body>
</html>