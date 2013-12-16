<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page import="com.ihk.utils.CacheUtils"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<s:include value="../../../customer/guangzhou/header.jsp"></s:include>	
		<s:include value="../../../customer/guangzhou/header_left_js.jsp"></s:include>	
		<title>查询单元</title>
		<style >
			.tb1 input{width:100%}
			.thisdiv td{padding-left: 12px}
			.ablue {color:#1199ff; text-decoration:underline;}
		</style>
	</head>
	<body>
	
<%--固定的上部 --%>

<s:include value="../../../customer/guangzhou/body_up.jsp">
</s:include>	
<%--主体导航页头 --%>
<div class="title02" ><a href="./property/unit/search_list_index.action?ts=<%= CacheUtils.getUrlTimeStamp()%>" target="_self">单元列表</a></div>
<div class="title01" ><a href="./property/unit/show_index.action?ts=<%= CacheUtils.getUrlTimeStamp()%>"  target="_self">单元视图</a></div>

<div class="right99"></div>
<div style="float: left;vertical-align: top;width: 100%;background: #edf8fe">
		<div class="d_over">
			<b><a href="./property/unit/search_list_index.action?ts=<%=CacheUtils.getUrlTimeStamp()%>" target="_self">查询单元</a></b>
		</div>		
		<div class="d_out">
			<a href="./property/unit/index.action?ts=<%=CacheUtils.getUrlTimeStamp()%>" target="_self">初始化单元</a>
		</div>				
</div>
<div class="right99"></div>
<div class="blueline"></div>

<%--主体table --%>

<div style="height:25px;width: 100%">
<form action="./property/unit/search_list_form.action" method="post">
	&nbsp;楼栋<input type="text" name="unitcond.buildName" value="${unitcond.buildName}"/>
	&nbsp;房间<input type="text" name="unitcond.unitNo" value="${unitcond.unitNo}"/>
	&nbsp;楼层<input type="text" name="unitcond.floorNum" value="${unitcond.floorNum}" style="width: 50px"/>
	&nbsp;<input type="submit" value="  查询  "/>
</form>
</div>

<table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" class="gbox thisdiv">
				<tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" class="gboxbg">
					<td><span>所属楼栋分区</span></td>
					<td><span>单元号</span></td>
					<td><span>建筑单价</span></td>
					<td><span>建筑面积</span></td>
					<td><span>朝向</span></td>
					<td><span>楼层</span></td>
				</tr>
			<s:iterator value="unitlist" id="li">
				<tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF">
					<td>
						${li.descBuildId}
					</td>
					<td>
						<a   href="./property/unit/update_one_unit.action?unitId=${li.id}" class="ablue" style="color:#1199ff">
						${li.unitNo}
						</a>
					</td>
					<td>
						${li.buildPrice}
					</td>
					<td>${li.buildArea}</td>
					<td>
						${li.descOrientation}
					</td>
					<td>
						${li.floorNum }
					</td>
					</tr>
			</s:iterator>	
</table>

<div class="manu">	<s:property value="showPage" escape="false"/>   </div>
<%--固定的底部 --%>
<s:include value="../../../customer/guangzhou/body_bottom.jsp">
</s:include>
	</body>
</html>
