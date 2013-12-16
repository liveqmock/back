<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt" %>

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
    <title>项目管理</title>

    <s:include value="header.jsp"/>

    <script type="text/javascript" src="<%=basePath%>/js/userAccount-hengda.js" ></script>

</head>

<body>

<%--主体导航页头 --%>
<div class="ui_tools">
    <!-- 搜索表单 top -->
    <form action="./guangzhou/project/searchform.action" method="post">
        状态
        <select name="proCond.projectState" >
            <option value="" >全部</option>
            <option value="1"
                    <s:if test="#request.proCond.projectState == 1">
                        selected="selected"
                    </s:if>
                    >活动</option>

            <option value="2"
                    <s:if test="#request.proCond.projectState == 2">
                        selected="selected"
                    </s:if>
                    >废止</option>
        </select >
        &nbsp;
        <input type="submit" name="button3" id="button3" value="  搜索  "  align="left"/>
        <s:actionmessage cssStyle="color:red"/>
    </form>
    <!-- 搜索表单 end -->
</div>

<div class="ui_listview">

    <table width="100%" border="0" align="left" cellspacing="0">

        <tr>
            <td height="10" colspan="6">
                <div class="blueline"></div>
            </td>
        </tr>
        <tr>
            <td>

                <!--  列表 top -->
                <div class="gbox1">
                    <table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" class="gbox"  >
                        <tr class="gboxbg">
                            <td width="197" align="left" >&nbsp;&nbsp;&nbsp;项目名称</td>
                            <td width="188">&nbsp;&nbsp;&nbsp;所属公司</td>
                            <td width="188">&nbsp;&nbsp;&nbsp;项目状态</td>
                            <td width="188">&nbsp;&nbsp;&nbsp;创建时间</td>

                        </tr>
                        <s:iterator value="prolist" id="pro">
                            <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" style="height:26px;">

                                <td align="left" valign="middle" style="padding-left: 20px">
                                    <a class="ablue" href="./guangzhou/project/update.action?id=${id}" target="_self" style="color: #1199FF;">
                                        <s:property  value="projectName" /></a>
                                </td>
                                <td align="left" valign="middle">&nbsp;&nbsp;&nbsp;<s:property  value="descCompanyId" /></td>

                                <td align="left" valign="middle"
                                    <s:if test="#pro.projectState == 1">style="color:green"</s:if>
                                    <s:else>style="color:red"</s:else>
                                        >
                                    &nbsp;&nbsp;&nbsp;<s:property  value="descProjectState" />	</td>

                                <td align="left" valign="middle" >&nbsp;&nbsp;&nbsp;<s:property value="createdTime" />	</td>


                            </tr>

                        </s:iterator>
                    </table>
                </div>

                <!-- 列表 end -->
            </td>
        </tr>
        <tr>
            <td colspan="6">
                <div class="manu">
                    <s:property value="showPage" escape="false"/>
                </div>
            </td>
        </tr>
    </table>
</div>
</body>
</html>
