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


    <title>详细登录情况</title>
    <style >
        .thisdiv td{padding-left:15px}
        tr{height: 26px;}
    </style>
    <script type="text/javascript" language="javascript" src="<%=basePath%>js/customer_guangzhou_project.js"></script>

    <script type="text/javascript">
        $().ready(function(){

            projectListForHiddenId("projectName", "hiddenId"); //项目的联想框,及用隐藏域保存其id
        });
    </script>
</head>
<body>


<%--主体 --%>
<div class="ui_listview">
    <form action="./property/oper/search.action" method="post" id="bandform">
			<table>
			<tr>
				<td>&nbsp;项目</td><td> <input type="text" maxlength="20" value="${projectName}" name="projectName" id="projectName"/></td>	
				<td>&nbsp;姓名</td><td><input style="height: 20px" type="text" maxlength="20" value="${operCond.searchName}" name="operCond.searchName"/></td>	
				<td>&nbsp;日期</td><td><input type="text" maxlength="20" value="${operCond.date1}" name="operCond.date1" class="easyui-datebox" style="width: 90px"/> -
            <input type="text" maxlength="20" value="${operCond.date2}" name="operCond.date2" class="easyui-datebox" style="width: 90px"/>
            <input type="hidden" maxlength="20" value="${operCond.projectId}" name="operCond.projectId" id="hiddenId"/></td>
            	<td>&nbsp;<input type="submit" value="  查询  "/></td>			
			</tr>
			</table>
    </form>

    <div  style="width: 100%;float: left;vertical-align: top;">
        <table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" class="gbox thisdiv" style="margin-top: 10px;">
            <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" class="gboxbg">
                <td width="75px"><span>账号</span></td>
                <td width="75px"><span>姓名</span></td>
                <td width="100px"><span>项目</span></td>
                <td width="120px"><span>登录时间</span></td>
                <td><span>备注</span></td>

            </tr>
            <s:iterator value="operList" id="li">
                <tr bgcolor="#FFFFFF">
                    <td>${li.userName}</td>
                    <td>${li.realName}</td>
                    <td>${li.descProjectId}</td>
                    <td>

                        <s:date name="#li.logTime" format="yyyy-MM-dd:hh:ss"/>
                    </td>
                    <td>${li.logDesc}</td>

                </tr>
            </s:iterator>
            <tr>
                <td colspan="6" bgcolor="#feffff"><div class="manu">
                    <s:property value="showPage" escape="false"/>
                </div>  </td>
            </tr>
            <s:actionmessage cssStyle="color:red;"/>
        </table>

    </div>
</div>


</body>
</html>




