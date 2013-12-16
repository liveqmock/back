<%@ page language="java" import="com.ihk.constanttype.ContUserId" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page import="com.ihk.utils.SessionUser" %>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <s:include value="../../header/header_easyui.jsp"></s:include>
    <title>权限管理</title>
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

            $("#dg").datagrid({
                height:$(this).height(),
                url:"./user/manager/searchPrivAjax.action",
                columns:[[
                    {field:'operator',title:'操作',width:50,align:'center',
                        formatter:function(value,row,index){
                            var e = '<a href="javascript:void(0);" onclick="editPriv('+row.id+')" style="text-decoration: none;color: #800080;">编辑</a> ';

                            return e;
                        }
                    },
                    {field:'id',title:'ID',width:30,align:'center'},
                    {field:'privName',title:'权限名称',width:150},
                    {field:'privCode',title:'权限代码',width:150,sortable:true},
                    {field:'devFlag',title:'开发标记',width:150,sortable:true},
                    {field:'orderIndex',title:'排序',width:40,align:'center',sortable:true},
                    {field:'remark',title:'备注',width:150,sortable:true}

                ]]
            });
        }

        $().ready(function(){
            queryForm();
        });


        function addPriv(){
            new MyAjaxIframeDialog({title:'新增权限', formId:'roleFormId', src:'./userAccount/manager/addPriv.jsp',closeFn:function(){$("#dg").datagrid("reload")}});
        }

        function editPriv(id){
            new MyAjaxIframeDialog({title:'编辑权限', formId:'roleFormId', src:'./user/manager/editPriv.action?privId='+id,closeFn:function(){$("#dg").datagrid("reload")}});
        }



    </script>

</head>
<body>
<table id="dg"
       toolbar="#toolbar" pagination="false" striped="true" nowrap="true"
       rownumbers="true" fitColumns="true" singleSelect="true"
        >

</table>
<div id="toolbar" style="padding:5px;height:auto">
    <%--权限列表--%>
    <%--<s:select list="roleList" listValue="roleName" headerKey="0" value="selRoleId" headerValue="全部" listKey="id" name="roleIds"></s:select>--%>

    <%--<input type="button" onclick="queryForm();" value=" 查询权限 "/>--%>
    &nbsp;
    <%if(SessionUser.getUserId() == ContUserId.ADMIN){%>

    <input type="button" onclick="addPriv();" value=" 新增权限 "/>

    <%}%>

</div>
</body>
</html>

