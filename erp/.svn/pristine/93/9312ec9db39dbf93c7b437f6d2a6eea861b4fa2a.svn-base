<%@ page contentType="text/html; charset=utf-8" %>

<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<div class="easyui-tabs" fit="true" border="false" id="manager_bottom_tabs">

	<div title="单元信息" id="unit_info_tabs" iconCls="icon-reload" toHref="./saleunit_new/appoint/guangzhou/unitInfo.action"></div>
	
	<div title="客户资料" id="customer_info_tabs" toHref="./saleunit_new/appoint/guangzhou/customerInfo.action"></div>
			
	<div title="单元房款应收" id="unit_pay_bill_tabs" toHref="./saleunit_financial_manager/guangzhou/unitPayInfo.action"></div>
	
	<div title="单元房款收款明细" id="receipt_list_tabs" toHref="./saleunit_financial_tabs/guangzhou/receiptList.action"></div>
	
	<div title="单元实收佣金明细" id="unit_commission_tabs" toHref="./saleunit_financial_tabs/guangzhou/apPaymentList.action"></div>
	
</div>