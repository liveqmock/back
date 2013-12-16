<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page contentType="text/html;charset=utf-8" %>
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
	
	<link href="css/blue_new.css"  rel="stylesheet" type="text/css" charset="utf-8"/>
	<meta http-equiv=Content-Type content="text/html; charset=utf-8" /> 
	
	
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
		
        	
	        <div class="title01" ><a href="./customer_tianluan!searchCustomer.action?from=left" target="_self">查询客户</a></div>
            <div class="title02"><a href="./customer_tianluan!doSomeForAddCustomer.action" target="_self">新建客户</a></div>			
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
	<form class="registerform" action="<%=request.getContextPath() %>/customer_tianluan!addCustomer.action" method="post" >	
			
          <div class="c"></div>
          <div class="c">
		  	 &nbsp;&nbsp;
			 <s:radio list="selCustomerState" name="customer.customerState" value="1"/>
			  &nbsp;&nbsp;	
			<font color="#FF0000"><span id="suggestion"><s:property value="#request.session.suggestion"/></span></font>
		  </div>
		  
		  	  
		  
           <table width="75%" border="0" align="left" cellpadding="0" cellspacing="1" class="gbox" style="white-space: nowrap">
              <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
                <td id="t15" align="right"><font color="red">*</font>客户姓名&nbsp;</td>
                <td id="t16">
					<input type="text" name="customer.customerName" id="customerName" class="leftcreateinputbox01" maxlength="20"/>
				</td>
                <td id="t15"  align="right"><font color="red">*</font>性别&nbsp;</td>
                <td id="t16">
					<s:select list="selGender"  name="customer.gender" value="%{customer.gender}" />
				</td>
                <td id="t15"  align="right"><font color="red">*</font>年龄&nbsp;</td>
                <td id="t16">
				 <s:select list="selAgeRange"  name="customer.age" value="%{customer.age}" />
                </td>
              </tr>
             <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
                <td id="t13"  align="right">身份证&nbsp;</td>
                <td id="t14">
					<input type="text" name="customer.idcardNo" id="idcardNo" class="leftcreateinputbox01"/>
				</td>
                <td id="t13"  align="right"><font color="red">*</font>联系电话A&nbsp;</td>
                <td id="t14">
					 <input type="text" id="phone" name="customer.phone" class="leftcreateinputbox01" maxlength="12" ac="customer_tianluan"/>
				</td>
                <td id="t13"  align="right">联系电话B&nbsp;</td>
                <td id="t14">
					<input type="text" id="homePhone" name="customer.homePhone" class="leftcreateinputbox01"/>
				</td>
              </tr>
             <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
                <td id="t11"  align="right"><font color="red">*</font>从事行业&nbsp;</td>
                <td id="t12">
					<s:select list="selJobType"  name="customer.jobIndustry" value="%{customer.jobIndustry}" />
				</td>
                <td id="t11"  align="right"><font color="red">*</font>行业背景描述&nbsp;</td>
                <td id="t12">
					<input type="text" name="customer.jobDesc" id="jobDesc" class="leftcreateinputbox02" style="width:auto"/>
				</td>
                <td id="t11"  align="right"><font color="red">*</font>居住区域&nbsp;</td>
                <td id="t12">	
					 <s:select list="selCustomerRegion"  name="customer.customerRegion" value="%{customer.customerRegion}" />
				</td>
              </tr>
              <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
                <td id="t9"  align="right">客户外貌特征描述&nbsp;</td>
                <td id="t10">
					 <input type="text" name="customer.faceLook" id="faceLook" class="leftcreateinputbox02" style="width:auto"/>
				</td>
                <td id="t9"  align="right"><font color="red">*</font>是否提及关系&nbsp;</td>
                <td id="t10">
					<input name="customer.isRelation" type="radio" value="1" id="yes"/>是
					<input name="customer.isRelation" type="radio" value="0" id="no"/>否
				</td>
                <td id="t9"  align="right"><span id="red"></span>关系描述&nbsp;</td>
                <td id="t10">
					<input type="text" name="customer.relationDesc" id="relationDesc" class="leftcreateinputbox02" style="width:auto"/>
				</td>
              </tr>
              <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
                <td id="t7"  align="right"><font color="red">*</font>获知途径&nbsp;</td>
                <td id="t8" colspan="5">
					 <s:checkboxlist list="selKnownFrom" name="knownFrom" value="%{customer.knownFrom}"/>
				</td>
               
              </tr>
			  
			   <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
                <td id="t5"  align="right"><font color="red">*</font>客户兴趣爱好&nbsp;</td>
                <td id="t6">
					<input type="text" name="customer.interest" id="interest" class="leftcreateinputbox02" />
				</td>
				<td id="t7"  align="right"><font color="red">*</font>购房目的&nbsp;</td>
                <td id="t8">
					<s:select list="selBuyAim"  name="customer.buyAim" value="%{customer.buyAim}" />
				</td>
                <td id="t7"  align="right"><font color="red">*</font>需求面积&nbsp;</td>
                <td id="t8">
					 <s:select list="selRequestArea"  name="customer.requestArea" value="%{customer.requestArea}" />
				</td>
              </tr>
			  
			  
             <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
                <td id="t5"  align="right">户型需求&nbsp;</td>
                <td id="t6">
					 <s:select list="selRoomType"  name="customer.roomType" value="%{customer.roomType}" />
				</td>
                <td id="t5"  align="right"><font color="red">*</font>预算总价&nbsp;</td>
                <td id="t6">
					 <s:select list="selPriceAmount"  name="customer.priceAmount" value="%{customer.priceAmount}" />
				</td>
                <td id="t5"  align="right"><font color="red">*</font>购房付款方式&nbsp;</td>
                <td id="t6">
					<s:select list="selPayType"  name="customer.payType" value="%{customer.payType}" />
				</td>
              </tr>
			  
	   <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
		<td id="t1" style="width:15%"  align="right">客户对产品及项目认可方面&nbsp;</td>
		<td colspan="5">
			 <input type="text" name="customer.buyReson" id="buyReson" class="leftcreateinputbox02" style="width:80%"/>
		</td>
	  </tr>
	  
	<tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
		<td id="t3"  align="right" >所选单位1&nbsp;</td>
		<td id="t4" colspan="5">
			<input type="text" id="building1" name="recRoom1.building"/>栋
			<input type="text" id="room1" name="recRoom1.room"/>单元&nbsp;&nbsp;
			原价<input type="text" id="originalPrice1" name="recRoom1.originalPrice"/>万元&nbsp;&nbsp;
			折扣<input type="text" id="discountDesc1" name="recRoom1.discountDesc"/>
		</td>
		
	  </tr>
	  
	 <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
		<td id="t3"  align="right">所选单位2&nbsp;</td>
		<td id="t4" colspan="5">
			<input type="text" id="building2" name="recRoom2.building"/>栋
			<input type="text" id="room2" name="recRoom2.room"/>单元&nbsp;&nbsp;
			原价<input type="text" id="originalPrice2" name="recRoom2.originalPrice"/>万元&nbsp;&nbsp;
			折扣<input type="text" id="discountDesc2" name="recRoom2.discountDesc"/>
		</td>
	  </tr>
	  
	  <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
		<td id="t3"  align="right">所选单位3&nbsp;</td>
		<td id="t4" colspan="5">
			<input type="text" id="building3" name="recRoom3.building"/>栋
			<input type="text" id="room3" name="recRoom3.room"/>单元&nbsp;&nbsp;
			原价<input type="text" id="originalPrice3" name="recRoom3.originalPrice"/>万元&nbsp;&nbsp;
			折扣<input type="text" id="discountDesc3" name="recRoom3.discountDesc"/>
		</td>
	  </tr>
	  
	   <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
		<td id="t1" style="width:15%"  align="right"><font color="red">*</font>客户购买抗性&nbsp;</td>
		<td colspan="5">
			 <textarea id="notBuyReson" name="customer.notBuyReson" rows="3" cols="30"></textarea>
		</td>
	  </tr>
	  
	   <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
		<td id="t1" style="width:15%"  align="right"><font color="red">*</font>备注&nbsp;</td>
		<td colspan="5">
			 <input type="text" name="customer.remark1" id="remark1" class="leftcreateinputbox02" style="width:80%"/>
		</td>
	  </tr>
	  
	   <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
		<td id="t1" style="width:15%"  align="right"><font color="red">*</font>首次到场日期&nbsp;</td>
		<td>
		 	<input class="Wdate" type="text" id="firstDate" name="customer.firstDate" value="${customer.firstDate}" onClick="WdatePicker()"/>
		</td>
		<td  align="right">
			<font color="red">*</font>首次到场时间&nbsp;
		</td>
		<td colspan="3">
			 <s:select list="selFirstHour"  name="customer.firstHour" value="%{customer.firstHour}" />
		</td>
	  </tr>
	  
	  
	  <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF"; align="center">
		<td colspan="6">
		  <input type="submit" value="  保存  " id="sub"/>
			&nbsp;&nbsp;
		  <input type="button" value="  取消  " onClick="javascript:window.location.href = './customer_tianluan!searchCustomer.action'" />
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
