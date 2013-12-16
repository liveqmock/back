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
		<s:include value="header_bak.jsp"></s:include>
		
		<title>设置权限</title>
		
		<script language="javascript" type="text/javascript">
			
		</script>
		
	</head>
	<body>
		<table width="100%" border="0" align="left" cellspacing="0" >
			<thead>
				<tr>
					<td colspan="2" style="border-collapse: collapse; border: 0px; margin: 0px; padding: 0px;">
						<%--<s:include value="include/top.jsp"></s:include>
					--%></td>
				</tr>
			</thead>
			<tfoot>
				<tr>
					<td colspan="10">
						<s:include value="bottom.jsp"></s:include>
					</td>
				</tr>
			</tfoot>
			<tbody>
				<tr>
					<td width="1" align="left" valign="top">
					
						<s:include value="left.jsp">
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
			    <div class="title01" ><a href="./guangzhou/userAccount/search.action" target="_self">用户管理</a></div>
					 <div class="title02" ><a href="./guangzhou/role/index.action" target="_self">设置用户权限</a></div>			
				   <div class="right99"></div>
				<div class="blueline"></div>
					
				  <div class="c"></div>
				  <div class="c"></div>
				  
				  
         
          <table width="75%" border="0" align="left" cellspacing="0">	
		  
		  <!-- 搜索表单 top -->
       		<tr>
       			<td nowrap="nowrap" colspan="5">
       				 人员姓名: <font color="red">${SessionroleUser.realName }</font>&nbsp;&nbsp;
                账号: <font color="red">${SessionroleUser.userName }</font>   &nbsp;&nbsp; 
                 所属公司: <font color="red">${SessionroleUser.descCompanyId }</font>&nbsp;&nbsp; 
     	    所属项目: <font color="red">${SessionroleUser.descProjectId }</font>       
       			</td>
       		</tr>
       
		<!-- 搜索表单 end -->
		
					
		
			 
	
   		<tr >
        <td colspan="3" valign="top" width="300px">			  
			  
	  <!--  列表 top -->	
		
	   <div class="gbox1" style="height:500px;overflow:auto;height:800">					  
			 &nbsp;
			  <table width="100%"  border="0" align="center" cellpadding="0" cellspacing="1" class="gbox" style="vertical-align: top;" >
			  
  				<tr class="gboxbg" align="left" style="white-space: nowrap">
  					<td colspan="3" >&nbsp;已有权限</td> 
  				
  				</tr>	
  				<s:iterator value="roleListToHave" id="idhave">
  					<tr class="gboxbg" align="left" style="white-space: nowrap">
  						<td colspan="2">&nbsp;${idhave.roleName }</td>
  						<td>&nbsp;<a href="./guangzhou/role/del.action?id=${idhave.id }" target="_self" class="ablue" >删除</a></td>
  					</tr>
  				</s:iterator>
			</table>
            </div>
	</td>
<!-- 列表 end -->
	<td colspan="3" valign="top" width="300px">			  
			  
	  <!--  列表 top -->	
		
	   <div class="gbox1" style="height:500px;overflow:auto;height:800">			  
			  	 <form action="./guangzhou/role/search.action" method="get">
					
				</label>
					<label>
					<span>选择公司</span>
					<select name="companyId">
						<option value="17">广州公司</option>
					 </select>
				<%--<s:select list="companyList"  listKey="id" listValue="companyName" name="companyId"/>	
					
				--%></label>
				<input value="${SessionroleUser.id }" name="selectId" type="hidden"/>
			  	<input type="submit" value="  搜索  " id="searchSubmit""/>
			  </form>
			  <table width="100%"  border="0" align="center" cellpadding="0" cellspacing="1" class="gbox" style="vertical-align: top;" >
  				<tr class="gboxbg" align="left" style="white-space: nowrap">
  					<td colspan="3">&nbsp;可赋权限</td>
  				</tr>	
  				<s:iterator value="roleListToCan" id="idcan">
  					<tr class="gboxbg" align="left" style="white-space: nowrap">
  					<td colspan="2" >&nbsp;${idcan.roleName } </td>
  					<td>&nbsp;<a href="./guangzhou/role/add.action?id=${idcan.id }" target="_self" class="ablue"> 赋予</a></td>
  					</tr>
  				</s:iterator>
			</table>
            </div>
</td>

<!-- 列表 end -->
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
