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
	
	<title>认购公司分析</title>
	
	<base href="<%=basePath%>">
		
	<s:include value="../../customer/guangzhou/header.jsp"></s:include>	  
	<s:include value="../../customer/guangzhou/header_left_js.jsp"></s:include>	 
	
	<script type="text/javascript" language="javascript" src="<%=basePath%>js/customer_guangzhou_project.js"></script>	 
	
	<style>
		*{margin:0;padding:0;}
		
	</style>
	
  </head>
  
 <body onload="clearSome('suggestion', 2000)">
 
 
<%--固定的上部 --%>
<s:include value="../../customer/guangzhou/body_up.jsp">
</s:include>

<%--主体导航页头 --%>
<div class="title02" ><a href="./report/guangzhou/confirm.action" target="_self">公司认购单</a></div>
<div class="title01" ><a href="./report/guangzhou/confirmProperty.action" target="_self">楼盘认购单</a></div>
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
       
     <form class="registerform" id="searchForm" action="<%=request.getContextPath() %>/report/guangzhou/confirm.action" method="post" >
		  <tr>
		  	<td colspan="6">
			

		 <table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" class="gbox" style="white-space:nowrap">
		 
  			<tr onMouseOver="this.style.backgroundColor='#f1f9fe';" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF">

				<td align="center" valign="middle" width="180">签署日期</td>
				
				 <td width="200" align="left" valign="middle" style="white-space:nowrap">			
					<input class="Wdate" type="text" id="date1" style="width:90px" name="cond.date1" value="${cond.date1}"/>		
					-
					<input class="Wdate" type="text" id="date2" style="width:90px" name="cond.date2" value="${cond.date2}"/>
				</td>
				
			   <td align="center" valign="middle" width="180">
			   		<input type="submit" value="  搜索  " />			   	
				</td>
				
				 <td align="left" valign="middle" colspan="3">					
				 </td>
				
				 
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
					<td width="197"  align="center">认购数量</td>
					<td width="197"  align="center">应收定金</td>
					<td width="197"  align="center">协议总价</td>
					
				</tr>
				
				 <s:iterator value="#request.confirmReportList" id="c">  
				  
					<tr onMouseOver="this.style.backgroundColor='#f1f9fe';" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF">
						<td width="197" align="center" valign="middle" class="fontblue">
							<a href="./report/guangzhou/confirmProperty.action?cond.propertyId=${c.pId}&cond.date1=${cond.date1}&cond.date2=${cond.date2}" target="_self">${c.propertyName}</a>
						</td>
						<td width="197"  align="center">${c.cou}</td>
						<td width="197"  align="center">${c.depMoney}</td>
						<td width="197"  align="center">${c.agrMoney}</td>
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

