
var chart_show;  
/**
 * 显示highcharts(支持多条曲线的情况)
 * chartdata 的格式为:
 * Categories,Apples,Pears,Oranges,Bananas;John,8,4,6,5;Jane,3,4,2,3
 */
function showHighCharts(chartdata,options){
    var lines = chartdata.split(';');
    
    //data数据填充到option中
    $.each(lines, function(lineNo, line) {
    	
        var items = line.split(',');
        if (lineNo == 0) {
            $.each(items, function(itemNo, item) {
                if (itemNo > 0) options.xAxis.categories.push(item);//第一个分隔符前的字符串忽略Categories
            });
        }			        
        else {
        
            var series = {
                data: []
            };
            $.each(items, function(itemNo, item) {
                if (itemNo == 0) {
                    series.name = item;
                } else {
                    series.data.push(parseFloat(item));
                }
            });
            
            options.series.push(series);
    
        }
    });
				
    chart_show = new Highcharts.Chart(options);				
}