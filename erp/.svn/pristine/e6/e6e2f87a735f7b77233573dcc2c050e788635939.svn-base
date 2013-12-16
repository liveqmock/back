/**
 * 界面调整的js
 */
 
//显示格式为每千位一逗号
function  commafy(num)
{  
   num  =  num+"";  
   var  re=/(-?\d+)(\d{3})/  
   while(re.test(num))
   {  
     num=num.replace(re,"$1,$2")  
   }  
   return  num;  
}	

//千位逗号格式的取消
function  commafyback(num)
{  
   var x = num.split(',');
   return parseFloat(x.join(""));
}    

//保留两位小数
function changeTwoDecimal(x)
{
	var f_x = parseFloat(x);
	if (isNaN(f_x))
	{
	alert('function:changeTwoDecimal->parameter error'+x);
	return false;
	}
	var f_x = Math.round(x*100)/100;
	
	return f_x;
}








