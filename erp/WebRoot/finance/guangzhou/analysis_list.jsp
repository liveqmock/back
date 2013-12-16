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
	
	<title>财务分析</title>
	
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
<div class="title02" ><a href="./finance/guangzhou/analysis.action" target="_self">财务分析</a></div>
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
	日期范围	</td>
	
     <td width="187" align="left" valign="middle">
	 	<input type="text" id="customerName" name="cond.customerId" value="${cond.customerId}"/>-
	 	<input type="text" id="customerName" name="cond.customerId" value="${cond.customerId}"/>
	 </td>
	
	<td>
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
			  <th colspan="10" align="left">房款收取情况</th>
			  </tr>
			  <tr bgcolor="#FFFFFF">
				 <td width="100" align="center" valign="middle" >
					应收
				</td>
				 <td width="100" align="center" valign="middle" colspan="2">
					<input style="width:98%"></input>
				</td>
				 <td width="100" align="center" valign="middle">
					实收
				</td>
				 <td width="100" align="center" valign="middle" colspan="2">
					<input style="width:98%"></input>
				</td>
			  </tr>
			  <tr bgcolor="#FFFFFF">
			  <td></td>
			  <td>贷款合计</td>
			  <td>
					<input style="width:98%"></input></td>
			  <td></td>
			  <td>贷款合计</td>
			  <td>
					<input style="width:98%"></input></td>
			  </tr>
			  <tr bgcolor="#FFFFFF">
			  <td></td>
			  <td>银行按揭</td>
			  <td>
					<input style="width:98%"></input></td>
			  <td></td>
			  <td>银行按揭</td>
			  <td>
					<input style="width:98%"></input></td>
			  </tr>
			  <tr bgcolor="#FFFFFF">
			  <td></td>
			  <td>公积金</td>
			  <td>
					<input style="width:98%"></input></td>
			  <td></td>
			  <td>公积金</td>
			  <td>
					<input style="width:98%"></input></td>
			  </tr>
			  <tr bgcolor="#FFFFFF">
			  <td></td>
			  <td>客户应交</td>
			  <td>
					<input style="width:98%"></input></td>
			  <td></td>
			  <td>客户交款</td>
			  <td>
					<input style="width:98%"></input></td>
			  </tr>
			  <tr bgcolor="#FFFFFF"><td colspan="6">&nbsp;</td></tr>
			  
			  <tr bgcolor="#FFFFFF">
				 <td width="100" align="center" valign="middle" >
					未收
				</td>
				 <td width="100" align="center" valign="middle" colspan="2">
					<input style="width:98%"></input>
				</td>
				 <td width="100" align="center" valign="middle">
					多收
				</td>
				 <td width="100" align="center" valign="middle" colspan="2">
					<input style="width:98%"></input>
				</td>
			  </tr>
			  <tr bgcolor="#FFFFFF">
			  <td></td>
			  <td>贷款合计</td>
			  <td>
					<input style="width:98%"></input></td>
			  <td></td>
			  <td>贷款合计</td>
			  <td>
					<input style="width:98%"></input></td>
			  </tr>
			  <tr bgcolor="#FFFFFF">
			  <td></td>
			  <td>银行按揭</td>
			  <td>
					<input style="width:98%"></input></td>
			  <td></td>
			  <td>银行按揭</td>
			  <td>
					<input style="width:98%"></input></td>
			  </tr>
			  <tr bgcolor="#FFFFFF">
			  <td></td>
			  <td>公积金</td>
			  <td>
					<input style="width:98%"></input></td>
			  <td></td>
			  <td>公积金</td>
			  <td>
					<input style="width:98%"></input></td>
			  </tr>
			  <tr bgcolor="#FFFFFF">
			  <td></td>
			  <td>应收未收</td>
			  <td>
					<input style="width:98%"></input></td>
			  <td></td>
			  <td>客户交款</td>
			  <td>
					<input style="width:98%"></input></td>
			  </tr>
			  <tr bgcolor="#FFFFFF">
			  <td></td>
			  <td>未到期</td>
			  <td>
					<input style="width:98%"></input></td>
					<td></td><td></td><td></td></tr>
					
					<tr class="gboxbg">
			  <th colspan="3" align="left">代收费用收取情况</th>
			  <th colspan="3" align="left" style="border-color: blue;border-left: 1px;border-top: 1px;border-right: 1px;border-style: solid;">其他收取情况</th>
			  </tr>
					<tr  bgcolor="#FFFFFF">
			  <td align="center">应收</td>
			  <td colspan="2">
					<input style="width:98%"></input></td>
			  <td align="center" class="gboxbg" style="border-color: blue;border-left: 1px;border-style: solid;">应收</td>
			  <td colspan="2" class="gboxbg" style="border-color: blue;border-right: 1px;border-style: solid;">
					<input style="width:98%"></input></td>
					</tr>
					<tr  bgcolor="#FFFFFF">
			  <td align="center">实收</td>
			  <td colspan="2">
					<input style="width:98%"></input></td>
			  <td align="center" class="gboxbg"  style="border-color: blue;border-left: 1px;border-style: solid;">实收</td>
			  <td colspan="2" class="gboxbg" style="border-color: blue;border-right: 1px;border-style: solid;">
					<input style="width:98%"></input></td>
					</tr>
					<tr  bgcolor="#FFFFFF">
			  <td align="center">未收</td>
			  <td colspan="2">
					<input style="width:98%"></input></td>
			  <td align="center" class="gboxbg"  style="border-color: blue;border-left: 1px;border-style: solid;">未收</td>
			  <td colspan="2" class="gboxbg" style="border-color: blue;border-right: 1px;border-style: solid;">
					<input style="width:98%"></input></td>
					</tr>
					<tr  bgcolor="#FFFFFF">
					<td></td>
			  <td align="center">应收未收</td>
			  <td >
					<input style="width:98%"></input></td>
			  <td align="center" class="gboxbg"  style="border-color: blue;border-left: 1px;border-bottom: 1px;border-style: solid;">多收</td>
			  <td colspan="2" class="gboxbg" style="border-color: blue;border-right: 1px;border-bottom: 1px;border-style: solid;">
					<input style="width:98%"></input></td>
					</tr>
					<tr  bgcolor="#FFFFFF">
					<td></td>
			  <td align="center">未到期</td>
			  <td >
					<input style="width:98%"></input></td>
			  <td align="center" class="gboxbg"></td>
			  <td colspan="2" class="gboxbg"></td>
					</tr>
					<tr  bgcolor="#FFFFFF">
					
			  <td align="center">多收</td>
			  <td colspan="2">
					<input style="width:98%"></input></td>
					<td></td><td></td><td></td>
					</tr>
					
					
					<tr class="gboxbg">
			  <th colspan="6" align="left">合计</th>
			  </tr>
					<tr  bgcolor="#FFFFFF">
			  <td align="center">应收</td>
			  <td colspan="2">
					<input style="width:98%"></input></td>
			  <td align="center">未收</td>
			  <td colspan="2" >
					<input style="width:98%"></input></td>
					</tr>
					<tr  bgcolor="#FFFFFF">
			  <td align="center">实收</td>
			  <td colspan="2">
					<input style="width:98%"></input></td>
					<td></td>
			  <td align="center" >应收未收</td>
			  <td >
					<input style="width:98%"></input></td>
					</tr>
					<tr  bgcolor="#FFFFFF">
			  <td align="center">多收</td>
			  <td colspan="2">
					<input style="width:98%"></input></td>
					<td></td>
			  <td align="center" >未到期</td>
			  <td >
					<input style="width:98%"></input></td>
					</tr>
					<tr  bgcolor="#FFFFFF">
			  <td align="center"></td>
			  <td colspan="2"></td>
					<td></td>
			  <td align="center" >银行按揭</td>
			  <td >
					<input style="width:98%"></input></td>
					</tr>
					<tr  bgcolor="#FFFFFF">
			  <td align="center"></td>
			  <td colspan="2"></td>
					<td></td>
			  <td align="center" >公积金</td>
			  <td >
					<input style="width:98%"></input></td>
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

