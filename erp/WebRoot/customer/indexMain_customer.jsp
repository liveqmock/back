<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
    
    <title>indexMain.jsp</title>
	<meta http-equiv=Content-Type content="text/html; charset=utf-8" /> 
		
	<link href="../css/blue.css" rel="stylesheet" type="text/css" charset="utf-8" />
	
	<script language="javascript" type="text/javascript" src="./My97DatePicker/WdatePicker.js"></script>	
	<script type="text/javascript" language="javascript" src="./js/customer.js"></script>


  </head>
  
  <body onLoad="clearSuggestion()">
    
    

<!--main-->
<table width="100%" border="0" cellspacing="0" class="boxnav">
  <tr>  
      <td width="290" align="left" valign="top" background="images/blue/leftbg.gif">
	  
	<!--left.top-->
	
	<s:include value="left.jsp"></s:include>

    <!--left.end-->	
    </td>

	
	
    <td>
    <!--right-->
    <div class="rightnav">
    	<div class="righttitle">
    	客户主页
		&nbsp;&nbsp;
		<font color="#FF0000"><span id="suggestion"><s:property value="#request.suggestion"/></span></font>
        </div>
		
		
		<!-- 视图部分 top -->
		<!--
        <div class="rightword01">
        <div class="l"><strong>视图：</strong></div>
        <div class="rightbox">
            <form id="form2" name="form2" method="post" action=""  >
            <select name="select" id="select" class="rightinputbox">
              <option>我的客户</option>
            </select>
          </form>
        </div>
        <div class="l"><a href="#" target="_blank">编辑</a> | <a href="#" target="_blank">新建视图</a></div>
        <div class="c"></div>
        </div>
		-->
		<!-- 视图部分 end -->
		
		
        <div class="rightlineg"></div>
        <div class="rightboxn">
        <div class="righttitleword fontblue">最近客户</div>
<div class="r">
  <div class="leftcreatesave iconbg"><a href="./customer!doSomeForAddCustomer.action" target="_self"">+ 新 建</a></div>
  
 		<!-- 
          <div class="l">
            <form id="form3" name="form2" method="post" action=""  >
              <select name="select2" id="select2" class="rightinputbox">
                <option>最近查看</option>
              </select>
            </form>
          </div>
		  -->
		  
	</div>
        <div class="rightlineg"></div>
		
		<!-- 搜索表单 top -->
       
       <form action="customer!searchCustomer.action" method="get">
          <div class="l">
          
          	客户姓名: <input id="searchName" name="customerCond.searchName" value="${customerCond.searchName}" style="width:6%"/>
          	
          	客户电话: <input id="searchPhone" name="customerCond.searchPhone" value="${customerCond.searchPhone}"  style="width:10%"/>
			<input type="hidden" id="ob" name="ob" value="${customerCond.orderByFiled}"/>
			

			创建日期:从 <input class="Wdate" type="text" id="date1" name="customerCond.date1" value="${customerCond.date1}" onClick="WdatePicker()" style="width:10%"/>
			到<input class="Wdate" type="text" id="date2" name="customerCond.date2" value="${customerCond.date2}" onClick="WdatePicker()" style="width:10%"/>
			
			客户状态: <s:select list="selCustomerState" name="customerCond.state" value="#session.customerCond.state"/>
			
		  	<input type="submit" value=" 搜 索 " id="searchSubmit" onClick="return check();"/>
          </div>
		  
        
          
         </form>
		  
		<!-- 搜索表单 end -->
		  
		  
          <div class="c"></div>
          
        <div>
        <table width="100%" border="0" cellspacing="0">
  <tr>
    <td height="37" colspan="10" bgcolor="#fbfbfb">
	
	
	<s:if test="#session.loginAccount.accountType == 2 ">
	 

	<div class="tableword">操作： 
	
	<input type="button" id="delete" value="删除" onClick="return delCustomers('customer')"/>
	
	<!-- 
	<a href="#" target="_blank" onClick="return false">删除</a> ｜ 
	<a href="#" target="_blank" onClick="return false">增加</a> ｜  
	<a href="#" target="_blank" onClick="return false">追加</a> ｜  
	<a href="#" target="_blank" onClick="return false">批量删除</a>
	-->
	
	</div>
	
	</s:if>

    <div class="r">
	
	<s:property value="showPage" escape="false"/>
	
	<!--
		<div class="l"><a href="./customer!queryCustomerLimit.action?curPage=1"><img src="images/blue/arrow01.gif" width="24" height="20" border="0" /></a></div>
		<div class="l"><a href="./customer!queryCustomerLimit.action?curPage=<s:property value='curPage-1'/>"><img src="images/blue/arrow02.gif" width="20" height="20" border="0" /></a></div>
		<div class="l" style="font-size:12px; margin-left:5px; margin-right:5px;">
		(<s:property value="start"/>-<s:property value="end"/> / <s:property value="count"/>)
		</div>
		<div class="l"><a href="./customer!queryCustomerLimit.action?curPage=<s:property value='curPage+1'/>"><img src="images/blue/arrow03.gif" width="20" height="20" border="0" /></a></div>
		<div class="l"><a href="./customer!queryCustomerLimit.action?curPage=<s:property value='countPage'/>"><img src="images/blue/arrow04.gif" width="24" height="20" border="0" /></a></div>
	-->
	
    </div>
    <div class="c"></div>
    </td>
    </tr>
  <tr>
    <td width="52" height="30" background="images/blue/tablebg.gif">
      <div class="tablebg01"><input name="allDel" type="checkbox" value="" onClick="allDel()" id="allDel"/></div>
      </td>

    <td width="114" align="center" valign="middle" background="images/blue/tablebg.gif">
	  <div class="l" style="margin-left:5px;">客户名称</div>
      <div class="l">
        <div><a href="customer!searchCustomer.action?ob=14"><img src="images/blue/upn.gif" width="9" height="10" border="0" /></a></div>
        <div><a href="customer!searchCustomer.action?ob=13"><img src="images/blue/downopen.gif" width="9" height="10" border="0" /></a></div>
      </div>
	 </td>
    <td width="104" align="center" valign="middle" background="images/blue/tablebg.gif"><div class="l" style="margin-left:5px;">所属用户</div>
      <div class="l">
      </div>
	 </td>
     <td width="140" align="center" valign="middle" background="images/blue/tablebg.gif"><div class="l" style="margin-left:5px;">预算总价</div>
      <div class="l">
        <div><a href="customer!searchCustomer.action?ob=16"><img src="images/blue/upn.gif" width="9" height="10" border="0" /></a></div>
        <div><a href="customer!searchCustomer.action?ob=15"><img src="images/blue/downopen.gif" width="9" height="10" border="0" /></a></div>
      </div></td>
	<td width="104" align="center" valign="middle" background="images/blue/tablebg.gif"><div class="l" style="margin-left:5px;">电话号码</div>
      <div class="l">
      </div>
	 </td>
    <td width="104" align="center" valign="middle" background="images/blue/tablebg.gif"><div class="l" style="margin-left:5px;">创建时间</div>
      <div class="l">
	  	<div><a href="customer!searchCustomer.action?ob=12"><img src="images/blue/upn.gif" width="9" height="10" border="0" /></a></div>
        <div><a href="customer!searchCustomer.action?ob=11"><img src="images/blue/downopen.gif" width="9" height="10" border="0" /></a></div>
      </div>
	  </td>
 	<td width="104" align="center" valign="middle" background="images/blue/tablebg.gif"><div class="l" style="margin-left:5px;">客户状态</div>
      <div class="l">        
      </div>
	  </td>
    <td width="29" height="30" align="center" valign="middle" background="images/blue/tablebg.gif">&nbsp;</td>
    <td width="32" align="center" valign="middle" background="images/blue/tablebg.gif">&nbsp;</td>
  </tr>
  
  
  <!-- 列表 top -->
  
  <s:iterator value="#request.customerList" id="c">  
  
	  <tr>
	    <td height="30" align="center" valign="middle"><input name="delId" type="checkbox" value="<s:property value='#c.id'/>" onClick="delId()" /></td>

		
	    <td width="114" height="30" align="left" valign="middle" class="fontblue">
	    	<a href="./customer!queryCustomerById.action?id=<s:property value='#c.id'/>" target="_self" ><s:property value="#c.customerName"/></a>

	    </td>
	    <td width="104" height="30" align="left" valign="middle">
	    	<s:property value="#c.descUserId"/>
	    </td>
	    <td width="140" height="30" align="left" valign="middle">
	    	<s:property value="#c.descPriceAmount"/>
	    </td>
		<td width="140" height="30" align="left" valign="middle">
	    	<s:property value="#c.phone"/>
	    </td>
		<td width="140" height="30" align="left" valign="middle">
			<s:date name="#c.createdTime" format="yyyy-MM-dd "/> 
	    </td>
	   <td width="140" height="30" align="left" valign="middle">
			<s:property value="#c.descCustomerState"/>
		</td>
	    <td height="30" align="center" valign="middle">&nbsp;</td>
	    <td height="30" align="center" valign="middle">&nbsp;</td>
	  </tr>
  
  </s:iterator>
  
  	
  
 
   <!-- 列表 end -->
  
        </table>

        </div>
      </div>
    </div>
	
	
	<!-- 报表,工具部分 top -->
	<!--
	
    <div class="rightnav1">
      <div class="rightboxn">
        <div class="righttitleword fontblue">报表</div>
<div class="r">
  <a href="#" target="_blank">X</a></div>
        <div class="rightlineg"></div>
        <ul>
        <li><a href="#" target="_blank">已户用客户</a></li>
<li><a href="#" target="_blank">有last活动 > 30天的客户</a></li>
<li><a href="#" target="_blank">客户所有人</a></li>
<li><a href="#" target="_blank">联系人角色报表</a></li>
<li class="fontblue"><a href="#" target="_blank">转至报表  >></a></li>
        </ul>
      </div>
    </div>
    <div class="rightnav2">
      <div class="rightboxn">
        <div class="righttitleword fontblue">工具</div>
<div class="r">
  <a href="#" target="_blank">X</a></div>
        <div class="rightlineg"></div>
        <ul>
        <li><a href="#" target="_blank">导入我的客户 &amp; 联系人</a></li>
         <li><a href="#" target="_blank">导入我的组织的客户 &amp; 联系人</a></li>  
          <li><a href="#" target="_blank">批量删除客户</a></li>
          <li><a href="#" target="_blank">转移客户</a></li>
          <li><a href="#" target="_blank">合并客户</a></li>
        </ul>
      </div>
    </div>
	
	-->
	<!-- 报表,工具部分 end -->
	
    <!--right.end--></td>
  </tr>
 
</table>

<!--main.end-->
    
  </body>
</html>
