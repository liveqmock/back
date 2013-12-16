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

	        <div class="title02" ><a href="./userrole!queryRoles.action" target="_self">查询角色</a></div>
            <div class="title01"><a href="./userrole!doSomeForAddRole.action" target="_self">新建角色</a></div>		
			
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
       
       <form action="userrole!queryRoles.action" method="get">
			
            <tr >
			  <td width="8%" height="0" align="right">角色名称</td>
              <td width="19%" height="0" >
			  	&nbsp;
			  	<input type="text" id="roleName" name="roleCond.fmRoleName" value="${roleCond.fmRoleName}" style="width:180px"/>
			  </td>  
			  
			  <td width="8%" height="0" align="right" >所属项目</td>
              <td width="40%" height="0" align="left" style="white-space:nowrap">
				&nbsp;
				<input type="text" id="projectName" name="roleCond.projectName" value="${roleCond.projectName}" style="width:180px"/>
				&nbsp;&nbsp;
				<input type="submit" value="  搜索  " id="searchSubmit" onClick="return check();"/>
			  </td>     

			  
			  <td width="25%" height="0"></td>
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
			  
			  操作： 	
				<input type="button" id="delete" value="  删除  " onClick="return delSome('userrole', 'deleteRoles')"/>
				&nbsp;&nbsp;
				<font color="#FF0000"><span id="suggestion"><s:property value="#request.session.suggestion"/></span></font>
				
				<!-- 
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
					<td width="50" align="center">
					<label for="checkbox">
				
					  <input name="allDel" type="checkbox" value="" onClick="allDel()" id="allDel" title="全选"/>      
				
					  </label>
					 </td>
				
					<td width="222" align="center" valign="middle">角色名称</td>
					<td width="240" align="center" valign="middle">所属项目</td>	
					<td width="197" align="center" valign="middle">修改人</td>	
					<td width="197" align="center" valign="middle">修改时间</td>	
					<td width="440" align="center" valign="middle">角色描述</td>
					
					
					
				  </tr>
  
  
   <s:iterator value="#request.roleList" id="r">  
	  <tr onMouseOver="this.style.backgroundColor='#f1f9fe';" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF"> 
		<td width="50" align="center">
			<!--
			<input name="delId" type="radio" value="<s:property value='#c.id'/>" />
			-->
			<input name="delId" type="checkbox" value="<s:property value='#r.id'/>" onClick="delId()" />

		</td>
		<td align="center" valign="middle" class="fontblue">
			<a href="./userrole!queryRoleById.action?id=<s:property value='#r.id'/>" target="_self" ><s:property value="#r.roleName"/></a>
			
		</td>
		<td align="center" valign="middle">
			<s:property value="#r.descProjectName"/>
		</td>
		<td align="center" valign="middle">
			<s:property value="#r.descModName"/>
		</td>
		<td align="center" valign="middle">
			<s:date name="#r.modTime" format="yy-MM-dd hh:mm:ss"/>
		</td>
		<td align="center" valign="middle">
			<s:property value="#r.roleDesc"/>
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
