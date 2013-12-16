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
    <title>对数管理</title>
    <s:include value="header.jsp"></s:include>
    <script type="text/javascript">

        $(document).ready(function(){

            bindProjectAreaBuildForXKZX("projectId", "areaId", "buildId"); //销控中心角色的项目,分区,楼栋级联

            $('#tbList').datagrid({
                width:'auto',
                height: 430,
                /*fitColumns: true,*/
                /*fix:true,*/
                loadMsg:'数据加载中...',
                url:'<%=basePath%>saleunit_new/checkfee/checkfee_view.action',
                columns:[[
                    {field:'ck',checkbox:true, hidden:true},
                    {field:'unit_id',title:'单元ID',hidden:true},
                    {field:'checkfeeTypeName',title:'状态',width:70,align:"center"},
                    {field:'checkfee_date',title:'对数日期',width:70,align:"center"},
                    {field:'work_date',title:'成交日期',width:70,align:"center"},
                    {field:'sign_date',title:'签约日期',width:70,align:"center"},
                    {field:'area_name',title:'分区',width:50},
                    {field:'build_name',title:'楼栋',width:50},
                    {field:'unit_no',title:'单元号',width:50},
                    {field:'customer_name',title:'业主姓名',width:100,sortable:true},
                    {field:'build_area',title:'建筑面积(㎡)',width:60,sortable:true,align:"right"},
                    {field:'sum_price',title:'成交总价(元)',width:80,sortable:true,align:"right"},
                    {field:'contract_no',title:'合同号',width:50},
                    {field:'pay_name',title:'付款方式',width:50},

                    {field:'repayMoney',title:'回款金额',width:100,align:"right"},
                    {field:'repayAmount',title:'合计回款金额',width:100,align:"right"},
                    {field:'receiptId',title:'实收款ID',width:50,hidden:true},

                    {field:'sales',title:'销售人员'}

                ]],
				striped: true,
                showFooter: true,
                singleSelect:true
            });
        });
       
        function exportExcel(){
           
		   location.href = './saleunit_new/checkfee/exportExcel.action';
        }

    </script>
</head>
<body  style="padding:0;background:white;">


<div id="toolbar" style="height: auto;padding: 5px">
    <input type="button" onclick="return exportExcel()" value="导出对数表" />
</div>


<div region="center" style="background:#ffffff;overflow:hidden;padding:5px;">
    <table id="tbList"></table>
</div>


</body>
</html>
