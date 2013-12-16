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
    <title>销售货量分析（按价格）</title>
    <s:include value="header_report.jsp"></s:include>
    <script type="text/javascript" src="<%=basePath%>js/highcharts.js"></script>
    <script type="text/javascript">

        $().ready(function() {
            //projectListForHiddenId("projectName", "hiddenId"); //项目的联想框,及用隐藏域保存其id
            bindProjectDialogForXKZX("projectName", "hiddenId"); //多个项目的选择
            parent.hideLoading("销售货量分析(按价格)");
            //单价区间比例
            var chart1;

            chart1 = new Highcharts.Chart({
                chart: {
                    renderTo: 'container1',
                    plotBackgroundColor: null,
                    plotBorderWidth: null,
                    plotShadow: false
                },
                title: {
                    text: '单价区间_套数比例'
                },
                tooltip: {
                    pointFormat: '{series.name}: <b>{point.percentage}%</b>',
                    percentageDecimals: 1
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
                    name: 'Browser share',
                    data: [
								<s:property value="chartSeriesData_DJ"  escape="false"/>
                    ]
                }]
            });


            //总价区间比例
            var chart2;

            chart2 = new Highcharts.Chart({
                chart: {
                    renderTo: 'container2',
                    plotBackgroundColor: null,
                    plotBorderWidth: null,
                    plotShadow: false
                },
                title: {
                    text: '总价区间_套数比例'
                },
                tooltip: {
                    pointFormat: '{series.name}: <b>{point.percentage}%</b>',
                    percentageDecimals: 1
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
                    name: 'Browser share',
                    data: [
								<s:property value="chartSeriesData_ZJ"  escape="false"/>
                    ]
                }]
            });

        });
        
        $(function(){
		$('#tbForm').datagrid({
                width: 1215,
                height: 380,
                nowrap: true,//是否只显示一行，即文本过多是否省略部分。  
                striped: true,  
                sortName: 'parentID',  
                sortOrder: 'desc', 
                idField:'nodeID', 
                loadMsg:'数据加载中...', 
                url:'./customer/report_json/searchxshlfxJg.action',
                rownumbers: true,
                fitColumns: false, //取消自适应列宽
                frozenColumns:[[  
                ]], 
                columns: [[
                    {title:'产品类型',colspan:1 },
                    {title:' ',colspan:1 },
                    {title:'总货量',colspan:4 },
                    {title:'推出货量',colspan:4 },
                    {title:'总剩余货量',colspan:5 },
                    {title:'认购情况', colspan:4 },
                    {title:'已签约情况', colspan:5 },
                    {title:'未签约情况', colspan:4 },
                    {title:'推出剩余货量', colspan:5 }
                ],[ 
                    {field:'xs0',title:'类别',width:65,rowspan:1,align:'center'},
                    {field:'xs1',title:'价格区间',width:100,rowspan:1,align:'center'},
                    {field:'xs2',title:'总套数',width:68,rowspan:1,align:'center'},
                    {field:'xs3',title:'总面积(平方米)',width:88,rowspan:1,align:'center'},
                    {field:'xs4',title:'总金额(定价:万元)',width:130,rowspan:1,align:'center'},
                    {field:'xs5',title:'均价',width:68,rowspan:1,align:'center'},
                    
                    {field:'xs6',title:'总套数',width:68,rowspan:1,align:'center'},
                    {field:'xs7',title:'总面积(平方米)',width:88,rowspan:1,align:'center'},
                    {field:'xs8',title:'总金额(定价:万元)',width:130,rowspan:1,align:'center'},
                    {field:'xs9',title:'均价',width:68,rowspan:1,align:'center'},
                    
                    {field:'xs10',title:'总套数',width:68,rowspan:1,align:'center'},
                    {field:'xs11',title:'总面积(平方米)',width:88,rowspan:1,align:'center'},
                    {field:'xs12',title:'总金额(定价:万元)',width:130,rowspan:1,align:'center'},
                    {field:'xs13',title:'均价',width:68,rowspan:1,align:'center'},
                    
                    {field:'xs14',title:'余货比例',width:72,rowspan:1,align:'center'},
                    {field:'xs15',title:'成交套数',width:72,rowspan:1,align:'center'},
                    {field:'xs16',title:'成交面积(平方米)',width:100,rowspan:1,align:'center'},
                    {field:'xs17',title:'成交金额(万元)',width:95,rowspan:1,align:'center'},
                    {field:'xs18',title:'均价',width:68,rowspan:1,align:'center'},
                    
                    {field:'xs19',title:'签约套数',width:72,rowspan:1,align:'center'},
                    {field:'xs20',title:'签约面积(平方米)',width:100,rowspan:1,align:'center'},
                    {field:'xs21',title:'签约金额(万元)',width:95,rowspan:1,align:'center'},
                    {field:'xs22',title:'均价',width:68,rowspan:1,align:'center'},
                    {field:'xs23',title:'签约率',width:72,rowspan:1,align:'center'},
                    {field:'xs24',title:'未签约套数',width:76,rowspan:1,align:'center'},
                    {field:'xs25',title:'未签约面积',width:76,rowspan:1,align:'center'},
                    {field:'xs26',title:'未签约金额',width:76,rowspan:1,align:'center'},
                    {field:'xs27',title:'均价',width:68,rowspan:1,align:'center'},
                    
                    {field:'xs28',title:'总量',width:50,rowspan:1,align:'center'},
                    {field:'xs29',title:'面积',width:50,rowspan:1,align:'center'},
                    {field:'xs30',title:'金额',width:50,rowspan:1,align:'center'},
                    {field:'xs31',title:'均价',width:50,rowspan:1,align:'center'},
                    {field:'xs32',title:'剩余率',width:60,rowspan:1,align:'center'}
                ]],
                pagination:false, //不包含分页  
                rownumbers:true,  
	            singleSelect:true
            });
            });

        function submitSearch() {
	          $("#thisForm").submit();
        }
        
        function exportMessage(){
				$(function(){
					$('#exportFm').form({
						url:'./saleunit_new_report/report/guangzhou/xshlfxJgdownload.action'
					});
					$('#exportFm').submit();  
				});
		}
			
		//查看项目列定义
		function query() {
			$('#openjgIframe')[0].src="./saleunit_new_report/report/guangzhou/queryXshlfxJgJ.action";
			$('#queryjg').window('open');  
		}
    </script>
</head>
<body  style="padding:0px;background:white;">

<div class="right99"></div>

    <table width="1000px" border="0" align="left" cellspacing="0">

        <tr>
            <td colspan="6">
            <form class="registerform" id="thisForm" method="post">
            	<label>&nbsp;<span>项目</span> </label>
                <input type="text" id="projectName" size="40" name="propertyUnitCond.strSearchProjectNames" value="${propertyUnitCond.strSearchProjectNames}" />
                <input type="hidden" id="hiddenId" name="propertyUnitCond.strSearchProjectIds" value="${propertyUnitCond.strSearchProjectIds}" />

                </select> 截止日期<input
                        class="easyui-datebox" type="text" style="width:90px"
                        name="propertyUnitCond.date2" value="${propertyUnitCond.date2}" /> &nbsp;<input
                        type="button" onclick="return submitSearch()" value=" 查询  " />
                <div class="right99"></div>
                <div class="blueline"></div>
            </form>
            <form id="exportFm" method="post">
            	<input style="float:left;margin-left:460px;margin-top:-33px;" type="button" onclick="return exportMessage()" value="导出" />
            	<a class="easyui-linkbutton" style="float:left;margin-left:518px;margin-top:-33px;" iconCls="icon-search" href="javascript:void(0);" onclick="query()">查看项目列定义</a>
            </form>
            </td>
        </tr>

        <!-- 搜索表单 end -->


        <tr>
            <td colspan="6">

                <div class="gbox1">
					<table id="tbForm" > </table>
                    <!--<table width="2100px" border="0" align="center" cellpadding="0"
                           cellspacing="1" class="gbox" style="text-align: center;">
                        <tr class="gboxbg">
                            <th>产品类型</th>
                            <th>&nbsp;</th>
                            <th colspan="4">总货量</th>
                            <th colspan="4">推出货量</th>
                            <th colspan="5">总剩余货量</th>
                            <th colspan="4">认购情况</th>
                            <th colspan="5">已签约情况</th>
                            <th colspan="4">未签约情况</th>
                            <th colspan="5">推出剩余货量</th>
                        </tr>
                        <tr class="gboxbg">
                            <th>类别</th>
                            <th>价格区间</th>
                            <th>总套数</th>
                            <th>总面积(平方米)</th>
                            <th>总金额（定价:万元）</th>
                            <th>均价</th>
                            <th>总套数</th>
                            <th>总面积(平方米)</th>
                            <th>总金额（定价:万元）</th>
                            <th>均价</th>
                            <th>总套数</th>
                            <th>总面积(平方米)</th>
                            <th>总金额（定价:万元）</th>
                            <th>均价</th>
                            <th>余货比例</th>
                            <th>成交套数</th>
                            <th>成交面积(平方米)</th>
                            <th>成交金额(万元)</th>
                            <th>均价</th>
                            <th>签约套数</th>
                            <th>签约面积(平方米)</th>
                            <th>签约金额(万元)</th>
                            <th>均价</th>
                            <th>签约率</th>
                            <th>未签约套数</th>
                            <th>未签约面积</th>
                            <th>未签约金额</th>
                            <th>均价</th>
                            <th>总量</th>
                            <th>面积</th>
                            <th>金额</th>
                            <th>均价</th>
                            <th>剩余率</th>
                        </tr>
                        <s:property value="showTrs"  escape="false"/>
                    </table>-->
                </div>


                <div class="gbox1">
                    <table>
                        <tr><td>
                            <div id="container1" style=" margin: 0 auto"></div>

                        </td>
                            <td>
                                <div id="container2" style=" margin: 0 auto"></div>
                            </td>
                        </tr>
                    </table>

                </div>
            </td>
        </tr>

    </table>

<!-- 弹出查看项目列定义页面 -->
	<div id="queryjg" class="easyui-window" title="查看项目列定义" style="width: 530px;height:310px;"
    		 closed="true" maximizable="false" minimizable="false" collapsible="false">
    		   <iframe scrolling="yes" id='openjgIframe' frameborder="0"  src="" style="width:100%;height:100%;"></iframe>
    </div>
</body>
</html>
