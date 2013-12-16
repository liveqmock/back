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

    <title>楼栋修改</title>

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

            $("#build_teee").tree({
                dnd:true,
                animate:false,
                url:'./saleunit_new_init/appoint/guangzhou/modifyBuildByBrag.action?areaId=${id}',
                onDrop:function(target, source, point){
                    //target:表示的是拖拉对象source要放置的对象;source:表示的是拖拉对象;point:表示的是操作类型,包括'append','top' or 'bottom'
                    var text = "只能对楼栋进行上下排序操作";
                    if(point == 'append'){
                        myAlert(text);
                        reloadTree(target);
                    }
                }
            });

        });

        function reloadTree(target){
            //$("#build_teee").tree("reload", target);
            var roots = $("#build_teee").tree("getRoots");
            var length = roots.length;

            for(var index=0; index<length; index++){
                $("#build_teee").tree("remove", roots[index].target);
            }

            $.ajax({
                type: 'get',
                url: './saleunit_new_init/appoint/guangzhou/modifyBuildByBrag.action?areaId=${id}',
                dataType: "json",
                success: function(data){
                    $("#build_teee").tree("loadData", data);
                },
                error: function(XMLHttpRequest, textStatus, errorThrown){
                    myAlert("重新加载楼栋出错,请关闭弹出框,再重新操作");
                }

            });
        }

        function formsubmit (){

            var roots = $("#build_teee").tree("getRoots");
            var length = roots.length;
            var idArr = new Array([length]);

            for(var index=0; index<length; index++){
                idArr.push(roots[index].id);
            }

            $("#sortBuildId").val(idArr.join(","));

            if($("#isdel").is(":checked")){

                $.messager.confirm('对话框','是否确认删除?',function(r){
                    if(r){
                        document.getElementById("pay_unit_form").submit();
                    }
                });

            }else{
                document.getElementById("pay_unit_form").submit();
            }
        }
    </script>
</head>
<body>
<div >
    <form action="./saleunit_new_init/appoint/guangzhou/updateAreaForm.action" method="post" id="pay_unit_form">
        <table width="100%" border="0" align="center" cellpadding="0" cellspacing="1"  style="font-size:12px; line-height:26px;background-color: #A9D9FF">
            <tr bgcolor="#E9F5FF" style="empty-cells:show">
                <td  align="left" colspan="2" style="line-height: 30px" ><b>&nbsp;您现在的操作:${text1}&nbsp;</b></td>
            </tr>
            <tr bgcolor="#FFFFFF" style="empty-cells:show" >
                <td width="100px"   align="right"><font color="red"> * </font> 名称&nbsp;</td>
                <td >
                    <input name="newName" type="text" maxlength="25" value="${newName}"/>
                    <input type="hidden" value="${id}" name="id"/>

                    <input type="hidden" name="sortBuildId" id="sortBuildId"/>
                </td>
            </tr>

            <%if(PermissionUtils.hasPermission(EnumPrivCode.SALEUNIT_INIT_UNITINFO, EnumDevFlag.GUANGZHOU)){%>
            <tr bgcolor="#FFFFFF" style="empty-cells:show" >
                <td align="right">删除分区</td>
                <td>&nbsp;<label><input id="isdel"
                                        type="radio" name="isDeleted" value="1" style="width: auto;vertical-align: text-top"/>是</label>
                    &nbsp;<label><input style="width: auto;vertical-align: text-top"
                                        type="radio" name="isDeleted" value="0" checked="checked"/>否</label>
                    <font color="red">请先确认本分区下没有楼栋</font>
                </td>
            </tr>
            <%}%>
            <tr bgcolor="#FFFFFF" style="empty-cells:show" >
                <td colspan="2"><font color="red">拖拉可以修改该分区对应楼栋的排序</font></td>
            </tr>

        </table>

    </form>
</div>

<!-- 该分区下可以拖拉排序的楼栋 -->
<ul id="build_teee"></ul>


</body>
</html>