<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<script type="text/javascript">
    $(function () {
        var categories = <s:property value="categories"  escape="false"/>;
        var custdata = <s:property value="data"  escape="false"/>;
        var endDate = '<s:property value="endDate"  escape="false"/>';
        var yAxis = '单位(万) ';   //Y轴描述
        var title = '销售人员业绩（前五名）';
        var subtitle = '截止日期：' + endDate;

        var series = '销售业绩';       //分组描述
        var pointunit = '万' ;     //柱子描述单元

        for(var i=0;i<custdata.length;i++){
            custdata[i]= parseInt(custdata[i]);
        }


        $('#char_report33').highcharts({
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

                lineWidth: 1,
                tickWidth: 1,
                title: {
                    align: 'high',
                    offset: -30,
                    text: yAxis,
                    rotation: 0,
                    y: -14
                }
            },
            tooltip: {
                headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
                pointFormat: '<tr><td style="padding:0">{series.name}:{point.y} '+pointunit+' </td></tr>',
                footerFormat: '</table>',
                shared: true,
                useHTML: true
            },
            legend: {
                layout: 'vertical',
                align: 'left',
                verticalAlign: 'top',
                x: -100,
                y: 0,
                borderWidth: 0,
                enabled:false
            },
            plotOptions: {
                column: {
                    pointPadding: 0.2,
                    borderWidth: 0,
                    minPointLength:2,
                    color:'#ff8908'
                }
            },
            series: [{
                name: series,
                data: custdata
            }]

        });
    });


</script>

<div id="char_report33" style="height: 210px; margin: 0 auto;"></div>
            
            
            
            
