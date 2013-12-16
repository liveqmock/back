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
	
	<title>新建预约排号</title>
	
	<base href="<%=basePath%>">
			
	<s:include value="../../customer/guangzhou/header.jsp"></s:include>	  
	<s:include value="../../customer/guangzhou/header_left_js.jsp"></s:include>	 

	<script type="text/javascript" language="javascript" src="./js/customer_guangzhou_project.js"></script>
	<script type="text/javascript" language="javascript" src="./js/customer_guangzhou_user.js"></script>	 
	
	<script type="text/javascript" language="javascript">
	
		$(document).ready(function(){		
			
		});
		
	</script>
	
	<style type="text/css">
		*{margin:0;padding:0;}
	</style>

	
  </head>
  
 <body>
 
 
<%--固定的上部 --%>
<s:include value="../../customer/guangzhou/body_up.jsp">
</s:include>

<%--主体导航页头 --%>
<div class="title01" ><a href="./saleunit/appoint/guangzhou/index.action" target="_self">查询预约排号</a></div>
<div class="title02"><a href="./saleunit/appoint/guangzhou/forInput.action" target="_self">新建预约排号</a></div>	
<table width="100%" border="0" cellspacing="0" class="d_top">
	<tr>
	  <td bgcolor="#edf8fe">
	  
	<div class="d_out">
		第一步:选择楼栋
	</div>		
	<div class="d_out">
		第二步:选择房间
	</div>		
	<div class="d_over">
		<b>第三步:选择客户</b>
	</div>
	<div class="d_out">
		第四步:主要信息
	</div> 

	<div class="d_out">
		<font color="#FF0000"><span id="suggestion"><s:property value="#request.session.suggestion"/></span></font>					
	</div>
		
	 </td>
	</tr>
</table>
<%--主体table top --%>
		
  		<div class="c"></div>
          <div class="c"></div>	
		  
	<table style="width: 100%;" align="left" border="0" cellspacing="0">		  
		  
		  <!-- 搜索表单 top -->
       
     <form class="registerform" id="searchForm" action="<%=request.getContextPath() %>/saleunit/appoint/guangzhou/appointInputThird.action" method="post" >
		  <tr>
		  	<td colspan="6">
			

		 <table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" class="gbox" style="white-space:nowrap">
		 
  			<tr onMouseOver="this.style.backgroundColor='#f1f9fe';" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF">

    <td align="center" valign="middle" width="180">客户姓名</td>
	
	<td width="187" align="left" valign="middle">
		<input type="text" id="customerName" name="customerCond.customerName" value="${customerCond.customerName}"/>	
	</td>
	
   <td align="center" valign="middle" width="180">
		<input type="hidden" id="hiddenBuildId" name="buildId" value="${buildId}" />
		<input type="hidden" id="hiddenUnitId" name="unitId" value="${unitId}" />
		<input type="hidden" id="hiddenCustomerId" />
		<input type="submit" value="  搜索  " id="searchSubmit"/>
	</td>
	
   <td align="center" valign="middle" width="180">
   		<input type="button" value="  新建  " onclick="appointCustomer()"/>
   </td>
   <td align="left" valign="middle" colspan="2"></td>
	
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
    	
	 <td width="100" align="center" valign="middle">
		客户姓名
	</td>
	
	 <td width="100" align="center" valign="middle">
		客户性别
	</td>
		
     <td width="120" align="center" valign="middle">
		证件类型
	</td>
	
	 <td width="100" align="center" valign="middle">
		证件号码
	</td>
	
	 <td width="50" align="center" valign="middle">
		操作
	</td>
      
  </tr>
 
 
  
   <s:iterator value="#request.customerList" id="c">  
	  <tr onMouseOver="this.style.backgroundColor='#f1f9fe';" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF"> 
	
		<td align="center" valign="middle">	
			${c.customerName}
		</td>
		
		<td align="center" valign="middle">
			${c.genderStr}
		</td>
		
		<td align="center" valign="middle">
			${c.idcardTypeStr}
		</td>
		<td align="center" valign="middle">
			${c.idcardNo}
		</td>
		
		<td align="center" valign="middle" class="fontblue">
			<a href="./saleunit/appoint/guangzhou/changeCustomerToFourth.action?buildId=${buildId}&unitId=${unitId}&customerId=${c.id}">选择</a>
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

