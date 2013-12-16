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
		
        	
	        <div class="title01" ><a href="./customer_shanshui!searchCustomer.action?from=left" target="_self">查询客户</a></div>
            <div class="title01"><a href="./customer_shanshui!doSomeForAddCustomer.action?from=huijing" target="_self">新建客户</a></div>			
			 <div class="right99"></div>
			<div class="blueline"></div>
			<%-- 
            <div class="title02" style="display:none;"><a href="#">录入</a></div>
            <div class="title01"><a href="#">录入2</a></div>
            <div class="title02" style="display:none;"><a href="#">录入</a></div>
            <div class="title01"><a href="#">录入3</a></div>
            <div class="title02" style="display:none;"><a href="#">录入</a></div>
            <div class="title01"><a href="#">录入4</a></div>
            <div class="title02" style="display:none;"><a href="#">录入</a></div>
			--%>
		
		
		<!-- right form top -->
	<form class="registerform" action="<%=request.getContextPath() %>/customer_shanshui!updateCustomer.action" method="post" >	
			
          <div class="c"></div>
          <div class="c">
		  	 &nbsp;&nbsp;	
			<font color="#FF0000"><span id="suggestion"><s:property value="#session.suggestion"/></span></font>
			
		  </div>
		  
		  	  
		  
           <table style="white-space: nowrap" width="75%" border="0" align="left" cellpadding="0" cellspacing="1" class="gbox" >
		   
		   	<tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
                <td width="15%" id="t15" align="right">销售人员&nbsp;</td>
                <td width="33%" id="t16">
                	<s:if test="#session.loginAccount.accountType == 2 ">
                		<s:select list="#session.selUser"  name="customer.userId" value="#session.c.userId"/>
                	</s:if>
                	<s:else>
                		<input type="text" value="<s:property value='#session.user.realName'/>" disabled="disabled"/>
						<input type="hidden" value="<s:property value='#session.user.id'/>" name="customer.userId"/>
                	</s:else>                   	
					
				</td>
                <td width="24%" id="t15" align="right">日期&nbsp;</td>
                <td width="28%" id="t16">
					<input type="text" class="Wdate" onClick="WdatePicker()" id="createdTime"
						value="<s:date name='#session.c.createdTime' format='yyyy-MM-dd'/> " />
				</td>                		
              </tr>
		   
              <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
                <td id="t15" align="right"><font color="red">*</font>客户姓名&nbsp;</td>
                <td id="t16">
					<input type="text" name="customer.customerName" id="customerName" class="leftcreateinputbox01" maxlength="20" value="${session.c.customerName}"/>
				</td>
                <td id="t15" align="right"><font color="red">*</font>性别&nbsp;</td>
                <td id="t16">
					<s:select list="selGender"  name="customer.gender" value="#session.c.gender"/>
				</td>
               
              </tr>
			  
			  
             <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
                <td id="t13" align="right">移动电话&nbsp;</td>
                <td id="t14"><input type="text" id="phone" name="customer.phone" class="leftcreateinputbox01" value="${session.c.phone}"/></td>
                <td id="t13" align="right">固定电话&nbsp;</td>
                <td id="t14"><input type="text" id="homePhone" name="customer.homePhone" class="leftcreateinputbox01" maxlength="12" value="${session.c.homePhone}"/></td>
               
              </tr>
			  
			   <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
                <td id="t13" align="right">电子邮件&nbsp;</td>
                <td id="t14"><input type="text" name="customer.email" class="leftcreateinputbox01" value="${session.c.email}"/></td>
                <td id="t13" align="right"></td>
                <td id="t14">&nbsp;</td>
               
              </tr>
			  
             <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
                <td id="t11" align="right">同行人数&nbsp;</td>
                <td id="t12"><input type="text" name="customer.peerNumber" class="leftcreateinputbox02" style="width:auto"  value="${session.c.peerNumber}"/></td>
                <td id="t11" align="right">是否首次到场:</td>
                <td id="t12">
					<s:radio list="#{'1':'是','0':'否'}" name="customer.isFirst" value="#session.c.isFirst"/>
				</td>
               
              </tr>
              <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
                 <td id="t11" align="right">是否提及关系户&nbsp;</td>
                 <td id="t12">	
					<s:radio list="#{'1':'是','0':'否'}" name="customer.isRelation" value="#session.c.isRelation"/>
					
					<s:if test="#session.c.isRelation == 1">
						<input type="text" name="customer.relationDesc" id="relationDesc" class="leftcreateinputbox02"  
							value="<s:property value='#session.c.relationDesc'/>" style="width:auto" />
                	</s:if>
					<s:else>
						<input type="text" name="customer.relationDesc" id="relationDesc" class="leftcreateinputbox02" disabled="disabled"
							value="<s:property value='#session.c.relationDesc'/>" style="width:auto"/>
					</s:else>
				</td>
                <td id="t9" align="right">是否业主&nbsp;</td>
                <td id="t10">
					<s:radio list="#{'1':'是','0':'否'}" name="customer.isOwner" value="#session.c.isOwner"/>
				</td>
                
              </tr>
              <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
                <td id="t7" align="right">客户背景&nbsp;</td>
                <td id="t8" colspan="3">
					<input type="text" name="customer.background" id="background" style="width:80%"  value="${session.c.background}"/>
				</td>
               
              </tr>
			  
			   <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
                 <td id="t7" align="right">需求面积:</td>
                 <td id="t8">
					<s:select list="selRequestArea"  name="customer.requestArea" value="#session.c.requestArea"/>
				</td>
				<td id="t7" align="right">投资额度&nbsp;</td>
                <td id="t8">
					 <s:select list="selPriceAmount"  name="customer.priceAmount" value="#session.c.priceAmount"/>
				</td>               
              </tr>
			  
           
	   <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
		<td id="t1" style="width:15%" align="right">影响客户购买的原因&nbsp;</td>
		<td colspan="3">
			  <input type="text" name="customer.buyReson" id="buyReson" class="leftcreateinputbox02" style="width:80%" value="${session.c.buyReson}"/>
		</td>
	  </tr>
	  
	   <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
			<td id="t7" align="right">意向区域&nbsp;</td>
			<td id="t8" colspan="3">				
				<s:radio list="selIntentionPart" name="customer.intentionPart" value="#session.c.intentionPart"/>
			</td>
		   
		  </tr>
		  
		  <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
			<td id="t7" align="right"><font color="red">*</font>客户初步评级&nbsp;</td>
			<td id="t8" colspan="3">
				
				<s:radio list="selRating" name="customer.rating" value="#session.c.rating"/>
				<input type="text" name="customer.ratingRemark" id="ratingRemark" value="${session.c.ratingRemark}"/>
			</td>
		   
		  </tr>
	  
	<tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
		<td id="t1" style="width:15%" align="right">备注1&nbsp;</td>
		<td colspan="3">
			<input type="text" name="customer.remark1" id="remark1" class="leftcreateinputbox02" style="width:80%" value="${session.c.remark1}"/>
		</td>
	  </tr>
	  
	<tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
		<td id="t1" style="width:15%" align="right">备注2&nbsp;</td>
		<td colspan="3">
			 <input type="text" name="customer.remark2" id="remark2" class="leftcreateinputbox02" style="width:80%" value="${session.c.remark2}"/>
		</td>
	  </tr>	 
	  
	  <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
		<td id="t1" style="width:15%" align="right">备注3&nbsp;</td>
		<td colspan="3">
			 <input type="text" name="customer.remark3" id="remark3" class="leftcreateinputbox02" style="width:80%" value="${session.c.remark3}"/>
		</td>
	  </tr>
	  
	   <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
		<td id="t1" style="width:15%" align="right">备注4&nbsp;</td>
		<td colspan="3">
			 <input type="text" name="customer.remark4" id="remark4" class="leftcreateinputbox02" style="width:80%" value="${session.c.remark4}"/>
		</td>
	  </tr>
	  
	   <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
		<td id="t11" align="right">经办人</td>
		<td id="t12">
			<input type="text" value="<s:property value='#session.user.realName'/>" disabled="disabled"/>
			<input type="hidden" name="customer.createdId" value="<s:property value='#session.user.id'/>" />
		</td>
		<td id="t11" colspan="2"></td>
	  </tr>
	  
	  
	  <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF"; align="center">
		<td colspan="4">
		  <input type="hidden" name="customer.id" value="<s:property value='#session.c.id'/>"/>
		  <input type="submit" value="  保存  " id="sub"/>
			&nbsp;&nbsp;
		  <input type="button" value="  取消  " onClick="javascript:window.location.href = './customer_shanshui!searchCustomer.action?from=return'" />
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
