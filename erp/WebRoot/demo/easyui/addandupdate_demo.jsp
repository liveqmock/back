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
<b>easyui版弹出框新建与修改说明：</b>

<br/>

<p></p>
<p><b>参考：</b><br/>
<b>例子地址:</b><br/>
交易管理--销控中心--单元操作（挞定、换房、退房）；以有认购成交的为例（合肥新桥阳光半岛）
<br/>
<b>例子图片</b><br/>
<img src="<%= basePath%>/demo/easyui/images/addandupdate_demo.jpg" width="800px"/>
<br/><br/>
<b>做法步骤</b><br/>

<table>
<tr><th>序号</th><th>说明</th><th>参考</th><th>注意</th></tr>
<tr><td>1</td><td>页面主体文件</td><td>struts-saleunit-operation.xml</td><td>单元操作的下方列表</td></tr>
<tr><td>2</td><td>新建:弹出框的调用</td><td>saleunit_new_unit_operation.js</td><td>在页面主体中调用function addCancelContract(unitId)</td></tr>
<tr><td>3</td><td>新建:弹出框的内容承载</td>
<td>struts-saleunit-operation.xml<br></br>addCancelContract</td><td>
<textarea rows=10 cols=80 >
		<!-- 新增挞订 --><!-- DEMO div弹出框 -->
		<action name="addCancelContract" class="com.ihk.saleunit.action.tart.GuangZhouAppointNewTartAction" method="addCancelContract">
			<result name="add_cancel_contract">/saleunit_new/guangzhou/add_cancel_contract.jsp</result>
		</action>

</textarea>
</td></tr><tr><td>4</td><td>新建:弹出框的内容提交</td>
<td>struts-saleunit-operation.xml<br></br>addCancelContract<br/>
add_cancel_contract.jsp</td><td>
<textarea rows=20 cols=80 >

<%-- DEMO 指定弹出框的提交事件 --%>
<form action="./saleunit/operation/submitTart.action" method="post" id="submitTartFormId">

		<!-- 提交挞订 --><!-- DEMO div弹出框中的提交按钮对应响应方法 -->
		<action name="submitTart" class="com.ihk.saleunit.action.tart.GuangZhouAppointNewTartAction" method="submitTart"/>

弹出框的基础上，再弹出iframe弹出框
//DEMO 使用这个方法，将页面内按钮(元素)绑定到对应事件
	$.ed().ready(function(){
		$.ed("#showConfirmDetailFormId").bind('click', function(){
			showConfirmDetail(${confirm.id});
		});
	});
</textarea>
</td></tr>
<tr><td>5</td><td>修改（查看):弹出框</td><td></td><td>
<textarea rows=10 cols=80 >
		<!-- 查看挞订记录 --><!-- DEMO div弹出框 -->
		<action name="showTartRecord" class="com.ihk.saleunit.action.new_.GuangZhouAppointUnitOperation" method="showTartRecord">
			<result name="show_tart_record">/saleunit_new/guangzhou/show_tart_record.jsp</result>
		</action>

</textarea>
</td></tr>
</table>
<br/>
<hr/>
<b>优点列举</b><br/>
1,界面表格整体样式美观，间距合理；<br/>
2,弹出框，不拘泥于iframe之中，能够不被遮挡；<br/>
3,验证同时使用了easyui提示，以及点击提交按钮，有对应的按钮左边的提示文本；<br/>
4,使用了ajax进行提交数据；<br/>
5,弹出框之中，再弹出，两级的情况处理的好；第一级是div，第二级是iframe；<br/>
6,action的写法，也是按照功能去区分，而不是写在一个大的类里面，清晰明了<br/>

  <br/>
</p>
<b>配置文件:</b><br/>

struts-saleunit-operation.xml(里面有DEMO对应的说明)<br/>

<br/>
下方的列表显示:unitOperation.action<br/>
js脚本统一放置:saleunit_new_unit_operation.js,放在saleunit_new\guangzhou\layout.jsp中<br/>
saleunit_new_unit_operation.js的说明：<br/>
弹出新窗口：<br>
</br>MyAjaxDivDialog这个方法，在easyui.utils.js中，以这个为最新<br/>
1,弹出框的DIV模式：showTartRecord<br/>
2,弹出框的iframe模式:showUnitList<br/>

弹出框(div)中，再弹出iframe<br/>
参考saleunit_new\guangzhou\add_cancel_contract.jsp

<br/>




<br/>

</body>
</html>

