<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags"%>

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
	<meta http-equiv="content-type" content="text/html; charset=utf-8" /> 
	
  </head>
  
  <body onLoad="clearSuggestion()">
   
   
<!--main-->
<table width="100%" border="0" align="center" cellpadding="0" cellspacing="1">
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
		
        	
	        <div class="title01" ><a href="./customer_huijing!searchCustomer.action?from=left" target="_self">查询客户</a></div>
            <div class="title02"><a href="./customer_huijing!doSomeForAddCustomer.action?from=huijing" target="_self">新建客户</a></div>			
			 
			<div class="right99"></div>
			<div class="blueline"></div>
			<!--
            <div class="title02" style="display:none;"><a href="#">录入</a></div>
            <div class="title01"><a href="#">录入2</a></div>
            <div class="title02" style="display:none;"><a href="#">录入</a></div>
            <div class="title01"><a href="#">录入3</a></div>
            <div class="title02" style="display:none;"><a href="#">录入</a></div>
            <div class="title01"><a href="#">录入4</a></div>
            <div class="title02" style="display:none;"><a href="#">录入</a></div>
			-->
		
		
		<!-- right form top -->
	<form class="registerform" action="<%=request.getContextPath() %>/customer_huijing!addCustomer.action" method="post" >	
			
          <div class="c"></div>
          <div class="c">
		  	 &nbsp;&nbsp;	
			<font color="#FF0000"><span id="suggestion"><s:property value="#session.suggestion"/></span></font>
		  </div>
		  
		  	  
		  
           <table style="white-space: nowrap" width="75%" border="0" align="left" cellpadding="0" cellspacing="1" class="gbox" >
		   
		   	<tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
                <td id="t15" align="right">跟进人员&nbsp;</td>
                <td id="t16">
                	<s:if test="#session.loginAccount.accountType == 2 ">
                		<s:select list="#session.selUser"  name="customer.userId"/>
                	</s:if>
                	<s:else>
                		<input type="text" value="<s:property value='#session.user.realName'/>" disabled="disabled"/>
						<input type="hidden" value="<s:property value='#session.user.id'/>" name="customer.userId"/>
                	</s:else>                	
					
				</td>
                <td id="t15" align="right">日期&nbsp;</td>
                <td id="t16">
					<input type="text" class="Wdate" onClick="WdatePicker()" id="createdTime" name="customer.createdTime" value="${now}"/>
				</td>
                <td id="t15" colspan="2"></td>				
              </tr>
		   
              <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
                <td align="right" id="t15"><font color="red">*</font>客户姓名&nbsp;</td>
                <td id="t16">
					<input type="text" name="customer.customerName" id="customerName" class="leftcreateinputbox01" maxlength="20"/>
				</td>
                <td align="right" id="t15"><font color="red">*</font>性别&nbsp;</td>
                <td id="t16">
					<s:select list="selGender"  name="customer.gender" value="%{customer.gender}" />
				</td>
                <td align="right" id="t15">客户国籍&nbsp;</td>
                <td id="t16">
					<input type="text" id="nationality" name="customer.nationality" class="leftcreateinputbox01"/>
                </td>
              </tr>
			  
			  
             <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
                <td align="right"  id="t13">移动电话&nbsp;</td>
                <td id="t14">
					<input type="text" id="phone" name="customer.phone" class="leftcreateinputbox01"/>
				</td>
                <td align="right" id="t13">固定电话&nbsp;</td>
                <td id="t14">
					 <input type="text" id="homePhone" name="customer.homePhone" class="leftcreateinputbox01" maxlength="12"/>
				</td>
                <td align="right" id="t13">电子邮件&nbsp;</td>
                <td id="t14">
					<input type="text" name="customer.email" class="leftcreateinputbox01"/>
				</td>
              </tr>
			  
             <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
                <td align="right" id="t11">客户现居住地点&nbsp;</td>
                <td id="t12">
					<input type="text" name="customer.address" class="leftcreateinputbox02" style="width:auto"/>
				</td>
                <td align="right" id="t11">同行人数&nbsp;</td>
                <td id="t12">
					<input type="text" name="customer.peerNumber" id="peerNumber" class="leftcreateinputbox02" style="width:auto"/>
				</td>
                <td align="right" id="t11">是否首次到场&nbsp;</td>
                <td id="t12">	
					<input name="customer.isFirst" type="radio" value="1"/>是
					<input name="customer.isFirst" type="radio" value="0" />否
				</td>
              </tr>
			  
              <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
                 <td align="right" id="t11">是否业主&nbsp;</td>
                 <td id="t12">	
					 <input name="customer.isOwner" type="radio" value="1"/>是
					<input name="customer.isOwner" type="radio" value="0" />否
				</td>
                <td align="right" id="t9">是否提及关系户&nbsp;</td>
                <td id="t10">
					<input name="customer.isRelation" type="radio" value="1" id="yes"/>是
					<input name="customer.isRelation" type="radio" value="0" id="no"/>否
				</td>
                <td align="right" id="t9"><span id="red"></span>关系描述&nbsp;</td>
                <td id="t10">
					<input type="text" name="customer.relationDesc" id="relationDesc" class="leftcreateinputbox02" style="width:auto"/>
				</td>
              </tr>
			  
			   <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
                <td align="right" id="t11">公司名称&nbsp;</td>
                <td id="t12">
					<input type="text" name="customer.workUnit" class="leftcreateinputbox02" style="width:auto"/>
				</td>
                <td align="right" id="t11">意向租期&nbsp;</td>
                <td id="t12">
					<s:select list="selIntentLease"  name="customer.intentLease" value="%{customer.intentLease}" />
				</td>
                <td align="right" id="t11">租金支付&nbsp;</td>
                <td id="t12">	
					<s:select list="selPayBy"  name="customer.payBy" value="%{customer.payBy}" />
				</td>
              </tr>
			  
              <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
                <td align="right" id="t7">客户背景&nbsp;</td>
                <td id="t8" colspan="5">
					 <input type="text" name="customer.background" id="background" style="width:80%"/>
					 
				</td>
               
              </tr>
			  
			   <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
                 <td align="right" id="t7">需求面积&nbsp;</td>
                 <td id="t8">
					 <s:select list="selRequestArea"  name="customer.requestArea"/>
				</td>
				<td align="right"  id="t7">租金预算&nbsp;</td>
                <td id="t8">
					 <s:select list="selPriceAmount"  name="customer.priceAmount"/>
				</td>
                <td id="t7" colspan="2"></td>
              </tr>
			  
           
	   <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
		<td align="right"  id="t1" style="width:15%">影响客户租赁的原因&nbsp;</td>
		<td colspan="5">
			 <input type="text" name="customer.buyReson" id="buyReson" class="leftcreateinputbox02" style="width:80%"/>
		</td>
	  </tr>
	  
	   <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
			<td align="right"  id="t7">意向单元&nbsp;</td>
			<td id="t8" colspan="5">				
				<s:radio list="selIntentionPart" name="customer.intentionPart" value="%{customer.selIntentionPart}"/>
			</td>
		   
		  </tr>
		  
		  <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
			<td align="right"  id="t7"><font color="red">*</font>客户初步评价&nbsp;</td>
			<td id="t8" colspan="5">
				
				<s:radio list="selRating" name="customer.rating" value="%{customer.selRating}"/>
				<input type="text" name="customer.ratingRemark" id="ratingRemark"/>
			</td>
		   
		  </tr>
	  
	<tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
		<td align="right"  id="t1" style="width:15%">备注1&nbsp;</td>
		<td colspan="5">
			 <input type="text" name="customer.remark1" id="remark1" class="leftcreateinputbox02" style="width:80%"/>
		</td>
	  </tr>
	  
	<tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
		<td align="right"  id="t1" style="width:15%">备注2&nbsp;</td>
		<td colspan="5">
			 <input type="text" name="customer.remark2" id="remark2" class="leftcreateinputbox02" style="width:80%"/>
		</td>
	  </tr>	 
	  
	  <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
		<td align="right"  id="t1" style="width:15%">备注3&nbsp;</td>
		<td colspan="5">
			 <input type="text" name="customer.remark3" id="remark3" class="leftcreateinputbox02" style="width:80%"/>
		</td>
	  </tr>
	  
	   <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
		<td  align="right" id="t1" style="width:15%">备注4&nbsp;</td>
		<td colspan="5">
			 <input type="text" name="customer.remark4" id="remark4" class="leftcreateinputbox02" style="width:80%"/>
		</td>
	  </tr>
	  
	   <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
                <td  align="right" id="t11">经办人&nbsp;</td>
                <td id="t12">
					<input type="text" value="<s:property value='#session.user.realName'/>" disabled="disabled"/>
					<input type="hidden" name="customer.createdId" value="<s:property value='#session.user.id'/>" />
				</td>
                <td id="t11" colspan="4"></td>
              </tr>
	  
	  
	  <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF"; align="center">
		<td colspan="6">
		  <input type="submit" value="  保存  " id="sub"/>
			&nbsp;&nbsp;
		  <input type="button" value="  取消  " onClick="javascript:window.location.href = './customer_huijing!searchCustomer.action'" />
		  &nbsp;&nbsp;

		 </td>
	  </tr>
	  </table>
	  
	  </form>
	  
	  
			  <div class="c"></div>
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
