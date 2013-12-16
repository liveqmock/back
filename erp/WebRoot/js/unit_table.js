
function showDiv(inputUnitNo ,inputUnitId,buildId,proId){
	
	$("#"+inputUnitNo).focus(function(){
		$("#"+inputUnitNo).blur();
		//	var offset = $(this).offset();
		
			 $.ajax({ //请求登录处理页
	             url: "./property/test/list.action", //登录处理页
	             dataType: "html",
	             //传送请求数据
	             data: "buildId="+$("#"+buildId).val()+"&propertyId="+$("#"+proId).val()+"&unitNoInput="+inputUnitNo+"&unitIdInput="+inputUnitId,
	             success: function(strValue) { //登录成功后返回的数据
	                 //根据返回值进行状态显示
				 $("#select_unit_div_body").html("");
				 $("#select_unit_div_body").html(strValue);
				 $("#select_unit_div").css("display","block");
	             }
	         });
	         
			 $("#select_unit_div").css("z-index","1000");
			 $("#select_unit_div").css("top",(window.screen.availHeight - $("#select_unit_div").height()) < 0 ? 0 : (window.screen.availHeight - $("#select_unit_div").height())/3);
			 $("#select_unit_div").css("left",(document.body.offsetWidth - $("#select_unit_div").width()) < 0 ? 0 : (document.body.offsetWidth - $("#select_unit_div").width())/ 2);
		});
	
}
