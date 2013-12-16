<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html>
<head>
	
	<title>成交</title>

	<s:include value="../../customer/guangzhou/header_min.jsp"></s:include>	  
	
	<script type="text/javascript" language="javascript" src="./js/customer_guangzhou_project.js"></script>
	<script type="text/javascript" language="javascript" src="<%=basePath%>js/customer_guangzhou_user.js"></script>	 
		
	<script type="text/javascript" language="javascript" src="<%=basePath%>js/jquery.easyui.min.js"></script>
	<script type="text/javascript" language="javascript" src="<%=basePath%>css/local/easyui-lang-zh_CN.js"></script>
	<link href="./css/easyui.css" rel="stylesheet" type="text/css" charset="utf-8"/>
	<link href="./css/icon.css" rel="stylesheet" type="text/css" charset="utf-8"/>
	
	<script type="text/javascript" language="javascript" src="<%=basePath%>js/saleunit_new_unit_info.js"></script>
	<script type="text/javascript" language="javascript" src="./js/saleunit_sale.js"></script><!-- 管理销售弹出框 -->
	<script type="text/javascript" language="javascript" src="./js/saleunit_contract_customer.js"></script><!-- 合同客户弹出框 -->
	<script type="text/javascript" language="javascript" src="./js/saleunit_new_discount.js"></script>
	
	<script type="text/javascript" language="javascript" src="./js/saleunit_new_common.js"></script>
	<script type="text/javascript" language="javascript" src="./js/easyui.utils.js"></script>
	<script type="text/javascript" language="javascript" src="./js/saleunit_new_common_min.js"></script>
	
	<script type="text/javascript" language="javascript">
		$().ready(function(){
		
			closeIframeDialog("myIframeDialog", "${closeMark}", "", "${suggestion}");
			
			//baseAutoComplete("customerName", "customerHiddenId", "./saleunit_new/appoint/guangzhou/searchCustomersForContract.action", "");
			//baseAutoComplete("customerPhone", "customerHiddenId", "./saleunit_new/appoint/guangzhou/searchCustomersFromPhoneForContract.action", "");	
			
			$("#sumMoney").blur(function(){
			
				blurFun(this, "buildPrice", "insideUnitPrice");
			
			});
			
			$("#unitSumPriceId").blur(function(){
				
				blurFun(this, "unitBuildPriceId", "unitInsidePriceId"); 
				
			});			

			initOldContractCustomerDataGrid("salesId", "${unit.id}", "1", "customerId", "customer_table", "${confirm.id}");

			initOldContractCustomerDataGrid("salesId", "${unit.id}", "1", "oldCustomerId", "old_customer_table", "${confirm.id}");
		
			//modifyPoint("unitBuildPriceId");	
			//modifyPoint("unitInsidePriceId");	
			//modifyPoint("buildPrice");	
			//modifyPoint("insideUnitPrice");		  
			
		});
		
		//不可编辑,且四舍五入Math.round(12.03)
		function blurFun(thisText, buildPrice, insidePrice){
		
			var sumMoney = $(thisText).val();
			
			if(isNaN(sumMoney) || sumMoney==""){
				
				$(thisText).val("0");
				$("#" + buildPrice).val("0");
				$("#" + insidePrice).val("0");
				return;
			}
			
			var intSumMoney = 0;
			try{
				intSumMoney = parseInt(sumMoney);
			}catch(e){
				$(thisText).val("0");
				$("#" + buildPrice).val("0");
				$("#" + insidePrice).val("0");
				return;
			}
			if(intSumMoney == 0){
				$(thisText).val("0");
				$("#" + buildPrice).val("0");
				$("#" + insidePrice).val("0");
				return;					
			}
			
			var getBuildArea = $("#hiddenBuildAreaId").val();
			var getInsideArea = $("#hiddenInsideAreaId").val();
			
			if(parseInt(getBuildArea) == 0){
				$("#" + buildPrice).val("0");
			}else{
				$("#" + buildPrice).val(Math.round(intSumMoney/getBuildArea)); //四舍五入
			}
			
			if(parseInt(getInsideArea) == 0){
				$("#" + insidePrice).val("0");
			}else{
				$("#" + insidePrice).val(Math.round(intSumMoney/getInsideArea));
			}
			
		}
		
		//可以编辑小数部分
		/**
		function blurFun(thisText, buildPrice, insidePrice){

			var sumMoney = $(thisText).val();
			
			if(isNaN(sumMoney) || sumMoney==""){
				
				$(thisText).val("0.00");
				$("#" + buildPrice).val("0.00");
				$("#" + insidePrice).val("0.00");
				return;
			}
			
			var intSumMoney = 0;
			try{
				intSumMoney = parseInt(sumMoney);
			}catch(e){
				$(thisText).val("0.00");
				$("#" + buildPrice).val("0.00");
				$("#" + insidePrice).val("0.00");
				return;
			}
			if(intSumMoney == 0){
				$(thisText).val("0.00");
				$("#" + buildPrice).val("0.00");
				$("#" + insidePrice).val("0.00");
				return;					
			}
			
			var getBuildArea = $("#hiddenBuildAreaId").val();
			var getInsideArea = $("#hiddenInsideAreaId").val();
			
			if(parseInt(getBuildArea) == 0){
				$("#" + buildPrice).val("0.00");
			}else{
				$("#" + buildPrice).val((intSumMoney/getBuildArea).toFixed(2));  //保存两位
			}
			
			if(parseInt(getInsideArea) == 0){
				$("#" + insidePrice).val("0.00");
			}else{
				$("#" + insidePrice).val((intSumMoney/getInsideArea).toFixed(2));
			}			
			
		}
		*/
	</script>
	
	<style type="text/css">
		*{margin:0;padding:0;}
	</style>
	
</head>
	
<body>
<div class="gbox1">			

<form action="./saleunit/operation/submitChangeCustomerName.action" method="post" id="submitReplaceCustomerNameFormId">



		 
<table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" class="gbox" style="font-size:12px; line-height:26px">	



		 	   <tr bgcolor="#E9F5FF" style="empty-cells:show">
				
				<td id="t15" style="width:15%" align="right"><b>新销售及客户</b>&nbsp;</td>
				<td colspan="3"></td>
			  </tr>
			  
			   <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
				<td id="t13" style="width:15%" align="right"><font color="#FF0000"></font>销售人员&nbsp;</td>
                <td id="t14" colspan="2">				 	
						
				  <input type="text" id="salesName" class="readonly" readonly="readonly" style="width:85%" value="${confirm.salesName}"/>
				 <input type="hidden" id="salesId" name="confirm.salesId" value="${confirm.salesId}"/> 
				  <input type="hidden" id="customerId" name="customerId" value="${customerId}"/>
				  
				 </td>
				
                <td id="t16" style="width:30%">
				
				  
				 </td>						
              </tr>	 
			  
			  <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" style="empty-cells:show">
			  
			  	<td colspan="4">
					
					<table id="customer_table" style="width:500;height:auto"></table>
				
				</td>
				
              </tr>	
			  <tr bgcolor="#E9F5FF" style="empty-cells:show">
				
				<td id="t15" style="width:15%" align="right"><b>改名资料</b>&nbsp;</td>
				<td colspan="3"></td>
			  </tr>
			  <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			style="empty-cells:show">
			<td id="t19" style="width:15%" align="right"><font color="red"></font>批准人&nbsp;</td>
			<td id="t20" style="width:25%">
				<s:property value='customerRename.approverMan'/>
			</td>					
			<td id="t21" style="width:15%" align="right"><font color="red"></font>经办人&nbsp;</td>
			<td id="t22" style="width:25%">
				${customerRename.inputMan}</td>	
		  </tr>
		  
		  
		   <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			style="empty-cells:show">
			<td id="t27" style="width:15%" align="right"><font color="red"></font>更名时间&nbsp;</td>
			<td id="t28" style="width:25%">
				<s:date name="#request.customerRename.renameTime" format="yyyy-MM-dd"/>
			<td id="t29" style="width:15%" align="right"><font color="red"></font>备注&nbsp;</td>
			<td id="t30" style="width:25%">
				${customerRename.remark}				</td>					
		  </tr>
			  
		 <tr bgcolor="#E9F5FF" style="empty-cells:show">
				
				<td id="t15" style="width:15%" align="right"><b>原销售及客户</b>&nbsp;</td>
				<td colspan="3"></td>
			  </tr>
			  
			   <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
				<td id="t13" style="width:15%" align="right"><font color="#FF0000"></font>销售人员&nbsp;</td>
                <td id="t14" colspan="2">				 	
						
				  <input type="text" id="salesName" class="readonly" readonly="readonly" style="width:85%" value="${confirm.salesName}"/>
				 <input type="hidden" id="salesId" name="confirm.salesId" value="${confirm.salesId}"/> 
				  <input type="hidden" id="oldCustomerId" name="oldCustomerId" value="${oldCustomerId}" />
				 </td>
				
                <td id="t16" style="width:30%">
				
				  
				 </td>						
              </tr>	 
			  
			  <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" style="empty-cells:show">
			  
			  	<td colspan="4">
					
					<table id="old_customer_table" style="width:500;height:auto"></table>
				
				</td>
				
              </tr>	  
			  
			  
			</table>

</form>	
	
