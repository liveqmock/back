<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html>
<head>
	
	<title>查看合同</title>

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
	
</head>

<body>
<div class="gbox1">			

<form action="./saleunit_new/appoint/guangzhou/updateContractDialog.action" method="post">

		 
<table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" class="gbox" style="font-size:12px; line-height:26px">	
		 
		 	   <tr bgcolor="#E9F5FF" style="empty-cells:show">
				
				<td id="t15" style="width:15%" align="right"><b>基本资料</b>&nbsp;</td>
				<td colspan="3"><font color="#FF0000"><span id="suggestion"><s:property value="#request.session.suggestion"/></span></font></td>
			  </tr>

              <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
				<td id="t15" style="width:15%" align="right"><font color="#FF0000">*</font>客户名称&nbsp;</td>
                <td id="t16" style="width:30%" class="fontblue">
				 
				 <a href="#" onclick="return showContractCustomer();" id="showContractCustomer">${confirmCustomer.customerName}</a>
				<input type='hidden' id='contractCustomerId'  name="contract.customerId" value="${confirmCustomer.id}"/>

				</td>
				<td id="t15" style="width:15%" align="right"><font color="#FF0000">*</font>联系电话&nbsp;</td>
                <td id="t16" style="width:30%">
			 	
				 <input type="text" id="phone" name="contract.phone" class="leftcreateinputbox01" value="${contract.phone}"/>
				 </td>
              </tr>		
			  
			  <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
				
				<td id="t15" style="width:15%" align="right"><font color="#FF0000">*</font>房间&nbsp;</td>
				<td id="t16" style="width:30%">
					
					<a href="#" onclick="return false;" id="showConfirmUnitName">${selectUnit.unitNo}</a>
      			 	<input type="hidden" id="hiddenUnitId" name="contract.unitId" value="${contract.unitId}"/>
				</td>
				
				<td id="t15" style="width:15%" align="right">房产类型&nbsp;</td>
                <td id="t16" style="width:30%">
					<s:select list="selPropertyType"  name="contract.propertyType" cssStyle="width:auto" id="propertyType"/>
				</td>
			  </tr>
			  
			    <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
				<td id="t13" style="width:15%" align="right">房间结构&nbsp;</td>
                <td id="t14">
					${selectUnit.roomTypeStr}
				</td>		
                <td id="t15" style="width:15%" align="right">面积状态&nbsp;</td>
                <td id="t16" style="width:30%">
					${selectUnit.areaStateStr}					
				</td>			
              </tr>	 
			  
			   <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
				<td id="t13" style="width:15%" align="right">建筑面积&nbsp;</td>
                <td id="t14">
				${selectUnit.buildArea}	
				</td>		
                <td id="t15" style="width:15%" align="right">套内面积&nbsp;</td>
                <td id="t16" style="width:30%">
				${selectUnit.insideArea}	
				</td>			
              </tr>	 
			  
			   <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
				<td id="t13" style="width:15%" align="right">建筑单价&nbsp;</td>
                <td id="t14">
				${selectUnit.buildPrice} 元
				</td>		
                <td id="t15" style="width:15%" align="right">套内单价&nbsp;</td>
                <td id="t16" style="width:30%">
				${selectUnit.insidePrice}	元
				</td>			
              </tr>	 
			 
			  
			   <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
				<td id="t13" style="width:15%" align="right">计价方式&nbsp;</td>
                <td id="t14">				
				<s:select list="selPriceWay"  name="contract.priceWay" cssStyle="width:auto" id="priceWay" value="#contract.priceWay" />
				</td>		
                <td id="t15" style="width:15%" align="right">标准总价&nbsp;</td>
                <td id="t16" style="width:30%">
				${selectUnit.sumPrice} 元
				 </td>			
              </tr>	 
			  
			    <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
				<td id="t13" style="width:15%" align="right"><font color="#FF0000">*</font>付款方式&nbsp;</td>
                <td id="t14">
				 	<s:select list="selPayType"  name="contract.payType" cssStyle="width:auto" id="payType"/>
				</td>		
                <td id="t15" style="width:15%" align="right"><font color="#FF0000">*</font>折扣(%)&nbsp;</td>
                <td id="t16" style="width:30%">
					<!--
					<input type="text" id="discountPercent" name="contract.discountPercent" class="leftcreateinputbox01" value="${contract.discountPercent}" style="width:30%"/>
					-->
					${contract.discountModifyHref}
				</td>			
              </tr>	 
			  
			   <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
				<td id="t13" style="width:15%" align="right"><font color="#FF0000">*</font>建筑成交单价&nbsp;</td>
                <td id="t14">
				 <input type="text" id="buildPrice" name="contract.buildPrice" class="leftcreateinputbox01" style="width:30%" value="${contract.buildPrice}"/>
				 元
				</td>		
               <td id="t15" style="width:15%" align="right">折扣说明&nbsp;</td>
                <td id="t16" style="width:30%">
				 <input type="text" id="discountDesc" name="contract.discountDesc" class="leftcreateinputbox01" value="${contract.discountDesc}"/>
				 </td>	
              </tr>	 
			  
			   <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
				
				 <td id="t13" style="width:15%" align="right"><font color="#FF0000">*</font>套内成交单价&nbsp;</td>
                <td id="t14">
					 <input type="text" id="insideUnitPrice" name="contract.insideUnitPrice" class="leftcreateinputbox01" value="${contract.insideUnitPrice}" style="width:30%"/>
				 元
				</td>					
						
                <td id="t15" style="width:15%" align="right"><font color="#FF0000">*</font>成交总价&nbsp;</td>
                <td id="t16" style="width:30%">
					 <input type="text" id="sumMoney" name="contract.sumMoney" class="leftcreateinputbox01" value="${contract.sumMoney}" style="width:30%"/>
				 元
				</td>			
              </tr>	 
			  
			  
  			  <tr bgcolor="#E9F5FF" style="empty-cells:show">
				
				<td id="t15" style="width:15%" align="right"><b>装修选择</b>&nbsp;</td>
				<td colspan="3"></td>
			  </tr>
			  
			  <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
				<td id="t15" style="width:15%" align="right">装修标准&nbsp;</td>
                <td id="t16" style="width:30%">
					 <input type="text" id="renovateDesc" name="contract.renovateDesc" class="leftcreateinputbox01" value="${contract.renovateDesc}"/>
				 </td>
                 <td id="t13" style="width:15%" align="right">装修单价&nbsp;</td>
                <td id="t14">
					 <input type="text" id="renovatePrice" name="contract.renovatePrice" class="leftcreateinputbox01" value="${contract.renovatePrice}" style="width:30%"/>
				元
				</td>				
              </tr>	
			  
			    <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
				<td id="t15" style="width:15%" align="right">是否并入合同&nbsp;</td>
                <td id="t16" style="width:30%">
					<s:select list="selIsMerge" name="contract.isMerge" cssStyle="width:auto" id="isMerge"/>				 </td>
                 <td id="t13" style="width:15%" align="right">装修总价&nbsp;</td>
                <td id="t14">
					 <input type="text" id="renovateMoney" name="contract.renovateMoney" class="leftcreateinputbox01" value="${contract.renovateMoney}" style="width:30%"/>
				元
				</td>					
              </tr>	
			  
			  <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
				<td id="t15" style="width:15%" align="right">个性装修约定交楼日期&nbsp;</td>
                <td id="t16" style="width:30%">
					 <input class="Wdate" type="text" id="finishDate" style="width:90px" name="contract.finishDate" 
						 value='<s:date name="#request.contract.finishDate" format="yyyy-MM-dd "/>'/>
					 
				</td>
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
				 <input type="text" id="contractNo" name="contract.contractNo" class="leftcreateinputbox01" value="${contract.contractNo}"/>				 </td>
                 <td id="t13" style="width:15%" align="right">&nbsp;</td>
                <td id="t14"></td>				
              </tr>	
			  
			  <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
				<td id="t15" style="width:15%" align="right">应收定金&nbsp;</td>
                <td id="t16" style="width:30%">
				   <input type="text" id="shouldDeposit" name="contract.shouldDeposit" class="leftcreateinputbox01" value="${contract.shouldDeposit}" style="width:30%"/>
				 元					    </td>
                 <td id="t13" style="width:15%" align="right"><font color="#FF0000">*</font>合同总价&nbsp;</td>
                <td id="t14">
				  <input type="text" id="contractMoney" name="contract.contractMoney" class="leftcreateinputbox01" value="${contract.contractMoney}" style="width:30%"/>
				 元				</td>				
              </tr>	
			  
			  <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
				<td id="t15" style="width:15%" align="right"><font color="#FF0000">*</font>签合同日期&nbsp;</td>
                <td id="t16" style="width:30%">
				    <input class="Wdate" type="text" id="signDate" style="width:90px" name="contract.signDate" 
						 value='<s:date name="#request.contract.signDate" format="yyyy-MM-dd "/>'/>
					</td>
                 <td id="t13" style="width:15%" align="right"><font color="#FF0000">*</font>业务归属日期&nbsp;</td>
                <td id="t14">
				 <input class="Wdate" type="text" id="workDate" style="width:90px" name="contract.workDate" 
						 value='<s:date name="#request.contract.workDate" format="yyyy-MM-dd "/>'/>
				 </td>				
              </tr>	
			  
			  <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
				<td id="t15" style="width:15%" align="right">约定交房日期&nbsp;</td>
                <td id="t16" style="width:30%">
				    <input class="Wdate" type="text" id="deliveryDate" style="width:90px" name="contract.deliveryDate" 
						 value='<s:date name="#request.contract.deliveryDate" format="yyyy-MM-dd "/>'/>
					</td>
                 <td id="t13" style="width:15%" align="right">实际交房日期&nbsp;</td>
                <td id="t14">
				  <input class="Wdate" type="text" id="realHouseDate" style="width:90px" name="contract.realHouseDate" 
						 value='<s:date name="#request.contract.realHouseDate" format="yyyy-MM-dd "/>'/>
				</td>				
              </tr>	
			  
			  <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
				<td id="t15" style="width:15%" align="right">延期收楼日期&nbsp;</td>
                <td id="t16" style="width:30%">
				 	 <input class="Wdate" type="text" id="delayDate" style="width:90px" name="contract.delayDate" 
						 value='<s:date name="#request.contract.delayDate" format="yyyy-MM-dd "/>'/>
					 </td>
                 <td id="t13" style="width:15%" align="right">&nbsp;</td>
                <td id="t14"></td>				
              </tr>	
			  
			  <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
				<td id="t15" style="width:15%" align="right">合同备案号&nbsp;</td>
                <td id="t16" style="width:30%">
				     <input type="text" id="recordNo" name="contract.recordNo" class="leftcreateinputbox01" value="${contract.recordNo}"/>			    </td>
                 <td id="t13" style="width:15%" align="right">备案日期&nbsp;</td>
                <td id="t14">
				    <input class="Wdate" type="text" id="recordDate" style="width:90px" name="contract.recordDate" 
						 value='<s:date name="#request.contract.recordDate" format="yyyy-MM-dd "/>'/>
				</td>				
              </tr>	
			  
			   <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
				<td id="t15" style="width:15%" align="right">推荐人&nbsp;</td>
                <td id="t16" style="width:30%">
				    <input type="text" id="recommendMan" name="contract.recommendMan" class="leftcreateinputbox01" value="${contract.recommendMan}"/>
				</td>
                 <td id="t13" style="width:15%" align="right">销售人员&nbsp;</td>
                <td id="t14">					
					
					 <input type="text" id="saleName" name="saleName" class="leftcreateinputbox01" value="${contract.saleName}"/>
					 <input type="hidden" id="hiddenSalesId" name="contract.salesId" value="${contract.salesId}"/>
				</td>				
              </tr>	
			  
			   <tr bgcolor="#E9F5FF" style="empty-cells:show">
				
				<td id="t15" style="width:15%" align="right"><b>贷款信息</b>&nbsp;</td>
				<td colspan="3"></td>
			  </tr>
			  
			  <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
				<td id="t15" style="width:15%" align="right">按揭银行&nbsp;</td>
                <td id="t16" style="width:30%">
				    <input type="text" id="contract.mortgageBank" name="contract.mortgageBank" class="leftcreateinputbox01" value="${contract.mortgageBank}"/>	
					
				 </td>
                 <td id="t13" style="width:15%" align="right">按揭贷款&nbsp;</td>
                <td id="t14">
					<input type="text" id="contract.mortgageMoney" name="contract.mortgageMoney" class="leftcreateinputbox01" value="${contract.mortgageMoney}"/>
				</td>				
              </tr>	
			  
			  <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
				<td id="t15" style="width:15%" align="right"></td>
                <td id="t16" style="width:30%"></td>
                 <td id="t13" style="width:15%" align="right">按揭年限&nbsp;</td>
                <td id="t14">
				<input type="text" id="mortgageYear" name="contract.mortgageYear" class="leftcreateinputbox01" value="${contract.mortgageYear}"/>
				</td>				
              </tr>	
			  
			  <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
				<td id="t15" style="width:15%" align="right">公积金银行&nbsp;</td>
                <td id="t16" style="width:30%">
				    <input type="text" id="fundBank" name="contract.fundBank" class="leftcreateinputbox01" value="${contract.fundBank}"/>
					
				</td>
                 <td id="t13" style="width:15%" align="right">公积金贷款&nbsp;</td>
                <td id="t14">
				 <input type="text" id="fundMoney" name="contract.fundMoney" class="leftcreateinputbox01" value="${contract.fundMoney}"/>
				 </td>				
              </tr>	
			  
			  <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
				<td id="t15" style="width:15%" align="right"></td>
                <td id="t16" style="width:30%"></td>
                 <td id="t13" style="width:15%" align="right">公积金年限&nbsp;</td>
                <td id="t14">
				<input type="text" id="fundYear" name="contract.fundYear" class="leftcreateinputbox01" value="${contract.fundYear}"/>
				</td>				
              </tr>	
			  
			   <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" align="center">
				<td colspan="4">
				
				  <s:token />
				  <input type="submit" value="  保存  " id="subContract"/>
				  <input type="hidden" id="baseUrl" value="<%=basePath%>"/>
				  <input type="hidden" id="confirmType" value="${confirmType}" />
				  <input type="hidden" id="mainId" name="contract.id"  value="${contract.id}"/>
					&nbsp;&nbsp;
				  <input type="button" value="  退房  " onClick="return checkOut('contract', ${contract.id}, ${contract.unitId})" id="checkOutId"/>
				  
				 </td>
			  </tr>			 
			 
			</table>

</form>	
	
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