<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<script type="text/javascript">
    $(function () {
        var categories = <s:property value="categories"  escape="false"/>;
        var data = <s:property value="data"  escape="false"/>;
        var data2 = <s:property value="data2"  escape="false"/>;
        var data3 = <s:property value="data3"  escape="false"/>;
        var endDate = '<s:property value="endDate"  escape="false"/>';
        var newDate = new Date(endDate);
        var month = newDate.getMonth()+1;
        var title = month + '月销量（前五名）';
        var subtitle = '截止日期：' + endDate;
        var yAxis = ' ';   //Y轴描述
        var series1 = '金额';       //分组描述
        var series2 = '面积';       //分组描述
        var series3 = '套数';       //分组描述
        var pointunit = '亿元' ;     //柱子描述单元
        var pointunit2 = '㎡' ;     //柱子描述单元
        var pointunit3 = '套' ;     //柱子描述单元

        //处理金额，元-->亿元,保留2位小数，四舍五入
        for(var i=0;i<data.length;i++){
            data[i]= Math.round(parseInt(data[i])/1000000)/100;
        }
        /*for(var i=0;i<data2.length;i++){
         data2[i]= Math.round(parseInt(data2[i]))/100;
         }*/

        $('#char_report13').highcharts({
            chart: {
                zoomType: 'xy'
            },
            title: {
                text: title
            },
            subtitle: {
                text: subtitle
            },
            xAxis: {
                categories:categories ,

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
            yAxis:
                [{
                    min: 0,
                    title: {
                        text: yAxis
                    }
                }]

             ,
            /*tooltip: {
             headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
             pointFormat: '<tr><td style="padding:0">{series.name}:{point.y:.1f} </td></tr>',
             footerFormat: '</table>',
             shared: true,
             useHTML: true
             },*/
            plotOptions: {
                column: {
                    pointPadding: 0.1,
                    borderWidth: 0,
                    minPointLength:2

                }
            },
            series: [{
                name: series1,
                type:'column',
                color: '#4572A7',
                data: data,
                visible: true,
                tooltip: {
                    headerFormat: '<span style="font-size:12px">{point.key}</span><br><table>',
                    pointFormat: '<tr><td style="padding:0">{series.name}:{point.y:.1f} '+pointunit+'  </td></tr>',
                    footerFormat: '</table>',
                    shared: true,
                    useHTML: true
                }

            },{
                name: series2,
                color: '#AA4643',
                type:'column',
                data: data2,
                visible: false,
                tooltip: {
                    headerFormat: '<span style="font-size:12px">{point.key}</span><br><table>',
                    pointFormat: '<tr><td style="padding:0">{series.name}:{point.y:.1f} '+pointunit2+'  </td></tr>',
                    footerFormat: '</table>',
                    shared: true,
                    useHTML: true
                }
            },{
                name: series3,
                color: '#89A54E',
                type:'column',
                data: data3,
                visible: false,
                tooltip: {
                    headerFormat: '<span style="font-size:12px">{point.key}</span><br><table>',
                    pointFormat: '<tr><td style="padding:0">{series.name}:{point.y} '+pointunit3+'  </td></tr>',
                    footerFormat: '</table>',
                    shared: true,
                    useHTML: true
                }
            }
            ]
        });
    });


</script>

<div id="char_report13" style="height: 210px; margin: 0 auto;"></div>
            
            
            
            
