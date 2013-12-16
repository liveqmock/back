<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>主页</title>
	
	<link href="css/hengda.css"  rel="stylesheet" type="text/css" charset="utf-8"/>
	<meta http-equiv=Content-Type content="text/html; charset=utf-8" /> 

  </head>
  
  <body onLoad="clearSuggestion()">
   
   

<!--main-->
<table width="100%" border="0" cellspacing="0">
  <tr>
  
  	<!--left.top-->
	
	<s:include value="left.jsp"></s:include>

    <!--left.end-->	
  
  
	
    <td width="100%" valign="top" height="100%" style="overflow:hidden;">
    <div class="right01"></div>
    <div class="right02"></div>
    <div class="right03"></div>
    <div class="c"></div>
    <div >
    <div class="right04"></div>
    <div class="right05">
      <div class="titlel"></div>
        <div class="titlebg" style=" height:auto;overflow:hidden;">

	        <div class="title02" ><a href="./userrole!queryUserPrivs.action" target="_self">查询用户权限</a></div>
			
			&nbsp;&nbsp;
			<font color="#FF0000"><span id="suggestion"><s:property value="#request.suggestion"/></span></font>
			<!--
            <div class="title02" style="display:none;"><a href="#">录入</a></div>
            <div class="title01"><a href="#">录入2</a></div>
            <div class="title02" style="display:none;"><a href="#">录入</a></div>
            <div class="title01"><a href="#">录入3</a></div>
            <div class="title02" style="display:none;"><a href="#">录入</a></div>
            <div class="title01"><a href="#">录入4</a></div>
            <div class="title02" style="display:none;"><a href="#">录入</a></div>
			-->
			
			
          <div class="c"></div>
          <div class="c"></div>
		  
		  
          <table width="100%" border="0" align="left" cellspacing="0">
		  
		   <tr>
              <td height="10" colspan="6">
              <div class="blueline"></div>
              </td>
              </tr>			  
		  
		  <!-- 搜索表单 top -->
       
       <form action="userrole!queryUserPrivs.action" method="get">
			
			  <tr>
			  <td width="9%" height="0" align="center"><label> <span>用户名称</span></label></td>
              <td width="21%" height="0" >
			  	&nbsp;
			  	<input type="text" id="userNameRemote" name="userName" value="${session.userName}" style="width:180px"/>
			  </td>  
			
			  
			  <td width="70%" height="0" colspan="4">
			  	&nbsp;
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
		
		<s:if test="#session.loginAccount.accountType == 2 ">
	 
            <tr>
              <td height="20" colspan="6">
			  
			  <!-- 
			  操作： 	
				<input type="button" id="delete" value="  删除  " onClick="return delSales('sale_hengda')"/>
				
				
				<a href="#" target="_blank" onClick="return false">删除</a> ｜ 
				<a href="#" target="_blank" onClick="return false">增加</a> ｜  
				<a href="#" target="_blank" onClick="return false">追加</a> ｜  
				<a href="#" target="_blank" onClick="return false">批量删除</a>
				-->
			 
				</td>
            </tr>
			
		</s:if>
			
	
		
            <tr>
              <td colspan="6">			  
			  
			  
			  <!--  列表 top -->
			  <div class="gbox1">			  
			  
			  <table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" class="gbox" >
				  <tr class="gboxbg">
					<td width="257" align="center" valign="middle">用户名称</td>
					<td width="269" align="center" valign="middle">权限code</td>	
					<td width="287" align="center" valign="middle">权限名称</td>	
					<td width="228" align="center" valign="middle">权限所属角色</td>	
					<td width="230" align="center" valign="middle">权限所属角色的所属项目</td>	
					
				  </tr>
  
  
   <s:iterator value="#request.userPrivList" id="r">  
	  <tr onMouseOver="this.style.backgroundColor='#f1f9fe';" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF"> 
				
		<td align="center" valign="middle">
			<s:property value="#r.realName"/>
		</td>
		<td align="center" valign="middle">
			<s:property value="#r.privCode"/>
		</td>
		<td align="center" valign="middle">
			<s:property value="#r.privName"/>
		</td>
		<td align="center" valign="middle">
			<s:property value="#r.roleName"/>
		</td>
		<td align="center" valign="middle">
			<s:property value="#r.projectName"/>
		</td>
		
		
	  </tr>
    </s:iterator>
  
</table>
</div>

<!-- 列表 end -->


</td>
        </tr>
            <tr>
              <td colspan="6">
                <div class="manu">
					<s:property value="showPage" escape="false"/>
				</div>                
			</td>
            </tr>
            </table>
        </div>
        <div class="titler"></div>
        <div class="c"></div>
    </div>
    <div class="right06"></div>
    <div class="c"></div>
    </div>
    <div class="right07"></div>
    <div class="right08"></div>
    <div class="right09"></div>
    <div class="c" ></div>
    </td>
  </tr>
  <!--main.end-->
  <tr>
    <td height="5" colspan="3">
    </td>
  </tr>
  
</table>

   
   
   
  </body>
</html>
