<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<div id="div_create_propertygroup" class="easyui-dialog"  closed="true" modal="true" title="新建组团" style="width:450px;height:350px;">
	
	<form id="createFormpropertygroup">
		<table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" class="gbox" style="font-size:12px; line-height:26px">	
			<tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" style="empty-cells:show">
			<td id="t15" style="width:30%" align="center"><font color="#FF0000">*</font>所属楼盘</td>
			<td id="t16" style="width:70%">&nbsp;&nbsp;<s:select list="propertyProjectSel" name="createPropertyGroup.projectId"></s:select>
			</td>
			</tr>
			<tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" style="empty-cells:show">
			<td id="t15" style="width:30%" align="center"><font color="#FF0000">*</font>组团名称</td>
			<td id="t16" style="width:70%">&nbsp;&nbsp;<input type="text" id="createPropertyGroup_groupName" name="createPropertyGroup.groupName" required="true"  style="width:90px" /></td>
			</tr>
			<tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" style="empty-cells:show">
			<td id="t15" style="width:30%" align="center"><font color="#FF0000">*</font>认筹类型</td>
			<td id="t16" style="width:70%">&nbsp;
			<select name="createPropertyGroup.chipType">
				<option value="1">普通筹</option>
				<option value="2">AB筹</option>
			</select>
			</td>
			</tr>
			<tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" style="empty-cells:show">
			<td id="t15" style="width:30%" align="center">备注</td>
			<td id="t16" style="width:70%">&nbsp;&nbsp;<textarea id="createPropertyGroup_remark" name="createPropertyGroup.remark"  style="width:160px;font-size: 12px" ></textarea></td>
			</tr>
		</table>
	</form>	
</div>



<script type="text/javascript">
//打开新建弹出窗口
function openDivCreatePropertyGroup(){	
	
	$("#div_create_propertygroup").dialog({
		resizable: true,
		onClose:function(){			
			$('#createFormpropertygroup')[0].reset();
			
            //清理form中的所有填充值

			
			moduleMask("searchChipTableId");//遮罩层
			//window.parent.refreshSelectedTab("chip_tabs");  //在easyui.utils.js中(刷新tab)
					
		},
		buttons:[{
			text:'提交',
			iconCls:'icon-ok',
			handler:function(){
				
				submitCreatePropertyGroup(this);				
			}
		},
		{
			text:'关闭',
			iconCls:'icon-cancel',
			handler:function(){
				
				$('#div_create_propertygroup').dialog('close');
			}
		}]
	});
	
	$('#div_create_propertygroup').dialog('open');
	$('#div_create_propertygroup').dialog('setTitle', '新建组团');
	return false;
}


//保存组团
function submitCreatePropertyGroup(dialogSaveButton){
    //做填充的验证
	//var chipCustomerName = $("#chipCustomerName").val();	
	//if(chipCustomerName == ""){		
	//	$("#chipCustomerName").focus();
	//	dialogNewSugg(dialogSaveButton, "客户名称不能为空");
	//	return false;
	//}
    //使用easyui的validatebox进行验证，如果不够，直接在easyui.utils.js进行补充扩展
	//if($("#createFormPropertyGroup").form('validate')==false){
	//	dialogNewSugg(dialogButton, "填写的数据有误或没有填全");
	//	return;
	//};
	dialogNewSugg(dialogSaveButton, "提交中...");
	
	$.ajax({
		type:"post",
		url: "./saleunit_new/unit/group/ajaxCreatePropertyGroup.action",//TODO 填好完整的action地址
		data: $("#createFormpropertygroup").serialize() ,
		dataType: "json",
		success: function(data){			
			//根据返回的类型type判断是否成功,message做为提示内容			
			var type = data.type;
			
			if(type == "true"){
				//保存成功				
				$('#createFormpropertygroup')[0].reset();	
				$('#div_create_propertygroup').dialog('close');
				//alert(data.message)
				location = './saleunit_new/unit/group/searchPropertyGroupDetailMap.action?groupId=' +data.message;
			}else{				
				//保存失败				
				var sugg = "<font color='red'>" + data.message + "</font>";
				dialogNewSugg(dialogSaveButton, sugg);
			}			
		}		
	});
}
</script>



