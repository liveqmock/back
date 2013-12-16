<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
         isELIgnored="false"%>
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
    <title>年度销售计划及落实情况</title>
    <s:include value="header_report.jsp"></s:include>
    <script type="text/javascript">
        $().ready(function() {
            bindProjectDialogForXKZX("projectName", "hiddenId"); //多个项目的选择
            parent.hideLoading("年度销售计划及落实情况");
        });

        function submitSearch() {
            $("#thisForm").submit();
        }
    </script>
</head>
<body  style="padding:0px;background:white;">

<div class="right99"></div>
<form class="registerform" id="thisForm"  method="post" action="./saleunit_new_report/report/guangzhou/ndxsjhReport.action">
<table width="100%" border="0" align="left" cellspacing="0">

<tr>
    <td colspan="6"><label>&nbsp;<span>项目</span> </label> <input
            type="text" id="projectName" name="propertyUnitCond.strSearchProjectNames" value="${propertyUnitCond.strSearchProjectNames}" /> <input type="hidden" id="hiddenId"
                                                                                                                                                   name="propertyUnitCond.strSearchProjectIds" value="${propertyUnitCond.strSearchProjectIds}" />
        年度<input  type="text" style="width:90px"
                  name="propertyProjectPlanCond.planMonth" value="2012" /> &nbsp;<input
                type="button"  onclick="return submitSearch()"  value=" 查询  " />
        <div class="right99"></div>
        <div class="blueline"></div></td>
</tr>

<!-- 搜索表单 end -->


<tr>
<td colspan="6">

<div class="gbox1">

<table width="100%" border="0" align="center" cellpadding="0"
       cellspacing="1" class="gbox" style="text-align: center;">
<tr class="gboxbg">
    <th colspan="2">2012年1-12月</th>
    <th>一月</th>
    <th>二月</th>
    <th>三月</th>
    <th>四月</th>
    <th>五月</th>
    <th>六月</th>
    <th>七月</th>
    <th>八月</th>
    <th>九月</th>
    <th>十月</th>
    <th>十一月</th>
    <th>十二月</th>
    <th>合计</th>
    <th>平均值</th>
    <th>剩余</th>
</tr>


</table>
</div>

</td>
</tr>
</table>
</form>
</body>
</html>



