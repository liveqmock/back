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
	
	<title>新建客户</title>
	
	<base href="<%=basePath%>">
		
	<s:include value="header.jsp"></s:include>	  
	<s:include value="header_left_js.jsp"></s:include>	  
	
	<script type="text/javascript" language="javascript" src="./js/provi_city_region_select.js"></script>
	<script type="text/javascript" language="javascript" src="./js/customer_sel.js"></script>
	<script type="text/javascript" language="javascript" src="./js/customer_value_change.js"></script>
	<script type="text/javascript" language="javascript" src="./js/customer_guangzhou.js"></script>	
	<script type="text/javascript" language="javascript" src="./js/customer_guangzhou_input.js"></script>	
			
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
	
	<form class="registerform" action="./customer_guangzhou/input/addCustomer.action?ts=<%= CacheUtils.getUrlTimeStamp()%>" method="post" >	
		  
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
					<span><s:property value='#request.project.projectName'/></span>
					<input type="hidden" id="hiddenId" name="customer.projectId" value="<s:property value='#request.project.id'/>"/>
					<input type="hidden" id="projectName" name="projectName" value="<s:property value='#request.project.projectName'/>"/>
				</td>
				<td id="t15"  style="width:15%"  align="right"></td>
                <td id="t16"></td>
				 
              </tr>
			  
			  <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
                <td id="t15"  style="width:15%"  align="right"><font color="red">*</font>客户姓名&nbsp;</td>
                <td id="t16">
					<input type="text" name="customer.customerName" id="customerName" class="leftcreateinputbox01" maxlength="20"/>	
            	</td>
				<td id="t15"  style="width:15%"  align="right"><font color="red">*</font>客户评级&nbsp;</td>
                <td id="t16" style="width:18%">
					<s:select list="selRating"  name="customer.rating"/>	
				</td>
				<td id="t15"  style="width:15%"  align="right">来访日期</td>
                <td id="t16">
					<input class="Wdate" type="text" id="visitDate" style="width:90px" name="customer.visitDate"/>	
				</td>
				 
              </tr>
		  
		   
              <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
				<td id="t15" style="width:15%" align="right"><font color="red">*</font>移动电话&nbsp;</td>
                <td id="t16" style="width:18%">
				 <input type="text" id="phone" name="customer.phone" class="leftcreateinputbox01" maxlength="12" title="移动电话,固定电话可以二选一" 
				 	onkeyup="valueChangeGetCount('phone', 'phoneCount', 11)" onkeydown="valueChangeGetCount('phone', 'phoneCount', 11)"/>
				 <span id="phoneCount"></span>
				 </td>
                 <td id="t13" style="width:15%" align="right"><font color="red">*</font>固定电话&nbsp;</td>
                <td id="t14">
					 <input type="text" id="homePhone" name="customer.homePhone" class="leftcreateinputbox01" title="移动电话,固定电话可以二选一"/>				</td>
				<td colspan="2">
					(移动电话,固定电话可以二选一)
				</td>
                
              </tr>
             <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
                <td id="t13"  align="right"><font color="red">*</font>居住区域&nbsp;</td>
                <td colspan="5">
					<s:select list="selProvince"  name="customer.homeProvince" value="#session.cacheCustomer.homeProvince" cssStyle="width:auto"/>省
					<s:select list="selHomeCity"  name="customer.homeCity" value="#session.cacheCustomer.homeCity" cssStyle="width:auto"/>市
					<s:select list="selHomeRegion"  name="customer.homeRegion" value="#session.cacheCustomer.homeRegion" cssStyle="width:auto"/>
					<input type="text" id="homeContent" name="customer.homeContent" value="<s:property value='#session.cacheCustomer.homeContent'/>" />
					
				</td>
             </tr>
			  
			  <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
                <td id="t13"  align="right"><font color="red">*</font>工作区域&nbsp;</td>
                <td colspan="5">
					<s:select list="selProvince"  name="customer.workProvince" value="#session.cacheCustomer.workProvince" cssStyle="width:auto"/>省
					<s:select list="selWorkCity"  name="customer.workCity" value="#session.cacheCustomer.workCity" cssStyle="width:auto"/>市
					<s:select list="selWorkRegion"  name="customer.workRegion" value="#session.cacheCustomer.workRegion" cssStyle="width:auto"/>
					<input type="text" id="workContent" name="customer.workContent" value="<s:property value='#session.cacheCustomer.workContent'/>" /> 
					&nbsp;
					<input type="checkbox" id="copyHome" />与居住区域相同
				</td>
              </tr>
			  
             <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
                <td id="t11"  align="right"><font color="red">*</font>购房用途&nbsp;</td>
                <td id="t12">
					<s:select list="selBuyUse"  name="customer.buyUse" />
				</td>
                <td id="t11"  align="right"><font color="red">*</font>置业次数&nbsp;</td>
                <td id="t12">
					<s:select list="selBuyCount"  name="customer.buyCount" />
				</td>
                <td id="t11"  align="right"><font color="red">*</font>意向总价&nbsp;</td>
                <td id="t12">	
					
					<input type="text" name="customer.priceNum" id="priceNum" style="width:40px" />
					万
				</td>
             </tr>
			  
			  <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
                <td id="t11"  align="right"><font color="red">*</font>产品类型&nbsp;</td>
                <td id="t12">
					<s:select list="selHouseType"  name="customer.houseType" value="#request.houseType"/>
				</td>
                <td id="t11"  align="right"><font color="red">*</font>客户来源&nbsp;</td>
                <td id="t12">	
					<s:select list="selCustomerSource"  name="customer.customerSource" />				
				</td>
                <td id="t11" align="right"><font color="red">*</font>意向面积&nbsp;</td>
                <td id="t12">
					<input type="text" name="customer.areaNum" id="areaNum" style="width:40px" />
					<span id="areaNumUnit">㎡</span>
				</td>
              </tr>
			  
			   <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
			  					
			  	 <td id="t11"  align="right"><font color="red">*</font>销售人员&nbsp;</td>
                <td id="t12" colspan="3">
					<input type="hidden" name="customer.managerId" value="<s:property value='#session.loginAccount.id'/>" />
					<span><s:property value='#session.loginAccount.realName'/></span>
					&nbsp;&nbsp;
					当前时间:
					<span id="nowTime"></span>
					&nbsp;&nbsp;
					选定的项目:
					<span id="showProject"></span>					
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
					<s:select list="selVisitCount"  name="customer.visitCount" />	
				</td>
                <td id="t9" style="width:15%" align="right">性别&nbsp;</td>
                <td id="t10" style="width:18%">
					<s:select list="selGender"  name="customer.gender" />	
				</td>
                <td id="t9" style="width:15%" align="right">国籍&nbsp;</td>
                <td id="t10">
					<input type="text" name="customer.nationality" id="nationality" class="leftcreateinputbox01" />
				</td>
              </tr>
              
			  <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
                <td id="t9"  align="right">身份证号码&nbsp;</td>
                <td id="t10" style="width:18%">
					<input type="text" name="customer.idcardNo" id="idcardNo" class="leftcreateinputbox02" style="width:auto"
					onkeyup="valueChangeGetCount('idcardNo', 'idcardNoCount', 18)" onkeydown="valueChangeGetCount('idcardNo', 'idcardNoCount', 18)"/>
					<span id="idcardNoCount"></span>
				</td>
                <td id="t9"  align="right">驾车车型&nbsp;</td>
                <td id="t10">
					<input type="text" name="customer.trafficDesc" id="trafficDesc" class="leftcreateinputbox02" style="width:auto"/>
					
				</td>
                <td id="t9"  align="right">年龄&nbsp;</td>
                <td id="t10">
					<s:select list="selAgeRange"  name="customer.age" />	
				</td>
              </tr>
			  
			   <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
                <td id="t5"  align="right">地址&nbsp;</td>
                <td colspan="3">
					<input type="text" name="customer.address" id="address" class="leftcreateinputbox02" style="width:80%"/>				
				</td>
                <td id="t7"  align="right">邮编&nbsp;</td>
                <td id="t8">
					<input type="text" name="customer.postcode" id="postcode" class="leftcreateinputbox01" />				
					
				</td>
              </tr>
			  
			  
             <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
                <td id="t5"  align="right">家庭结构&nbsp;</td>
                <td id="t6">
					<s:select list="selFamilyType"  name="customer.familyType" />	
				</td>
                <td id="t5"  align="right">家庭收入&nbsp;</td>
                <td id="t6">
					<s:select list="selFamilyIncome"  name="customer.familyIncome" />	
				</td>
                <td id="t5"  align="right">&nbsp;</td>
                <td id="t6"></td>
             </tr>
			  
			  <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
                <td id="t5"  align="right">行业分类&nbsp;</td>
                <td id="t6">
					<s:select list="selJobType"  name="customer.jobType" />	
				</td>
                <td id="t5"  align="right">职业&nbsp;</td>
                <td id="t6">
					<s:select list="selJobIndustry"  name="customer.jobIndustry" />	
				</td>
                <td id="t5"  align="right">&nbsp;</td>
                <td id="t6">				</td>
              </tr>
			  
			   <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
                <td id="t5"  align="right">购买单元1&nbsp;</td>
                <td id="t6">					
					<input type="text" id="intentUnit1" name="customer.intentUnit1" />
				</td>
                <td id="t5"  align="right">购买单元2&nbsp;</td>
                <td id="t6">
					<input type="text" id="intentUnit2" name="customer.intentUnit2" />
				</td>
                <td id="t5"  align="right">&nbsp;</td>
                <td id="t6">				</td>
              </tr>
			  
			   <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
                <td id="t5"  align="right">购房目的&nbsp;</td>
                <td id="t6">
					<s:select list="selBuyAim"  name="customer.buyAim" />
				</td>
                <td id="t5"  align="right">付款方式&nbsp;</td>
                <td id="t6">
					<s:select list="selPayType"  name="customer.payType" />	
				</td>
                <td id="t5"  align="right">&nbsp;</td>
                <td id="t6">				</td>
              </tr>
	  
	
	  
	    <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
              
                <td id="t9"  align="right">意向套数&nbsp;</td>
                <td id="t10">
					<s:select list="selIntentBuynum"  name="customer.intentBuynum" />	
				</td>
                <td id="t9"  align="right">意向户型&nbsp;</td>
                <td id="t10">
				  <s:select list="selRoomType"  name="customer.roomType" />	
			    </td>
				
				<td id="t9"  align="right"></td>
                <td id="t10"></td>
             </tr>
	  
	   <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
		<td id="t1" style="width:15%"  align="right">认知途径&nbsp;</td>
		<td colspan="5" style="white-space:normal;line-height: 30px">
						<s:checkboxlist list="selKnownFrom1" name="knownFrom" />
		</td>
	  </tr>
	  
	  <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
		<td id="t7"  align="right">关注点&nbsp;</td>
		<td colspan="5" style="white-space:normal">
			<s:checkboxlist list="selCustomerFocus" name="customerFocus"/>
			<input type="hidden" id="focusPoint" />
		</td>
	  </tr>
	  
	   <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
		<td id="t7"  align="right">关系户&nbsp;</td>
		<td colspan="5" style="white-space:normal">	
			<input type="text" name="customer.relationDesc" id="relationDesc" class="leftcreateinputbox02" style="width:80%"/>			
		</td>
	  </tr>
	  
	   <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
		<td id="t7"  align="right">客户背景&nbsp;</td>
		<td colspan="5" style="white-space:normal">	
			<input type="text" name="customer.background" id="background" class="leftcreateinputbox02" style="width:80%"/>			
		</td>
	  </tr>
	  
	   <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
		<td id="t7"  align="right">业主介绍&nbsp;</td>
		<td colspan="5" style="white-space:normal">	
			<input type="text" name="customer.remark3" id="remark3" class="leftcreateinputbox02" style="width:80%"/>			
		</td>
	  </tr>
	  
	   <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
		<td id="t7"  align="right">业主选项&nbsp;</td>
		<td colspan="5" style="white-space:normal">	
			<input type="text" name="customer.remark4" id="remark4" class="leftcreateinputbox02" style="width:80%"/>			
		</td>
	  </tr>
	  
	  <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
		<td id="t7"  align="right">备注&nbsp;</td>
		<td colspan="5" style="white-space:normal">	
			<input type="text" name="customer.remark1" id="remark1" class="leftcreateinputbox02" style="width:80%"/>			
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
		
		  <s:token />
		  <input type="submit" value="  保存  " id="sub"/>
		  <input type="hidden" id="baseUrl" value="<%=basePath%>"/>
			&nbsp;&nbsp;
			<!--
		  <input type="button" value="  取消  " onClick="javascript:window.location.href = '<%=basePath%>customer_guangzhou/search/index.action'" />
		  -->
		   <input type="button" value="  关闭  " id="bnt-close" />
			
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
			
           
            </table>
</form>

    <%--主体table end --%>
</div>
 </body>
</html>
