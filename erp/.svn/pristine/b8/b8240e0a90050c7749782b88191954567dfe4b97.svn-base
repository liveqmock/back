<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page import="com.ihk.constanttype.EnumDevFlag" %>
<%@ page import="com.ihk.constanttype.EnumPrivCode" %>
<%@ page import="com.ihk.permission.PermissionUtils" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>客户分类明细表(废弃,2013-10-30,因为直接用easyui分组异步的方式，性能已经提高了，不需要再用first来过渡)</title>

    <s:include value="header_report.jsp"></s:include>

    <script type="text/javascript" src="<%=basePath%>js/parent_dialog_by_report.js"></script><!-- 分类分析需要的弹出框 -->

    <script type="text/javascript">

        $().ready(function(){
            //projectListForHiddenId("projectName", "hiddenId"); //项目的联想框,及用隐藏域保存其id
            bindProjectDialogForSQKHOnlyQuestion("projectName", "hiddenId"); //单个项目的选择，并且设置该项目的问卷


            /**先隐藏
             $("#selCategory").change(function(){
					getRangeFromProjectIdAndType("hiddenId", "selCategory", "PRICE_AMOUNT", "rangeId");
				});
             */
            //function getRangeFromProjectIdAndType(projectId, typeId, typeValue, rangeId){
            /*$("#hiddenId").change(function(){
             $.ajax({
             url:'./customer_guangzhou/input/pickQuestionList.action?proId='+$("#hiddenId").val(),
             success:function(data){
             $("#questionList").empty();
             $("#questionList").append(data);

             }
             });
             }
             );	*/


        });

        function getSelCategory(){
            $.ajax({
                url:'./saleunit_new_report/report/guangzhou/getSelCategory.action?questionId='+ $("#questionList").val(),
                success:function(data){
                    $("#selCategoryList").empty();
                    $("#selCategoryList").append(data);
                }
            });
        }


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

        function submitSearch_CustomerPie(){

            if($("#hiddenId").val()==""){
                myAlert("请选择项目");
                return;
            }
            $(window.parent.document).find("#showTitle").text('单项比例分析图');
            $("#thisForm").attr("action", "./saleunit_new_report/report/guangzhou/customerPie.action").submit();
        }

        function exportMessage(){
            $(function(){
                $('#exportFm').form({
                    url:'./saleunit_new_report/report/guangzhou/customerExport.action'
                });
                $('#exportFm').submit();
            });
        }
    </script>
</head>
<body style="padding:0px;background:white;">

<div class="right99"></div>

<table width="100%" border="0" align="left" cellspacing="0">

    <tr>
        <td>
            <form class="registerform" id="thisForm" method="post" style="margin:0px;display: inline" action="./saleunit_new_report/report/guangzhou/customerTable.action">

                &nbsp;项目<input type="text" id="projectName" size="40" name="projectName" value="${customerCond.strSearchProjectNames}"/>
                <input type="hidden" id="hiddenId" name="customerCond.strSearchProjectIds" value="${customerCond.strSearchProjectIds}"/>

                <label>&nbsp;<span>项目问卷</span></label><s:select list="questionList" name="questionId" id="questionList"  onchange="getSelCategory();" />
                <label>&nbsp;<span>分析类型</span>
                </label><select id="selCategoryList" name="selCategory" style="width:100px"></select>
                <!--
                <label>&nbsp;<span>区间范围</span></label><select id="rangeId" name="rangeId"><option value="">请选择</option></select>
                -->
                日期<input class="easyui-datebox" type="text" id="date1" style="width:90px" name="customerCond.visitDate1" value="${customerCond.visitDate1}"/>
                -
                <input class="easyui-datebox" type="text" id="date2" style="width:90px" name="customerCond.visitDate2" value="${customerCond.visitDate2}"/>

                &nbsp;<input type="button" onclick="return submitSearch()" value=" 查询  "/>
                <a style="color:#1199FF;" href="javascript:submitSearch_CategoryNum();">环比走势</a>&nbsp;
                <a style="color:#1199FF;" href="javascript:submitSearch_CustomerPie();">比例分析</a>&nbsp;
                <!--
                <a style="color:#1199FF;" href="./customer_guangzhou/chart/downLoad.action">下载</a>&nbsp;
                 -->
            </form>
            <%if(PermissionUtils.hasPermission(EnumPrivCode.REPORT_PRECUSTOMER_EXCEL, EnumDevFlag.GUANGZHOU) ){%>
            <form id="exportFm" method="post" style="margin:0px;display: inline">
                <input type="button" onclick="return exportMessage()" value="导出" />
            </form>
            <%} %>
            <div class="right99"></div>
            <div class="blueline"></div>		</td>
    </tr>

    <!-- 搜索表单 end -->
</table>






</body>
</html>

