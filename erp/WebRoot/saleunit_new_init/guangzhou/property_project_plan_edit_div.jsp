<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page contentType="text/html; charset=utf-8" %>

<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<base href="<%=basePath%>">				

<div id="editChipDiv" class="easyui-dialog" closed="true" modal="true" title="修改计划" style="width:450px;height:350px;">
	
	<form id="editChipForm">
		<table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" class="gbox" style="font-size:12px; line-height:26px">			
			<tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" style="empty-cells:show">
			<td id="t15" style="width:30%" align="center"><font color="#FF0000">*</font>筹单号
				<input type="hidden" id="editChip_id" name="editChip.id"/></td>
			<td id="t16" style="width:70%">&nbsp;&nbsp;<span type="text" id="editChip_chipNo" name="editChip.chipNo" /></td>
			</tr>
		  <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" style="empty-cells:show">
			<td id="t15" style="width:30%" align="center"><font color="#FF0000">*</font>姓名</td>
			<td id="t16" style="width:70%">&nbsp;&nbsp;<input type="text" id="chipCustomerName" name="editChip.customer.customerName"/>
			<input type="hidden" id="chipCustomerId" name="chipCustomer.id" value="0"/>	
			</td>
			</tr>
			
			 <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" style="empty-cells:show">
			<td id="t15" style="width:30%" align="center"><font color="#FF0000">*</font>电话号码</td>
			<td id="t16" style="width:70%">&nbsp;&nbsp;<input type="text" id="chipCustomerPhone" name="editChip.customer.phone"/></td>
			</tr>

			
			 <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" style="empty-cells:show">
			<td id="t15" style="width:30%" align="center">证件号码</td>
			<td id="t16" style="width:70%">&nbsp;&nbsp;<input type="text" id="chipCustomerIdcardNo" name="editChip.customer.idcardNo"/></td>
			</tr>
			
			 <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" style="empty-cells:show">
			<td id="t15" style="width:30%" align="center">通信地址</td>
			<td id="t16" style="width:70%">&nbsp;&nbsp;<input type="text" id="chipCustomerAddress" style="width: 85%;" name="editChip.customer.address"/></td>
			</tr>
			
			 <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" style="empty-cells:show">
			<td id="t15" style="width:30%" align="center"><font color="#FF0000">*</font>意向单元1</td>
			<td id="t16" style="width:70%">&nbsp;&nbsp;
				<input type="hidden" id="hiddenBuildId" />
				<input type="hidden" id="editChip_unitId1" name="editChip.unitId1"/>
				<span id="editChip_unit1_allName" style="color:#FF0000"></span>
				<a href="javascript:void(0)" style="color:#1199FF; text-decoration:underline;" onclick="return editChipChangeUnit(1)">选择单元</a>
			</td>
			</tr>
			
			 <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" style="empty-cells:show">
			<td id="t15" style="width:30%" align="center">意向单元2</td>
			<td id="t16" style="width:70%">&nbsp;&nbsp;
				<input type="hidden" id="editChip_unitId2" name="editChip.unitId2"/>
				<span id="editChip_unit2_allName" style="color:#FF0000"></span>
				<a href="javascript:void(0)" style="color:#1199FF; text-decoration:underline;" onclick="return editChipChangeUnit(2)">选择单元</a>
			</td>
			</tr>
			
			 <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" style="empty-cells:show">
			<td id="t15" style="width:30%" align="center">意向单元3</td>
			<td id="t16" style="width:70%">&nbsp;&nbsp;
				<input type="hidden" id="editChip_unitId3" name="editChip.unitId3"/>
				<span id="editChip_unit3_allName" style="color:#FF0000"></span>
				<a href="javascript:void(0)" style="color:#1199FF; text-decoration:underline;" onclick="return editChipChangeUnit(3)">选择单元</a>
			</td>
			</tr>			
		</table>
	</form>	
</div>

<script type="text/javascript">

// 注册js脚本的命名空间
Namespace.register("erp.saleunit.propertyprojectplan");
//修改认筹,弹出窗口
erp.saleunit.propertyprojectplan.openEditDiv = function(id){	
//异步获取数据
	$.ajax({
		type:"post",
		url: "./saleunit_chip_manager/guangzhou/ajaxGetChipById.action",
		data: "id=" + id,
		dataType: "json",
		success: function(data){			
			if(data != "" && data != null){
				//alert(data["editChip.chipNo"]);		
				//	赋值到form中		
				$('#editChipForm').form('load',data);
				//var jsonobj=eval('('+data+')');		
				//alert($("#editChip.unit3.allName"));
				
				$("#editChip_chipNo").html(data["editChip.chipNo"]);
				$("#editChip_unit1_allName").html(data["editChip.unit1.allName"]);
				$("#editChip_unit2_allName").html(data["editChip.unit2.allName"]);
				$("#editChip_unit3_allName").html(data["editChip.unit3.allName"]);
				
				$("#hiddenBuildId").attr("value", data["editChip.buildId"]);//设置第一意向的buildId
			}else{				
				//加载失败
				alert('加载失败');			
				//dialogNewSugg(dialogButton, "<font color='red'>保存失败,请重试</font>");
			}
		}	
	});

	$("#editChipDiv").dialog({
		resizable: true,
		onClose:function(){		
			//还原表单及显示
			
			$('#editChipForm')[0].reset();	
			
			$("#editChip_unit1_allName").html("");
			$("#editChip_unit2_allName").html("");
			$("#editChip_unit3_allName").html("");
						
		},
		buttons:[{
			text:'提交',
			iconCls:'icon-ok',
			handler:function(){
				//具体的update方法
				erp.saleunit.propertyprojectplan.submitUpdateChipDiv(this);				
			}
		},
		{
			text:'关闭',
			iconCls:'icon-cancel',
			handler:function(){
				
				$('#editChipDiv').dialog('close');
			}
		}]
	});
	
	$('#editChipDiv').dialog('open');
	$('#editChipDiv').dialog('setTitle', '修改计划');
	
	return false;
}

//进行修改认筹
erp.saleunit.propertyprojectplan.submitUpdateChipDiv = function (dialogButton){		
	//dialogNewSugg(dialogButton, "提交中...");	
	$.ajax({
		type:"post",
		url: "./saleunit_chip_manager/guangzhou/updateChip.action",
		data: $("#editChipForm").serialize(),
		dataType: "json",
		success: function(data){
			
			//根据返回的类型type判断是否成功,message做为提示内容			
			var type = data.type;
			
			if(type == "true"){			
				//保存成功	
				var sugg = "<font color='red'>保存成功</font>";	
				dialogNewSugg(dialogButton, sugg);		
				
				$('#editChipDiv').dialog('close');
				
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


