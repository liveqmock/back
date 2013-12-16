<%@ page contentType="text/html; charset=utf-8" %>

<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<div class="easyui-tabs" fit="true" border="false" id="manager_center_tabs">
	
	<div title="汇总" id="gather_tabs" toHref="./saleunit_contract/manager/toGatherTabs.action"></div>
	
	<div title="明细" id="detail_tabs" toHref="./saleunit_contract/manager/toDetailTabs.action"></div>
	
	<%--<div title="应收管理" id="should_tabs" toHref="./saleunit_contract/manager/receiveInManager.action?id="></div>--%>

	<div title="实收管理" id="paidin_tabs" toHref="./saleunit_contract/manager/paidInManager.action?id=" ></div>

    <div title="底价管理" id="baseprice_tabs" toHref="./saleunit_contract/manager/basePriceManager.action?id="></div>

    <div title="其他费用" id="other_tabs" toHref="./saleunit_contract/manager/toOtherExpensesTabs.action"></div>
	
	<div title="合同管理" id="contract_tabs" toHref="./saleunit_new_init/appoint/guangzhou/contractManager.action?for=Saleunit"></div>

</div>