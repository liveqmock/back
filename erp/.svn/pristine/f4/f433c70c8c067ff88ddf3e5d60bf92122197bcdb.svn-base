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
		<title>客户录入分析</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<s:include value="header.jsp"></s:include>	
		<s:include value="header_left_js.jsp"></s:include>	
		<script type="text/javascript" src="<%=basePath%>js/highcharts.js"></script>
		<script type="text/javascript" src="<%=basePath%>js/ui_fix.js"></script>
		<script src="<%=basePath%>js/TableOrder.js" type="text/javascript"></script>
		<script type="text/javascript" language="javascript" src="<%=basePath%>js/customer_guangzhou_project.js"></script>
		<script type="text/javascript">
		$().ready(function(){				
					
		
		projectListForHiddenId("projectName", "hiddenId"); //项目的联想框,及用隐藏域保存其id
		 TableOrderOper.Init("idTable", 0, {
	            OnShow: function (i, trJqObj, _tbodyObj) {
	                trJqObj.attr("class", ((i + 1) % 2 == 0 ? "hoverTr" : ""));
	            }
	        });
	        TableOrderOper.SetOrder("ishav", 1, { DataType: "int", "desc": false, OnClick: function () {
	        } });
	        TableOrderOper.SetOrder("isnohav", 2, { DataType: "int", DefaultOrder: false, OnClick: function () {
	        } });
	        TableOrderOper.SetOrder("ispei", 3, { DataType: "int", DefaultOrder: false, OnClick: function () {
	        } });
		
	});
	</script>	
	
   
	</head>
<body>
<%--固定的上部 --%>
<s:include value="body_up.jsp">
</s:include>	
<style>
		* {margin:0;padding:0;}
	</style>
<%--主体导航页头 --%>
<div class="title02" ><a href="<%=path %>/customer_guangzhou/analysis/index.action" target="_self">客户录入分析</a></div>

<div class="right99"></div>
<div class="blueline"></div>
<div class="c"></div>
<div class="c"></div>

<%--主体table --%>
<form action="./customer_guangzhou/analysis/search.action" method="post">
&nbsp;项目<input type="text" id="projectName" name ="projectName"  value="${projectName }" maxlength="20"/>
&nbsp;销售<input type="text" name="saleName" maxlength="20" value="${saleName }"/>
&nbsp;日期<input class="Wdate" type="text" id="date1" style="width:90px" name="searchCond.date1" value="${searchCond.date1}" maxlength="20"/>
				-
				<input class="Wdate" type="text" id="date2" style="width:90px" name="searchCond.date2" value="${searchCond.date2}" maxlength="20"/>
				<input type="hidden" id="hiddenId" name="searchCond.projectId" value="${searchCond.projectId }" />
									&nbsp; <input type="submit" value="  查询  "/>
									 	<s:actionmessage cssStyle="color:red;"/>
									 </form>
<div class="right99"></div>
<div class="blueline"></div>
<div style="height: 500px;overflow: scroll;">
<table id="idTable" width="75%" border="0" align="left" cellpadding="0" cellspacing="1" class="gbox" style="white-space: nowrap;" >
		<thead onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
		<tr class="gboxbg">
			<td>&nbsp;记录项</td>
			<td valign="top">
			<div style="float: left;">
			&nbsp;录入数量&nbsp;&nbsp;
			</div>
			<div style="float: left; padding-top: 5px">
			<a href="javascript:void(0)" id="ishav" style="color: #1199FF;">
				<div ><img  src="images/blue/upn.gif" width="9" height="10" border="0" /></div>
				<div ><img  src="images/blue/downn.gif" width="9" height="10" border="0" /></div>
				</div>
				</a>
			</td>
			<td valign="top">
			<div style="float: left;">
			&nbsp;未录入数量&nbsp;&nbsp;
			</div>
			<div style="float: left; padding-top: 5px">
			<a href="javascript:void(0)" id="isnohav" style="color: #1199FF;">
				<div ><img  src="images/blue/upn.gif" width="9" height="10" border="0" /></div>
				<div ><img  src="images/blue/downn.gif" width="9" height="10" border="0" /></div>
				</div>
				</a>
			
		    </td>
			<td valign="top">
				<div style="float: left;">
			&nbsp;录入率&nbsp;&nbsp;
			</div>
			<div style="float: left; padding-top: 5px">
			<a href="javascript:void(0)" id="ispei" style="color: #1199FF;">
				<div ><img  src="images/blue/upn.gif" width="9" height="10" border="0" /></div>
				<div ><img  src="images/blue/downn.gif" width="9" height="10" border="0" /></div>
				</div>
				</a>
		
			
			</td>
		</tr>
		</thead>
		
      	<tbody >
		<s:iterator value="tableList" var="ta">
		<tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
			<td>&nbsp;${real }</td>
			<td _order="${hav }">&nbsp;${hav }</td>
			<td _order="${nohav }">&nbsp;${nohav }</td>
			<td _order="${pei}">&nbsp;${pei}</td>
			</tr>
		</s:iterator>
		</tbody>
		
</table></div>



<%--固定的底部 --%>
<s:include value="body_bottom.jsp">
</s:include>
	</body>
</html>



   
   



