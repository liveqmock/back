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
    <s:include value="../../header/header_easyui.jsp"></s:include>
    <script language="javascript" type="text/javascript" src="./js/project.list.utils.js?v=1.2"></script>

    <script type="text/javascript">
        $().ready(function(){
            bindProjectDialogForRYSQ("projectName", "hiddenId"); //公司项目的多选
        });

        function viewRolepriv(){
            new MyAjaxIframeDialogX3({title:'查看角色权限',
                width:650,
                height:700,
                src:'./user/manager/searchRolepriv.action',
                buttons:false
            });
        }

    </script>
</head>

<body >
<form name="inputform" class="registerform" id="inputform" action="./user/manager/submitUserRole.action" method="post">
    <div class="gbox1" style="font-size:12px">
        <table width="100%" border="0" align="left" cellpadding="0" cellspacing="1" class="gbox">
            <tr class="gboxbg">
                <td align="center" width="25%">
                    公司
                </td>
                <td align="center" width="25%">
                    项目
                </td>
                <td align="center" width="25%">
                    角色
                </td>

            </tr>
            <div class="right99"></div>
            <div class="blueline"></div>
            <tr bgcolor="#FFFFFF">
                <td align="left" valign="middle">
                    <s:checkboxlist list="companyList" listValue="companyName" listKey="id" name="companyIds"  theme="vertical-checkbox"></s:checkboxlist>
                </td>
                <td align="center" valign="top">
                    <input type="text" id="projectName" size="40" name="projectName" />
                    <input type="hidden" id="hiddenId" name="projectIds" />
                    <input type="hidden" id="userId" name="userId" value="${userId}" />
                </td>
                <td align="left" valign="top">
                    <s:checkboxlist list="roleList" listValue="roleName" listKey="id" name="roleIds"  theme="vertical-checkbox"></s:checkboxlist>
                </td>
            </tr>
            <tr bgcolor="#FFFFFF">
                <td colspan="3"><b>操作说明：</b><br/>
                    本界面是能够做到多对多的保存；勾选可以是一个或多个；<br/>
                    操作方式1:如果勾选公司，勾选角色；结果则对用户赋权为：公司与角色的乘积结果；<br/>
                    操作方式2:如果勾选项目，勾选角色；结果则对用户赋权为：项目与角色的乘积结果；<br/>
                    不能同时勾选公司与项目<br/>

                    <a onclick="viewRolepriv()" style="color: #1199FF;cursor: pointer;" class="ablue">查看角色权限</a>
                    <br/>
                    <br/>

                </td>
            </tr>

        </table>
    </div>
</form>

</body>
</html>

