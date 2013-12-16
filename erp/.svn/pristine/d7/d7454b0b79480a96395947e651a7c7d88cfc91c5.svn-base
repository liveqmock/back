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
	
	<title>查询变更</title>
	
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
<div class="title02" ><a href="./saleunit/change/guangzhou/searchList.action" target="_self">查询变更</a></div>
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

    <td align="center" valign="middle" width="180">项目</td>
	
	<td width="187" align="left" valign="middle">
		<input type="text" id="projectName" name="cond.propertyName" value="${cond.propertyName}"/>	
		<input type="hidden" id="hiddenId" name="cond.propertyId" value="${cond.propertyId}"/>
		</td>
	
   <td align="center" valign="middle" width="180">
	客户名称	</td>
	
     <td width="187" align="left" valign="middle">
	 	<input type="text" id="customerName" name="cond.customerId" value="${cond.customerId}"/>
	 </td>
	
   <td align="center" valign="middle">
	业务员	</td>
	
     <td width="187" align="left" valign="middle">
	 	<input type="text" id="salesId" name="cond.salesId" value="${cond.salesId}"/>
	 </td>
	 
  </tr>
  
  <tr onMouseOver="this.style.backgroundColor='#f1f9fe';" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF">

    <td align="center" valign="middle">房间</td>
	
	<td width="187" align="left" valign="middle">
		<input type="text" id="unitId" name="cond.unitId" value="${cond.unitId}"/>	
	</td>
	
   <td align="center" valign="middle">
		
   	<input type="submit" value="  搜索  " id="searchSubmit"/></td>
	
     <td width="187" align="left" valign="middle" style="white-space:nowrap">
	 </td>
	 <td></td>
	 <td></td>
	
	 
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

    <td width="197">
	审批状态
	</td>
    <td width="197">
	客户名称
	</td>
    <td width="197">
	房间
	</td>
    <td width="197">
	申请类型
	</td>
    <td width="197">
	原因分类
	</td>
    <td width="197">
	申请人
	</td>
    <td width="197">
	审批意见
	</td>
    <td width="197">
	批准人
	</td>
    <td width="197">
	批准时间
	</td>
    <td width="197">
	执行人
	</td>
    <td width="197">
	执行时间
	</td>
   
	
   <td width="50" align="center" valign="middle">
		操作
	</td>
  </tr>
 
 
  
   <s:iterator value="#request.appintList" id="c">  
	  <tr onMouseOver="this.style.backgroundColor='#f1f9fe';" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF"
	   title='客户名称:<s:property value="#c.customerName"/>, 预约日期:<s:date name="#c.appointDate" format="yyyy-MM-dd "/>'> 
		<td width="20" align="center"><input name="delId" type="checkbox" value="<s:property value='#c.id'/>" onClick="delId()" /></td>
		<td align="center" valign="middle" class="fontblue">
			<a href="./saleunit/change/guangzhou/getById.action?id=<s:property value='#c.id'/>" target="_self" ><s:property value="#c.customerName"/></a>
		</td>
		
		<td align="center" valign="middle">
			<s:date name="#c.appointDate" format="yyyy-MM-dd "/>
		</td>
		<td align="center" valign="middle">
			<s:date name="#c.endDate" format="yyyy-MM-dd "/>
		</td>
		<td align="center" valign="middle">	
			<s:property value="#c.unitId"/>
		</td>
		<td align="center" valign="middle">
			<s:property value="#c.realNum"/>
		</td>
		
		<td align="center" valign="middle">
			<s:property value="#c.propertyId"/>
		</td>
		
		<td align="center" valign="middle">
			<s:property value="#c.apponitMoney"/>
		</td>
		
		<td align="center" valign="middle">
			人民币
		</td>
		
		<td align="center" valign="middle">
			<s:property value="#c.salesId"/>
		</td>
		
		<td align="center" valign="middle" class="fontblue">
			
		</td>
		<td align="center" valign="middle" class="fontblue">
			
		</td>
		<td align="center" valign="middle" class="fontblue">
			
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

