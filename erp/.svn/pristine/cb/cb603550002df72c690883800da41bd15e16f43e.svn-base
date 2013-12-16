<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
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
    <title>编辑权限</title>
    <style type="text/css">
        table {font-size: 12px;}
    </style>
    <script type="text/javascript" language="javascript" src="<%=basePath%>ui/js/jquery-1.8.0.min.js"></script>
</head>

<body >
<form name="inputform" class="registerform" id="roleFormId" action="./user/manager/updatePriv.action" method="post">
    <input type="hidden" id="privId" name="privId" value="${privId}"/>

    <table width="100%" border="0" align="left" cellpadding="0" cellspacing="1" class="gbox">

        <tr bgcolor="#FFFFFF">

            <td align="center" valign="middle">
                权限名称：
            </td>
            <td align="left" valign="middle">
                <input type="text" id="privName" size="40" name="privName" value="${privName}"/>
            </td>

        </tr>
        <tr bgcolor="#FFFFFF">

            <td align="center" valign="middle">
                权限代码：
            </td>
            <td align="left" valign="middle">
                <input type="text" id="privCode" size="40" readonly="true" name="privCode" value="${privCode}"/>
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
                <input type="text" id="ordderIndex" size="40" name="ordderIndex" value="${orderIndex}"/>
            </td>

        </tr>
        <tr bgcolor="#FFFFFF">

            <td align="center" valign="middle">
                备注：
            </td>
            <td align="left" valign="middle">
                <input type="text" id="remark" size="40" name="remark" value="${remark}"/>
            </td>

        </tr>


    </table>
</form>

</body>
</html>

