/**
 *  公司或楼盘项目的弹出框及下拉树
 *  基于jquery.js使用前必须引入jquery.js
 */
 
//projectTextId输入框显示名称,projectHiddenId隐藏域保存id值(两者都是用,连接),modifyProject为跳转的具体actionName
//公司项目的单选与多选,如: bindProjectDialog("projectTextId", "projectTestHiddenId", "modifyProject");  
function bindProjectDialog(projectTextId, projectHiddenId, actionName, isMultiple){
	
	var pt = $("#" + projectTextId);	
	$(pt).css("width", "200px");
	var id = pt.attr("id");
	
	var projectId = $("#" + projectHiddenId).val(); //设为选中的项目
	
	if(isMultiple == false){
		
		//单选
		$("#" + id).combotree({
			url: "./saleunit/common/" + actionName + "ajax.action?isMultiple=false&projectId=" + projectId,
			onChange:function(newValue, oldValue){
				//newValue为新选中的值

				$("#" + projectHiddenId).val(newValue);					
			},			
			onLoadSuccess:function(node, data){
				//if(projectId != "" && projectId != "0"){
					//$("#" + id).combotree('setValue', projectId);
				//}
				//$("#" + projectHiddenId).val("");
				
				var module = $("#" + id).combotree('textbox');
				$(module).bind('focus', function(){
					$("#" + id).combotree('showPanel');	
				});			
				
				if(projectId == 0){
					$("#" + id).combotree('setText', '请选择');
				}
			},
			onBeforeSelect:function(node){				
			
				$($("#" + id).combotree('textbox')).blur();

				var nodeId = node.id;
				if(nodeId != "" && isNaN(nodeId)){
					
					$("#" + id).combotree('tree').tree('toggle', node.target);	
					//return false;
				}
			},
			onHidePanel:function(){
				
				var newValue = $("#" + id).combotree('getValue');
				if(newValue == "" || isNaN(newValue) || newValue == "0"){
					
					$($("#" + id).combotree('textbox')).focus();
				}else{
					
					$($("#" + id).combotree('textbox')).blur();
				}
				
			}
		});
		
	}else{
		
		//默认多选
		$("#" + id).combotree({
			url: "./saleunit/common/" + actionName + "ajax.action?projectId=" + projectId,
			multiple: "true",
			cascadeCheck : "true",
			editable: "false", //
			delay: 0,
			onChange:function(newValue, oldValue){
				//newValue为新选中的值
				if(newValue == ""){
					$("#" + projectHiddenId).val("");
				}else{
					//处理掉空格及非数字
					var idArray = new Array();
					$(newValue).each(function(){
						if(this != "" && !isNaN(this)){
							idArray.push(this);
						}
					});
					
					$("#" + projectHiddenId).val(idArray.join(","));
				}
			},		
			/***/
			onLoadSuccess:function(node, data){
				
				var module = $("#" + id).combotree('textbox');
				$(module).bind('focus', function(){
					$("#" + id).combotree('showPanel');	
				});
			},
			onBeforeSelect:function(node){			
			
				$($("#" + id).combotree('textbox')).blur();

				var nodeId = node.id;
				
				//选择
				if(nodeId != "" && isNaN(nodeId)){
					
					$("#" + id).combotree('tree').tree('toggle', node.target);	
				}
				
			},
			onHidePanel:function(){
				
				$("#" + id).combotree('showPanel');							
			}
		});		
		
	}
	
}

/**
 * 根据问卷id设置问卷的选项列表,绑定为下拉框
 * @param selCategoryId 下拉框的控件id ，如果没有传入，则默认为"selCategoryList"
 * @param questionId 问卷id ，如果没有传入，则默认为"questionList"
 */
function bindQuestionCategory(selCategoryId,questionId){
	if(selCategoryId==null){
		selCategoryId = "selCategoryList";//设置默认值
	}
	var selCategory = $("#" + selCategoryId);
	if(selCategory.length <= 0){
		return;//没有具体问题的下拉框，那么直接返回，不再执行
	}
	if(questionId==null){
		questionId = $("#questionList").val();//设置默认值		
	}
	$.ajax({
		url:'./saleunit/common/getListCategoryByQuestionId.action?questionId='+ questionId,
		success:function(data){
			$(selCategory).empty();
			$(selCategory).append(data);
		}
	})	
}


//projectTextId输入框显示名称,projectHiddenId隐藏域保存id值(两者都是用,连接),modifyProject为跳转的具体actionName
//公司项目的单选与多选,(选中后，会加载另一个问卷列表框id为:questionList)如: bindProjectDialog("projectTextId", "projectTestHiddenId", "modifyProject");  查找问卷列表使用
function bindProjectDialogQuestion(projectTextId, projectHiddenId, actionName, isMultiple){
	
	var pt = $("#" + projectTextId);	
	$(pt).css("width", "200px");
	var id = pt.attr("id");

	var projectId = $("#" + projectHiddenId).val(); //设为选中的项目
	
	if($("#questionList").length>0 && $("#selCategoryList").length>0){//如果有问卷下拉框，也有具体问题选项的下拉框
		$("#questionList").bind("change",function(){bindQuestionCategory()});//绑定事件
	}
	if(isMultiple == false){
		
		//单选
		$("#" + id).combotree({
			url: "./saleunit/common/" + actionName + "ajax.action?isMultiple=false&projectId=" + projectId,
			onChange:function(newValue, oldValue){
				//newValue为新选中的值

				$("#" + projectHiddenId).val(newValue);	
				$.ajax({
					url:'./customer_guangzhou/input/pickQuestionList.action?proId='+$("#" + projectHiddenId).val(),
					success:function(data){
						$("#questionList").empty();
						$("#questionList").append(data);
						var qid = data.substring(data.indexOf('  '),data.indexOf('selected')).match('[0-9]+');
						if(qid==null){
							return;
						}
						bindQuestionCategory("selCategoryList",qid);//根据问卷，设置问卷选项的下拉框					
					}
				})
				
			},			
			onLoadSuccess:function(node, data){
				var module = $("#" + id).combotree('textbox');
				$(module).bind('focus', function(){
					$("#" + id).combotree('showPanel');	
				});	
				$.ajax({
					url:'./customer_guangzhou/input/pickQuestionList.action?proId='+$("#" + projectHiddenId).val(),
					success:function(data){
						$("#questionList").empty();
						$("#questionList").append(data);
						var qid = data.substring(data.indexOf('  '),data.indexOf('selected')).match('[0-9]+');
						if(qid==null){
							return;
						}
						bindQuestionCategory("selCategoryList",qid);//根据问卷，设置问卷选项的下拉框
					}
				})
				
			},
			onBeforeSelect:function(node){				

				$($("#" + id).combotree('textbox')).blur();

				var nodeId = node.id;
				if(nodeId != "" && isNaN(nodeId)){
					
					$("#" + id).combotree('tree').tree('toggle', node.target);	
				}
				
			},
			onHidePanel:function(){
				
				var newValue = $("#" + id).combotree('getValue');
				if(newValue == "" || isNaN(newValue) || newValue == "0"){
					
					$($("#" + id).combotree('textbox')).focus();
				}else{
					
					$($("#" + id).combotree('textbox')).blur();
				}
			}
		});
		
	}else{
		
		//默认多选
		$("#" + id).combotree({
			url: "./saleunit/common/" + actionName + "ajax.action?projectId=" + projectId,
			multiple: "true",
			cascadeCheck : "true",
			
			onChange:function(newValue, oldValue){
				//newValue为新选中的值
				if(newValue == ""){
					$("#" + projectHiddenId).val("");
				}else{
					//处理掉空格及非数字
					var idArray = new Array();
					$(newValue).each(function(){
						if(this != "" && !isNaN(this)){
							idArray.push(this);
						}
					});
					
					$("#" + projectHiddenId).val(idArray.join(","));
				}
			},		
			/***/
			onLoadSuccess:function(node, data){
				
				var module = $("#" + id).combotree('textbox');
				$(module).bind('focus', function(){
					$("#" + id).combotree('showPanel');	
				});			
			},
			onBeforeSelect:function(node){			
			
				$($("#" + id).combotree('textbox')).blur();

				var nodeId = node.id;
				
				//选择
				if(nodeId != "" && isNaN(nodeId)){
					
					$("#" + id).combotree('tree').tree('toggle', node.target);	
				}
				
			},
			onHidePanel:function(){
				
				$("#" + id).combotree('showPanel');							
			}
		});		
		
	}
	
}


//projectTextId输入框显示名称,projectHiddenId隐藏域保存id值(两者都是用,连接),modifyProject为跳转的具体actionName
//公司的单选与多选,(选中后，会加载另一个问卷列表框id为:questionList)如: bindProjectDialog("projectTextId", "projectTestHiddenId", "modifyProject");  查找问卷列表使用
function bindCompanyDialogQuestion(companyTextId, companyHiddenId, actionName, isMultiple){
	
	var pt = $("#" + companyTextId);	
	$(pt).css("width", "200px");
	var id = pt.attr("id");

	var companyId = $("#" + companyHiddenId).val(); //设为选中的项目
	if(isMultiple == false){
		
		//单选
		$("#" + id).combotree({
			url: "./saleunit/common/" + actionName + "ajax.action?isMultiple=false&projectId=" + companyId,
			onChange:function(newValue, oldValue){
				//newValue为新选中的值

				$("#" + companyHiddenId).val(newValue);	
				$.ajax({
					url:'./customer_guangzhou/input/pickQuestionListCompany.action?companyId='+$("#" + companyHiddenId).val(),
					success:function(data){
						$("#questionList").empty();
						$("#questionList").append(data);						
					}
				})
				
			},			
			onLoadSuccess:function(node, data){				
				var module = $("#" + id).combotree('textbox');
				$(module).bind('focus', function(){
					$("#" + id).combotree('showPanel');	
				});	
				$.ajax({
					url:'./customer_guangzhou/input/pickQuestionList.action?companyId='+$("#" + companyHiddenId).val(),
					success:function(data){
						$("#questionList").empty();
						$("#questionList").append(data);						
					}
				})
				
			},
			onBeforeSelect:function(node){				
			
				$($("#" + id).combotree('textbox')).blur();

				var nodeId = node.id;
				if(nodeId != "" && isNaN(nodeId)){
					
					$("#" + id).combotree('tree').tree('toggle', node.target);	
				}
			},
			onHidePanel:function(){
				
				var newValue = $("#" + id).combotree('getValue');
				if(newValue == "" || isNaN(newValue) || newValue == "0"){
					
					$($("#" + id).combotree('textbox')).focus();
				}else{
					
					$($("#" + id).combotree('textbox')).blur();
				}
			}
			
		});
		
	}else{
		
		//默认多选
		$("#" + id).combotree({
			url: "./saleunit/common/" + actionName + "ajax.action?projectId=" + companyId,
			multiple: "true",
			cascadeCheck : "true",
			
			onChange:function(newValue, oldValue){
				//newValue为新选中的值
				if(newValue == ""){
					$("#" + companyHiddenId).val("");
				}else{
					//处理掉空格及非数字
					var idArray = new Array();
					$(newValue).each(function(){
						if(this != "" && !isNaN(this)){
							idArray.push(this);
						}
					});
					
					$("#" + companyHiddenId).val(idArray.join(","));
				}
			},		
			onLoadSuccess:function(node, data){
				
				var module = $("#" + id).combotree('textbox');
				$(module).bind('focus', function(){
					$("#" + id).combotree('showPanel');	
				});			
			},
			onBeforeSelect:function(node){			
			
				$($("#" + id).combotree('textbox')).blur();

				var nodeId = node.id;
				
				//选择
				if(nodeId != "" && isNaN(nodeId)){
					
					$("#" + id).combotree('tree').tree('toggle', node.target);	
				}
				
			},
			onHidePanel:function(){
				
				$("#" + id).combotree('showPanel');							
			}
		});		
		
	}
	
}

//楼盘项目,区域,楼栋实现三级联动,actionName:modifyProjectXKZX
function bindProjectAreaBuild(projectTextId, areaTextId, buildTextId, actionName){
	
	var projectId = $("#" + projectTextId).val(); //选择的项目的值
	var areaId = $("#" + areaTextId).val(); //选择的分区的值
	var buildId = $("#" + buildTextId).val(); //选择的楼栋的值
		
	//$("#" + projectTextId).attr("value", "");
	$("#" + areaTextId).attr("value", "");
	$("#" + buildTextId).attr("value", "");
	
	$("#" + projectTextId).combotree({
		width:200,
		editable:false,
		url: "./saleunit/common/" + actionName + "forPropertyAjax.action?isMultiple=false&projectId=" + projectId,
		onChange:function(newValue, oldValue){
			
			if(newValue == "" || isNaN(newValue) || newValue == "0"){
				//还原分区及楼栋
				
				setComboBoxEmpty(areaTextId);
				setComboBoxEmpty(buildTextId);
				return false;
			}			
			
			var url = "./saleunit/common/" + actionName + "forAreaAjax.action?projectId=" + newValue;			
			$("#" + areaTextId).combobox("reload", url);			
			$("#" + areaTextId).combobox("setText", "请选择");
			$("#" + areaTextId).combobox("setValue", "");	
			
			setComboBoxEmpty(buildTextId);
		},
		onLoadSuccess:function(node, data){
				
			//整个组件
			var module = $("#" + projectTextId).combotree('textbox');
			$(module).bind('focus', function(){
				$("#" + projectTextId).combotree('showPanel');	
			});			
			
		},
		onBeforeSelect:function(node){				
			
			$($("#" + projectTextId).combotree('textbox')).blur();

			var nodeId = node.id;
			if(nodeId != "" && isNaN(nodeId)){
				
				$("#" + projectTextId).combotree('tree').tree('toggle', node.target);	
			}
		},
		onHidePanel:function(){
			
			var newValue = $("#" + projectTextId).combotree('getValue');
			if(newValue == "" || isNaN(newValue) || newValue == "0"){
				
				$($("#" + projectTextId).combotree('textbox')).focus();
			}else{
				
				$($("#" + projectTextId).combotree('textbox')).blur();
			}
			
		}
	});
	
	$("#" + areaTextId).combobox({
		width:150,
		editable:false,
		valueField:'id',   
		textField:'text',
		url: "./saleunit/common/" + actionName + "forAreaAjax.action?projectId=" + projectId + "&areaId=" + areaId,
		onChange:function(newValue, oldValue){
			
			if(newValue == "" || isNaN(newValue) || newValue == "0"){
				//还原楼栋
				
				setComboBoxEmpty(buildTextId);
				return false;
			}	
			
			var url = "./saleunit/common/" + actionName + "forBuildAjax.action?areaId=" + newValue;			
			$("#" + buildTextId).combobox("reload", url);			
			$("#" + buildTextId).combobox("setText", "请选择");
			$("#" + buildTextId).combobox("setValue", "");	
			
		},
		onLoadSuccess:function(node, data){
				
			var module = $("#" + areaTextId).combobox('textbox');
			$(module).bind('focus', function(){
				$("#" + areaTextId).combobox('showPanel');	
			}).bind('blur', function(){
				$("#" + areaTextId).combobox('hidePanel');	
			});			
					
		}
		
	});
	
	$("#" + buildTextId).combobox({
		width:150,
		editable:false,
		valueField:'id',   
		textField:'text',
		url: "./saleunit/common/" + actionName + "forBuildAjax.action?projectId=" + projectId + "&areaId=" + areaId + "&buildId=" + buildId,
		onLoadSuccess:function(node, data){
				
			var module = $("#" + buildTextId).combobox('textbox');
			$(module).bind('focus', function(){
				$("#" + buildTextId).combobox('showPanel');	
			}).bind('blur', function(){
				$("#" + buildTextId).combobox('hidePanel');	
			});				
		}
		
	});	
	
}

//楼盘项目tree,区域,楼栋实现三级联动,actionName:modifyProjectXKZX
function bindProjectTreeAreaBuildByAction(projectTextId, areaTextId, buildTextId, actionName){
	
	var projectId = $("#" + projectTextId).val(); //选择的项目的值
	var areaId = $("#" + areaTextId).val(); //选择的分区的值
	var buildId = $("#" + buildTextId).val(); //选择的楼栋的值
		
	//$("#" + projectTextId).attr("value", "");
	$("#" + areaTextId).attr("value", "");
	$("#" + buildTextId).attr("value", "");
	
	$("#" + projectTextId).combotree({
		width:200,
		editable:false,
		//panelHeight:'auto',
		url: "./saleunit/common/modifyCompanyProjectPropertyajax.action?isMultiple=false", //&projectId=" + projectId,
		onChange:function(newValue, oldValue){
			
			if(newValue == "" || isNaN(newValue) || newValue == "0"){
				//还原分区及楼栋
				
				setComboBoxEmpty(areaTextId);
				setComboBoxEmpty(buildTextId);
				
			}else{
			
				var url = "./saleunit/common/" + actionName + "forAreaAjax.action?projectId=" + newValue;			
				$("#" + areaTextId).combobox("reload", url);			
				$("#" + areaTextId).combobox("setText", "请选择");
				$("#" + areaTextId).combobox("setValue", "");	
				
				setComboBoxEmpty(buildTextId);
			}
			
		},
		onLoadSuccess:function(node, data){
				
			//整个组件
			var module = $("#" + projectTextId).combotree('textbox');
			$(module).bind('focus', function(){
				$("#" + projectTextId).combotree('showPanel');	
			});		
			
		},
		onBeforeSelect:function(node){				

			var nodeId = node.id;
			if(nodeId != "" && isNaN(nodeId)){
				
				$("#" + projectTextId).combotree('tree').tree('toggle', node.target);
				//return false;
			}
		},
		onHidePanel:function(){
			
			var newValue = $("#" + projectTextId).combotree('getValue');
			if(newValue == "" || isNaN(newValue) || newValue == "0"){
				
				$($("#" + projectTextId).combotree('textbox')).focus();
			}else{
				
				$($("#" + projectTextId).combotree('textbox')).blur();
			}
			
			//$("#" + projectTextId).combotree('showPanel');			
		}
	});
	
	$("#" + areaTextId).combobox({
		width:150,
		editable:false,
		panelHeight:'auto',
		valueField:'id',   
		textField:'text',
		url: "./saleunit/common/" + actionName + "forAreaAjax.action", //?projectId=" + projectId + "&areaId=" + areaId,
		onChange:function(newValue, oldValue){
			
			if(newValue == "" || isNaN(newValue) || newValue == "0"){
				//还原楼栋
				
				setComboBoxEmpty(buildTextId);
				return false;
			}	
			
			var url = "./saleunit/common/" + actionName + "forBuildAjax.action?areaId=" + newValue;			
			$("#" + buildTextId).combobox("reload", url);			
			$("#" + buildTextId).combobox("setText", "请选择");
			$("#" + buildTextId).combobox("setValue", "");	
			
		},
		onLoadSuccess:function(node, data){
				
			var module = $("#" + areaTextId).combobox('textbox');
			$(module).bind('focus', function(){
				$("#" + areaTextId).combobox('showPanel');	
			}).bind('blur', function(){
				$("#" + areaTextId).combobox('hidePanel');	
			});			
					
		}
		
	});
	
	$("#" + buildTextId).combobox({
		width:150,
		editable:false,
		panelHeight:'auto',
		valueField:'id',   
		textField:'text',
		url: "./saleunit/common/" + actionName + "forBuildAjax.action", //?projectId=" + projectId + "&areaId=" + areaId + "&buildId=" + buildId,
		onLoadSuccess:function(node, data){
				
			var module = $("#" + buildTextId).combobox('textbox');
			$(module).bind('focus', function(){
				$("#" + buildTextId).combobox('showPanel');	
			}).bind('blur', function(){
				$("#" + buildTextId).combobox('hidePanel');	
			});				
		}
		
	});	
	
}

//省份,城市,区域实现三级联动
function bindProvinceCityRegion(provinceTextId, cityTextId, regionTextId){
	
	var provinceId = $("#" + provinceTextId).val(); //选择的省份的值
	var cityId = $("#" + cityTextId).val(); //选择的城市的值
	var regionId = $("#" + regionTextId).val(); //选择的区域的值

	if(provinceId == "0"){
		provinceId = "";
		$("#" + provinceTextId).val("");
	}
	
	if(cityId == "0"){
		cityId = "";
		$("#" + cityTextId).attr("value", "");
	}
	
	if(regionId == "0"){
		regionId = "";
		$("#" + regionTextId).attr("value", "");
	}
	
	$("#" + provinceTextId).combobox({
		width:100,
		editable:false,
		valueField:'id',   
		textField:'text',
		url: "./saleunit/common/getProvinceAjax.action?provinceId=" + provinceId,
		onChange:function(newValue, oldValue){
			
			if(newValue == "" || isNaN(newValue) || newValue == "0"){
				//还原城市,区域
				
				setComboBoxEmpty(cityTextId);
				setComboBoxEmpty(regionTextId);
				return false;
			}			
			
			var url = "./saleunit/common/getCityAjax.action?provinceId=" + newValue;			
			$("#" + cityTextId).combobox("reload", url);			
			$("#" + cityTextId).combobox("setText", "请选择");
			$("#" + cityTextId).combobox("setValue", "");	
			
			setComboBoxEmpty(regionTextId);
		},
		onLoadSuccess:function(node, data){
				
			var module = $("#" + provinceTextId).combotree('textbox');
			$(module).bind('focus', function(){
				$("#" + provinceTextId).combotree('showPanel');	
			}).bind('blur', function(){
				$("#" + provinceTextId).combotree('hidePanel');	
			});			
			
			if(provinceId == "0"){
				$("#" + provinceTextId).combobox("setText", "请选择");
				$("#" + provinceTextId).combobox("setValue", "");
			}
		}
	});
	
	$("#" + cityTextId).combobox({
		width:100,
		editable:false,
		valueField:'id',   
		textField:'text',
		url: "./saleunit/common/getCityAjax.action?provinceId=" + provinceId + "&cityId=" + cityId,
		onChange:function(newValue, oldValue){
			
			if(newValue == "" || isNaN(newValue) || newValue == "0"){
				//还原区域
				
				setComboBoxEmpty(regionTextId);
				return false;
			}	
			
			var url = "./saleunit/common/getRegionAjax.action?cityId=" + newValue;			
			$("#" + regionTextId).combobox("reload", url);			
			$("#" + regionTextId).combobox("setText", "请选择");
			$("#" + regionTextId).combobox("setValue", "");	
			
		},
		onLoadSuccess:function(node, data){
				
			var module = $("#" + cityTextId).combobox('textbox');
			$(module).bind('focus', function(){
				$("#" + cityTextId).combobox('showPanel');	
			}).bind('blur', function(){
				$("#" + cityTextId).combobox('hidePanel');	
			});			
					
		}
		
	});
	
	$("#" + regionTextId).combobox({
		width:100,
		editable:false,
		valueField:'id',   
		textField:'text',
		url: "./saleunit/common/getRegionAjax.action?cityId=" + cityId + "&regionId=" + regionId,
		onLoadSuccess:function(node, data){
				
			var module = $("#" + regionTextId).combobox('textbox');
			$(module).bind('focus', function(){
				$("#" + regionTextId).combobox('showPanel');	
			}).bind('blur', function(){
				$("#" + regionTextId).combobox('hidePanel');	
			});				
		}
		
	});	
	
}

//设置combobox为空,("请选择")
function setComboBoxEmpty(comboBoxId){
	
	$("#" + comboBoxId).combobox("reload", './saleunit/common/emptyCombobox.action');
	$("#" + comboBoxId).combobox("setText", "请选择");
	$("#" + comboBoxId).combobox("setValue", "");	
	
	
	/*
	$("#" + comboBoxId).combobox("clear");
	var options = $("#" + comboBoxId).combobox("options");
	var valueField = options.valueField;
	var textField = options.textField;
	
	options.data = [{valueField:'',textField:'请选择'}];
	*/
}

//楼盘项目多选iframe弹出框
function bindProjectDialogForIframe(projectTextId, projectHiddenId, actionName){
	
	var pt = $("#" + projectTextId);
	
	pt.attr("readonly", "readonly");
	pt.addClass("readonly");
	
	var hrefId = projectTextId + "_" + projectHiddenId; //要确定其唯一性
	var clickHref = "<a href='javascript:void(0)' style='padding:0 0 0 10px' id='" + hrefId + "'><font color='#5482DE'>选择项目</font></a>";
	pt.after(clickHref); //在输入框后面增加操作href
	
	//增加iframe, dialog, companyHiddenId(??)
	var dialogId = hrefId + "_dialogId";
	var iframeId = hrefId + "_iframeId";
	//var companyHiddenId = hrefId + "_companyHiddenId"
	
	var div = "<div id='" + dialogId + "' class='easyui-dialog' closed='true' modal='true' title='选择项目'>"
		+ "<iframe scrolling='auto' frameborder='0' style='width:100%;height:100%;' id='" + iframeId + "'></iframe></div>"
		;
	
	//var companyHidden = "<input type='hidden' id='" + companyHiddenId + "'/>";
	
	$(document.body).find("#" + dialogId).remove();
	$(document.body).append(div);
	//$(document.body).append(companyHidden);	
	
	//初始化dialog
	$("#" + dialogId).dialog({
		resizable: true,
		modal:true, //模态窗口,表示不能操作弹出框以外的内容
		maximizable: true, //显示最大化按钮
		width:600,
		height:400,
		onClose:function(){
			$('#' + iframeId).attr("src", "./saleunit_new/guangzhou/loading.jsp"); //清空内容
		},
		buttons:[				 
		{
			text:'提交',
			iconCls:'icon-ok',
			handler:function(){
				
				var idArray = new Array(); //应该把之前的值保存进去,
				var nameArray = new Array();
				
				var contentWindow = $('#' + iframeId)[0].contentWindow;
								
				var projectIds = contentWindow.$("input[name=projectName]");
				$(projectIds).each(function(){

					if($(this).attr("checked") == "checked"){
						
						var getId = $(this).attr("value");
						if(!isArrayInclude(idArray, getId)){
							idArray.push(getId);
							nameArray.push($(this).attr("label"));
						}						
					}
				});
				
				var ids = idArray.join(",");
				var names = nameArray.join(",");
				
				//var companyId = contentWindow.$("#companyId option:selected").val();
				
				$("#" + projectTextId).val(names);
				$("#" + projectHiddenId).val(ids);
				//$("#" + companyHiddenId).val(companyId);
				
				$('#' + dialogId).dialog('close');				
				
			}
		},
		{
			text:'关闭',
			iconCls:'icon-cancel',
			handler:function(){
				$("#" + dialogId).dialog('close');
			}
		}]
		
	});
	
	$("#" + hrefId).bind('click', function(){
		
		$('#' + dialogId).dialog('open');
		
		var projectName = $("#" + projectTextId).val();
		var projectId = $("#" + projectHiddenId).val();
		//var companyId = $("#" + companyHiddenId).val();
		
		var src = "./saleunit/common/" + actionName + ".action?projectName=" + projectName + "&projectId=" + projectId;
		
		$('#' + iframeId)[0].src = src;
	});
}

//销控中心角色的多选公司项目
function bindProjectDialogForXKZX(projectTextId, projectHiddenId){
	bindProjectDialog(projectTextId, projectHiddenId, "modifyProjectXKZX");
}

//售前客户角色的多选公司项目
function bindProjectDialogForSQKH(projectTextId, projectHiddenId){
	bindProjectDialog(projectTextId, projectHiddenId, "modifyProjectSQKH");
}

//销控中心角色的单选公司项目
function bindProjectDialogForXKZXOnly(projectTextId, projectHiddenId){
	bindProjectDialog(projectTextId, projectHiddenId, "modifyProjectXKZX", false);
}

//售前客户角色的单选公司项目
function bindProjectDialogForSQKHOnly(projectTextId, projectHiddenId){
	bindProjectDialog(projectTextId, projectHiddenId, "modifyProjectSQKH", false);
}

//售前客户角色的单选公司项目获取问卷列表
function bindProjectDialogForSQKHOnlyQuestion(projectTextId, projectHiddenId){
	bindProjectDialogQuestion(projectTextId, projectHiddenId, "modifyProjectSQKH", false);
}

//销控中心角色的项目,分区,楼栋级联
function bindProjectAreaBuildForXKZX(projectTextId, areaTextId, buildTextId){
	bindProjectAreaBuild(projectTextId, areaTextId, buildTextId, "modifyProjectXKZX");	
}

//销控中心角色的公司-->楼盘项目多选
function bindCompanyPropertyPorjectForXKZX(projectTextId, projectHiddenId){
	bindProjectDialog(projectTextId, projectHiddenId, "modifyProjectXKZXforProperty");
}

//销控中心角色的公司-->楼盘项目单选
function bindCompanyPropertyPorjectForXKZXOnly(projectTextId, projectHiddenId){
	bindProjectDialog(projectTextId, projectHiddenId, "modifyProjectXKZXforProperty", false);
}

//销控中心角色的公司多选
function bindCompanyForXKZX(companyTextId, companyHiddenId){
	bindProjectDialog(companyTextId, companyHiddenId, "modifyCompanyXKZX");
}

//销控中心角色的公司单选
function bindCompanyForXKZXOnly(companyTextId, companyHiddenId){
	bindProjectDialog(companyTextId, companyHiddenId, "modifyCompanyXKZX", false);
}

//售前客户角色的公司单选(带问卷)
function bindCompanyForSQKHOnlyQuestion(companyTextId, companyHiddenId){
	bindCompanyDialogQuestion(companyTextId, companyHiddenId, "modifyCompanyXKZX", false);
}

//人员授权角色的多选公司项目
function bindProjectDialogForRYSQ(projectTextId, projectHiddenId){
	bindProjectDialog(projectTextId, projectHiddenId, "modifyProjectRYSQ");
}

//人员授权角色的单选公司项目
function bindProjectDialogForRYSQOnly(projectTextId, projectHiddenId){
	bindProjectDialog(projectTextId, projectHiddenId, "modifyProjectRYSQ", false);
}

//单选：请选择-->公司-->公司项目-->楼盘项目
function bindProjectTreeAreaBuildOnly(projectTextId, areaTextId, buildTextId){
	bindProjectTreeAreaBuildByAction(projectTextId, areaTextId, buildTextId, "modifyProjectXKZX");
}