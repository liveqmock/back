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
<b>数据校验说明：</b>

<br/>

<p></p>
<p><b>参考：</b><br/>
 在弹出框用这个来统一验证：需要用到easyui.utils.js<br/>
 
举例:	new MyAjaxDivDialog({title:'新增楼盘合同', formId:'contractManagerFormId',	
ids:['contractNo', 'startDate:datebox', 'defaultCommission:number'],

<br/>
以上代码代表会对contractNo执行非空校验;对startDate执行日期校验;对defaultCommission执行数字类型校验<br/>
<br/>
input控件要按easyui来声明，并且class需要为对应类型<br/>

<b>具体参数的含义</b><br/>
<table>
<tr><th>序号</th><th>参数说明</th><th>校验内容</th><th>注意</th></tr>
<tr><td></td><td>:money</td><td>金额</td><td>该输入框要符合金额的格式</td></tr>
<tr><td></td><td>mail</td><td>邮件</td><td></td></tr>
<tr><td></td><td>phone</td><td>电话</td><td></td></tr>
<tr><td></td><td>number</td><td>数字</td><td></td></tr>
<tr><td></td><td>combobox</td><td>下拉框的值不能为空</td><td></td></tr>
<tr><td></td><td>datebox</td><td>日期</td><td></td></tr>
<tr><td></td><td>name</td><td></td><td></td></tr>
</table>
</p>
<p></p>

</body>
</html>

