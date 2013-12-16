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
<b>报表表格(列表)说明：</b>

<br/>

<p></p>
<b>参考：</b><br/>
<a href="./saleunit_new_report/report/guangzhou/saleReportSale.action" target="_blank">./saleunit_new_report/report/guangzhou/saleReportSale.action</a>
<br/>

<br/>
<p></p>
<b>主要代码说明：</b>
<br/>
<br/>
<b>代码示例：</b><br/>
<textarea rows="40" cols="150">
1,配置文件struts-saleunit-new-report.xml
		<action name="saleReportSale" class="com.ihk.saleunit.action.new_report.SaleReportSaleAction" method="index">
			<result name="success" >/saleunit_new_report/guangzhou/sale_report_sale.jsp</result>
		</action>

2,jsp文件（sale_report_sale.jsp）：
<table 
		 	id="dg" 
		 	title="" 
		 	class="easyui-datagrid" 
		 	style="width:auto;height:auto;overflow-x: scroll;"  
            url="./saleunit_new_report/report/saleReport_json/saleJsonSale.action"  
            method ='post'
            toolbar="#toolbar" 
            pagination="false"  
            rownumbers="true" 
            singleSelect="true"
            showFooter='true'
            striped='true'
            >  
	        <thead>  
	            <tr>  
	            	<th field="r1"  width="100px" formatter="descSales">销售</th>
	            	<th field="proName"  width="100px" >项目</th>
	            	<th field="r2" width="100px">认购套数</th> 
	                <th field="r3" width="100px">认购面积</th> 
	                <th field="r4" width="100px">认购总价</th>
	                <th field="q2" hidden width="100px">签约套数</th> 
	                <th field="q3" hidden width="100px">签约面积</th> 
	                <th field="q4" hidden width="100px">签约总价</th>
	            </tr>  
	        </thead>  
	    </table>  
	    <div id="toolbar" style="background-color: #eeeeee;height: auto;overflow: scroll;">
	        <table style="height: auto;width: auto;white-space: nowrap">
	        	<tr>
	        	
		        	<td>
			        	&nbsp;项目<input type="text" id="projectName" size="40" name="projectName" value="${propertyUnitCond.strSearchProjectNames}"/>
			       		&nbsp;销售
		        	</td>
		        	
</textarea>
<br/>

</body>
</html>

