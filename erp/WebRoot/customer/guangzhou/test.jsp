<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
    <title>录入</title>
    <base href="<%=basePath%>">
	
	<s:include value="header.jsp"></s:include>	
	<s:include value="header_left_js.jsp"></s:include>	   	
  </head>
 <body onLoad="clearSuggestion()">
 
<%--固定的上部 --%>
<table width="100%" border="0" align="left" cellspacing="0">
			<thead>
				<tr>
					<td colspan="2" style="border-collapse: collapse; border: 0px; margin: 0px; padding: 0px;">
						<div class="boxnavtop">
    <div class="logo"></div>
    <div class="logoword">广州项目</div>
    <!--welcome-->
<div class="welcome">
    	<div class="welcome01"></div>
        <div class="welcome02">		
		欢迎： <span class="fontblue">
		<s:property value="#session.loginAccount.realName"/>
		</span> | 
		<a href="./customer!customerLoginOut.action" title="注销" target="_self">注销</a> 
		
		
  </div>
    <!--welcome.end-->
    </div>
<div class="topline"></div>
</div>
					</td>
				</tr>
			</thead>
			
			<tfoot>
				<tr>
					<td colspan="2">
					</td>
				</tr>
			</tfoot>
			
			<tbody>
				<tr style="height: 100%">
					<td valign="top">
						<s:include value="left.jsp">
						</s:include>
					</td>
					<td width="100%" valign="top" >
					<DIV style="WIDTH: 98%; HEIGHT: 100%; BACKGROUND-COLOR: #A4C3D7;padding: 1px">
						<table width="100%" class="mainbg20111112" style="height: 100%">
							<tr>


								<td width="100%" valign="top" height="100%" style="overflow: hidden;">
									<div class="titlel"></div>
									<div class="titlebg" style="height: auto; overflow: hidden;">


<%--主体导航页头 --%>
<div class="title01" ><a href="./customer_guangzhou/search/index.action" target="_self">查询客户</a></div>
<div class="title02"><a href="./customer_guangzhou/input/forAdd.action" target="_self">新建客户</a></div>	
<div class="right99"></div>
<div class="blueline"></div>		

		
<%--主体table --%>
<table width="100%" border="0" align="left" cellspacing="0">
	<form class="registerform" action="./customer_guangzhou/input/addCustomer.action" method="post" >	
			
          <div class="c"></div>
          <div class="c">		  	
			  &nbsp;&nbsp;	
			<font color="#FF0000"><span id="suggestion"><s:property value="#request.session.suggestion"/></span></font>
		  </div>
		  
		  

           <table width="98%" border="0" align="left" cellpadding="0" cellspacing="1" class="gbox" style="white-space: nowrap">
		   		
			 <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
			 	<td colspan="6">&nbsp;&nbsp;必填</td>
			 </tr>
			 
			  <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
                <td id="t15"  style="width:15%"  align="right"><font color="red">*</font>项目&nbsp;</td>
                <td id="t16" colspan="5">
					<input type="text" id="projectName" name="projectName" />
				</td>
              </tr>
		   
              <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
                <td id="t15"  style="width:15%"  align="right"><font color="red">*</font>客户姓名&nbsp;</td>
                <td id="t16">
					<input type="text" name="customer.customerName" id="customerName" class="leftcreateinputbox01" maxlength="20"/>				</td>
					<td id="t15" style="width:15%" align="right"><font color="red">*</font>移动电话&nbsp;</td>
                <td id="t16">
				 <input type="text" id="phone" name="customer.phone" class="leftcreateinputbox01" maxlength="12"/>                </td>
                 <td id="t13" style="width:15%" align="right"><font color="red">*</font>固定电话&nbsp;</td>
                <td id="t14">
					 <input type="text" id="homePhone" name="customer.homePhone" class="leftcreateinputbox01"/>				</td>
                
              </tr>
             <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
                <td id="t13"  align="right"><font color="red">*</font>居住区域&nbsp;</td>
                <td colspan="5">
					<s:select list="selProvince"  name="customer.homeProvince" value="#session.cacheCustomer.homeProvince"/>省
					<s:select list="selHomeCity"  name="customer.homeCity" value="#session.cacheCustomer.homeCity"/>市
					<s:select list="selHomeRegion"  name="customer.homeRegion" value="#session.cacheCustomer.homeRegion"/>
				</td>
             </tr>
			  
			  <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
                <td id="t13"  align="right"><font color="red">*</font>工作区域&nbsp;</td>
                <td colspan="5">
					<s:select list="selProvince"  name="customer.workProvince" value="#session.cacheCustomer.workProvince"/>省
					<s:select list="selWorkCity"  name="customer.workCity" value="#session.cacheCustomer.workCity"/>市
					<s:select list="selWorkRegion"  name="customer.workRegion" value="#session.cacheCustomer.workRegion"/>
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
					<%--
					<s:select list="selPriceAmount"  name="customer.priceAmount" value="%{customer.priceAmount}" />	
					--%>
					<input type="text" name="customer.priceNum" id="priceNum" style="width:40px" />
					万
				</td>
             </tr>
			  
			  <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
                <td id="t11"  align="right"><font color="red">*</font>产品类型&nbsp;</td>
                <td id="t12">
					<s:select list="selHouseType"  name="customer.houseType" />	
				</td>
                <td id="t11"  align="right"><font color="red">*</font>客户来源&nbsp;</td>
                <td id="t12">	
					<s:select list="selCustomerSource"  name="customer.customerSource" />				
				</td>
                <td id="t11"></td>
                <td id="t12"></td>
              </tr>
			  
			  <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
			  	 <td id="t11"  align="right"><font color="red">*</font>销售人员&nbsp;</td>
                <td id="t12" colspan="5">
					<input type="hidden" name="customer.managerId" value="<s:property value='#session.loginAccount.id'/>" />
					<span><s:property value='#session.loginAccount.realName'/></span>
					&nbsp;&nbsp;
					当前时间:
					<span id="nowTime"></span>
					&nbsp;&nbsp;
					选定的项目:
					<span id="showProject"></span>
					
				</td>
			  </tr>
			 
			  <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
			 	<td colspan="6">&nbsp;&nbsp;选填(<a href="#" onClick="return false;" id="showOrHide"><font color="#1199FF">点击可以隐藏/显示</font></a>)</td>
			 </tr>
			  
			 
              <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" id="change1">
                <td id="t9"  align="right">来访次数&nbsp;</td>
                <td id="t10">
					<s:select list="selVisitCount"  name="customer.visitCount" />	
				</td>
                <td id="t9" style="width:15%" align="right">性别&nbsp;</td>
                <td id="t10">
					<s:select list="selGender"  name="customer.gender" />	
				</td>
                <td id="t9" style="width:15%" align="right">国籍&nbsp;</td>
                <td id="t10">
					<input type="text" name="customer.nationality" id="nationality" class="leftcreateinputbox01" />
				</td>
              </tr>
              
			  <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
                <td id="t9"  align="right">身份证号码&nbsp;</td>
                <td id="t10">
					<input type="text" name="customer.idcardNo" id="idcardNo" class="leftcreateinputbox02" style="width:auto"/>
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
                <td id="t6">				</td>
             </tr>
			  
			  <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
                <td id="t5"  align="right">行业结构&nbsp;</td>
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
                <td id="t9"  align="right">意向面积&nbsp;</td>
                <td id="t10">
					<%--
					<s:select list="selRequestArea"  name="customer.requestArea" />	
					--%>
					<input type="text" name="customer.areaNum" id="areaNum" style="width:40px" />
					㎡
				</td>
                <td id="t9"  align="right">意向套数&nbsp;</td>
                <td id="t10">
					<s:select list="selIntentBuynum"  name="customer.intentBuynum" />	
				</td>
                <td id="t9"  align="right">意向户型&nbsp;</td>
                <td id="t10">
				  <s:select list="selRoomType"  name="customer.roomType" />	
			    </td>
             </tr>
	  
	   <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
		<td id="t1" style="width:15%"  align="right">认知途径&nbsp;</td>
		<td colspan="5" style="white-space:normal">
			<table width="98%" border="0" align="left" cellpadding="0" cellspacing="1" style="white-space:normal">
				<tr>
					<td>
						<s:checkboxlist list="selKnownFrom1" name="knownFrom" />
					</td>
				</tr>
				
				<tr>
					<td>
						<s:checkboxlist list="selKnownFrom2" name="knownFrom" />
					</td>
				</tr>
				
				<tr>
					<td>
						<s:checkboxlist list="selKnownFrom3" name="knownFrom" />
					</td>
				</tr>
			</table>
			
		</td>
	  </tr>
	  
	  <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
		<td id="t7"  align="right">关注点&nbsp;</td>
		<td id="t8" colspan="5" style="white-space:normal">
			<s:checkboxlist list="selCustomerFocus" name="customerFocus" />
		</td>
	  </tr>
	  
	  <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF"; align="center">
		<td colspan="6">
		  <input type="submit" value="  保存  " id="sub"/>
			&nbsp;&nbsp;
		  <input type="button" value="  取消  " onClick="javascript:window.location.href = './customer_guangzhou/search/index.action'" />
			&nbsp;&nbsp;		 
		 </td>
	  </tr>
	  
	  
	  
  </form>
	 </table> 
	  <%--固定的底部 --%>
</td>
							</tr>
							</table>
</div>
								</td>
							</tr>
							

<tr><td colspan="2">
&nbsp;
						<table width="100%" border="0" cellspacing="0">
			<tr>
				<td colspan="3" class="footer">
					<!--footer-->
					Copyright ⓒ 2000-2011 hope733.com 公司版权所有。保留所有权利。
					<%-- 
					<a href="#" target="_blank">隐私声明</a> ｜
					<a href="#">安全声明</a> ｜
					<a href="#" target="_blank">使用条款</a>
					<!--footer.end-->
					--%>
				</td>
			</tr>
		</table>
						</td></tr>
			</tbody>

		</table>




	   
   
</body>
</html>
