<%@ page contentType="text/html; charset=utf-8" %>

<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<div class="easyui-tabs" fit="true" border="false" id="sale_tabs">
	<div title="单元图示" style="" id="unit_map" bid=""> 
	</div>
	<div title="单元列表"  style="padding:0px;" id="" bid="">
	</div>
	<div title="定价管理"  style="padding:0px;" id="tab_make_price" bid="">
	</div>
</div>