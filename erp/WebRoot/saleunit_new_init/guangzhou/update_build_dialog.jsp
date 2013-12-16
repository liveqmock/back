<%@ page import="com.ihk.constanttype.ContUserId" %>
<%@ page import="com.ihk.utils.SessionUser" %>
<%@ page import="com.ihk.constanttype.EnumDevFlag" %>
<%@ page import="com.ihk.constanttype.EnumPrivCode" %>
<%@ page import="com.ihk.permission.PermissionUtils" %>
<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html>
<head>
    <title>修改楼栋</title>
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
        function formsubmit(){
            if($("#isdel").is(":checked")){
                $.messager.confirm('对话框','是否确认删除?',function(r){
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
<form action="./saleunit_new_init/appoint/guangzhou/updateBuildForm.action" method="post" id="pay_unit_form">
    <table width="100%" border="0" align="center" cellpadding="0" cellspacing="1"  style="font-size:12px; line-height:26px;background-color: #A9D9FF">
        <tr bgcolor="#FFFFFF" style="empty-cells:show" >
            <td width="100px"  align="right"><span style="color:red">*</span>楼栋名称11&nbsp;</td>
            <td >
                <input name="upBuild.buildName" id="new_pro_name" value="${upBuild.buildName }"/>
                <input type="hidden"  name="upBuild.id" value="${upBuild.id }"/>
            </td>
        </tr>
        <tr bgcolor="#eeeeee">
            <td colspan="2">&nbsp;</td>
        </tr>


        <%if(PermissionUtils.hasPermission(EnumPrivCode.SALEUNIT_INIT_UNITINFO, EnumDevFlag.GUANGZHOU)){%>
        <tr bgcolor="#eeeeee">
            <td align="right">是否删除该楼栋</td>
            <td>&nbsp;<label><input id="isdel"
                                    type="radio" name="upBuild.isDeleted" value="1" style="width: auto;vertical-align: text-top"/>是</label>
                &nbsp;<label><input style="width: auto;vertical-align: text-top"
                                    type="radio" name="upBuild.isDeleted" value="0" checked="checked"/>否</label>&nbsp&nbsp<span style="color:red" >未进行单元状态变动才可删除</span></td>

        </tr>
        <%}%>
    </table>
</form>
</body>
</html>