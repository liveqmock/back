<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page contentType="text/html; charset=utf-8" %>

<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
	
	<title>修改客户信息</title>
	
	<base href="<%=basePath%>"/>
		
	<s:include value="header.jsp"></s:include>	  
	<s:include value="header_left_js.jsp"></s:include>	  
	<s:include value="../../customer/log/customer_log_include.jsp"></s:include>
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

	<script type="text/javascript">
		$().ready(function(){
			$("#showLog").click(function(){
				dialog_customerlog_list(${c.id})
				})
		})
	</script>
  </head>
  
 <body onload="clearSuggestion()">
 
 
<%--固定的上部 --%>
<s:include value="body_up.jsp">
</s:include>

<%--主体导航页头 --%>
<div class="title01" ><a href="./customer_guangzhou/search/index.action" target="_self">查询客户</a></div>
<div class="title01"><a href="./customer_guangzhou/input/forAdd.action" target="_self">新建客户</a></div>	
<div class="right99"></div>
<div class="blueline"></div>		
		
<%--主体table top --%>
		
  		<div class="c"></div>
          <div class="c">		  	
			  &nbsp;&nbsp;	
			<font color="#FF0000"><span id="suggestion"><s:property value="#request.session.suggestion"/></span></font>
		  </div>	
		  
	  <form class="registerform" action="./customer_guangzhou/update/toUpdateQuestion.action" method="post"  onsubmit="return validateCustForm();">
		  
		  <table style="width: 980px;" align="left" border="0" cellspacing="0">		  
		  
		  <tr>
		  	<td colspan="6">
			

		 <table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" class="gbox" >
		 
  			 <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
			 	<td colspan="6" style="background-color: #eeeeee; font-weight: bold;">&nbsp;&nbsp;必填</td>
			 </tr>
			 
			  <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
                <td id="t15"  style="width:15%"  align="right"><font color="red">*</font>项目&nbsp;</td>
                <td id="t16" colspan="3">
					<input type="text" id="projectName" disabled="disabled" value="<s:property value='#session.selectedProjectName'/>"/>
					<input type="hidden" id="hiddenId" value="<s:property value='#session.c.projectId'/>"/>
				</td>
				<td id="t15"  style="width:15%"  align="right"></td>
                <td id="t16">  
                <a style="color:#1199FF;cursor: pointer" id="showLog" >客户修改信息</a>
                </td>
				 
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
			 	<td colspan="6" style="background-color: #eeeeee; font-weight: bold;">&nbsp;&nbsp;选填</td>
			 </tr>
			 
			 <s:iterator value="questionDetailList" var="c">
			 <tr style="line-height: 20px" onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
			  	 <td colspan="6" id="t11"  align="left"> ${c.topicName }</td>
               
			  </tr>
			   <tr style="line-height: 20px" onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
                <td  id="t12" colspan="6">
                	${c.inputAndOtherHtml }
				</td>
			  </tr>
			 </s:iterator>
			  
			</table>

			
			
		  </td>
		  </tr>
		  
		
            <tr>
              <td colspan="6">			  
			  
			  


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

<%--主体table end --%>



<%--固定的底部 --%>
<s:include value="body_bottom.jsp">
</s:include>
</table>  
   
  </body>
</html>

