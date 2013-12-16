<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<div style="margin-left: auto;margin-right: auto;width: 400px;margin-top:10px;">
    <form id="fnEdit" action="./saleunit_contract/manager/updatePaidIn.action" method="post">
        <table>


            <tr>
                <td class="font-design">对应应收月份:</td>
                <td><input id="dateui" class="easyui-datebox" name="apPayment.receiptdate" value="<s:date format="yyyy-MM-dd"  name='apPayment.receiptdate'/>" ></td>

            </tr>
            <tr>
                <td class="font-design">实收金额:</td>
                <td><s:textfield name="apPayment.amount"/></td>
            </tr>
            <tr>
                <td class="font-design">备注:</td>
                <td><s:textfield name="apPayment.remark"/></td>

            </tr>

        </table>
        <s:textfield name="apPayment.id" style="visibility:hidden" />
    </form>

</div>