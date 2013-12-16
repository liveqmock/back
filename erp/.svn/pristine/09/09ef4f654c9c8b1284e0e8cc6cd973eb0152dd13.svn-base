<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
	isELIgnored="false"%>
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
<title></title>
<s:include value="../../header/header_easyui.jsp"></s:include>
<s:include value="coder_header.jsp"></s:include>
</head>

<body  style="padding:10px;">
<b>增删改查div说明：</b>

<br/>

<p></p>
<b>参考：</b><br/>
<a href="saleunit_chip_manager/guangzhou/layout.action" target="_blank">
saleunit_chip_manager/guangzhou/layout.action
</a>
<br/>
<p></p>
<b>主要代码说明：</b>
<br/>
使用前缀来标识div，并且div里面包括必须的js,js的命名，控件的命名，都添加前缀，这样用来避免div之间的冲突<br/>
在查询页面中，包含新增与修改的div页面<br/>
div的jsp页面中，已经写好自己的相关javascript<br/>

命名示范：<br/>
search_chip.jsp<br/>
div_edit_chip.jsp<br/>
div_create_chip.jsp<br/>
<br/>
div id="div_create_Chip"<br/> (div内部的所有控件，如果不确定，那就以div_create_开头)
form id="form_create_Chip"<br/>
<br/>
input type="hidden" id="editChip_id" name="editChip.id"<br/>
input type="hidden" id="editChip_chipNo" name="editChip.chipNo"<br/>
input type="text" id="editChip_customer_customerName" name="editChip.customer.customerName"<br/>
<br/>
//加载<br/>
function div_edit_chip_Load(id){<br/>
<br/>
//提交<br/>
function div_edit_chip_Submit(){<br/>

<br/>
//加载<br/>
function div_create_chip_Load(){<br/>


<br/>
其他<br/>

<br/>
<b>代码示例：</b><br/>
<textarea rows="10" cols="150">
用包含的方式，把div都分开各个文件
	 s:include value="chip_create_div.jsp"/>
	 s:include value="chip_edit_div.jsp"/>	
</textarea>
<br/>

</body>
</html>

