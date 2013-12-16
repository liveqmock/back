<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page import="com.ihk.permission.PermissionUtils" %>
<%@ page import="com.ihk.constanttype.EnumPrivCode" %>
<%@ page import="com.ihk.constanttype.EnumDevFlag" %>
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
    <title>销售分析(单元明细)</title>
    <s:include value="../../header/header_easyui.jsp"></s:include>
    <script language="javascript" type="text/javascript" src="<%=basePath%>js/project.list.utils.js?v=1.2"></script>
    <script type="text/javascript" src="<%=basePath%>js/highcharts.js"></script>
    <script type="text/javascript" src="<%=basePath%>js/datetime.utils.js?v=1"></script>
    <script type="text/javascript" src="<%=basePath%>/js/customer_guangzhou_project.js" ></script>

    <script type="text/javascript">

        //查询本周
        function queryFormByWeek(){
            setTwoDatebox("thisweek",$("#date1"),$("#date2"));
            queryForm();
        }

        //查询本月
        function queryFormByMonth(){
            setTwoDatebox("thismonth",$("#date1"),$("#date2"));
            queryForm();
        }

        //查询
        function queryForm(){
            //使用.datagrid的方法设置easyui组件,那么该table的class不要设置为easyui-datagrid，否则会两次加载渲染
            $("#dg").datagrid({
                url:"./saleunit_new_report/report/guangzhou/saleReportSaleUnitAjax.action",
                queryParams:getInputsAsOjbect(["cond.strSearchCompanyProjectIds","cond.date1","cond.date2","cond.strSalesId","cond.sort","cond.order","selType"])
            });
        }

        $().ready(function() {
            var paraObj = requestParaToObject();

            //根据传入的参数来进行查询
            if(typeof(paraObj["cond.strSalesId"])!="undefined"){
                $("#hiddenUserId").val(paraObj["cond.strSalesId"]);
                $("#date1").datebox("setValue",paraObj["cond.date1"]);
                $("#date2").datebox("setValue",paraObj["cond.date2"]);
                $("#selType").val(paraObj["selType"]);
                queryForm();
            }
            else{
                queryFormByMonth();
            }
            bindProjectDialogForXKZXOnly("projectNames", "projectIds"); //多个项目的选择(单选)

            baseProjectListForHiddenId("saleName", "hiddenUserId", "./customer_guangzhou/search/sales.action", "");
        });

        function download(){
            location.href = './saleunit_new_report/report/guangzhou/saleReportSaleUnitDownload.action';
        }

    </script>
</head>
<body style="padding:0px;background:white;">
<table
        id="dg"
        style="width:auto;height:auto;"
        toolbar="#toolbar"
        pagination="false"
        rownumbers="true" fitColumns="true"
        singleSelect="true"
        showFooter='true'
        striped='true'
        >
    <thead>
    <tr>
        <th field="buildName" width="100px">楼栋</th>
        <th field="roomNo" width="100px">房号</th>
        <th field="salesName" width="100px">销售</th>
        <th field="buildArea" width="100px" align="right">建筑面积</th>
        <th field="insideArea" width="100px" align="right">套内面积</th>
        <th field="sumPrice" width="100px" align="right" >标准总价</th>
        <th field="salePrice" width="100px" align="right">成交总价</th>
        <th field="workDate" width="100px" align="right">业务日期</th>
        <th field="payWay" width="100px">付款方式</th>
        <th field="discountPercent" width="100px" align="right">优惠折扣</th>
        <th field="customerName" width="100px">客户名称</th>
    </tr>
    </thead>
</table>
<div id="toolbar" style="padding:5px;height:auto">
    &nbsp;项目<input type="text" id="projectNames" size="40"/>
    <input type="hidden" id="projectIds" name="cond.strSearchCompanyProjectIds"/>
    &nbsp;销售<input type="text" id="saleName"  name="cond.saleName" title="按空格键可以查找前十条数据"/>
    <input type="hidden" id="hiddenUserId" name="cond.strSalesId" />
    <input type="hidden" name="cond.sort" value="sumMoney"/>
    <input type="hidden" name="cond.order" value="desc"/>
    日期<input class="easyui-datebox" type="text" id="date1" name="cond.date1" style="width:90px" />
    -
    <input class="easyui-datebox" type="text" id="date2" name="cond.date2" style="width:90px" />
    类型<s:select list="#{'confirm':'认购','contract':'签约','confirmBook':'临定'}" id="selType" name="selType" listKey="key" listValue="value" ></s:select>
    &nbsp;<input type="button" onclick="queryForm()" value=" 查询 "/>

    <%if(PermissionUtils.hasPermission(EnumPrivCode.REPORT_SALEUNIT_DOWNLOAD, EnumDevFlag.GUANGZHOU) ){%>
    &nbsp;<input type="button" onclick="download()" value=" 导出 "/>
    <%} %>
</div>
</body>
</html>



   
   



