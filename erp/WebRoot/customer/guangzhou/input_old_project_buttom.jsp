<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page contentType="text/html; charset=utf-8" %>

<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<style>
.midtd input{vertical-align: middle;}
.midtd label{padding-right: 10px;padding-left: 0px;}
</style>
<table width="100%" border="0" align="left" cellpadding="0" cellspacing="1" class="gbox" style="white-space: nowrap;display: block" id="changeTable">
			 
	  <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" id="change1">
		<td id="t9"  align="right">来访次数&nbsp;</td>
		<td id="t10">
			<s:select list="selVisitCount"  name="customer.visitCount" />	
		</td>
		<td id="t9" style="width:15%" align="right">性别&nbsp;</td>
		<td id="t10" style="width:18%">
			<s:select list="selGender"  name="customer.gender" />	
		</td>
		<td id="t9" style="width:15%" align="right">国籍&nbsp;</td>
		<td id="t10">
			<input type="text" name="customer.nationality" id="nationality" class="leftcreateinputbox01" maxlength="10"/>
		</td>
	  </tr>
	  
	  <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
		<td id="t9"  align="right">身份证号码&nbsp;</td>
		<td id="t10" style="width:18%">
			<input type="text" name="customer.idcardNo" id="idcardNo" class="leftcreateinputbox02" style="width:auto" maxlength="20"
			onkeyup="valueChangeGetCount('idcardNo', 'idcardNoCount', 18)" onKeyDown="valueChangeGetCount('idcardNo', 'idcardNoCount', 18)"/>
			<span id="idcardNoCount"></span>
		</td>
		<td id="t9"  align="right">驾车车型&nbsp;</td>
		<td id="t10">
			<input type="text" name="customer.trafficDesc" id="trafficDesc" class="leftcreateinputbox02" style="width:auto"  maxlength="10"/>
			
		</td>
		<td id="t9"  align="right">年龄&nbsp;</td>
		<td id="t10">
			<s:select list="selAgeRange"  name="customer.age" />	
		</td>
	  </tr>
	  
	   <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
		<td id="t5"  align="right">地址&nbsp;</td>
		<td colspan="3">
			<input type="text" name="customer.address" id="address" class="leftcreateinputbox02" style="width:80%" maxlength="100"/>				
		</td>
		<td id="t7"  align="right">邮编&nbsp;</td>
		<td id="t8">
			<input type="text" name="customer.postcode" id="postcode" class="leftcreateinputbox01" maxlength="10"/>				
			
		</td>
	  </tr>
	  
	  
	 <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
		<td id="t5"  align="right">家庭结构&nbsp;</td>
		<td id="t6">
			<s:select list="selFamilyType"  name="customer.familyType" />	
		</td>
		<td id="t5"  align="right">家庭收入&nbsp;</td>
		<td id="t6">
			<s:select list="selFamilyIncome"  name="customer.familyIncome" />	
		</td>
		 <td id="t9" style="width:15%" align="right"></td>
		<td id="t6">					
		</td>
	   
	 </tr>
	  
	  <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
		<td id="t5"  align="right">行业分类&nbsp;</td>
		<td id="t6">
			<s:select list="selJobType"  name="customer.jobType" />	
		</td>
		<td id="t5"  align="right">职业&nbsp;</td>
		<td id="t6">
			<s:select list="selJobIndustry"  name="customer.jobIndustry" />	
		</td>
		<td id="t5"  align="right">&nbsp;</td>
		<td id="t6">				</td>
	  </tr>
	  
	   <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
		<td id="t5"  align="right">购买单元1&nbsp;</td>
		<td id="t6">					
			<input type="text" id="intentUnit1" name="customer.intentUnit1" maxlength="10"/>
		</td>
		<td id="t5"  align="right">购买单元2&nbsp;</td>
		<td id="t6">
			<input type="text" id="intentUnit2" name="customer.intentUnit2" maxlength="10"/>
		</td>
		<td id="t5"  align="right">&nbsp;</td>
		<td id="t6">				</td>
	  </tr>
	  
	   <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
		<td id="t5"  align="right">购房目的&nbsp;</td>
		<td id="t6">
			<s:select list="selBuyAim"  name="customer.buyAim" />
		</td>
		<td id="t5"  align="right">付款方式&nbsp;</td>
		<td id="t6">
			<s:select list="selPayType"  name="customer.payType" />	
		</td>
		<td id="t5"  align="right">&nbsp;</td>
		<td id="t6">				</td>
	  </tr>



<tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
	  
		<td id="t9"  align="right">意向套数&nbsp;</td>
		<td id="t10">
			<s:select list="selIntentBuynum"  name="customer.intentBuynum" />	
		</td>
		<td id="t9"  align="right">意向户型&nbsp;</td>
		<td id="t10">
		  <s:select list="selRoomType"  name="customer.roomType" />	
		</td>
		
		<td id="t9"  align="right"></td>
		<td id="t10"></td>
	 </tr>

<tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
<td id="t1" style="width:15%"  align="right">认知途径&nbsp;</td>
<td colspan="5" style="white-space:normal;line-height: 30px" class="midtd">
				<s:checkboxlist list="selKnownFrom1" name="knownFrom" cssStyle="" />
	
</td>
</tr>

<tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
<td id="t7"  align="right">关注点&nbsp;</td>
<td colspan="5" style="white-space:normal;line-height: 30px" class="midtd">
	<s:checkboxlist list="selCustomerFocus" name="customerFocus"/>
	<input type="hidden" id="focusPoint" />
</td>
</tr>

<tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
<td id="t7"  align="right">未能成交原因&nbsp;</td>
<td colspan="5" style="white-space:normal">	
	<input type="text" name="customer.notBuyReson" id="notBuyReson" class="leftcreateinputbox02" style="width:80%" maxlength="50"/>			
</td>
</tr>

<tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
<td id="t7"  align="right">备注&nbsp;</td>
<td colspan="5" style="white-space:normal">	
	<input type="text" name="customer.remark1" id="remark1" class="leftcreateinputbox02" style="width:80%" maxlength="100"/>			
</td>
</tr>

</table>