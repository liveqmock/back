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


    <title>查看公告</title>

</head>
<body>


<%--主体导航页头 --%>




<table width="100%" border="0">
    <tr>
        <td valign="top" align="left" width="100%">

                <table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" class="gbox" style="table-layout:fixed;word-wrap:break-word;">
                    <tr bgcolor="white">
                        <td align="right" height="28" width="70">
                            标题：
                        </td>
                        <td style="padding-left: 20px;" height="28">
                             <b>${showArticle.title }</b>
                        </td>
                    </tr>
                    <tr bgcolor="white">
                        <td align="right" height="28" width="70">
                            发布日期：
                        </td>
                        <td style="padding-left: 20px;" height="28">
                             ${showArticle.dayString }
                        </td>
                    </tr>
                    <tr bgcolor="white">
                        <td align="right" height="28">
                            摘要：
                        </td>
                        <td style="padding-left: 20px;" height="28">
                            ${showArticle.summary }
                        </td>
                    </tr>

                    <tr bgcolor="white">
                        <td align="right" style="padding-top: 10px;" height="330" valign="top">
                            内容：
                        </td>
                        <td style="padding: 10px 20px 20px 20px"  valign="top">
                            ${showArticle.content }
                        </td>
                    </tr>

                </table>

        </td>
	</tr><tr>
        <td align="left" valign="top" >
        	<table width="100%">
        	<tr><td width="50%">旧一条：
        			<span style="height:34px;word-wrap:break-word;">${preArticle.dayString }&nbsp; <a href="<%=basePath %>customer_guangzhou/article/show.action?id=${preArticle.id}" target="_self" style="color: #1199FF;cursor: pointer;" class="ablue">${preArticle.title }</a></span>
        		</td>
        		<td width="50%">新一条：        			
        			<span style="height:34px;word-wrap:break-word;">${nextArticle.dayString }&nbsp; <a href="<%=basePath %>customer_guangzhou/article/show.action?id=${nextArticle.id}" target="_self" style="color: #1199FF;cursor: pointer;" class="ablue">${nextArticle.title }</a></span>
        		</td></tr>
           	</table>
        </td>
    </tr>
</table>


</body>
</html>
