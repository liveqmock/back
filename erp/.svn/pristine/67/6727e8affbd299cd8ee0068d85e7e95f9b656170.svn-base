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
	
	<title>查询合同</title>
	
	<base href="<%=basePath%>">
		
	<s:include value="../../customer/guangzhou/header.jsp"></s:include>	  
	<s:include value="../../customer/guangzhou/header_left_js.jsp"></s:include>	 
	
	<link href="./css/unit_table.css"  rel="stylesheet" type="text/css" charset="utf-8"/><!-- unit的样式 -->
	
	<script type="text/javascript" language="javascript" src="<%=basePath%>js/customer_guangzhou_project.js"></script>	 
	<script type="text/javascript" language="javascript" src="<%=basePath%>js/customer_alldel.js"></script>	 
	<script type="text/javascript" language="javascript" src="<%=basePath%>js/customer_guangzhou_user.js"></script>	 
	<script type="text/javascript" language="javascript" src="<%=basePath%>js/customer_common.js"></script>	 
	
	<script type="text/javascript" language="javascript" src="<%=basePath%>js/unit_table.js"></script>	<!-- unit table -->
			
	<script type="text/javascript" language="javascript">
		$(document).ready(function(){	
		
			showDiv("unitId","hiddenUnitId","hiddenBulidId","hiddenId");			
			
			propertyProjectListForHiddenId("projectName", "hiddenId"); //项目的联想框,及用隐藏域保存其id
			
			getBuildListFromPropertyIdForAuto("buildName", "hiddenId", "hiddenBulidId");  //根据楼盘项目id,获取对应的楼栋联想提示框
			
			userListForHiddenId("salesName", "hiddenSalesId");	
			
			confirmCustomerListForHiddenId("customerName", "hiddenCustomerId");   //confirm customer 的联想输入框		
			
			//项目id有变化,要清空楼栋的值与id
			$("#projectName").change(function(){
				$("#buildName").val("");
				//$("#hiddenBulidId").html("");
				$("#hiddenBulidId").attr("value", ""); 				
			});
						
			obIcon();
			
		});
		
		
	</script>
	
	<style>
		*{margin:0;padding:0;}
		
	</style>
	
  </head>
  
 <body onload="clearSome('suggestion', 2000)">
 
 
<%--固定的上部 --%>
<s:include value="../../customer/guangzhou/body_up.jsp">
</s:include>

<%--主体导航页头 --%>
<div class="title02" ><a href="./saleunit/contract/guangzhou/searchList.action" target="_self">查询合同</a></div>
<div class="title01"><a href="./saleunit/contract/guangzhou/forInput.action" target="_self">新建合同</a></div>	
<div class="right99"></div>
<div class="blueline"></div>		
		
<%--主体table top --%>
		
  		<div class="c"></div>
          <div class="c">		  	
			  &nbsp;&nbsp;	
			<font color="#FF0000"><span id="suggestion"><s:property value="#request.session.suggestion"/></span></font>
		  </div>	
		  
		  <table style="width: -moz-available;" align="left" border="0" cellspacing="0">		  
		  
		  <!-- 搜索表单 top -->
       
     <form class="registerform" id="searchForm" action="<%=request.getContextPath() %>/saleunit/contract/guangzhou/searchList.action" method="post" >
		  <tr>
		  	<td colspan="6">
			
			 <table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" class="gbox" style="white-space:nowrap">
		 
  			<tr onMouseOver="this.style.backgroundColor='#f1f9fe';" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF">

    <td align="center" valign="middle" width="180">楼盘项目</td>
	
	<td width="187" align="left" valign="middle">
		<input type="text" id="projectName" name="cond.propertyName" value="${cond.propertyName}"/>	
		<input type="hidden" id="hiddenId" name="cond.propertyId" value="${cond.propertyId}"/>
	</td>
	
   <td align="center" valign="middle" width="180">
   分区楼栋
	</td>
	
     <td width="187" align="left" valign="middle">
	<input type="text" id="buildName" name="cond.buildName" value="${cond.buildName}"/>	
	<input type="hidden" id="hiddenBulidId" name="cond.buildId" value="${cond.buildId}"/>
	 </td>
	
   <td align="center" valign="middle">房间</td>
	
     <td width="187" align="left" valign="middle">
	 	<input type="text" id="unitId" name="cond.unitName" value="${cond.unitName}"/>
		<input type="hidden" id="hiddenUnitId" name="cond.unitId" value="${cond.unitId}"/>

		<!--
		<input type="hidden" id="hiddenUnitId" name="cond.unitId" value="680"/>
		-->
	 </td>
	 
  </tr>
  
  <tr onMouseOver="this.style.backgroundColor='#f1f9fe';" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF">

    <td align="center" valign="middle">客户名称</td>
	
	<td width="187" align="left" valign="middle">
	 	<input type="text" id="customerName" name="cond.customerName" value="${cond.customerName}"/>
		<input type="hidden" id="hiddenCustomerId" name="cond.customerId" value="${cond.customerId}"/>
		
	</td>
	
   <td align="center" valign="middle">
  业务员
		</td>
	
     <td width="187" align="left" valign="middle" style="white-space:nowrap">
	 <input type="text" id="salesName" name="cond.salesName" value="${cond.salesName}"/>
	 <input type="hidden" id="hiddenSalesId" name="cond.salesId" value="${cond.salesId}"/>
	 </td> 
	
   <td align="center" valign="middle">
    	<input type="submit" value="  搜索  " id="searchSubmit"/>
	 	 </td>
	 
     <td width="120" align="left" valign="middle">
	 </td>
	 
  </tr>
  
  
  </table>
			
			</td>
		  </tr>
			
		</form>
		  
		<!-- 搜索表单 end -->
			
            <tr>
              <td height="10" colspan="6">
              <div class="blueline"></div>
              </td>
            </tr>		
		
			 <tr>
              <td height="20" colspan="6">
				<div id="load"></div>
				
				</td>
            </tr>
			
            <tr>
              <td colspan="6">			  
			  
			  <!--  列表 top -->
			  <div class="gbox1">			  
			  
			  <table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" class="gbox" >
  <tr class="gboxbg">
    
	 <td width="20" align="center">
	<label for="checkbox">
	  <input name="allDel" type="checkbox" value="" onClick="allDel()" id="allDel"/>      
      </label>
	 </td>

	<td width="197" align="center" valign="middle">楼盘项目</td> 
	
    <td width="197" align="center" valign="middle">房间</td>   
	
    <td width="120" align="center">客户名称
	</td>
	
	<td width="120" align="center">合同编号
	</td>
	
     <td width="187" align="center" valign="middle">
     
	<table width="100" height="28"  border="0" align="center" cellspacing="0">
      <tr>
        <td width="80%" align="center" valign="middle">签署日期</td>
        <td align="center" valign="middle"><table width="5" border="0" cellspacing="0">
          <tr>
            <td><a href="./saleunit/contract/guangzhou/searchOrderBy.action?ob=12"><img id="img12" src="images/blue/upn.gif" width="9" height="10" border="0" /></a></td>
          </tr>
          <tr>
            <td><a href="./saleunit/contract/guangzhou/searchOrderBy.action?ob=11"><img id="img11" src="images/blue/downn.gif" width="9" height="10" border="0" /></a></td>
          </tr>
        </table>
	</td>
      </tr>
    </table>
    
		
	</td>
	
	 <td width="100" align="center" valign="middle">
		合同总价
	</td>
	
	 <td width="100" align="center">付款方式</td>
	
	<td width="100" align="center" valign="middle">
		业务员
	</td>
		
	 <td width="100" align="center" valign="middle">
		审核人
	</td>
	
  
  </tr>
 
 
  
   <s:iterator value="#request.contractList" id="c">  
	  <tr onMouseOver="this.style.backgroundColor='#f1f9fe';" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
	   title='客户名称:<s:property value="#c.customerName"/>, 认购日期:<s:date name="#c.signDate" format="yyyy-MM-dd "/>'> 
		<td width="20" align="center"><input name="delId" type="checkbox" value="<s:property value='#c.id'/>" onClick="delId()" /></td>
		
		<td align="center" valign="middle">
			${c.propertyProjectName}
		</td>

		<td align="center" valign="middle" class="fontblue">
			<a href="./saleunit/contract/guangzhou/getById.action?id=${c.id}" target="_self">${c.propertyUnitNo}</a>
			 
		</td>
		<td align="center" valign="middle">
			<s:property value="#c.customerName"/>
		</td>
		<td align="center" valign="middle" class="fontblue">
			<a href="./saleunit/contract/guangzhou/getById.action?id=${c.id}" target="_self">${c.contractNo}</a>
		</td>
		<td align="center" valign="middle">
			<s:date name="#c.signDate" format="yyyy-MM-dd "/>
		</td>
		
		<td align="center" valign="middle">
			${c.contractMoney}
		</td>
		
		<td align="center" valign="middle">
			<s:property value="#c.payTypeStr"/>
		</td>
		
		<td align="center" valign="middle">
			<s:property value="#c.saleName"/>
		</td>
		
		
		<td align="center" valign="middle">
			<s:property value="#c.auditName"/>
		</td>
		
		
	  </tr>
    </s:iterator>
  
</table>
			  
			   </div>

<!-- 列表 end -->


</td>
            </tr>
            <tr>
              <td colspan="6">
                <div class="manu">
					<s:property value="showPage" escape="false"/>
				</div>                
			</td>
            </tr>
 </table>


<%--主体table end --%>



<%--固定的底部 --%>
<s:include value="../../customer/guangzhou/body_bottom.jsp">
</s:include>
</table>  
   
</body>
</html>

