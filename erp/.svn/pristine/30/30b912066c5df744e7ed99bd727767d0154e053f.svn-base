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
			
			var _td = $(td);
		
			var saleState = _td.attr("state");
			var checkfeeType = _td.attr("checkfeeType");
			
			if(!(saleState == "8" || saleState == "9")){
				myAlert("单元状态为成交或合同才能选择");
				return;
			}
			
			var unitId = _td.attr("unitId");
			
			//判断有没有实收
			$.ajax({
				type:"get",
				url: "./saleunit_financial_tabs/guangzhou/isHaveReceiptByUnitId.action",							
				data: "unitId=" + unitId,
				dataType: "json",
				success: function(data){
					if(data.type == false){
						myAlert("该单元没有对应的实收");
						return false;
					}
					
					$(".changetd").removeClass("changetd");
					$(td).addClass("changetd");
					
					//增加选中的单元隐藏id
					var dialogButton = $("#myIframeDialog .dialog-button .l-btn", parent.document)[0];
					var btParent = $(dialogButton).parent();					
					btParent.find("#__changeUnitId__").remove();					
					var hiddenUnitId = "<input type='hidden' id='__changeUnitId__' value='" + unitId + "'/>";
					btParent.append(hiddenUnitId);
					
					//加载实收
					$("#receipt_div").load('./saleunit_financial_tabs/guangzhou/receiptListDialogByUnitId.action?unitId=' + unitId);					
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
						
	
   

