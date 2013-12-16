<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
         isELIgnored="false"%>
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
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>销售货量分析（按分类）</title>
    <s:include value="header_report.jsp"></s:include>
    <script type="text/javascript">

        $().ready(function() {
            parent.hideLoading("销售货量分析(按分类)");
            //projectListForHiddenId("projectName", "hiddenId"); //项目的联想框,及用隐藏域保存其id
            bindProjectDialogForXKZX("projectName", "hiddenId"); //多个项目的选择
        });

        function submitSearch() {
            if($('#hiddenId').val()==''){
                myAlert("必须选择项目或公司再查询");
                return false;
            }

            $("#thisForm").submit();
        }

        function exportMessage(){
            $(function(){
                $('#exportFm').form({
                    url:'./saleunit_new_report/report/guangzhou/xshlfxFldownload.action'
                });
                $('#exportFm').submit();
            });
        }
    </script>
</head>
<body  style="padding:0px;background:white;">

<div class="right99"></div>
<table width="2100px" border="0" align="left" cellspacing="0">

    <tr>
        <td colspan="6">
            <form class="registerform" id="thisForm" method="post" action="./saleunit_new_report/report/guangzhou/xshlfxFlReport.action">
                <label>&nbsp;<span>项目</span> </label>
                <input type="text" id="projectName" size="40" name="propertyUnitCond.strSearchProjectNames" value="${propertyUnitCond.strSearchProjectNames}" />
                <input type="hidden" id="hiddenId" name="propertyUnitCond.strSearchProjectIds" value="${propertyUnitCond.strSearchProjectIds}" />

                截止日期<input
                    class="easyui-datebox" type="text" style="width:90px"
                    name="propertyUnitCond.date2" value="${propertyUnitCond.date2}" /> &nbsp;<input
                    type="button" onclick="return submitSearch('search')" value=" 查询  " />
                <div class="right99"></div>
                <div class="blueline"></div>
            </form>

            <%if(PermissionUtils.hasPermission(EnumPrivCode.REPORT_SALEUNIT_DOWNLOAD, EnumDevFlag.GUANGZHOU) ){%>
            <form id="exportFm" method="post">
                <input style="float:left;margin-left:460px;margin-top:-33px;" type="button" onclick="return exportMessage()" value="导出" />
            </form>
            <%} %>

        </td>
    </tr>

    <!-- 搜索表单 end -->

</table>
</body>
</html>

