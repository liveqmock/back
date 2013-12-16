<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<script type="text/javascript">
    $(function () {
        var categories = <s:property value="categories"  escape="false"/>;
        var data = <s:property value="data"  escape="false"/>;
        var endDate = '<s:property value="endDate"  escape="false"/>';
        var title = '应收佣（前五名）';
        var subtitle = '截止日期：' + endDate;
        var yAxis = '货量 (亿元)';   //Y轴描述
        var series = '公司';       //分组描述
        var pointunit = '亿元' ;     //柱子描述单元
                                                                 
        /*$('#char_report14').highcharts({
            chart: {
                type: 'column'
            },
            title: {
                text: title
            },
            subtitle: {
                text: subtitle
            },
            xAxis: {
                categories:categories
            },
            yAxis: {
                min: 0,
                title: {
                    text: yAxis
                }
            },
            tooltip: {
                headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
                pointFormat: '<tr><td style="padding:0">{series.name}:{point.y:.1f} '+pointunit+' </td></tr>',
                footerFormat: '</table>',
                shared: true,
                useHTML: true
            },
            plotOptions: {
                column: {
                    pointPadding: 0.2,
                    borderWidth: 0,
                    minPointLength:15,
                    color:'#ff8908'
                }
            },
            series: [{
                name: series,
                data: data
            }   ]
        });*/
    });


</script>

<div id="char_report14" style="height: 210px; margin: 0 auto;">本功能正在开发中。</div>
            
            
            
            
