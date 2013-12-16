/**
 * 广州项目中的省市级联js
 */


///old
function proviToCity(proviId, cityId, regionId){
	var emp = "<option value=\"\">请选择</option>";
	var provi = $("#" + proviId).val();
	
	if(provi == ""){
		$("#" + cityId).empty();
		$("#" + cityId).append(emp);
		$("#" + regionId).empty();
		$("#" + regionId).append(emp);
	}else{
		$.ajax({
			type:"get",
			url: "./customer_guangzhou/search/proviToCity.action",  
			data: "provinceId=" + provi,
			dataType: "html",
			success: function(data){
				$("#" + cityId).empty();
				$("#" + cityId).append(data);
				$("#" + regionId).empty();
				$("#" + regionId).append(emp);
			}
		});
	}
}

function cityToRegion(cityId, regionId){
	var emp = "<option value=\"\">请选择</option>";
	var city = $("#" + cityId).val();
	
	if(city == ""){
		$("#" + regionId).empty();
		$("#" + regionId).append(emp);
	}else{
		$.ajax({
			type:"get",
			url: "./customer_guangzhou/search/cityToRegion.action",  
			data: "cityId=" + city,
			dataType: "html",
			success: function(data){
				$("#" + regionId).empty();
				$("#" + regionId).append(data);
			}
		});
	}
}

///// new

function proviToCity(proviId, cityId, regionId, blockId){
	var emp = "<option value=\"\">请选择</option>";
	var provi = $("#" + proviId).val();
	
	if(provi == ""){
		$("#" + cityId).empty();
		$("#" + cityId).append(emp);
		$("#" + regionId).empty();
		$("#" + regionId).append(emp);
		
		$("#" + blockId).empty();
		$("#" + blockId).append(emp);

	}else{
		$.ajax({
			type:"get",
			url: "./customer_guangzhou/search/proviToCity.action",  
			data: "provinceId=" + provi,
			dataType: "html",
			success: function(data){
				$("#" + cityId).empty();
				$("#" + cityId).append(data);
				$("#" + regionId).empty();
				$("#" + regionId).append(emp);
				
				$("#" + blockId).empty();
				$("#" + blockId).append(emp);
			}
		});
	}
}

function cityToRegion(cityId, regionId, blockId){
	var emp = "<option value=\"\">请选择</option>";
	var city = $("#" + cityId).val();
	
	if(city == ""){
		$("#" + regionId).empty();
		$("#" + regionId).append(emp);
		
		$("#" + blockId).empty();
		$("#" + blockId).append(emp);
	}else{
		$.ajax({
			type:"get",
			url: "./customer_guangzhou/search/cityToRegion.action",  
			data: "cityId=" + city,
			dataType: "html",
			success: function(data){
				$("#" + regionId).empty();
				$("#" + regionId).append(data);
				
				$("#" + blockId).empty();
				$("#" + blockId).append(emp);
			}
		});
	}
}

function regionToBlock(projectId, regionId, blockId){
	var emp = "<option value=\"\">请选择</option>";
	
	var project = $("#" + projectId).val();
	var region = $("#" + regionId).val();
	
	if(region == ""){
		
		$("#" + blockId).empty();
		$("#" + blockId).append(emp);
	}else{
		
		if(project != "0"){
			$.ajax({
				type:"get",
				url: "./customer_guangzhou/search/regionToBlock.action",  
				data: "regionId=" + region + "&projectId=" + project,
				dataType: "html",
				success: function(data){
					
					$("#" + blockId).empty();
					$("#" + blockId).append(data);
				}
			});
	   }else{
		   //要先选择项目
		   
		   clearTip("请先选择项目");
	   }
	}
		
}