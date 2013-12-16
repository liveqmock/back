<%@ page contentType="text/html; charset=utf-8" %>

<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<div class="easyui-tabs" fit="true" border="false" id="financial_tabs">

	<div title="收款内容" id="_pay_info" uid="" iconCls="icon-reload" toHref="./saleunit_financial_manager/guangzhou/receiptList.action?unitId=">
	</div>
	
	<div title="应收款减免延期管理" id="_unit_pay_de_tab" uid="" toHref="./saleunit_financial_manager/guangzhou/unitPayDelayInfo.action?billId="> 
	</div>
	
	<div title="发票内容" id="_bill_info" uid=""  toHref="./saleunit_financial_manager/guangzhou/invoiceInfo.action?id="> 
	</div>
	
	<div title="客户内容"  style="padding:0px;" id="_customer_info" uid="" toHref="./saleunit_new/appoint/guangzhou/customerInfo.action?id=">		
	</div>
	
	<div title="单元内容" id="_unit_info" uid="" toHref="./saleunit_new_init/appoint/guangzhou/unitInfo.action?id=">
	</div>
	
	<div title="自定义数据"  style="" id="_property_unit_define_info" uid="" toHref="./saleunit_new/appoint/guangzhou/propertyUnitDefineTab.action?unitId=">
	</div>	
	
	<div title="延期签约"  style="" id="_extension_contract" uid="" toHref="./saleunit_new/appoint/guangzhou/extensionContractList.action?id=">			
	</div>
	
	<div title="业主更名"  style="" id="_updatet_customer" uid="" toHref="./saleunit_new/appoint/guangzhou/showContract.action?id=">			
	</div>

	<div title="客户服务事件"  style="" id="_customer_event_tabls" uid="" toHref="./saleunit_new/appoint/guangzhou/customerEvent.action?id=">			
	</div>
	
</div>