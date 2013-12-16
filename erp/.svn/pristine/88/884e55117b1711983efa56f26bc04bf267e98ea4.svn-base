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
    <title>项目修改</title>
    <s:include value="header.jsp"/>
    <style type="text/css">
        tr{height: 26px;}
    </style>
</head>
<body >

<%--主体 --%>
<div class="ui_tools"></div>
<div class="ui_listview">
    <div class="blueline"></div>
    <form class="registerform" id="registerform" action="./guangzhou/project/updateform.action" method="post">
        <table width="750" border="0" align="left" cellpadding="0" cellspacing="1" class="gbox">

            <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF">

            <td width="100" align="center" id="t15" nowrap="nowrap">
                项目名称
            </td>
            <td width="148" nowrap="nowrap" id="t16">
                &nbsp;
                ${selectPro.projectName }
            </td>
            <td width="100" align="center" id="t15" nowrap="nowrap">
                项目ID
            </td>
            <td width="148" nowrap="nowrap" id="t16">
                &nbsp;
                ${id }

            </td>
            </tr>

            <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF">


            <td width="100" align="center" id="t15" nowrap="nowrap">
                所属公司
            </td>
            <td width="148" nowrap="nowrap" id="t16">
                &nbsp;
                ${selectPro.descCompanyId}

            </td>
            <td width="100" align="center" id="t15" nowrap="nowrap">
                项目状态
            </td>

            <td width="148" nowrap="nowrap" id="t16">
                &nbsp;&nbsp;
                <input type="radio" name="updatePro.projectState"  value="1"
                       <s:if test="#request.selectPro.projectState == 1">checked="checked" </s:if>
                        >活动</input>

                <input type="radio" name="updatePro.projectState"  value="2"
                       <s:if test="#request.selectPro.projectState == 2">checked="checked" </s:if>
                        >废止</input>

            </td>
            </tr>


            <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" align="center">
            <td colspan="4">
                <input type="hidden" name="id" value="${id }" />
                <ul style="float:none;height: 0px;padding: 0;margin: 0"></ul>

                <input type="submit" value="  保存  " id="sub" />
                <input type="button" value="  返回  " onClick="javascript:window.location.href = '<%=path %>/guangzhou/project/search.action'" />
                <s:actionmessage cssStyle="color:red;" tabindex="p"/>
            </td>

            </tr>

            <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF"  align="center">
                <td colspan="4">
                    <font color="red">	最后修改人:${selectPro.modId}   &nbsp;&nbsp;&nbsp; 最后修改时间:<s:date name='#request.selectPro.modTime' format='yyyy-MM-dd HH:mm:ss'/></font>
                </td>
            </tr>
            <tr class="gboxbg" align="center">
                <td colspan="2">创建人：
                    ${selectPro.descCreatedId}</td>
                <td colspan="2">创建时间：
                    <s:date name='#request.selectPro.createdTime' format='yyyy-MM-dd HH:mm:ss'/></td>
            </tr>
            <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF"  align="center">
                <td colspan="2">修改人</td>

                <td colspan="2">修改时间</td>

            </tr>
            <s:iterator value="statelist" id="c">
                <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF"  align="center">

                    <td colspan="2">${c.descModId }</td>

                    <td colspan="2">
                        <s:date name='#c.modTime' format='yyyy-MM-dd HH:mm:ss'/>
                    </td>
                </tr>

            </s:iterator>

        </table>

    </form>
</div>

</body>
</html>

