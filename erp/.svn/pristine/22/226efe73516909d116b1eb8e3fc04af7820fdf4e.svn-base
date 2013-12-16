<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt" %>  

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<s:include value="include/header.jsp"></s:include>
		
		<title>录入次数查询</title>
		
		<script language="javascript" type="text/javascript">
			$().ready(function(){
				
				$("#saleCond_companyId").change(function(){
					companyToProject(this.value, "saleCond_projectId");
				});
				
				
			});
		</script>
		
	</head>
	<body>
		<table width="100%" border="0" align="left" cellspacing="0">
			<thead>
				<tr>
					<td colspan="2" style="border-collapse: collapse; border: 0px; margin: 0px; padding: 0px;">
						<s:include value="include/top.jsp"></s:include>
					</td>
				</tr>
			</thead>
			<tfoot>
				<tr>
					<td colspan="2">
						<s:include value="include/bottom.jsp"></s:include>
					</td>
				</tr>
			</tfoot>
			<tbody>
				<tr>
					<td width="1" align="left" valign="top">
					
						<s:include value="include/left.jsp">
						</s:include>
					</td>
						<td width="100%" valign="top">
						<DIV style="WIDTH: 98%; HEIGHT: 100%; BACKGROUND-COLOR: #A4C3D7;padding: 1px">
						<%-- 基本table分割 ^^^^^^<td width="100%">^^^^^^^^^^^^^^^^^^^^^^--%>
						<%--main table开始 --%>
						
					<table width="100%" class="mainbg20111112" style="height: 100%">
		  <tr>
		  
			
			<td width="100%" valign="top" height="100%" style="overflow:hidden;">
			
			  <div class="titlel"></div>
			   <div class="titlebg" style=" height:auto;overflow:hidden;">
		

					 <div class="title02" ><a href="./sale_hengda/search/inCount.action" target="_self">录入情况查询</a></div>
					
				   <div class="right99"></div>
				<div class="blueline"></div>
					
				  <div class="c"></div>
				  <div class="c"></div>
				  
				  
         
          <table width="100%" border="0" align="left" cellspacing="0">	
		  
		  <!-- 搜索表单 top -->
       
        <form action="sale_hengda/search/inCountForm.action" method="get">
			
            <tr>
			  <td height="0" align="left" colspan="6">
			  	<label>
					<span>日期</span>
				</label>
				<input class="Wdate" type="text" id="date1" style="width:90px" name="inputCountCond.date1" value="${inputCountCond.date1}" onClick="WdatePicker()"/>
				-
				<input class="Wdate" type="text" id="date2" style="width:90px" name="inputCountCond.date2" value="${inputCountCond.date2}" onClick="WdatePicker()"/>								
			  	<input type="submit" value="  搜索  " id="searchSubmit" onClick="return check();"/>
			  </td>
			 </tr>
			
			  </form>
		  
		<!-- 搜索表单 end -->
		
		 <tr>
              <td height="10" colspan="6">
              <div class="blueline"></div>
              </td>
         </tr>					
	
	
   		<tr >
         	<td colspan="6">			  
			  
	  <!--  列表 top -->	
		
	  <div class="gbox1">			  
			  
			  <table width="50%" border="0" align="left" cellpadding="0" cellspacing="1" class="gbox" >
  <tr class="gboxbg">
   

   <td width="100" align="center" valign="middle">
		项目名称</td>
	  <td width="100" align="center" valign="middle">
		录入次数</td>
		
  </tr>
  
  
   <s:iterator value="#request.beanList" id="b">  
	  <tr onMouseOver="this.style.backgroundColor='#ffffbf';" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF"> 
		
		<td align="center" valign="middle">
<a class="ablue" href="./sale_hengda/search/sale.action?saleCond.date1=${inputCountCond.date1}&saleCond.date2=${inputCountCond.date2}&saleCond.companyId=<s:property value='#b.companyId'/>&saleCond.projectId=<s:property value='#b.projectId'/>">
			<s:property value="#b.projectName"/>
			</a>
		</td>
		
		<td align="center" valign="middle">
			<s:property value="#b.cou"/>
		</td>
		
	  </tr>
    </s:iterator>
	
	
  
</table>
</div>
<!-- 列表 end --></td>
            </tr>
		
			
            </table>
        </div>
        <div class="titler"></div>
        <div class="c"></div>
   
	<div class="c"></div>
    <div class="c" ></div>
    </td>
  </tr>
  <!--main.end-->
  <tr>
    <td height="5" colspan="6">
    </td>
  </tr>
  
 
  
</table>
						
						</DIV>
					</td>
					<%-- 基本table分割 ^^^^^^^^^^^^^^^^^end^^^</td>^^^^^^^^^^^^^^^^^^^^^--%>
				</tr>
			</tbody>

		</table>

	</body>
</html>
