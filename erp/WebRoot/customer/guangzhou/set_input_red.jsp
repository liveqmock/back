<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>调查表标红</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<style>
			* {margin:0;padding:0;}
			#miantable td {padding-left: 15px}
    	</style>
		<s:include value="header.jsp"></s:include>	
		<s:include value="header_left_js.jsp"></s:include>	
		<script type="text/javascript" src="<%=basePath%>js/highcharts.js"></script>
		<script type="text/javascript" src="<%=basePath%>js/ui_fix.js"></script>		
	</head>
	
<body>
<%--固定的上部 --%>
<s:include value="body_up.jsp">
</s:include>	

<%--主体导航页头 --%>
<div class="title01" ><a href="<%=path %>/customer_guangzhou/customer_red/list.action" target="_self">查询调查表标红</a></div>
<div class="right99"></div>
<div class="blueline"></div>
<div class="c"></div>
<div class="c"></div>

<%--主体table --%>
<table width="100%" border="0" align="left" cellspacing="0">
<form action="<%=path %>/customer_guangzhou/customer_red/save.action" method="post">
	<table width="100%" border="0" align="left" cellspacing="0">
		 <tr>
              <td height="10" colspan="6"> </td>
        </tr>	
     <tr>
     	<td colspan="6">	
     	<label>&nbsp;<span></span></label>
     		
     		
		  
		  
		  <table width="98%" border="0" align="left" cellpadding="0" cellspacing="1" class="gbox" style="white-space: nowrap" id="miantable">
		   		
			 <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
			 	<td colspan="6">&nbsp;项目:${projectName }<input type="hidden" name="projectId" value="${projectId }"/></td>
			 </tr>
			 
			 
              <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
                <td id="t15"  style="width:15%"  align="right">客户姓名&nbsp;</td>
                <td id="t16">
					<input type="checkbox" name="customerRed.customerName" value="1" <s:if test="#request.customerRed.customerName == 1">checked="checked"</s:if> ></input></td>
                 <td id="t13" style="width:15%" align="right">移动电话&nbsp;</td>
                <td id="t14">
					<input type="checkbox" name="customerRed.phone" value="1"  <s:if test="#request.customerRed.phone == 1">checked="checked"</s:if>></input></td>
                <td id="t15" style="width:15%" align="right">家庭电话(固定电话)&nbsp;</td>
                <td id="t16">
					<input type="checkbox" name="customerRed.homePhone" value="1" <s:if test="#request.customerRed.homePhone == 1">checked="checked"</s:if>></input></td>
              </tr>
              <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
                <td id="t15"  style="width:15%"  align="right">居住区域&nbsp;</td>
                <td id="t16">
					<input type="checkbox" name="customerRed.homeRegion" value="1" <s:if test="#request.customerRed.homeRegion == 1">checked="checked"</s:if>></input></td>
                 <td id="t13" style="width:15%" align="right">工作区域&nbsp;</td>
                <td id="t14">
					<input type="checkbox" name="customerRed.workRegion" value="1" <s:if test="#request.customerRed.workRegion == 1">checked="checked"</s:if>></input></td>
                <td id="t15" style="width:15%" align="right">购房用途&nbsp;</td>
                <td id="t16">
					<input type="checkbox" name="customerRed.buyUse" value="1" <s:if test="#request.customerRed.buyUse == 1">checked="checked"</s:if>></input></td>
              </tr>
              <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
                <td id="t15"  style="width:15%"  align="right">置业次数&nbsp;</td>
                <td id="t16">
					<input type="checkbox" name="customerRed.buyCount" value="1"  <s:if test="#request.customerRed.buyCount == 1">checked="checked"</s:if>></input></td>
                 <td id="t13" style="width:15%" align="right">意向总价&nbsp;</td>
                <td id="t14">
					<input type="checkbox" name="customerRed.priceAmount" value="1" <s:if test="#request.customerRed.priceAmount == 1">checked="checked"</s:if>></input></td>
                <td id="t15" style="width:15%" align="right">产品类型&nbsp;</td>
                <td id="t16">
					<input type="checkbox" name="customerRed.houseType" value="1" <s:if test="#request.customerRed.houseType == 1">checked="checked"</s:if>></input></td>
              </tr>
              <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
                <td id="t15"  style="width:15%"  align="right">客户来源&nbsp;</td>
                <td id="t16">
					<input type="checkbox" name="customerRed.customerSource" value="1" <s:if test="#request.customerRed.customerSource == 1">checked="checked"</s:if>></input></td>
                 <td id="t13" style="width:15%" align="right">来访次数&nbsp;</td>
                <td id="t14">
					<input type="checkbox" name="customerRed.visitCount" value="1" <s:if test="#request.customerRed.visitCount== 1">checked="checked"</s:if>></input></td>
                <td id="t15" style="width:15%" align="right">性别&nbsp;</td>
                <td id="t16">
					<input type="checkbox" name="customerRed.gender" value="1" <s:if test="#request.customerRed.gender == 1">checked="checked"</s:if>></input></td>
              </tr>
              <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
                <td id="t1024"  style="width:15%"  align="right">国籍&nbsp;</td>
                <td id="t16">
					<input type="checkbox"  name="customerRed.nationality" value="1" <s:if test="#request.customerRed.nationality == 1">checked="checked"</s:if>></input></td>
                 <td id="t13" style="width:15%" align="right">身份证号码&nbsp;</td>
                <td id="t14">
					<input type="checkbox" name="customerRed.idcardNo" value="1" <s:if test="#request.customerRed.idcardNo == 1">checked="checked"</s:if>></input></td>
                <td id="t15" style="width:15%" align="right">驾车车型&nbsp;</td>
                <td id="t16">
					<input type="checkbox" name="customerRed.trafficDesc" value="1" <s:if test="#request.customerRed.trafficDesc == 1">checked="checked"</s:if>></input></td>
              </tr>
              <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
                <td id="t15"  style="width:15%"  align="right">年龄&nbsp;</td>
                <td id="t16">
					<input type="checkbox" name="customerRed.age" value="1" <s:if test="#request.customerRed.age == 1">checked="checked"</s:if>></input></td>
                 <td id="t13" style="width:15%" align="right">地址&nbsp;</td>
                <td id="t14">
					<input type="checkbox" name="customerRed.address" value="1" <s:if test="#request.customerRed.address == 1">checked="checked"</s:if>></input></td>
                <td id="t15" style="width:15%" align="right">邮编&nbsp;</td>
                <td id="t16">
					<input type="checkbox" name="customerRed.postcode" value="1" <s:if test="#request.customerRed.postcode == 1">checked="checked"</s:if>></input></td>
              </tr>
              <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
                <td id="t15"  style="width:15%"  align="right">家庭结构&nbsp;</td>
                <td id="t16">
					<input type="checkbox" name="customerRed.familyType" value="1" <s:if test="#request.customerRed.familyType == 1">checked="checked"</s:if>></input></td>
                 <td id="t13" style="width:15%" align="right">家庭收入&nbsp;</td>
                <td id="t14">
					<input type="checkbox" name="customerRed.familyIncome" value="1" <s:if test="#request.customerRed.familyIncome == 1">checked="checked"</s:if>></input></td>
                <td id="t15" style="width:15%" align="right">行业结构&nbsp;</td>
                <td id="t16">
					<input type="checkbox" name="customerRed.jobType" value="1" <s:if test="#request.customerRed.jobType == 1">checked="checked"</s:if>></input></td>
              </tr>
              <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
                <td id="t15"  style="width:15%"  align="right">职业&nbsp;</td>
                <td id="t16">
					<input type="checkbox" name="customerRed.jobIndustry" value="1" <s:if test="#request.customerRed.jobIndustry == 1">checked="checked"</s:if>></input></td>
                 <td id="t13" style="width:15%" align="right">购买单元1&nbsp;</td>
                <td id="t14">
					<input type="checkbox" name="customerRed.intentUnit1" value="1" <s:if test="#request.customerRed.intentUnit1 == 1">checked="checked"</s:if>></input></td>
                <td id="t15" style="width:15%" align="right">购买单元2&nbsp;</td>
                <td id="t16">
					<input type="checkbox" name="customerRed.intentUnit2" value="1" <s:if test="#request.customerRed.intentUnit2 == 1">checked="checked"</s:if>></input></td>
              </tr>
              <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
                <td id="t15"  style="width:15%"  align="right">购房目的&nbsp;</td>
                <td id="t16">
					<input type="checkbox" name="customerRed.buyAim" value="1" <s:if test="#request.customerRed.buyAim == 1">checked="checked"</s:if>></input></td>
                 <td id="t13" style="width:15%" align="right">付款方式&nbsp;</td>
                <td id="t14">
					<input type="checkbox" name="customerRed.payType" value="1" <s:if test="#request.customerRed.payType == 1">checked="checked"</s:if>></input></td>
                <td id="t15" style="width:15%" align="right">意向面积&nbsp;</td>
                <td id="t16">
					<input type="checkbox" name="customerRed.requestArea" value="1" <s:if test="#request.customerRed.requestArea == 1">checked="checked"</s:if>></input></td>
              </tr>
              <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
                <td id="t15"  style="width:15%"  align="right">意向套数&nbsp;</td>
                <td id="t16">
					<input type="checkbox" name="customerRed.intentBuynum" value="1" <s:if test="#request.customerRed.intentBuynum == 1">checked="checked"</s:if>></input></td>
                 <td id="t13" style="width:15%" align="right">意向户型&nbsp;</td>
                <td id="t14">
					<input type="checkbox" name="customerRed.roomType" value="1" <s:if test="#request.customerRed.roomType == 1">checked="checked"</s:if>></input></td>
                <td id="t15" style="width:15%" align="right">认知途径&nbsp;</td>
                <td id="t16">
					<input type="checkbox" name="customerRed.knownFrom" value="1" <s:if test="#request.customerRed.knownFrom == 1">checked="checked"</s:if>></input></td>
              </tr>
              <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
                <td id="t15"  style="width:15%"  align="right">关注点&nbsp;</td>
            	 <td id="t16">
					<input type="checkbox" name="customerRed.focusPoint" value="1" <s:if test="#request.customerRed.focusPoint == 1">checked="checked"</s:if>></input></td>
				
					<td id="t15"  style="width:15%"  align="right">客户评级&nbsp;</td>
            	 <td id="t16">
					<input type="checkbox" name="customerRed.reting" value="1" <s:if test="#request.customerRed.reting == 1">checked="checked"</s:if>></input></td>
					<td colspan="3"></td>
              </tr>
              
             
              <tr bgcolor="#FFFFFF";><td colspan="6"><input type="submit" value="  保存  " ></input></td></tr>
               <tr bgcolor="#FFFFFF";><td colspan="6"> <s:actionerror cssStyle="color:red" /></input></td></tr>
              </table>	
</td>
 </tr>
 <tr>
              <td colspan="6">
                <div class="manu">
				</div>                
			</td>
            </tr>
 </table>
 </form>

</table>

<%--固定的底部 --%>
<s:include value="body_bottom.jsp">
</s:include>
	</body>
</html>



   
   



