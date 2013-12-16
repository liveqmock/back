function unitInfomation(){
	//evdom 那里响应事件 用来得到显示DIV的坐标

	if(!$("#unitinfomation").is('div')){
		mybg = document.createElement("div");
		mybg.setAttribute("id","unitinfomation");
		mybg.style.position = "absolute";
		mybg.style.top = "0";
		mybg.style.left = "0";
		mybg.style.zIndex = "-1000";
		document.body.appendChild(mybg);
		// document.body.style.overflow = "hidden";
	}
	$("td[uid]").click(function(){
	
		var offset = $(this).offset();
		 $.ajax({ //请求登录处理页
             url: "./property/unit/unit_infomation.action", //登录处理页
             dataType: "html",
             //传送请求数据
             data: "unitId="+$(this).attr("uid"),
             success: function(strValue) { //登录成功后返回的数据
                 //根据返回值进行状态显示
			 $("#unitinfomation").html("");
			 $("#unitinfomation").html(strValue);
			 $("#unitinfomation").css("display","block");
			 $("#close").click(function(){
			 $("#unitinfomation").css("display","none")
				 
			 });
			 $("#buildId").val($("#getbuildid").val().toString());
			 $('#unitform').submit(function() {    
		         // submit the form    
				
		         $(this).ajaxSubmit();     //......为什么要刷新呢
		         // return false to prevent normal browser submit and page navigation    
		         window.location.reload();
		         return false;
		       
		         
		        });
             }
         })
		
		 $("#unitinfomation").css("z-index","500");
		 $("#unitinfomation").css("top",offset.top-50);
		 $("#unitinfomation").css("left",offset.left);
	}); 
	
}

//显示全部信息
function unitInfomation2(){
	//evdom 那里响应事件 用来得到显示DIV的坐标

	if(!$("#unitinfomation").is('div')){
		mybg = document.createElement("div");
		mybg.setAttribute("id","unitinfomation");
		mybg.style.position = "absolute";
		mybg.style.top = "0";
		mybg.style.left = "0";
		mybg.style.zIndex = "-1000";
		document.body.appendChild(mybg);
		// document.body.style.overflow = "hidden";
	}
	$("td[uid]").click(function(){
	
		var offset = $(this).offset();
		 $.ajax({ //请求登录处理页
             url: "./property/unit/unit_infomation.action", //登录处理页
             dataType: "html",
             //传送请求数据
             data: "unitId="+$(this).attr("uid"),
             success: function(strValue) { //登录成功后返回的数据
                 //根据返回值进行状态显示
			 $("#unitinfomation").html("");
			 $("#unitinfomation").html(strValue);
			 $("#unitinfomation").css("display","block");
			 $("#close").click(function(){
			 $("#unitinfomation").css("display","none")
				 
			 });
			 $("#buildId").val($("#getbuildid").val().toString());
			 $('#unitform').submit(function() {    
		         // submit the form    
				
		         $(this).ajaxSubmit();     //......为什么要刷新呢
		         // return false to prevent normal browser submit and page navigation    
		         window.location.reload();
		         return false;
		       
		         
		        });
             }
         })
		
		 $("#unitinfomation").css("z-index","1100");
		 $("#unitinfomation").css("top",offset.top-50);
		 $("#unitinfomation").css("left",offset.left);
	}); 
	
}

function selectUnit(unitNo,unitId){
	//evdom 那里响应事件 用来得到显示DIV的坐标
	 
	if(!$("#unitinfomationPag").is('div')){
		mybg = document.createElement("div");
		mybg.setAttribute("id","unitinfomationPag");
		mybg.style.position = "absolute";
		mybg.style.top = "0";
		mybg.style.left = "0";
		mybg.style.zIndex = "-1000";
		document.body.appendChild(mybg);
		// document.body.style.overflow = "hidden";
	}
	$("#flush").click(function(){
			var uname = $("#"+unitNo);
		
			var uid = $("#"+unitId);
		 uname.val("");
		 uid.val("");
	 	});
	$("td[uid]").click(function(){

		var cilcktd = $(this);
		//$("#"+inputUnitId).val($(this).attr("uid"));
		var uname = $("#"+unitNo);
		uname.val(cilcktd.text());
		var uid = $("#"+unitId);
		uid.val($(this).attr("uid"));
		
		var offset = $("#forunitframe").offset();
		 $.ajax({ 
             url: "./property/test/information.action",
             dataType: "html",
             data: "selectUid="+$(this).attr("uid"),
             success: function(strValue) { 
			 $("#unitinfomationPag").html("");
			 $("#unitinfomationPag").html(strValue);
			 $("#unitinfomationPag").css("display","block");
			 $("#unitinfomationPag").css("top",(document.body.offsetHeight - $("#unitinfomationPag").height()) < 0 ? 0 : (document.body.offsetHeight - $("#unitinfomationPag").height())/2);
			 $("#unitinfomationPag").css("left",(document.body.offsetWidth - $("#unitinfomationPag").width())< 0 ? 0 : (document.body.offsetWidth - $("#unitinfomationPag").width())/ 2);
			 $("#selectUnitInformation").click(function(){
				 $("#unitinfomationPag").css("display","none")
				 $("#forunitframe").html("");
			 	});
			 $("#closeUnitInformation").click(function(){
				 $("#unitinfomationPag").css("display","none")
				 uname.val("");
				 uid.val("");
			 	});
			 	
             }
         })
		
		 $("#unitinfomationPag").css("z-index","1500");
		// $("#unitinfomationPag").css("top","0");
		// $("#unitinfomationPag").css("left","0");
		// $("#unitinfomationPag").css("top",(document.body.offsetHeight - $("#unitinfomationPag").height()) < 0 ? 0 : (document.body.offsetHeight - $("#unitinfomationPag").height())/2);
		// $("#unitinfomationPag").css("left",(document.body.offsetWidth - $("#unitinfomationPag").width())< 0 ? 0 : (document.body.offsetWidth - $("#unitinfomationPag").width())/ 2);
	}); 
	
}