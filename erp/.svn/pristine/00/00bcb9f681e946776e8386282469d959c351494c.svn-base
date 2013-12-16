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
            var tempStr = $("#dateui").datebox("getValue");
            $('#fnEdit').form({
                url:'./customer/collection/editImp.action?dt='+tempStr,
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
    <table width="100%">
        <tr>
            <td class="font-design">客户编号:</td>
            <td><s:textfield name="vipCustImp.customerNo" /></td>
            <td class="font-design">来源:</td>
            <td><s:textfield name="vipCustImp.source" /></td>
        </tr>
        <tr>
            <td class="font-design">客户姓名:</td>
            <td><s:textfield name="vipCustImp.customerName" /></td>
            <td class="font-design">日期:</td>
            <td><input id="dateui" class="easyui-datebox" name="vipCustImp.dealDate" value="<s:date format="yyyy-MM-dd"  name='vipCustImp.dealDate'/>" ></td>
        </tr>
        <tr>
            <td class="font-design">身份证号:</td>
            <td><s:textfield id="idcardNo" name="vipCustImp.idcardNo" /></td>
            <td class="font-design">固定电话:</td>
            <td><s:textfield name="vipCustImp.tel" /></td>
        </tr>
        <tr>
            <td class="font-design">移动电话:</td>
            <td><s:textfield name="vipCustImp.phone" /></td>
            <td class="font-design">联系地址:</td>
            <td><s:textfield name="vipCustImp.contactAddr" /></td>
        </tr>
        <tr>
            <td class="font-design">居住区域:</td>
            <td><s:textfield name="vipCustImp.resideArea" /></td>
            <td class="font-design">工作区域:</td>
            <td><s:textfield name="vipCustImp.wordArea" /></td>
        </tr>
        <tr>
            <td class="font-design">所在行政区:</td>
            <td><s:textfield name="vipCustImp.adArea" /></td>
            <td class="font-design">户籍:</td>
            <td><s:textfield name="vipCustImp.natives" /></td>
        </tr>
        <tr>
            <td class="font-design">项目名称:</td>
            <td><s:textfield name="vipCustImp.projectName" /></td>
            <td class="font-design"></td>
            <td>&nbsp;</td>
        </tr>
        <tr>
            <td class="font-design">楼层:</td>
            <td><s:textfield name="vipCustImp.area" /></td>
            <td class="font-design">楼栋:</td>
            <td><s:textfield name="vipCustImp.building" /></td>
        </tr>
        <tr>
            <td class="font-design">楼层:</td>
            <td><s:textfield name="vipCustImp.floor" /></td>
            <td class="font-design">房号:</td>
            <td><s:textfield name="vipCustImp.room_no" /></td>
        </tr>
        <tr>
            <td class="font-design">购买总价:</td>
            <td><input  name="vipCustImp.total" value="<s:text name="vipCustImp.strTotal"/>" ></td>

            <td class="font-design">购买面积:</td>
            <td><s:textfield name="vipCustImp.areaSize"/></td>
        </tr>
        <tr>
            <td class="font-design">建筑面积:</td>
            <td><s:textfield name="vipCustImp.construction_area"/></td>
            <td class="font-design">付款方式:</td>
            <td><s:textfield name="vipCustImp.paymethod"/></td>
        </tr>
        <tr>
            <td class="font-design">商圈:</td>
            <td><s:textfield name="vipCustImp.businesscircle"/></td>
            <td class="font-design">类型:</td>
            <td><s:textfield name="vipCustImp.constructtype"/></td>
        </tr>
        <tr>
            <td><input type="button" onclick="subdata()" class="btn1_mouseover" value="修改"></td>
            <td></td>
            <td></td>
            <td><s:textfield name="vipCustImp.id" style="visibility:hidden" /></td>
        </tr>
    </table>

</form>
</body>

</html>