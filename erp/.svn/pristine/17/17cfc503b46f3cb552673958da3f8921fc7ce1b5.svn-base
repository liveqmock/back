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
	
	<title>修改例子</title>
	
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
<div class="title01" ><a href="./" target="_self">查询例子</a></div>
<div class="title01"><a href="./" target="_self">修改例子</a></div>	
<div class="right99"></div>
<div class="blueline"></div>		
		
<%--主体table top --%>
		
  		<div class="c"></div>
          <div class="c">  
			<font color="#FF0000"><span id="suggestion"><s:property value="#request.session.suggestion"/></span></font>
		  </div>	
		  
	  <form class="registerform" action="./demo/empty/updateDemo.action" method="post" >	
		  
		  <table style="width: 800px;" align="left" border="0" cellspacing="0">		  
		  
		  <tr>
		  	<td colspan="4">
			

		 <table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" class="gbox" >
		  
			  <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
                <td id="t15"  style="width:15%"  align="right">项目&nbsp;</td>
                <td id="t16" colspan="3">
					<input type="text" id="projectName" name="projectName" value="<s:property value='#request.project.projectName'/>"/>
					<input type="hidden" id="hiddenId" name="appoint.propertyId" value="<s:property value='#request.project.id'/>"/>
					(按空格键可以查找前十条数据)
				</td>
				
              </tr>
		   
              <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
				<td id="t15" style="width:15%" align="right">房间&nbsp;</td>
                <td id="t16" style="width:30%">
				 <input type="text" id="unitId" name="appoint.unitId" class="leftcreateinputbox01" value="${appoint.unitId}"/>
				 </td>
                 <td id="t13" style="width:15%" align="right">实际排号&nbsp;</td>
                <td id="t14">
					 <input type="text" id="realNum" name="appoint.realNum" class="leftcreateinputbox01" value="${appoint.realNum}"/>
				</td>
				
              </tr>
			  
			   <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF"; align="center">
				<td colspan="4">
				
				  <s:token />
				  <input type="submit" value="  保存  " id="sub"/>
				  <input type="hidden" id="baseUrl" value="<%=basePath%>"/>
				  <input type="hidden" name="appoint.id"  value="${appoint.id}"/>
					&nbsp;&nbsp;
				  <input type="button" value="  取消  " onClick="javascript:window.location.href = '<%=basePath%>/xindex.action'" />
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

