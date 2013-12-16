<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
	<base href="<%=basePath%>">		
<style>
	.td_is_check{background: #FBEC88;}
</style>
						
<table  id="unitTable" border="0" align="center" cellpadding="0" cellspacing="1" class="gbox tb1" style="margin: 0px;width:auto;float: left;">
	 <s:if test="null!=#request.trList && !#request.trList.isEmpty()">
		 <s:iterator value="#request.trList" id="c">  
			${c}
		 </s:iterator>
	 </s:if>
	<s:else> 
		未创建单元
	</s:else>
</table>

<input type="hidden" id="hiddenUnitId" value=""/>

<script type="text/javascript" language="javascript">	
	
	$("#unitTable td").hover(function(){//单元背景色HOVER
			var unitId = $(this).attr("unitid");
			if(unitId != "" && unitId != "0" && unitId != undefined){			
				$(this).addClass("seltd");
			}
		},function(){
			var unitId = $(this).attr("unitid");
			if(unitId != "" && unitId != "0" && unitId != undefined){			
				$(this).removeClass("seltd");
			}
	});
		

	//控制下面单元信息和图片信息tabs
		
	//--
	function toUnloadImage(){
		var hiddenUnitId = click_unit_id;
			
		if(hiddenUnitId == undefined || hiddenUnitId == "" || hiddenUnitId == "0"){
			myAlert("请先选择单元");
			return false;
		}
		
		unloadImage(hiddenUnitId);
		return false;
	}
	
	function toGetUnitImageInfo(unitId){
		$.ajax({
			type:"post",
			url: "./saleunit_new/appoint/guangzhou/getUnitImageInfo.action",
			data: "unitId=" + unitId,
			dataType: "html",
			success: function(data){
				
				//先删除除了第一行的内容
				
				$(".imageTr:gt(0)").remove();
				if(data != ""){
					//$("#imageTable").appendTo();				
					 $(data).insertAfter($("#imageTable tr:eq(0)")); 
				}
				
			}		
		});
	}

	function doUoXls(){
		if(build_id == '0'){
			myAlert('请先选择对应的楼栋');
			return false;
		}
		$("#new_dialog").dialog({
			resizable: true,
			modal:true, 
			maximizable: false, 
			width:500,
			height:300,
			onClose:function(){
			$('#new_dialog_ifram').attr("src", "./saleunit_new/guangzhou/loading.jsp"); //清空内容
			},
			buttons:[{
				text:'提交',
				iconCls:'icon-ok',
				handler:function(){
					window.document.getElementById("new_dialog_ifram").contentWindow.tosubmit();
				}},{
				text:'关闭',
				iconCls:'icon-cancel',
				handler:function(){
					$('#new_dialog').dialog('close');
					doMakePrice();
				}
			}]
		});
		$('#new_dialog').dialog('open');
		$('#new_dialog').dialog('setTitle', '上传资料'); 
		$('#new_dialog_ifram')[0].src='./saleunit_new_init/appoint/guangzhou/uploadBuildXlsDialog.action?buildId='+build_id; 
	}
	
	$("#unitTable td").click(function(){//绑定选择单元事件
		var clickUnitId = $(this).attr("unitId");
		//如果是重复选择的单元信息 不刷新 
		if(clickUnitId == click_unit_id || clickUnitId == '0' || clickUnitId == undefined || clickUnitId == ""){
			return false;
		}else{
			var unitValue = $(this).text();
			
			$("#unitTable td").removeClass("td_is_check");
			$(this).addClass("td_is_check");
			click_unit_id = clickUnitId;
			$("#hiddenUnitId").val(click_unit_id);
			
			if(select_tabs == '单元信息'){
				doUnitInfo();
			}else if(select_tabs == '售后客户问卷'){
				doQuestion();
			}else if(select_tabs == '单元图片'){
				doUnitImage();
			}else if(select_tabs == '单元资料管理'){
				doMakePrice();
			}
		}
		
	});
	
	//控制下面单元信息和图片信息tabs  end~~~
	
	var resug;
	$(document).ready(function(){
		$("#_center_layout .panel-title").html("<span id='showContent'>已选择==>&nbsp;&nbsp${build.descPropertyId},${build.areaName},${build.buildName}</span>");

		$("#init_some_unit_but").unbind("click");
		$("#init_some_unit_but").click(function(){//弹出 批量新建单元
			$("#new_dialog").dialog({
				resizable: true,
				modal:true, 
				maximizable: false, 
				width:800,
				height:400,
				onClose:function(){
					getUnitMap();
				},
				buttons:[ {
					text:'提交',
					iconCls:'icon-ok',
					handler:function(){
						window.document.getElementById("new_dialog_ifram").contentWindow.tosubmit();
					}},
					{text:'关闭',
						iconCls:'icon-cancel',
						handler:function(){
						$('#new_dialog').dialog('close');
						getUnitMap();
					}}
				]
			});
			$('#new_dialog').dialog('open');
			$('#new_dialog').dialog('setTitle', '批量创建单元'); 
			$('#new_dialog_ifram')[0].src='./saleunit_new_init/appoint/guangzhou/initSomeUnit.action?buildId='+${buildId}; 
		});	


		$("#init_one_unit").unbind("click"); 
		$("#init_one_unit").click(function(){//弹出新建单个单元
			$("#new_dialog").dialog({
				resizable: true,
				modal:true, 
				maximizable: false, 
				width:500,
				height:500,
				onClose:function(){
					getUnitMap();
				},
				buttons:[ {
					text:'提交',
					iconCls:'icon-ok',
					handler:function(){
						window.document.getElementById("new_dialog_ifram").contentWindow.tosubmit();
					}},
					{text:'关闭',
						iconCls:'icon-cancel',
						handler:function(){
						$('#new_dialog').dialog('close');
						getUnitMap();
					}}
				]
			});
			$('#new_dialog').dialog('open');
			$('#new_dialog').dialog('setTitle', '创建单个单元'); 
			$('#new_dialog_ifram')[0].src='./saleunit_new_init/appoint/guangzhou/initOneUnit.action?buildId='+${buildId}; 
		});	
	
		$.messager.defaults = { ok: "确定", cancel: "取消" };
		$("#deleted_unit").unbind("click"); 
		$("#deleted_unit").click(function(){
			if(click_unit_id == '0'){
					$.messager.alert('提示框','请先选择单元',"question");
					return false;
				}
			var letd = $("td[unitid='"+click_unit_id+"']");
			$.messager.confirm('确定框','是否确定删除'+letd.text(),function(r){  
				if (r){  
					$.getJSON('./saleunit_new_init/appoint/guangzhou/delOneUnit.action',{'selectuid':click_unit_id},function(date){
						$.messager.alert('提示',date.sug);
						//alert(date.sug);
						if(date.flush == "true"){getUnitMap();}
					});
				}
			});
					
		});	

		$("#update_unit").unbind("click"); 
		$("#update_unit").click(function(){//弹出修改单个单元
			if(click_unit_id == '0'){
				myAlert('请先选择单元');
				return false;
			}
			$("#new_dialog").dialog({
				resizable: true,
				modal:true, 
				maximizable: false, 
				width:500,
				height:500,
				onClose:function(){
					refreshUnitInfo();
					$('#new_dialog_ifram').attr("src", "./saleunit_new/guangzhou/loading.jsp"); //清空内容
				},
				buttons:[ {
					text:'提交',
					iconCls:'icon-ok',
					handler:function(){
					window.document.getElementById("new_dialog_ifram").contentWindow.tosubmit();
					}},
					{text:'关闭',
						iconCls:'icon-cancel',
					handler:function(){
						$('#new_dialog').dialog('close');
						getUnitMap();
					}}
				]
			});
			$('#new_dialog').dialog('open');
			$('#new_dialog').dialog('setTitle', '修改所选单元'); 
			$('#new_dialog_ifram')[0].src='./saleunit_new_init/appoint/guangzhou/updateOneUnit.action?buildId='+${buildId} +'&unitId='+click_unit_id;
		});	

		$("#update_some_unit").unbind("click"); 
		$("#update_some_unit").click(function(){//弹出批量修改单元
			if(build_id == '0'){
				myAlert('请先选择楼栋');
				return false;
			}
			$("#new_dialog").dialog({
				resizable: true,
				modal:true, 
				maximizable: false, 
				width:500,
				height:500,
				onClose:function(){
				$('#new_dialog_ifram').attr("src", "./saleunit_new/guangzhou/loading.jsp"); //清空内容
				},
				buttons:[ 
					{text:'关闭',
						iconCls:'icon-cancel',
					handler:function(){
						$('#new_dialog').dialog('close');
						getUnitMap();
					}}
				]
			});
			$('#new_dialog').dialog('open');
			$('#new_dialog').dialog('setTitle', '批量 修改/删除 单元'); 
			$('#new_dialog_ifram')[0].src='./saleunit_new_init/appoint/guangzhou/updateSomeUnit.action?buildId='+${buildId}; 
		});	
		
		/*$("#up_load_xls").unbind("click");
		$("#up_load_xls").click(function(){
			doUoXls();
		})*/	
	});
			
</script>