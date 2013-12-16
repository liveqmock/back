<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
         isELIgnored="false"%>
<%@ page import="com.ihk.constanttype.ContUserId" %>
<%@ page import="com.ihk.utils.SessionUser" %>
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
    <title>角色权限</title>
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
            var selRoleId = $("#roleIds").val();
            var url = "./user/manager/searchRoleprivAjax.action?selRoleId=" + selRoleId;
            //使用.datagrid的方法设置easyui组件,那么该table的class不要设置为easyui-datagrid，否则会两次加载渲染
            $("#dg").datagrid({
                height:$(this).height(),
                url:"./user/manager/searchRoleprivAjax.action",
                queryParams:{"selRoleId":selRoleId}
            });
            //alert(url);
        }
        $().ready(function(){
            queryForm();
        });

        function addRole(){
            new MyAjaxIframeDialog({title:'新增角色', formId:'roleFormId', src:'./user/manager/addRoleFirst.action'});
        }

        function editRole(){
            var selRoleId = $("#roleIds").val();
            if(selRoleId=="0"){
                myAlert("该角色不能编辑，请选择其他角色");
            } else {
                new MyAjaxIframeDialog({title:'编辑角色', formId:'roleFormId', src:'./user/manager/editRole.action?roleid='+selRoleId});
            }
        }


        function editRolePriv(){
            var selRoleId = $("#roleIds").val();
            if(selRoleId=="0"){
                myAlert("该角色不能编辑，请选择其他角色");
            } else {
                new MyAjaxIframeDialog({title:'编辑角色权限', formId:'roleFormId', src:'./user/manager/editRolePriv.action?roleid='+selRoleId});
            }
        }
        
        function copyRole(){
        	var selRoleId = $("#roleIds").val();
            if(selRoleId=="0"){
                myAlert("该角色不能复制，请选择其他角色");
            } else {
            	new MyAjaxIframeDialog({title:'复制角色', formId:'roleFormId', src:'./user/manager/copyRoleForm.action?roleid='+selRoleId});
            }
        }

    </script>

</head>
<body>
<table id="dg"
       toolbar="#toolbar" pagination="false" striped="true" nowrap="true"
       rownumbers="true" fitColumns="true" singleSelect="true"
        >
    <thead>
    <tr>
        <th field="descRoleId" width="50">角色名称</th>
        <th field="descPrivId" width="50">权限</th>
        <th field="createdTime" width="50">创建日期</th>
    </tr>
    </thead>
</table>
<div id="toolbar" style="padding:5px;height:auto">
    角色列表
    <s:select list="roleList" listValue="roleName" headerKey="0" value="selRoleId" headerValue="全部" listKey="id" name="roleIds"></s:select>

    <input type="button" onclick="queryForm();" value=" 查询权限 "/>
    &nbsp;
    <%if(SessionUser.getUserId() == ContUserId.ADMIN){%>
    <input type="button" onclick="addRole();" value=" 新增角色 "/>
    <input type="button" onclick="copyRole();" value=" 复制角色"/>
    <input type="button" onclick="editRole();" value=" 编辑角色 "/>
    &nbsp;

    <input type="button" onclick="editRolePriv();" value=" 编辑权限 "/>

    <%}%>

</div>
</body>
</html>

