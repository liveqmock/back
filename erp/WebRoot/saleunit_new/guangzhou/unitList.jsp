<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page contentType="text/html; charset=utf-8" %>

<%@ taglib prefix="s" uri="/struts-tags" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<base href="<%=basePath%>" />
<script type="text/javascript" language="javascript" src="<%=basePath%>js/customer_guangzhou_user.js"></script>

<script type="text/javascript">

    function submitSearch(){
        var buildId = $("#buildId").val();
        var saleState =  $('#saleStateId').val();
        var unitNo =  $("#unitNo").val();
        var confirmDate =  $("#confirmDate").datebox("getValue");
        var payName =  $("#payName").val();
        var sales =  $("#hiddenUserId").val();
        var realBuildArea1 =  $("#realBuildArea1").val();
        $("#dg").datagrid({
            url:'./saleunit_new/appoint/guangzhou/date/searchUnit.action',
            queryParams:{'selectType':'__appoint__','unitCond.buildId':buildId,
                'unitCond.saleState':saleState,'unitCond.unitNo':unitNo,'unitCond.confirmDate':confirmDate,
                'unitCond.payName':payName, 'unitCond.sales':sales, 'unitCond.realBuildArea1':realBuildArea1},
            onClickRow:function(rowIndex,rowData){
                tdClick(rowData);
            }

        });
    }
    $(document).ready(function(){
        baseProjectListForHiddenId("saleName", "hiddenUserId", "./customer_guangzhou/search/sales.action", "");
    });

</script>
<style type="text/css">
    #toolbar td{padding-left: 5px;text-align: right}
</style>

<table id="dg" title="" class="easyui-datagrid" style="width:auto;height:auto;"
       toolbar="#toolbar"
       loadMsg='加载中...'
       pagination="true"
       showFooter='true'
       singleSelect='true'
       striped='true'
        >
    <thead>
    <tr>
        <th field="unitid" width="100px" hidden="true">房间号</th>
        <th field="unitNo" width="100px">房间号</th>
        <th field="saleState" width="40px">状态</th>
        <th field="customerName" width="100px">客户名称</th>
        <th field="saleDate" width="70px">认购日期</th>
        <th field="saleSumPrice" width="70px" align="right">销售总价(万)</th>
        <th field="buildArea" width="60px" align="right">面积(㎡)</th>
        <th field="payName" width="80px">付款方式</th>
        <th field="saleUser" width="80px">销售人员</th>
        <th field="ConfirmContractCreateOrShowHref" width="200px">操作</th>
    </tr>
    </thead>
</table>

<div id="toolbar" style="height: auto;padding: 2px;overflow: hidden;">
    <table style="white-space: nowrap" cellpadding="1" cellspacing="2">
        <tr>

            <td>楼栋</td>
            <td align="left">
                <s:select list="buildList" id="buildId" emptyOption="true" cssStyle="width:200px"></s:select>
            </td>
            <td>单元</td>
            <td align="left">
                <input type="text" maxlength="20" id="unitNo" size="10" style="width:60px">
            </td>
            <td>房间状态</td>
            <td align="left">
                <s:select list="saleStateList" id="saleStateId" emptyOption="true" cssStyle="width:90px"></s:select>
            </td>
            <td> </td>
            <td> </td>


        </tr>

        <tr>
            <td>销售人</td>
            <td align="left">
                <%--<input id="sales" type="text" maxlength="20" size="10" style="width:85px">--%>

                <input type="text" id="saleName"/>
                <input type="hidden" id="hiddenUserId"/>
            </td>

            <td>付款方式</td>
            <td align="left">
                <input id="payName" type="text" maxlength="20" style="width:60px">
            </td>

            <%-- //没有查询的意义，屏蔽by wy 2013-05-07
            <td>面积</td>
            <td align="left">
                <input id="realBuildArea1" type="text" maxlength="20" size="10" style="width:60px">
            </td>--%>

            <td>认购日期</td>
            <td align="left">
                <input id="confirmDate" type="text" class="easyui-datebox"  size="10" style="width:90px">
            </td>


            <td>
                <input type="button" value=" 搜索 " style="height: 21px" onclick="submitSearch()"/>
            </td>
        </tr>
    </table>



</div>
	    
						
	
   

