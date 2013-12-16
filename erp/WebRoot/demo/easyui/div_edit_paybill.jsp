<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<div id="div_edit_PayBill" class="easyui-dialog" closed="true" modal="true" title="修改付款单" style="width:450px;height:350px;">
	<form id="editFormPayBill">
		<table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" class="gbox" style="font-size:12px; line-height:26px">			
			<input type="hidden" id="editPayBill_id" name="editPayBill.id"/>
            <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" style="empty-cells:show">
			<td id="t15" style="width:30%" align="center"><font color="#FF0000">*</font>认购或合同				
			<td id="t16" style="width:70%">&nbsp;&nbsp;<input type="text" id="editPayBill_confirmType" name="editPayBill.confirmType" required="required"  style="width:90px" /></td>
			</tr>            
            <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" style="empty-cells:show">
			<td id="t15" style="width:30%" align="center"><font color="#FF0000">*</font>主单id				
			<td id="t16" style="width:70%">&nbsp;&nbsp;<input type="text" id="editPayBill_mainId" name="editPayBill.mainId" required="required"  style="width:90px" class="easyui-numberbox" data-options="min:0,precision:0"/></td>
			</tr>            
            <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" style="empty-cells:show">
			<td id="t15" style="width:30%" align="center"><font color="#FF0000">*</font>开盘日期				
			<td id="t16" style="width:70%">&nbsp;&nbsp;<input type="text" id="editPayBill_startSaleDate" name="editPayBill.startSaleDate" required="required"  style="width:90px" class="easyui-datebox"/></td>
			</tr>            
            <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" style="empty-cells:show">
			<td id="t15" style="width:30%" align="center"><font color="#FF0000">*</font>单据类型				
			<td id="t16" style="width:70%">&nbsp;&nbsp;<input type="text" id="editPayBill_billType" name="editPayBill.billType" required="required"  style="width:90px" /></td>
			</tr>            
            <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" style="empty-cells:show">
			<td id="t15" style="width:30%" align="center"><font color="#FF0000">*</font>票据类型				
			<td id="t16" style="width:70%">&nbsp;&nbsp;<input type="text" id="editPayBill_paperType" name="editPayBill.paperType" required="required"  style="width:90px" /></td>
			</tr>            
            <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" style="empty-cells:show">
			<td id="t15" style="width:30%" align="center"><font color="#FF0000">*</font>票据编号				
			<td id="t16" style="width:70%">&nbsp;&nbsp;<input type="text" id="editPayBill_billNo" name="editPayBill.billNo" required="required"  style="width:90px" /></td>
			</tr>            
            <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" style="empty-cells:show">
			<td id="t15" style="width:30%" align="center"><font color="#FF0000">*</font>金额				
			<td id="t16" style="width:70%">&nbsp;&nbsp;<input type="text" id="editPayBill_payMoney" name="editPayBill.payMoney" required="required"  style="width:90px" class="easyui-numberbox" data-options="min:0,precision:2"/></td>
			</tr>            
            <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" style="empty-cells:show">
			<td id="t15" style="width:30%" align="center"><font color="#FF0000">*</font>交款人				
			<td id="t16" style="width:70%">&nbsp;&nbsp;<input type="text" id="editPayBill_payMan" name="editPayBill.payMan" required="required"  style="width:90px" /></td>
			</tr>            
            <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" style="empty-cells:show">
			<td id="t15" style="width:30%" align="center"><font color="#FF0000">*</font>开票人id				
			<td id="t16" style="width:70%">&nbsp;&nbsp;<input type="text" id="editPayBill_writerId" name="editPayBill.writerId" required="required"  style="width:90px" class="easyui-numberbox" data-options="min:0,precision:0"/></td>
			</tr>            
            <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" style="empty-cells:show">
			<td id="t15" style="width:30%" align="center"><font color="#FF0000">*</font>审核日期				
			<td id="t16" style="width:70%">&nbsp;&nbsp;<input type="text" id="editPayBill_approvalDate" name="editPayBill.approvalDate" required="required"  style="width:90px" class="easyui-datebox"/></td>
			</tr>            
            <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" style="empty-cells:show">
			<td id="t15" style="width:30%" align="center"><font color="#FF0000">*</font>状态				
			<td id="t16" style="width:70%">&nbsp;&nbsp;<input type="text" id="editPayBill_state" name="editPayBill.state" required="required"  style="width:90px" /></td>
			</tr>            
            <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" style="empty-cells:show">
			<td id="t15" style="width:30%" align="center"><font color="#FF0000">*</font>备注				
			<td id="t16" style="width:70%">&nbsp;&nbsp;<input type="text" id="editPayBill_remark" class="easyui-validatebox"" name="editPayBill.remark" required="required"  style="width:90px" /></td>
			</tr>            
		</table>
	</form>	
</div>

<script type="text/javascript">
//修改付款单,弹出窗口
function openDivEditPayBill(id){	
//异步获取数据
	$.ajax({
		type:"post",
		url: "./demo/easyui/ajaxGetPayBillById.action",
		data: "id=" + id,
		dataType: "json",
		success: function(data){			
			if(data != "" && data != null){	
				//	赋值到form中		
				$('#editFormPayBill').form('load',data);
				
                //其他预处理
				//$("#editChip_chipNo").html(data["editChip.chipNo"]);
			}else{				
				//加载失败
				myAlert('加载失败');			
			}
		}	
	});

	$("#div_edit_PayBill").dialog({
		resizable: true,
		onClose:function(){					
			$('#editFormPayBill')[0].reset();	
						
		},
		buttons:[{
			text:'提交',
			iconCls:'icon-ok',
			handler:function(){
				//具体的update方法
				submitUpdatePayBill(this);				
			}
		},
		{
			text:'关闭',
			iconCls:'icon-cancel',
			handler:function(){
				
				$('#div_edit_PayBill').dialog('close');
			}
		}]
	});
	
	$('#div_edit_PayBill').dialog('open');
	$('#div_edit_PayBill').dialog('setTitle', '修改付款单');
	
	return false;
}

//进行修改
function submitUpdatePayBill(dialogButton){	
	if($("#editFormPayBill").form('validate')==false){
		dialogNewSugg(dialogButton, "填写的数据有误或没有填全");
		clearDialogButtonSugg();
		return;
	};
	dialogNewSugg(dialogButton, "提交中...");
	
	$.ajax({
		type:"post",
		url: "./demo/easyui/ajaxUpdatePayBill.action",
		data: $("#editFormPayBill").serialize(),
		dataType: "json",
		success: function(data){
			
			//根据返回的类型type判断是否成功,message做为提示内容			
			var type = data.type;
			
			if(type == "true"){			
				//保存成功	
				var sugg = "<font color='red'>保存成功</font>";	
				dialogNewSugg(dialogButton, sugg);		
				
				$('#div_edit_PayBill').dialog('close');
				
				submitSearch();
				
			}else{				
				//保存失败				
				var sugg = "<font color='red'>" + data.message + "</font>";
				dialogNewSugg(dialogButton, sugg);
			}
			
		}		
	});

}

</script>
