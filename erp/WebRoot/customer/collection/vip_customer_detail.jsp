<%@ page language="java" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title></title>
    <base href="<%=basePath%>"/>
    <link rel="stylesheet" type="text/css" href="<%=basePath%>css/easyui.css" />
    <link rel="stylesheet" type="text/css" href="<%=basePath%>css/icon.css" />
    <link rel="stylesheet" type="text/css" href="<%=basePath%>css/easydemo.css" />
    <script type="text/javascript" src="<%=basePath%>js/jquery-1.6.2.min.js"></script>
    <script type="text/javascript" src="<%=basePath%>js/jquery.easyui.min.js"></script>
    <style type="text/css">
        .btn1_mouseover {
            BORDER-RIGHT: #2C59AA 1px solid; PADDING-RIGHT: 2px; BORDER-TOP: #2C59AA 1px solid; PADDING-LEFT: 2px; FONT-SIZE: 12px;
            FILTER: progid:DXImageTransform.Microsoft.Gradient(GradientType=0, StartColorStr=#ffffff, EndColorStr=#C3DAF5); BORDER-LEFT: #2C59AA 1px solid;
        CURSOR: hand; COLOR: black; PADDING-TOP: 2px; BORDER-BOTTOM: #2C59AA 1px solid
            }
    </style>

    <script type="text/javascript">
        $(function(){
            $('#tbItem').datagrid({
                width: 'auto',
                height: 'auto',
                nowrap: true,//是否只显示一行，即文本过多是否省略部分。  
                striped: true,
                sortName: 'customer_name',
                sortOrder: 'desc',
                idField:'nodeID',
                url:'<%=basePath%>customer/collection/InitailItem.action',
                loadMsg:'数据加载中...',
                frozenColumns:[[
                ]],
                columns:[[
                    {field:'deal_date',title:'购买日期',width:80},
                    {field:'customer_name',title:'姓名',width:90},
                    {field:'phone',title:'移动电话',width:90},
                    {field:'tel',title:'固话',width:50,align:'center'},
                    {field:'idcard_no',title:'身份证',width:120,align:'center'},
                    {field:'projectName',title:'项目名',width:50,align:'center'},
                    {field:'area',title:'组团',width:50,align:'center'},
                    {field:'building',title:'楼栋',width:50,align:'center'},
                    {field:'floor',title:'楼层',width:30,align:'center'},
                    {field:'room_no',title:'房号',width:30,align:'center'},
                    {field:'total',title:'总价',width:60,align:'center',formatter:function(val,rec){return commafy(val);}},
                    {field:'construction_area',title:'建筑面积',width:50,align:'center'},
                    {field:'areaSize',title:'套内面积',width:50,align:'center'},
                    {field:'paymethod',title:'付款方式',width:50,align:'center'},
                    {field:'adArea',title:'行政区域',width:80,align:'center'},
                    {field:'businesscircle',title:'商圈',width:50,align:'center'},
                    {field:'constructtype',title:'类型',width:50,align:'center'},
                    {field:'source',title:'来源',width:50,align:'center'},


                    {field:'createdate',title:'导入日期',width:100,align:'center'}

                ]],
                pagination:false, //包含分页  
                rownumbers:true,
                singleSelect:true
            });
            //displayMsg();
        });

        function save(){
            var id = document.getElementById("inId").value;
            $('#editForm').form({
                url:'./customer/collection/saveVipCust.action?id='+id,
                success:function(data){
                    $.messager.defaults = { ok: '确定'};
                    $.messager.alert('提示', '修改成功', 'info');
                }
            });

            $('#editForm').submit();
        }


        function commafy(num){
            if((num+"").trim()==""){
                return"";
            }
            if(isNaN(num)){
                return"";
            }
            num = num+"";
            if(/^.*\..*$/.test(num)){
                varpointIndex =num.lastIndexOf(".");
                varintPart = num.substring(0,pointIndex);
                varpointPart =num.substring(pointIndex+1,num.length);
                intPart = intPart +"";
                var re =/(-?\d+)(\d{3})/
                while(re.test(intPart)){
                    intPart =intPart.replace(re,"$1,$2")
                }
                num = intPart+"."+pointPart;
            }else{
                num = num +"";
                var re =/(-?\d+)(\d{3})/
                while(re.test(num)){
                    num =num.replace(re,"$1,$2")
                }
            }
            return num;
        }
    </script>
</head>

<body>
<div style="overflow:hidden;">
    <form id="editForm" action="" method="post">
        <table width="100%">
            <tr>
                <td>客户编号</td>
                <td><s:text name="vipCust.id"/></td>
                <td>客户姓名</td>
                <td><s:textfield name="vipCust.customerName" /></td>
            </tr>
            <tr>
                <td>身份证号</td>
                <td><s:textfield name="vipCust.idcardNo" /></td>
                <td>来源</td>
                <td><s:textfield name="vipCust.source" /></td>
            </tr>
            <tr>
                <td>固话</td>
                <td><s:textfield name="vipCust.tel" /></td>
                <td>移动电话</td>
                <td><s:textfield name="vipCust.phone" /></td>
            </tr>
            <tr>
                <td>联系地址</td>
                <td><s:textfield name="vipCust.contactAddr" /></td>
                <td>居住区域</td>
                <td><s:textfield name="vipCust.resideArea" /></td>
            </tr>
            <tr>
                <td>户籍</td>
                <td><s:textfield name="vipCust.natives" /></td>
                <td>工作区域</td>
                <td><s:textfield name="vipCust.workArea" /></td>
            </tr>
            <tr>
                <td></td>
                <td><s:textfield style="visibility:hidden" id="inId" name="vipCust.id" /></td>
                <td></td>
                <td></td>
            </tr>

            <tr>
                <td colspan="4" align="center">
                    <a href="javascript:void(0);" class="easyui-linkbutton" onclick="save()" iconCls="icon-redo">保存</a>
                </td>
            </tr>
        </table>
    </form>
</div>
<div class="easyui-layout" style="width:100%;height:270px;">
    <div region="center" style="overflow-x:hidden;padding: 1px">
        <table id="tbItem" ></table>
    </div>
</div>
</body>
</html>