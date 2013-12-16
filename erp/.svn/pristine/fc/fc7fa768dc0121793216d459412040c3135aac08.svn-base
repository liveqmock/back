<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
         isELIgnored="false"%>
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
    <title>总体货量分析</title>
    <s:include value="header_report.jsp"></s:include>
    <script type="text/javascript" src="<%=basePath%>/ui/js/highcharts.js"></script>
    <script type="text/javascript">


        $().ready(function(){
            //页面加载时执行
            //projectListForHiddenId("projectName", "hiddenId"); //项目的联想框,及用隐藏域保存其id
            bindProjectDialogForXKZX("projectName", "hiddenId"); //多个项目的选择
            parent.hideLoading("总体货量分析");
        });


        function submitSearch(){
            parent.showLoading();
            $("#thisForm").submit();
        }
    </script>

    <script type="text/javascript">
        var chart1;
        var chart2;
        $(function () {

            $(document).ready(function() {
                chart1 = new Highcharts.Chart({
                    chart: {
                        renderTo: 'container1',
                        plotBackgroundColor: null,
                        plotBorderWidth: null,
                        plotShadow: false
                    },
                    title: {
                        text: '总套数比例'
                    },
                    tooltip: {
                        pointFormat: '<b>{point.percentage}%</b>',
                        percentageDecimals: 1
                    },
                    plotOptions: {
                        pie: {
                            allowPointSelect: true,
                            cursor: 'pointer',
                            /*dataLabels: {
                             enabled: true,
                             color: '#000000',
                             connectorColor: '#000000',
                             formatter: function() {
                             return '<b>'+ this.point.name +'</b>: <br/>'+ changeTwoDecimal(this.percentage) +' %';
                             }
                             }*/
                            dataLabels: {
                                enabled: false
                            },
                            showInLegend: true
                        }
                    },
                    series: [{
                        type: 'pie',
                        name: '总套数比例',
                        data: [
                            ['推出货量',   <s:property value="tchl_zts"  escape="false"/>],
                            ['总剩余货量', <s:property value="zsyhl_zts"  escape="false"/>]
                        ]
                    }]
                });
            });


            //总金额比例

            $(document).ready(function() {
                chart2 = new Highcharts.Chart({
                    chart: {
                        renderTo: 'container2',
                        plotBackgroundColor: null,
                        plotBorderWidth: null,
                        plotShadow: false
                    },
                    title: {
                        text: '总金额比例'
                    },
                    tooltip: {
                        pointFormat: '{series.name}: <b>{point.percentage}%</b>',
                        percentageDecimals: 1
                    },
                    plotOptions: {
                        pie: {
                            allowPointSelect: true,
                            cursor: 'pointer',
                            /*dataLabels: {
                             enabled: true,
                             color: '#000000',
                             connectorColor: '#000000',
                             formatter: function() {
                             return '<b>'+ this.point.name +'</b>: '+ changeTwoDecimal(this.percentage) +' %';
                             }
                             }*/
                            dataLabels: {
                                enabled: false
                            },
                            showInLegend: true

                        }
                    },
                    series: [{
                        type: 'pie',
                        name: '总金额比例',
                        data: [
                            ['推出货量',   <s:property value="tchl_zje"  escape="false"/>],
                            ['总剩余货量', <s:property value="zsyhl_zje"  escape="false"/>]
                        ]
                    }]
                });
            });
        });


    </script>
    <style type="text/css">
        td {height:26px}
    </style>
</head>
<body style="padding:0;background:white;">

<div class="right99"></div>
<form class="registerform" id="thisForm" method="post">
    <table width="100%" border="0" align="left" cellspacing="0">

        <tr>
            <td colspan="6">
                <label>&nbsp;<span>项目</span></label><input type="text" id="projectName"  size="40" name="propertyUnitCond.strSearchProjectNames" value="${propertyUnitCond.strSearchProjectNames}"/>
                <input type="hidden" id="hiddenId" name="propertyUnitCond.strSearchProjectIds" value="${propertyUnitCond.strSearchProjectIds}" />
                
		截止日期
		<input class="easyui-datebox" type="text" id="date2" style="width:90px" name="propertyUnitCond.date2" value="${propertyUnitCond.date2}"/>
                &nbsp;<input type="button" onclick="return submitSearch()" value=" 查询  "/>
                <!-- <a style="color:#1199FF;" href="#">下载</a>&nbsp; -->
                <div class="right99"></div>
                <div class="blueline"></div>
            </td>
        </tr>

        <!-- 搜索表单 end -->


        <tr>
            <td colspan="6" >

                <div class="gbox1">

                    <table width="680" border="0" align="left" cellpadding="0"
                           cellspacing="1" class="gbox" style="text-align: center;">

                        <tr class="gboxbg">
                            <th width="90">总货量</th>
                            <td width="90">总套数</td>
                            <td width="130">总面积(平方米)</td>
                            <td width="130">总金额(定价:万元)</td>
                            <td width="100">均价(元)</td>
                            <td width="100"></td>
                        </tr>
                        <tr onMouseOver="this.style.backgroundColor='#f1f9fe'"
                            onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF">
                            <td></td>
                            <td>${zhl_zts}</td>
                            <td>${zhl_zmj}</td>
                            <td>${zhl_zje}</td>
                            <td>${zhl_jj}</td>
                            <td></td>
                        </tr>

                        <tr class="gboxbg">
                            <th>推出货量</th>
                            <td >总套数</td>
                            <td >总面积(平方米)</td>
                            <td >总金额(定价:万元)</td>
                            <td >均价(元)</td>
                            <td></td>
                        </tr>
                        <tr onMouseOver="this.style.backgroundColor='#f1f9fe'"
                            onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF">
                            <td></td>
                            <td>${tchl_zts}</td>
                            <td>${tchl_zmj}</td>
                            <td>${tchl_zje}</td>
                            <td>${tchl_jj}</td>
                            <td></td>
                        </tr>

                        <tr class="gboxbg">
                            <th>总剩余货量</th>
                            <td >总套数</td>
                            <td >总面积(平方米)</td>
                            <td >总金额(定价:万元)</td>
                            <td >均价(元)</td>
                            <td >余货比例</td>
                        </tr>

                        <tr onMouseOver="this.style.backgroundColor='#f1f9fe'"
                            onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF">
                            <td></td>
                            <td>${zsyhl_zts}</td>
                            <td>${zsyhl_zmj}</td>
                            <td>${zsyhl_zje}</td>
                            <td>${zsyhl_jj}</td>
                            <td>${zsyhl_yhbl}%</td>
                        </tr>

                        <tr class="gboxbg">
                            <th>认购情况</th>
                            <td >成交套数</td>
                            <td >成交面积(平方米)</td>
                            <td >成交金额(万元)</td>
                            <td >均价(元)</td>
                            <td ></td>
                        </tr>

                        <tr onMouseOver="this.style.backgroundColor='#f1f9fe'"
                            onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF">
                            <td></td>
                            <td>${rgqk_cjts}</td>
                            <td>${rgqk_cjmj}</td>
                            <td>${rgqk_cjje}</td>
                            <td>${rgqk_jj}</td>
                            <td></td>
                        </tr>

                        <tr class="gboxbg">
                            <th>已签约情况</th>
                            <td >签约套数</td>
                            <td >签约面积(平方米)</td>
                            <td >签约金额(万元)</td>
                            <td >均价(元)</td>
                            <td >签约率</td>
                        </tr>

                        <tr onMouseOver="this.style.backgroundColor='#f1f9fe'"
                            onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF">
                            <td></td>
                            <td>${yqyqk_qyts}</td>
                            <td>${yqyqk_qymj}</td>
                            <td>${yqyqk_qyje}</td>
                            <td>${yqyqk_jj}</td>
                            <td>${yqyqk_qyl}</td>
                        </tr>

                        <tr class="gboxbg">
                            <th>未签约情况</th>
                            <td >未签约套数</td>
                            <td >未签约面积(平方米)</td>
                            <td >未签约金额(万元)</td>
                            <td >均价(元)</td>
                            <td></td>
                        </tr>

                        <tr onMouseOver="this.style.backgroundColor='#f1f9fe'"
                            onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF">
                            <td></td>
                            <td>${wqyqk_wqyts}</td>
                            <td>${wqyqk_wqymj}</td>
                            <td>${wqyqk_wqyje}</td>
                            <td>${wqyqk_jj}</td>
                            <td></td>
                        </tr>



                        <tr class="gboxbg">
                            <th>推出剩余货量</th>
                            <td >总量</td>
                            <td >面积(平方米)</td>
                            <td >金额(万元)</td>
                            <td >均价(元)</td>
                            <td >剩余率</td>
                        </tr>

                        <tr onMouseOver="this.style.backgroundColor='#f1f9fe'"
                            onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF">
                            <td></td>
                            <td>${tcsyhl_zl}</td>
                            <td>${tcsyhl_mj}</td>
                            <td>${tcsyhl_je}</td>
                            <td>${tcsyhl_jj}</td>
                            <td>${tcsyhl_syl}</td>
                        </tr>
                    </table>
                </div>

            </td>
        </tr>
        <tr>
            <td colspan="6">

                <table border="0" align="left" >
                    <tr>
                        <td>
                            <div id="container1" style="min-width: 330px; height: 300px; margin: 0 auto;border-color:#a6d8ff;border-style:solid; border-width:1px;"></div>

                        </td>
                        <td>
                            <div id="container2" style="min-width: 330px; height: 300px; margin: 0 auto;border-color:#a6d8ff;border-style:solid; border-width:1px;"></div>
                        </td>
                    </tr>
                </table>


            </td>
        </tr>

    </table>
</form>
</body>
</html>
