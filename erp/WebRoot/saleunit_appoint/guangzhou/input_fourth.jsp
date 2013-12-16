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
	<script type="text/javascript" language="javascript" src="./js/appoint_guangzhou_input.js"></script>

	<script type="text/javascript" language="javascript" src="<%=basePath%>js/unit_table.js"></script>	<!-- unit table -->
		
	<link href="./css/unit_table.css"  rel="stylesheet" type="text/css" charset="utf-8"/><!-- unit的样式 -->
	
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
	<div class="d_out">
		第三步:选择客户
	</div>
	<div class="d_over">
		<b>第四步:主要信息</b>
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
		  
	  <form class="registerform" action="./saleunit/appoint/guangzhou/inputAppoint.action" method="post" >	
		  
		  <table style="width: 800px;" align="left" border="0" cellspacing="0">		  
		  
		  <tr>
		  	<td colspan="4">
			

		 <table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" class="gbox" >
		  
			  <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
                <td id="t15"  style="width:15%"  align="right">楼盘项目&nbsp;</td>
                <td id="t16">
					${fourthMap.propertyProjectName}
					<input type="hidden" id="hiddenId" name="appoint.propertyId" value="${fourthMap.propertyProjectId}"/>
				</td>
								
				 <td id="t13" style="width:15%" align="right">楼盘楼栋&nbsp;</td>				
				
				<td>
					${fourthMap.propertyBuildName}
					<input type="hidden" id="hiddenBuildId" name="appoint.buildId" value="${fourthMap.propertyBuildId}"/>
				</td>
				
              </tr>
		   
              <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
				<td id="t15" style="width:15%" align="right">房间&nbsp;</td>
                <td id="t16" style="width:30%">
				 ${fourthMap.unitNo}
 				 <input type="hidden"  name="appoint.unitId" id="hiddenUnitId" value="${fourthMap.unitId}"/>
				 </td>
                 <td id="t13" style="width:15%" align="right">实际排号&nbsp;</td>
                <td id="t14">
					 <input type="text" id="realNum" name="appoint.realNum" class="leftcreateinputbox01" />
				</td>
				
              </tr>
            
			
             <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
                <td id="t11"  align="right">客户名称&nbsp;</td>
                <td id="t12" class="fontblue">
					<a href="#" onclick="return showAppointCustomer(${customer.id})">${customer.customerName}</a>					
					<input type='hidden' id='appointCustomerId' name="appoint.customerId" value="${customer.id}"/>				
				</td>
				
				 <td id="t11"  align="right">业务员&nbsp;</td>
                <td id="t12">	
					<input type="text" id="saleName" class="leftcreateinputbox01"/>
					<input type="hidden" id="saleHiddenId" name="appoint.salesId"/>
				</td>
				
              
             </tr>
			 
			 
			  <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
                <td id="t11"  align="right"><font color="#FF0000">*</font>预约日期&nbsp;</td>
                <td id="t12">
					<input class="Wdate" type="text" id="appointDate" style="width:90px" name="appoint.appointDate" />
				</td>
                <td id="t11"  align="right">失效日期&nbsp;</td>
                <td id="t12">	
					<input class="Wdate" type="text" id="endDate" style="width:90px" name="appoint.endDate" />
				</td>
				
              
             </tr>
			 
			  
			  <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
                <td id="t11"  align="right"><font color="#FF0000">*</font>项目排号&nbsp;</td>
                <td id="t12">
					<input type="text" id="appointNum" name="appoint.appointNum" class="leftcreateinputbox01"/>
				</td>
                <td id="t11"  align="right">房间排号&nbsp;</td>
                <td id="t12">	
					<input type="text" id="unitNum" name="appoint.unitNum" class="leftcreateinputbox01"/>
				</td>
               
              </tr>
			  
			   <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
                <td id="t11"  align="right">应收预约金&nbsp;</td>
                <td id="t12">
					<input type="text" id="apponitMoney" name="appoint.apponitMoney" class="leftcreateinputbox01" style="width:25%"/>
					元
				</td>
                 <td id="t11"  align="right"></td>
                <td id="t12"></td>
				
				<%--
                <td id="t11"  align="right">实收预约金&nbsp;</td>
                <td id="t12">					
					<input type="text" id="realMoney" name="appoint.realMoney" class="leftcreateinputbox01" style="width:20%"/>					
					元					
				</td>
              	 --%>
				 
               
             </tr>
			 
			 <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
				<td id="t7"  align="right">备注&nbsp;</td>
				<td colspan="3" style="white-space:normal">	
					<input type="text" name="appoint.remark" id="remark1" class="leftcreateinputbox02" style="width:80%"/>			
				</td>
			  </tr>
			  
			   <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF"; align="center">
				<td colspan="4">
				
				  <s:token />
				  <input type="submit" value="  保存  " id="sub"/>
				  <input type="hidden" id="baseUrl" value="<%=basePath%>"/>
					&nbsp;&nbsp;
				  <input type="button" value="  取消  " onClick="javascript:window.location.href = '<%=basePath%>saleunit/appoint/guangzhou/index.action'" />
				</td>
			  </tr>
			 	
			 <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF"; align="center">
				<td colspan="4" align="center">					
					<font color="#FF0000"><span id="suggestion2"><s:property value="#request.session.suggestion"/></span></font>	
				</td>
			  </tr>		
			
			</table>

			
		  </td>
		  </tr>
			
		  
           
            </table>
</form>

<%--主体table end --%>



<%--固定的底部 --%>
<s:include value="../../customer/guangzhou/body_bottom.jsp">
</s:include>
</table>  
   
  </body>
</html>

