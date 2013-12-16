/**
 * Created with IntelliJ IDEA.
 * User: Lenovo
 * Date: 13-4-16
 * Time: 下午4:43
 * 业绩排行榜.
 */

var char_yeji;

$(document).ready(function() {

    function setChart(name, categories, data, color) {
        char_yeji.xAxis[0].setCategories(categories, false);
        char_yeji.series[0].remove(false);
        char_yeji.addSeries({
            name: name,
            data: data,
            color: color || 'white'
        }, false);
        char_yeji.redraw();
    }


    char_yeji = new Highcharts.Chart({
        chart: {
            renderTo: 'char_yeji',
            type: 'bar',
            marginRight:100
        },
        title: {
            text: '业绩排行榜'
        },
        subtitle: {
            text: ''
        },
        xAxis: {
            categories: categories
        },
        yAxis: {
            title: {
                text: '' //单位:亿元(人民币)
            }
        },

        plotOptions: {
            bar: {
                groupPadding:0,
                pointPadding:0.1,
                borderWidth: 0,
                pointWidth:15, //设置柱子的宽度
                //color:'#c35f5c',
                connectNulls:false,
                minPointLength:5,


                cursor: 'pointer',
                point: {
                    events: {
                        click: function() {
                            var drilldown = this.drilldown;
                            if (drilldown) { // drill down
                                setChart(drilldown.name, drilldown.categories, drilldown.data, drilldown.color);
                            } else { // restore
                                setChart(name, categories, data_yeji);
                            }
                        }
                    }
                },
                dataLabels: {
                    align:"left",
                    enabled: true,
                    color: colors[0],

                    style: {
                        fontWeight: 'bold'
                    },
                    formatter: function() {
                        var point = this.point;
                        var s ="";
                        if (point.drilldown) {
                            s = this.y+"亿元";
                        }else{
                            s = Highcharts.numberFormat(this.y, 0, ',')+"元";
                        }
                        return s;
                    }
                }

            }

        },
        tooltip: {
            formatter: function() {
                var point = this.point,
                    s = this.x +':<b>'+ this.y +'亿元</b><br/>';
                if (point.drilldown) {
                    s += '点击查看 '+ point.category +' 项目明细';
                } else {
                    s = this.x +':<b>'+ Highcharts.numberFormat(this.y, 0, ',')  +'元</b><br/>';
                    s += '点击返回';
                }
                return s;
            }
        },
        credits: {
            enabled: false
        },
        series: [{
            name: '业绩排行榜',
            data: data_yeji,
            color: 'white'
        }]
    });
});
