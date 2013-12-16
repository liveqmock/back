<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt" %>  
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
		
		<s:include value="../sale/include/header.jsp"></s:include>
		<script type="text/javascript" src="<%=basePath%>/js/userAccount-hengda.js" ></script>
		<title>用户管理</title>
		
		<script language="javascript" type="text/javascript">
		
			function showrole(showrole,showid){
				
				var show = showrole
					+"<br/>"
					+"<a class='ablue' href='./sale_hengda/role/index.action?selectId="
					+showid
					+"'"	
					+"target='_self'>修改</a>"
					;
				var showdialog = new Dialog(show,{title:'查看角色'});	
				showdialog.show();
			}
		
		</script>
		
	</head>
	<body>
		<table width="100%" border="0" align="left" cellspacing="0" >
			<thead>
				<tr>
					<td colspan="2" style="border-collapse: collapse; border: 0px; margin: 0px; padding: 0px;">
						<s:include value="../sale/include/top.jsp"></s:include>
						
					</td>
				</tr>
			</thead>
			<tfoot>
				<tr>
					<td colspan="2">
						<s:include value="../sale/include/bottom.jsp"></s:include>
					</td>
				</tr>
			</tfoot>
			<tbody>
				<tr>
					<td width="1" align="left" valign="top">
					
						<s:include value="../sale/include/left.jsp">
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

	        <div class="title02" ><a href="./sale_hengda/userAccount/search.action" target="_self">用户管理</a></div>
            <div class="title01"><a href="./sale_hengda/userAccount/input.action" target="_self" >新建用户</a></div>
			<div class="right99"></div>
			<div class="blueline"></div>
          <div class="c"></div>
          <div class="c"></div>
		  
		  
          <table width="100%" border="0" align="left" cellspacing="0">		  
		  
		  <!-- 搜索表单 top -->
       
       <form action="./sale_hengda/userAccount/searchform.action" method="post">
            <tr>
              <td width="100%" height="0" align="left" colspan="5" nowrap="nowrap">姓名：<input value="${searchCondSave.userName}" name="searchCond.userName" maxlength="10"/>
                <input type="submit" name="button3" id="button3" value="搜索"  align="left"/></td>
           
            </tr>
            <s:actionmessage cssStyle="color:red"/>
		 </form>
		  
		<!-- 搜索表单 end -->
			
            <tr>
              <td height="10" colspan="6">
              <div class="blueline"></div>              </td>
              </tr>		
			  	 
	
	 
            <tr>
              <td height="20" colspan="6">
<input  type="button" value="删除"  onclick="delUserAccount('./sale_hengda/userAccount/delete')"/>
				</td>
            </tr>
	
			
	
		
            <tr>
              <td colspan="6">			  
			  
			  <!--  列表 top -->
			  <div class="gbox1">			  
			  
			  <table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" class="gbox" >
  <tr class="gboxbg">
    <td width="25" align="center"><input  type="checkbox" id="allDel" name="allDel" onclick="allDel()" /> </td>

    <td width="197" align="center">
		姓名
	</td>
     <td width="188">
	<table width="100" height="28"  border="0" align="center" cellspacing="0">
      <tr>
        <td width="80%" align="center" valign="middle">公司</td>
        <td align="center" valign="middle"><table width="5" border="0" cellspacing="0">
          <tr>
            <td><a href="./sale_hengda/userAccount/searchform.action?ob=21"><img src="images/blue/upn.gif" width="9" height="10" border="0" /></a></td>
          </tr>
          <tr>
            <td><a href="./sale_hengda/userAccount/searchform.action?ob=22"><img src="images/blue/downopen.gif" width="9" height="10" border="0" /></a></td>
          </tr>
        </table>	</td>
      </tr>
    </table></td>
	
    <td width="188">
	<table width="100" height="28"  border="0" align="center" cellspacing="0">
      <tr>
        <td width="80%" align="center" valign="middle">项目</td>
        <td align="center" valign="middle"><table width="5" border="0" cellspacing="0">
          <tr>
            <td><a href="./sale_hengda/userAccount/searchform.action?ob=31"><img src="images/blue/upn.gif" width="9" height="10" border="0" /></a></td>
          </tr>
          <tr>
            <td><a href="./sale_hengda/userAccount/searchform.action?ob=32"><img src="images/blue/downopen.gif" width="9" height="10" border="0" /></a></td>
          </tr>
        </table>	</td>
      </tr>
    </table></td>
      <td width="188">
	<table width="100" height="28"  border="0" align="center" cellspacing="0">
      <tr>
        <td width="80%" align="center" valign="middle">账号</td>
        <td align="center" valign="middle"><table width="5" border="0" cellspacing="0">
          <tr>
            <td><a href="./sale_hengda/userAccount/searchform.action?ob=11"><img src="images/blue/upn.gif" width="9" height="10" border="0" /></a></td>
          </tr>
          <tr>
            <td><a href="./sale_hengda/userAccount/searchform.action?ob=12"><img src="images/blue/downopen.gif" width="9" height="10" border="0" /></a></td>
          </tr>
        </table>	</td>
      </tr>
    </table></td>
    <td width="197" align="center">
		权限
	</td>
  </tr>
  
  
  <s:iterator value="userlist"  id="u">
	  <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
		<td align="center" valign="middle"><input name="delId" type="checkbox" value="<s:property value='id'/>" onclick="delId()" /></td>
		<td align="left" valign="middle"  class="fontblue">&nbsp;
			<a href="./sale_hengda/userAccount/update.action?id=${id}" target="_self"> 
			<s:property  value="realName" /></a>	</td>
		<td align="left" valign="middle">&nbsp;
			<s:property  value="descCompanyId" />	</td>
		<td align="left" valign="middle">&nbsp;
			<s:property  value="descProjectId" />	</td>
		<td align="left" valign="middle" >&nbsp;	
			<s:property value="userName" /></td>
		<td align="left" valign="middle" title="${fn:length(selectUserRoleList)}条权限" >&nbsp;
		<a class="ablue" href="./sale_hengda/role/index.action?selectId=${id }" target="_self">修改</a>&nbsp;
			<a  onclick="showrole(<s:iterator value='selectUserRoleList' id='rl'>
				'${rl.roleName }<br/>'+
			</s:iterator>'',${id})" class="ablue">查看权限(${fn:length(selectUserRoleList)})</a>
			    </td>
	  </tr>
	  
    </s:iterator>
</table>
</div>

<!-- 列表 end --></td>
            </tr>
            <tr>
              <td colspan="6">
                <div class="manu">
					<s:property value="showPage" escape="false"/>
				</div>			</td>
            </tr>
            </table>
        </div>
        <div class="titler"></div>
        <div class="c"></div>
   
    <div class="c"></div>
    </div>
   
    <div class="c" ></div>
    </td>
  </tr>
  <!--main.end-->
  <tr>
    <td height="5" colspan="3">
    </td>
  </tr>
  
</table>
				
						</div>
					</td>
					<%-- 基本table分割 ^^^^^^^^^^^^^^^^^end^^^</td>^^^^^^^^^^^^^^^^^^^^^--%>
				</tr>
			</tbody>

		</table>

	</body>
</html>

