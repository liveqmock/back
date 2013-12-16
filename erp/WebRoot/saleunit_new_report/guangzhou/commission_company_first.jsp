<%@ page language="java" pageEncoding="UTF-8"	isELIgnored="false"%>

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
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>公司结佣表</title>
    <s:include value="header_report.jsp"></s:include>
    <script type="text/javascript">
        $(document).ready(function(){
            bindCompanyForXKZX("companyName", "companyID"); //单个项目的选择

            $('#tbList').datagrid({
                height: 'auto',
                width: 'auto',
                fitColumns: true,
                loadMsg:'数据加载中...',
                url:'',
                columns:[[
                    {field:'company_name',title:'公司名',width:100,sortable:true},
                    {field:'build_area',title:'面积(㎡)',width:50,sortable:true,align:"right"},
                    {field:'build_price',title:'成交单价(元)',width:60,sortable:true,align:"right"},
                    {field:'sum_price',title:'成交金额(元)',width:80,sortable:true,align:"right"},
                    {field:'should_amount',title:'应收金额',width:80,align:"right"},
                    {field:'relCommissionAmount',title:'关系户应收金额',width:80,align:"right"},
                    {field:'secondshould_amount',title:'一二手应收金额',width:80,align:"right"},
                    {field:'total_should_amount',title:'合计应收金额',width:80,align:"right"},
                    {field:'payment_amount',title:'实收金额',width:80,align:"right"},
                    {field:'otherAmount',title:'其它费用',width:80,align:"right"},
                    {field:'amount',title:'未收金额',width:80,align:"right"}

                ]],

                showFooter: true,
                singleSelect:true
            });
        });

        function submitSearch() {

            $('#tbList').datagrid({

                loadMsg:'数据加载中...',
                url:'./saleunit_new_report/report/guangzhou/commission_company.action',
                queryParams:{
                    companyID:$("#companyID").val()

                }

            });
        }
    </script>
</head>
<body  style="padding:0;background:white;">


<div id="toolbar" style="height: auto;padding: 5px">
    <form class="registerform" id="thisForm" name="thisForm"  method="post">
        <table width="100%" border="0" align="left" cellspacing="0">

            <tr>
                <td>

                <span style="margin: 0 0 0 12px">
                    
					<input type="text" id="companyName" value="" />
					<input type="hidden" id="companyID" name="propertyUnitCond.strSearchProjectIds" value="" />


                    <%--成交日期：
                    <input class="easyui-datebox" type="text" id="date1" style="width:90px" name="propertyUnitCond.date1" value="${propertyUnitCond.date1}"/>-
                    <input class="easyui-datebox" type="text" id="date2" style="width:90px" name="propertyUnitCond.date2" value="${propertyUnitCond.date2}"/>--%>

                </span>
                    <input type="button" onclick="return submitSearch()" value=" 查询  " />
                </td>
            </tr>
        </table>
    </form>
</div>

<table id="tbList">&nbsp;</table>



</body>
</html>
