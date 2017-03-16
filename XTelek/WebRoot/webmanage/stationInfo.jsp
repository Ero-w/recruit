<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
	<style type="text/css">
		.mytext {width:150px;}
	</style>
	<script type="text/javascript">
	function stationDataGridDlg(stationname,type,address,pnumber,responsibility,require){ 
		$("#stationGridDlg").dialog({title:stationname});
		$("#stationGridDlg").dialog("open");
		
		$("#stationtype").combobox('setValue',type);
		$("#stationaddress").textbox('setValue',address);
		$("#stationpnumber").textbox('setValue',pnumber);
		$("#stationresponsibility").textbox('setValue',responsibility);
		$("#stationrequire").textbox('setValue',require);
		
	}
	
	
	</script>
	<div id="stationGridDlg" class="easyui-dialog" style="width:500px;height:350px;padding:10px;" data-options="closed:true">
		<div style="padding:0px 0px 0px 0px;">
			<form id="dataGridDlg-formPanel" class="easyui-form" method="post">
				<input  type="hidden" id="stationid" name="stationid" ></input>
				<table cellpadding="5">
	    			<tr>
	    				<td>岗位性质:</td>
	    				<td><select class="easyui-combobox mytext"  id="stationtype" name="stationtype" data-options="required:true,missingMessage:'必填项.',editor:false" readonly="readonly" ></select></td>
	    			</tr>
	    			<tr>
	    				<td>工作地点:</td>
	    				<td><input class="easyui-textbox mytext" type="text" id="stationaddress" name="stationaddress" data-options="required:true,missingMessage:'必填项.'" readonly="readonly"></input></td>
	    				<td>招聘人数:</td>
	    				<td><input class="easyui-numberbox" type="text" id="stationpnumber" name="stationpnumber" data-options="required:true,missingMessage:'必填项.'" readonly="readonly"></input></td>
	    			</tr>
	    			<tr>
	    				<td>工作职责:</td>
	    				<td colspan="3"><input class="easyui-textbox" style="width:385px;height:80px;" type="text" id="stationresponsibility" name="stationresponsibility" data-options="multiline:true" readonly="readonly"></input></td>
	    			</tr>
	    			<tr>
	    				<td>岗位要求:</td>
	    				<td colspan="3"><input class="easyui-textbox" style="width:385px;height:100px;" type="text" id="stationrequire" name="stationrequire" data-options="multiline:true" readonly="readonly"></input></td>
	    			</tr>
	    		</table>
			</form>
		</div>
	</div>