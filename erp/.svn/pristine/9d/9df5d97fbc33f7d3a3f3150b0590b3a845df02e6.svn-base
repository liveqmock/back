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
    <title>客户录入分析(废弃了这个first页面，直接进入数据页面)</title>
    <s:include value="header_report.jsp"></s:include>

    <script type="text/javascript">
        $().ready(function(){

            //projectListForHiddenId("projectName", "hiddenId"); //项目的联想框,及用隐藏域保存其id
            bindProjectDialogForSQKHOnly("projectName", "hiddenId"); //多个项目的选择
        });


        function submitSearch(dir){
            $("#thisForm").attr("action", "./saleunit_new_report/report/guangzhou/redAnalysis.action").submit();

        }

        function exportMessage(){
            $(function(){
                $('#exportFm').form({
                    url:'./saleunit_new_report/report/guangzhou/redExport.action'
                });
                $('#exportFm').submit();
            });
        }
    </script>


</head>
<body style="padding:0px;background:white;">

<div class="right99"></div>

<%--主体table --%>

<table width="100%" border="0" align="left" cellspacing="0">

    <tr>
        <td>
            <form id="thisForm"  method="post" action="./saleunit_new_report/report/guangzhou/redAnalysis.action">
                &nbsp;项目<input type="text" id="projectName" size="40" name="projectName" value="${searchCond.strSearchProjectNames}"/>
                <input type="hidden" id="hiddenId" name="searchCond.strSearchProjectIds" value="${searchCond.strSearchProjectIds}"/>
                &nbsp;销售<input type="text" name="saleName" maxlength="20" value="${saleName }"/>
                &nbsp;日期<input class="easyui-datebox" type="text" id="date1" style="width:90px" name="searchCond.date1" value="${searchCond.date1}" maxlength="20"/>
                -
                <input class="easyui-datebox" type="text" id="date2" style="width:90px" name="searchCond.date2" value="${searchCond.date2}" maxlength="20"/>
                &nbsp; <input type="button" onclick="return submitSearch('search')" value="  查询  "/>
            </form>

            <%if(PermissionUtils.hasPermission(EnumPrivCode.REPORT_PRECUSTOMER_EXCEL, EnumDevFlag.GUANGZHOU) ){%>
            <form id="exportFm" method="post">
                <input style="float:left;margin-left:740px;margin-top:-24px;" type="button" onclick="return exportMessage()" value="导出" />
            </form>
            <%} %>
            <br/>
            选择单个项目，可以分析自定义问卷的录入质量
            <s:actionmessage cssStyle="color:red;"/>
        </td></tr>
    <tr>
        <td>
            <div class="right99"></div>
            <div class="blueline"></div>


        </td></tr></table>

</body>
</html>



   
   



