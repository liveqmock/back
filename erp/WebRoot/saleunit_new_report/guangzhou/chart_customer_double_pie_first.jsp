<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page import="com.ihk.permission.PermissionUtils" %>
<%@ page import="com.ihk.constanttype.EnumPrivCode" %>
<%@ page import="com.ihk.constanttype.EnumDevFlag" %>
<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html >
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>分类交叉分析</title>
    <s:include value="header_report.jsp"></s:include>
    <script type="text/javascript" src="<%=basePath%>js/parent_dialog_by_report.js"></script><!-- 分类分析需要的弹出框 -->
    <script type="text/javascript">

        $().ready(function(){
            $("#saleMonitorCond_companyId").change(function(){
                companyToProject(this.value, "saleMonitorCond_projectId");
            });

            //projectListForHiddenId("projectName", "hiddenId"); //项目的联想框,及用隐藏域保存其id
            bindProjectDialogForSQKHOnlyQuestion("projectName", "hiddenId"); //多个项目的选择
        });
        
        function getSelCategory(){
            $.ajax({
                url:'./saleunit_new_report/report/guangzhou/getSelCategory.action?questionId='+ $("#questionList").val(),
                success:function(data){
                    $("#sel1").empty();
                    $("#sel1").append(data);
                    $("#sel2").empty();
                    $("#sel2").append(data);
                    $("#sel3").empty();
                    $("#sel3").append(data);
                }
            });
        }


        function submitSearch(){

            var projectId = $("#hiddenId").val();

            if(projectId == "" || projectId == "0" || isNaN(projectId)){

                myAlert("请先选择项目");
                return false;
            }

            var count = 0;

            var sel1 = $("#sel1").val();
            var sel2 = $("#sel2").val();
            var sel3 = $("#sel3").val();

            if(sel1 != ""){
                count++;
            }
            if(sel2 != ""){
                count++;
            }
            if(sel3 != ""){
                count++;
            }

            

            $("#thisForm").submit();
        }

        function exportMessage(){

            $(function(){
                $('#exportFm').form({
                    url:'./saleunit_new_report/report/guangzhou/doublePieExport.action'
                });
                $('#exportFm').submit();
            });

        }
    </script>

</head>

<body style="padding:0px;background:white;">


<div class="right99"></div>


<table width="100%" border="0" align="left" cellspacing="0">

    <!-- 搜索表单 top -->

    <tr>
        <td>
            <form class="registerform" id="thisForm"  method="post" style="margin:0px;display: inline" action="./saleunit_new_report/report/guangzhou/customerDoublePie.action">
                	项目<input type="text" id="projectName" size="40" name="projectName" value="${customerCond.strSearchProjectNames}"/>
                <input type="hidden" id="hiddenId" name="customerCond.strSearchProjectIds" value="${customerCond.strSearchProjectIds}"/>
				<label>&nbsp;<span>项目问卷</span></label><s:select list="questionList" name="questionId" id="questionList"  onchange="getSelCategory();" />
                <label>&nbsp;<span>必填类型1</span></label><s:select list="listSelCategory" name="selCategory1" value="%{selCategory1}" id="sel1"/>
                <label>&nbsp;<span>必填类型2</span></label><s:select list="listSelCategory" name="selCategory2" value="%{selCategory2}" id="sel2"/>
               <!--   <label>&nbsp;<span>选填类型3</span></label><s:select list="listSelCategory" name="selCategory3" value="%{selCategory3}" id="sel3"/> -->
                
                日期<input class="easyui-datebox" type="text" id="date1" style="width:90px" name="customerCond.date1" value="${customerCond.date1}"/>
                -
                <input class="easyui-datebox" type="text" id="date2" style="width:90px" name="customerCond.date2" value="${customerCond.date2}"/>

                <input type="button" onclick="return submitSearch()" value=" 查询  "/>

            </form>

            <%if(PermissionUtils.hasPermission(EnumPrivCode.REPORT_PRECUSTOMER_EXCEL, EnumDevFlag.GUANGZHOU) ){%>
            <form id="exportFm" method="post" style="margin:0px;display: inline">
                <input  type="button" onclick="return exportMessage()" value="导出" >
            </form>
            <%} %>
            <div class="right99"></div>
            <div class="blueline"></div>
        </td>
    </tr>

    <!-- 搜索表单 end -->

</table>

</body>
</html>

