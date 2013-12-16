<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>自定义选项</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<s:include value="header.jsp"></s:include>	
		<s:include value="header_left_js.jsp"></s:include>	
		<script type="text/javascript" src="<%=basePath%>js/highcharts.js"></script>
		<script type="text/javascript" src="<%=basePath%>js/ui_fix.js"></script>
		
		<script type="text/javascript" language="javascript" src="<%=basePath%>js/customer_guangzhou_project.js"></script>
		
		<script type="text/javascript">
			$().ready(function(){
				projectListForHiddenId("projectName", "hiddenId"); //项目的联想框,及用隐藏域保存其id
				projectListForHiddenId("projectName1", "hiddenId1"); 
			});
		</script>	
		<style>
			* {margin:0;padding:0;}
		</style>	
	</head>
	
<body>
<%--固定的上部 --%>
<s:include value="body_up.jsp">
</s:include>	
	
<%--主体导航页头 --%>
<div class="title02" ><a href="<%=path %>/customer_guangzhou/option/index.action" target="_self">查看下拉项</a></div>
<div class="title01" ><a href="<%=path %>/customer_guangzhou/option/indexInput.action" target="_self">新建下拉项</a></div>
<div class="right99"></div>
<div class="blueline"></div>
<div class="c"></div>
<div class="c"></div>

<%--主体table --%>

							 


<form action="./customer_guangzhou/option/search.action" method="post">
项目<input type="text" id="projectName1" name ="projectName"  value="${projectName }"/>
									<input type="hidden" id="hiddenId1" name="cond.projectId" value="${cond.projectId }"/>
									 <input type="submit" value="  查询  "/></form>
											 
<table width="75%" border="0" align="left" cellpadding="0" cellspacing="1" class="gbox" style="white-space: nowrap">
		<tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
			<td>&nbsp;修改</td>
			<td>&nbsp;项目</td>
			<td>&nbsp;产品类型</td>
			<td>&nbsp;类型</td>
			<td>&nbsp;名称</td>
			<td>&nbsp;最小值</td>
			<td>&nbsp;最大值</td>
			<td>&nbsp;顺序</td>
			
		</tr>
      
		<s:iterator value="proRanList" var="ta">
		<tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
			<td>&nbsp;
				<a href="./customer_guangzhou/option/indexUpdate.action?id=${id}" class="ablue" ><font color="blue">  修改 </font> </a>
			</td>
			<td>&nbsp;${ta.descProjectId }</td>
			<td>&nbsp;${ta.rangeType }</td>
			<td>&nbsp;${ta.houseType }</td>
			<td>&nbsp;${ta.rangeName }</td>
			<td>&nbsp;${ta.startNum }</td>
			<td>&nbsp;${ta.endNum }</td>
			<td>&nbsp;${ta.orderIndex }</td>
			</tr>
		</s:iterator>
</table>

<%--固定的底部 --%>
<s:include value="body_bottom.jsp">
</s:include>
	</body>
</html>



   
   



