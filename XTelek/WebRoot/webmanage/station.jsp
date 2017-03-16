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
<title>-岗位配置-</title>
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
		$("#list_data").datagrid({
			collapsible:false,
			fit:true,fitColumns:false,
			border:false,striped:true,
			loadMsg:'数据加载中,请等待...',
			url:"../proxy.action?targetAction=getStationList",
			method:"post",
			queryParams:form2Json("form_search"),
			singleSelect:true,checkOnSelect:false,selectOnCheck:false,
			frozenColumns:[[
				{field:'ck',checkbox:true}
			]],
			pagePosition:'bottom'/*分页显示位置*/,
			pagination:true/*分页是否显示，默认值*/,
			pageNumber:1/*当使用分页组件时，设置初始化的分页页码,该设置会自动传递到分页组件*/,
			pageSize:5/*当使用分页组件时，设置初始化的分页大小,该设置会自动传递到分页组件*/,
			pageList:[5,10,20]/*当使用分页组件时，设置初始化页面尺寸的选择列表,该设置会自动传递到分页组件*/,
			//添加按钮或分割线
			toolbar:"#toolbar",
			onDblClickRow :function(rowIndex,rowData){
   				var stationname=rowData.stationname;
   				var type=rowData.type;
   				var address=rowData.address;
   				var pnumber=rowData.pnumber;
   				var responsibility=rowData.responsibility;
   				var require=rowData.require;
   				stationDataGridDlg(stationname,type,address,pnumber,responsibility,require);
 				 },
		});
		
		//分页控件的初始化
		var pager=$("#list_data").datagrid("getPager");//获取datagrid中自带的分页（pager）对象
		pager.pagination({
			layout:['list','sep','first','prev','links','next','last','sep','refresh']/*设置分页布局*/,
			displayMsg:"当前显示 {from} 到 {to} 条数据,共{total} 条数据."
		});

		$("#submit_search").click(function(){
			$("#list_data").datagrid("load",form2Json("form_search"));
		});
		
			$("#toolber_del").click(function(){
			var rows=$("#list_data").datagrid("getChecked");//获取当前选中行
			if (rows!=null && rows.length>0) { 
				var list="[";
				$.each(rows,function(index,item) { 
					list=list+rows[index].stationid;
					if (index+1<rows.length) {
						list=list+",";
					} else {
						list=list+"]";
					}
				});
				$.messager.confirm("系统提示","您是否确认要删除选中的"+rows.length+"条数据?",function(yes_no){
					if (yes_no) { 
					$.ajax({  
                    type :"POST",  //提交方式  
                    url : "../proxy.action?targetAction=deleteTStation",  
                    data : {list:list},//数据，这里使用的是Json格式进行传输  
                    success : function(result) {//返回数据根据结果进行相应的处理  
                        if (result=="11") {
                        	$.messager.show({title:"执行结果",msg:rows.length+"条数据删除成功.",showType:"show"});
                        	$("#list_data").datagrid("load",form2Json("form_search"));
                        } else {  
                           $.messager.show({title:"执行失败",msg:"请尝试重新删除或者刷新页面",showType:"show"});
                        }  
                    }  
                });  

					}
				});
			} else { //$.messager.alert("系统提示","<div style='margin-top:10px;'>无法删除,请先选中要删除的行.</div>","info");
				$.messager.show({title:"系统提示",msg:"无法删除,请先选中要删除的行.",showType:"show"});
			}
		});
		
		
		$("#toolber_add").click(function(){ //$.messager.alert("系统提示","添加的窗口.","info");
			addDataGridDlg();
		});
		
		$("#toolber_upd").click(function(){
			var row=$("#list_data").datagrid("getSelected");//获取当前选中行
			if (row!=null) { //$.messager.alert("系统提示","修改的窗口.["+row.empno+"]","info");
				var stationid=row.stationid;
				var stationname=row.stationname;
				var type=row.type;
				var address=row.address;
				var pnumber=row.pnumber;
				var responsibility=row.responsibility;
				var require=row.require;
				updateDataGridDlg(stationid,stationname,type,address,pnumber,responsibility,require);
			} else { //$.messager.alert("系统提示","<div style='margin-top:10px;'>无法修改,请先选中要修改的行.</div>","info");
				$.messager.show({title:"系统提示",msg:"无法修改,请先选中要修改的行.",showType:"show"});
			}
		});
		
		
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
	</script>
</head>
<body>
	<table id="list_data" class="easyui-datagrid" style="width:100%;height:320px">
		<thead>
			<tr>
				<th data-options="field:'stationid',hidden:'true'">主键ID</th>
				<th data-options="field:'stationname',align:'center',sortable:false" style="width:100px;">岗位名称</th>
				<th data-options="field:'type',width:'100px',align:'center'">岗位性质</th>
				<th data-options="field:'address',width:'100px',align:'center'">工作地点</th>
				<th data-options="field:'pnumber',width:'100px',align:'center'" >招聘人数</th>
				<th data-options="field:'responsibility',width:'370px',align:'center',title:'工作职责'"></th>
				<th data-options="field:'require',width:'380px',align:'center',title:'岗位要求'"></th>
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
										<a id="toolber_add" href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true">增加岗位</a>
									</td>
									<td style="width:4px"><div class="datagrid-btn-separator"></div></td>
									<td style="width:80px">
										<a id="toolber_upd" href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true">修改岗位</a>
									</td>
									<td style="width:4px"><div class="datagrid-btn-separator"></div></td>
									<td style="width:80px">
										<a id="toolber_del" href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true">删除岗位</a>
									</td>
								</tr>
							</tbody>
						</table>
					</td>
					<td style="text-align:right;">
						<form id="form_search" name="form_search" method="post" action="">
							<input id="stationname" name="stationname" type="text" class="easyui-textbox" style="width:200px;height:26px;" data-options="prompt:'输入岗位名称'"/>
							<a id="submit_search" href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true">查询</a>
						</form>
					</td>
				</tr>
			</tbody>
		</table>
	</div>
	<%@ include file="dataGridDlg.jsp"%>
	<%@ include file="stationInfo.jsp"%>

</body>
</html>