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

		<title>客户录入</title>
		
		<script language="javascript" type="text/javascript">
			$().ready(function(){
				
				$("#customerCond_companyId").change(function(){
					companyToProject(this.value, "customerCond_projectId");
				});
				
				
			});
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
				<tr style="height: 100%">
					<td valign="top">
						<s:include value="include/left.jsp">
						</s:include>
					</td>
					<td width="100%" valign="top" >
					<DIV style="WIDTH: 98%; HEIGHT: 100%; BACKGROUND-COLOR: #A4C3D7;padding: 1px">
						<%-- 基本table分割 ^^^^^^<td width="100%">^^^^^^^^^^^^^^^^^^^^^^--%>
						<%--main table开始 --%>
						<table width="100%" class="mainbg20111112" style="height: 100%">
							<tr>


								<td width="100%" valign="top" height="100%" style="overflow: hidden;">
									
									<div class="titlel"></div>
									<div class="titlebg" style="height: auto; overflow: hidden;">

										 <div class="title02" ><a href="./sale_hengda/customer/index.action" target="_self">查询客户</a></div>
								         <div class="title01"><a href="./sale_hengda/customer/forCustomerInput.action" target="_self">新建客户</a></div>		
										<div class="right99"></div>
										<div class="blueline"></div>

										<div class="c"></div>
										<div class="c"></div>
										
										
								<table style="table-layout: fixed; width: auto;" align="left" border="0" cellspacing="0">		  
		  
		  <!-- 搜索表单 top -->
       
       <form action="./sale_hengda/customer/index.action" method="get">
		  
            <tr>
              <td width="73"  height="0" align="right" nowrap="nowrap">客户姓名&nbsp;</td>
              <td  width="194" height="0" nowrap="nowrap">
			  	<input id="searchName" name="customerCond.searchName" value="${customerCond.searchName}"/>
				</td>
              <td width="78" height="0" align="right"  nowrap="nowrap" >客户电话&nbsp;</td>
              <td  width="168" height="0" nowrap="nowrap">
			  	 <input id="searchPhone" name="customerCond.searchPhone" value="${customerCond.searchPhone}"/>
			  </td >
              <td   width="74" height="0" align="right" nowrap="nowrap">客户状态&nbsp;</td>
              <td   width="420" height="0" nowrap="nowrap">
			  	<s:select list="selCustomerState" name="customerCond.state" value="#session.customerCond.state"/>
			  </td>
            </tr>			
			
            <tr>
              <td height="0" align="right" nowrap="nowrap">创建日期&nbsp;</td>
              <td height="0" nowrap="nowrap" >
			  	<input class="Wdate" type="text" id="date1" style="width:90px" name="customerCond.date1" value="${customerCond.date1}" onClick="WdatePicker()"/>
				-
				<input class="Wdate" type="text" id="date2" style="width:90px" name="customerCond.date2" value="${customerCond.date2}" onClick="WdatePicker()"/>
			  </td>   
			   
			  
              <td nowrap="nowrap" height="0" align="left" colspan="4">
			  	&nbsp;&nbsp;
			  	<label>
					<span>所属公司</span>
				</label>
				<s:select list="selCompany" name="customerCond.companyId" value="#session.companyId" />
				<label>
					<span>所属项目</span>
				</label>
				<s:select list="selProject" name="customerCond.projectId" value="#session.projectId" />

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
			  
			  操作： 	
				<input type="button" id="delete" value="  删除  " onClick="return delCustomers('customer_tianluan')"/>
				
				<%-- 
				<a href="#" target="_blank" onClick="return false">删除</a> ｜ 
				<a href="#" target="_blank" onClick="return false">增加</a> ｜  
				<a href="#" target="_blank" onClick="return false">追加</a> ｜  
				<a href="#" target="_blank" onClick="return false">批量删除</a>
				--%>
			 
				</td>
            </tr>
			
		</s:if>
			
	
		
            <tr>
              <td colspan="6">			  
			  
			  <!--  列表 top -->
			  <div class="gbox1">			  
			  
			  <table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" class="gbox" >
  <tr class="gboxbg">
    <td width="20">
	<label for="checkbox">
	  <input name="allDel" type="checkbox" value="" onClick="allDel()" id="allDel"/>      
      </label>
	 </td>

    <td width="197">
	<table width="99" height="28"  border="0" align="center" cellspacing="0">
      <tr>
        <td width="80%" align="center" valign="middle">客户名称</td>
        <td align="center" valign="middle">
		<table width="5" border="0" cellspacing="0">
          <tr>
            <td><a href="./sale_hengda/customer/index.action?ob=14"><img src="images/blue/upn.gif" width="9" height="10" border="0" /></a></td>
          </tr>
          <tr>
            <td><a href="./sale_hengda/customer/index.action?ob=13"><img src="images/blue/downopen.gif" width="9" height="10" border="0" /></a></a></td>
          </tr>
        </table>
	  </td>
      </tr>
      </table></td>
    <td width="187" align="center" valign="middle">
		所属用户
	</td>
	
    <td width="188">
	<table width="100" height="28"  border="0" align="center" cellspacing="0">
      <tr>
        <td width="80%" align="center" valign="middle">预算总价</td>
        <td align="center" valign="middle"><table width="5" border="0" cellspacing="0">
          <tr>
            <td><a href="./sale_hengda/customer/index.action?ob=16"><img src="images/blue/upn.gif" width="9" height="10" border="0" /></a></td>
          </tr>
          <tr>
            <td><a href="./sale_hengda/customer/index.action?ob=15"><img src="images/blue/downopen.gif" width="9" height="10" border="0" /></a></td>
          </tr>
        </table>
	</td>
      </tr>
    </table></td>
     <td width="187" align="center" valign="middle">
		电话号码
	</td>
     <td width="110">
	<table width="100" height="28"  border="0" align="center" cellspacing="0">
      <tr>
        <td width="80%" align="center" valign="middle">创建时间</td>
        <td align="center" valign="middle"><table width="5" border="0" cellspacing="0">
          <tr>
            <td><a href="./sale_hengda/customer/index.action?ob=12"><img src="images/blue/upn.gif" width="9" height="10" border="0" /></a></td>
          </tr>
          <tr>
            <td><a href="./sale_hengda/customer/index.action?ob=11"><img src="images/blue/downopen.gif" width="9" height="10" border="0" /></a></td>
          </tr>
        </table>
	</td>
      </tr>
    </table></td>
     <td width="120" align="center" valign="middle">
		客户状态
	</td>
   
  </tr>
  
  
   <s:iterator value="#request.customerList" id="c">  
	  <tr onMouseOver="this.style.backgroundColor='#f1f9fe';" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF"
	   title='客户名称:<s:property value="#c.customerName"/>, 电话:<s:property value="#c.phone"/>'> 
		<td width="20"><input name="delId" type="checkbox" value="<s:property value='#c.id'/>" onClick="delId()" /></td>
		
		<td align="center" valign="middle" class="fontblue">
			<a href="./sale_hengda/customer/queryCustomerById.action?id=<s:property value='#c.id'/>" target="_self" ><s:property value="#c.customerName"/></a>
		</td>
		
		
		<td align="center" valign="middle">
			<s:property value="#c.descUserId"/>
		</td>
		<td align="center" valign="middle">
			<s:property value="#c.descPriceAmount"/>
		</td>
		<td align="center" valign="middle">	
			<s:property value="#c.phone"/>
		</td>
		<td align="center" valign="middle">
			<s:date name="#c.createdTime" format="yyyy-MM-dd "/> 
		</td>
		<td align="center" valign="middle">
			<s:property value="#c.descCustomerState"/>
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
								
								</td>
							</tr>
							<!--main.end-->
							<tr>
								<td height="100%" colspan="6">
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
