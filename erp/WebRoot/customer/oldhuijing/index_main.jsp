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
	
	<link href="css/tianluan.css"  rel="stylesheet" type="text/css" charset="utf-8"/>
	
	<meta http-equiv=Content-Type content="text/html; charset=utf-8" /> 
	<style type="text/css">
        .FixedTitleRow
        {
            position: relative;
            top: expression(this.offsetParent.scrollTop);
            z-index: 10;
        }

        .FixedTitleColumn
        {
            position: relative;
            left: expression(this.parentElement.offsetParent.scrollLeft);
        }

        .FixedDataColumn
        {
            position: relative;
            left: expression(this.parentElement.offsetParent.parentElement.scrollLeft);
        }
        .td{width:100px;overflow:hidden}
    </style>
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

	        <div class="title02" ><a href="./customer_oldhuijing!searchCustomer.action?from=left" target="_self">查询客户</a></div>
            <div class="title01"><a href="./customer_oldhuijing!doSomeForAddCustomer.action?from=huijing" target="_self">新建客户</a></div>
			<div class="right99"></div>
			<div class="blueline"></div>
		
			<%--	&nbsp;&nbsp;
			<font color="#FF0000"><span id="suggestion"><s:property value="#request.suggestion"/></span></font>
            <div class="title02" style="display:none;"><a href="#">录入</a></div>
            <div class="title01"><a href="#">录入2</a></div>
            <div class="title02" style="display:none;"><a href="#">录入</a></div>
            <div class="title01"><a href="#">录入3</a></div>
            <div class="title02" style="display:none;"><a href="#">录入</a></div>
            <div class="title01"><a href="#">录入4</a></div>
            <div class="title02" style="display:none;"><a href="#">录入</a></div>
			--%>
			
			
          <div class="c"></div>
          <div class="c"></div>
		  
		  
          <table width="100%" border="0" align="left" cellspacing="0"  style="table-layout:fixed;width:auto">	
		  
		  <!-- 搜索表单 top -->
       
       <form action="customer_oldhuijing!searchCustomer.action" method="get">
		   <tr>
              <td width="75" height="0" align="right">关键字&nbsp;</td>
              <td width="168" height="0" valign="bottom" > <input id="keyword" name="customerCond.keyword" value="${customerCond.keyword}"/></td>
              <td width="75" height="0" align="right">客户姓名&nbsp;</td>
              <td width="168" height="0">
			  	 <input id="searchName" name="customerCond.searchName" value="${customerCond.searchName}"/>			  </td>
				 
				 
             <s:if test="#session.loginAccount.accountType == 2 ">
              <td width="75" height="0" align="right">销售人员&nbsp;</td>
              <td width="469" height="0">
			  	<s:select list="#session.selUserForOldHuiJing"  name="customerCond.userId" value="#session.customerCond.userId"/>				</td>
			 </s:if>
            </tr>		
			
				
				<td width="75" align="right">移动电话&nbsp;</td>
				<td width="168">
				  <input id="searchPhone" name="customerCond.searchPhone" value="${customerCond.searchPhone}"/>				</td>
				<td width="75" align="right">固定电话&nbsp;</td>
				<td>
					<input id="homePhone" name="customerCond.homePhone" value="${customerCond.homePhone}"/>				</td>
				<td width="75" align="right">创建日期&nbsp;</td>
				<td>
			  	<input class="Wdate" type="text" id="date1" name="customerCond.date1" value="${customerCond.date1}" onClick="WdatePicker()" style="width:100px"/>
				-
						
				<input class="Wdate" type="text" id="date2" name="customerCond.date2" value="${customerCond.date2}" onClick="WdatePicker()" style="width:100px"/>				  </td>
            <tr>                    
			   <td width="75"  height="0" align="right">
				关系户&nbsp;</td>        
              <td width="168"  height="0">
				<input id="relationDesc" name="customerCond.relationDesc" value="${customerCond.relationDesc}"/>			  </td>
			  <td width="75" height="0" align="right">
			  客户评级&nbsp;</td>
              <td height="0" align="left">
			  	
				<s:select list="selRating" name="customerCond.rating" value="#session.customerCond.rating"/>			    </td>
              <td width="75" height="0" align="left"><input name="submit" type="submit" id="searchSubmit" onClick="return check();" value="  搜索  "/></td>
              <td height="0">&nbsp;</td>
              
            </tr>
			 <tr>
              <td height="10" colspan="6" width="960">
              <div class="blueline"></div>              </td>
              </tr>		
			
			  </form>
		  
		<!-- 搜索表单 end -->
			
           
			  	 
		<s:if test="#session.loginAccount.accountType == 2 ">
	 
            <tr>
              <td height="20" colspan="6">
			  
			  操作&nbsp; 	
				<input type="button" id="delete" value="  删除  " onClick="return delCustomers('customer_oldhuijing')"/>&nbsp;&nbsp; <a href="customer_oldhuijing!downLoad.action"><font color="blue"> [导出]</font></a>
				
				<%-- 
				<a href="#" target="_blank" onClick="return false">删除</a> ｜ 
				<a href="#" target="_blank" onClick="return false">增加</a> ｜  
				<a href="#" target="_blank" onClick="return false">追加</a> ｜  
				<a href="#" target="_blank" onClick="return false">批量删除</a>
				--%>				</td>
            </tr>
		</s:if>
		
	
	
   <tr>
         <td colspan="6">			  
			  
	  <!--  列表 top -->
	<div class="gbox1" style="left:0; overflow:scroll;display: inline;width:1050px; float:left;">			  
			  
	<table class="gbox" style="table-layout: fixed; width: 980px; font-size: 12px;" align="center" border="0" cellpadding="0" cellspacing="1" width="95%">	
  <tr class="gboxbg" style="line-height:11px">
    <td width="25">
	<label for="checkbox">
	  <input name="allDel" type="checkbox" value="" onClick="allDel()" id="allDel"/>
      </label>	 </td>

     <td width="100">
	<table width="100" height="28"  border="0" align="center" cellspacing="0" >
      <tr>
        <td width="80%" align="center" valign="middle">录入时间</td>
        <td align="center" valign="middle"><table width="5" border="0" cellspacing="0">
          <tr>
            <td><a href="customer_oldhuijing!searchCustomer.action?ob=12"><img src="images/blue/upn.gif" width="9" height="10" border="0" /></a></td>
          </tr>
          <tr>
            <td><a href="customer_oldhuijing!searchCustomer.action?ob=11"><img src="images/blue/downopen.gif" width="9" height="10" border="0" /></a></td>
          </tr>
        </table>	</td>
      </tr>
    </table></td>
	
	 <td width="80">
	<table width="75" height="28" border="0" align="center" cellspacing="0">
      <tr>
        <td width="75" align="center" valign="middle">客户名称</td>
        <td align="center" valign="middle">
		<table width="5" border="0" cellspacing="0">
          <tr>
            <td><a href="customer_oldhuijing!searchCustomer.action?ob=14"><img src="images/blue/upn.gif" width="9" height="10" border="0" /></a></td>
          </tr>
          <tr>
            <td><a href="customer_oldhuijing!searchCustomer.action?ob=13"><img src="images/blue/downopen.gif" width="9" height="10" border="0" /></a></a></td>
          </tr>
        </table>	  </td>
      </tr>
      </table></td>
	  
	  <td width="80" align="center" valign="middle">
		移动电话	</td>
	<td width="80" align="center" valign="middle">
		固定电话	</td>
	<td width="50" align="center" valign="middle" title="客户人数">
		人数	</td>
	<td width="75" align="center" valign="middle" title="是否首次到场">首次到场</td>
	<td width="50" align="center" valign="middle" title="是否业主">
		业主	</td>
	<td width="75" align="center" valign="middle" title="是否有提及关系户">关系户</td>
	<td width="75" align="center" valign="middle">
		需求面积	</td>
	<td width="75" align="center" valign="middle">
		租金预算	</td>
	<td width="75" align="center" valign="middle">
		意向单元	</td>
	<td width="187" align="center" valign="middle">
		客户背景	</td>
	<td width="187" align="center" valign="middle" title="影响客户购买的原因">购买原因</td>
	<td width="50" align="center" valign="middle" title="客户初步评级">评级</td>
	<td width="187" align="center" valign="middle">
		经办人	</td>
	<td width="187" align="center" valign="middle">
		销售人员	</td>
	
	  
	  <!--
    <td width="187" align="center" valign="middle">
		所属用户
	</td>
	-->
  </tr>
  
  
   <s:iterator value="#request.customerList" id="c">  
	  <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF"
	   title='客户名称:<s:property value="#c.customerName"/>, 电话:<s:property value="#c.phone"/>'> 
		<td width="109"><input name="delId" type="checkbox" value="<s:property value='#c.id'/>" onClick="delId()" /></td>
		<td align="center" valign="middle">
			<s:date name="#c.createdTime" format="yyyy-MM-dd "/>		</td>
		<td align="center" valign="middle" class="fontblue" >
			<a href="./customer_oldhuijing!queryCustomerById.action?id=<s:property value='#c.id'/>" target="_self" ><s:property value="#c.customerName"/></a>		</td>
		
	<td align="center" valign="middle">
		<s:property value="#c.phone"/>	</td>
	<td align="center" valign="middle">
		<s:property value="#c.homePhone"/>	</td>
	<td align="center" valign="middle">
		<s:property value="#c.peerNumber"/>	</td>
	<td align="center" valign="middle">
		<s:if test="#c.isFirst==1">是</s:if>
		<s:if test="#c.isFirst==0">否</s:if>	</td>
	<td align="center" valign="middle">
		<s:if test="#c.isOwner==1">是</s:if>
		<s:if test="#c.isOwner==0">否</s:if>	</td>
	<td align="center" valign="middle">
		<s:if test="#c.isRelation==1">是</s:if>
		<s:if test="#c.isRelation==0">否</s:if>	</td>
	<td align="center" valign="middle">
		<s:property value="#c.descCustomerRequestArea"/>	</td>
	<td align="center" valign="middle">
		<s:property value="#c.descPriceAmount"/>	</td>
	<td align="center" valign="middle">
		<s:property value="#c.descIntentionPart"/>	</td>
	<td align="center" valign="middle">
		<s:property value="#c.background"/>	</td>
	<td align="center" valign="middle">
		<s:property value="#c.buyReson"/>	</td>
	<td align="center" valign="middle">
		<s:property value="#c.descRating"/>	</td>
	<td align="center" valign="middle">
		<s:property value="#c.descCreatedId"/>	</td>
	<td align="center" valign="middle">
		<s:property value="#c.descUserId"/>	</td>
	
		<!--
		<td align="center" valign="middle">
			<s:property value="#c.descUserId"/>
		</td>
		-->
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
