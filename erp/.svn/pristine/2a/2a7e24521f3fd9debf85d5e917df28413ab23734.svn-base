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
		<title>新建下拉项</title>
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
			.tip {font-size: 12px;line-height: 7px;color: blue;padding-left: 20px;}
		</style>	
	</head>
	
<body>
<%--固定的上部 --%>
<s:include value="body_up.jsp">
</s:include>	
	
<%--主体导航页头 --%>
<div class="title01" ><a href="<%=path %>/customer_guangzhou/option/index.action" target="_self">查看下拉项</a></div>
<div class="title02" ><a href="<%=path %>/customer_guangzhou/option/indexInput.action" target="_self">新建下拉项</a></div>
<div class="right99"></div>
<div class="blueline"></div>
<div class="c"></div>
<div class="c"></div>

<%--主体table --%>


							 
<form action="./customer_guangzhou/option/form.action" method="post">
	<table>
		<tr>
			<td align="right">
				&nbsp;项目</td><td><input type="text" id="projectName" name="projectName" value="${projectName}"/>
					<input type="hidden" id="hiddenId" name="proRan.projectId" value="${cond.projectId }"/>
					</td>
			<td align="right">
				&nbsp;类型</td><td><select name="proRan.rangeType">
						<option value="AREA" 
							<s:if test="#request.proRan.rangeType == 'AREA'">
								selected="selected"
							</s:if>
						>面积</option>
						<option value="SUM_PRICE"
							<s:if test="#request.proRan.rangeType == 'SUM_PRICE'">
								selected="selected"
							</s:if>
						>价格</option>
					</select></td>
			<td align="right">
				&nbsp;产品类型</td><td>
								
								<s:select list="selHouseType" name="proRan.houseType" />
			</td>
		</tr>
		<tr style="height: 0px">
			<td class="tip" colspan="2"">按空格提示前十个项目</td>
			<td class="tip" colspan="2"">&nbsp;</td>
			<td class="tip" colspan="2">&nbsp;</td>
		</tr>
		<tr>
			<td align="right">
				&nbsp;名称</td><td><input type="text"  name ="proRan.rangeName"  value="${proRan.rangeName }" maxlength="12"/>
			</td>
			
			<td align="right">
				&nbsp;开始值</td><td><input type="text"  name ="proRan.startNum"  value="${proRan.startNum }" maxlength="12"/>
			</td align="right">
			<td align="right">
				&nbsp;结束值</td><td><input type="text"  name ="proRan.endNum"  value="${proRan.endNum }" maxlength="12"/>
			</td>
		</tr>
		<tr style="height: 0px">
			<td class="tip" colspan="2">例如 200万-300万  ; 50平米-100平米</td>
			<td class="tip" colspan="2">例如 200</td>
			<td class="tip" colspan="2">例如 300</td>
		</tr>
		<tr>
			<td align="right">
				&nbsp;顺序</td><td><input type="text"  name ="proRan.orderIndex"  value="${proRan.orderIndex }" maxlength="12"/>
			</td>
			<td align="right">
				</td><td><input type="submit" value="  保存  " />
			</td>
			<td></td><td></td>
		</tr>
		<tr style="height: 0px">
			<td class="tip" colspan="6">下拉项顺序  比如1,2,3,4,5等等</td>
			
		</tr>
	</table>
	<br/>
	<s:actionmessage cssStyle="color:red;padding-left: 200px;"/>

	
	
	
	
	


<%--固定的底部 --%>
<s:include value="body_bottom.jsp">
</s:include>
	</body>
</html>



   
   



