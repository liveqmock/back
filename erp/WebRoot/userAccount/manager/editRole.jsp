<%@ page language="java" pageEncoding="UTF-8" isELIgnored="false"%>
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
    <title>编辑用户角色</title>
    <script type="text/javascript" language="javascript" src="<%=basePath%>ui/js/jquery-1.8.0.min.js"></script>
    <style type="text/css">
        table {font-size: 12px;}
    </style>
</head>

<body >
<form name="roleFormId" class="registerform" id="roleFormId" action="./user/manager/updateRole.action" method="post">
    <input type="hidden" id="roleid" size="40" name="roleid" value="${roleid}"/>

    <table width="100%" border="0" align="left" cellpadding="0" cellspacing="1" class="gbox">

        <tr bgcolor="#FFFFFF">

            <td align="center" valign="middle">
                角色名称：
            </td>
            <td align="left" valign="middle">
                <input type="text" id="roleName" size="40" name="roleName"  value="${roleName}"/>
            </td>

        </tr>
        <tr bgcolor="#FFFFFF">

            <td align="center" valign="middle">
                角色描述：
            </td>
            <td align="left" valign="middle">
                <input type="text" id="roleDesc" size="40" name="roleDesc"  value="${roleDesc}"/>
            </td>

        </tr>
        <tr bgcolor="#FFFFFF">

            <td align="center" valign="middle">
                开发标记：
            </td>
            <td align="left" valign="middle">
                <input type="text" id="devFlag" size="40" name="devFlag" value="${devFlag}"/>
            </td>

        </tr>
        <tr bgcolor="#FFFFFF">

            <td align="center" valign="middle">
                排序：（由小到大）
            </td>
            <td align="left" valign="middle">
                <input type="text" id="orderIndex" size="40" name="orderIndex" value="${orderIndex}"/>
            </td>

        </tr>
        <tr bgcolor="#FFFFFF">

            <td align="center" valign="middle">
                是否删除：
            </td>
            <td align="left" valign="middle">
                <s:select list="#{'1':'是','0':'否'}"  label="abc" listKey="key" listValue="value"  headerKey="0" headerValue="否" name="%{deleted}"/>
            </td>

        </tr>

        <tr bgcolor="#FFFFFF">

            <td align="center" valign="middle">
                创建时间：
            </td>
            <td align="left" valign="middle">
                 <input type="text" id="createdTime" size="40" name="createdTime" readonly="true" value="${createdTime}"/>

            </td>

        </tr>

        <tr bgcolor="#FFFFFF">

            <td align="center" valign="middle">
                所属公司：
            </td>
            <td align="left" valign="middle">
                <s:select headerKey="" headerValue="全部" list="companyList" id="companyId" name="companyId" listKey="id" listValue="companyName" value="%{companyId}"></s:select>

            </td>

        </tr>

    </table>
</form>

</body>
</html>

