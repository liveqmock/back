/**
 * Created with IntelliJ IDEA.
 * User: Lenovo
 * Date: 13-4-16
 * Time: 下午5:25
 * To change this template use File | Settings | File Templates.
 */
var chart;
$(document).ready(function() {
    chart = new Highcharts.Chart({
        chart: {
            renderTo: 'container',
            defaultSeriesType: 'spline'
        },
        title: {
            text: '最近7天来访客户情况'
        },
        xAxis: {
            categories: categories_value

        },
        yAxis:
        {
            allowDecimals: false,min:0,
            title: {
                text: '人数'
            },
            plotLines: [{
                value: 0,
                width: 1,
                color: '#808080'
            }]
        }
        ,
        legend: {
            layout: 'vertical',
            backgroundColor: '#FFFFFF',
            x: 100,
            y: 70,
            floating: true,
            shadow: true
        },
        tooltip: {
            formatter: function() {
                var tips = ''+this.x +' ' + this.series.name +' :'+ commafy(this.y);
                if(this.series.name=="来电"){
                    tips += '组';
                }

                return tips;
            }
        },
        plotOptions: {
            spline: {
                dataLabels: {
                    enabled: true
                },
                enableMouseTracking: true
            }
        },

        series: series_value

    });


});