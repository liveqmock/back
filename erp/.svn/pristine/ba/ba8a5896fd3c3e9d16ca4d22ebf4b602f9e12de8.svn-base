<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page import="com.ihk.constanttype.EnumPrivCode" %>
<%@ page import="com.ihk.constanttype.EnumDevFlag" %>
<%@ page import="com.ihk.permission.PermissionUtils" %>
<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>认筹分析 </title>
    <s:include value="header_report.jsp"></s:include>

    <script type="text/javascript">

        $().ready(function(){
            //页面加载时执行
            //projectListForHiddenId("projectName", "hiddenId"); //项目的联想框,及用隐藏域保存其id
            bindProjectDialogForXKZXOnly("projectName", "hiddenId"); //多个项目的选择
        });


        function submitSearch(){
            $("#thisForm").submit();
        }

        function exportMessage(){
            $(function(){
                $('#thisForm').form({
                    url:'./saleunit_new_report/report/guangzhou/rcfxdownload.action'
                });
                $('#thisForm').submit();
            });
        }
    </script>
</head>
<body  style="padding:0px;background:white;">

<div class="right99"></div>
<form class="registerform" id="thisForm" method="post" action="./saleunit_new_report/report/guangzhou/rcfxReport.action">
    <table width="100%" border="0" align="left" cellspacing="0">

        <tr>
            <td colspan="6">
                <label>&nbsp;<span>项目</span></label>
                <input type="text" id="projectName" name="propertyUnitCond.strSearchProjectNames" value="${propertyUnitCond.strSearchProjectNames}" />
                <input type="hidden" id="hiddenId" name="propertyUnitCond.strSearchProjectIds" value="${propertyUnitCond.strSearchProjectIds}" />
                &nbsp;
                <!--<span>楼栋(组团)</span></label><input type="text" />-->

                <span></span>


                日期<input class="easyui-datebox" type="text" id="date1" style="width:90px" name="propertyUnitCond.date1" value="${propertyUnitCond.date1}"/>
                -
                <input class="easyui-datebox" type="text" id="date2" style="width:90px" name="propertyUnitCond.date2" value="${propertyUnitCond.date2}"/>

                &nbsp;<input type="button" onclick="return submitSearch()" value=" 查询  "/>
                <%if(PermissionUtils.hasPermission(EnumPrivCode.REPORT_SALEUNIT_DOWNLOAD, EnumDevFlag.GUANGZHOU) ){%>
                <input type="button" onclick="return submitSearch('export')" value="导出" />
                <%} %>
                <div class="right99"></div>
                <div class="blueline"></div>
            </td>
        </tr>

        <!-- 搜索表单 end -->

    </table>


</form>



</body>
</html>