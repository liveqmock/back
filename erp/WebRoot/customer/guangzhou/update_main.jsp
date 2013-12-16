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
	<link href="css/dialogForm.css" rel="stylesheet" type="text/css"/>	
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
		
        	
	        <div class="title01" ><a href="./customer_guangzhou!searchCustomer.action?from=left" target="_self">查询客户</a></div>
            <div class="title01"><a href="./customer_guangzhou!doSomeForAddCustomer.action" target="_self">新建客户</a></div>			
			 <div class="right99"></div>
			<div class="blueline"></div>
			
			
		
		<!-- right form top -->
	<form class="registerform" action="<%=request.getContextPath() %>/customer_guangzhou!updateCustomer.action" method="post" >	
			
          <div class="c"></div>
          <div class="c">
			  &nbsp;&nbsp;	
			<font color="#FF0000"><span id="suggestion"><s:property value="#request.session.suggestion"/></span></font>
		  </div>
		  
		  

           <table width="98%" border="0" align="left" cellpadding="0" cellspacing="1" class="gbox" style="white-space: nowrap">
		   		
			 <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
			 	<td colspan="6">&nbsp;&nbsp;必填</td>
			 </tr>
		   
              <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
                <td id="t15" style="width:15%" align="right"><font color="red">*</font>客户姓名&nbsp;</td>
                <td id="t16">
				<input type="text" name="customer.customerName" id="customerName" class="leftcreateinputbox01" maxlength="20" value="<s:property value='#session.c.customerName'/>"/>
				</td>
                 <td id="t13" style="width:15%" align="right"><font color="red">*</font>固定电话&nbsp;</td>
                <td id="t14">
					 <input type="text" id="homePhone" name="customer.homePhone" class="leftcreateinputbox01" value="<s:property value='#session.c.homePhone'/>"/>
				</td>
                <td id="t15" style="width:15%" align="right"><font color="red">*</font>移动电话&nbsp;</td>
                <td id="t16">
				 <input type="text" id="phone" name="customer.phone" class="leftcreateinputbox01" maxlength="12" value="<s:property value='#session.c.phone'/>"/>
				 </td>
              </tr>
             <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
                <td id="t13"  align="right"><font color="red">*</font>居住区域&nbsp;</td>
                <td colspan="5">
					<s:select list="selProvince"  name="customer.homeProvince" value="#session.c.homeProvince"/>省
					<s:select list="selHomeCity"  name="customer.homeCity" value="#session.c.homeCity"/>市
					<s:select list="selHomeRegion"  name="customer.homeRegion" value="#session.c.homeRegion"/>
				</td>
               </tr>
			  
			  <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
                <td id="t13"  align="right"><font color="red">*</font>工作区域&nbsp;</td>
                <td colspan="5">
					<s:select list="selProvince"  name="customer.workProvince" value="#session.c.workProvince"/>省
					<s:select list="selWorkCity"  name="customer.workCity" value="#session.c.workCity"/>市
					<s:select list="selWorkRegion"  name="customer.workRegion" value="#session.c.workRegion"/>
				</td>
              </tr>
			  
             <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
                <td id="t11"  align="right"><font color="red">*</font>购房用途&nbsp;</td>
                <td id="t12">
					<s:select list="selBuyUse"  name="customer.buyUse" value="#session.c.buyUse"/>
				</td>
                <td id="t11"  align="right"><font color="red">*</font>置业次数&nbsp;</td>
                <td id="t12">
					<s:select list="selBuyCount"  name="customer.buyCount" value="#session.c.buyCount"/>
				</td>
                <td id="t11" style="width:15%" align="right"><font color="red">*</font>意向总价&nbsp;</td>
                <td id="t12">	
					<s:select list="selPriceAmount"  name="customer.priceAmount" value="#session.c.priceAmount"/>			</td>
              </tr>
			  
			  <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
                <td id="t11"  align="right"><font color="red">*</font>产品类型&nbsp;</td>
                <td id="t12">
					<s:select list="selHouseType"  name="customer.houseType" value="#session.c.houseType"/>				</td>
                <td id="t11"  align="right"><font color="red">*</font>客户来源&nbsp;</td>
                <td id="t12">	
					<s:select list="selCustomerSource"  name="customer.customerSource" value="#session.c.customerSource"/>				</td>
                <td id="t11"  align="right"><font color="red">*</font>负责人&nbsp;</td>
                <td id="t12">
					
					<span><s:property value='#session.c.managerName'/></span>
					<input type="hidden" name="customer.managerId" value="<s:property value='#session.c.managerId'/>" />		
				</td>
              </tr>
			  
			 
			  <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
			 	<td colspan="6">&nbsp;&nbsp;选填(<a href="#" onClick="return false;" id="showOrHide"><font color="#1199FF">点击可以隐藏/显示</font></a>)</td>
			 </tr>
			  
			 
              <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" id="change1">
                <td id="t9" style="width:15%" align="right">来访次数&nbsp;</td>
                <td id="t10">
					<s:select list="selVisitCount"  name="customer.visitCount" value="#session.c.visitCount"/>				</td>
                <td id="t9" style="width:15%" align="right">性别&nbsp;</td>
                <td id="t10">
					<s:select list="selGender"  name="customer.gender" value="#session.c.gender"/>				</td>
                <td id="t9"  align="right">国籍&nbsp;</td>
                <td id="t10">
					<input type="text" name="customer.nationality" id="nationality" class="leftcreateinputbox01" value="<s:property value='#session.c.nationality'/>"/>				</td>
              </tr>
              
			  <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
                <td id="t9"  align="right">身份证号码&nbsp;</td>
                <td id="t10">
					<input type="text" name="customer.idcardNo" id="idcardNo" class="leftcreateinputbox02" style="width:auto" value="<s:property value='#session.c.idcardNo'/>"/>				</td>
                <td id="t9"  align="right">驾车车型&nbsp;</td>
                <td id="t10">
					<input type="text" name="customer.trafficDesc" id="trafficDesc" class="leftcreateinputbox02" style="width:auto" value="<s:property value='#session.c.trafficDesc'/>"/>				</td>
                <td id="t9"  align="right">年龄&nbsp;</td>
                <td id="t10">
					<s:select list="selAgeRange"  name="customer.age" value="#session.c.age"/>				</td>
              </tr>
			  
			   <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
                <td id="t5"  align="right">地址&nbsp;</td>
                <td colspan="3">
					<input type="text" name="customer.address" id="address" class="leftcreateinputbox02" style="width:80%" value="<s:property value='#session.c.address'/>"/>				</td>
                <td id="t7"  align="right">邮编&nbsp;</td>
                <td id="t8">
					<input type="text" name="customer.postcode" id="postcode" class="leftcreateinputbox01" value="<s:property value='#session.c.postcode'/>"/>				</td>
              </tr>
			  
			  
             <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
                <td id="t5"  align="right">家庭结构&nbsp;</td>
                <td id="t6">
					<s:select list="selFamilyType"  name="customer.familyType" value="#session.c.familyType"/>				</td>
                <td id="t5"  align="right">家庭收入&nbsp;</td>
                <td id="t6">
					<s:select list="selFamilyIncome"  name="customer.familyIncome" value="#session.c.familyIncome"/>				</td>
                <td id="t5"  align="right">&nbsp;</td>
                <td id="t6">				</td>
              </tr>
			  
			  <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
                <td id="t5"  align="right">行业结构&nbsp;</td>
                <td id="t6">
					<s:select list="selJobType"  name="customer.jobType" value="#session.c.jobType"/>				</td>
                <td id="t5"  align="right">职业&nbsp;</td>
                <td id="t6">
					<s:select list="selJobIndustry"  name="customer.jobIndustry" value="#session.c.jobIndustry"/>				</td>
                <td id="t5"  align="right">&nbsp;</td>
                <td id="t6">				</td>
              </tr>
			  
			   <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
                <td id="t5"  align="right">购买单元1&nbsp;</td>
                <td id="t6">					
					<input type="text" id="intentUnit1" name="customer.intentUnit1" value="<s:property value='#session.c.intentUnit1'/>"/>				</td>
                <td id="t5"  align="right">购买单元2&nbsp;</td>
                <td id="t6">
					<input type="text" id="intentUnit2" name="customer.intentUnit2" value="<s:property value='#session.c.intentUnit2'/>"/>				</td>
                <td id="t5"  align="right">&nbsp;</td>
                <td id="t6">				</td>
              </tr>
			  
			   <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
                <td id="t5"  align="right">购房目的&nbsp;</td>
                <td id="t6">
					<s:select list="selBuyAim"  name="customer.buyAim" value="#session.c.buyAim"/>				</td>
                <td id="t5"  align="right">付款方式&nbsp;</td>
                <td id="t6">
					<s:select list="selPayType"  name="customer.payType" value="#session.c.payType"/>			</td>
                <td id="t5"  align="right">&nbsp;</td>
                <td id="t6">				</td>
              </tr>
	  
	
	  
	    <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
                <td id="t9"  align="right">意向面积&nbsp;</td>
                <td id="t10">
					<s:select list="selRequestArea"  name="customer.requestArea" value="#session.c.requestArea"/>				</td>
                <td id="t9"  align="right">意向套数&nbsp;</td>
                <td id="t10">
					<s:select list="selIntentBuynum"  name="customer.intentBuynum" value="#session.c.intentBuynum"/>				</td>
                <td id="t9"  align="right">意向户型&nbsp;</td>
                <td id="t10">
				  <s:select list="selRoomType"  name="customer.roomType" value="#session.c.roomType"/>		    </td>
              </tr>
	  
	   <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
		<td id="t1" style="width:15%"  align="right">认知途径&nbsp;</td>
		<td colspan="5" style="white-space:normal">
			<table width="98%" border="0" align="left" cellpadding="0" cellspacing="1" style="white-space:normal">
				<tr>
					<td>
						<s:checkboxlist list="selKnownFrom1" name="knownFrom" value="#session.knowns"/>
					</td>
				</tr>
				
				<tr>
					<td>
						<s:checkboxlist list="selKnownFrom2" name="knownFrom" value="#session.knowns"/>
					</td>
				</tr>
				
				<tr>
					<td>
						<s:checkboxlist list="selKnownFrom3" name="knownFrom" value="#session.knowns"/>
					</td>
				</tr>
			</table>
		</td>
	  </tr>
	  
	  <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
		<td id="t7"  align="right">关注点&nbsp;</td>
		<td id="t8" colspan="5" style="white-space:normal">
			<s:checkboxlist list="selCustomerFocus" name="customerFocus" value="#session.focus"/>
		</td>
	  </tr>
	 	
	
	  
	  <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF"; align="center">
		<td colspan="6">
		 <input type="hidden" name="customer.id" value="<s:property value='#session.c.id'/>"/>
		  <input type="submit" value="  保存  " id="sub"/>
		  &nbsp;&nbsp;
		  <input type="button" value="  取消  " onClick="javascript:window.location.href = './customer_guangzhou!searchCustomer.action'" />
		  &nbsp;&nbsp;
		  <input type="button" value="  跟进  " id="follow" ac="customer_guangzhou"/>
		 </td>
	  </tr>
	  
	   </table>
	  
	  </form>
	  
	 <table width="98%" border="0" align="left" cellpadding="0" cellspacing="1" class="gbox" style="white-space: nowrap">
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
