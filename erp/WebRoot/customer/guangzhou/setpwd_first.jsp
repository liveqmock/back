
<%@ page language="java" pageEncoding="UTF-8" isELIgnored="false"%>
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

    <s:include value="../../header/header_easyui.jsp"></s:include>

    <title>修改密码</title>

    <script type="text/javascript">
        function doSubmit(){
            if($("#pwd").val().trim()=="" || $("#vpwd").val().trim()==""){
                alert("密码不能为空，请重新输入。");
                return false;
            } else {
                $("#pwdform").action = "./customer_guangzhou/first/form.action" ;
                $("#pwdform").submit();
            }
        }
    </script>

</head>

<body>
<div style="width:1000px; top:50%; left:50%; position:absolute;margin-left:-250px;margin-top:-200px;">
    <div class="easyui-panel" title="您的密码过于简单，请修改密码再使用本系统" style="width:400px;">
        <div style="padding:10px 0 10px 60px">
            <form id="pwdform" action="./customer_guangzhou/first/form.action" method="post" >
                <table>
                    <tr>
                        <td align="right">新密码:</td>
                        <td>
                            <input class="easyui-validatebox" type="password" name="pwd" id="pwd">
                        </td>
                    </tr>
                    <tr>
                        <td>&nbsp;</td>
                        <td>
                            <font color="red">密码6位以上,必须包含数字和英文</font>
                        </td>
                    </tr>
                    <tr>
                        <td align="right">确认新密码:</td>
                        <td><input class="easyui-validatebox" type="password" name="vpwd" id="vpwd"></td>
                    </tr>
                    <tr>
                        <td colspan="2" align="center">
                            <br/>
                            <input type="submit" name="button"  value="  保存  " class="easyui-linkbutton" />

                            <br/>
                            <br/>
                             <s:if test="#request.tip == 'suc'">

                                <a href="./customer_guangzhou/index/login.action" title="注销" class="easyui-linkbutton">进入主页</a>

                            </s:if>
                            <s:else><font color="red">提示：请检查密码是否在6位以上？是否包含数字和英文？</font></s:else>

                        </td>
                    </tr>

                </table>
            </form>
        </div>

    </div>
</div>


</body>
</html>



