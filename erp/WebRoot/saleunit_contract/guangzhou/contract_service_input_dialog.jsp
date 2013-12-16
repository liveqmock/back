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
	
	<title>添加销售服务</title>
	
	<base href="<%=basePath%>">
			
	<s:include value="../../customer/guangzhou/header.jsp"></s:include>	  
	
	<script type="text/javascript" language="javascript" src="<%=basePath%>js/contract_service_guangzhou.js"></script>
			
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

		 <form class="registerform" action="./saleunit/contract/guangzhou/inputContractService.action" method="post" >	
		  
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
				<td id="t15" style="width:20%" align="right">服务项目&nbsp;</td>
                <td id="t16" style="width:30%">				 
				 	 <s:select list="selServiceType" name="contractService.serviceType" cssStyle="width:auto" id="serviceType"/>	
				 				 
			    </td>
                 <td id="t13" style="width:20%" align="right">服务进程&nbsp;</td>
                <td id="t14">
					 <s:select list="selStepState" name="contractService.stepState" cssStyle="width:auto" id="stepState"/>	
					 
				</td>
				
              </tr>
            
			
             <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
			 
			 	<td id="t11"  align="right">承诺办理时间&nbsp;</td>
                <td id="t12">	
					 <input class="Wdate" type="text" id="promiseDoDate" style="width:90px" name="contractService.promiseDoDate" />		
				</td>
				
                <td id="t11"  align="right">承诺完成时间&nbsp;</td>
                <td id="t12">
				 	 <input class="Wdate" type="text" id="promiseFinishDate" style="width:90px" name="contractService.promiseFinishDate" />		
				</td>
				
             </tr>
			 
			
			   <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF"; align="center">
				<td colspan="4">
				
				  <s:token />
				  <input type="submit" value="  保存  " id="contractServicesSub"/>				 
					&nbsp;&nbsp;
				  <input type="reset" value="  重置  "/>			
				  <input type="hidden" name="contractService.contractId" value="${contract.id}"/>	 
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

