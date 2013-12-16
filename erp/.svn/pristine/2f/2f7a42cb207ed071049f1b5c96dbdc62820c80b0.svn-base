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
			
			$("#sumMoney").blur(function(){
			
				blurFun(this, "buildPrice", "insideUnitPrice");
			
			});
			
			$("#unitSumPriceId").blur(function(){
				
				blurFun(this, "unitBuildPriceId", "unitInsidePriceId"); 
				
			});			
			
			//如果有实收,就为付款方式增加change监听事件
			if(${isHaveReceipt} == true){
				
				$("#payWayId").change(function(){
					
					if($("#oldPayWayId").val() != $(this).val()){
						myAlert("该单元已经有对应的实收,修改付款方式不会生成新的应收");
					}
				});
				
				$("#sumMoney").blur(function(){
					
					if(parseInt($("#oldSumMoney").val()) != parseInt($(this).val())){
						myAlert("该单元已经有对应的实收,修改成交总价不会生成新的应收");
					}					
					
				});
			}			
			
			initContractCustomerDataGrid("salesId", "${unit.id}", "${confirmType}", "customerId", "customer_table", "${confirm.id}");
			
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
		
	</script>
	
	<style type="text/css">
		*{margin:0;padding:0;}
	</style>
	
</head>
	
<body>
<div class="gbox1">			

<form action="./saleunit_new/appoint/guangzhou/updateEasyUIConfirm.action" method="post" id="easyUIConfirmFormId">

		 
<table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" class="gbox" style="font-size:12px; line-height:23px">	
		 	   <tr bgcolor="#E9F5FF" style="empty-cells:show">
				
				<td id="t15" style="width:15%" align="right"><b>销售及客户</b>&nbsp;</td>
				<td colspan="3"></td>
			  </tr>
			  
			   <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
				<td id="t13" style="width:15%" align="right"><font color="#FF0000">*</font>销售人员&nbsp;</td>
                <td id="t14" colspan="2">				 	
						
				  <input type="text" id="salesName" class="readonly" readonly="readonly" style="width:85%" value="${confirm.salesName}"/>
				 <input type="hidden" id="salesId" name="confirm.salesId" value="${confirm.salesId}"/> 
				 
				 </td>
				
                <td id="t16" style="width:30%">
				
				  <a href="javascript:void(0)" style="float:left; padding:0 10px 0 0" onclick="return modifySale('salesId', 'salesName', '__appoint__')">
				  <font color="#5482DE">选择销售</font></a>
				 </td>						
              </tr>	 
			  
			  <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" style="empty-cells:show">
			  
			  	<td colspan="4">
					 <input type="hidden" id="customerId" name="customerId" />
					<table id="customer_table"></table>
				
				</td>
				
              </tr>	
		 	   <tr bgcolor="#E9F5FF" style="empty-cells:show">
				
				<td id="t15" style="width:15%" align="right"><b>基本资料</b>&nbsp;</td>
				<td colspan="3"></td>
			  </tr>

              	
			  
			  <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
				
				<td id="t15" style="width:15%" align="right"><font color="#FF0000">*</font>房间&nbsp;</td>
				<td>
				  ${unit.allName}
				  <input type="hidden" id="hiddenUnitId" name="confirm.unitId" value="${unit.id}"/>
				  <input type="hidden" id="hiddenPropertyProjectId" name="confirm.propertyProjectId" value="${confirm.propertyProjectId}"/>
				  </td>
				 
				 <td id="t15" style="width:15%" align="right">产品类型&nbsp;</td>
                <td id="t16" style="width:30%">${unit.productTypeStr}</td>
			  </tr>
			  
			   <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
				<td id="t13" style="width:15%" align="right">房间结构&nbsp;</td>
                <td id="t14">
					${unit.roomNum}房 ${unit.hallNum}厅 ${unit.toiletNum}卫				</td>		
                <td id="t15" style="width:15%" align="right">销售状态&nbsp;</td>
                <td id="t16" style="width:30%">
					${unit.saleStateStr}				</td>			
              </tr>	 
			  
			   <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
				<td id="t13" style="width:15%" align="right">建筑面积&nbsp;</td>
                <td id="t14">
				 <input type="text" id="hiddenBuildAreaId" name="unit.buildArea" value="${unit.buildArea}" class="money"/>
				</td>		
                <td id="t15" style="width:15%" align="right">套内面积&nbsp;</td>
                <td id="t16" style="width:30%">
				 <input type="text" id="hiddenInsideAreaId" name="unit.insideArea" value="${unit.insideArea}" class="money"/>
				</td>			
              </tr>	 
			  
			   <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
				<td id="t13" style="width:15%" align="right">建筑单价&nbsp;</td>
                <td id="t14">
				 <!--
				 <input type="text" id="unitBuildPriceId" name="unit.buildPrice" value="${unit.buildPrice}" class="money"/>
				 -->
				 <input type="text" id="unitBuildPriceId" name="unit.buildPrice" value="${unit.buildPrice}" class="money readonly" readonly="readonly"/>
				 元	
				</td>		
                <td id="t15" style="width:15%" align="right">套内单价&nbsp;</td>
                <td id="t16" style="width:30%">
				 <!--
				  <input type="text" id="unitInsidePriceId" name="unit.insidePrice" value="${unit.insidePrice}" class="money"/>
				  -->
				   <input type="text" id="unitInsidePriceId" name="unit.insidePrice" value="${unit.insidePrice}" class="money readonly" readonly="readonly"/>
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
				 <input type="text" id="unitSumPriceId" name="unit.sumPrice" value="${unit.sumPrice}" class="money"/>
				 元
				</td>			
              </tr>	 
			  
			    <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
				<td id="t13" style="width:15%" align="right"><font color="#FF0000">*</font>付款方式&nbsp;</td>
                <td id="t14">
				 	<s:select list="selPayType"  name="confirm.payWayId" cssStyle="width:auto" id="payWayId" value="#request.confirm.payWayId"/>
					<input type="hidden" id="oldPayWayId" value="${confirm.payWayId}" />
				</td>		
                <td id="t15" style="width:15%" align="right">计价方式&nbsp;</td>
                <td id="t16" style="width:30%">
					<s:select list="selPriceWay"  name="confirm.priceWay" cssStyle="width:auto" id="priceWay" value="#request.confirm.priceWay" />				
				</td>			
              </tr>	 
			  
			   <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
				<td id="t13" style="width:15%" align="right">折扣(%)&nbsp;<input type="hidden" id="discountPercent" name="confirm.discountPercent" value="${confirm.discountPercent}"/></td>
                <td id="t14">				
					${confirm.discountModifyHref}					
				</td>	
				
				<td id="t15" style="width:15%" align="right">折扣说明&nbsp;</td>
                <td id="t16" style="width:30%">
				 <input type="text" id="discountDesc" name="confirm.discountDesc" class="leftcreateinputbox01" value="${confirm.discountDesc}"/>
				</td>						
              </tr>	 
			  
			   <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
				<td id="t13" style="width:15%" align="right"><font color="#FF0000">*</font>建筑成交单价&nbsp;</td>
                <td id="t14">
				 <input type="text" id="buildPrice" name="confirm.buildPrice" class="money readonly" readonly="readonly" value="${confirm.buildPrice}"/>
				 元
				 </td>	
				
				<td id="t15" style="width:15%" align="right"><font color="#FF0000">*</font>套内成交单价&nbsp;</td>
                <td id="t16" style="width:30%">
				  <input type="text" id="insideUnitPrice" name="confirm.insideUnitPrice" class="money readonly" readonly="readonly" value="${confirm.insideUnitPrice}"/>
				 元							 </td>						
              </tr>	 
			  
			   <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
				   <td id="t13" style="width:15%" align="right">&nbsp;</td>
                <td id="t14"></td>		
                <td id="t15" style="width:15%" align="right"><font color="#FF0000">*</font>成交总价&nbsp;</td>
                <td id="t16" style="width:30%">
				<input type="hidden" id="oldSumMoney" value="${confirm.sumMoney}" />
				 <input type="text" id="sumMoney" name="confirm.sumMoney" class="money" value="${confirm.sumMoney}"/>
				 元
				 </td>			
              </tr>	 
			  
			   <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
				<td id="t13" style="width:15%" align="right"><font color="#FF0000">*</font>认购书编号&nbsp;</td>
                <td id="t14">
				 <input type="text" id="agreeNo" name="confirm.agreeNo" value="${confirm.agreeNo}"/></td>	
				
				<td id="t15" style="width:15%" align="right"><font color="#FF0000">*</font>认购日期&nbsp;</td>
                <td id="t16" style="width:30%">	
				  
				  <input class="easyui-datebox" type="text" id="workDate" style="width:90px" name="confirm.workDate" 
						 value='<s:date name="#request.confirm.workDate" format="yyyy-MM-dd "/>'/>
				 </td>						
              </tr>	 			   
			  
			   <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
				<td id="t13" style="width:15%" align="right">附属产品&nbsp;</td>
                <td id="t14">
				 <input type="text" id="auxiliaryProduct" name="confirm.auxiliaryProduct" value="${confirm.auxiliaryProduct}"/>
				</td>	
				
				<td id="t15" style="width:15%" align="right">应收定金&nbsp;</td>
                <td id="t16" style="width:30%">
				   <input type="text" id="shouldDeposit" name="confirm.shouldDeposit" class="money" value="${confirm.shouldDeposit}"/>
				 元
				  
				 </td>						
              </tr>	 
			  
			    
			  
			   <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
				<td id="t15" style="width:15%" align="right"><font color="#FF0000">*</font>是否关系户&nbsp;</td>
                <td id="t16" style="width:30%">
					<s:select list="selIsMerge" name="confirm.isRelation" cssStyle="width:auto" id="isRelation"/>	
				</td>
                 <td id="t13" style="width:15%" align="right"><font color="#FF0000">*</font>是否一二手联动&nbsp;</td>
                <td id="t14">
					<s:select list="selIsMerge" name="confirm.isSecondLinkage" cssStyle="width:auto" id="isSecondLinkage"/>
				</td>				
              </tr>	
			  
			   <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
				<td id="t15" style="width:15%" align="right">备注&nbsp;</td>
                <td id="t16" colspan="3">
					<input type="text" id="remark" name="confirm.remark" value="${confirm.remark}" style="width:60%"/>
					
					 <s:token />
					<input type="hidden" id="baseUrl" value="<%=basePath%>"/>
				   <input type="hidden" id="confirmType" value="${confirmType}" />
					<input type="hidden" id="mainId" name="confirm.id"  value="${confirm.id}"/>
					
					<input type="hidden" name="confirm.companyProjectId" value="${confirm.companyProjectId}" />
					
				</td>
						
              </tr>	 
			  
			  
			</table>

</form>	
	
</div>


<div id="discountManagerDialog" class="easyui-dialog" closed="true" modal="true" title="折扣管理">
	<iframe scrolling="auto" frameborder="0"  style="width:580px;height:100%;" id="discountManagerIframe"></iframe>	
</div>

<div id="myIframeDialog" class="easyui-dialog" closed="true" modal="true" title="">
	<iframe scrolling="auto" frameborder="0"  style="width:100%;height:100%;" id="openIframe" src="./saleunit_new/guangzhou/loading.jsp"></iframe>	
</div>


</body>
</html>