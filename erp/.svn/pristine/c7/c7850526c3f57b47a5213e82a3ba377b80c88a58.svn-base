<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" class="gbox" style="font-size:12px; line-height:26px">	
	
  <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
	style="empty-cells:show">
	<td id="t13" align="center">选择</td>
	<td id="t14" align="center">
		客户姓名(来源)
	</td>		
	
	<td id="t14" align="center">
		对应单元
	</td>	
	
	<td id="t14" align="center">
		所属销售
	</td>		
	
  </tr>	 
  
  <s:iterator value="#request.copyCusList" id="c">
  
   <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
	style="empty-cells:show">
	<td id="t13" align="center">
		<input type="radio" name="copyCustomerId" value="${c.customerId}" preCustomerType="${c.preCustomerType}" salesId="${c.salesId}"/>
	</td>
	<td id="t14" align="center">
		${c.customerName}
	</td>	
	<td id="t14" align="center">
		${c.unitName}
	</td>	
	
	<td id="t14" align="center">
		${c.salesName}
	</td>	
	
  </tr>
  
  </s:iterator>
		  
	
</table>