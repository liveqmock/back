/**
 * 利用easyui的combobox来实现的公司项目查找框与楼盘项目,分区,楼栋的级联
 */
 
//moduleId绑定的查找下拉框id, selectType session key的类型(具体的值可以查看com.ihk.constanttype.EnumSelectTypeSessionKey.java),
//bindLeftTreeFn加载成功后要绑定的树的函数, bindLeftTreeArg绑定的树的函数参数(数组的形式),目前的情况bindLeftTreeArg只有selectType
function bindLeftCombobox(moduleId, selectType, bindLeftTreeFn, bindLeftTreeArg){
		
	$("#" + moduleId).combobox({
		delay:0,
		url: './saleunit_new/appoint/guangzhou/layoutAjax.action?selectType=' + selectType,
		valueField:'id',
		textField:'text',
		mode:'remote',				
		onHidePanel:function(){
		
			var textboxTmpValId = moduleId + "tmp__valId__";
			var oldIdVal = $("#" + textboxTmpValId).val();
			var newIdVal = $("#" + moduleId).combobox("getValue");					
			
			if(isNaN(newIdVal)){
				myAlert("选择的项目有误");
				return false;
			}
			
			if(oldIdVal == newIdVal){
				return false;
			}
			
			try{						
				
				var module = $("#" + moduleId).parent().parent().parent();
				var width = module.width();
				var height = module.height();
				
				var mask = '<div id="maskDiv" style="display: block;" class="datagrid-mask"></div>'; // width: 578px; height: 31px;
				var msg = '<div id="msgDiv" style="display: block;" class="datagrid-mask-msg">加载中...</div>'; //left: 242.5px; top: -5.5px; 
				
				$(module).append(mask);
				$(module).append(msg);
				
				$("#maskDiv").width(width+10).height(height+10);
				$("#msgDiv").css("left", width/4).css("top", height/2);
				
			}catch(e){}
			
			var rhref = $("#" + moduleId).attr('rhref');
			var toHref = rhref + "?selectType=" + selectType + "&selectProId=" + newIdVal;
			location.href = toHref;					
		},				
		onLoadSuccess:function(){
			//mode:'remote'时,每次查找都会执行改方法,判断隐藏域textboxTmpValId是否有值,如果有值就不用执行下去
		
			var textboxTmpValId = moduleId + "tmp__valId__";
			var textboxTmpTextId = moduleId + "tmp__textId__";
			
			if($("#" + textboxTmpValId).val() == undefined){
			
				$("#" + moduleId).after("<input type='hidden' id='" + textboxTmpValId + "'/>");
				$("#" + moduleId).after("<input type='hidden' id='" + textboxTmpTextId + "'/>");
				
				var textboxObj = $("#" + moduleId).combobox("textbox");
				$(textboxObj).focus(function(){
					
					$("#" + textboxTmpValId).val($("#" + moduleId).combobox("getValue"));
					$("#" + textboxTmpTextId).val($("#" + moduleId).combobox("getText"));
					
					$("#" + moduleId).combobox("showPanel");
					$("#" + moduleId).combobox("setText", "");
					
				}).blur(function(){
					
					$("#" + moduleId).combobox("setText", $("#" + textboxTmpTextId).val());
				});
				
				if(bindLeftTreeFn != "" && typeof bindLeftTreeFn == "function"){
				
					var argLength = bindLeftTreeArg.length;
					if(argLength > 0){
						
						var arr = new Array([argLength]);
						$(bindLeftTreeArg).each(function(index){
							arr[index] = bindLeftTreeArg[index];
						});
						bindLeftTreeFn.apply(bindLeftTreeFn, arr);
					}else{
						
						bindLeftTreeFn();
					}
					
				}
				
			}
			
		}
	});
	
}