<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page contentType="text/html; charset=utf-8" %>
<%@ page import="com.ihk.utils.CacheUtils"%>

<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
	
	<title>修改客户信息</title>
	
	<base href="<%=basePath%>">
		
	<s:include value="header.jsp"></s:include>	  
	<s:include value="header_left_js.jsp"></s:include>	  
	
	<script type="text/javascript" language="javascript" src="./js/provi_city_region_select.js"></script>
	<script type="text/javascript" language="javascript" src="./js/customer_guangzhou.js"></script>
	<script type="text/javascript" language="javascript" src="./js/customer_guangzhou_update.js"></script>	
	<script type="text/javascript" language="javascript" src="<%=basePath%>js/customer_copy.js"></script>
	<script type="text/javascript" language="javascript" src="<%=basePath%>js/customer_guangzhou_user.js"></script>	 
	<script type="text/javascript" language="javascript" src="./js/customer_value_change.js"></script>
	<script type="text/javascript" language="javascript" src="./js/customer_sel.js"></script>
	
	<style type="text/css">
		*{margin:0;padding:0;}
	</style>

	
  </head>
  
 <body onload="clearSuggestion()">

<%--主体 --%>
<div class="ui_tools"></div>
<div class="ui_listview">
    <div class="right99"></div>

    <%--主体table top --%>

    <div class="c"></div>
    <div class="c">
        &nbsp;&nbsp;
        <font color="#FF0000"><span id="suggestion"><s:property value="#request.session.suggestion"/></span></font>
    </div>


	<form class="registerform" action="./customer_guangzhou/update/toUpdate.action?ts=<%= CacheUtils.getUrlTimeStamp()%>" method="post" >	
		  
		  <table style="width: 100%;line-height:25px" align="left" border="0" cellspacing="0">		 
		  
		  <tr>
		  	<td colspan="6">
			

		 <table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" class="gbox" >
		 
  			 <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
			 	<td colspan="6">&nbsp;&nbsp;必填</td>
			 </tr>
			 
			   <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
                <td id="t15"  style="width:15%"  align="right"><font color="red">*</font>项目&nbsp;</td>
                <td id="t16" colspan="3">
					<input type="text" id="projectName" disabled="disabled" value="<s:property value='#session.selectedProjectName'/>"/>
					<input type="hidden" id="hiddenId" value="<s:property value='#session.c.projectId'/>"/>
					
					<input type="hidden" id="customerId" value="<s:property value='#session.c.id'/>"/>
				</td>
				<td id="t15"  style="width:15%"  align="right"></td>
                <td id="t16"></td>
				 
              </tr>
			  
			  <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
                <td id="t15"  style="width:15%"  align="right"><font color="red">*</font>客户姓名&nbsp;</td>
                <td id="t16">
					<input type="text" name="customer.customerName" id="customerName" class="leftcreateinputbox01" maxlength="20" value="<s:property value='#session.c.customerName'/>"/>
				</td>
				<td id="t15"  style="width:15%"  align="right"><font color="red">*</font>客户评级&nbsp;</td>
                <td id="t16" style="width:18%">
					<s:select list="selRating"  name="customer.rating" value="#session.c.rating"/>
				</td>
				<td id="t15"  style="width:15%"  align="right">来访日期</td>
                <td id="t16">
					<input class="Wdate" type="text" id="visitDate" style="width:90px" name="customer.visitDate" value="${session.c.visitDate}"/>	
				</td>
				 
              </tr>
			 
			 
              <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
                
                <td id="t15" style="width:15%" align="right"><font color="red">*</font>移动电话&nbsp;</td>
                <td id="t16" style="width:18%">
				 <input type="text" id="phone" name="customer.phone" class="leftcreateinputbox01" maxlength="12" value="<s:property value='#session.c.phone'/>" 
				 	title="移动电话,固定电话可以二选一" onkeyup="valueChangeGetCount('phone', 'phoneCount', 11)" onkeydown="valueChangeGetCount('phone', 'phoneCount', 11)"/>
				 <span id="phoneCount"></span>
				 </td>
				 
				  <td id="t13" style="width:15%" align="right"><font color="red">*</font>固定电话&nbsp;</td>
                <td id="t14">
					 <input type="text" id="homePhone" name="customer.homePhone" class="leftcreateinputbox01" value="<s:property value='#session.c.homePhone'/>"
					 	title="移动电话,固定电话可以二选一"/>
				</td>
				<td colspan="2">
					(移动电话,固定电话可以二选一)
				</td>
              </tr>
             <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
                <td id="t13"  align="right"><font color="red">*</font>居住区域&nbsp;</td>
                <td colspan="5">
					<s:select list="selProvince"  name="customer.homeProvince" value="#session.c.homeProvince"/>省
					<s:select list="selHomeCity"  name="customer.homeCity" value="#session.c.homeCity"/>市
					<s:select list="selHomeRegion"  name="customer.homeRegion" value="#session.c.homeRegion"/>
					
					<input type="text" id="homeContent" name="customer.homeContent" value="<s:property value='#session.c.homeContent'/>" />
					
				</td>
               </tr>
			  
			  <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
                <td id="t13"  align="right"><font color="red">*</font>工作区域&nbsp;</td>
                <td colspan="5">
					<s:select list="selProvince"  name="customer.workProvince" value="#session.c.workProvince"/>省
					<s:select list="selWorkCity"  name="customer.workCity" value="#session.c.workCity"/>市
					<s:select list="selWorkRegion"  name="customer.workRegion" value="#session.c.workRegion"/>
					
					<input type="text" id="workContent" name="customer.workContent" value="<s:property value='#session.c.workContent'/>" /> 
					&nbsp;
					<input type="checkbox" id="copyHome" />与居住区域相同
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
					<input type="text" name="customer.priceNum" id="priceNum" style="width:40px" value="<s:property value='#session.c.priceNum'/>"/>	
					万
				</td>
              </tr>
			  
			  <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
                <td id="t11"  align="right"><font color="red">*</font>产品类型&nbsp;</td>
                <td id="t12">
					<s:select list="selHouseType"  name="customer.houseType" value="#session.c.houseType"/>				</td>
                <td id="t11"  align="right"><font color="red">*</font>客户来源&nbsp;</td>
                <td id="t12">	
					<s:select list="selCustomerSource"  name="customer.customerSource" value="#session.c.customerSource"/>				
				</td>
				<td id="t11" align="right"><font color="red">*</font>意向面积&nbsp;</td>
                <td id="t12">
					<input type="text" name="customer.areaNum" id="areaNum" style="width:40px" value="<s:property value='#session.c.areaNum'/>"/>	
					<span id="areaNumUnit">㎡</span>
				</td>
              </tr>
			  
			  <!-- 侨鑫 top -->
			  
			   <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
                <td id="t11"  align="right"><font color="red">*</font>邮箱地址&nbsp;</td>
                <td id="t12">
					<input type="text" name="customer.email" id="email" class="leftcreateinputbox01" value="<s:property value='#session.c.email'/>"/>
				</td>
                <td id="t11"  align="right"><font color="red">*</font>希望付款方式&nbsp;</td>
                <td id="t12">	
					<input type="text" name="customer.rejectFactor" id="rejectFactor" class="leftcreateinputbox01" value="<s:property value='#session.c.rejectFactor'/>"/>				
				</td>
                <td id="t11" align="right"><font color="red">*</font>意向单价&nbsp;</td>
                <td id="t12">
					<input type="text" name="customer.ratingRemark" id="ratingRemark" class="leftcreateinputbox01" value="<s:property value='#session.c.ratingRemark'/>"
					style="width:40px" />
					万/㎡
				</td>
              </tr>
			  
			   <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
                <td id="t11"  align="right"><font color="red">*</font>是否有名额购房&nbsp;</td>
                <td id="t12">
					<s:select list="selIntentLease"  name="customer.intentLease" value="#session.c.intentLease"/>
				</td>
                <td id="t11"  align="right"><font color="red">*</font>客户形象&nbsp;</td>
                <td id="t12">	
					<s:select list="selWage"  name="customer.wage" value="#session.c.wage"/>				
				</td>
                <td id="t11" align="right"><font color="red">*</font>发动力&nbsp;</td>
                <td id="t12">
					<s:select list="selProductClaim"  name="customer.productClaim" value="#session.c.productClaim"/>
					
				</td>
              </tr>
			  
			   <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
                <td id="t11"  align="right"><font color="red">*</font>车位个数&nbsp;</td>
                <td id="t12">
					<input type="text" name="customer.faceLook" id="faceLook" class="leftcreateinputbox01" value="<s:property value='#session.c.faceLook'/>"/>
					
				</td>
                <td id="t11"  align="right"><font color="red">*</font>家庭作主&nbsp;</td>
                <td id="t12">	
					<input type="text" name="customer.family" id="family" class="leftcreateinputbox01" value="<s:property value='#session.c.family'/>"/>	
								
				</td>
                <td id="t11" align="right"></td>
                <td id="t12"></td>
              </tr>
			  
			   <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
                <td id="t11"  align="right"><font color="red">*</font>个人爱好&nbsp;</td>
                <td id="t12">
					<input type="text" name="customer.interest" id="interest" class="leftcreateinputbox01" value="<s:property value='#session.c.interest'/>"/>
					
				</td>
                <td id="t11"  align="right"><font color="red">*</font>认识关系&nbsp;</td>
                <td id="t12">	
					<input type="text" name="customer.relationDesc" id="relationDesc" class="leftcreateinputbox01" value="<s:property value='#session.c.relationDesc'/>"/>			
				</td>
                <td id="t11" align="right"></td>
                <td id="t12"></td>
              </tr>
			  
			  <!-- 侨鑫 end -->
			  
			  <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
			  	 <td id="t11"  align="right"><font color="red">*</font>销售人员&nbsp;</td>
                <td id="t12" colspan="3">
					<input type="hidden" name="customer.managerId" value="<s:property value='#session.c.managerId'/>" />	
					<span><s:property value='#session.c.descUserId'/></span>
					&nbsp;&nbsp;
					创建日期:
					<s:date name="#session.c.createdTime" format="yyyy-MM-dd "/> 
					&nbsp;&nbsp;
					选定的项目:
					<font color="red"><span id="showProject"><s:property value='#session.selectedProjectName'/></span></font>
					
				</td>
				
				<td id="t9" style="width:15%" align="right"></td>
                <td id="t6"></td>
			  </tr>
			 
			  <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
			 	<td colspan="6">&nbsp;&nbsp;选填(<a href="#" onClick="return false;" id="showOrHide"><font color="#1199FF">点击可以隐藏/显示</font></a>)</td>
			 </tr>
			</table>

			
			
		  </td>
		  </tr>
		  
		
            <tr>
              <td colspan="6">			  
			  
			  
			  <table width="100%" border="0" align="left" cellpadding="0" cellspacing="1" class="gbox" style="white-space: nowrap;display: block" id="changeTable">
			 
			 <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" id="change1">
                <td id="t9"  align="right">来访次数&nbsp;</td>
                <td id="t10">
					<s:select list="selVisitCount"  name="customer.visitCount" value="#session.c.visitCount"/>
				</td>
                <td id="t9" style="width:15%" align="right">性别&nbsp;</td>
                <td id="t10" style="width:18%">
					<s:select list="selGender"  name="customer.gender" value="#session.c.gender"/>	
				</td>
                <td id="t9" style="width:15%" align="right">国籍&nbsp;</td>
                <td id="t10">
					<input type="text" name="customer.nationality" id="nationality" class="leftcreateinputbox01" value="<s:property value='#session.c.nationality'/>"/>		
				</td>
              </tr>
              
			  <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
                <td id="t9" align="right">身份证号码&nbsp;</td>
                <td id="t10" style="width:18%">
					<input type="text" name="customer.idcardNo" id="idcardNo" class="leftcreateinputbox02" style="width:auto" value="<s:property value='#session.c.idcardNo'/>"
					onkeyup="valueChangeGetCount('idcardNo', 'idcardNoCount', 18)" onkeydown="valueChangeGetCount('idcardNo', 'idcardNoCount', 18)"/>
					<span id="idcardNoCount"></span>
				</td>
                <td id="t9"  align="right">驾车品牌、驾车型号&nbsp;</td>
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
                <td id="t5"  align="right"></td>
                <td id="t6"></td>
              </tr>
			  
			  <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
                <td id="t5"  align="right">行业分类&nbsp;</td>
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
                
                <td id="t9"  align="right">意向套数&nbsp;</td>
                <td id="t10">
					<s:select list="selIntentBuynum"  name="customer.intentBuynum" value="#session.c.intentBuynum"/>				</td>
                <td id="t9"  align="right">意向户型&nbsp;</td>
                <td id="t10">
				  <s:select list="selRoomType"  name="customer.roomType" value="#session.c.roomType"/>		    </td>
				  <td id="t9"  align="right"></td>
                <td id="t10"></td>
              </tr>
	  
	   <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
		<td id="t1" style="width:15%"  align="right">认知途径(多选)&nbsp;</td>
		<td colspan="5" style="white-space:normal;line-height: 30px">
						<s:checkboxlist list="selKnownFrom1" name="knownFrom" value="#session.knowns"/>
		</td>
	  </tr>
	  
	  <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
		<td id="t7"  align="right">关注点(多选)&nbsp;</td>
		<td id="t8" colspan="5" style="white-space:normal">
			<s:checkboxlist list="selCustomerFocus" name="customerFocus" value="#session.focus"/>
			<input type="hidden" id="focusPoint" />
		</td>
	  </tr>
	  
	   <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
		<td id="t7"  align="right">客户背景&nbsp;</td>
		<td colspan="5" style="white-space:normal">	
			<input type="text" name="customer.background" id="background" value="<s:property value='#session.c.background'/>" class="leftcreateinputbox02" style="width:80%"/>		
		</td>
	  </tr>
	  
	   <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
		<td id="t7"  align="right">未能成交原因&nbsp;</td>
		<td colspan="5" style="white-space:normal">	
			<input type="text" name="customer.notBuyReson" id="notBuyReson" value="<s:property value='#session.c.notBuyReson'/>" class="leftcreateinputbox02" style="width:80%"/>	
		</td>
	  </tr>
	  	  
	  <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
		<td id="t7"  align="right">备注&nbsp;</td>
		<td colspan="5" style="white-space:normal">	
			<input type="text" name="customer.remark1" id="remark1" value="<s:property value='#session.c.remark1'/>" class="leftcreateinputbox02" style="width:80%"/>	
		</td>
	  </tr>
	  
	    <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
                <td id="t5"  align="right">自填选项内容1&nbsp;</td>
                <td id="t6">					
					<input type="text" id="subject1" name="customer.subject1" value="<s:property value='#session.c.subject1'/>"/>
				</td>
				 <td id="t6">
				 	<input type="text" id="content1" name="customer.content1" value="<s:property value='#session.c.content1'/>"/>
				 </td>
                <td id="t5"  align="right">自填选项内容2&nbsp;</td>
                <td id="t6">
					<input type="text" id="subject2" name="customer.subject2" value="<s:property value='#session.c.subject2'/>"/>
				</td>
                <td id="t5"  align="right">
					<input type="text" id="content2" name="customer.content2" value="<s:property value='#session.c.content2'/>"/>
				</td>
               
              </tr>
			  
		<tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
                <td id="t5"  align="right">自填选项内容3&nbsp;</td>
                <td id="t6">					
					<input type="text" id="subject3" name="customer.subject3" value="<s:property value='#session.c.subject3'/>"/>
				</td>
				 <td id="t6">
				 	<input type="text" id="content3" name="customer.content3" value="<s:property value='#session.c.content3'/>"/>
				 </td>
                <td id="t5"  align="right">自填选项内容4&nbsp;</td>
                <td id="t6">
					<input type="text" id="subject4" name="customer.subject4" value="<s:property value='#session.c.subject4'/>"/>
				</td>
                <td id="t5"  align="right">
					<input type="text" id="content4" name="customer.content4" value="<s:property value='#session.c.content4'/>"/>
				</td>
               
         </tr>
		 
	   </table>


</td>
            </tr>
			
		   <tr>
		  <td colspan="6">	
		  
		  	 <table width="100%" border="0" align="left" cellpadding="0" cellspacing="1" class="gbox" style="white-space: nowrap">
	 		  
	  <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF"; align="center">
		<td colspan="6">
		 <input type="hidden" name="customer.id" value="<s:property value='#session.c.id'/>"/>
		  <input type="hidden" id="baseUrl" value="<%=basePath%>"/>
		  <input type="submit" value="  保存  " id="sub"/>
		  &nbsp;&nbsp;
		  <input type="button" value="  取消  " onClick="javascript:window.location.href = '<%=basePath%>customer_guangzhou/search/searchOrderBy.action'" />
		  &nbsp;&nbsp;
		  <input type="button" value="  跟进  " id="follow" ac="customer_guangzhou"/>
		  &nbsp;&nbsp;
		  <input type="button" id="copyCustomer" value="  转移客户  " onclick="return copyOneCustomer('<s:property value='#session.c.id'/>')"/>
		 </td>
	  </tr>
	  
	  <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF"; align="center">
		<td colspan="6">	
			<font color="#FF0000"><span id="tip"><s:property value="#request.session.suggestion"/></span></font>
		</td>
	</tr>
	  
      </table>
		  
		  </td>
		  </tr>
		  
		   <tr>
		  <td colspan="6">
		  	
			<table width="100%" border="0" align="left" cellpadding="0" cellspacing="1" class="gbox" style="white-space: normal">
			  <!-- follow top -->
			   <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
				<td align="center" id="t4" style="width:15%">跟进类型&nbsp;</td>
				<td align="center" id="t4" style="width:15%">跟进人&nbsp;</td>		
				<td align="center" id="t4" style="width:15%">跟进日期&nbsp;</td>
				<td align="left" id="t4" colspan="3">跟进内容&nbsp;</td>
			  </tr>
	  
			  <s:iterator value="#request.session.follows" id="f">	
				   <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
					<td align="center" id="t4"><s:property value="#f.descFollowType"/></td>
					<td align="center" id="t4"><s:property value="#f.descUserId"/></td>		
					<td align="center" id="t4"><s:date name="#f.createdTime" format="yyyy-MM-dd "/></td>
					<td align="left" id="t4" colspan="3"><s:property value="#f.followDesc"/></td>
				  </tr>
			  </s:iterator>
			  
			   <!-- follow end -->
			  
			  </table>
			
		  </td>
		  </tr>
			
           
            </table>
</form>
	

 </div>
 </body>
</html>
