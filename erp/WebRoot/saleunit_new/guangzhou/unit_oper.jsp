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
		
		function tdClick(td){
			var salestate=$(td).attr("salestate");
			if(salestate!="sale_state_2"){
				myAlert("只能选择可售单元");
				return;
			}
			$(".changetd").removeClass("changetd");
			$(td).addClass("changetd");
		
			var dialogButton = $("#myIframeDialog .dialog-button .l-btn", parent.document)[0];
			var unitId = $(td).attr("unitid");
			
			$.ajax({
				type:"get",
				url: "./saleunit/common/getUnitAllName.action",							
				data: "unitId=" + unitId,
				dataType: "html",
				success: function(data){
				
					var btParent = $(dialogButton).parent();
					
					btParent.find("#__changeUnitId__").remove();
					
					var hiddenUnitId = "<input type='hidden' id='__changeUnitId__' value='" + unitId + "'/>";
					btParent.append(hiddenUnitId);
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
						
	
   

