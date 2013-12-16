
function reload(){
			var node = $('#left_tree').tree('getSelected');
			if (node){
				$('#left_tree').tree('reload', node.target).tree('expandTo',node.target);
			} else {
				$('#left_tree').tree('reload');
			}
}
function treereload(){
		$('#left_tree').tree('reload');
}
function resalef(){
	var node = $('#left_tree').tree('getSelected');
	if (node){
		$('#left_tree').tree('reload', node.target);
	} else {
		$('#left_tree').tree('reload');
	}
}

function reloadParent(){
	var node = $('#left_tree').tree('getSelected');
	var node1 = $('#left_tree').tree('getParent',node.target);
	if (node1){
		$('#left_tree').tree('reload', node1.target);		
	} else {
		$('#left_tree').tree('reload');
	}
	
	try{
		$('#left_tree').tree('expandTo',node.target);
	}catch(e){}
}



function copyBuild(){
	var node = $('#left_tree').tree('getSelected');
	if (node){
		var textstr=node.attributes.bid;
		if(textstr == undefined){
			myAlert('请选择楼栋');
		}else{
			$("#new_dialog").dialog({
				resizable: true,
				modal:true, 
				maximizable: false, 
				onClose:function(){
				reloadParent();
				},
				buttons:[ {
					text:'提交',
					iconCls:'icon-ok',
					handler:function(){
					window.document.getElementById("new_dialog_ifram").contentWindow.formsubmit();
					
					}},
					{text:'关闭',
					iconCls:'icon-cancel',
					handler:function(){
						$('#new_dialog').dialog('close');
						//reloadParent();
					}}
				]
			});
			$('#new_dialog').dialog('open');
			$('#new_dialog').dialog('setTitle', '复制'); 
			$('#new_dialog_ifram')[0].src='./saleunit_new_init/appoint/guangzhou/copyBuild.action?&id='+textstr; 
		}
	} else {
		myAlert('请选择楼栋');
	}
}

function addSomeProject(type,soid){	
	$("#new_dialog").dialog({
		resizable: true,
		modal:true, 
		maximizable: false, 
		width:500,
		height:193,
		onClose:function(){
		reload();
		},
		buttons:[ {
			text:'提交',
			iconCls:'icon-ok',
			handler:function(){
			window.document.getElementById("new_dialog_ifram").contentWindow.formsubmit();
			
			}},
			{text:'关闭',
			iconCls:'icon-cancel',
			handler:function(){
				$('#new_dialog').dialog('close');
				//reload();
			}}
		]
	});
	$('#new_dialog').dialog('open');
	$('#new_dialog').dialog('setTitle', '新建'); 
	$('#new_dialog_ifram')[0].src='./saleunit_new_init/appoint/guangzhou/addSome.action?type='+type+'&id='+soid; 
	return false;
}

function addSome(type,soid){	
	$("#new_dialog").dialog({
		resizable: true,
		modal:true, 
		maximizable: false, 
		width:500,
		height:300,
		onClose:function(){
		reload();
		},
		buttons:[ {
			text:'提交',
			iconCls:'icon-ok',
			handler:function(){
			window.document.getElementById("new_dialog_ifram").contentWindow.formsubmit();
			
			}},
			{text:'关闭',
			iconCls:'icon-cancel',
			handler:function(){
				$('#new_dialog').dialog('close');
				//reload();
			}}
		]
	});
	$('#new_dialog').dialog('open');
	$('#new_dialog').dialog('setTitle', '新建'); 
	$('#new_dialog_ifram')[0].src='./saleunit_new_init/appoint/guangzhou/addSome.action?type='+type+'&id='+soid; 
	return false;
}


function reSome(type,sid){	
	 
	 var title = '修改名称';
	 var height = 220;
	 if(type == "rename_area"){
		 title = "修改名称及楼栋的排序";
		 height = 400;
	 }

	if(type == 'rename_project'){
		updateProject(type,sid);
		return;
	}
	if(type == 'rename_build'){
		updateBuild(type,sid);
		return;
	}
	$("#new_dialog").dialog({
		resizable: true,
		modal:true, 
		maximizable: false,
		width:450,
		height:height,
		onClose:function(){
			reloadParent();
		},
		buttons:[ {
			text:'提交',
			iconCls:'icon-ok',
			handler:function(){
				window.document.getElementById("new_dialog_ifram").contentWindow.formsubmit();
			}},
			{text:'关闭',
			iconCls:'icon-cancel',
			handler:function(){
			//	var newname = window.document.getElementById("new_dialog_ifram").contentWindow.getNewName();
				$('#new_dialog').dialog('close');
				//reloadParent();
			}}
		]
	});
	$('#new_dialog').dialog('open');
	$('#new_dialog').dialog('setTitle', title); 
	$('#new_dialog_ifram')[0].src='./saleunit_new_init/appoint/guangzhou/renameSome.action?id='+sid+"&type="+type; 
	return false;
}

function updateProject(type,sid){	
	$("#new_dialog").dialog({
		resizable: true,
		modal:true, 
		maximizable: false, 
		width:500,
		height:300,
		onClose:function(){
		reloadParent();
		},
		buttons:[ {
			text:'提交',
			iconCls:'icon-ok',
			handler:function(){
			window.document.getElementById("new_dialog_ifram").contentWindow.formsubmit();
			}},
			{text:'关闭',
			iconCls:'icon-cancel',
			handler:function(){
			//	var newname = window.document.getElementById("new_dialog_ifram").contentWindow.getNewName();
				$('#new_dialog').dialog('close');
				//reloadParent();
			}}
		]
	});
	$('#new_dialog').dialog('open');
	$('#new_dialog').dialog('setTitle', '修改楼盘信息'); 
	$('#new_dialog_ifram')[0].src='./saleunit_new_init/appoint/guangzhou/updateProjectDialog.action?upProId='+sid+"&type="+type; 
	return false;
}

/**
 * 修改楼栋 2012-10-12 增加删除功能
 * */
function updateBuild(type,sid){	
	$("#new_dialog").dialog({
		resizable: true,
		modal:true, 
		maximizable: false, 
		width:500,
		height:190,
		onClose:function(){
		reloadParent();
		},
		buttons:[ {
			text:'提交',
			iconCls:'icon-ok',
			handler:function(){
			window.document.getElementById("new_dialog_ifram").contentWindow.formsubmit();
			//dialogIframeSubmit('new_dialog_ifram','','pay_unit_form',this);
			}},
			{text:'关闭',
			iconCls:'icon-cancel',
			handler:function(){
			//	var newname = window.document.getElementById("new_dialog_ifram").contentWindow.getNewName();
				$('#new_dialog').dialog('close');
			}}
		]
	});
	$('#new_dialog').dialog('open');
	$('#new_dialog').dialog('setTitle', '修改楼栋信息'); 
	$('#new_dialog_ifram')[0].src='./saleunit_new_init/appoint/guangzhou/updateBuildDialog.action?upBuildId='+sid+"&type="+type+"?ts=<%= CacheUtils.getUrlTimeStamp()%>"; 
	return false;
}


//layout里面用

function getUnitMap(){
    if(build_id == '0'){
        return;
    }
    $.ajax({
        type:"get",
        url: "./saleunit_new_init/appoint/guangzhou/unitMap.action",

        data: "buildId=" + build_id + "&ts=" + new Date(),
        dataType: "html",
        beforeSend: function(){
            moduleMask('unit_map');
        },
        success: function(data){
            $("#unit_map").html(data);
        }
    });
}

function bindbutclass(str){
    $(str).hover(
            function () {
                $(this).addClass("btn1_mouseover");
            },
            function () {
                $(this).removeClass("btn1_mouseover btn1_d");
            }
    );
    $(str).mousedown(function(){
        $(this).removeClass("btn1_mouseover").addClass("btn1_d");
    });
}

function doCustomerBeforTab(){
    var utabs = $("#_customer_question_befor");
    utabs.load("./saleunit_new_init/appoint/guangzhou/customerBeforeTab.action?selectType=__init__");
}
function doUnitImage(){
	 if(click_unit_id != "0"){
		toGetUnitImageInfo(click_unit_id);
	 }
}

function doUnitInfo (){
	var utabs = $("#_unit_map");//指定显示单元信息的控件ID
	if(utabs.attr("uid") != click_unit_id){
		utabs.load("./saleunit_new_init/appoint/guangzhou/unitInfo.action?id="+click_unit_id+"");
		utabs.attr("uid",click_unit_id);
	}
}

//刷新
function refreshUnitInfo(){
	var utabs = $("#_unit_map");//指定显示单元信息的控件ID
	utabs.load("./saleunit_new_init/appoint/guangzhou/unitInfo.action?id="+click_unit_id+"");
}

function doMakePrice(){
	if(build_id == '0'){
		return false;
	}
	var utabs = $("#_make_price");
	utabs.load("./saleunit_new_init/appoint/guangzhou/makePriceTab.action?buildId="+build_id);
}

function doQuestion(){
	if(pro_pro_id == '0'){
		return false;
	}
	var utabs = $("#_customer_question");
	utabs.load("./saleunit_new_init/appoint/guangzhou/cusQuestion.action?buildId="+pro_pro_id);
}