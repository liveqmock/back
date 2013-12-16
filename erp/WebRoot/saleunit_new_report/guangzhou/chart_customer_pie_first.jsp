<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page import="com.ihk.constanttype.EnumDevFlag" %>
<%@ page import="com.ihk.constanttype.EnumPrivCode" %>
<%@ page import="com.ihk.permission.PermissionUtils" %>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html >
<head>
    <title>客户分类比例图</title>
    <s:include value="header_report.jsp"></s:include>

    <script type="text/javascript">

        $().ready(function(){
            $("#saleMonitorCond_companyId").change(function(){
                companyToProject(this.value, "saleMonitorCond_projectId");
            });

            //projectListForHiddenId("projectName", "hiddenId"); //项目的联想框,及用隐藏域保存其id
            bindProjectDialogForSQKHOnlyQuestion("projectName", "hiddenId"); //多个项目的选择
        });

        function submitSearch(){
            if($("#hiddenId").val()==""){
                myAlert("请选择项目");
                return;
            }
            $("#thisForm").submit();
        }

        function submitSearch_CategoryNum(){
            if($("#hiddenId").val()==""){
                myAlert("请选择项目");
                return;
            }
            $(window.parent.document).find("#showTitle").text('单项环比走势图');
            $("#thisForm").attr("action", "./saleunit_new_report/report/guangzhou/categoryNum.action").submit();
        }


        function submitSearch_CustomerTable(){
            if($("#hiddenId").val()==""){
                myAlert("请选择项目");
                return;
            }
            $(window.parent.document).find("#showTitle").text('单项数据分析表');
            $("#thisForm").attr("action", "./saleunit_new_report/report/guangzhou/customerTable.action").submit();
        }

        function exportMessage(){

            $(function(){
                $('#exportFm').form({
                    url:'./saleunit_new_report/report/guangzhou/pieExport.action'
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
            <form id="thisForm" method="post" style="margin:0px;display: inline" action="./saleunit_new_report/report/guangzhou/customerPie.action">
                &nbsp;项目<input type="text" id="projectName" size="40" name="projectName" value="${customerCond.strSearchProjectNames}"/>
                <input type="hidden" id="hiddenId" name="customerCond.strSearchProjectIds" value="${customerCond.strSearchProjectIds}"/>

                <label>&nbsp;<span>项目问卷</span></label><s:select list="questionList" name="questionId" id="questionList"  onchange="bindQuestionCategory();" />
                <label>&nbsp;<span>分析类型</span>
                </label><select id="selCategoryList" name="selCategory" style="width:100px"></select>
                &nbsp;日期<input class="easyui-datebox" type="text" id="date1" style="width:90px" name="customerCond.visitDate1" value="${customerCond.visitDate1}"/>
                -
                <input class="easyui-datebox" type="text" id="date2" style="width:90px" name="customerCond.visitDate2" value="${customerCond.visitDate2}"/>

                &nbsp;<input type="button" onclick="return submitSearch()" value=" 查询  "/>
                <a style="color:#1199FF;" href="javascript:submitSearch_CategoryNum();">环比走势</a>&nbsp;
                <a style="color:#1199FF;" href="javascript:submitSearch_CustomerTable();">分析表</a>&nbsp;
            </form>

            <%if(PermissionUtils.hasPermission(EnumPrivCode.REPORT_PRECUSTOMER_EXCEL, EnumDevFlag.GUANGZHOU) ){%>
            <form id="exportFm" method="post" style="margin:0px;display: inline">
                <input type="button" onclick="return exportMessage()" value="导出" >
            </form>
            <%} %>
            <div class="right99"></div>
            <div class="blueline"></div></td>
    </tr>

    <!-- 搜索表单 end -->
</table>


</body>
</html>



   
   



