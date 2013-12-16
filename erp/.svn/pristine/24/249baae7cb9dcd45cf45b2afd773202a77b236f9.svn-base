/**
 *关于日期时间的帮助类
 *
 */

/**
 * 格式化日期
 */
function formatDate(formatDate, formatString) {  
    if(formatDate instanceof Date) {  
        var months = new Array("Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec");  
        var yyyy = formatDate.getFullYear();  
        var yy = yyyy.toString().substring(2);  
        var m = formatDate.getMonth()+1;  
        var mm = m < 10 ? "0" + m : m;  
        var mmm = months[m];  
        var d = formatDate.getDate();  
        var dd = d < 10 ? "0" + d : d;  
   
        var h = formatDate.getHours();  
        var hh = h < 10 ? "0" + h : h;  
        var n = formatDate.getMinutes();  
        var nn = n < 10 ? "0" + n : n;  
        var s = formatDate.getSeconds();  
        var ss = s < 10 ? "0" + s : s;  
        
        if(formatString==null){
        	formatString = "yyyy-MM-dd";
        }
   
        formatString = formatString.replace(/yyyy/i, yyyy);  
        formatString = formatString.replace(/yy/i, yy);  
        formatString = formatString.replace(/mmm/i, mmm);  
        formatString = formatString.replace(/mm/i, mm);  
        formatString = formatString.replace(/m/i, m);  
        formatString = formatString.replace(/dd/i, dd);  
        formatString = formatString.replace(/d/i, d);  
        formatString = formatString.replace(/hh/i, hh);  
        formatString = formatString.replace(/h/i, h);  
        formatString = formatString.replace(/nn/i, nn);  
        formatString = formatString.replace(/n/i, n);  
        formatString = formatString.replace(/ss/i, ss);  
        formatString = formatString.replace(/s/i, s);  
   
        return formatString;  
    } else {  
        return "";  
    }  
}

/**
 * 日期所在月份的最后一天
 * @param date
 */
function getMonthLastDate(date){
	return new Date(date.getFullYear(), date.getMonth()+1, 0); 
}
    
/**
 * 设置两个日期控件的值
 * typeName:(周以星期天开始
 * (thisweek:本周,thismonth:本月,thisquarter:本季,thisyear:本年,today:今天,lastweek:上周,lastmonth:上月,lastquarter:上季,lastyear:上年,
 * last2week:上二周,last2month:上二月,clear:清空)
 * beginDateObject:开始日期easyui-datebox
 * endDateObject:结束日期easyui-datebox
 */
function setTwoDatebox(typeName,beginDateObject,endDateObject){
	var beginTime;
	var endTime;
	var now = new Date();
	var month = now.getMonth();
	var year = now.getFullYear();
	var day = now.getDate();
	var wday = now.getDay();	
	
	switch(typeName){
		case "thisweek": //本周
		var day  = now.getDay();
		now.setDate(now.getDate() - (day));
		beginTime = formatDate(now);		
		now.setDate(now.getDate() + 6);
		endTime = formatDate(now);
		break;
		
		case "thismonth":  //本月
		now.setDate(1);
		beginTime = formatDate(now);
		endTime = formatDate(getMonthLastDate(now));
		break;
		
		case "thisquarter":   //本季
		var m = now.getMonth() + 1;
		var q = parseInt((m + 2 ) / 3 ); //得到第几季
		m = q * 3 - 2;  //得到季的首月份		
		now.setMonth(m-1);
		now.setDate(1);
		beginTime = formatDate(now);
		
		now.setMonth(now.getMonth() + 3);
		now.setDate(0);
		endTime = formatDate(now);
		break;
		case "thisyear":    //本年
		now.setMonth(0);
		now.setDate(1);
		beginTime = formatDate(now);
		
		now.setMonth(11);
		now.setDate(31);
		endTime = formatDate(now);        
		break;
		case "today":    //今天
		beginTime = formatDate(now);
		endTime = beginTime;
		break;
		case "lastweek":    //上周
		var day  = now.getDay();
		now.setDate(now.getDate() - (day -1) - 7 );
		beginTime = formatDate(now);
		
		now.setDate(now.getDate() + 6);
		endTime = formatDate(now);
		
		break;
		case "lastmonth":    //上月
		now.setDate(1);
		now.setMonth(now.getMonth() -1 );
		beginTime = formatDate(now);
		
		var days = getDays(now);
		now.setDate(days);
		endTime = formatDate(now);
		break;
		case "lastquarter":    //上季
		var m = now.getMonth() + 1;
		var q = parseInt((m + 2 ) / 3 ); //得到第几季
		m = q * 3 - 2;  //得到季的首月份
		
		m = m-3 ; //上季
		now.setMonth(m-1);
		now.setDate(1);
		beginTime = formatDate(now);
		
		now.setMonth(now.getMonth() + 3);
		now.setDate(0);
		endTime = formatDate(now);        
		break;
		case "lastyear":    //上年
		now.setFullYear(now.getFullYear() -1 );
		now.setMonth(0);
		now.setDate(1);
		beginTime = formatDate(now);
		
		now.setMonth(11);
		now.setDate(31);
		endTime = formatDate(now);            
		break;
		case "last2week":    //上二周
		var day  = now.getDay();
		now.setDate(now.getDate() - (day -1) - 7 *2);
		beginTime = formatDate(now);
		
		now.setDate(now.getDate() + 6 + 7);
		endTime = formatDate(now);            
		break;
		case "last2month":    //上二月
		now.setDate(1);
		now.setMonth(now.getMonth() -1*2 );
		beginTime = formatDate(now);
		
		now.setMonth(now.getMonth() + 2);
		now.setDate(0);
		endTime = formatDate(now);
		break;
		case "clear":    //清空
		beginTime = "";
		endTime = "";
		break;
		
		default: 
		alert("setTwoDatebox:参数错误typeName");
		break;
	}

	beginDateObject.datebox("setValue",beginTime);
	endDateObject.datebox("setValue",endTime);
}