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
		<script type="text/javascript" src="<%=basePath%>/js/userAccount-hengda.js" ></script>
		<title>查询项目</title>
		
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

	        <div class="title02" ><a href="./sale_hengda/project/search.action" target="_self">查询项目</a></div>
            
			<div class="right99"></div>
			<div class="blueline"></div>
          <div class="c"></div>
          <div class="c"></div>
		  
		  
          <table width="100%" border="0" align="left" cellspacing="0">		  
		  
		  <!-- 搜索表单 top -->
       
       <form action="./sale_hengda/project/searchform.action" method="post">
            <tr>
              <td width="100%" height="0" align="left" colspan="5" nowrap="nowrap">
              	状态:
				<select name="proCond.projectState" >
					<option value="" >全部</option>
					<option value="1"
						<s:if test="#request.proCond.projectState == 1">
							selected="selected"
						</s:if>
					>活动</option>
					
					<option value="2"
						<s:if test="#request.proCond.projectState == 2">
							selected="selected"
						</s:if>
					>废止</option>
				</select >
				&nbsp;&nbsp;&nbsp;
				所属公司:
				<select name="proCond.companyId"> 
					<option value="0">全部</option>
					<s:iterator value="companylist" id="comp">
						<option value="${comp.id}"
							<s:if test="#comp.id == #request.proCond.companyId">
								selected="selected"
							</s:if>
						>${comp.companyName }</option>
					</s:iterator>
				</select>
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

				</td>
            </tr>
	
			
	
		
            <tr>
              <td colspan="6">			  
			  
			  <!--  列表 top -->
			  <div class="gbox1">			  
			  
			  <table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" class="gbox" >
  <tr class="gboxbg">
   

    <td width="197" align="center" >
		项目名称
	</td>
     <td width="188">
	<table width="100" height="28"  border="0" align="center" cellspacing="0">
      <tr>
        <td width="80%" align="center" valign="middle">所属公司</td><%--
        <td align="center" valign="middle"><table width="5" border="0" cellspacing="0">
          <tr>
            <td><a href="./sale_hengda/project/searchform.action?ob=11"><img src="images/blue/upn.gif" width="9" height="10" border="0" /></a></td>
          </tr>
          <tr>
            <td><a href="./sale_hengda/project/searchform.action?ob=12"><img src="images/blue/downopen.gif" width="9" height="10" border="0" /></a></td>
          </tr>
        </table>	</td>
      --%></tr>
    </table></td>
	
    <td width="188">
	<table width="100" height="28"  border="0" align="center" cellspacing="0">
      <tr>
        <td width="80%" align="center" valign="middle">项目状态</td><%--
        <td align="center" valign="middle"><table width="5" border="0" cellspacing="0">
          <tr>
            <td><a href="./sale_hengda/userAccount/searchform.action?ob=31"><img src="images/blue/upn.gif" width="9" height="10" border="0" /></a></td>
          </tr>
          <tr>
            <td><a href="./sale_hengda/userAccount/searchform.action?ob=32"><img src="images/blue/downopen.gif" width="9" height="10" border="0" /></a></td>
          </tr>
        </table>	</td>
      --%></tr>
    </table></td>
      <td width="188">
	<table width="100" height="28"  border="0" align="center" cellspacing="0">
      <tr>
        <td width="80%" align="center" valign="middle">创建时间按</td>
        <%--<td align="center" valign="middle"><table width="5" border="0" cellspacing="0">
          <tr>
            <td><a href="./sale_hengda/userAccount/searchform.action?ob=11"><img src="images/blue/upn.gif" width="9" height="10" border="0" /></a></td>
          </tr>
          <tr>
            <td><a href="./sale_hengda/userAccount/searchform.action?ob=12"><img src="images/blue/downopen.gif" width="9" height="10" border="0" /></a></td>
          </tr>
        </table>	</td>
      --%></tr>
    </table></td>
     
  </tr>
  
  
  <s:iterator value="prolist" id="pro">
	  <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
		
		<td align="center" valign="middle">
			<a class="ablue" href="./sale_hengda/project/update.action?id=${id}" target="_self">
				<s:property  value="projectName" /></a>
			</td>
		<td align="center" valign="middle">
			<s:property  value="descCompanyId" />	</td>
		<td align="center" valign="middle" 
			<s:if test="#pro.projectState == 1">style="color:green"</s:if>
			<s:else>style="color:red"</s:else>
		>
			<s:property  value="descProjectState" />	</td>
		<td align="center" valign="middle" >	
			<s:property value="createdTime" />	</td>
		
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
