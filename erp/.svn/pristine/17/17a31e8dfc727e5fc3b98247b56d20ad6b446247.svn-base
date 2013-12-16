<%@ page language="java" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page contentType="text/html; charset=utf-8" %>

<%@ taglib prefix="s" uri="/struts-tags" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<base href="<%=basePath%>" />

<table style="width:auto; white-space:normal; text-align:center" border="0" align="center" cellpadding="0" cellspacing="1" class="gbox unit_table" >

    <tr bgcolor="#FFFFFF" style="line-height: 20px;">
        <td colspan="6" style="text-align:left; padding:0 0 0 10px">

            <%/*
			项目:<s:select list="projectMap" id="gather_project_select"></s:select>
			*/%>

            <!-- 用于判断是否要重新加载页面,如果这个值跟hiddenPropertyProjectId的值相同,就不用重新加载-->
            <input type="hidden" id="gatherTabsHiddenPropertyProjectId" value="${propertyProjectId}"/>

            项目名称:<b>${propertyProject.propertyName}</b>,

            销售状态:<s:select list="saleMap" id="gather_sale_select" name="saleId"></s:select>
            <a href="javascript:void(0)" id="search" class="easyui-linkbutton" iconCls="icon-search" onclick="searchGatherTabs()">查找</a>
        </td>
    </tr>

    <tr bgcolor="#FFFFFF" style="line-height: 26px; text-align:center">
        <td align="center" style="width:100px">
            套数
        </td>
        <td style="width:100px;padding-right: 20px;text-align: right" id="countTd">
        </td>
        <td align="center" style="width:110px">
            建筑面积
        </td>
        <td style="width:100px;padding-right: 20px;text-align: right" id="buildAreaTd">
        </td>
        <td align="center" style="width:100px">
            单价
        </td>
        <td style="width:100px" id="buildPriceTd">
        </td>


    </tr>

    <tr bgcolor="#FFFFFF" style="line-height: 26px; text-align:center">

        <td align="center" style="width:100px">
            成交总价
        </td>
        <td style="width:100px;padding-right: 20px;text-align: right" id="sumMoneyTd">
        </td>
        <td align="center" style="width:100px">
            未收金额
        </td>
        <td style="width:100px;padding-right: 20px;text-align: right" id="notMoneyTd">
        </td>

        <td align="center" style="width:100px;">

        </td>
        <td style="width:100px">
        </td>
    </tr>

    <tr bgcolor="#FFFFFF" style="line-height: 26px;">
        <td align="left" colspan="6" style="padding-left: 5px;color: red;">
             说明：未收金额 =  应收金额 + 一二手联动金额 + 关系户金额 - 实收金额 - 其他费用
        </td>
    </tr>

    <tr bgcolor="#FFFFFF" style="line-height: 26px;">
        <td align="center">
            应收金额
        </td>
        <td style="width: 100px;padding-right: 20px;font-weight:bold;text-align: right" id="shouldAmountTd">
        </td>
        <td align="center">
            一二手联动金额
        </td>
        <td style="width:100px;padding-right: 20px;font-weight:bold;text-align: right" id="secondLinkageAmountTd">
        </td>
        <td style="width:80px;padding-right: 20px;" align="center">
            关系户金额
        </td>
        <td style="width: 100px;padding-right: 20px;font-weight:bold;text-align: right" id="relAmountTd">
        </td>
    </tr>

    <tr bgcolor="#FFFFFF" style="line-height: 26px;">
        <td align="center">
            实收金额
        </td>
        <td style="width: 100px;padding-right: 20px;font-weight:bold;text-align: right" id="paymentAmountTd">
        </td>
        <td align="center">
            其他费用
        </td>
        <td style="width:100px;padding-right: 20px;font-weight:bold;text-align: right" id="otherExpensesTd">
        </td>
        <td style="width:80px;padding-right: 20px;" align="center">

        </td>
        <td style="width: 100px;padding-right: 20px;color: red;font-weight:bold;text-align: right" >
        </td>
    </tr>

    <tr bgcolor="#FFFFFF" style="line-height: 26px;">
        <td align="left" colspan="6" style="padding-left: 5px;color: red;">
            说明：以下需使用“底价管理”才有数据
        </td>
    </tr>

    <tr bgcolor="#FFFFFF" style="line-height: 26px;">

        <td width="80px" align="center">
            单价(溢价)
        </td>

        <td style="width:100px;padding-right: 20px;font-weight:bold;text-align: right" id="priceOutTd"></td>

        <td align="center">
            总价(溢价)
        </td>

        <td style="width:100px;padding-right: 20px;font-weight:bold;text-align: right" id="totalPriceOutTd"></td>

        <td align="center">

        </td>
        <td style="width:100px;padding-right: 20px;font-weight:bold;text-align: right"></td>


    </tr>

</table>
<br>
以下为各楼栋成交情况
<table id="gather_table">

    <thead>
    <tr>

        <th field="buildName" width="75">楼栋名称</th>

        <th field="count" width="40" align="center">套数</th>

        <th field="buildArea" width="80" align="right">建筑面积</th>

        <th field="buildPrice" width="80" align="right">成交单价</th>

        <th field="sumMoney" width="80" align="right">成交总价</th>

        <th field="shouldAmount" width="80" align="right">应收金额</th>
        <th field="secondLinkageAmount" width="80" align="right">一二手联动金额</th>
        <th field="relAmount" width="80" align="right">关系户金额</th>

        <th field="paymentAmount" width="80" align="right">实收金额</th>

        <th field="notMoney" width="80" align="right">未收金额</th>

        <th field="priceOut" width="80" align="right">单价溢价</th>

        <th field="totalPriceOut" width="80" align="right">总价溢价</th>

    </tr>

    </thead>
</table>