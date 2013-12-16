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
    <title>编辑角色权限</title>
    <script type="text/javascript" language="javascript" src="<%=basePath%>ui/js/jquery-1.8.0.min.js"></script>
    <style type="text/css">
        table {font-size: 12px;}
    </style>

    <script type="text/javascript">
        $().ready(function(){
            <s:iterator value="roleprivlist" id="rplist">
            $("#privId${rplist.privId}").attr("checked",true);
            </s:iterator>

        });

    </script>
</head>

<body >
<form name="roleFormId" class="registerform" id="roleFormId" action="./user/manager/updateRolePriv.action" method="post">
    <input type="hidden" id="roleid" name="roleid" value="${roleid}"/>


    <table width="100%" border="0" align="left" cellpadding="0" cellspacing="1" class="gbox">
        <s:iterator value="privlist" id="plist">
            <tr bgcolor="#FFFFFF">
                <td valign="middle">
                        <input type=checkbox name="chkboxPrivId" id="privId${plist.id}" value="${plist.id}">
                        ${plist.privName}
                </td>
            </tr>
        </s:iterator>
    </table>
</form>

</body>
</html>

