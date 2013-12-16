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
	
	<title>合同楼盘分析</title>
	
	<base href="<%=basePath%>">
		
	<s:include value="../../customer/guangzhou/header.jsp"></s:include>	  
	<s:include value="../../customer/guangzhou/header_left_js.jsp"></s:include>	 
	
	<script type="text/javascript" language="javascript" src="<%=basePath%>js/customer_guangzhou_project.js"></script>	 
		
	<script type="text/javascript" language="javascript">
		$(document).ready(function(){				
			
			propertyProjectListForHiddenId("projectName", "hiddenId"); //项目的联想框,及用隐藏域保存其id
			
		});
		
	</script>
	
	<style>
		*{margin:0;padding:0;}
		
	</style>
	
  </head>
  
 <body onload="clearSome('suggestion', 2000)">
 
 
<%--固定的上部 --%>
<s:include value="../../customer/guangzhou/body_up.jsp">
</s:include>

<%--主体导航页头 --%>
<div class="title01" ><a href="./report/guangzhou/contract.action" target="_self">公司合同单</a></div>
<div class="title02" ><a href="./report/guangzhou/contractProperty.action" target="_self">楼盘合同单</a></div>
<div class="right99"></div>
<div class="blueline"></div>		
		
<%--主体table top --%>
		
  		<div class="c"></div>
          <div class="c">		  	
			  &nbsp;&nbsp;	
			<font color="#FF0000"><span id="suggestion"><s:property value="#request.session.suggestion"/></span></font>
		  </div>	
		  
		  <table style="width: 98%;" align="left" border="0" cellspacing="0">		  
		  
		  <!-- 搜索表单 top -->
       
     <form class="registerform" id="searchForm" action="<%=request.getContextPath() %>/report/guangzhou/contractProperty.action" method="post" >
		  <tr>
		  	<td colspan="6">
			

			 <table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" class="gbox" style="white-space:nowrap">
		 
  			<tr onMouseOver="this.style.backgroundColor='#f1f9fe';" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF">

				<td align="center" valign="middle" width="180">楼盘项目</td>
				
				<td width="187" align="left" valign="middle">					
					<input type="text" id="projectName" name="cond.propertyName" value="${cond.propertyName}"/>	
					<input type="hidden" id="hiddenId" name="cond.propertyId" value="${cond.propertyId}"/>				
					
				</td>
				
			   <td align="center" valign="middle" width="180">
			   签署日期
				</td>
				
				 <td width="200" align="left" valign="middle">
					<input class="Wdate" type="text" id="date1" style="width:90px" name="cond.date1" value="${cond.date1}"/>		
					-
					<input class="Wdate" type="text" id="date2" style="width:90px" name="cond.date2" value="${cond.date2}"/>
				 </td>
				
			   <td align="center" valign="middle" width="180px">
			   	<input type="submit" value="  搜索  " />
				</td>
				
				 <td width="187" align="left" valign="middle"></td>
				 
			  </tr>
		  
		  
		  </table>

			
			
		  </td>
		  </tr>
			
		</form>
		  
		<!-- 搜索表单 end -->
			
            <tr>
              <td height="10" colspan="6">
              <div class="blueline"></div>
              </td>
            </tr>		
		
			 <tr>
              <td height="20" colspan="6">
				<div id="load"></div>
				
				</td>
            </tr>
			
            <tr>
              <td colspan="6">			  
			  
					  <!--  列表 top -->
					  <div class="gbox1">			  
					  
					  <table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" class="gbox" >
						  <tr class="gboxbg">
								<td width="197"  align="center">楼盘项目</td>
								<td width="197"  align="center">楼盘分区</td>
								<td width="197"  align="center">楼盘楼栋</td>
								<td width="197"  align="center">合同数量</td>
								<td width="197"  align="center">应收定金</td>
								<td width="197"  align="center">合同总价</td>
						  </tr>
						  
						   <s:iterator value="#request.contractReportList" id="c">  
						   
							<tr onMouseOver="this.style.backgroundColor='#f1f9fe';" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF">
								<td width="197"  align="center">${c.propertyName}</td>
								<td width="197"  align="center">${c.areaName}</td>
								<td width="197"  align="center">${c.buildName}</td>
								<td width="197"  align="center">${c.cou}</td>
								<td width="197"  align="center">${c.depMoney}</td>
								<td width="197"  align="center">${c.conMoney}</td>
							</tr>
							
							</s:iterator>
						 
						  </table>
					</div>
				
					<!-- 列表 end -->


				</td>
            </tr>
 </table>


<%--主体table end --%>



<%--固定的底部 --%>
<s:include value="../../customer/guangzhou/body_bottom.jsp">
</s:include>
</table>  
   
</body>
</html>

