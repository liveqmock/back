<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>新建用户</title>
    <s:include value="header.jsp"></s:include>

    <script src="<%=path %>/js/jquery.validate.js" type="text/javascript"></script>
    <script src="<%=path %>/js/jquery.validate.messages_cn.js" type="text/javascript"></script>
    <script src="<%=path %>/js/jquery.metadata.js" type="text/javascript"></script>

    <style type="text/css">
        p {color:red;}
        tr{height:28px;}
        .box{line-height: 28px;height: 20px;}
    </style>

    <script language="javascript" type="text/javascript">
        $().ready(function(){

            $("#inputUser_companyId").change(function(){
                companyToProject(this.value, "inputUser_projectId");
            });

            $("#inputform").validate({
                rules: {
                    'inputUser.realName': {
                        required: true,
                        minlength: 2
                    },
                    'inputUser.userName': {
                        required: true,
                        minlength: 2
                    },
                    'inputUser.userPwd': {
                        required: true,
                        minlength: 6
                    }
                },

                messages: {
                    'inputUser.realName': {
                        required: '请输入姓名',
                        minlength: '请至少输入两个字符'
                    },
                    'inputUser.userName': {
                        required: '请输入账号',
                        minlength: '请至少输入两个字符'
                    },
                    'inputUser.userPwd': {
                        required: '请输入密码',
                        minlength: '请至少输入六个字符'
                    }
                },

                errorElement: "p", //可以用其他标签，记住把样式也对应修改
                success: function(label) {
                    //label指向上面那个错误提示信息标签em
                    label.text(" ")				//清空错误提示消息
                    //加上自定义的success类
                }
            });
        });
    </script>
</head>

<body onLoad="clearSuggestion()">

<%--主体 --%>
<div class="ui_tools"></div>
<div class="ui_listview">
    <div class="right99"></div>
    <div class="blueline"></div>
    <div class="c"></div>
    <div class="c"></div>


    <form name="inputform" class="registerform" id="inputform" action="./guangzhou/userAccount/inputform.action" method="post">
        <table width="470" border="0" align="left" cellpadding="0" cellspacing="1" class="gbox">
            <tr  bgcolor="#FFFFFF">
                <td style="line-height: 15px" width="110" align="center"   nowrap="nowrap">账号</td>
                <td style="line-height: 15px" width="360" nowrap="nowrap"  >

                    <input type="text" name="inputUser.userName"  class="box" value="${inputUser.userName }"/>(可带公司项目标示防止重复)

                </td>
            </tr>
            <tr  bgcolor="#FFFFFF">

                <td style="line-height: 15px"  align="center"   nowrap="nowrap">密码</td>
                <td style="line-height: 15px"  nowrap="nowrap"  >
                    <input type="text" name="inputUser.userPwd" value="a123456"   class="box"/>(6位以上)
                </td>
            </tr>


            <tr  bgcolor="#FFFFFF">

                <td style="line-height: 15px"   align="center">姓名</td>
                <td style="line-height: 15px"  >
                    <input type="text" name="inputUser.realName" value="${inputUser.realName }"  class="box" />(可带公司项目标示防止重复)
                </td>

            </tr>
            <tr  bgcolor="#FFFFFF">

                <td style="line-height: 15px"  align="center" >移动电话</td>
                <td style="line-height: 15px"  >

                    <input type="text" name="inputUser.mobilePhone" value="${inputUser.mobilePhone }"  class="box"  onkeyup="if(isNaN(value))execCommand('undo')"/>(短信通知用)
                </td>
            </tr>
            <tr  bgcolor="#FFFFFF">

                <td style="line-height: 15px"   align="center" >工号</td>
                <td style="line-height: 15px" >
                    <input size="12" type="text" name="inputUser.jobNumber" value="${inputUser.jobNumber }"  class="box"/>(选填)
                </td>
            </tr>
            <tr bgcolor="#FFFFFF">

                <td id="t15" align="center">所属项目</td>
                <td style="line-height: 15px" id="t12">
                    <s:select list="projectList" listKey="id" listValue="projectName" headerValue="全部" headerKey="0" name="inputUser.projectId" ></s:select>
                </td>

            </tr>
            <%--
                                                         <tr  bgcolor="#eeeeee"; height="28px">

                                                         <td style="line-height: 15px" colspan="2" id="t13" align="center" >
                                                             下面选项为管理层使用,销售人员不需要选择

                                                         </td>


                                                     </tr>




                                                     <tr bgcolor="#eeeeee"; height="28px">

                                                         <td id="t15" align="center">所属项目</td>
                                                         <td style="line-height: 15px" id="t12">
                                                             <s:select list="projectList" listKey="id" listValue="projectName" headerValue="全部" headerKey="0" name="inputUser.projectId" ></s:select>
                                                             </td>

                                                     </tr>
                                                     <tr  bgcolor="#eeeeee"; height="40px">

                                                         <td id="t15" align="center">权限</td>
                                                         <td id="t12">
                                                         项目
                                                         <s:select list="projectList" listKey="id" listValue="projectName" headerValue="全部" headerKey="0" name="inputUser.projectId" ></s:select><br/><hr/>
                                                         角色
                                                             <s:select list="roleList" listKey="id" listValue="roleName" name="role1" size="5" multiple="true"></s:select>
                                                         </td>

                                                     </tr>	--%>
            <tr  bgcolor="#FFFFFF"  align="center">
                <td colspan="2" style="color: red;size: 4">
                    <input type="hidden" name="saleMonitor.id" value="<s:property value='#session.saleMonitor.id'/>" />
                    <input type="hidden" name="saleMonitor.projectId" value="<s:property value='#session.saleMonitor.projectId'/>" />
                    <input type="hidden" name="saleMonitor.monitorDate" value="<s:date name='#session.saleMonitor.monitorDate' format='yyyy-MM-dd'/> " />

                    <input type="submit" value="  保存  " name="button" id="button"/>
                    <input type="button" value="  关闭  " id="bnt-close"/>
                    <s:actionmessage/>
                </td>
            </tr>
            <s:iterator value="logMonitorList" id="c"/>


        </table>

    </form>


    <div class="c"></div>



    <!--main.end-->

</div>
</body>
</html>

