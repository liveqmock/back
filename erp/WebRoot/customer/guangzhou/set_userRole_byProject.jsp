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
		
		<title>权限管理</title>
		
		<script language="javascript" type="text/javascript">
			
		</script>
		
	</head>
	<body>
		<table width="100%" border="0" align="left" cellspacing="0" >
			<thead>
				<tr>
					<td colspan="2" style="border-collapse: collapse; border: 0px; margin: 0px; padding: 0px;">
						
					</td>
				</tr>
			</thead>
			<tfoot>
				<tr>
					<td colspan="2">
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
					 <div class="title02" ><a href="./guangzhou/role_project/index.action" target="_self">权限管理</a></div>			
				   <div class="right99"></div>
				<div class="blueline"></div>
					
				  <div class="c"></div>
				  <div class="c"></div>
				  
				  
         
          <table width="100%" border="0" align="left" cellspacing="0">	
		  
		  <!-- 搜索表单 top -->
       		<tr>
       			<td nowrap="nowrap" colspan="3" width="48%">
       				 <form action="./guangzhou/role_project/search.action" method="get">
       			搜索权限<br/>
				<label>
					<span>选择项目</span>
					<select name="leftUserCond.projectId" >
						<option value="5"
							<s:if test=" #request.leftUserCond.projectId == 5">selected="selected"</s:if>
						>广州项目1</option>
						<option value="6"  
							<s:if test=" #request.leftUserCond.projectId == 6">selected="selected"</s:if>
						>广州项目2</option>
						<option value="7" 
							<s:if test=" #request.leftUserCond.projectId == 7">selected="selected"</s:if>
						>广州项目3</option>
					</select><%--
					
				  <s:select list="projectList"  listKey="id" listValue="projectName" name="leftUserCond.projectId"/>	
				--%></label>
				<label>
					<span>选择权限</span>
					<select name="roleType">
						<option value="1"
							<s:if test=" #request.roleType == 1">selected="selected"</s:if>
						>录入人员</option>
						<option value="2"
							<s:if test=" #request.roleType == 2">selected="selected"</s:if>
						>管理人员</option>
					</select>
					<%--
				  <s:select list=""  listKey="id" listValue="roleName" name="leftUserCond.role.id"/>	
				--%></label>
				<input type="submit" value="  搜索  " />
				</td>
				<td nowrap="nowrap" colspan="3" width="48%">
				 
				 查询用户
				 <br/>
				<label>
					<span>姓名</span>
					<input type="text" name="rightUserCond.userName" value="${rightUserCond.userName }"/>
				  <%--<s:select list="projectList"  listKey="id" listValue="projectName" name="rightUserCond.projectId"/>	
				--%></label>
			  	<input type="submit" value="  搜索  " />
			  </form> 
       			</td>
       		</tr>
       
		<!-- 搜索表单 end -->
		
					
		
			 
	
   		<tr >
        <td colspan="3" valign="top" >			  
			  
	  <!--  列表 top -->	
		<font color="red">选择权限:${selectRole.roleName }</font>&nbsp;
	   <div class="gbox1" style="height:500px;overflow:auto;height:800">					  
			
			  <table width="100%"  border="0" align="center" cellpadding="0" cellspacing="1" class="gbox" style="vertical-align: top;" >
			  
  				<tr class="gboxbg" align="left" style="white-space: nowrap">
  					<td colspan="3" >&nbsp;已有人员</td> 
  				
  				</tr>	
  				<s:iterator value="leftUserList" id="idhave">
  					<tr class="gboxbg" align="left" style="white-space: nowrap">
  						<td>&nbsp;${idhave.userAccount.realName }</td>
  						
  						<td>&nbsp;<a href="./guangzhou/role_project/del.action?id=${idhave.userAccount.id }&selectRoleId=${selectRoleId}" target="_self" class="ablue" >移除</a></td>
  					</tr>
  				</s:iterator>
			</table>
            </div>
	</td>
<!-- 列表 end -->
	<td colspan="3" valign="top" >			  
			  
	  <!--  列表 top -->	
		&nbsp;
	   <div class="gbox1" style="height:500px;overflow:auto;height:800">			  
			  	
			  <table width="100%"  border="0" align="center" cellpadding="0" cellspacing="1" class="gbox" style="vertical-align: top;" >
  				<tr class="gboxbg" align="left" style="white-space: nowrap">
  					<td colspan="3">&nbsp;可添加人员</td>
  				</tr>	
  				<s:iterator value="rightUserList" id="idcan">
  					<tr class="gboxbg" align="left" style="white-space: nowrap">
  					<td colspan="2" >&nbsp;${idcan.realName } </td>
  					<td>&nbsp;<a href="./guangzhou/role_project/add.action?id=${idcan.id }&selectRoleId=${selectRoleId}" target="_self" class="ablue"> 赋予</a></td>
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