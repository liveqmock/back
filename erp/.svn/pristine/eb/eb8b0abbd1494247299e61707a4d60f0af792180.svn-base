<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page contentType="text/html; charset=utf-8" %>

<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
	
	<title>添加权益人</title>
	
	<base href="<%=basePath%>">
			
	<s:include value="../../customer/guangzhou/header.jsp"></s:include>	  
	
	<script type="text/javascript" language="javascript" src="<%=basePath%>js/property_owner_guangzhou.js"></script>
			
	<style type="text/css">
		*{margin:0;padding:0;}
	</style>

	
  </head>
  
 <body>
 
 <DIV style="WIDTH: 98%; HEIGHT: 100%; BACKGROUND-COLOR: #A4C3D7;padding: 1px">
	<table width="100%" class="mainbg20111112" style="height: 100%">
		<tr>


			<td width="100%" valign="top" height="100%" style="overflow: hidden;">
				<div class="titlebg" style="height: auto; overflow: visible;">
				
				<div class="c"></div>
				  <div class="c"></div>

		 <form class="registerform" action="./saleunit/contract/guangzhou/inputPropertyOwner.action" method="post" >	
		  
		  <table style="width: 600px;" align="left" border="0" cellspacing="0">		  
		  
		  <tr>
		  	<td colspan="4">
			

		 <table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" class="gbox" >
		 
		 	<tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
                <td id="t16" colspan="4">
					&nbsp;&nbsp;<font color="#000000">相关信息</font> 
					&nbsp;&nbsp;<font color="#FF0000"><span id="suggestion"><s:property value="#request.session.suggestion"/></span></font>
				</td>
				
              </tr>
		  			 
			   <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
				<td id="t15" style="width:20%" align="right"><font color="#FF0000">*</font>客户姓名&nbsp;</td>
                <td id="t16" style="width:30%">				 
				 	 <input type="text" id="customerName" name="owner.customerName" class="leftcreateinputbox01"/>
				 				 
			    </td>
                 <td id="t13" style="width:20%" align="right"><font color="#FF0000">*</font>证件号码&nbsp;</td>
                <td id="t14">
					 <input type="text" id="idcardNo" name="owner.idcardNo" class="leftcreateinputbox01"/>	
				</td>
				
              </tr>
            
			
             <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
			 
			 	<td id="t11"  align="right"><font color="#FF0000">*</font>联系电话&nbsp;</td>
                <td id="t12">	
					<input type="text" id="phone" name="owner.phone" class="leftcreateinputbox01"/>
				</td>
				
                <td id="t11"  align="right"><font color="#FF0000">*</font>产权比例(%)&nbsp;</td>
                <td id="t12">
				 	<input type="text" id="rightPercent" name="owner.rightPercent" class="leftcreateinputbox01"/>
				</td>
				
             </tr>
			 
			  <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
			 
			 	<td id="t11"  align="right">代理人名称&nbsp;</td>
                <td id="t12">	
					<input type="text" id="agentName" name="owner.agentName" class="leftcreateinputbox01"/>
				</td>
				
                <td id="t11"  align="right">代理人国籍&nbsp;</td>
                <td id="t12">
				 	<input type="text" id="agentNation" name="owner.agentNation" class="leftcreateinputbox01"/>
				</td>
				
             </tr>
			 
			  <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
			 
			 	<td id="t11"  align="right">代理人证件号码&nbsp;</td>
                <td id="t12">	
					<input type="text" id="cardNum" name="owner.cardNum" class="leftcreateinputbox01"/>
				</td>
				
                <td id="t11"  align="right">代理人联系电话&nbsp;</td>
                <td id="t12">
				 	<input type="text" id="agentPhone" name="owner.agentPhone" class="leftcreateinputbox01"/>
				</td>
				
             </tr>
			  
			   <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF"; align="center">
				<td colspan="4">
				
				  <s:token />
				  <input type="submit" value="  保存  " id="propertyOwnerSub"/>				 
					&nbsp;&nbsp;
				  <input type="reset" value="  重置  "/>			
				  <input type="hidden" name="owner.mainId" value="${contract.id}"/>	 
				</td>
			  </tr>
			  
			  <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF"; align="center">
				<td colspan="4"><font color="#FF0000"><span id="suggestion"><s:property value="#request.session.suggestion"/></span></font></td>
			  </tr>
			 
			
			</table>

			
		  </td>
		  </tr>
			
		  
           
            </table>
</form>
				
				
				</div>
			</td>
		</tr>
	</table>
</DIV>
				


 	
 

  </body>
</html>

