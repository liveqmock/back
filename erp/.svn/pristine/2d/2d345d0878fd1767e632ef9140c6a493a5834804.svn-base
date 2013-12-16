<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<script type="text/javascript">
    $(function () {
        var categories = <s:property value="categories"  escape="false"/>;
        var custdata = <s:property value="data"  escape="false"/>;
        var endDate = '<s:property value="endDate"  escape="false"/>';
        var yAxis = '单位(人) ';   //Y轴描述
        var title = '最近5天售前客户趋势';
        var subtitle = '截止日期：' + endDate;

        var series = '客户';       //分组描述
        var pointunit = '人' ;     //柱子描述单元


        for(var i=0;i<custdata.length;i++){
            custdata[i]= parseInt(custdata[i]);
        }



        $('#char_report36').highcharts({
            chart: {
                type: 'line'
            },
            title: {
                text: title,
                x: -20 //center
            },
            subtitle: {
                text: subtitle,
                x: -20
            },
            xAxis: {
                categories: categories,
                labels: {
                    rotation:0,
                    formatter:function() {
                        var vlen = this.value.length;
                        var xlabel = this.value;

                        if(vlen>4){
                            xlabel = xlabel.substring(5,vlen);
                        }

                        return xlabel;
                    }
                }
            },
            yAxis: {
                lineWidth: 1,
                tickWidth: 1,
                title: {
                    align: 'high',
                    offset: -30,
                    text: yAxis,
                    rotation: 0,
                    y: -14
                },
                plotLines: [{
                    value: 0,
                    width: 1,
                    color: '#808080'
                }]
            },
            tooltip: {
                valueSuffix: pointunit
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
            series: [{
                name: series,
                data: custdata
            }]
        });
    });


</script>

<div id="char_report36" style="height: 210px; margin: 0 auto;"></div>
            
            
            
            
