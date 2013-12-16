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
	
	<link href="./css/unit_table.css"  rel="stylesheet" type="text/css" charset="utf-8"/><!-- unit的样式 -->
	
	<script type="text/javascript" language="javascript" src="./js/customer_guangzhou_project.js"></script>
	<script type="text/javascript" language="javascript" src="<%=basePath%>js/customer_guangzhou_user.js"></script>	 
	
	<script type="text/javascript" language="javascript" src="<%=basePath%>js/unit_table.js"></script>	<!-- unit table -->
	<script type="text/javascript" language="javascript" src="<%=basePath%>js/unit_infomation.js"></script>	
	
	<script type="text/javascript" language="javascript" src="<%=basePath%>js/jquery.easyui.min.js"></script>
	<script type="text/javascript" language="javascript" src="<%=basePath%>css/local/easyui-lang-zh_CN.js"></script>
	<link href="./css/easyui.css" rel="stylesheet" type="text/css" charset="utf-8"/>
	<link href="./css/icon.css" rel="stylesheet" type="text/css" charset="utf-8"/>
	
	<script type="text/javascript" language="javascript" src="<%=basePath%>js/saleunit_new_unit_info.js"></script>
	<script type="text/javascript" language="javascript" src="./js/saleunit_sale.js"></script><!-- 管理销售弹出框 -->
	<script type="text/javascript" language="javascript" src="./js/saleunit_new_discount.js"></script>
	
	<style type="text/css">
		*{margin:0;padding:0;}
	</style>
	

<div class="gbox1">			

<form action="./saleunit_new/appoint/guangzhou/inputContract.action" method="post" id="xiaoZhuContractFormId">

		 
<table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" class="gbox" style="font-size:12px; line-height:26px">	
		 	   <tr bgcolor="#E9F5FF" style="empty-cells:show">
				
				<td id="t15" style="width:15%" align="right"><b>基本资料</b>&nbsp;</td>
				<td colspan="3"><font color="#FF0000"><span id="suggestion"><s:property value="#request.session.suggestion"/></span></font></td>
			  </tr>

              <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
				<td id="t15" style="width:15%" align="right"><font color="#FF0000">*</font>客户名称&nbsp;</td>
                <td id="t16" style="width:30%">				 				 
				  <a href="#" style="float:right;" onclick="return createContractCustomer()"><font color="#5482DE">新建客户</font></a>
				
				<!-- 
				 <span id="showContractCustomerName"></span>
				 <input type='hidden' id='showContractCustomerId' name="contract.customerId"/>
				 -->
				 
				 <a href="#" onclick="return showContractCustomer();" id="showContractCustomerName"><font class="fontblue">${confirmCustomer.customerName}</font></a>
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
				  ${selectUnit.unitNo}
				  <input type="hidden" id="hiddenUnitId" name="contract.unitId" value="${selectUnit.id}"/>				 </td>
				 
				 <td id="t15" style="width:15%" align="right">房产类型&nbsp;</td>
                <td id="t16" style="width:30%">
					<s:select list="selPropertyType"  name="contract.propertyType" cssStyle="width:auto" id="propertyType"/>				</td>
			  </tr>
			  
			   <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
				<td id="t13" style="width:15%" align="right">房间结构&nbsp;</td>
                <td id="t14">
					${selectUnit.roomTypeStr}				</td>		
                <td id="t15" style="width:15%" align="right">面积状态&nbsp;</td>
                <td id="t16" style="width:30%">
					${selectUnit.areaStateStr}				</td>			
              </tr>	 
			  
			   <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
				<td id="t13" style="width:15%" align="right">建筑面积&nbsp;</td>
                <td id="t14">
				${selectUnit.buildArea}				</td>		
                <td id="t15" style="width:15%" align="right">套内面积&nbsp;</td>
                <td id="t16" style="width:30%">
				${selectUnit.insideArea}				</td>			
              </tr>	 
			  
			   <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
				<td id="t13" style="width:15%" align="right">建筑单价&nbsp;</td>
                <td id="t14">
				${selectUnit.buildPrice} 元				</td>		
                <td id="t15" style="width:15%" align="right">套内单价&nbsp;</td>
                <td id="t16" style="width:30%">
				${selectUnit.insidePrice}	元				</td>			
              </tr>	 
			 
			  
			   <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
				<td id="t13" style="width:15%" align="right">计价方式&nbsp;</td>
                <td id="t14">				
				<s:select list="selPriceWay"  name="contract.priceWay" cssStyle="width:auto" id="priceWay"
				value="#request.unit.priceWay" />				</td>		
                <td id="t15" style="width:15%" align="right">标准总价&nbsp;</td>
                <td id="t16" style="width:30%">
				${selectUnit.sumPrice} 元				 </td>			
              </tr>	 
			  
			    <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
				<td id="t13" style="width:15%" align="right"><font color="#FF0000">*</font>付款方式&nbsp;</td>
                <td id="t14">
				 	<s:select list="selPayType"  name="contract.payWayId" cssStyle="width:auto" id="payWayId" />
				</td>		
                <td id="t15" style="width:15%" align="right"><font color="#FF0000">*</font>折扣(%)&nbsp;</td>
                <td id="t16" style="width:30%">
					<!--
					<input type="text" id="discountPercent" name="contract.discountPercent" class="leftcreateinputbox01"  style="width:30%"/>
					-->
					<a href="#" id="addDiscountId" style="float:left;" onclick="return createDiscountDialog(${selectUnit.id}, '', '')"><font color="#5482DE">新增折扣</font></a>
					<input type="hidden" id="unitDiscountId" name="unitDiscountId" value="${unitDiscountId}"/>
				</td>			
              </tr>	 
			  
			   <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
				<td id="t13" style="width:15%" align="right"><font color="#FF0000">*</font>建筑成交单价&nbsp;</td>
                <td id="t14">
				 <input type="text" id="buildPrice" name="contract.buildPrice" class="money"/>
				 元				</td>	
				
				<td id="t15" style="width:15%" align="right">折扣说明&nbsp;</td>
                <td id="t16" style="width:30%">
				 <input type="text" id="discountDesc" name="contract.discountDesc" class="leftcreateinputbox01"/>				 </td>						
              </tr>	 
			  
			   <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
				   <td id="t13" style="width:15%" align="right"><font color="#FF0000">*</font>套内成交单价&nbsp;</td>
                <td id="t14">
					 <input type="text" id="insideUnitPrice" name="contract.insideUnitPrice" class="money"/>
				 元				</td>		
                <td id="t15" style="width:15%" align="right"><font color="#FF0000">*</font>成交总价&nbsp;</td>
                <td id="t16" style="width:30%">
					 <input type="text" id="sumMoney" name="contract.sumMoney" class="money"/>
				 元</td>			
              </tr>	 
			  
			  
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
			  
			  <tr bgcolor="#E9F5FF" style="empty-cells:show">
				
				<td id="t15" style="width:15%" align="right"><b>摘要</b>&nbsp;</td>
				<td colspan="3"></td>
			  </tr>
			  
			   <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
				<td id="t15" style="width:15%" align="right"><font color="#FF0000">*</font>合同编号&nbsp;</td>
                <td id="t16" style="width:30%">
				 <input type="text" id="contractNo" name="contract.contractNo" class="leftcreateinputbox01"/>				 </td>
                 <td id="t13" style="width:15%" align="right">&nbsp;</td>
                <td id="t14"></td>				
              </tr>	
			  
			  <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
				<td id="t15" style="width:15%" align="right">应收定金&nbsp;</td>
                <td id="t16" style="width:30%">
				   <input type="text" id="shouldDeposit" name="contract.shouldDeposit" class="money"/>
				 元						    </td>
                 <td id="t13" style="width:15%" align="right"><font color="#FF0000">*</font>合同总价&nbsp;</td>
                <td id="t14">
				  <input type="text" id="contractMoney" name="contract.contractMoney" class="money"/>
				 元				</td>				
              </tr>	
			  
			  <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
				<td id="t15" style="width:15%" align="right"><font color="#FF0000">*</font>签合同日期&nbsp;</td>
                <td id="t16" style="width:30%">
				    <input class="Wdate" type="text" id="signDate" style="width:90px" name="contract.signDate" value="${nowDate}"/>				 </td>
                 <td id="t13" style="width:15%" align="right"><font color="#FF0000">*</font>业务归属日期&nbsp;</td>
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
                 <td id="t13" style="width:15%" align="right">销售人员&nbsp;</td>
                <td id="t14">
					<input type="text" id="saleName" class="leftcreateinputbox01" />
					<input type="hidden" id="hiddenSalesId" name="contract.salesId"/>				</td>				
              </tr>	
			  
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
				<s:token />
				<input type="hidden" id="baseUrl" value="<%=basePath%>"/>
			   <input type="hidden" id="confirmType" value="${confirmType}" />				</td>
                 <td id="t13" style="width:15%" align="right">公积金年限&nbsp;</td>
                <td id="t14">
				<input type="text" id="fundYear" name="contract.fundYear" class="money"/>				</td>				
              </tr>	
			</table>

</form>	
	
</div>

<div id="contractCustomerDiv" class="easyui-dialog" closed="true" modal="true" title="新建合同客户" style="width:450px;height:200px;">

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
			<td id="t15" colspan="2" align="center">
				<input type="button" value="  提交  " id="contractCustomerForDialog" onclick="saveContractCustomerForDialog(${confirmType})"/>
				<span id='suggId'></span>
			</td>
		</tr>
	</table>
	
</div>

<div id="contractCustomerShowDiv" class="easyui-dialog" closed="true" modal="true" title="查看签约客户" style="width:450px;height:220px;">

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
		
	</table>
	
</div>

<div id="discountManagerDialog" class="easyui-dialog" closed="true" modal="true" title="折扣管理">
	<iframe scrolling="auto" frameborder="0"  style="width:580px;height:100%;" id="discountManagerIframe"></iframe>	
</div>

</body>
</html>