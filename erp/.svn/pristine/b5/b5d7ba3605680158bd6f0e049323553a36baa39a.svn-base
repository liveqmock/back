<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page contentType="text/html; charset=utf-8" %>

<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html>
  <head>
	
	<title></title>
	
	<base href="<%=basePath%>"/>		

	<link href="./css/unit_table.css"  rel="stylesheet" type="text/css" charset="utf-8"/><!-- unit的样式 -->	
	<link href="./css/blue_guangzhou.css"  rel="stylesheet" type="text/css" charset="utf-8"/>
	
	<style type="text/css">
		*{margin:0;padding:0;}		
		.tb1 td{padding-left: 2px;width:50px; text-align:center; cursor: pointer}
		.tb1 tr{background-color:#FFFFFF}
		.seltd{background-color:#EEAD0E}
		.changetd{background-color:#EEAD0E}
		.exChangetd{background-color:#EEAD0E}		
		
	</style>	
	<script type="text/javascript" language="javascript" src="<%=basePath%>js/easyui.utils.js"></script>
	<script type="text/javascript" language="javascript" src="./js/jquery-1.6.2.min.js"></script>
	<script type="text/javascript" language="javascript" src="<%=basePath%>js/jquery.easyui.min.js"></script>	
	
	<script type="text/javascript" language="javascript">
	
		$(document).ready(function() {
		
			$("#unitChangeTable td").bind({
				
				//设置显示及单元隐藏id
				click : function() {
					tdClick(this);
				},
				//给单元格加鼠标经过的背景颜色
				mouseover : function() {
					tdOver(this);
				},
				mouseout : function() {
					tdOut(this);
				}
		
			});
			
		});
		
		function tdClick(td){
		
			
		
			
			var unitId = $(td).attr("unitid");
			//var buildId = $(td).attr("buildId");
			//var areaId = $(td).attr("areaId");
			
			$.ajax({
				type:"get",
				url: "./saleunit/common/getUnitAllNameForChip.action",							
				data: "unitId=" + unitId,
				dataType: "html",
				success: function(data){
					if(data=="full_chip"){
						alert("单元认筹已满，不能选择");
						return false;
					}
					if(data=="not_sale"){
						alert("非可售单元，不能选择");
						return false;
					}
					$(".changetd").removeClass("changetd");
					$(td).addClass("changetd");
					var dialogButton = $("#myIframeDialog .dialog-button .l-btn", parent.document)[0];
					var btParent = $(dialogButton).parent();
					
					btParent.find("#changeUnitId").remove();
					
					$.ajax({
						type:"get",
						
						url: "./saleunit/common/getUnitBuildAreaForChip.action",							
						data: "unitId=" + unitId,
						dataType: "json",
						success: function(data){
							var hiddenBuildId = "<input type='hidden' id='changeBuildId' value='" + data.buildId + "'/>"
							var hiddenAreaId = "<input type='hidden' id='changeAreaId' value='" + data.areaId + "'/>";
							var hiddenUnitId = "<input type='hidden' id='changeUnitId' value='" + unitId + "'/>";
							//var hiddenBuildId = "<input type='hidden' id='changeUnitId' value='" + buildId + "'/>";
							//var hiddenAreaId = "<input type='hidden' id='changeUnitId' value='" + areaId + "'/>";
							btParent.append(hiddenUnitId);
							btParent.append(hiddenBuildId);
							btParent.append(hiddenAreaId);
						}
					})
					
					
					window.parent.dialogNewSugg(dialogButton, data);
					
				}		
			});		
			
		}
		
		function tdOver(td) {
			var unitId = $(td).attr("unitid");
			if (unitId != "" && unitId != "0" && unitId != undefined) {
				$(td).addClass("seltd");
		
			}
		}
		
		function tdOut(td) {
			var unitId = $(td).attr("unitid");
			if (unitId != "" && unitId != "0" && unitId != undefined) {
				$(td).removeClass("seltd");
			}
		}
	</script>
	
	
  </head>
  
	<body>
		
		<s:if test="#request.trList.size > 0">
			<div style="height: auto;border: 0px solid #A9D9FF;float: left;">
				<table id="unitChangeTable" border="0" align="center" cellpadding="0" cellspacing="1" class="gbox tb1" style="margin: 0px;width:auto;">
					 <s:iterator value="#request.trList" id="c">  
						${c}
					 </s:iterator>
				</table>
		
			</div>
		</s:if>	
	
	 	<s:iterator value="#request.groList" id="aa">  
			 <div style="height: auto;border: 0px solid #A9D9FF;">
				 ${aa[0]}
				<table id="unitChangeTable" border="0" align="center" cellpadding="0" cellspacing="1" class="gbox tb1" style="margin: 0px;width:auto;" >
					 <s:iterator value="#request.aa" id="cc" begin="1">  
						${cc}
					 </s:iterator>
				</table>
			</div>
		</s:iterator>
		
	
	</body>
</html>