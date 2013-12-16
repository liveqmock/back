<%@ page import="com.ihk.constanttype.EnumDevFlag" %>
<%@ page import="com.ihk.constanttype.EnumPrivCode" %>
<%@ page import="com.ihk.permission.PermissionUtils" %>
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
    <title>结佣明细表</title>
    <s:include value="header_report.jsp"></s:include>
    <script type="text/javascript">
	    $(window).resize(function(){
			$('#tbList').datagrid('resize');
		});
        $(document).ready(function(){

            //bindProjectAreaBuildForXKZX("projectId", "areaId", "buildId"); //销控中心角色的项目,分区,楼栋级联
			
			bindProjectTreeAreaBuildOnly("projectId", "areaId", "buildId", "modifyProjectXKZX");

            $('#tbList').datagrid({
                height: $(this).height()-48,
                width: 'auto',
                fitColumns: true,
                /*fix:true,*/
                loadMsg:'数据加载中...',
                url:'',
                columns:[[
                    {field:'work_date',title:'成交日期',width:$(this).width() * 0.2,align:"center"},
                    {field:'unit_no',title:'单元号',width:$(this).width() * 0.2},
                    {field:'customer_name',title:'客户姓名',width:$(this).width() * 0.2,sortable:true},
                    {field:'build_area',title:'建筑面积(㎡)',width:$(this).width() * 0.2,sortable:true,align:"right"},
                    {field:'build_price',title:'成交单价(元)',width:$(this).width() * 0.2,sortable:true,align:"right"},
                    {field:'sum_price',title:'成交金额(元)',width:$(this).width() * 0.2,sortable:true,align:"right",formatter:fmtPriceColor},
                    {field:'commission',title:'佣金点',width:$(this).width() * 0.2,align:"center",formatter:fmtCommissionColor},
                    {field:'should_amount',title:'应收金额',width:$(this).width() * 0.2,align:"right",formatter:fmtCommissionColor},
                    {field:'relCommissionAmount',title:'关系户应收金额',width:$(this).width() * 0.2,align:"right"},
                    {field:'secondcommission',title:'一二手佣金点',width:$(this).width() * 0.2,align:"center"},
                    {field:'secondshould_amount',title:'一二手应收金额',width:$(this).width() * 0.2,align:"right"},
                    {field:'total_should_amount',title:'合计应收金额',width:$(this).width() * 0.2,align:"right"},
                    {field:'payment_amount',title:'实收金额',width:$(this).width() * 0.2,align:"right"},
                    {field:'amount',title:'未收金额',width:$(this).width() * 0.2,align:"right"}

                ]],

                showFooter: true,
                singleSelect:true
            });
        });

        //如果佣金被改过，显示蓝色
        function fmtCommissionColor(val,row) {
            if (row.commissionStatus == "0"){
                return '<span style="color:blue;">'+val+'</span>';
            } else {
                return val;
            }
        }
        //如果签了合同显示蓝色
        function fmtPriceColor(val,row) {
            if (row.status == "1"){
                return '<span style="color:blue;">'+val+'</span>';
            } else {
                return val;
            }
        }
        function submitSearch() {
        	var projectIds = $("input[name='propertyUnitCond.strSearchProjectIds']").val();
        	if(isNaN(projectIds)){
        		myAlert("请选择一个项目");
    			return ;
    		}
            $('#tbList').datagrid({
            	
                loadMsg:'数据加载中...',
                url:'./saleunit_new_report/report/guangzhou/commissionUnitAffirm.action',
                queryParams:{
                    projectIds:$("input[name='propertyUnitCond.strSearchProjectIds']").val(),
                    areaId:$("input[name='propertyUnitCond.areaId']").val() ,
                    buildId:$("input[name='propertyUnitCond.buildId']").val()
                }

            });
            
        }

        function exportExcel(){
            location.href = './saleunit_new_report/report/guangzhou/exportExcel.action?projectIds='
                    + $("input[name='propertyUnitCond.strSearchProjectIds']").val()
                    + "&areaId=" + $("input[name='propertyUnitCond.areaId']").val()
                    + "&buildId=" + $("input[name='propertyUnitCond.buildId']").val()
            ;
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
                    
					<input type="text" id="projectId" name="propertyUnitCond.strSearchProjectIds" value="${propertyUnitCond.strSearchProjectIds}" />
					<input type="text" id="areaId" name="propertyUnitCond.areaId" value="${propertyUnitCond.areaId}" />
					<input type="text" id="buildId" name="propertyUnitCond.buildId" value="${propertyUnitCond.buildId}" />

                    <%--成交日期：
                    <input class="easyui-datebox" type="text" id="date1" style="width:90px" name="propertyUnitCond.date1" value="${propertyUnitCond.date1}"/>-
                    <input class="easyui-datebox" type="text" id="date2" style="width:90px" name="propertyUnitCond.date2" value="${propertyUnitCond.date2}"/>--%>

                </span>
                    <input type="button" onclick="return submitSearch()" value="  查询  " />

                    <%if(PermissionUtils.hasPermission(EnumPrivCode.REPORT_FINANCIAL_DOWNLOAD, EnumDevFlag.GUANGZHOU) ){%>
                    <input type="button" onclick="return exportExcel()" value="  导出  " />
                    <%} %>
                </td>
            </tr>
        </table>
    </form>
</div>

<div region="center" style="background:#ffffff;overflow:hidden;padding:5px;">
    <table id="tbList"  class="easyui-datagrid"></table>
</div>



</body>
</html>
