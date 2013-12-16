<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
         isELIgnored="false"%>
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
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>销售货量分析（按楼层）</title>
    <s:include value="header_report.jsp"></s:include>

    <script type="text/javascript" src="<%=basePath%>js/highcharts.js"></script>
    <script type="text/javascript">

        $().ready(function() {
            parent.hideLoading("销售货量分析(按楼层)");
            //projectListForHiddenId("projectName", "hiddenId"); //项目的联想框,及用隐藏域保存其id
            bindProjectDialogForXKZX("projectName", "hiddenId"); //多个项目的选择

        });

        function submitSearch(dir){
            if(dir == 'export')
                exportMessage();
            else{
                parent.showLoading();
                $("#thisForm").submit();
            }
        }

        function exportMessage(){
            location.href='./saleunit_new_report/report/guangzhou/xshlfxLcdownload.action'
        }

        //查看项目列定义
        function query() {
            $('#openlcIframe')[0].src="./saleunit_new_report/report/guangzhou/queryXshlfxLcL.action";
            $('#querylc').window('open');
        }
    </script>
</head>
<body  style="padding:0px;background:white;">

<div class="right99"></div>
<form class="registerform" id="thisForm" method="post" action="./saleunit_new_report/report/guangzhou/xshlfxLcReport.action">
    <table width="1000px" border="0" align="left" cellspacing="0">

        <tr>
            <td colspan="6"><label>&nbsp;<span>项目</span> </label>
                <input type="text" id="projectName" size="40" name="propertyUnitCond.strSearchProjectNames" value="${propertyUnitCond.strSearchProjectNames}" />
                <input type="hidden" id="hiddenId" name="propertyUnitCond.strSearchProjectIds" value="${propertyUnitCond.strSearchProjectIds}" />

                截止日期<input
                        class="easyui-datebox" type="text" style="width:90px"
                        name="propertyUnitCond.date2" value="${propertyUnitCond.date2}" /> &nbsp;<input
                        type="button" onclick="return submitSearch('search')" value=" 查询  " />
                <%if(PermissionUtils.hasPermission(EnumPrivCode.REPORT_SALEUNIT_DOWNLOAD, EnumDevFlag.GUANGZHOU) ){%>
                <input type="button" onclick="return submitSearch('export')" value="导出" />
                <%} %>
                <a class="easyui-linkbutton" iconCls="icon-search" href="javascript:void(0);" onclick="query()">查看项目列定义</a>
                <div class="right99"></div>
                <div class="blueline"></div></td>
        </tr>

        <!-- 搜索表单 end -->

    </table>
</form>

<!-- 弹出查看项目列定义页面 -->
<div id="querylc" class="easyui-window" title="查看项目列定义" style="width: 530px;height:310px;"
     closed="true" maximizable="false" minimizable="false" collapsible="false">
    <iframe scrolling="yes" id='openlcIframe' frameborder="0"  src="" style="width:100%;height:100%;"></iframe>
</div>
</body>
</html>
