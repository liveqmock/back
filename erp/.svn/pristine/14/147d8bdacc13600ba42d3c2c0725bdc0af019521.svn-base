/**
 *  共用的自动获取时间
 */
function nowTime(id){

	//setInterval(getNowTime(), 1000); //重写setInterval方法,让其可以接收参数,默认的setInterval是不能接收参数的
	window.setInterval(function(){
		getNowTime(id);}, 1000);
}

function getNowTime(id){
	var nowTime = new Date();
	var hh = "0" + nowTime.getHours();
	var mm = "0" + nowTime.getMinutes();
	var ss = "0" + nowTime.getSeconds();
	var showNowTime = hh.substring(hh.length-2) + ":" + mm.substring(mm.length-2) + ":" + ss.substring(ss.length-2);
	var getEle = document.getElementById(id);
	if(getEle != null){
		getEle.innerHTML = showNowTime;
	}
}