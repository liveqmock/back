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
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <s:include value="../../customer/guangzhou/header.jsp"></s:include>
    <s:include value="../../customer/guangzhou/header_left_js.jsp"></s:include>

    <title>绑定内网账号</title>

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
                                <div class="title01" ><a href="./guangzhou/userAccount/setpwd.action">修改密码</a></div>
                                <div class="title02" ><a href="<%=path %>/customer_guangzhou/band/indexBand.action" target="_self">绑定内网账号</a></div>
                                <div class="title01" ><a href="./guangzhou/userAccount/showMyRole.action">我的角色</a></div>
                                <div class="right99"></div>
                                <div class="blueline"></div>
                                <div class="c"></div>
                                <div class="c"></div>

                                <form action="./customer_guangzhou/band/band.action" method="post" id="bandform">
                                    <table>
                                        <tr>
                                            <td colspan="4">
                                                <p>绑定内网账号 ( 集团内网 www.hope733.com ) 成功后,可以使用内网账号密码登陆系统</p>
                                                <hr/>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>内网账号</td>
                                            <td> <input type="text" name="innerName" id="account"/>
                                                <input type="hidden" name="oldInnerName" value="${userName}"/>
                                            </td>

                                            <td>内网密码</td>
                                            <td> <input type="password" name="innerPwd" id="pwd"/> </td>
                                            <td> <input type="submit" value="  绑定  "/> </td>
                                        </tr>

                                    </table>
                                    <div class="right99"></div>
                                    <div class="blueline"></div>
                                </form>
                                <s:actionmessage cssStyle="color:red;"/>

                                <table>
                                    <tr>
                                        <td>
                                            <s:if test="#request.userName != ''">已绑定内网账号:</s:if>
                                            <s:else>还未绑定内网账号</s:else>
                                        </td>
                                        <td>${userName} &nbsp;
                                            <s:if test="#request.userName != ''"><input type="button" value="  解除绑定  " onclick="window.location.href = './customer_guangzhou/band/removeBand.action'"/></s:if>
                                        </td>
                                    </tr>
                                </table>

</body>
</html>




