<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page import="com.ihk.constanttype.EnumDevFlag" %>
<%@ page import="com.ihk.constanttype.EnumPrivCode" %>
<%@ page import="com.ihk.permission.PermissionUtils" %>
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
    <title>销售分析(按项目)</title>

    <s:include value="../../header/header_easyui.jsp"></s:include>
    <script language="javascript" type="text/javascript" src="<%=basePath%>js/project.list.utils.js?v=1.2"></script>
    <script type="text/javascript" src="<%=basePath%>js/highcharts.js"></script>
    <script type="text/javascript" src="<%=basePath%>js/datetime.utils.js?v=1"></script>
    <script type="text/javascript" src="<%=basePath%>/js/customer_guangzhou_project.js" ></script>

    <script type="text/javascript">

        //查询本月
        function queryFormByMonth(){
            setTwoDatebox("thismonth",$("#date1"),$("#date2"));
            queryForm();
        }

        //查询
        function queryForm(){
            //使用.datagrid的方法设置easyui组件,那么该table的class不要设置为easyui-datagrid，否则会两次加载渲染
            $("#dg").datagrid({
                url:"./saleunit_new_report/report/guangzhou/saleReportProjectAjax.action",
                queryParams:getInputsAsOjbect(["cond.strSearchCompanyIds","cond.strSearchCompanyProjectIds","cond.date1","cond.date2","cond.sort","cond.order","selType"])
            });
        }

        //dategrid显示下划线，超链接
        function formatterProjectName(value,row,index){
            if(value == '合计')return value;
            var date1 = $("#date1").datebox('getValue');
            var date2 = $("#date2").datebox('getValue');

            var projectId = row.projectId;

            var url = './saleunit_new_report/report/guangzhou/saleReportSale.action?'+
                    'cond.date1='+date1+
                    '&cond.date2='+date2+
                    '&cond.strSearchCompanyProjectIds='+projectId+
                    '&selType='+$("#selType").val();
            var url = "<a style='color: #1199FF;cursor: pointer;' class='ablue' onclick=\"parent.OpenAndRefreshTab(" + "\'销售分析(销售人员)_"+value+"\',\'" + url + "\')\">" + value + "</a>";
            return 	url;
        }

        $().ready(function() {
            var paraObj = requestParaToObject();
            //根据传入的参数来进行查询
            if(typeof(paraObj["cond.strSearchCompanyIds"])!="undefined"){
                $("#strSearchCompanyIds").val(paraObj["cond.strSearchCompanyIds"]);

                $("#date1").datebox("setValue",paraObj["cond.date1"]);
                $("#date2").datebox("setValue",paraObj["cond.date2"]);
                $("#selType").val(paraObj["selType"]);
                queryForm();
            }
            else{
                queryFormByMonth();
            }
            bindProjectDialogForXKZX("projectNames", "projectIds"); //多个项目的选择
        });

        function download(){
            location.href = './saleunit_new_report/report/guangzhou/saleReportProjectDownload.action';
        }
    </script>
</head>
<body style="padding:0px;background:white;">
<table id="dg"
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
        <th field="projectName" width="200px"   formatter="formatterProjectName">项目名称</th>
        <th field="sumAmount" width="100" sortable="true" align="right">套数</th>
        <th field="sumArea" width="100" sortable="true" align="right" >面积(㎡)</th>
        <th field="sumMoney" width="100" sortable="true" align="right">总价(元)</th>
        <th field="leftAmount"  width="100" sortable="true" align="right">当前剩余套数</th>
        <th field="leftArea"  width="100" sortable="true" align="right">当前剩余面积(㎡)</th>
        <th field="leftMoney"  width="100" sortable="true" align="right">当前剩余货值(元)</th>
    </tr>
    </thead>
</table>
<div id="toolbar"  style="padding:5px;height:auto">
    &nbsp;项目<input type="text" id="projectNames" size="40" name="projectNames" />
    <input type="hidden" id="projectIds" name="cond.strSearchCompanyProjectIds" />
    <input type="hidden" id="strSearchCompanyIds" name="cond.strSearchCompanyIds" />
    <input type="hidden" name="cond.sort" value="sumMoney"/>
    <input type="hidden" name="cond.order" value="desc"/>
    &nbsp;日期<input class="easyui-datebox" type="text" id="date1" style="width:90px" name="cond.date1"/>
    -
    <input class="easyui-datebox" type="text" id="date2" style="width:90px" name="cond.date2"/>

    类型<s:select list="#{'confirm':'认购','contract':'签约','confirmBook':'临定'}" id="selType" name="selType" listKey="key" listValue="value" ></s:select>
    &nbsp;<input type="button" onclick="queryForm()" value=" 查询 "/>

    <%if(PermissionUtils.hasPermission(EnumPrivCode.REPORT_SALEUNIT_DOWNLOAD, EnumDevFlag.GUANGZHOU) ){%>
    &nbsp;<input type="button" onclick="download()" value=" 导出 "/>
    <%} %>

</div>
</body>
</html>



   
   



