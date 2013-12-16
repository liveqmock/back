<%@ page import="com.ihk.permission.PermissionUtils" %>
<%@ page import="com.ihk.constanttype.EnumPrivCode" %>
<%@ page import="com.ihk.constanttype.EnumDevFlag" %>
<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html>
<head>
    <title>修改楼盘项目</title>
    <s:include value="../../header/header_easyui.jsp"></s:include>
    <script type="text/javascript" language="javascript" src="<%=basePath%>js/easyui.utils.js"></script>
    <script type="text/javascript" language="javascript" src="<%=basePath%>js/saleunit_new_common_min.js"></script>
    <style type="text/css">
        *{margin:0;padding:0;}
        input{width: 75%}
    </style>
    <script>
        $().ready(function(){
            closeIframeDialog("new_dialog", "${closeMark}", "", "${suggestion}");
        })

        function formsubmit (){
            if($("#isdel").is(":checked")){
                $.messager.confirm('对话框','是否确认删除楼盘? 请谨慎操作.',function(r){
                    if(r){
                        document.getElementById("pay_unit_form").submit();
                    }
                })
            }else{
                document.getElementById("pay_unit_form").submit();
            }
        }
    </script>
</head>
<body>
<form action="./saleunit_new_init/appoint/guangzhou/updateProjectForm.action" method="post" id="pay_unit_form">
    <table width="100%" border="0" align="left" cellpadding="0" cellspacing="1"  style="font-size:12px; line-height:26px;background-color: #A9D9FF">
        <tr bgcolor="#FFFFFF" style="empty-cells:show" >
            <td align="right"><span style="color:red"> * </span>楼盘名称&nbsp;</td>
            <td >
                <input name="upProject.propertyName" id="new_pro_name" value="${upProject.propertyName }"/>
                <input type="hidden"  name="upProject.id" value="${upProject.id }"/>
            </td>
        </tr>
        <tr bgcolor="#FFFFFF" style="empty-cells:show" >
            <td   align="right">预售证号&nbsp;</td>
            <td >
                <input name="upProject.saleCard"  value="${upProject.saleCard }" id="new_card"/>
            </td>
        </tr>
        <tr bgcolor="#FFFFFF" style="empty-cells:show" >
            <td   align="right">楼盘地址&nbsp;</td>
            <td >
                <input name="upProject.propertyAddress"  value="${upProject.propertyAddress }" id="new_address"/>
            </td>
        </tr>
        <tr bgcolor="#FFFFFF" style="empty-cells:show" >
            <td   align="right">行政区域&nbsp;</td>
            <td >
                <input name="upProject.areaName"  value="${upProject.areaName }" id="new_areaname"/>
            </td>
        </tr>
        <tr bgcolor="#FFFFFF" style="empty-cells:show" >
            <td  align="right">项目功能描述&nbsp;</td>
            <td >
                <input name="upProject.projectDesc"  value="${upProject.projectDesc }" id="new_prodesc"/>
            </td>
        </tr>
        <tr bgcolor="#FFFFFF" style="empty-cells:show" >
            <td align="right">开发商&nbsp;</td>
            <td >
                <s:select list="devList"  listKey="id" listValue="developerName" name="upProject.developerId"></s:select>
                <%-- <a href="#" id="but_new_dev" onclick="open1()">新建开发商</a>--%>
            </td>
        </tr>
        <tr bgcolor="#eeeeee">
            <td colspan="2">&nbsp; </td>
        </tr>
        <%if(PermissionUtils.hasPermission(EnumPrivCode.SALEUNIT_INIT_UNITINFO, EnumDevFlag.GUANGZHOU)){%>
        <tr bgcolor="#eeeeee">
            <td align="right">是否删除该楼盘</td>
            <td>&nbsp;<label><input id="isdel" style="width: auto;vertical-align: text-top" type="radio" name="upProject.isDeleted" value="1" style="width: auto;"/>是</label>
                &nbsp;&nbsp;<label><input style="width: auto;vertical-align: text-top" type="radio" name="upProject.isDeleted" value="0" checked="checked"/>否</label>
                <font color="red">&nbsp;请谨慎操作删除楼盘功能.</font>
            </td>
        </tr>
        <%}%>
        <tr bgcolor="#FFFFFF" style="empty-cells:show" >
            <td colspan="2" width="100%"  align="center" style="color: red">${sug }</td>
        </tr>
    </table>
</form>
</body>
</html>