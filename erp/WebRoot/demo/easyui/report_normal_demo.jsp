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
<b>报表常规做法说明：</b><br/>
1，用easyui的样式；<br/>
2,数据的处理，要在sql层做大部分处理，不要用action(java类)里面处理大量数据<br/>
<br/>

<p></p>
<b>参考：</b><br/>
<a href="./saleunit_new_report/report/guangzhou/saleReportSale.action" target="_blank">./saleunit_new_report/report/guangzhou/saleReportSale.action</a>

<br/>
<br/>
也可以参考：<br/>
项目跟进情况:<br/>
<a href="./saleunit_new_report/report/guangzhou/xmgjqkReport.action" target="_blank">./saleunit_new_report/report/guangzhou/xmgjqkReport.action</a><br/>
其中还包括了报表的跳转，下载，多项目，单项目的做法，弹出窗口来显示比例图<br/>
这里是ajax的方式，提高页面的性能与体验<br/>

<br/>
<p></p>
<b>主要代码说明：</b>
<br/>
<br/>
<b>代码示例：</b><br/>
<textarea rows="50" cols="150">
1，配置文件（struts-saleunit-new-report.xml）：
<action name="saleReportSale" class="com.ihk.saleunit.action.new_report.SaleReportSaleAction" method="index">
			<result name="success" >/saleunit_new_report/guangzhou/sale_report_sale.jsp</result>
		</action>
		
2,action里面的实际查询办法：
	public String search(){
		
		if(urcond == null)return null;
		
		try {
			new MyTransationTemplate() {
				@SuppressWarnings("unchecked")
				@Override
				protected void doExecuteCallback() throws Exception {
					
					JSONArray proJsList = new JSONArray();
					JSONObject onePro = new JSONObject();
						
3，jsp里面的写法：
<body style="padding:0px;background:white;">
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
	            	
4,json数据的配置写法：
		<action name="saleJsonSale" class="com.ihk.saleunit.action.new_report.SaleReportSaleAction" method="search">
			<result name="suc" type="json">
				<param name="root">res</param>
			</result>
		</action>	          
		
5,数据接口的写法(PropertyUnitMapper.xml)：
findListMapForReportByPidAndUserId
	<select id="findListMapForReportByPidAndUserId" resultType="java.util.Map">
		select c.sales_id r1,count(1) r2,sum(p.build_area) r3,sum(c.sum_money)
		r4 ,pr.project_name proName,c.sales_id as salesid,
		p.company_project_id as proId
		from property_unit
		p,confirm c,company_project pr
		where
		p.id = c.unit_id		  							
</textarea>
<br/>

</body>
</html>

