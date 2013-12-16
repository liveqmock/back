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
    <title>新建用户角色</title>
    <script type="text/javascript" language="javascript" src="<%=basePath%>ui/js/jquery-1.8.0.min.js"></script>
</head>

<body >
<form name="inputform" class="registerform" id="roleFormId" action="./user/manager/addRole.action" method="post">


    <table width="100%" border="0" align="left" cellpadding="0" cellspacing="1" class="gbox">

        <tr bgcolor="#FFFFFF">

            <td align="center" valign="middle">
                 角色名称：
            </td>
            <td align="left" valign="middle">
                <input type="text" id="roleName" size="40" name="roleName" />
            </td>

        </tr>
        <tr bgcolor="#FFFFFF">

            <td align="center" valign="middle">
                角色描述：
            </td>
            <td align="left" valign="middle">
                <input type="text" id="roleDesc" size="40" name="roleDesc" />
            </td>

        </tr>
        <tr bgcolor="#FFFFFF">

            <td align="center" valign="middle">
                开发标记：
            </td>
            <td align="left" valign="middle">
                <input type="text" id="devFlag" size="40" name="devFlag" value="GUANGZHOU"/>
            </td>

        </tr>
        <tr bgcolor="#FFFFFF">

            <td align="center" valign="middle">
                排序：（由小到大）
            </td>
            <td align="left" valign="middle">
                <input type="text" id="ordderIndex" size="40" name="ordderIndex" value="999"/>
            </td>

        </tr>
        <tr bgcolor="#FFFFFF">

            <td align="center" valign="middle">
                所属公司：
            </td>
            <td align="left" valign="middle">
                <s:select headerKey="" headerValue="全部" list="companyList" id="comId" listKey="id" listValue="companyName" ></s:select>

            </td>

        </tr>


    </table>
</form>

</body>
</html>

