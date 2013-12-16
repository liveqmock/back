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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title>vip 客户导入</title>
<base href="<%=basePath%>"/>
<link rel="stylesheet" type="text/css" href="./css/easyui.css" />
<link rel="stylesheet" type="text/css" href="./css/icon.css" />
<link rel="stylesheet" type="text/css" href="./css/easydemo.css" />
<style type="text/css">
    .btn1_mouseover {
        BORDER-RIGHT: #2C59AA 1px solid; PADDING-RIGHT: 2px; BORDER-TOP: #2C59AA 1px solid; PADDING-LEFT: 2px; FONT-SIZE: 12px;
        FILTER: progid:DXImageTransform.Microsoft.Gradient(GradientType=0, StartColorStr=#ffffff, EndColorStr=#C3DAF5); BORDER-LEFT: #2C59AA 1px solid;
    CURSOR: hand; COLOR: black; PADDING-TOP: 2px; BORDER-BOTTOM: #2C59AA 1px solid
        }


</style>
<script type="text/javascript" src="./js/jquery-1.6.2.min.js"></script>
<script type="text/javascript" src="./js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="./js/easyui-lang-zh_CN.js"></script>
<script type="text/javascript">
$(function(){
    $('#test').datagrid({
        title:'核对信息',//表格标题
        //iconCls:'icon-save',//表格图标
        width: 'auto',
        height: 380,
        nowrap: true,//是否只显示一行，即文本过多是否省略部分。
        striped: true,
        sortName: 'memo',
        sortOrder: 'desc',
        idField:'nodeID',
        loadMsg:'数据加载中...',
        pageSize:'50',
        frozenColumns:[[
        ]],
        columns:[[

            {field:'customerNo',title:'客户编号',width:100,hidden:true},
            {field:'memo',title:'备注',width:100 ,sortable:true},
            {field:'source',title:'来源',width:50},
            {field:'customer_name',title:'客户姓名',width:180,sortable:true},
            {field:'deal_date',title:'日期',width:100,sortable:true},
            {field:'idcard_no',title:'身份证号',width:180,sortable:true},
            {field:'tel',title:'固话',width:100,sortable:true},
            {field:'phone',title:'移动电话',width:100,sortable:true},
            {field:'contactAddr',title:'联系地址',width:120},
            {field:'resideArea',title:'居住区域',width:100},
            {field:'adArea',title:'行政区域',width:100},
            {field:'wordArea',title:'工作区域',width:100},
            {field:'natives',title:'户籍',width:100,sortable:true},
            {field:'projectName',title:'项目名称',width:100},
            {field:'area',title:'组团',width:50},
            {field:'building',title:'楼栋',width:50},
            {field:'floor',title:'楼层',width:50},
            {field:'room_no',title:'房号',width:50},
            {field:'construction_area',title:'建筑面积',width:100},
            {field:'total',title:'购买总价',width:100},
            {field:'areaSize',title:'套内面积',width:100},
            {field:'attribute',title:'属性',width:100},
            {field:'businesscircle',title:'商圈',width:100},
            {field:'constructtype',title:'结构',width:50},
            {field:'operator',title:'操作',width:95,align:'center',
                formatter:function(value,row,index){
                    var e = '<a href="javascript:void(0);" onclick="editRow()" style="text-decoration: none;color: #800080;">编辑</a> ';
                    var d = '<a href="javascript:void(0);" onclick="deleteRow()" style="text-decoration: none;color: #800080;">删除</a>';
                    return e+d;
                }
            }
        ]],
        onContextMenu:onRowContextMenu,
        pagination:true, //包含分页
        rownumbers:true,
        singleSelect:true
    });
});

//修改
function editRow(){
    var selected = $('#test').datagrid('getSelected');

    if(selected){
        $('#openvipIframe')[0].src="./customer/collection/query.action?id="+selected.id;
        $('#edit').window('open');
    } else {
        alert("请选择要操作的数据");
    }
}

function deleteRow(){
    var selected = $('#test').datagrid('getSelected');

    if(selected){
        $.messager.confirm('删除',"客户：" + selected.customerName + ' 确认删除吗?',function(d){
            if(d){
                /* 将数据删除 */
                $.ajax({
                    type:"POST",
                    url:"./customer/collection/delete.action",
                    data:"id="+selected.id,
                    success:function(data){
                        $('#test').datagrid('reload');
                        $.messager.alert('提示',data,'info');
                    }
                });
            }
        });
    } else {
        alert("请选择要操作的数据");
    }

}

function allowImport(){
    var selected = $('#test').datagrid('getSelected');

    if(selected){
        $.messager.confirm('提示', '是否将可能要修改的记录全部导入?', function(r){
            if (r){
                $.ajax({
                    type:"POST",
                    url:"./customer/collection/allowsImport.action" ,
                    data: {id :selected.id},
                    success:function(data){
                        $('#test').datagrid('reload');
                        $.messager.alert('提示',data,'info');
                    }
                });
            }
        });
    }
}


//查询
function query(){
    $('#test').datagrid({
        url:'./customer/collection/search.action'
    });
}

//导出有误的数据
function exportErrorData(){
    $.messager.confirm('提示', '是否导出有误的数据?请整理后重新导入。', function(r){
        if (r){
            $('#exportfm').form({
                url:'./customer/collection/exportErrorData.action'
            });
            $('#exportfm').submit();
        }
    });
}

function allowsImport(){
    $.messager.confirm('提示', '是否将可能要修改的记录全部导入?', function(r){
        if (r){
            $.ajax({
                type:"POST",
                url:"./customer/collection/allowsImport.action" ,
                success:function(data){
                    $('#test').datagrid('reload');
                    $.messager.alert('提示',data,'info');
                }
            });
        }
    });
}

/*上传*/
function uploada(act){
    $.messager.confirm('提示', '是否确定上传？', function(r){
        if (r){
            if(act){
                $("#act").val(act);
            }else{
                $("#act").val("");
            }

            $('#upform').form({
                url:'./customer/collection/uploadFile.action',
                onSubmit:function(){
                    return $(this).form('validate');
                },
                success:function(data){
                    parent.hideLoading();
                    var options = {
                        title: "操作提示",
                        msg: data,
                        timeout:0,
                        height:300,
                        showType:'show'

                    };
                    $.messager.show(options);

                }
            });
            parent.showLoading();
            $('#upform').submit();
        }
    });
}

/*下载*/
function download(){
    $('dnform').form({
        url:'./customer/collection/download.action',
        onSubmit:function(){
            return $(this).form('validate');
        }
    });
    $('#dnform').submit();
}

$(".datagrid-cell").live('contextmenu',function(e){
    //显示快捷菜单
    $('#mm').menu('show', {
        left: e.pageX,
        top: e.pageY
    });

    return false;
});


//添加右击菜单内容
function onRowContextMenu(e, rowIndex, rowData){
    e.preventDefault();

    var selected=$("#test").datagrid('getRows'); //获取所有行集合对象
    var idValue = selected[rowIndex].id;
    $(this).datagrid('selectRecord', idValue);  //通过获取到的id的值做参数选中一行

    $('#mm').menu('show', {
        left:e.pageX,
        top:e.pageY
    });
}

function help(){
    $.messager.alert('导入规则','1)自动替换分隔符为逗号，适用字段(姓名、移动电话、身份证)<br>2)国外香港澳门台湾及公司不判断身份证');
}

</script>

</head>

<body>
<div class="easyui-layout" style="width:100%;height:540px;">
    <div region="north" style="overflow:hidden;height:100px;padding:5px;">
        <div region="north" style="overflow:hidden;height:35px;padding:5px;">
            <form id="dnform" action="./customer/collection/download.action" enctype="multipart/form-data" method="post">
                第一步：
                <input class="btn1_mouseover" type="submit" value="Excel模板下载" >
            </form>
            <font color="red">说明：1、请先下载模版，按模板要求填写数据；2、建议整理不规范的数据，如多个电话号码、身份证、姓名直接的分隔符 。</font>
        </div>
        <div region="center" style="overflow:hidden;height:55px;padding:5px;">
            <form id="upform" action="" enctype="multipart/form-data" method="post">
                <input type="hidden" id="act" name="act">
                第二步：
                <input type="file" name="upload" value="上传的文件"/>
                <a href="javascript:void(0);" class="easyui-linkbutton" onclick="uploada('test')" iconCls="icon-redo">模拟上传</a>
                <a href="javascript:void(0);" class="easyui-linkbutton" onclick="uploada()" iconCls="icon-redo">上传</a>
                <%--<a href="javascript:void(0);" class="easyui-linkbutton" onclick="uploada('del')" iconCls="icon-redo">清空并上传</a>--%>
                <a href="javascript:void(0);" class="easyui-linkbutton" onclick="help()" iconCls="icon-help">帮助</a>

                <br />
                <font color="red">
                    说明：1、上传，指追加导入数据，重复数据会被过滤(<a href="upload/imp_err.xls">重复数据下载</a>)；2、清空并上传，指先删除原有导入数据，再上传新的数据。
                </font>
            </form>
        </div>
    </div>
    <div region="center" style="overflow:hidden;">
        <div region="north" style="overflow:hidden;height:29px;padding:10px;">
            <div style="float:left;margin-left:0px;">第三步：</div>
            <form id="exportfm" action="" enctype="multipart/form-data" method="post">
                <a class="easyui-linkbutton" iconCls="icon-search" href="javascript:void(0);" onclick="query()">可能需要修改的信息</a>
                <a class="easyui-linkbutton"  href="javascript:void(0);" onclick="allowsImport()">完全导入</a>
                <a class="easyui-linkbutton" iconCls="icon-redo"   href="javascript:void(0);" onclick="exportErrorData()">导出</a>
            </form>
            <font color="red">
                说明：请修改以下有问题的数据，或导出后重新整理再导入。
            </font>
        </div>
        <div region="center" style="background:#fafafa;overflow:hidden;padding:5px;">
            <table id="test"></table>
        </div>
    </div>
</div>

<!-- 弹出修改页面 -->
<div id="edit" class="easyui-window" title="编辑vip客户信息" style="width: 570px;height:410px;"
     closed="true" maximizable="false" minimizable="false" collapsible="false">
    <iframe scrolling="no" id='openvipIframe' frameborder="0"  src="" style="width:100%;height:100%;"></iframe>
</div>

<div id="mm" class="easyui-menu" style="width:100px;">
    <div iconCls="icon-edit" onclick="editRow()">编辑</div>
    <div iconCls="icon-remove" onclick="deleteRow()">删除</div>
    <div iconCls="icon-save" onclick="allowImport()">导入</div>
    <%--<div class="menu-sep"></div>--%>

</div>
</body>
</html>