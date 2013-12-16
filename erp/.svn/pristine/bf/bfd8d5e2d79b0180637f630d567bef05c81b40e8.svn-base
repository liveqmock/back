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

	<script type="text/javascript">
	
	
	$().ready(function(){
	var old_pro_id = "0";
	$("#projectName").blur(function(){
		var pro_aja_id = $("#hiddenId").val();
		var projectName = $("#projectName").val();	
		if(projectName == ""){
			$("#hiddenId").val("0");
			$(".red").remove();
		}
		$("#showProject").html("<font color=\"red\">" + projectName + "</red>");
		val_jsp_and_proid(pro_aja_id); // 2012-11-05已经废弃自定义 
		if(pro_aja_id !=  old_pro_id){
			old_pro_id = pro_aja_id;
		}
	});
	
	function val_jsp_and_proid(proid){//本身就是 input2 jsp
			$.post('./customer_guangzhou/input/changeProject.action',{'changeProjectId':proid},function(date){
  			if(date == 'input2'){
      			location=location;
      		}
  		})
		}
	})
	
	
	</script>
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

    <form class="registerform" action="./customer_guangzhou/input/addCustomer.action?ts=<%= CacheUtils.getUrlTimeStamp()%>" method="get" >	
		  
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
                <td id="t16">
					<input type="text" id="projectName" name="projectName" value="<s:property value='#request.project.projectName'/>"/>
					<input type="hidden" id="hiddenId" name="customer.projectId" value="<s:property value='#request.project.id'/>"/>
				      
                </td>
                <td> <div><font color="red">请首先确定项目</font></div></td>
            	   <td></td>
                <td style="width:15%"  align="right"></td>
                <td></td>
				 
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
					<input class="Wdate" type="text" id="visitDate" style="width:90px" name="customer.visitDate" value="${nowDate}"/>
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
					<!--
					<s:select list="selHomeBlock"  name="customer.homeBlock" value="#session.cacheCustomer.homeBlock" cssStyle="width:auto"/>
					-->
					
				</td>
             </tr>
			  
			  <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
                <td id="t13"  align="right"><font color="red">*</font>工作区域&nbsp;</td>
                <td colspan="5">
					<s:select list="selProvince"  name="customer.workProvince" value="#session.cacheCustomer.workProvince" cssStyle="width:auto"/>省
					<s:select list="selWorkCity"  name="customer.workCity" value="#session.cacheCustomer.workCity" cssStyle="width:auto"/>市
					<s:select list="selWorkRegion"  name="customer.workRegion" value="#session.cacheCustomer.workRegion" cssStyle="width:auto"/>
					<input type="text" id="workContent" name="customer.workContent" value="<s:property value='#session.cacheCustomer.workContent'/>" /> 
					<!--
					<s:select list="selWorkBlock"  name="customer.workBlock" value="#session.cacheCustomer.workBlock" cssStyle="width:auto"/>
					-->
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
              <td colspan="6" id="input_buttom_id">
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
