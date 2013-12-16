<%@page import="com.ihk.permission.PermissionUtils"%>
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


    <title>用户登录情况</title>
    <style >
        /*.thisdiv td{padding-left:5px}*/
        tr{height: 26px;}
    </style>

    <script type="text/javascript" language="javascript" src="<%=basePath%>js/customer_guangzhou_project.js"></script>
    <script type="text/javascript">
        $().ready(function(){

            projectListForHiddenId("projectName", "hiddenId"); //项目的联想框,及用隐藏域保存其id
        });
        function checkRole(){
        	var projectIds =  '<%=PermissionUtils.findProjectIdByRoleId(14)%>';
        	var selectProjectId = $("#hiddenId").val();
        	if(projectIds.toString().indexOf(selectProjectId)!=-1&&selectProjectId.length!=0){
        		//${"#bandform"}.submit();
        		return true;
        	}else{
        		if($("#projectName").val().length!=0)
        			myAlert("你没有查看该项目的权限");
        		else
        			return true;
        	}
        	return false;
        }
    </script>
</head>
<body>

<%--主体 --%>
<form action="./property/oper/user_search.action" method="post" id="bandform">
    <table>
        <tr>
            <td>&nbsp;项目</td>
            <td>   <input id="projectName" type="text" maxlength="20" value="${operCond.projectName}" name="operCond.projectName" />
                <input type="hidden"  id="hiddenId" name="operCond.projectId" value="${operCond.projectId}"/></td>
            <td>&nbsp;姓名</td>
            <td>
                <input type="text"  value="${operCond.searchName}" name="operCond.searchName" style="height: 20px"/></td>

            <td>&nbsp;日期</td>
            <td><input type="text" maxlength="20" value="${operCond.date1}" name="operCond.date1" class="easyui-datebox" style="width: 90px"/> -
                <input type="text" maxlength="20" value="${operCond.date2}" name="operCond.date2" class="easyui-datebox" style="width: 90px"/>
            </td>
            <td>&nbsp;<input type="submit" value="  查询  " onclick="return checkRole();"/></td>
        </tr>
    </table>
</form>
<div class="ui_listview">

    <div  style="width: 90%;float: left;vertical-align: top;">
        <table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" class="gbox thisdiv" style="margin-top: 10px;">
            <tr bgcolor="#ffffff" class="gboxbg">
                <td align="center">用户账号</td>
                <td align="center">用户姓名</td>
                <td align="center">项目</td>
                <td align="center">登录成功</td>
                <td align="center">登录失败</td>
            </tr>
            <s:iterator value="tableList" id="li">
                <tr bgcolor="#ffffff">
                    <td align="center">
                        <a class='ablue' style="color:#1199FF" href="./property/oper/search.action?operCond.userName=${userName}&operCond.date1=${operCond.date1}&operCond.date2=${operCond.date2}">
                                ${userName}</a>
                    </td>
                    <td align="center">${realName}</td>
                    <td align="center">${projectName}</td>
                    <td align="center">${countSuc}</td>
                    <td align="center">${countErr}</td>
                </tr>

            </s:iterator>
            <s:actionmessage cssStyle="color:red"/>
        </table>

    </div>
</div>


</body>
</html>




