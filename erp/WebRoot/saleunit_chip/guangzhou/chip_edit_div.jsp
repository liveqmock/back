<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page contentType="text/html; charset=utf-8" %>

<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">				
<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>修改筹单</title>

<base href="<%=basePath%>">		

<s:include value="header_chip.jsp"></s:include>

<style type="text/css">
	.isVoid1{text-decoration:line-through}
	.isVoid0{}
</style>

<script type="text/javascript" language="javascript" src="./js/customer_guangzhou_user.js"></script>	 

<script type="text/javascript" language="javascript" src="./js/saleunit_new_common.js"></script>
<script type="text/javascript" language="javascript" src="./js/easyui.utils.js"></script>
<script type="text/javascript" language="javascript" src="./js/saleunit_chip_manager.js?v=1.0"></script>

<script type="text/javascript" language="javascript" src="./js/saleunit_new_unit_info.js"></script>	
<script type="text/javascript" language="javascript" src="./js/saleunit_sale.js"></script><!-- 管理销售弹出框 -->
<script type="text/javascript" language="javascript" src="./js/saleunit_contract_customer.js?v=1.2"></script><!-- 合同客户弹出框 -->

<script type="text/javascript" language="javascript">

	$(document).ready(function(){
		var parent_ = $(this);
		for(var i=1;i<=3;i++){
			if($("#unitNo"+i).val()==""){
				continue;
			}
			$("#showUnit"+i).html($("#descPropertyId"+i).val()+","+$("#areaName"+i).val()+","+$("#buildName"+i).val()+","+$("#unitNo"+i).val());
		}
		
		//initContractCustomerDataGrid("salesId", "${unit.id}", "${confirmType}", "customerId", "customer_table", "");
		new MyContractCustomerDataGrid({
			salesModuleId:"salesId", unitIdVal:"${unit.id}", confirmType:"${confirmType}",
			customerModuleId:"customerId", datagridModuleId:"customer_table", isChip:true, mainId:"${chip.id}"
		});
	});	

</script>
</head>

<body style="padding:0px;background:white;">

	<div class="gbox1">	
	
	<form action="./saleunit_chip_manager/guangzhou/modifyChip.action" method="post" id="chipFormId">
			  
		<table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" class="gbox" style="font-size:12px; line-height:26px">	
	
			  <tr bgcolor="#E9F5FF" style="empty-cells:show">
				
				<td id="t15" style="width:15%" align="right"><b>销售及客户</b>&nbsp;</td>
				<td colspan="3"></td>
			  </tr>
			  
			   <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
				<td id="t13" style="width:15%" align="right"><font color="#FF0000">*</font>销售人员&nbsp;</td>
                <td id="t14" colspan="2">				 	
				  <input type="hidden" id="chipId" name="chip.id" value="${chip.id}"/>
				  <input type="text" id="salesName" class="readonly" readonly="readonly" style="width:85%" value="${chip.salesName}"/>
				  <input type="hidden" id="salesId" name="chip.salesId" value="${chip.salesId}"/>
				  
				 </td>
				
                <td id="t16" style="width:30%">
				
				  <a href="javascript:void(0)" style="float:left; padding:0 10px 0 0" onclick="return modifySale('salesId', 'salesName', '__chip__')">
				  <font color="#5482DE">选择销售</font></a>
				 </td>						
              </tr>	 
			  
			  <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" style="empty-cells:show">
			  
			  	<td colspan="4">
					<input type="hidden" id="customerId" name="customerId" />
					<table id="customer_table" style="width:500;height:auto"></table>
				
				</td>
				
              </tr>	
				
			   <tr bgcolor="#E9F5FF" style="empty-cells:show">
				
				<td id="t15" style="width:15%" align="right"><b>认筹资料</b>&nbsp;</td>
				<td colspan="3"></td>
			  </tr>
			  
			    <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
				<td id="t13" style="width:15%" align="right"><font color="#FF0000">*</font>筹单号&nbsp;</td>
                <td id="t14">
				&nbsp;<input type="text" id="chipNo" name="chip.chipNo" value="${chip.chipNo}"/>	
				<input type="hidden" name="chip.chipType" value="${chipType}" />
				</td>		
				
                <td id="t15" style="width:15%" align="right">认筹金额&nbsp;</td>
                <td id="t16" style="width:30%">
				&nbsp;<input type="text" style="width:60%" id="chipMoney" name="chip.chipMoney" value="${chip.chipMoney}"/>
				</td>			
              </tr>	 
			  
			   <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
				<td id="t15" style="width:15%" align="right"><font color="#FF0000">*</font>意向单元1&nbsp;</td>
                <td id="t16" style="width:30%">	
                	<input type="hidden" id="descPropertyId1" value="${chip.build1.descPropertyId}"/>	
                	<input type="hidden" id="areaName1" value="${chip.build1.areaName}"/>	
                	<input type="hidden" id="buildName1" value="${chip.build1.buildName}"/>		
                	<input type="hidden" id="unitNo1" value="${chip.unit1.unitNo}"/>	 
					<input type="hidden" id="unit_id1" name="chip.unitId1" value="${chip.unitId1}"/>
					<input type="hidden" id="build_id1" name="chip.buildId1" value="${chip.buildId1}"/>
					<input type="hidden" id="area_id1" name="chip.areaId1" value="${chip.areaId1}"/>
					<span id="showUnit1" style="color:#FF0000"></span>
					<a href="javascript:void(0)" style="color:#1199FF; text-decoration:underline;" onclick="return changeUnit(1, ${typeId},'${type}')">选择单元</a>
				 </td>
				<td id="t15" style="width:15%" align="right" colspan="2"></td>
              </tr>		
			  
			   <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
				<td id="t15" style="width:15%" align="right">意向单元2&nbsp;</td>
                <td id="t16" style="width:30%">				 
                	<input type="hidden" id="descPropertyId2" value="${chip.build2.descPropertyId}"/>	
                	<input type="hidden" id="areaName2" value="${chip.build2.areaName}"/>	
                	<input type="hidden" id="buildName2" value="${chip.build2.buildName}"/>		
                	<input type="hidden" id="unitNo2" value="${chip.unit2.unitNo}"/>
					<input type="hidden" id="unit_id2" name="chip.unitId2" value="${chip.unitId2}"/>
					<input type="hidden" id="build_id2" name="chip.buildId2" value="${chip.buildId2}"/>
					<input type="hidden" id="area_id2" name="chip.areaId2" value="${chip.areaId2}"/>
					<span id="showUnit2" style="color:#FF0000"></span>
					<a href="javascript:void(0)" style="color:#1199FF; text-decoration:underline;" onclick="return changeUnit(2, ${typeId},'${type}')">选择单元</a>	
				 </td>
				<td id="t15" style="width:15%" align="right" colspan="2"></td>
              </tr>		
			  
			   <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
				<td id="t15" style="width:15%" align="right">意向单元3&nbsp;</td>
                <td id="t16" style="width:30%">				 
               		<input type="hidden" id="descPropertyId3" value="${chip.build3.descPropertyId}"/>	
                	<input type="hidden" id="areaName3" value="${chip.build3.areaName}"/>	
                	<input type="hidden" id="buildName3" value="${chip.build3.buildName}"/>		
                	<input type="hidden" id="unitNo3" value="${chip.unit3.unitNo}"/>
					<input type="hidden" id="unit_id3" name="chip.unitId3" value="${chip.unitId3}"/>
					<input type="hidden" id="build_id3" name="chip.buildId3" value="${chip.buildId3}"/>
					<input type="hidden" id="area_id3" name="chip.areaId3" value="${chip.areaId3}"/>
					<span id="showUnit3" style="color:#FF0000"></span>
					<a href="javascript:void(0)" style="color:#1199FF; text-decoration:underline;" onclick="return changeUnit(3, ${typeId},'${type}')">选择单元</a>
				 </td>
				<td id="t15" style="width:15%" align="right" colspan="2"></td>
              </tr>	
			  
			   
			  							  
			</table>
		</form>	
	</div>

	<div id="myIframeDialog" class="easyui-dialog" closed="true" modal="true" title="标题" style="display:block;width:400px;height:300px; overflow-x:hidden">
    	<iframe scrolling="auto" id='openIframe' frameborder="0"  src="./saleunit_new/guangzhou/loading.jsp" style="width:100%;height:100%;"></iframe>
	</div>
</body>

</html>



