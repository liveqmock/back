<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page contentType="text/html; charset=utf-8" %>
<%@ page import="com.ihk.permission.PermissionUtils"%>
<%@page import="com.ihk.constanttype.EnumDevFlag"%>
<%@page import="com.ihk.constanttype.EnumPrivCode"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
	
	<title>销售分析</title>
	
	<base href="<%=basePath%>">
		
	<s:include value="../../customer/guangzhou/header.jsp"></s:include>	  
	<s:include value="../../customer/guangzhou/header_left_js.jsp"></s:include>	 
	
	<script type="text/javascript" language="javascript" src="<%=basePath%>js/customer_guangzhou_project.js"></script>	 
	<script type="text/javascript" language="javascript" src="<%=basePath%>js/customer_alldel.js"></script>	 
	<script type="text/javascript" language="javascript" src="<%=basePath%>js/customer_guangzhou_user.js"></script>	 
	<script type="text/javascript" language="javascript" src="<%=basePath%>js/customer_common.js"></script>	 
		
	<script type="text/javascript" language="javascript">
		$(document).ready(function(){				
			
			projectListForHiddenId("projectName", "hiddenId"); //项目的联想框,及用隐藏域保存其id
			
			obIcon();
			
		});
			
		function resetValue(){
			
			$("#projectName").val("");
			$("#unitId").val("");
			$("#realNum").val("");
			$("#unitNum").val("");
			$("#date1").val("");
			$("#date2").val("");
			$("#salesId").val("");
			$("#customerName").val("");			
			
			$("#hiddenId").val("0");
			
			return true;
		}
		
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
<div class="title02" ><a href="./saleunit/analysis/guangzhou/searchList.action" target="_self">销售分析</a></div>
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
       
     <form class="registerform" id="searchForm" action="<%=request.getContextPath() %>/saleunit/appoint/guangzhou/index.action" method="post" >
		  <tr>
		  	<td colspan="6">
			

		 <table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" class="gbox" style="white-space:nowrap">
		 
  			<tr onMouseOver="this.style.backgroundColor='#f1f9fe';" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF">

    <td align="center" valign="middle" width="80">项目</td>
	
	<td width="187" align="left" valign="middle">
		<input type="text" id="projectName" name="cond.propertyName" value="${cond.propertyName}"/>	
		<input type="hidden" id="hiddenId" name="cond.propertyId" value="${cond.propertyId}"/>
		</td>
    <td align="center" valign="middle" width="80">楼栋</td>	
	<td width="187" align="left" valign="middle">
		<input type="text" id="projectNamex" name="cond.propertyName" value="${cond.propertyName}"/>	
		</td>
	
   <td align="center" valign="middle" width="100">
	产品类型	</td>
	
     <td width="100" align="left" valign="middle">
	 	<input type="text" id="customerName" name="cond.customerId" value="${cond.customerId}"/>
	 </td>
   <td align="center" valign="middle" width="100">
	面积类型	</td>
	
     <td width="187" align="left" valign="middle">
     <input></input>
     </td>
	
	<td  align="left" width="100">
   	<input type="submit" value="  搜索  " id="searchSubmit"/></td> 
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
			  <th colspan="10" align="center">销售进展明细</th>
			  </tr>
			  <tr class="gboxbg">
				 <td width="150" align="center" valign="middle">
					
				</td>
				<td width="100" align="center" valign="middle">
					<b>总数</b>
				</td>
				 <td width="100" align="center" valign="middle">
					签约
				</td>
				 <td width="100" align="center" valign="middle">
					认购
				</td>
				 <td width="100" align="center" valign="middle">
					小订
				</td>
				 <td width="100" align="center" valign="middle">
					预留
				</td>
				 <td width="100" align="center" valign="middle">
					预约
				</td>
				 <td width="100" align="center" valign="middle">
					待售
				</td>
				 <td width="100" align="center" valign="middle">
					销控
				</td>
				 <td width="100" align="center" valign="middle">
					非售
				</td>
			  </tr>
			  <tr bgcolor="#FFFFFF">
				 <td width="100" align="center" valign="middle" class="gboxbg">
					<b>销售套数</b>
				</td>
				 <td width="100" align="center" valign="middle">
					
				</td>
				 <td width="100" align="center" valign="middle">
					
				</td>
				 <td width="100" align="center" valign="middle">
					
				</td>
				 <td width="100" align="center" valign="middle">
					
				</td>
				 <td width="100" align="center" valign="middle">
					
				</td>
				 <td width="100" align="center" valign="middle">
					
				</td>
				 <td width="100" align="center" valign="middle">
					
				</td>
				 <td width="100" align="center" valign="middle">
					
				</td>
				 <td width="100" align="center" valign="middle">
					
				</td>
			  </tr>
			  <tr bgcolor="#FFFFFF">
				 <td width="100" align="center" valign="middle" class="gboxbg">
					销售套数比例
				</td>
				 <td width="100" align="center" valign="middle">
					
				</td>
				 <td width="100" align="center" valign="middle">
					
				</td>
				 <td width="100" align="center" valign="middle">
					
				</td>
				 <td width="100" align="center" valign="middle">
					
				</td>
				 <td width="100" align="center" valign="middle">
					
				</td>
				 <td width="100" align="center" valign="middle">
					
				</td>
				 <td width="100" align="center" valign="middle">
					
				</td>
				 <td width="100" align="center" valign="middle">
					
				</td>
				 <td width="100" align="center" valign="middle">
					
				</td>
			  </tr>
			  <tr bgcolor="#FFFFFF">
				 <td width="100" align="center" valign="middle" class="gboxbg">
					<b>销售面积(建筑)</b>
				</td>
				 <td width="100" align="center" valign="middle">
					
				</td>
				 <td width="100" align="center" valign="middle">
					
				</td>
				 <td width="100" align="center" valign="middle">
					
				</td>
				 <td width="100" align="center" valign="middle">
					
				</td>
				 <td width="100" align="center" valign="middle">
					
				</td>
				 <td width="100" align="center" valign="middle">
					
				</td>
				 <td width="100" align="center" valign="middle">
					
				</td>
				 <td width="100" align="center" valign="middle">
					
				</td>
				 <td width="100" align="center" valign="middle">
					
				</td>
			  </tr>
			  <tr bgcolor="#FFFFFF">
				 <td width="100" align="center" valign="middle" class="gboxbg">
					销售面积(建筑)比例
				</td>
				 <td width="100" align="center" valign="middle">
					
				</td>
				 <td width="100" align="center" valign="middle">
					
				</td>
				 <td width="100" align="center" valign="middle">
					
				</td>
				 <td width="100" align="center" valign="middle">
					
				</td>
				 <td width="100" align="center" valign="middle">
					
				</td>
				 <td width="100" align="center" valign="middle">
					
				</td>
				 <td width="100" align="center" valign="middle">
					
				</td>
				 <td width="100" align="center" valign="middle">
					
				</td>
				 <td width="100" align="center" valign="middle">
					
				</td>
			  </tr>
			  <tr bgcolor="#FFFFFF">
				 <td width="100" align="center" valign="middle" class="gboxbg">
					<b>销售面积(套内)</b>
				</td>
				 <td width="100" align="center" valign="middle">
					
				</td>
				 <td width="100" align="center" valign="middle">
					
				</td>
				 <td width="100" align="center" valign="middle">
					
				</td>
				 <td width="100" align="center" valign="middle">
					
				</td>
				 <td width="100" align="center" valign="middle">
					
				</td>
				 <td width="100" align="center" valign="middle">
					
				</td>
				 <td width="100" align="center" valign="middle">
					
				</td>
				 <td width="100" align="center" valign="middle">
					
				</td>
				 <td width="100" align="center" valign="middle">
					
				</td>
			  </tr>
			  <tr bgcolor="#FFFFFF">
				 <td width="100" align="center" valign="middle" class="gboxbg">
					销售面积(套内)比例
				</td>
				 <td width="100" align="center" valign="middle">
					
				</td>
				 <td width="100" align="center" valign="middle">
					
				</td>
				 <td width="100" align="center" valign="middle">
					
				</td>
				 <td width="100" align="center" valign="middle">
					
				</td>
				 <td width="100" align="center" valign="middle">
					
				</td>
				 <td width="100" align="center" valign="middle">
					
				</td>
				 <td width="100" align="center" valign="middle">
					
				</td>
				 <td width="100" align="center" valign="middle">
					
				</td>
				 <td width="100" align="center" valign="middle">
					
				</td>
			  </tr>
			  <tr bgcolor="#FFFFFF">
				 <td width="100" align="center" valign="middle" class="gboxbg">
					<b>平均价格</b>
				</td>
				 <td width="100" align="center" valign="middle">
					
				</td>
				 <td width="100" align="center" valign="middle">
					
				</td>
				 <td width="100" align="center" valign="middle">
					
				</td>
				 <td width="100" align="center" valign="middle">
					
				</td>
				 <td width="100" align="center" valign="middle">
					
				</td>
				 <td width="100" align="center" valign="middle">
					
				</td>
				 <td width="100" align="center" valign="middle">
					
				</td>
				 <td width="100" align="center" valign="middle">
					
				</td>
				 <td width="100" align="center" valign="middle">
					
				</td>
			  </tr>
			  <tr bgcolor="#FFFFFF">
				 <td width="100" align="center" valign="middle" class="gboxbg">
					<b>销售金额</b>
				</td>
				 <td width="100" align="center" valign="middle">
					
				</td>
				 <td width="100" align="center" valign="middle">
					
				</td>
				 <td width="100" align="center" valign="middle">
					
				</td>
				 <td width="100" align="center" valign="middle">
					
				</td>
				 <td width="100" align="center" valign="middle">
					
				</td>
				 <td width="100" align="center" valign="middle">
					
				</td>
				 <td width="100" align="center" valign="middle">
					
				</td>
				 <td width="100" align="center" valign="middle">
					
				</td>
				 <td width="100" align="center" valign="middle">
					
				</td>
			  </tr>
			  <tr bgcolor="#FFFFFF">
				 <td width="100" align="center" valign="middle" class="gboxbg">
					销售金额比例
				</td>
				 <td width="100" align="center" valign="middle">
					
				</td>
				 <td width="100" align="center" valign="middle">
					
				</td>
				 <td width="100" align="center" valign="middle">
					
				</td>
				 <td width="100" align="center" valign="middle">
					
				</td>
				 <td width="100" align="center" valign="middle">
					
				</td>
				 <td width="100" align="center" valign="middle">
					
				</td>
				 <td width="100" align="center" valign="middle">
					
				</td>
				 <td width="100" align="center" valign="middle">
					
				</td>
				 <td width="100" align="center" valign="middle">
					
				</td>
			  </tr>
			  </table>
</div>

<!-- 列表 end -->


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

