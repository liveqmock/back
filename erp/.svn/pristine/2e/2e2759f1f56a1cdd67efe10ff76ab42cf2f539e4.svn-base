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
    <title>项目客户数量对比(已废弃，由customer_num_compare_company.jsp替代)</title>

    <s:include value="header_report.jsp"></s:include>
    <script type="text/javascript" src="<%=basePath%>js/highcharts.js"></script>
    <script type="text/javascript" src="<%=basePath%>js/ui_fix.js"></script>

    <script type="text/javascript" src="<%=basePath%>/js/userAccount-hengda.js" ></script>
    <!--
    <script type="text/javascript" src="./js/customer_guangzhou.js"></script>
    -->

    <script type="text/javascript">
        var chart;
        $(document).ready(function() {
            bindProjectDialogForSQKH("projectName", "hiddenId"); //多个项目的选择
            $("#formweek").click(function(){
                $("#datetype").val("week");
                submitSearch();
                return false;
            });

            $("#formmonth").click(function(){
                $("#datetype").val("month");
                submitSearch();
                return false;
            });

            chart = new Highcharts.Chart({
                chart: {
                    renderTo: 'container1',
                    plotBackgroundColor: null,
                    plotBorderWidth: null,
                    plotShadow: false
                },
                title: {
                    text: '项目-客户比例'
                },
                tooltip: {
                    formatter: function() {
                        return '<b>'+ this.point.name +'</b>: '+ changeTwoDecimal(this.percentage) +' %';
                    }
                },
                plotOptions: {
                    pie: {
                        allowPointSelect: true,
                        cursor: 'pointer',
                        dataLabels: {
                            enabled: true,
                            color: '#000000',
                            connectorColor: '#000000',
                            formatter: function() {
                                return '<b>'+ this.point.name +'</b>: '+ changeTwoDecimal(this.percentage) +' %';
                            }
                        }
                    }
                },
                series: [{
                    type: 'pie',
                    data: [
                        <s:property value="chartSeriesData"  escape="false"/>
                    ]
                }]
            });
        });
    </script>


    <script type="text/javascript">
        function submitSearch(dir){
            if(dir == "export")
                exportMessage();
            else
                $("#thisForm").submit();
        }

        function submitSearchProject(projectId){
            $("#hiddenId").val(projectId);
            submitSearch('search');
        }

        function redirectCustomerNum(projectId){
            $("#hiddenId").val(projectId);
            $("#customerCond_projectId").val(projectId);

            $(window.parent.document).find("#showTitle").text('客户数量环比图');
            $("#thisForm").attr("action", "./saleunit_new_report/report/guangzhou/customerNum.action").submit();
        }

        function exportMessage(){
            $(function(){
                $('#thisForm').form({
                    url:'./saleunit_new_report/report/guangzhou/andCustExport.action'
                });
                $('#thisForm').submit();
            });
        }
    </script>


</head>
<body style="padding:0px;background:white;">

<%--主体导航页头 --%>
<div class="right99"></div>

<%--主体table --%>
<form id="thisForm"  method="post">
    <table width="100%" border="0" align="left" cellspacing="0">

        <tr>

            <td colspan="6">
                &nbsp;项目<input type="text" id="projectName" size="40" name="projectName" value="${cond.strSearchProjectNames}"/>
                <input type="hidden" id="hiddenId" name="cond.strSearchProjectIds" value="${cond.strSearchProjectIds}"/>
                <input type="hidden" id="customerCond_date1" name="customerCond.date1" value="${cond.date1 }"/>
                <input type="hidden" id="customerCond_date2" name="customerCond.date2" value="${cond.date2 }"/>
                <input type="hidden" id="datetype" name="datetype"/>
                &nbsp;
                日期<input class="easyui-datebox" type="text" id="date1" style="width:90px" name="cond.date1" value="${cond.date1}"/>
                -
                <input class="easyui-datebox" type="text" id="date2" style="width:90px" name="cond.date2" value="${cond.date2}"/>
                &nbsp;<a id="formweek" href="#" style="color: #1199FF;" class="ablue">本周</a>
                &nbsp;<a id="formmonth" href="#" style="color: #1199FF;" class="ablue">本月</a>
                &nbsp;<input type="button" onclick="return submitSearch('search')" value=" 查询  "/>

                <input type="button" onclick="return submitSearch('export')" value="导出" />

                <div class="right99"></div>
                <div class="blueline"></div>

                <div class="gbox1">
                    <table style="width:100%">

                        <tr>
                            <td width="50%" valign="top">


                                <div class="gbox1">
                                    <table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" class="gbox" style="text-align: center;">

                                        <tr class="gboxbg">
                                            <td style="font-weight:bolder;">项目</td>
                                            <td style="font-weight:bolder;">客户量</td>
                                            <td style="font-weight:bolder;">比例</td>
                                            <td></td>
                                        </tr>

                                        <s:iterator value="custList" var="line">
                                            <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF">


                                                <s:if test="#line.projectName == '合计' || #request.tt == 'yes'">
                                                    <td>${projectName }</td>
                                                </s:if>
                                                <s:else>
                                                    <td>
                                                            ${projectName }
                                                            <%--<a  href="javascript:submitSearchProject(${projectId });" target="_self" class="ablue" style="color: #1199FF;">${projectName }</a>--%>
                                                    </td>
                                                </s:else>

                                                <td>${count }</td>
                                                <td>${pei }</td>

                                                <td>

                                                    <s:if test="#line.projectName == '合计'">

                                                    </s:if>
                                                    <s:else>
                                                        <a class="ablue" style="color: #1199FF;" href="javascript:redirectCustomerNum(${projectId });" target="_self">客户数量环比</a>
                                                    </s:else>
                                                </td>

                                            </tr>
                                        </s:iterator>


                                    </table>
                                </div>

                            </td>

                            <td width="50%">
                                <div id="container1" style="width:100%;height:400px;"></div>
                            </td>

                        </tr>

                    </table>

                </div>


            </td>
        </tr>


    </table>
</form>
</body>
</html>



   
   



