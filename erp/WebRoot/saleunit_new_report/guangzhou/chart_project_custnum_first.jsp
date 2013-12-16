<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page import="com.ihk.constanttype.EnumDevFlag" %>
<%@ page import="com.ihk.permission.PermissionUtils" %>
<%@ page import="com.ihk.constanttype.EnumPrivCode" %>
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
    <title>项目客户量比例(已废弃，由customer_num_compare_company.jsp替代)</title>

    <s:include value="header_report.jsp"></s:include>

    <script type="text/javascript" src="<%=basePath%>/js/userAccount-hengda.js" ></script>
    <!--
    <script type="text/javascript" src="./js/customer_guangzhou.js"></script>
    -->

    <script type="text/javascript">
        $(document).ready(function() {
            bindProjectDialogForSQKH("projectName", "hiddenId"); //多个项目的选择

            $("#formweek").click(function(){
                $("#datetype").val("week");
                submitSearch();
                return false;
            });

            $("#formmonth").click(function(){
                $("#datetype").val("month");
                submitSearch();
                return false;
            });

        });
    </script>

    <script type="text/javascript">
        function submitSearch(dir){
            if(dir == "export")
                exportMessage();
            else
                $("#thisForm").submit();
        }

        function submitSearchProject(projectId){
            $("#hiddenId").val(projectId);
            submitSearch('search');
        }

        function redirectCustomerNum(projectId){
            $("#hiddenId").val(projectId);
            $("#customerCond_projectId").val(projectId);

            $(window.parent.document).find("#showTitle").text('客户数量环比图');
            $("#thisForm").attr("action", "./saleunit_new_report/report/guangzhou/customerNum.action").submit();
        }

        function exportMessage(){
            $(function(){
                $('#thisForm').form({
                    url:'./saleunit_new_report/report/guangzhou/andCustExport.action'
                });
                $('#thisForm').submit();
            });
        }
    </script>


</head>
<body style="padding:0px;background:white;">

<%--主体导航页头 --%>
<div class="right99"></div>

<%--主体table --%>
<form id="thisForm"  method="post" action="./saleunit_new_report/report/guangzhou/projectAndCustNum.action">
    <table width="100%" border="0" align="left" cellspacing="0">

        <tr>

            <td colspan="6">
                &nbsp;项目<input type="text" id="projectName" size="40" name="projectName" value="${cond.strSearchProjectNames}"/>
                <input type="hidden" id="hiddenId" name="cond.strSearchProjectIds" value="${cond.strSearchProjectIds}"/>
                <input type="hidden" id="customerCond_date1" name="customerCond.date1" value="${cond.date1 }"/>
                <input type="hidden" id="customerCond_date2" name="customerCond.date2" value="${cond.date2 }"/>
                <input type="hidden" id="datetype" name="datetype"/>
                &nbsp;
                日期<input class="easyui-datebox" type="text" id="date1" style="width:90px" name="cond.date1" value="${cond.date1}"/>
                -
                <input class="easyui-datebox" type="text" id="date2" style="width:90px" name="cond.date2" value="${cond.date2}"/>
                &nbsp;<a id="formweek" href="#" style="color: #1199FF;" class="ablue">本周</a>
                &nbsp;<a id="formmonth" href="#" style="color: #1199FF;" class="ablue">本月</a>
                &nbsp;<input type="button" onclick="return submitSearch('search')" value=" 查询  "/>
                <%if(PermissionUtils.hasPermission(EnumPrivCode.REPORT_PRECUSTOMER_EXCEL, EnumDevFlag.GUANGZHOU) ){%>
                    <input type="button" onclick="return submitSearch('export')" value="导出" />
                <%} %>
                <div class="right99"></div>
                <div class="blueline"></div>

            </td>
        </tr>


    </table>
</form>
</body>
</html>



   
   



