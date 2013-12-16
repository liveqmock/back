<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
         isELIgnored="false"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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
    <s:include value="../../header/header_easyui.jsp"></s:include>
    <title>项目管理</title>
    <style>
        * {
            margin: 0;
            padding: 0;
        }

        html,body {
            height: 100%;
            width: 100%;
        }
    </style>
    <script type="text/javascript">
        function queryForm(){
            var companyId = $("#comId").val();
            $("#dg").datagrid({
                height:$(this).height(),
                url:'./projecr/manager_json/indexSearch.action?comId='+companyId,
                onDblClickRow:function(index,date){
                    update_project();
                }
            });
        }
        $().ready(function(){
            queryForm();
        });

        function flush(){
            var companyId = $("#comId").val();
            $("#dg").datagrid({
                url:'./projecr/manager_json/indexSearch.action?comId='+companyId
            });
            //$('#dg').datagrid('reload');
        }

        function dialog_input_project(){
            $("#new_dialog").dialog({
                resizable: true,
                modal:true,
                maximizable: false,
                width:480,
                height:300,
                onClose:function(){
                    $('#new_dialog_ifram').attr("src", "./saleunit_new/guangzhou/loading.jsp"); //清空内容
                    $('#dg').datagrid('reload');
                },
                buttons:[ {
                    text:'提交',
                    iconCls:'icon-ok',
                    handler:function(){
                        window.document.getElementById("new_dialog_ifram").contentWindow.formsubmit();
                    }},
                    {text:'关闭',
                        iconCls:'icon-cancel',
                        handler:function(){
                            $('#new_dialog').dialog('close');
                        }}
                ]
            });
            $('#new_dialog').dialog('open');
            $('#new_dialog').dialog('setTitle', '新建');
            $('#new_dialog_ifram')[0].src='./projecr/manager/inputProjectDialog.action';
        }


        <%-- 修改项目信息 PID 项目ID--%>
        function update_project(){

            var row = $('#dg').datagrid('getSelected');
            if (row){
                $("#new_dialog").dialog({
                    resizable: true,
                    modal:true,
                    maximizable: false,
                    width:520,
                    height:350,
                    onClose:function(){
                        $('#new_dialog_ifram').attr("src", "./saleunit_new/guangzhou/loading.jsp"); //清空内容
                        $('#dg').datagrid('reload');
                    },
                    buttons:[ {
                        text:'提交',
                        iconCls:'icon-ok',
                        handler:function(){
                            window.document.getElementById("new_dialog_ifram").contentWindow.formsubmit();
                        }},
                        {text:'关闭',
                            iconCls:'icon-cancel',
                            handler:function(){
                                $('#new_dialog').dialog('close');
                            }}
                    ]
                });
                $('#new_dialog').dialog('open');
                $('#new_dialog').dialog('setTitle', '修改');
                $('#new_dialog_ifram')[0].src='./projecr/manager/updateProjectDialog.action?inputProject.id='+row.id;
            }
        }
    </script>

</head>
<body>



<table id="dg" style="width:auto;height:612px;"
       url="./projecr/manager_json/indexSearch.action"
       toolbar="#toolbar" pagination="true" striped="true" nowrap="true"
       rownumbers="true" fitColumns="true" singleSelect="true"
       pageSize='20'

        >
    <thead>
    <tr>
        <th field="name" width="50">项目</th>
        <th field="cname" width="50">公司</th>
        <th field="cdate" width="50">创建时间</th>
        <th field="cuser" width="50">创建人</th>
    </tr>
    </thead>
</table>
<div id="toolbar" style="padding:5px;height:auto">
    公司
    <s:select headerKey="" headerValue="全部" list="comList" id="comId" listKey="id" listValue="companyName" >
    </s:select>
    &nbsp;<input type="button" onclick="queryForm();" value=" 查询 "/>
    &nbsp;&nbsp;
    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="dialog_input_project()">新建</a>
    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="update_project()">修改</a>
</div>


<div id="new_dialog" class="easyui-dialog" closed="true" modal="true" title="标题" style="display:block;width:800px;height:400px; overflow-x:hidden">
    <iframe scrolling="auto" id='new_dialog_ifram' frameborder="0"  src="./saleunit_new/guangzhou/loading.jsp" style="width:100%;height:100%;"></iframe>
</div>
</body>
</html>

