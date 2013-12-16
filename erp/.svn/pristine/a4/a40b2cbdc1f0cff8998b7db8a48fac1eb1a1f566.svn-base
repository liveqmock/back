<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>vip客户数据分析</title>
    <base href="<%=basePath%>"/>
    <style>
        .btn1_mouseover {
            BORDER-RIGHT: #2C59AA 1px solid; PADDING-RIGHT: 2px; BORDER-TOP: #2C59AA 1px solid; PADDING-LEFT: 2px; FONT-SIZE: 12px;
            FILTER: progid:DXImageTransform.Microsoft.Gradient(GradientType=0, StartColorStr=#ffffff, EndColorStr=#C3DAF5); BORDER-LEFT: #2C59AA 1px solid;
        CURSOR: hand; COLOR: black; PADDING-TOP: 2px; BORDER-BOTTOM: #2C59AA 1px solid
            }
    </style>
    <link rel="stylesheet" type="text/css" href="./css/easyui.css" />
    <link rel="stylesheet" type="text/css" href="./css/icon.css" />
    <link rel="stylesheet" type="text/css" href="./css/easydemo.css" />
    <script type="text/javascript" src="./js/jquery-1.6.2.min.js"></script>
    <script type="text/javascript" src="./js/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="./js/easyui-lang-zh_CN.js"></script>
    <script>
        /*统计*/
        $(function(){
            $('#tbstatis').datagrid({
                title: '统计结果',
                width: '100%',
                height: 180,
                loadMsg:'数据加载中,请稍后...',
                fitColumns: true,
                rowStyler:function(){
                    return 'background-color:#FFFFFF;';
                },
                columns:[[
                    {field:'itemid',title:'购买次数',width:200},
                    {field:'countid',title:'人数',width:100,align:"center",
                        formatter:function(value,row,index){
                            if(index<4){
                                return  '<a href="javascript:void(0);" onclick="findDetails(0,'+index+')" style="text-decoration: none;color: #800080;">'+value+'</a> ';
                            }
                            return value;

                        }},
                    {field:'liitem',title:'购买1个代理项目(人)',width:270,align:"center",
                        formatter:function(value,row,index){
                            if(index<4){
                                return '<a href="javascript:void(0);" onclick="findDetails(1,'+index+')" style="text-decoration: none;color: #800080;">'+value+'</a> ';
                            }
                            return value;
                        }},
                    {field:'uitem',title:'购买2个代理项目(人)',width:280,align:"center",
                        formatter:function(value,row,index){
                            if(index<4){
                                return '<a href="javascript:void(0);" onclick="findDetails(2,' + index + ')" style="text-decoration: none;color: #800080;">' + value + '</a> ';
                            }
                            return value;
                        }},
                    {field:'aitem',title:'近三年内购买(人)',width:260,align:"center",
                        formatter:function(value,row,index){
                            if(index<4){
                                return '<a href="javascript:void(0);" onclick="findDetails(3,' + index + ')" style="text-decoration: none;color: #800080;">' + value + '</a> ';
                            }
                            return value;
                        }}
                    ,
                    {field:'ts',title:'套数',width:100,align:"center",
                        formatter:function(value,row,index){
                            if(index<4){
                                //return '<a href="javascript:void(0);" onclick="findDetails(4,' + index + ')" style="text-decoration: none;color: #800080;">' + value + '</a> ';
                            }
                            return value;
                        }},
                    {field:'Tts_1',title:'购买1个代理项目(套)',width:270,align:"center",
                        formatter:function(value,row,index){
                            if(index<4){
                                //return '<a href="javascript:void(0);" onclick="findDetails(5,' + index + ')" style="text-decoration: none;color: #800080;">'+value+'</a> ';
                            }
                            return value;
                        }},
                    {field:'Tts_2',title:'购买2个代理项目(套)',width:280,align:"center",
                        formatter:function(value,row,index){
                            if(index<4){
                                //return '<a href="javascript:void(0);" onclick="findDetails(6,' + index + ')" style="text-decoration: none;color: #800080;">' + value + '</a> ';
                            }
                            return value;
                        }},
                    {field:'Tts_3',title:'近三年内购买(套)',width:260,align:"center",
                        formatter:function(value,row,index){
                            if(index<4){
                                //return '<a href="javascript:void(0);" onclick="findDetails(7,' + index + ')" style="text-decoration: none;color: #800080;">' + value + '</a> ';
                            }
                            return value;
                        }}
                ]]

            });
            });


            function findDetails(row,index){
                $("#vip_z").attr("disabled",true);
                if(row<5){
                    $("#vip_z").attr("disabled",false);
                }

                $('#tbdetails').datagrid({
                    url:'./customer/collection/analysisDetail.action',
                    queryParams:{'index':index, 'row':row }
                });
            }

            /*统计*/
            function query(){
                var date1 = $("#date1").datebox("getValue");
                var date2 = $("#date2").datebox("getValue");

                $('#tbstatis').datagrid({
                    url:'./customer/collection/statistics.action',
                    queryParams:{'date1':date1, 'date2':date2 }
                });
            }

            /*整理*/
            function analysis(){
                $(function(){
                    $('#search').form({
                        url:'./customer/collection/analysisData.action',
                        onSubmit:function(){
                            return $(this).form('validate');
                        },
                        success:function(data){
                            parent.hideLoading();
                            $.messager.defaults = { ok: '确定'};
                            $.messager.alert('提示', '数据整理成功', 'info');
                        },
                        error: function(){
                            alert("数据整理失败");//如果提交失败则提示
                        }
                    });
                    parent.showLoading();
                    $('#search').submit();
                });

            }

        /*详细*/
        $(function(){
            $('#tbdetails').datagrid({
                title: '详细信息',
                width: 'auto',
                height: 246,
                nowrap: true,//是否只显示一行，即文本过多是否省略部分。
                striped: true,
                sortName: 'customer_name',
                sortOrder: 'desc',
                idField:'nodeID',
                loadMsg:'数据加载中...',
                pageSize:'50',

                columns:[[
                    {field:'customerNo',title:'客户编号',width:50,hidden:true},
                    {field:'deal_date',title:'交易日期',width:80,sortable:true},
                    {field:'customer_name',title:'客户姓名',width:180,sortable:true},
                    {field:'idcard_no',title:'身份证号',width:180},
                    {field:'tel',title:'固话',width:100,sortable:true},
                    {field:'phone',title:'移动电话',width:100,sortable:true},
                    {field:'contact_addr',title:'联系地址',width:120,sortable:true},
                    {field:'resid_area',title:'居住区域',width:100,sortable:true},
                    {field:'word_area',title:'工作区域',width:100,sortable:true},
                    {field:'natives',title:'户籍',width:100,sortable:true},
                    {field:'projectName',title:'项目名称',width:100},
                    {field:'area',title:'组团',width:50,sortable:true},
                    {field:'building',title:'楼栋',width:50,sortable:true},
                    {field:'floor',title:'楼层',width:50,sortable:true},
                    {field:'room_no',title:'房号',width:50,sortable:true},
                    {field:'construction_area',title:'建筑面积',width:80},
                    {field:'areaSize',title:'套内面积',width:80}
                    /*,
                     {field:'oper',title:'操作',width:100}*/
                ]],
                pagination:true, //包含分页
                rownumbers:true,
                singleSelect:true
            });

        });

        /*详细*/
        function details(){
            $('#tbdetails').datagrid({
                url:'./customer/collection/analysisDetail.action'
            });
        }

        //导出vip客户资料
        function submitExport(){
            $(function(){
                $('#dnform').form({
                    url:'./customer/collection/exportData.action'
                });
                $('#dnform').submit();
            });
        }

        //一键转化为vip客户
        function submitVip(){
            $('#vipform').form({
                url:'./customer/collection/analysisVipCustomer.action',
                success:function(data){
                    parent.hideLoading();
                    $.messager.defaults = { ok: '确定'};
                    $.messager.alert('提示', data, 'info');
                }
            });
            parent.showLoading();
            $('#vipform').submit();
        }

    </script>

</head>
<body bgcolor="#ffffff" style="padding: 1px;">
<div class="easyui-layout" style="width:100%;height:528px;">
    <div region="north" style="width:100%;overflow:hidden;height:40px;padding:5px;border: 0">
        <form id="search" method="post" >
            第一步：
            <a href="javascript:void(0);" class="easyui-linkbutton" onclick="analysis()" >整理vip客户原始数据</a>
            <font color="red">说明：整理之后，同一单元多个购买客户将被拆分，并且生成相应的统计结果.</font>
        </form>
    </div>
    <div region="center" style="width:99%;height: auto;border: 0">
        <div region="north" style="overflow:hidden;height:35px;padding:1px 10px 1px 10px;">
            <div style="float:left;margin-left:-6px;">
                第二步：
            </div>

            <input class="easyui-datebox" type="text" id="date1" style="width:90px" />
            -
            <input class="easyui-datebox" type="text" id="date2" style="width:90px" />

            <a class="easyui-linkbutton" iconCls="icon-search" href="javascript:void(0);" onclick="query()">统计</a>
        </div>
        <div region="center" style="width:100%;">
            <table id="tbstatis"></table>
            <form id="dnform" style="margin:0px;display:inline;" method="post">
                &nbsp;第三步: <input class="btn1_mouseover" type="button" onclick="return submitExport()" value="导出详细客户资料" >
            </form>
            <form id="vipform" style="margin:0px;display:inline;" method="post">
                <input id="vip_z" class="btn1_mouseover" type="button" onclick="return submitVip()" value="一键转化为vip客户">
                <font color="red">说明：点击一键转化为vip客户，是将详细信息里面相同的客户合并为vip管理的客户信息.</font>
            </form>
            <table id="tbdetails"></table>
        </div>
    </div>
</div>
</body>
</html>