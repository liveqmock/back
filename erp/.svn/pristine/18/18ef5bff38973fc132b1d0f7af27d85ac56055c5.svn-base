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
	
	<title>楼盘货量分析</title>
	
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
<div class="title02" ><a href="./report/guangzhou/propertyNum.action" target="_self">楼盘货量分析</a></div>
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
	<td width="180" align="center">楼盘</td>
	<td width="180"><input></input></td>
	<td width="180">类型</td>
	<td width="180"><select>
	<option>楼层</option>
	<option>面积</option>
	<option>单价</option>
	<option>总价</option>
	<option>户型</option>
	</select></td>
   <td align="center" valign="middle" width="180">
	日期范围	</td>
	
     <td width="187" align="left" valign="middle">
    <input class="Wdate" style="width:90px"></input>-<input class="Wdate" style="width:90px"></input>

	 </td>
	
	<td>
   	<input type="button" value="  搜索  " id="searchSubmit"/></td> 
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
    <td width="150px" align="center">类型</td>
    <td colspan="4" align="center">总货量</td>
    <td  colspan="4" align="center">推出货量</td>
    <td   colspan="5" align="center">总剩余货量</td>
    <td   colspan="4" align="center">认购情况</td>
    <td   colspan="5" align="center">已签约情况</td>
    <td   colspan="4" align="center">未签约情况</td>
    <td   colspan="5" align="center">推出剩余货量</td>
  </tr>
  <tr class="gboxbg">
  <td></td>
  <td width="150px" align="center">总套数</td>
  <td width="150px" align="center">总面积</td>
  <td width="150px" align="center">总金额</td>
  <td width="150px" align="center">均价</td>

  <td width="150px" align="center">总套数</td>
  <td width="150px" align="center">总面积</td>
  <td width="150px" align="center">总金额</td>
  <td width="150px" align="center">均价</td>
  
  <td width="150px" align="center">总套数</td>
  <td width="150px" align="center">总面积</td>
  <td width="150px" align="center">总金额</td>
  <td width="150px" align="center">均价</td>
  <td width="150px" align="center">余货比例</td>
  
  <td width="150px" align="center">总量</td>
  <td width="150px" align="center">成交面积</td>
  <td width="150px" align="center">成交金额</td>
  <td width="150px" align="center">均价</td>
  
  <td width="150px" align="center">总量</td>
  <td width="150px" align="center">签约面积</td>
  <td width="150px" align="center">签约金额</td>
  <td width="150px" align="center">均价</td>
  <td width="150px" align="center">签约率</td>
  
  <td width="150px" align="center">总量</td>
  <td width="150px" align="center">签约面积</td>
  <td width="150px" align="center">签约金额</td>
  <td width="150px" align="center">均价</td>
  
  <td width="150px" align="center">总量</td>
  <td width="150px" align="center">面积</td>
  <td width="150px" align="center">金额</td>
  <td width="150px" align="center">均价</td>
  <td width="150px" align="center">剩余率</td>
  
  </tr>
  <tr onMouseOver="this.style.backgroundColor='#f1f9fe';" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF">
  <td>1层</td>
  <td align="right">1</td>
  <td align="right">1</td>
  <td align="right">1</td>
  <td align="right">1</td>
  <td align="right">1</td>
  <td align="right">1</td>
  <td align="right">1</td>
  <td align="right">1</td>
  <td align="right">1</td>
  <td align="right">1</td>
  <td align="right">1</td>
  <td align="right">1</td>
  <td align="right">1</td>
  <td align="right">1</td>
  <td align="right">1</td>
  <td align="right">1</td>
  <td align="right">1</td>
  <td align="right">1</td>
  <td align="right">1</td>
  <td align="right">1</td>
  <td align="right">1</td>
  <td align="right">1</td>
  <td align="right">1</td>
  <td align="right">1</td>
  <td align="right">1</td>
  <td align="right">1</td>
  <td align="right">1</td>
  <td align="right">1</td>
  <td align="right">1</td>
  <td align="right">1</td>
   <td align="right">1</td>
  </tr>
  <tr onMouseOver="this.style.backgroundColor='#f1f9fe';" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF">
  <td>2层</td>
  <td align="right">1</td>
  <td align="right">1</td>
  <td align="right">1</td>
  <td align="right">1</td>
  <td align="right">1</td>
  <td align="right">1</td>
  <td align="right">1</td>
  <td align="right">1</td>
  <td align="right">1</td>
  <td align="right">1</td>
  <td align="right">1</td>
  <td align="right">1</td>
  <td align="right">1</td>
  <td align="right">1</td>
  <td align="right">1</td>
  <td align="right">1</td>
  <td align="right">1</td>
  <td align="right">1</td>
  <td align="right">1</td>
  <td align="right">1</td>
  <td align="right">1</td>
  <td align="right">1</td>
  <td align="right">1</td>
  <td align="right">1</td>
  <td align="right">1</td>
  <td align="right">1</td>
  <td align="right">1</td>
  <td align="right">1</td>
  <td align="right">1</td>
  <td align="right">1</td>
   <td align="right">1</td>
  </tr>
  <tr onMouseOver="this.style.backgroundColor='#f1f9fe';" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF">
  <td>3层</td>
  <td align="right">1</td>
  <td align="right">1</td>
  <td align="right">1</td>
  <td align="right">1</td>
  <td align="right">1</td>
  <td align="right">1</td>
  <td align="right">1</td>
  <td align="right">1</td>
  <td align="right">1</td>
  <td align="right">1</td>
  <td align="right">1</td>
  <td align="right">1</td>
  <td align="right">1</td>
  <td align="right">1</td>
  <td align="right">1</td>
  <td align="right">1</td>
  <td align="right">1</td>
  <td align="right">1</td>
  <td align="right">1</td>
  <td align="right">1</td>
  <td align="right">1</td>
  <td align="right">1</td>
  <td align="right">1</td>
  <td align="right">1</td>
  <td align="right">1</td>
  <td align="right">1</td>
  <td align="right">1</td>
  <td align="right">1</td>
  <td align="right">1</td>
  <td align="right">1</td>
   <td align="right">1</td>
  </tr>
  <tr onMouseOver="this.style.backgroundColor='#f1f9fe';" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF">
  <td>4层</td>
  <td align="right">1</td>
  <td align="right">1</td>
  <td align="right">1</td>
  <td align="right">1</td>
  <td align="right">1</td>
  <td align="right">1</td>
  <td align="right">1</td>
  <td align="right">1</td>
  <td align="right">1</td>
  <td align="right">1</td>
  <td align="right">1</td>
  <td align="right">1</td>
  <td align="right">1</td>
  <td align="right">1</td>
  <td align="right">1</td>
  <td align="right">1</td>
  <td align="right">1</td>
  <td align="right">1</td>
  <td align="right">1</td>
  <td align="right">1</td>
  <td align="right">1</td>
  <td align="right">1</td>
  <td align="right">1</td>
  <td align="right">1</td>
  <td align="right">1</td>
  <td align="right">1</td>
  <td align="right">1</td>
  <td align="right">1</td>
  <td align="right">1</td>
  <td align="right">1</td>
   <td align="right">1</td>
  </tr>
  <tr class="gboxbg">
  <td>合计</td>
  <td align="right">1</td>
  <td align="right">1</td>
  <td align="right">1</td>
  <td align="right">1</td>
  <td align="right">1</td>
  <td align="right">1</td>
  <td align="right">1</td>
  <td align="right">1</td>
  <td align="right">1</td>
  <td align="right">1</td>
  <td align="right">1</td>
  <td align="right">1</td>
  <td align="right">1</td>
  <td align="right">1</td>
  <td align="right">1</td>
  <td align="right">1</td>
  <td align="right">1</td>
  <td align="right">1</td>
  <td align="right">1</td>
  <td align="right">1</td>
  <td align="right">1</td>
  <td align="right">1</td>
  <td align="right">1</td>
  <td align="right">1</td>
  <td align="right">1</td>
  <td align="right">1</td>
  <td align="right">1</td>
  <td align="right">1</td>
  <td align="right">1</td>
  <td align="right">1</td>
   <td align="right">1</td>
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

