<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html>
<head>
	
	<title>合同</title>

	<s:include value="../../customer/guangzhou/header_min.jsp"></s:include>	  
	
	<script type="text/javascript" language="javascript" src="./js/customer_guangzhou_project.js"></script>
	<script type="text/javascript" language="javascript" src="<%=basePath%>js/customer_guangzhou_user.js"></script>	 
	
	<script type="text/javascript" language="javascript" src="<%=basePath%>js/jquery.easyui.min.js"></script>
	<script type="text/javascript" language="javascript" src="<%=basePath%>css/local/easyui-lang-zh_CN.js"></script>
	<link href="./css/easyui.css" rel="stylesheet" type="text/css" charset="utf-8"/>
	<link href="./css/icon.css" rel="stylesheet" type="text/css" charset="utf-8"/>
	
	<script type="text/javascript" language="javascript" src="<%=basePath%>js/saleunit_new_unit_info.js?v=2"></script>
	<script type="text/javascript" language="javascript" src="./js/saleunit_sale.js"></script><!-- 管理销售弹出框 -->
	<script type="text/javascript" language="javascript" src="./js/saleunit_new_discount.js"></script>
	
	<script type="text/javascript" language="javascript" src="./js/saleunit_new_common.js"></script>
	<script type="text/javascript" language="javascript" src="./js/easyui.utils.js"></script>
	<script type="text/javascript" language="javascript" src="./js/saleunit_new_common_min.js"></script>
	
	<script type="text/javascript" language="javascript">
		$().ready(function(){
		
			closeIframeDialog("myIframeDialog", "${closeMark}", "", "${suggestion}");
			
			baseAutoComplete("customerName", "customerHiddenId", "./saleunit_new/appoint/guangzhou/searchCustomersForContract.action", "");
			baseAutoComplete("customerPhone", "customerHiddenId", "./saleunit_new/appoint/guangzhou/searchCustomersFromPhoneForContract.action", "");			
			
			$("#sumMoney").blur(function(){
			
				blurFun(this, "buildPrice", "insideUnitPrice");
			
			});
			
			$("#unitSumPriceId").blur(function(){
				
				blurFun(this, "unitBuildPriceId", "unitInsidePriceId"); 
				
			});
			
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

<form action="./saleunit_new/appoint/guangzhou/inputXiaoZhuContract.action" method="post" id="xiaoZhuContractFormId">

		 
<table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" class="gbox" style="font-size:12px; line-height:26px">	
		 	   <tr bgcolor="#E9F5FF" style="empty-cells:show">
				
				<td id="t15" style="width:15%" align="right"><b>基本资料</b>&nbsp;</td>
				<td colspan="3"><font color="#FF0000"><span id="suggestion"><s:property value="#request.session.suggestion"/></span></font></td>
			  </tr>

              <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
				<td id="t15" style="width:15%" align="right"><font color="#FF0000">*</font>客户名称&nbsp;</td>
                <td id="t16" style="width:30%">				 				 
				  <a href="javascript:void(0)" style="float:right; padding:0 0 0 10px" onclick="return createContractCustomer(${confirmType})"><font color="#5482DE">新建</font></a>
				  <a href="javascript:void(0)" style="float:right;" onclick="return searchContractCustomer()"><font color="#5482DE">查找</font></a>

				
				<!-- 
				 <span id="showContractCustomerName"></span>
				 <input type='hidden' id='showContractCustomerId' name="contract.customerId"/>
				 -->
				 
				 <a href="javascript:void(0)" onclick="return showContractCustomer();" id="showContractCustomerName"><font class="fontblue">${confirmCustomer.customerName}</font></a>
				 <span id="showNewCreateContractCustomerName"></span>
				<input type='hidden' id='showContractCustomerId'  name="contract.customerId" value="${confirmCustomer.id}"/>				 </td>
				<td id="t15" style="width:15%" align="right"><font color="#FF0000">*</font>联系电话&nbsp;</td>
                <td id="t16" style="width:30%">
			 	
				 <input type="text" id="phone" name="contract.phone" class="leftcreateinputbox01" value="${confirmCustomer.phone}"/>				</td>
              </tr>		
			  
			  <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
				
				<td id="t15" style="width:15%" align="right"><font color="#FF0000">*</font>房间&nbsp;</td>
				<td>
				  ${selectUnit.allName}
				  <input type="hidden" id="hiddenUnitId" name="contract.unitId" value="${selectUnit.id}"/>
				  <input type="hidden" id="hiddenPropertyProjectId" name="contract.propertyProjectId" value="${selectUnit.propertyProjectId}"/>
				 </td>
				 
				 <td id="t15" style="width:15%" align="right">产品类型&nbsp;</td>
                <td id="t16" style="width:30%">${selectUnit.productTypeStr}</td>
			  </tr>
			  
			   <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
				<td id="t13" style="width:15%" align="right">房间结构&nbsp;</td>
                <td id="t14">
					${selectUnit.roomNum}房 ${selectUnit.hallNum}厅 ${selectUnit.toiletNum}卫			</td>		
                 <td id="t15" style="width:15%" align="right">销售状态&nbsp;</td>
                <td id="t16" style="width:30%">
					${selectUnit.saleStateStr}				</td>			
              </tr>	 
			  
			  <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
				<td id="t13" style="width:15%" align="right">建筑面积&nbsp;</td>
                <td id="t14">				
				 <input type="text" id="hiddenBuildAreaId" name="selectUnit.buildArea" value="${selectUnit.buildArea}" class="money"/>
				</td>		
                <td id="t15" style="width:15%" align="right">套内面积&nbsp;</td>
                <td id="t16" style="width:30%">
				 <input type="text" id="hiddenInsideAreaId" name="selectUnit.insideArea" value="${selectUnit.insideArea}" class="money"/>
				</td>			
              </tr>	 
			  
			   <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
				<td id="t13" style="width:15%" align="right">建筑单价&nbsp;</td>
                <td id="t14">
				<!--
				 <input type="text" id="unitBuildPriceId" name="selectUnit.buildPrice" value="${selectUnit.buildPrice}" class="money"/>
				 -->
				 <input type="text" id="unitBuildPriceId" name="selectUnit.buildPrice" value="${selectUnit.buildPrice}" class="money readonly" readonly="readonly"/>
				 元
				</td>		
                <td id="t15" style="width:15%" align="right">套内单价&nbsp;</td>
                <td id="t16" style="width:30%">
				<!--
				  <input type="text" id="unitInsidePriceId" name="selectUnit.insidePrice" value="${selectUnit.insidePrice}" class="money"/>
				  -->
				   <input type="text" id="unitInsidePriceId" name="selectUnit.insidePrice" value="${selectUnit.insidePrice}" class="money readonly" readonly="readonly"/>
				  元
				</td>			
              </tr>	 
			 
			  
			   <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
				<td id="t13" style="width:15%" align="right">&nbsp;</td>
                <td id="t14">		
				</td>		
                <td id="t15" style="width:15%" align="right">标准总价&nbsp;</td>
                <td id="t16" style="width:30%">
				 <input type="text" id="unitSumPriceId" name="selectUnit.sumPrice" value="${selectUnit.sumPrice}" class="money"/>
				 元
				</td>			
              </tr>	 
			  
			    <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
				<td id="t13" style="width:15%" align="right"><font color="#FF0000">*</font>付款方式&nbsp;</td>
                <td id="t14">
				 	<s:select list="selPayType"  name="contract.payWayId" cssStyle="width:auto" id="payWayId" value="#request.confirm.payWayId"/>
				</td>		
                <td id="t15" style="width:15%" align="right">计价方式&nbsp;</td>
                <td id="t16" style="width:30%">
				<!--
					<s:select list="selPriceWay"  name="contract.priceWay" cssStyle="width:auto" id="priceWay" value="#request.priceWay" />	
				-->
					<s:select list="selPriceWay"  name="contract.priceWay" cssStyle="width:auto" id="priceWay" value="#request.selectUnit.priceWay" />					
				</td>			
              </tr>	 
			  
			   <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
				<td id="t13" style="width:15%" align="right">折扣(%)&nbsp;<input type="hidden" id="discountPercent" name="contract.discountPercent"/></td>
                <td id="t14">
				<!--
					<input type="text" id="discountPercent" name="contract.discountPercent" class="leftcreateinputbox01"  style="width:30%"/>
					-->
					<!--
					<a href="#" id="addDiscountId" style="float:left;" onclick="return createDiscountDialog(${selectUnit.id}, '', '')"><font color="#5482DE">新增折扣</font></a>
					<input type="hidden" id="checkUnitDiscountId"/>
					-->
					<!--
					<a href="#" id="addDiscountId" style="float:left;" 
						onclick="return createUnitDiscountDialog('payWayId', '${selectUnit.id}', '', '${confirmType}')"><font color="#5482DE">新增折扣</font></a>
					-->
					
					<a href="#" id="modifyDiscountId" style="float:left;" 
						onclick="return createProjectDiscountDialog('${selectUnit.id}', '', '${confirmType}')"><font color="#5482DE">新增折扣</font></a>	
					
				</td>	
				
				<td id="t15" style="width:15%" align="right">折扣说明&nbsp;</td>
                <td id="t16" style="width:30%">
				 <input type="text" id="discountDesc" name="contract.discountDesc" class="leftcreateinputbox01"/>				 </td>						
              </tr>	 
			  
			   <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
				<td id="t13" style="width:15%" align="right"><font color="#FF0000">*</font>建筑成交单价&nbsp;</td>
                <td id="t14">
				 <input type="text" id="buildPrice" name="contract.buildPrice" class="money readonly" readonly="readonly"/>
				 元				</td>	
				
				<td id="t15" style="width:15%" align="right"><font color="#FF0000">*</font>套内成交单价&nbsp;</td>
                <td id="t16" style="width:30%">
				 <input type="text" id="insideUnitPrice" name="contract.insideUnitPrice" class="money readonly" readonly="readonly"/>
				 元							 </td>						
              </tr>	 
			  
			   <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
				   <td id="t13" style="width:15%" align="right">是否一二手联动&nbsp;</td>
                <td id="t14">
				<s:select list="selIsMerge" name="contract.isSecondLinkage" cssStyle="width:auto" id="isSecondLinkage"/>
				
				<s:token />
				<input type="hidden" id="baseUrl" value="<%=basePath%>"/>
			   <input type="hidden" id="confirmType" value="${confirmType}" />
			   <input type="hidden" id="unitDiscountId" name="unitDiscountId"/>
				</td>		
                <td id="t15" style="width:15%" align="right"><font color="#FF0000">*</font>成交总价&nbsp;</td>
                <td id="t16" style="width:30%">
					 <input type="text" id="sumMoney" name="contract.sumMoney" class="money"/>
				 元</td>			
              </tr>	 
			  
			  <!--
			  
  			  <tr bgcolor="#E9F5FF" style="empty-cells:show">
				
				<td id="t15" style="width:15%" align="right"><b>装修选择</b>&nbsp;</td>
				<td colspan="3"></td>
			  </tr>
			  
			  <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
				<td id="t15" style="width:15%" align="right">装修标准&nbsp;</td>
                <td id="t16" style="width:30%">				
				 <input type="text" id="renovateDesc" name="contract.renovateDesc" class="leftcreateinputbox01" value="${selectUnit.renovateDesc}"/>				</td>
                 <td id="t13" style="width:15%" align="right">装修单价&nbsp;</td>
                <td id="t14">
				 <input type="text" id="renovatePrice" name="contract.renovatePrice" class="money" value="${selectUnit.renovatePrice}"/>
				元				</td>				
              </tr>	
			  
			    <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
				<td id="t15" style="width:15%" align="right">是否并入合同&nbsp;</td>
                <td id="t16" style="width:30%">
					<s:select list="selIsMerge" name="contract.isMerge" cssStyle="width:auto" id="isMerge"/>				 </td>
                 <td id="t13" style="width:15%" align="right">装修总价&nbsp;</td>
                <td id="t14">
				 <input type="text" id="renovateMoney" name="contract.renovateMoney" class="money" value="${selectUnit.renovateMoney}"/>
				元				</td>				
              </tr>	
			  
			  <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
				<td id="t15" style="width:15%" align="right">个性装修约定交楼日期&nbsp;</td>
                <td id="t16" style="width:30%">
					 <input class="Wdate" type="text" id="finishDate" style="width:90px" name="contract.finishDate" />				 </td>
                 <td id="t13" style="width:15%" align="right"></td>
                <td id="t14"></td>				
              </tr>	
			  
			  -->
			  
			  <tr bgcolor="#E9F5FF" style="empty-cells:show">
				
				<td id="t15" style="width:15%" align="right"><b>摘要</b>&nbsp;</td>
				<td colspan="3"></td>
			  </tr>
			  
			   <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
				<td id="t15" style="width:15%" align="right"><font color="#FF0000">*</font>合同编号&nbsp;</td>
                <td id="t16" style="width:30%">
				 <input type="text" id="contractNo" name="contract.contractNo" class="leftcreateinputbox01"/>				 </td>
                 <td id="t13" style="width:15%" align="right"><font color="#FF0000">*</font>签合同日期&nbsp;</td>
                <td id="t14"><input class="Wdate" type="text" id="signDate" style="width:90px" name="contract.signDate" value="${nowDate}"/></td>				
              </tr>	
			 
			  <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
				<td id="t13" style="width:15%" align="right"><font color="#FF0000">*</font>销售人员&nbsp;</td>
                <td id="t14" colspan="2">				 	
						
				  <input type="text" id="salesName" class="readonly" readonly="readonly" style="width:85%"/>
				  <input type="hidden" id="hiddenSalesId" name="contract.salesId"/>
				 </td>
				
                <td id="t16" style="width:30%">
				
				  <a href="javascript:void(0)" style="float:left; padding:0 10px 0 0" onclick="return modifySale('hiddenSalesId', 'salesName', '__appoint__')">
				  <font color="#5482DE">选择销售</font></a>
				 </td>						
              </tr>	 
			  
			  <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
				<td id="t15" style="width:15%" align="right">应收定金&nbsp;</td>
                <td id="t16" style="width:30%">
				   <input type="text" id="shouldDeposit" name="contract.shouldDeposit" class="money"/>
				 元						     </td>
                 <td id="t13" style="width:15%" align="right">业务归属日期&nbsp;</td>
                <td id="t14">
				 <input class="Wdate" type="text" id="workDate" style="width:90px" name="contract.workDate" value="${nowDate}"/>				</td>				
              </tr>	
			  
			  <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
				<td id="t15" style="width:15%" align="right">约定交房日期&nbsp;</td>
                <td id="t16" style="width:30%">
				    <input class="Wdate" type="text" id="deliveryDate" style="width:90px" name="contract.deliveryDate" />			    </td>
                 <td id="t13" style="width:15%" align="right">实际交房日期&nbsp;</td>
                <td id="t14">
				 <input type="text" id="realHouseDate" name="contract.realHouseDate" class="Wdate" style="width:90px" />				</td>				
              </tr>	
			  
			  <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
				<td id="t15" style="width:15%" align="right">延期收楼日期&nbsp;</td>
                <td id="t16" style="width:30%">
				 	 <input class="Wdate" type="text" id="delayDate" style="width:90px" name="contract.delayDate" />			    </td>
                 <td id="t13" style="width:15%" align="right">&nbsp;</td>
                <td id="t14"></td>				
              </tr>	
			  
			  <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
				<td id="t15" style="width:15%" align="right">合同备案号&nbsp;</td>
                <td id="t16" style="width:30%">
				     <input type="text" id="recordNo" name="contract.recordNo" class="leftcreateinputbox01"/>			    </td>
                 <td id="t13" style="width:15%" align="right">备案日期&nbsp;</td>
                <td id="t14">
				    <input class="Wdate" type="text" id="recordDate" style="width:90px" name="contract.recordDate" />				</td>				
              </tr>	
			  
			   <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
				<td id="t15" style="width:15%" align="right">推荐人&nbsp;</td>
                <td id="t16" style="width:30%">
				    <input type="text" id="recommendMan" name="contract.recommendMan" class="leftcreateinputbox01"/>			    </td>
                 <td id="t13" style="width:15%" align="right"></td>
                <td id="t14"></td>				
              </tr>	
			  
			 
			 <!-- 
			   <tr bgcolor="#E9F5FF" style="empty-cells:show">
				
				<td id="t15" style="width:15%" align="right"><b>贷款信息</b>&nbsp;</td>
				<td colspan="3"></td>
			  </tr>
			  
			  <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
				<td id="t15" style="width:15%" align="right">按揭银行&nbsp;</td>
                <td id="t16" style="width:30%">
				    <input type="text" id="contract.mortgageBank" name="contract.mortgageBank" class="leftcreateinputbox01"/>				 </td>
                 <td id="t13" style="width:15%" align="right">按揭贷款&nbsp;</td>
                <td id="t14">
					<input type="text" id="contract.mortgageMoney" name="contract.mortgageMoney" class="money"/>
					元				</td>				
              </tr>	
			  
			  <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
				<td id="t15" style="width:15%" align="right"></td>
                <td id="t16" style="width:30%"></td>
                 <td id="t13" style="width:15%" align="right">按揭年限&nbsp;</td>
                <td id="t14">
				<input type="text" id="mortgageYear" name="contract.mortgageYear" class="money"/>				</td>				
              </tr>	
			  
			  <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
				<td id="t15" style="width:15%" align="right">公积金银行&nbsp;</td>
                <td id="t16" style="width:30%">
				    <input type="text" id="fundBank" name="contract.fundBank" class="leftcreateinputbox01"/>				</td>
                 <td id="t13" style="width:15%" align="right">公积金贷款&nbsp;</td>
                <td id="t14">
				 <input type="text" id="fundMoney" name="contract.fundMoney" class="money"/>
				 元				 </td>				
              </tr>	
			  
			  <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
				<td id="t15" style="width:15%" align="right"></td>
                <td id="t16" style="width:30%">
				
			   </td>
                 <td id="t13" style="width:15%" align="right">公积金年限&nbsp;</td>
                <td id="t14">
				<input type="text" id="fundYear" name="contract.fundYear" class="money"/>				</td>				
              </tr>	
			  
			  -->
			  
			</table>

</form>	
	
</div>

<div id="contractCustomerDiv" class="easyui-dialog" closed="true" modal="true" title="新建签约客户" style="width:450px;height:250px;">

	<table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" class="gbox" style="font-size:12px; line-height:26px">			

	  <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" style="empty-cells:show">
		<td id="t15" style="width:30%" align="center"><font color="#FF0000">*</font>姓名</td>
		<td id="t16" style="width:70%">&nbsp;&nbsp;<input type="text" id="contractCustomerName"/></td>
		</tr>
		
		 <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" style="empty-cells:show">
		<td id="t15" style="width:30%" align="center"><font color="#FF0000">*</font>电话号码</td>
		<td id="t16" style="width:70%">&nbsp;&nbsp;<input type="text" id="contractCustomerPhone"/></td>
		</tr>
		
		 <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" style="empty-cells:show">
		<td id="t15" style="width:30%" align="center">性别</td>
		<td id="t16" style="width:70%">&nbsp;&nbsp;<s:select list="selCustomerGender" cssStyle="width:auto" id="contractCustomerGender"/></td>
		</tr>
		
		 <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" style="empty-cells:show">
		<td id="t15" style="width:30%" align="center">证件类型</td>
		<td id="t16" style="width:70%">&nbsp;&nbsp;<s:select list="selCustomerIdCardType" cssStyle="width:auto" id="contractCustomerIdcardType"/></td>
		</tr>
		
		 <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" style="empty-cells:show">
		<td id="t15" style="width:30%" align="center">证件号码</td>
		<td id="t16" style="width:70%">&nbsp;&nbsp;<input type="text" id="contractCustomerIdcardNo"/></td>
		</tr>
		
		 <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" style="empty-cells:show">
		<td id="t15" style="width:30%" align="center">通信地址</td>
		<td id="t16" style="width:70%">&nbsp;&nbsp;<input type="text" id="contractCustomerAddress" style="width: 85%;"/></td>
		</tr>
		<!--		
		 <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" style="empty-cells:show">
			<td id="t15" colspan="2" align="center">
				<input type="button" value="  保存  " id="contractCustomerForDialog" onclick="saveContractCustomerForDialog(${confirmType})"/>
				<span id='suggId'></span>
			</td>
		</tr>
		-->
	</table>
	
</div>

<div id="contractCustomerShowDiv" class="easyui-dialog" closed="true" modal="true" title="查看签约客户" style="width:450px;height:250px;">

	<table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" class="gbox" style="font-size:12px; line-height:26px">			

	  <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" style="empty-cells:show">
		<td id="t15" style="width:30%" align="center"><font color="#FF0000">*</font>姓名</td>
		<td id="t16" style="width:70%">&nbsp;&nbsp;${confirmCustomer.customerName}</td>
		</tr>
		
		 <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" style="empty-cells:show">
		<td id="t15" style="width:30%" align="center"><font color="#FF0000">*</font>电话号码</td>
		<td id="t16" style="width:70%">&nbsp;&nbsp;${confirmCustomer.phone}</td>
		</tr>
		
		 <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" style="empty-cells:show">
		<td id="t15" style="width:30%" align="center">性别</td>
		<td id="t16" style="width:70%">&nbsp;&nbsp;${confirmCustomer.genderStr}</td>
		</tr>
		
		 <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" style="empty-cells:show">
		<td id="t15" style="width:30%" align="center">证件类型</td>
		<td id="t16" style="width:70%">&nbsp;&nbsp;${confirmCustomer.idcardTypeStr}</td>
		</tr>
		
		 <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" style="empty-cells:show">
		<td id="t15" style="width:30%" align="center">证件号码</td>
		<td id="t16" style="width:70%">&nbsp;&nbsp;${confirmCustomer.idcardNo}</td>
		</tr>
		
		 <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" style="empty-cells:show">
		<td id="t15" style="width:30%" align="center">通信地址</td>
		<td id="t16" style="width:70%">&nbsp;&nbsp;${confirmCustomer.address}</td>
		</tr>
		
	</table>
	
</div>

<div id="discountManagerDialog" class="easyui-dialog" closed="true" modal="true" title="折扣管理">
	<iframe scrolling="auto" frameborder="0"  style="width:580px;height:100%;" id="discountManagerIframe"></iframe>	
</div>

<div id="myIframeDialog" class="easyui-dialog" closed="true" modal="true" title="">
	<iframe scrolling="auto" frameborder="0"  style="width:100%;height:100%;" id="openIframe" src="./saleunit_new/guangzhou/loading.jsp"></iframe>	
</div>

<div id="searchContractCustomerDiv" class="easyui-dialog" closed="true" modal="true" title="查找客户" style="width:375px;height:180px;">

	<table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" class="gbox" style="font-size:12px; line-height:26px">			

	  <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" style="empty-cells:show">
		<td id="t15" style="width:30%" align="center">姓名</td>
		<td id="t16" style="width:70%">&nbsp;&nbsp;
		   <input type="text" id="customerName"/>
		   <input type="hidden" id="customerHiddenId"/>
		</td>
		</tr>
		
		<tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" style="empty-cells:show">
		<td id="t15" style="width:30%" align="center">电话</td>
		<td id="t16" style="width:70%">&nbsp;&nbsp;
		   <input type="text" id="customerPhone"/>
		</td>
		</tr>
		
	</table>
</div>

</body>
</html>