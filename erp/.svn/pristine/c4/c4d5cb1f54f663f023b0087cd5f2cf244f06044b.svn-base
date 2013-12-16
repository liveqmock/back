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
	
	<meta http-equiv=Content-Type content="text/html; charset=utf-8" /> 
	
	<link href="css/blue_new.css"  rel="stylesheet" type="text/css" charset="utf-8"/>
	<link href="css/dialogForm.css" rel="stylesheet" type="text/css"/>	
   
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
            <div class="title01"><a href="./customer_tianluan!doSomeForAddCustomer.action" target="_self">新建客户</a></div>			
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
	<form class="registerform" action="<%=request.getContextPath() %>/customer_tianluan!updateCustomer.action" method="post" >	
			
          <div class="c"></div>
          <div class="c">
		  	 &nbsp;&nbsp;
			  <s:radio list="selCustomerState" name="customer.customerState"  value="#session.c.customerState"/> 
			  <input type="hidden" name="type" id="type" value="<s:property value='#session.loginAccount.accountType'/>"/>
			  			  
			   &nbsp;&nbsp;	
				<font color="#FF0000"><span id="suggestion"><s:property value="#request.suggestion"/></span></font>
		  	</div>
		  
		  	  
		  
           <table width="75%" border="0" align="left" cellpadding="0" cellspacing="1" class="gbox"  style="white-space: nowrap">
              <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
                <td id="t15" align="right"><font color="red">*</font>客户姓名&nbsp;</td>
                <td id="t16">
					<input type="text" name="customer.customerName" id="customerName" class="leftcreateinputbox01" maxlength="20" value="<s:property value='#session.c.customerName'/>"/>
				</td>
                <td align="right" id="t15"><font color="red">*</font>性别&nbsp;</td>
                <td id="t16">
					<s:select list="selGender"  name="customer.gender" value="#session.c.gender"/>
				</td>
                <td align="right" id="t15"><font color="red">*</font>年龄&nbsp;</td>
                <td id="t16">
				 <s:select list="selAgeRange"  name="customer.age" value="#session.c.age"/>
                </td>
              </tr>
             <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
                <td align="right" id="t13">身份证&nbsp;</td>
                <td id="t14">
					<input type="text" name="customer.idcardNo" id="idcardNo" class="leftcreateinputbox01" value="<s:property value='#session.c.idcardNo'/>"/>
				</td>
                <td align="right"  id="t13"><font color="red">*</font>联系电话A&nbsp;</td>
                <td id="t14">
					 <input type="text" id="phone" class="leftcreateinputbox01" disabled="disabled" maxlength="12" value="<s:property value='#session.c.phone'/>"/>
					 <input type="hidden" name="customer.phone" value="<s:property value='#session.c.phone'/>"/>
				</td>
                <td align="right" id="t13">联系电话B&nbsp;</td>
                <td id="t14">
					 <input type="text" id="homePhone" class="leftcreateinputbox01" disabled="disabled" maxlength="12" value="<s:property value='#session.c.homePhone'/>"/>
					 <input type="hidden" name="customer.homePhone" value="<s:property value='#session.c.homePhone'/>"/>
				</td>
              </tr>
             <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
                <td align="right" id="t11"><font color="red">*</font>从事行业&nbsp;</td>
                <td id="t12">
					<s:select list="selJobType"  name="customer.jobIndustry" value="#session.c.jobIndustry"/>
				</td>
                <td align="right" id="t11"><font color="red">*</font>行业背景描述&nbsp;</td>
                <td id="t12">
					<input type="text" name="customer.jobDesc" id="jobDesc" class="leftcreateinputbox02" style="width:auto"  value="<s:property value='#session.c.jobDesc'/>" />
				</td>
                <td align="right" id="t11"><font color="red">*</font>居住区域&nbsp;</td>
                <td id="t12">	
					 <s:select list="selCustomerRegion"  name="customer.customerRegion" value="#session.c.customerRegion"/>
				</td>
              </tr>
              <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
                <td align="right" id="t9">客户外面特征描述&nbsp;</td>
                <td id="t10">
					 <input type="text" name="customer.faceLook" id="faceLook" class="leftcreateinputbox02" style="width:auto"  value="<s:property value='#session.c.faceLook'/>"/>
				</td>
                <td align="right" id="t9"><font color="red">*</font>是否提及关系&nbsp;</td>
                <td id="t10">
					 <s:radio list="#{'1':'是','0':'否'}" name="customer.isRelation" value="#session.c.isRelation"/>
				</td>
                <td align="right" id="t9"><span id="red"></span>关系描述&nbsp;</td>
                <td id="t10">

					<s:if test="#session.c.isRelation==1">
                	<input type="text" name="customer.relationDesc" id="relationDesc" class="leftcreateinputbox02"  
                		value="<s:property value='#session.c.relationDesc'/>" style="width:auto"/>
					</s:if>
					<s:else>
						<input type="text" name="customer.relationDesc" id="relationDesc" class="leftcreateinputbox02" disabled="disabled"
							value="<s:property value='#session.c.relationDesc'/>"  style="width:auto"/>
					</s:else>
				</td>
              </tr>
              <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
                <td align="right" id="t7"><font color="red">*</font>获知途径&nbsp;</td>
                <td id="t8" colspan="5">
					 <s:checkboxlist list="selKnownFrom" name="knownFrom" value="#session.knowns"/>
				</td>
               
              </tr>
			  
			   <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
                <td align="right" id="t5"><font color="red">*</font>客户兴趣爱好&nbsp;</td>
                <td id="t6">
					 <input type="text" name="customer.interest" id="interest" class="leftcreateinputbox02" value="<s:property value='#session.c.interest'/>"/>
				</td>
				<td align="right" id="t7"><font color="red">*</font>购房目的&nbsp;</td>
                <td id="t8">
					 <s:select list="selBuyAim"  name="customer.buyAim" value="#session.c.buyAim"/>
				</td>
                <td align="right" id="t7"><font color="red">*</font>需求面积&nbsp;</td>
                <td id="t8">
					 <s:select list="selRequestArea"  name="customer.requestArea" value="#session.c.requestArea"/>
				</td>
              </tr>
			  
			  
             <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
                <td align="right" id="t5">户型需求&nbsp;</td>
                <td id="t6">
					  <s:select list="selRoomType"  name="customer.roomType" value="#session.c.roomType"/>
				</td>
                <td align="right" id="t5"><font color="red">*</font>预算总价&nbsp;</td>
                <td id="t6">
					  <s:select list="selPriceAmount"  name="customer.priceAmount" value="#session.c.priceAmount"/>
				</td>
                <td align="right" id="t5"><font color="red">*</font>购房付款方式&nbsp;</td>
                <td id="t6">
					 <s:select list="selPayType"  name="customer.payType" value="#session.c.payType"/>
				</td>
              </tr>
			  
	   <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
		<td align="right" id="t1" style="width:15%">客户对产品及项目认可方面&nbsp;</td>
		<td colspan="5">
			 <input type="text" name="customer.buyReson" id="buyReson" class="leftcreateinputbox02" style="width:80%" value="<s:property value='#session.c.buyReson'/>"/>
			 
		</td>
	  </tr>
	  
	<tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
		<td align="right" id="t3">所选单位1&nbsp;</td>
		<td id="t4" colspan="5">
			<input type="text" id="building1" name="recRoom1.building" value="<s:property value='#session.recRoom1.building'/>"/>栋
			<input type="text" id="room1" name="recRoom1.room" value="<s:property value='#session.recRoom1.room'/>"/>单元&nbsp;
			原价<input type="text" id="originalPrice1" name="recRoom1.originalPrice" value="<s:property value='#session.recRoom1.originalPrice'/>"/>万元&nbsp;
			折扣<input type="text" id="discountDesc1" name="recRoom1.discountDesc" value="<s:property value='#session.recRoom1.discountDesc'/>"/>
			<input type="hidden" name="recRoom1.id" value="<s:property value='#session.recRoom1.id'/>"/>
		</td>
		
	  </tr>
	  
	 <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
		<td align="right" id="t3">所选单位2&nbsp;</td>
		<td id="t4" colspan="5">
			<input type="text" id="building2" name="recRoom2.building" value="<s:property value='#session.recRoom2.building'/>"/>栋
			<input type="text" id="room2" name="recRoom2.room" value="<s:property value='#session.recRoom2.room'/>"/>单元&nbsp;
			原价<input type="text" id="originalPrice2" name="recRoom2.originalPrice" value="<s:property value='#session.recRoom2.originalPrice'/>"/>万元&nbsp;
			折扣<input type="text" id="discountDesc2" name="recRoom2.discountDesc" value="<s:property value='#session.recRoom2.discountDesc'/>"/>
			<input type="hidden" name="recRoom2.id" value="<s:property value='#session.recRoom2.id'/>"/>
		</td>
	  </tr>
	  
	  <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
		<td align="right" id="t3">所选单位3&nbsp;</td>
		<td id="t4" colspan="5">
			<input type="text" id="building3" name="recRoom3.building" value="<s:property value='#session.recRoom3.building'/>"/>栋
			<input type="text" id="room3" name="recRoom3.room" value="<s:property value='#session.recRoom3.room'/>"/>单元&nbsp;
			原价<input type="text" id="originalPrice3" name="recRoom3.originalPrice" value="<s:property value='#session.recRoom3.originalPrice'/>"/>万元&nbsp;
			折扣<input type="text" id="discountDesc3" name="recRoom3.discountDesc" value="<s:property value='#session.recRoom3.discountDesc'/>"/>
			<input type="hidden" name="recRoom3.id" value="<s:property value='#session.recRoom3.id'/>"/>
		</td>
	  </tr>
	  
	   <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
		<td align="right" id="t1" style="width:15%"><font color="red">*</font>客户购买抗性&nbsp;</td>
		<td colspan="5">
			 <textarea id="notBuyReson" name="customer.notBuyReson" rows="3" cols="30"><s:property value='#session.c.notBuyReson'/></textarea>
		</td>
	  </tr>
	  
	   <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
		<td align="right" id="t1" style="width:15%"><font color="red">*</font>备注&nbsp;</td>
		<td colspan="5">
			 <input type="text" name="customer.remark1" id="remark1" class="leftcreateinputbox02" style="width:80%" value="<s:property value='#session.c.remark1'/>"/>
		</td>
	  </tr>
	  
	   <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
		<td align="right" id="t1" style="width:15%"><font color="red">*</font>首次到场日期&nbsp;</td>
		<td>
			<input type="text" class="Wdate" onClick="WdatePicker()" id="firstDate" name="customer.firstDate" 
						value="<s:property value='#session.c.firstDate'/>" />
		</td>
		<td align="right">
			<font color="red">*</font>首次到场时间&nbsp;
		</td>
		<td colspan="3">
			 <s:select list="selFirstHour"  name="customer.firstHour" value="#session.c.firstHour"/>
		</td>
	  </tr>
	  
	  
	  <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF"; align="center">
		<td colspan="6">
		 <input type="hidden" name="customer.id" value="<s:property value='#session.c.id'/>"/>
		  
		  <input type="submit" value="  保存  " id="sub"
		  	<s:if test="(#session.c.customerState == 2 || #session.c.customerState == 3) && #session.loginAccount.accountType != 2"> 
		  	disabled="disabled"
		  	</s:if>
		  />
		  
			&nbsp;&nbsp;
		  <input type="button" value="  取消  " onClick="javascript:window.location.href = './customer_tianluan!searchCustomer.action?from=return'" />
		  &nbsp;&nbsp;
		  
		  <input type="button" value="  跟进  " id="follow" ac="customer_tianluan"
				<s:if test="#session.c.customerState == 2 || #session.c.customerState == 3"> 
			  	disabled="disabled"
			  </s:if>
			/>

		 </td>
	  </tr>
	  
	  <!-- follow top -->
	   <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
		<td align="left" id="t4">跟进类型&nbsp;</td>
		<td align="left" id="t4">跟进人&nbsp;</td>		
		<td align="left" id="t4">跟进日期&nbsp;</td>
		<td align="left" id="t4" colspan="3">跟进内容&nbsp;</td>
	  </tr>
	  
	  <s:iterator value="#request.session.follows" id="f">	
		   <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
			<td id="t4"><s:property value="#f.descFollowType"/></td>
			<td id="t4"><s:property value="#f.descUserId"/></td>		
			<td id="t4"><s:date name="#f.createdTime" format="yyyy-MM-dd "/></td>
			<td id="t4" colspan="3"><s:property value="#f.followDesc"/></td>
		  </tr>
	  </s:iterator>
	  
	   <!-- follow end -->
	  
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
