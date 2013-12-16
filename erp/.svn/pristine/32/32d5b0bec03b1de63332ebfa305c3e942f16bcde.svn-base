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
    <title>查询调查表标红</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <s:include value="header.jsp"></s:include>

    <script type="text/javascript" src="<%=basePath%>js/highcharts.js"></script>
    <script type="text/javascript" src="<%=basePath%>js/ui_fix.js"></script>

    <script type="text/javascript" language="javascript" src="../js/customer_guangzhou_project.js"></script>
    <script type="text/javascript">
        $().ready(function(){
            projectListForHiddenId("projectName", "hiddenId"); //项目的联想框,及用隐藏域保存其id
        });
    </script>

</head>

<body>

<%--主体table --%>
<div class="ui_tools">
    <form action="./customer_guangzhou/customer_red/listsearch.action" method="post">
        项目<input type="text" id="projectName" name ="projectName"  value="${projectName }"/>
        <input type="hidden" id="hiddenId" name="custRedCond.projectId" value="${custRedCond.projectId }"/>
        <input type="submit" value="  查询  "/>
    </form>
</div>
<div style="margin: 0 5px 5px 5px;">
    <table width="100%" border="0" align="left" cellpadding="0" cellspacing="1" class="gbox" style="white-space: nowrap">
        <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF"  class="gboxbg">
            <td>&nbsp;项目名</td>
            <td>&nbsp;录入人</td>
            <td>&nbsp;录入时间</td>
            <td>&nbsp;修改人</td>
            <td>&nbsp;修改时间</td>
        </tr>
        <div class="right99"></div>
        <div class="blueline"></div>
        <s:iterator value="custredList" id="c">
            <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF">
                <td style="padding-left: 5px"><a style="color: #1199FF;" class="ablue" href="<%=path %>/customer_guangzhou/customer_red/search.action?projectId=${projectId}">	${descProjectId }</a></td>
                <td>&nbsp;${descCreatedId }</td>
                <td>&nbsp;<s:date name='#c.createdTime' format='yyyy-MM-dd HH:mm:ss'/></td>
                <td>&nbsp;${descModId }</td>
                <td>&nbsp;<s:date name='#c.modTime' format='yyyy-MM-dd HH:mm:ss'/></td>
            </tr>
        </s:iterator>
    </table>
</div>

</body>
</html>



   
   



