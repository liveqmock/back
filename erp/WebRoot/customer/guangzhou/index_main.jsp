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
    
    <title>查询客户</title>
	
	<link href="css/blue_new.css"  rel="stylesheet" type="text/css" charset="utf-8"/>
	<meta http-equiv=Content-Type content="text/html; charset=utf-8" /> 

  </head>
  
  <body onLoad="clearSuggestion()">
   
   

<!--main-->
<span class="titlebg" style=" height:auto;overflow:hidden;">
<%-- 
			&nbsp;&nbsp;
			<font color="#FF0000"><span id="suggestion"><s:property value="#request.suggestion"/></span></font>
            <div class="title02" style="display:none;"><a href="#">录入</a></div>
            <div class="title01"><a href="#">录入2</a></div>
            <div class="title02" style="display:none;"><a href="#">录入</a></div>
            <div class="title01"><a href="#">录入3</a></div>
            <div class="title02" style="display:none;"><a href="#">录入</a></div>
            <div class="title01"><a href="#">录入4</a></div>
            <div class="title02" style="display:none;"><a href="#">录入</a></div>
			--%>
</span>
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

	        <div class="title02" ><a href="./customer_guangzhou!searchCustomer.action?from=left" target="_self">查询客户</a></div>
            <div class="title01"><a href="./customer_guangzhou!doSomeForAddCustomer.action" target="_self">新建客户</a></div>
			<div class="right99"></div>
			<div class="blueline"></div>
			
			<div class="c"></div>
          <div class="c"></div>
		  
		  
           <table style="table-layout: fixed; width: auto;" align="left" border="0" cellspacing="0">		  
		  
		  <!-- 搜索表单 top -->
       
       <form action="customer_guangzhou!searchCustomer.action" method="get">
		  
            <tr>
              <td width="73"  height="0" align="right" nowrap="nowrap">客户姓名&nbsp;</td>
              <td  width="194" height="0" nowrap="nowrap">
			  	<input id="searchName" name="customerCond.searchName" value="${customerCond.searchName}"/>
				</td>
              <td width="78" height="0" align="right"  nowrap="nowrap" >客户电话&nbsp;</td>
              <td  width="168" height="0" nowrap="nowrap">
			  	 <input id="searchPhone" name="customerCond.searchPhone" value="${customerCond.searchPhone}"/>
			  </td >
              <td   width="74" height="0" align="right" nowrap="nowrap">&nbsp;</td>
              <td   width="420" height="0" nowrap="nowrap">
			  <%-- 
			  	<s:select list="selCustomerState" name="customerCond.state" value="#session.customerCond.state"/>
				--%>
			  </td>
            </tr>			
			
            <tr nowrap="nowrap">
              <td height="0" align="right" nowrap="nowrap">创建日期&nbsp;</td>
              <td height="0" nowrap="nowrap">
			  	<input class="Wdate" type="text" id="date1" style="width:90px" name="customerCond.date1" value="${customerCond.date1}" onClick="WdatePicker()"/>
				-
				<input class="Wdate" type="text" id="date2" style="width:90px" name="customerCond.date2" value="${customerCond.date2}" onClick="WdatePicker()"/>
			  </td>   
			  
			   <%--
			   <s:if test="#session.loginAccount.accountType == 2 ">
				  <td height="0" align="right" nowrap="nowrap" >
					所属用户&nbsp;
					</td>
					<td height="0" align="left" nowrap="nowrap" >
					
					<s:select list="#session.selUserForTianLuan"  name="customerCond.userId" value="#session.customerCond.userId"/>
					
				  </td>                       
			  </s:if>
			--%>
			  
              <td nowrap="nowrap" height="0" align="right" colspan="2">
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
				<input type="button" id="delete" value="  删除  " onClick="return delCustomers('customer_guangzhou')"/>
				
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
            <td><a href="customer_guangzhou!searchCustomer.action?ob=14"><img src="images/blue/upn.gif" width="9" height="10" border="0" /></a></td>
          </tr>
          <tr>
            <td><a href="customer_guangzhou!searchCustomer.action?ob=13"><img src="images/blue/downopen.gif" width="9" height="10" border="0" /></a></a></td>
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
            <td><a href="customer_guangzhou!searchCustomer.action?ob=16"><img src="images/blue/upn.gif" width="9" height="10" border="0" /></a></td>
          </tr>
          <tr>
            <td><a href="customer_guangzhou!searchCustomer.action?ob=15"><img src="images/blue/downopen.gif" width="9" height="10" border="0" /></a></td>
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
            <td><a href="customer_guangzhou!searchCustomer.action?ob=12"><img src="images/blue/upn.gif" width="9" height="10" border="0" /></a></td>
          </tr>
          <tr>
            <td><a href="customer_guangzhou!searchCustomer.action?ob=11"><img src="images/blue/downopen.gif" width="9" height="10" border="0" /></a></td>
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
			<a href="./customer_guangzhou!queryCustomerById.action?id=<s:property value='#c.id'/>" target="_self" ><s:property value="#c.customerName"/></a>
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
