<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">
    <link href="ui/css/common.css"  rel="stylesheet" type="text/css" charset="utf-8"/>
    <link rel="stylesheet" type="text/css" href="./css/easyui.css" />
    <link rel="stylesheet" type="text/css" href="./css/icon.css" />
    <link rel="stylesheet" type="text/css" href="./css/easydemo.css" />
    <script type="text/javascript" src="./js/jquery-1.6.2.min.js"></script>
    <script type="text/javascript" src="./js/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="./js/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript" src="./js/easyui.utils.js"></script>
    <script type="text/javascript">

        $(function(){
            $('#tbCustomer').datagrid({
                width: 'auto',
                height: 440,
                nowrap: true,//是否只显示一行，即文本过多是否省略部分。  
                striped: true,
                sortName: 'parentID',
                sortOrder: 'desc',
                idField:'nodeID',
                loadMsg:'数据加载中...',
                url: "${custs}",
                pageList : [ 20, 50 ,100 ],
                sortName: 'customer_name',
                sortOrder: 'desc',
                frozenColumns:[[
                ]],
                columns:[[
                    {field:'operator',title:'操作',width:65,align:'center',
                        formatter:function(value,row,index){
                            var e = '<a href="javascript:void(0);" onclick="editInput('+row.id+','+row.customerNo+')" style="text-decoration: none;color: #800080;">编辑</a> ';
                            var d = '<a href="javascript:void(0);" onclick="customerFollow('+row.id+')"  style="text-decoration: none;color: #800080;">跟进</a>';
                            return e+d;
                        }
                    },
                    {field:'customerNo',title:'客户编号',width:50,hidden:true},
                    {field:'source',title:'来源',width:50},
                    {field:'customer_name',title:'客户姓名',width:150,sortable:true},
                    {field:'follow_date',title:'跟进日期',width:80,sortable:true},
                    {field:'create_time',title:'创建日期',width:80,sortable:true},
                    {field:'idcard_no',title:'身份证号',width:180,sortable:true},
                    {field:'tel',title:'固话',width:100},
                    {field:'phone',title:'移动电话',width:100},
                    {field:'contactAddr',title:'联系地址',width:120},
                    {field:'resideArea',title:'居住区域',width:100},
                    {field:'adArea',title:'行政区域',width:100},
                    {field:'wordArea',title:'工作区域',width:100},
                    {field:'natives',title:'户籍',width:100}
                ]],
                pagination:true, //包含分页  
                rownumbers:true,
                singleSelect:true
            });
            displayMsg();
        });

        function displayMsg() {
            $('#tbCustomer').datagrid('getPager').pagination({
                displayMsg : '当前显示从{from}条到{to}条共{total}条记录',
                beforePageText:'当前页' ,
                afterPageText: '/{pages}'
            });
        }

        /*跟进*/
        function customerFollow(id){
            $('#openfollowIframe')[0].src="./customer/collection/followVipCust.action?id="+id;
            $('#follow').window('open');
        }

        /*编辑*/
        function editInput(id,customerNo){
            //$('#openvipIframe')[0].src="./customer/collection/editVipCust.action?id="+id+"&customerNo="+customerNo;
            //$('#edit').window('open');
            new MyIframeDialog({title:'编辑vip客户信息', width:800,height:550,formId:'edit', src:'./customer/collection/editVipCust.action?id='+id+'&customerNo='+customerNo});
        }

        /*查询*/
        function query(){

            $('#tbCustomer').datagrid({
                url:'./customer/collection/queryVipCust.action',
                queryParams:{customerName:$.trim($("#searchName").val()),
                    phone:$.trim($("#searchPhone").val()),
                    workarea:$.trim($("#workarea").val()),
                    contactaddr:$("#contactaddr").val(),
                    source:$("#source").val(),
                    adArea:$("#adArea").val(),
                    notFollowDay:$("#notFollowDay").val(),
                    paymethod:$("#paymethod").val(),
                    natives:$("#natives").val(),
                    businesscircle:$("#businesscircle").val(),
                    dt1:$("#date1").datebox("getValue"),
                    dt2:$("#date2").datebox("getValue"),
                    fd1:$("#follow1").datebox("getValue"),
                    fd2:$("#follow2").datebox("getValue")
                }
            });
        }

    </script>
    <style type="text/css">
        .fst{
            font-size:12px;
            padding-right: 3px;
        }
        #searchSubmit{
            BORDER-RIGHT: #2C59AA 1px solid; PADDING-RIGHT: 2px; BORDER-TOP: #2C59AA 1px solid; PADDING-LEFT: 2px; FONT-SIZE: 12px;
            FILTER: progid:DXImageTransform.Microsoft.Gradient(GradientType=0, StartColorStr=#ffffff, EndColorStr=#C3DAF5); BORDER-LEFT: #2C59AA 1px solid;
        CURSOR: hand; COLOR: black; PADDING-TOP: 2px; BORDER-BOTTOM: #2C59AA 1px solid
            }
    </style>
</head>

<body style="width: 100%;margin: 1px;padding: 0;background: #ffffff;overflow:hidden;">

<form class="registerform" id="searchForm" action="" method="post" >
    <table width="100%" border="0" align="center" cellpadding="0" cellspacing="1"  style="margin:0;white-space:nowrap">
        <tr>
            <td align="right" class="fst" valign="middle" width="66" height="25">
                客户姓名
            </td>

            <td align="left" valign="middle">
                <input id="searchName" name="searchCond.customerName" />
            </td>

            <td align="right" class="fst" valign="middle" width="66">
                移动电话
            </td>

            <td align="left" valign="middle">
                <input id="searchPhone" name="searchCond" />
            </td>

            <td align="right" class="fst" valign="middle">
                工作区域
            </td>

            <td align="left" valign="middle">
                <input type="text" id="workarea" name="searchCond.workArea" />
            </td>
        </tr>


        </tr>

        <tr>
            <td align="right" class="fst" valign="middle">
                联系地址
            </td>

            <td align="left" valign="middle" style="white-space:nowrap">
                <input type="text" id="contactaddr"  name="searchCond.contactAddr" />
            </td>

            <td align="right" class="fst" valign="middle" height="25">
                客户来源
            </td>

            <td  align="left" valign="middle">
                <input type="text" id="source" name="searchCond.source" />
            </td>

            <td align="right" class="fst" valign="middle">
                行政区域
            </td>

            <td align="left" valign="middle">
                <input type="text" id="adArea" name="searchCond.adArea" />
            </td>


        </tr>

        <tr>
            <td align="right" class="fst" valign="middle" height="25">
                跟进日期
            </td>
            <td  class="fst" align="left" valign="middle">
                <input class="easyui-datebox" type="text" id="follow1" style="width:90px" />
                -
                <input class="easyui-datebox" type="text" id="follow2" style="width:90px" />
            </td>
            <td align="right" class="fst" valign="middle">
                未跟进天数
            </td>
            <td align="left" valign="middle">
                <input type="text" id="notFollowDay" name="searchCond.notFollowDay"/>
            </td>

            <td align="right" class="fst" valign="middle">
                付款方式
            </td>

            <td align="left" valign="middle">
                <input type="text" id="paymethod" name="searchCond.paymethod" />
            </td>

        </tr>
        <tr>
            <td align="right" class="fst" valign="middle" height="25">
                创建日期
            </td>
            <td class="fst" align="left" valign="middle" style="white-space:nowrap">
                <input class="easyui-datebox" type="text" id="date1" style="width:90px" />
                -
                <input class="easyui-datebox" type="text" id="date2" style="width:90px" />
            </td>

            <td align="right" class="fst" valign="middle">
                户籍
            </td>

            <td align="left" valign="middle">
                <input type="text" id="natives" name="searchCond.natives" />
            </td>
            <td align="right" class="fst" valign="middle">
                商圈
            </td>
            <td align="left" valign="middle">
                <input type="text" id="businesscircle" name="searchCond.businesscircle" />
                <input type="button"  value="搜索 " onClick="query()" id="searchSubmit"/>
            </td>
        </tr>
    </table>
</form>
<!-- 详细信息列表 -->
<div class="easyui-layout" style="width:100%;height:450px;">
    <div region="center">
        <table id="tbCustomer"  style="width:99%;"></table>
    </div>
</div>

<div id="edit" class="easyui-window" title="编辑vip客户信息" style="width: 800px;height:570px;"
     closed="true" maximizable="false" minimizable="false" collapsible="false">
    <iframe scrolling="no" id='openvipIframe' frameborder="0"  src="" style="width:100%;height:100%;"></iframe>
</div>
<div id="follow" class="easyui-window" title="vip客户跟进" style="width: 440px;height:360px;"
     closed="true" maximizable="false" minimizable="false" collapsible="false">
    <iframe scrolling="no" id='openfollowIframe' frameborder="0"  src="" style="width:100%;height:100%;"></iframe>
</div>
</body>
</html>
