<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page contentType="text/html; charset=utf-8" %>

<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<div style="height: auto; width:auto; float: left"> 
	<table>
		<tr>
			<td title="可认筹" width="auto" ><div class="sale_state_2"></div> <div style="float: left">可认筹</div>  </td>
			<td title="已认筹" width="auto" ><div class="sale_state_4"></div> <div style="float: left">已认筹</div>  </td>
			<td title="不能认筹" width="auto" ><div class="sale_state_16"></div> <div style="float: left">不能认筹</div>  </td>
		</tr>
	 </table>
</div>

