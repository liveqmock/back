<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<style type="text/css">
		*{margin:0;padding:0;}		
		
		.tb1 td{padding-left: 2px;width:50px; text-align:center; cursor: pointer}
		.tb1 tr{background-color:#FFFFFF}
		
	</style>	
	<base href="<%=basePath%>">		
						<p style="color: blue">${selBuild.buildName}</p>
							<table  id="unitTable1" border="0" align="center" cellpadding="0" cellspacing="1" class="tb1" style="margin: 0px;width:auto;float: left;background-color: #A9D9FF">
								 <s:iterator value="#request.trList" id="c">  
								 	${c}
								 </s:iterator>
							</table>
<input type="hidden" id="hiddenUnitId" value=""/>
