<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>我的角色</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <s:include value="header.jsp"></s:include>
    <s:include value="header_left_js.jsp"></s:include>
</head>
<body>
<%--固定的上部 --%>
<table width="100%" border="0" align="left" cellspacing="0">
    <thead>
    <tr>
        <td colspan="2" style="border-collapse: collapse; border: 0px; margin: 0px; padding: 0px;">

        </td>
    </tr>
    </thead>
    <tfoot>
    <tr>
        <td colspan="2">
        </td>
    </tr>
    </tfoot>
    <tbody>
    <tr style="height: 100%">
        <td valign="top">

        </td>
        <td width="100%" valign="top" >
            <DIV style="WIDTH: 98%; HEIGHT: 100%; BACKGROUND-COLOR: #A4C3D7;padding: 1px">
                <table width="100%" class="mainbg20111112" style="height: 100%">
                    <tr>


                        <td width="100%" valign="top" height="100%" style="overflow: hidden;">
                            <div class="titlel"></div>
                            <div class="titlebg" style="height: auto; overflow: hidden">
                                <%--主体导航页头 --%>
                                <div class="title01">
                                    <a href="./guangzhou/userAccount/setpwd.action">修改密码</a>
                                </div>
                                <div class="title01">
                                    <a href="./customer_guangzhou/band/indexBand.action">绑定内网账号</a>
                                </div>
                                <div class="title02">
                                    <a href="./customer_guangzhou/band/indexBand.action">我的角色</a>
                                </div>
                                <div class="right99"></div>
                                <div class="blueline"></div>
                                <div class="c"></div>
                                <div class="c"></div>
                                <%--主体table --%>
                                <table width="50%" border="0" align="left" cellpadding="0" cellspacing="1" class="gbox" style="white-space: nowrap">
                                    <tr bgcolor="#FFFFFF"   class="gboxbg">
                                    <td>
                                        &nbsp;&nbsp; 角色
                                    </td>
                                    <td>
                                        &nbsp;&nbsp; 所属项目
                                    </td>
                                    </tr>
                                    <s:iterator value="myRoleList" id="myrole">
                                        <tr  bgcolor="#FFFFFF" >
                                        <td>
                                            &nbsp;&nbsp; ${descRoleName }
                                        </td>
                                        <td>
                                            &nbsp;&nbsp; ${descProjectId }
                                        </td>
                                        </tr>
                                    </s:iterator>
                                </table>

</body>
</html>








