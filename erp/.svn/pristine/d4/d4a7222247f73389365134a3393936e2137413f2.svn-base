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
	
	<title>修改日志</title>
	
	<base href="<%=basePath%>">
			
	<s:include value="../../customer/guangzhou/header.jsp"></s:include>	  
	<s:include value="../../customer/guangzhou/header_left_js.jsp"></s:include>	 

	<script type="text/javascript" language="javascript" src="./js/customer_common.js"></script>
	<script type="text/javascript" language="javascript" src="./js/customer_guangzhou_project.js"></script>
	<script type="text/javascript" language="javascript" src="./js/appoint_guangzhou_input.js"></script>
			
	<style type="text/css">
		*{margin:0;padding:0;}
	</style>

	
  </head>
  
 <body>
 
 
<%--固定的上部 --%>
<s:include value="../../customer/guangzhou/body_up.jsp">
</s:include>

<%--主体导航页头 --%>
<div class="title01" ><a href="<%=request.getContextPath() %>/saleunit/log/guangzhou/searchList.action" target="_self">销售日志</a></div>	
<div class="title02" ><a href="<%=request.getContextPath() %>/saleunit/log/guangzhou/getById.action?id=${saleDaily.id}" target="_self">修改日志</a></div>
<div class="right99"></div>
<div class="blueline"></div>		
		
<%--主体table top --%>
		
  		<div class="c"></div>
          <div class="c">  
			<font color="#FF0000"><span id="suggestion"><s:property value="#request.session.suggestion"/></span></font>
		  </div>	
		  
	  <form class="registerform" action="./saleunit/log/guangzhou/updateSaleDaily.action" method="post" >	
			  <table style="width: 800px;" align="left" border="0" cellspacing="0">		  
		  
		  <tr>
		  	<td colspan="4">
			

		 <table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" class="gbox" >		  		   
              <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
				<td id="t15" style="width:15%" align="right">项目&nbsp;</td>
                <td id="t16" style="width:30%">
					<input type="text" id="projectName" name="projectName" value="${saleDaily.propertyProjectName}"/>
					<input type="hidden" id="hiddenId" name="saleDaily.propertyId" value="${saleDaily.propertyId}"/>
				 </td>
                 <td id="t13" style="width:15%" align="right">日期&nbsp;</td>
                <td id="t14">
					 <input type="text" id="saleDate" class="Wdate"  name="saleDaily.saleDate"  value="<s:date name="#request.saleDaily.saleDate" format="yyyy-MM-dd "/>"/>
				</td>				
              </tr>		
               <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
				<td id="t15" style="width:15%" align="right">来电&nbsp;</td>
                <td id="t16" style="width:30%">
				 <input type="text" id="phoneNum" name="saleDaily.phoneNum" class="leftcreateinputbox01" value="${saleDaily.phoneNum}"/>
				 </td>
                 <td id="t13" style="width:15%" align="right">来访&nbsp;</td>
                <td id="t14">
					 <input type="text" id="visitNum" name="saleDaily.visitNum" class="leftcreateinputbox01" value="${saleDaily.visitNum}"/>
				</td>				
              </tr> <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
				<td id="t15" style="width:15%" align="right">预约排号&nbsp;</td>
                <td id="t16" style="width:30%">
				 </td>
                 <td id="t13" style="width:15%" align="right">预约退定&nbsp;</td>
                <td id="t14">
				</td>				
              </tr>	
               <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
				<td id="t15" colspan="4" align="center;" >

<div style="border-style:solid;border-width:1px; border-color:blue;">
			  <table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" class="gbox" >
			  <tr class="gboxbg">
			  <th colspan="4" align="left">房间销售情况统计</th>
			  <th colspan="2" align="right">单位(套)</th>
			  </tr>
			  <tr class="gboxbg">
				 <td width="100" align="center" valign="middle">
					状态
				</td>
				 <td width="100" align="center" valign="middle">
					今日销售
				</td>
				 <td width="100" align="center" valign="middle">
					今日退出
				</td>
				 <td width="100" align="center" valign="middle">
					今日净销售
				</td>
				 <td width="100" align="center" valign="middle">
					累计退出
				</td>
				 <td width="100" align="center" valign="middle">
					累计销售
				</td>
			  </tr>
			  <tr bgcolor="#FFFFFF">
				 <td width="100" align="center" valign="middle" class="gboxbg">
					小订
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
					认购
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
					签约
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
			   <tr class="gboxbg">
			  <th colspan="6" align="left">项目总计</th>
			  </tr>
			  <tr bgcolor="#FFFFFF">
				 <td width="100" align="center" valign="middle" >
					项目总可售
				</td>
				 <td width="100" align="center" valign="middle">
					
				</td>
				 <td width="100" align="center" valign="middle">
					项目总已售
				</td>
				 <td width="100" align="center" valign="middle">
					
				</td>
				 <td width="100" align="center" valign="middle">
					项目总剩余
				</td>
				 <td width="100" align="center" valign="middle">
					
				</td>
			  </tr>
			  </table>
			  </div>
</td>
				</tr>	
					
               <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
				<td id="t15" style="width:15%" align="right">广告表现&nbsp;</td>
                <td id="t16" style="width:90%" colspan="3">
				 <input type="text" id="adDesc" name="saleDaily.adDesc" class="leftcreateinputbox01" style="width:90%" value="${saleDaily.adDesc}"/>
				 </td>		
              </tr>
              	
               <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
				<td id="t15" style="width:15%" align="right">业务分析&nbsp;</td>
                <td id="t16" style="width:90%" colspan="3">
				 <input type="text" id="workDesc" name="saleDaily.workDesc" class="leftcreateinputbox01" style="width:90%" value="${saleDaily.workDesc}"/>
				 </td>		
              </tr> 
               <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
				<td id="t15" style="width:15%" align="right">填写人&nbsp;</td>
                <td id="t16" style="width:90%" colspan="3">
				 </td>		
              </tr> 
			  
			   <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF"; align="center">
				<td colspan="4">
				
				  <s:token />
				  <input type="submit" value="  保存  " id="sub"/>
				  <input type="hidden" id="baseUrl" value="<%=basePath%>"/>
				  <input type="hidden" id="saleDailyId" name="saleDaily.id" value="${saleDaily.id}"/>
					&nbsp;&nbsp;
				  <input type="button" value="  取消  " onClick="javascript:window.location.href = '<%=basePath%>saleunit/log/guangzhou/searchList.action'" />
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

