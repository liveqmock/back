<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html>
<head>
	
	<title>查看成交</title>
	
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
		body{font-size:75%}
	</style>
	
</head>
<body>
<div class="gbox1">			

<form action="./saleunit_new/appoint/guangzhou/updateConfirmDialog.action" method="post">
			  
	<table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" class="gbox" style="font-size:12px; line-height:26px">
		  
		 
		 	   <tr bgcolor="#E9F5FF" style="empty-cells:show">
				
				<td id="t15" style="width:15%" align="right"><b>基本资料</b>&nbsp;</td>
				<td colspan="3"></td>
				
			  </tr>

              <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
				<td id="t15" style="width:15%" align="right"><font color="#FF0000">*</font>客户名称&nbsp;</td>
                <td id="t16" style="width:30%" class="fontblue">
				
				<a href="#" onclick="return showConfirmCustomer();" id="showConfirmCustomer">${confirmCustomer.customerName}</a>
				<input type='hidden' id='confirmCustomerId'  name="confirm.customerId" value="${confirmCustomer.id}"/>
				 
			    </td>
				<td id="t15" style="width:15%" align="right"><font color="#FF0000">*</font>联系电话&nbsp;</td>
                <td id="t16" style="width:30%">
			 	
				 <input type="text" id="phone" name="confirm.phone" class="leftcreateinputbox01" value="${confirm.phone}" />

				 </td>
                			
              </tr>		
			  
			  <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show" >
				
				<td id="t15" style="width:15%" align="right"><font color="#FF0000">*</font>房间&nbsp;</td>
				<td colspan="3">
					<a href="#" onclick="return false;" id="showConfirmUnitName">${selectUnit.unitNo}</a>
      			 	<input type="hidden" id="hiddenUnitId" name="confirm.unitId" value="${confirm.unitId}"/>
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
				<s:select list="selPriceWay"  name="confirm.priceWay" cssStyle="width:auto" id="priceWay"
				value="#request.confirm.priceWay" />
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
				 	<s:select list="selPayType"  name="confirm.payType" cssStyle="width:auto" id="payType" />
				</td>		
                <td id="t15" style="width:15%" align="right"><font color="#FF0000">*</font>折扣(%)&nbsp;</td>
                <td id="t16" style="width:30%">
					<!--
					<input type="text" id="discountPercent" name="confirm.discountPercent" class="leftcreateinputbox01"  style="width:30%" value="${confirm.discountPercent}" />
					-->
					${confirm.discountModifyHref}
				 </td>			
              </tr>	 
			  
			   <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
				<td id="t13" style="width:15%" align="right"><font color="#FF0000">*</font>建筑成交单价&nbsp;</td>
                <td id="t14">
				 <input type="text" id="buildPrice" name="confirm.buildPrice" class="leftcreateinputbox01" style="width:30%" value="${confirm.buildPrice}" />
				 元	
				</td>		
				
				<td id="t15" style="width:15%" align="right">折扣说明&nbsp;</td>
                <td id="t16" style="width:30%">
				 <input type="text" id="discountDesc" name="confirm.discountDesc" class="leftcreateinputbox01" value="${confirm.discountDesc}" />				 </td>	
				 
            	
              </tr>	 
			  
			   <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
				   <td id="t13" style="width:15%" align="right"><font color="#FF0000">*</font>套内成交单价&nbsp;</td>
                <td id="t14">
					 <input type="text" id="insideUnitPrice" name="confirm.insideUnitPrice" class="leftcreateinputbox01"  style="width:30%" value="${confirm.insideUnitPrice}" />
				 元
				</td>		
                <td id="t15" style="width:15%" align="right"><font color="#FF0000">*</font>房间总价&nbsp;</td>
                <td id="t16" style="width:30%">
					 <input type="text" id="sumMoney" name="confirm.sumMoney" class="leftcreateinputbox01"  style="width:30%" value="${confirm.sumMoney}" />
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
				 <input type="text" id="renovateDesc" name="confirm.renovateDesc" class="leftcreateinputbox01" value="${confirm.renovateDesc}"/>
				</td>
                 <td id="t13" style="width:15%" align="right">装修单价&nbsp;</td>
                <td id="t14">
				 <input type="text" id="renovatePrice" name="confirm.renovatePrice" class="leftcreateinputbox01" value="${confirm.renovatePrice}" style="width:30%"/>
				元
				</td>				
              </tr>	
			  
			    <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
				<td id="t15" style="width:15%" align="right">是否并入合同&nbsp;</td>
                <td id="t16" style="width:30%">
					<s:select list="selIsMerge" name="confirm.isMerge" cssStyle="width:auto" id="isMerge"/>				 </td>
                 <td id="t13" style="width:15%" align="right">装修总价&nbsp;</td>
                <td id="t14">
				 <input type="text" id="renovateMoney" name="confirm.renovateMoney" class="leftcreateinputbox01" value="${confirm.renovateMoney}" style="width:30%"/>
				元
				</td>				
              </tr>	
			  
			  <tr bgcolor="#E9F5FF" style="empty-cells:show">
				
				<td id="t15" style="width:15%" align="right"><b>摘要</b>&nbsp;</td>
				<td colspan="3"></td>
			  </tr>
			  
			   <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
				<td id="t15" style="width:15%" align="right"><font color="#FF0000">*</font>协议编号&nbsp;</td>
                <td id="t16" style="width:30%">
				 <input type="text" id="agreeNo" name="confirm.agreeNo" class="leftcreateinputbox01" value="${confirm.agreeNo}" />				 </td>
                 <td id="t13" style="width:15%" align="right">&nbsp;</td>
                <td id="t14"></td>				
              </tr>	
			  
			  <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
				<td id="t15" style="width:15%" align="right"><font color="#FF0000">*</font>应收定金&nbsp;</td>
                <td id="t16" style="width:30%">
				   <input type="text" id="shouldDeposit" name="confirm.shouldDeposit" class="leftcreateinputbox01"  style="width:30%" value="${confirm.shouldDeposit}" />
				 元</td>
                 <td id="t13" style="width:15%" align="right"><font color="#FF0000">*</font>协议总价&nbsp;</td>
                <td id="t14">
				  <input type="text" id="agreeMoney" name="confirm.agreeMoney" class="leftcreateinputbox01" style="width:30%" value="${confirm.agreeMoney}" />
				 元
				 </td>				
              </tr>	
			  
			  <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
				<td id="t15" style="width:15%" align="right"><font color="#FF0000">*</font>签署日期&nbsp;</td>
                <td id="t16" style="width:30%">
				    <input class="Wdate" type="text" id="signDate" style="width:90px" name="confirm.signDate" 
					value='<s:date name="#request.confirm.signDate" format="yyyy-MM-dd "/>'/>
				 </td>
                 <td id="t13" style="width:15%" align="right"><font color="#FF0000">*</font>业务归属日期&nbsp;</td>
                <td id="t14">
				 <input class="Wdate" type="text" id="workDate" style="width:90px" name="confirm.workDate" 
				 value='<s:date name="#request.confirm.workDate" format="yyyy-MM-dd "/>'/>
				</td>				
              </tr>	
			  
			  <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
				<td id="t15" style="width:15%" align="right">失效日期&nbsp;</td>
                <td id="t16" style="width:30%">
				    <input class="Wdate" type="text" id="endDate" style="width:90px" name="confirm.endDate" 
					value='<s:date name="#request.confirm.endDate" format="yyyy-MM-dd "/>'/>
			    </td>
                 <td id="t13" style="width:15%" align="right">推荐人&nbsp;</td>
                <td id="t14">
				 <input type="text" id="recommendMan" name="confirm.recommendMan" class="leftcreateinputbox01" value="${confirm.recommendMan}" />				</td>				
              </tr>	
			  
			  <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
				<td id="t15" style="width:15%" align="right">业务员&nbsp;</td>
                <td id="t16" style="width:30%">
				 	<input type="text" id="saleName" class="leftcreateinputbox01"  value="${confirm.saleName}" />
					<input type="hidden" id="hiddenSalesId" name="confirm.salesId"  value="${confirm.salesId}" />
			    </td>
                 <td id="t13" style="width:15%" align="right"><font color="#FF0000">*</font>认购约定交楼日期&nbsp;</td>
                <td id="t14">
				 <input class="Wdate" type="text" id="deliveryDate" style="width:90px" name="confirm.deliveryDate" 
				 value='<s:date name="#request.confirm.deliveryDate" format="yyyy-MM-dd "/>'/>
				</td>				
              </tr>	
			  
			  <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
				 <td id="t13" style="width:15%" align="right">关联房间&nbsp;</td>
                <td id="t14">
					 
					  <input type="text" id="refUnitId" class="leftcreateinputbox01"  value="${confirm.refUnitName}" />
					 <input type="hidden" id="hiddenRefUnitId" name="confirm.refUnitId"  value="${confirm.refUnitId}" />
				</td>	
                 <td id="t13" style="width:15%" align="right"></td>
                <td id="t14"></td>				
              </tr>	 
			  
			  
			   <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF"; align="center">
				<td colspan="4">
				
				  <s:token />
				  <input type="submit" value="  保存  " id="confirmSub"/>
				   <input type="hidden" id="baseUrl" value="<%=basePath%>"/>
				  <input type="hidden" id="mainId" name="confirm.id"  value="${confirm.id}"/>
				   <input type="hidden" id="unitDiscountId" name="unitDiscountId" value="${unitDiscountId}"/>
				   <input type="hidden" id="confirmType" value="${confirmType}" />
					&nbsp;&nbsp;
				  <input type="button" value="  退房  " onClick="return checkOut('confirm', ${confirm.id}, ${confirm.unitId})" id="checkOutId"/>				  
				   <s:if test="confirm.canChangeToContract"> 
				    &nbsp;&nbsp;					
				   <input type="button" value="  转签约  " id="changeToContractButton" onclick="return changeToContract(${confirm.id})"/>				  
				   </s:if>
				   &nbsp;&nbsp;
				   <!--
				   <input type="button" value="  折扣管理  " onclick="return createDiscountDialog(${confirm.unitId})"/>
				   -->
				</td>
			  </tr>			
			  
			    <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF"; align="center">
				<td colspan="4" align="center" style="height:26px">					
					<font color="#FF0000"><span id="suggestion2"><s:property value="#request.session.suggestion"/></span></font>	
				</td>
			  </tr>		 
			
           
            </table>
</form>	
	
	</div>

<div id="confirmCustomerShowDiv" class="easyui-dialog" closed="true" modal="true" title="查看成交客户" style="width:450px;height:195px;">

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
