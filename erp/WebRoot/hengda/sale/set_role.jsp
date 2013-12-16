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
		
		<title>设置权限</title>
		
		<script language="javascript" type="text/javascript">
			
		</script>
		
	</head>
	<body>
		<table width="100%" border="0" align="left" cellspacing="0" >
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
					 <div class="title02" ><a href="./sale_hengda/role/index.action" target="_self">权限管理</a></div>			
				   <div class="right99"></div>
				<div class="blueline"></div>
					
				  <div class="c"></div>
				  <div class="c"></div>
				  
				  
         
          <table width="100%" border="0" align="left" cellspacing="0">	
		  
		  <!-- 搜索表单 top -->
       
        <form action="./sale_hengda/role/search.action" method="get">
			
            <tr style="white-space:nowrap">
			  <td height="0" align="left" colspan="6">
			  	<label>
					<span>选择人员</span>
				
				<s:select list="userList"  listKey="id" listValue="realName" name="selectId"/>	
					
				</label>
					<label>
					<span>权限所属公司</span>
				
				<s:select list="companyList"  listKey="id" listValue="companyName" name="companyId"/>	
					
				</label>
			  	<input type="submit" value="  搜索  " id="searchSubmit""/>
				
			  </td>
            </tr>
			
			  </form>
		  
		<!-- 搜索表单 end -->
		
		 <tr>
              <td height="10" colspan="6">
              <div class="blueline"></div>
               <br/>
               选择人员: <font color="red">${SessionroleUser.realName }</font>&nbsp;&nbsp;
                账号: <font color="red">${SessionroleUser.userName }</font>   &nbsp;&nbsp;  所属公司: <font color="red">${SessionroleUser.descCompanyId }</font>
              </td>
         </tr>					
		
			 
	
   		<tr >
         	<td colspan="3" valign="top" >			  
			  
	  <!--  列表 top -->	
		
	  <div class="gbox1" style="height:500px;overflow:auto;">			  
			 
			  <table width="100%"  border="0" align="center" cellpadding="0" cellspacing="1" class="gbox" style="vertical-align: top;" >
			  
  				<tr class="gboxbg" align="center" style="white-space: nowrap">
  					<td colspan="3" >已有权限</td> 
  				
  				</tr>	
  				<s:iterator value="roleListToHave" id="idhave">
  					<tr class="gboxbg" align="center" style="white-space: nowrap">
  						<td colspan="2">${idhave.roleName }</td>
  						<td><a href="./sale_hengda/role_project/del.action?id=${idhave.id }" target="_self" class="ablue" >删除</a></td>
  					</tr>
  				</s:iterator>
			</table>
            </div>
</td>
<!-- 列表 end -->
	<td colspan="3" valign="top" width="50%" height="800">			  
			  
	  <!--  列表 top -->	
		
	   <div class="gbox1" style="height:500px;overflow:auto;height:800">			  
			  
			  <table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" class="gbox">
  				<tr class="gboxbg" align="center" style="white-space: nowrap">
  					<td colspan="3">可赋权限</td>
  				</tr>	
  				<s:iterator value="roleListToCan" id="idcan">
  					<tr class="gboxbg" align="center" style="white-space: nowrap">
  					<td colspan="2" >${idcan.roleName } </td>
  					<td><a href="./sale_hengda/role/add.action?id=${idcan.id }" target="_self" class="ablue"> 赋予</a></td>
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
