 
 function moveForId(moveid,movediv){
	//moveid 响应的
	 //movediv 移动的
	
	 		var bool = false;
			    var offsetX = 0;
			    var offsetY = 0;
			    var divid ;
			$("#"+moveid).mousedown(function(event) {//绑定事件的控件
	            bool = true;
	            divid = movediv;//移动的控件
	            offsetX = event.offsetX ? event.offsetX : event.layerX;
	            offsetX = offsetX ;

	            offsetY = event.offsetY ? event.offsetY : event.layerY;
	            offsetY = offsetY ;
	        
	        })
	        .mouseup(function() {
	            bool = false;
	        })
	        
	        $(document).mousemove(function(event) {
            if (!bool) {
                return;
            }
            else {
           
                var x = event.clientX - offsetX;
                var y = event.clientY - offsetY;
                $("#"+divid).css("position", "absolute");
                $("#"+divid).css("left", x);
                $("#"+divid).css("top", y);
            }
        })
}