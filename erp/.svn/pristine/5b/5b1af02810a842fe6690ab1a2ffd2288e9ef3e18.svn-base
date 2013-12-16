<%@ page language="java" import="com.ihk.constanttype.ContUserId" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page import="com.ihk.constanttype.EnumDevFlag" %>
<%@ page import="com.ihk.constanttype.EnumPrivCode" %>
<%@ page import="com.ihk.permission.PermissionUtils" %>
<%@ page import="com.ihk.utils.SessionUser" %>
<%@ page contentType="text/html; charset=utf-8" %>

<%@ taglib prefix="s" uri="/struts-tags" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<style>

    .btn1 {
        BORDER-RIGHT: #7b9ebd 1px solid; PADDING-RIGHT: 2px; BORDER-TOP: #7b9ebd 1px solid; PADDING-LEFT: 2px; FONT-SIZE: 12px; FILTER: progid:DXImageTransform.Microsoft.Gradient(GradientType=0, StartColorStr=#ffffff, EndColorStr=#cecfde); BORDER-LEFT: #7b9ebd 1px solid; CURSOR: hand; COLOR: black; PADDING-TOP: 2px; BORDER-BOTTOM: #7b9ebd 1px solid
        }
    .btn1_d {
        background:#444444;
        BORDER-RIGHT: #7EBF4F 1px solid; PADDING-RIGHT: 2px; BORDER-TOP: #7EBF4F 1px solid; PADDING-LEFT: 2px; FONT-SIZE: 12px; FILTER: progid:DXImageTransform.Microsoft.Gradient(GradientType=0, StartColorStr=#ffffff, EndColorStr=#B3D997); BORDER-LEFT: #7EBF4F 1px solid; CURSOR: hand; COLOR: #ffffff; PADDING-TOP: 2px; BORDER-BOTTOM: #7EBF4F 1px solid
        }
    .btn1_mouseover {
        background:#8DB6CD;color:#ffffff;
        BORDER-RIGHT: #7EBF4F 1px solid; PADDING-RIGHT: 2px; BORDER-TOP: #7EBF4F 1px solid; PADDING-LEFT: 2px; FONT-SIZE: 12px; FILTER: progid:DXImageTransform.Microsoft.Gradient(GradientType=0, StartColorStr=#ffffff, EndColorStr=#CAE4B6); BORDER-LEFT: #7EBF4F 1px solid; CURSOR: hand;  PADDING-TOP: 2px; BORDER-BOTTOM: #7EBF4F 1px solid
        }
</style>
<script type="text/javascript">
    $().ready(function(){
        $(".btn1").hover(
                function () {
                    $(this).addClass("btn1_mouseover");
                },
                function () {
                    $(this).removeClass("btn1_mouseover btn1_d");
                }
        );
        $(".btn1").mousedown(function(){
            $(this).removeClass("btn1_mouseover").addClass("btn1_d");
        });
    });
    function doloadbuild(){
        if(build_id == '0'){
            myAlert('请先选择楼栋');
            return false;
        }
        location.href='./saleunit_new_init/appoint/guangzhou/loadBuildXls.action?buildId='+build_id;
    }
</script>

<%if(PermissionUtils.hasPermission(EnumPrivCode.SALEUNIT_INIT_UNITINFO, EnumDevFlag.GUANGZHOU) || SessionUser.getUserId() == ContUserId.ADMIN ){%>
<div style="width: 100%;height: auto; float: left;padding-top: 3px;">
    <input id="init_one_unit" type="button" class="btn1" value="创建单个单元"/>
    <input id="init_some_unit_but" type="button" class="btn1" value="批量创建单元" />
    <input id="update_unit" type="button" class="btn1" value="修改所选单元"/>
    <input id="deleted_unit" type="button" class="btn1" value="删除所选单元"/>
    <input id="update_some_unit" type="button" class="btn1" value="批量修改/删除单元"/>
</div>
<%} %>




