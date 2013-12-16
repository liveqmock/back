<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page contentType="text/html; charset=utf-8" %>

<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
	<base href="<%=basePath%>">		
	
	<script type="text/javascript" language="javascript">
		$(document).ready(function() {
		
			//可以和财务管理的单元显示合并,但是为了管理方便,不进行合并			
			$("#_dialog_for_").click(function() {
				var buildId = $("#hiddenBuildId").val();
				if(buildId != undefined && buildId != "" && buildId != "0"){
					dialog_unit_state_info(buildId);
				}
			});
			//点击左边的导航,还原为空状态
			if("${isRefresh}" == "false"){
				click_unit_id = "0";
				
				if("${build.id}" != ""){
					//表示选择的不是组合
					var hiddenVar = "<input type='hidden' id='hiddenBuildId' value='${build.id}'/>";
					var showVar = "<span id='showContent'>已选择==>&nbsp;&nbsp${build.descPropertyId},${build.areaName},${build.buildName}(${build.id})</span>";
				
					$("#_center_layout .panel-title").html(hiddenVar + showVar);
					$("#_dialog_for_").show();
					
				}else{
					$("#_dialog_for_").hide() ;
					$("#_center_layout .panel-title").html("&nbsp;");
				}
				
			}
		
			doUnitInfo();
		
			$("#unitTable td").bind({
		
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
	</script>
	

<s:if test="#request.trList.size > 0">
	<div style="height: auto;border: 0px solid #A9D9FF;float: left;">
		<table id="unitTable" border="0" align="center" cellpadding="0" cellspacing="1" class="gbox tb1" style="margin: 0px;width:auto;">
			 <s:iterator value="#request.trList" id="c">  
				${c}
			 </s:iterator>
		</table>

	</div>
</s:if>	
	
	 <s:iterator value="#request.groList" id="aa">  
			 <div style="height: auto;border: 0px solid #A9D9FF;background-color: ">
				 ${aa[0]}
				<table id="unitTable" border="0" align="center" cellpadding="0" cellspacing="1" class="gbox tb1" style="margin: 0px;width:auto;" >
					 <s:iterator value="#request.aa" id="cc" begin="1">  
						${cc}
					 </s:iterator>
				</table>
			</div>
	</s:iterator>
						
	
   

