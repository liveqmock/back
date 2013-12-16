<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title></title>
    <base href="<%=basePath%>"/>
    <link rel="stylesheet" type="text/css" href="./css/easyui.css">
    <link rel="stylesheet" type="text/css" href="./css/icon.css">
    <link rel="stylesheet" type="text/css" href="./css/easydemo.css">
    <script type="text/javascript" src="./js/jquery-1.6.2.min.js"></script>
    <script type="text/javascript" src="./js/jquery.easyui.min.js"></script>
    <style type="text/css">
        .font-design{
            text-align:right;
            font-size:12px;
        }
        .btn1_mouseover {
            BORDER-RIGHT: #2C59AA 1px solid; PADDING-RIGHT: 2px; BORDER-TOP: #2C59AA 1px solid; PADDING-LEFT: 2px; FONT-SIZE: 12px;
            FILTER: progid:DXImageTransform.Microsoft.Gradient(GradientType=0, StartColorStr=#ffffff, EndColorStr=#C3DAF5); BORDER-LEFT: #2C59AA 1px solid;
        CURSOR: hand; COLOR: black; PADDING-TOP: 2px; BORDER-BOTTOM: #2C59AA 1px solid
            }
    </style>
    <script type="text/javascript">

        function subdata(){
            //var tempStr = $("#dateui").datebox("getValue");
            $('#fnEdit').form({
                url:'./saleunit_contract/manager/updateReceiveIn.action',
                success:function(data){
                    $.messager.defaults = { ok: '确定'};
                    $.messager.alert('提示', '修改成功', 'info');
                }
            });
            $('#fnEdit').submit();
        }

        $('#dateui').datebox({
            formatter: function(date){ return date.getFullYear()+'-'+(date.getMonth()+1)+'-'+date.getDate();},
            parser: function(date){ return new Date(Date.parse(date.replace(/-/g,"/")));}
        });
    </script>

</head>
<body>
<form id="fnEdit" action="" method="post">
    <table>
        <%--<tr>
            <td class="font-design">应收月份:</td>
            <td><input id="dateui" class="easyui-datebox" name="arAmount.arDate" value="<s:date format="yyyy-MM-dd"  name='arAmount.arDate'/>" ></td>
        </tr>--%>
        <tr>
            <td class="font-design">单元号:</td>
            <td><s:text name="arAmount.getPropertyUnit().getUnitNo()"/></td>
        </tr>
        <tr>
            <td class="font-design">实收金额:</td>
            <td><s:textfield name="arAmount.amount"/></td>
        </tr>
        <tr>
            <td class="font-design">备注:</td>
            <td><s:textfield name="arAmount.remark"/></td>
        </tr>
        <tr>
            <td class="font-design"></td>
            <td>
                <input type="button" onclick="subdata()" class="btn1_mouseover" value="修改" />
            </td>
        </tr>
    </table>
    <s:textfield name="arAmount.id" style="visibility:hidden" />
</form>
</body>

</html>