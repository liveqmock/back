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
    <title>修改密码</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <s:include value="header.jsp"></s:include>
    <s:include value="header_left_js.jsp"></s:include>
    <script type="text/javascript" src="<%=basePath%>js/ui_fix.js"></script>
</head>
<style >
    * {margin:0;padding:0;}
</style>
<body>
<%--固定的上部 --%>
<table width="100%" border="0" align="left" cellspacing="0">
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
                                <div class="title02" ><a href="./guangzhou/userAccount/setpwd.action">修改密码</a></div>
                                <div class="title01" ><a href="./customer_guangzhou/band/indexBand.action">绑定内网账号</a></div>
                                <div class="title01" ><a href="./guangzhou/userAccount/showMyRole.action">我的角色</a></div>

                                <div class="right99"></div>
                                <div class="blueline"></div>
                                <div class="c"></div>
                                <div class="c"></div>

                                <%--主体table --%>

                                <form action="./guangzhou/userAccount/setpwdform.action" method="post">
                                    <table width="100%" border="0" align="left" cellspacing="0">
                                        <tr>
                                            <td align="right" width="300px">旧密码&nbsp;&nbsp;&nbsp;</td><td><input type="password" name="oldPwd" /> </td>
                                        </tr>
                                        <tr>
                                            <td align="right">新密码&nbsp;&nbsp;&nbsp;</td><td><input type="password" name="newPwd" /> </td>
                                        </tr>
                                        <tr>
                                            <td align="right">重复新密码&nbsp;&nbsp;&nbsp;</td><td><input type="password" name="vilPwd"/></td>
                                        </tr>
                                        <tr>
                                            <td></td><td><input type="submit" value="  提交  "/> </td>
                                        </tr>
                                        <tr>
                                            <td> </td><td><s:actionmessage cssStyle="color:red;"/></td>
                                        </tr>
                                    </table>
                                </form>



</body>
</html>



   
   



