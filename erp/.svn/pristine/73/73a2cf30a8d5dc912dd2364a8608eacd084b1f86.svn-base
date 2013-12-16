<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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

    <s:include value="header.jsp"></s:include>

    <script type="text/javascript" src="<%=basePath%>/js/userAccount-hengda.js" ></script>
    <script type="text/javascript" src="<%=basePath%>js/customer_guangzhou.js"></script>

    <script type="text/javascript" language="javascript" src="<%=basePath%>js/customer_guangzhou_project.js"></script>
    <script type="text/javascript" language="javascript" src="<%=basePath%>js/customer_sel.js"></script>

    <title>用户管理</title>


    <style>
        * {margin:0;padding:0;}
        html,body {height:100%;width:100%;}
        #content {background:#f8f8f8;padding:30px;height:100%;}
        #content a {font-size:30px;color:#369;font-weight:700;}
        .alert {margin:0;padding:0;font-size:12px;}
        .alert {border:3px solid #369;width:450px;height:250px;background:#e2ecf5;z-index:1000;position:absolute;display:none;}
        .alert h4 {height:20px;background:#369;color:#fff;padding:5px 0 0 5px;}
        .alert h4 span {float:left;}
        .alert em  {color:red;padding:5px 0 0 5px;}
        .alert h4 span#close1 {margin-left:250px;font-weight:500;cursor:pointer;}
        .alert h4 span#close2 {margin-left:250px;font-weight:500;cursor:pointer;}
        .alert h4 span#close3 {margin-rhght:250px;font-weight:500;cursor:pointer;}
        .alert p {padding:12px 0 0 30px;}
        .alert p input {width:120px;margin-left:20px;}
        .alert p input.myinp {border:1px solid #ccc;height:16px;}
        .alert p input.sub {width:60px;margin-left:30px;}
    </style>
    <script type="text/javascript">
        $().ready(function(){

            var bool = false;
            var offsetX = 0;
            var offsetY = 0;
            var divid ;
            projectListForHiddenId("projectName", "hiddenId"); //项目的联想框,及用隐藏域保存其id
            projectListForHiddenId("projectName2", "delProjectId"); //项目的联想框,及用隐藏域保存其id
            projectListForHiddenId("projectName3", "addProjectId"); //项目的联想框,及用隐藏域保存其id

            //userList("realName");
            //拖动DIV
            $("#alert1title").mousedown(function(event) {//绑定事件的控件
                bool = true;
                divid = 'alert1';//移动的控件
                offsetX = event.offsetX ? event.offsetX : event.layerX;
                offsetX = offsetX -150;
                offsetY = event.offsetY ? event.offsetY : event.layerY;
                offsetY = offsetY -75;

            })
                    .mouseup(function() {
                        bool = false;
                    })
            $("#alert2title").mousedown(function(event) {
                bool = true;
                divid = 'alert2';
                offsetX = event.offsetX ? event.offsetX : event.layerX;
                offsetX = offsetX -150;
                offsetY = event.offsetY ? event.offsetY : event.layerY;
                offsetY = offsetY -75;

            })
                    .mouseup(function() {
                        bool = false;
                    });
            $("#alert3title").mousedown(function(event) {
                bool = true;
                divid = 'alert3';
                offsetX = event.offsetX ? event.offsetX : event.layerX;
                offsetX = offsetX -150;
                offsetY = event.offsetY ? event.offsetY : event.layerY;
                offsetY = offsetY -75;

            })
                    .mouseup(function() {
                        bool = false;
                    });
            $(document).mousemove(function(event) {
                if (!bool) {
                    return;
                }
                else {

                    var x = event.clientX - offsetX;
                    var y = event.clientY - offsetY;
                    $("#"+divid).css("position", "absolute");
                    $("#"+divid).css("left", x);
                    $("#"+divid).css("top", y);
                }
            })

        });
    </script>

</head>
<body>



    <table width="100%" border="0" align="left" cellspacing="0">

        <!-- 搜索表单 top -->

        <form action="./guangzhou/userAccount/searchform.action" method="post">
            <tr>
                <td width="100%" height="0" align="left" colspan="5" nowrap="nowrap">
                    &nbsp; 帐号<input size="10" type="text" name="searchCond.userName" value="${searchCond.userName}" />
                    &nbsp; 姓名<input size="10" type="text" id="realName" name="searchCond.realName" maxlength="10" value="${searchCond.realName}"/>


                    &nbsp; 项目<input type="text" id="projectName" name ="projectName"  value="${projectName}"/>
                    <input type="hidden" id="hiddenId" name="searchCond.userRoleProjectId" value="${searchCond.userRoleProjectId}"/>
                    &nbsp;   角色<s:select list="roleList" listValue="roleName" listKey="id" name="searchCond.roleId" headerKey="" headerValue="全部"></s:select>
                    &nbsp;  创建日期<input class="Wdate" type="text"  style="width:90px" name="searchCond.date1" value="${searchCond.date1}" onClick="WdatePicker()"/>
                    -<input class="Wdate" type="text"  style="width:90px" name="searchCond.date2" value="${searchCond.date2}"  onClick="WdatePicker()"/>
                    &nbsp;<input  type="submit" name="button3" id="button3" value="  搜索  "  align="left"/></td>

            </tr>
            <s:actionmessage cssStyle="color:red"/>
        </form>

        <!-- 搜索表单 end -->

        <tr>
            <td height="10" colspan="6">
                <div class="blueline"></div>              </td>
        </tr>



        <tr>
            <td height="20" colspan="6">
                <input  type="button" value="  删除  "  onclick="delUserAccount('./guangzhou/userAccount/delete')"/>
                <input  type="button" value="  批量增加项目角色  "   id="showdlog" onclick="showalert($('#alert1'));"></input>
                <input  type="button" value="  批量删除项目角色  "  onclick="showalert($('#alert2'));"></input>
                <input  type="button" value="  批量复制用户角色  "  onclick="showalert($('#alert3'));"></input>

            </td>
        </tr>





        <tr>
            <td colspan="6">

                <!--  列表 top -->
                <div class="gbox1">

                    <table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" class="gbox" >
                        <tr class="gboxbg">
                            <td width="25" align="center"><input  type="checkbox" id="allDel" name="allDel" onclick="allDel()" /> </td>

                            <td width="188" align="left">
                                <table width="100" height="28"  border="0" align="center" cellspacing="0">
                                    <tr>
                                        <td width="80%" align="left" valign="middle">&nbsp;&nbsp;&nbsp;账号</td>
                                        <td align="center" valign="middle"><table width="5" border="0" cellspacing="0">
                                            <tr>
                                                <td><a href="./guangzhou/userAccount/searchform.action?ob=11"><img src="images/blue/upn.gif" width="9" height="10" border="0" /></a></td>
                                            </tr>
                                            <tr>
                                                <td><a href="./guangzhou/userAccount/searchform.action?ob=12"><img src="images/blue/downopen.gif" width="9" height="10" border="0" /></a></td>
                                            </tr>
                                        </table>	</td>
                                    </tr>
                                </table></td>



                            <td width="188" align="left">
                                &nbsp;&nbsp;&nbsp;姓名
                            </td>
                            <td width="188" align="left">
                                &nbsp;&nbsp;&nbsp;项目
                            </td>
                            <td width="197" align="left">
                                &nbsp;&nbsp;&nbsp;手机号
                            </td>
                            <td width="188" align="left">
                                <table width="100" height="28"  border="0" align="center" cellspacing="0">
                                    <tr>
                                        <td width="80%" align="left" valign="middle">&nbsp;&nbsp;&nbsp;创建时间</td>
                                        <td align="center" valign="middle"><table width="5" border="0" cellspacing="0">
                                            <tr>
                                                <td><a href="./guangzhou/userAccount/searchform.action?ob=31"><img src="images/blue/upn.gif" width="9" height="10" border="0" /></a></td>
                                            </tr>
                                            <tr>
                                                <td><a href="./guangzhou/userAccount/searchform.action?ob=32"><img src="images/blue/downopen.gif" width="9" height="10" border="0" /></a></td>
                                            </tr>
                                        </table>	</td>
                                    </tr>
                                </table></td>
                        </tr>


                        <s:iterator value="userlist"  id="u">
                            <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
                            <td align="center" valign="middle"><input name="delId" type="checkbox" value="<s:property value='id'/>" onclick="delId()" /></td>
                            <td align="left" valign="middle"  class="fontblue">&nbsp;
                                <a style="color: #1199FF;" class="ablue" href="./guangzhou/userAccount/indexUpdate.action?id=${id}" target="_self">
                                    &nbsp;<s:property  value="userName" /></a>	</td>


                            <td align="left" valign="middle" >&nbsp;
                                &nbsp;<s:property value="realName" /></td>
                            <td align="left" valign="middle" >&nbsp;
                                &nbsp;<s:property value="descProjectId" /></td>
                            <td align="left" valign="middle" title="${fn:length(selectUserRoleList)}条权限" >&nbsp;
                                &nbsp;<s:property value="mobilePhone" />
                            </td>
                            <td align="left" valign="middle">&nbsp;
                                &nbsp;<s:property  value="createdTime" />	</td>
                            </tr>

                        </s:iterator>



                    </table>
                </div>

                <!-- 列表 end --></td>
        </tr>
        <tr>
            <td colspan="6">
                <div class="manu">
                    <s:property value="showPage" escape="false"/>
                </div>			</td>
        </tr>
    </table>
</div>


<div id="alert1" class="alert">
    <iframe     style= "position:absolute;z-index:-1;width:99%;height:99%;top:0;left:0; "   frameborder= "0"   src= "about:blank "> </iframe>
    <h4 id="alert1title"><span>批量增加用户角色</span><span id="close1" onclick="closealert($('#alert1'));">关闭</span></h4>
    <p><label><em>*</em> 项目</label>
        <input type="text" id="projectName3" /></p>
    <input type="hidden" id="addProjectId" />

    <p><label><em>*</em> 角色</label>&nbsp;&nbsp;&nbsp;

        <s:select id="addRoleId" list="roleList" listValue="roleName" listKey="id" name="searchCond.roleId" ></s:select>
    </p>

    <p><input style="width: 70px" type="button" value="执行操作" onclick="addUserRole('./guangzhou/userAccount/addrole');"></input></p>
    <p>增加所有勾选用户所项目的所选选角色</p>
</div>

<div id="alert2" class="alert">
    <iframe     style= "position:absolute;z-index:-1;width:99%;height:99%;top:0;left:0; "   frameborder= "0"   src= "about:blank "> </iframe>

    <h4 id="alert2title"><span>批量删除用户角色</span><span id="close2" onclick="closealert($('#alert2'));">关闭</span></h4>
    <p><label><em>*</em> 项目</label>
        <input type="text" id="projectName2"/></p>
    <input type="hidden" id="delProjectId" />
    <p><label><em>*</em> 角色</label>&nbsp;&nbsp;&nbsp;

        <s:select id="delRoleId" list="roleList" listValue="roleName" listKey="id" name="searchCond.roleId" ></s:select>
    </p>
    <p><input style="width: 70px" type="button" value="执行操作"  onclick="delUserRole('./guangzhou/userAccount/delrole');"></input></p>
    <p>删除所有勾选用户的该角色</p>
</div>

<div id="alert3" class="alert" >
    <iframe     style= "position:absolute;z-index:-1;width:99%;height:99%;top:0;left:0; "   frameborder= "0"   src= "about:blank "> </iframe>

    <h4  id="alert3title"><span>批量复制用户角色</span><span id="close3" onclick="closealert($('#alert3'));">关闭</span></h4>
    <p><label><em>*</em> 复制</label>
        <s:select list="userlist" listValue="realName" listKey="id" id="copyUserId"></s:select>角色
    </p>

    <p><input style="width: 70px" type="button" value="执行操作"  onclick="copyUserRole('./guangzhou/userAccount/copyrole');"></input></p>
    <p>所选人员的角色复制到所有勾选用户</p>

</div>
</body>
<script language="javascript" type="text/javascript">



    function showalert(alert){
        //myAlert.style.display = "block";
        //myAlert.style.position = "absolute";
        //myAlert.style.top = "30%";
        //myAlert.style.left = "30%";
        //myAlert.style.marginTop = "-75px";
        //myAlert.style.marginLeft = "-150px";
        alert.children("h4").css('cursor', 'move');
        alert.css("display","block");
        alert.css("top","30%");
        alert.css("left","50%");
        alert.css("marginTop","-75px");
        alert.css("marginLeft","-150px");

        mybg = document.createElement("div");
        mybg.setAttribute("id","mybg");
        mybg.style.background = "#000";
        mybg.style.width = "100%";
        mybg.style.height = "100%";
        mybg.style.position = "absolute";
        mybg.style.top = "0";
        mybg.style.left = "0";
        mybg.style.zIndex = "500";
        mybg.style.opacity = "0.3";
        mybg.style.filter = "Alpha(opacity=30)";
        document.body.appendChild(mybg);
        document.body.style.overflow = "hidden";
    }
    function closealert(alert){
        //alert.style.display = "none";
        alert.css("display","none");
        mybg.style.display = "none";
        document.body.style.overflow = "auto";
    }



    function showrole(showrole,showid){

        var show = showrole
                +"<br/>"
                +"<a class='ablue' href='./sale_hengda/role/index.action?selectId="
                +showid
                +"'"
                +"target='_self'>修改</a>"
                ;
        var showdialog = new Dialog(show,{title:'查看角色'});
        showdialog.show();
    }

</script>
</html>

