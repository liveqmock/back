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
<title></title>
<s:include value="../../header/header_easyui.jsp"></s:include>
<s:include value="coder_header.jsp"></s:include>
</head>

<body  style="padding:10px;">
<b>柱状图说明：</b>

<br/>

<p></p>
<b>参考：</b><br/>
report12.jsp
<br/>
<p></p>
<b>主要代码说明：</b>
<br/>
<br/>
<b>代码示例：</b><br/>
<textarea rows="40" cols="150">
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

</textarea>
<br/>

</body>
</html>

