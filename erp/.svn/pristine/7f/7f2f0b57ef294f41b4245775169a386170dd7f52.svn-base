<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<script type="text/javascript">
    $(function () {
        var categories = <s:property value="categories"  escape="false"/>;
        var data = <s:property value="data"  escape="false"/>;
        var endDate = '<s:property value="endDate"  escape="false"/>';
        var title = '总货量（前五名）';
        var subtitle = '截止日期：' + endDate;
        var yAxis = '单位(亿元)';   //Y轴描述
        var series = '货量';       //分组描述
        var pointunit = '亿元' ;     //柱子描述单元

        //处理金额，元-->亿元,保留2位小数，四舍五入
        for(var i=0;i<data.length;i++){
            data[i]= Math.round(parseInt(data[i])/1000000)/100;
        }

        $('#char_report12').highcharts({
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
                categories:categories,
                labels: {
                    rotation:0,
                    formatter:function() {
                        var vlen = this.value.length;
                        var xlabel = this.value;

                        if(vlen>4){
                            xlabel = xlabel.substring(0,4)+"...";
                        }

                        return xlabel;
                    }
                }

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
                pointFormat: '<tr><td style="padding:0">{point.y:.1f} '+pointunit+' </td></tr>',
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
                    color:'#ff0000',
                    connectNulls:false
                }
            },
            series: [{
                name: series,
                data: data
            }   ]
        });
    });


</script>

<div id="char_report12" style="height: 210px; margin: 0 auto;"></div>
            
            
            
            
            