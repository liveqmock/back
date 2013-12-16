/**
 * 广州的项目js
 */

//提示框 top

function projectListForHiddenId(projectTextId, hiddenId){
	//projectTextId为提示框id, hiddenId保存选择的project的id
	$("#" + projectTextId).autocomplete("./customer_guangzhou/search/projects.action", {
		width: 150,  //提示框宽度
		selectFirst: false,
		setHiddenId: hiddenId
	});

	//checkProjectName(projectTextId, hiddenId);

}

function projectList(projectTextId){
	//projectTextId为提示框id,
	$("#" + projectTextId).autocomplete("./customer_guangzhou/search/projects.action", {
		width: 150,  //提示框宽度
		selectFirst: false
	});
	
}

function checkProjectName(projectTextId, hiddenId){
	
	$("#" + projectTextId).blur(function(){
		var projectName = $("#" + projectTextId).val();
		
		if(projectName != "" && projectName != " "){
			$.ajax({
				type:"post",
				url: "./customer_guangzhou/search/getProjectIdByProjectName.action",
				data: "projectName=" + projectName,
				dataType: "html",
				success: function(data){
					//if(data == "0"){
						//表示项目不存在
						//alert("项目：\"" + projectName + "\"不存在");
					//}
					$("#" + hiddenId).val(data);
				}
				
			});
		}else{
			$("#" + hiddenId).val("0");			
		}
	});
}

function getRangeFromProjectIdAndType(projectId, typeId, typeValue, rangeId){
	//根据项目id和分析类型,获取区间范围的值
	var getTypeValue = $("#" + typeId).val();
	if(getTypeValue == typeValue){
		var getProjectId = $("#" + projectId).val();
		if(getProjectId == "" || getProjectId == "0"){
			
			alert("请先选择项目");
		}else{
			$.ajax({
				type:"post",
				url: "./customer_guangzhou/search/getRangeFromProjectIdAndType.action",
				data: "projectId=" + getProjectId + "&typeValue=" + getTypeValue,
				dataType: "html",
				success: function(data){
					$("#" + rangeId).val(data);
				}
				
			});
		}
	}
	
}

function propertyProjectListForHiddenId(projectTextId, hiddenId){
	//projectTextId为提示框id, hiddenId保存选择的project的id, 楼盘项目	
	var searchAction = "./customer_guangzhou/search/propertyProjects.action";
	var checkAction = "./customer_guangzhou/search/getProjectIdByProjectNameForProperty.action";
	baseProjectListForHiddenId(projectTextId, hiddenId, searchAction, "");

}

//property_area (没有使用)
function propertyAreaListForHiddenId(projectTextId, hiddenId){
	//projectTextId为提示框id, hiddenId保存选择的project的id, 楼盘项目	
	var searchAction = "./customer_guangzhou/search/propertyProjects.action";
	var checkAction = "./customer_guangzhou/search/getProjectIdByProjectNameForProperty.action";
	baseProjectListForHiddenId(projectTextId, hiddenId, searchAction, "");
}

function propertyBuildListForHiddenId(projectTextId, hiddenId){
	//projectTextId为提示框id, hiddenId保存选择的project的id, 楼盘项目	
	var searchAction = "./customer_guangzhou/search/propertyBuild.action";
	var checkAction = "./customer_guangzhou/search/getBuildIdByBuildName.action";
	baseProjectListForHiddenId(projectTextId, hiddenId, searchAction, "");
}

function baseProjectListForHiddenId(projectTextId, hiddenId, searchAction, checkAction){
	
	$("#" + projectTextId).autocomplete(searchAction, {
		width: 150,  //提示框宽度
		selectFirst: false,
		setHiddenId: hiddenId
	});	
	
	$("#" + projectTextId).blur(function(){
		var projectName = $("#" + projectTextId).val();
		
		if($.trim(projectName) != ""){
			
			if(checkAction != ""){
				$.ajax({
					type:"post",
					url: checkAction,
					data: "projectName=" + projectName,
					dataType: "html",
					success: function(data){
						
						$("#" + hiddenId).val(data);
					}
					
				});
				
			}
			
		}else{
			$("#" + hiddenId).val("");			
		}
	});

}

//根据楼盘项目id,获取对应的楼栋下拉框
function getBuildListFromPropertyId(property, propertyId, buildId){
	
	$("#" + property).blur(function(){
		
		var propertyValue = $("#" + propertyId).val();
		if(propertyValue != "" && propertyValue != "0"){
			$.ajax({
				type:"post",
				url: "./customer_guangzhou/search/getBuildListFromPropertyId.action",
				data: "propertyId=" + propertyValue,
				dataType: "html",
				success: function(data){
					
					$("#" + buildId).empty();
					$("#" + buildId).append(data);

				}
				
			});
			
		}else{
			
			var emp = "<option value=\"\">请选择</option>";
			
			$("#" + buildId).empty();
			$("#" + buildId).append(emp);
			
		}
	});
}

//根据楼盘项目id,获取对应的楼栋联想提示框
function getBuildListFromPropertyIdForAuto(build, propertyId, hiddenId){
	//build为楼栋录入框,propertyId为楼盘项目的值的id, hiddenId保存选择的build的id
	$("#" + build).autocomplete("./customer_guangzhou/search/getBuildListFromPropertyIdForAuto.action", {
		width: 150,  //提示框宽度
		selectFirst: false,
		otherDataId: propertyId,
		setHiddenId: hiddenId
	});

}