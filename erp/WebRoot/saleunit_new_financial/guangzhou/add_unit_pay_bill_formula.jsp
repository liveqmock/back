<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="pt" uri="/WEB-INF/projectText.tld" %> 

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html>
<head>
	
	<title>使用公式</title>
	
	<s:include value="../../header/header_easyui.jsp"></s:include>	  

	<script type="text/javascript" language="javascript" src="./js/saleunit_new_common_min.js"></script>
	<script type="text/javascript" language="javascript" src="./js/common.js"></script>
	<script type="text/javascript" language="javascript" src="./js/easyui.utils.js"></script>
	<script type="text/javascript" language="javascript" src="./js/project.text.utils.js"></script>
	
	<script type="text/javascript" language="javascript">
		$().ready(function(){
			$("#payWay").combobox({
				editable:false,
				onChange:function(newValue, oldValue){
				
					$("input[name='myPayWay.formula']").attr("checked", false);
					
					if(newValue == ""){
					
						$("#formulaTr").hide();
						$(".pro").hide();
					}else{
						
						$.ajax({
							type:"get",
							url: "./saleunit_financial_manager/guangzhou/isPayWayDetailHaveMortgage.action",
							data: "wayId=" + newValue,
							dataType: "json",
							success: function(data){
							
								if(data.type == "true"){
									$("#formulaTr").show();
								}else{
									$("#formulaTr").hide();
								}	
								$(".pro").hide();												
							}		
						});	
							
					}					
				}
			});
			
			$("#firstInstallment").numberbox({
				precision:2,
				onChange:function(newValue, oldValue){
					if(newValue == ""){
						$("#firstInstallment").numberbox("setValue", ""); 
						$("#mortgage").numberbox("setValue", "");
					}else{
						$("#mortgage").numberbox("setValue", (100-newValue));
					}
				}				
			});
			
			$("#mortgage").numberbox({
				precision:2,
				onChange:function(newValue, oldValue){
					if(newValue == ""){
						$("#firstInstallment").numberbox("setValue", ""); 
						$("#mortgage").numberbox("setValue", "");
					}else{
						$("#firstInstallment").numberbox("setValue", (100-newValue));
					}
				}				
			});
			
			bindModuleShowHidePanelById(["payWay"]);
			
			$("input[name='myPayWay.formula']").click(function(){
				$(".pro").hide();
				
				if(this.value == 1){
					$("#proShow1").show();
				}				
				$("#pro" + this.value).show();
				commCanel();
			});
			
			$("input[name='myPayWay.proportion']").click(function(){
				$("#firstInstallmentShow").val(100-this.value);
				$("#mortgageShow").val(this.value);				
				
			});
		});
		
		//选择设置方式要取消的内容
		function commCanel(){
			$("input[name='myPayWay.proportion']").attr("checked", false);
			
			$("#firstInstallmentShow").val(""); 
			$("#mortgageShow").val("");
			
			$("#firstInstallment").numberbox("setValue", ""); 
			$("#mortgage").numberbox("setValue", "");
			
			$("#firstInstallmentMoney").val(""); 
			$("#mortgageMoney").val("");			
		}	
		
	</script>
		
	<style type="text/css">
		*{margin:0;padding:0;}
		body{font-size:75%}
		
	</style>
	
</head>
<body>

<form action="./saleunit_financial_manager/guangzhou/addUnitPayBillFormula.action" method="post" id="addUnitPayBillFormulaFormId">
	<table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" class="gbox" style="font-size:12px; line-height:26px">		
		   <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			style="empty-cells:show">
			<td id="t13" style="width:30%" align="right"><font color="red">*</font>付款方式&nbsp;</td>
			<td id="t14"  colspan="3">
				<s:select list="selPayWay" id="payWay" name="myPayWay.payWayId" value=""></s:select>
				<input type="hidden" id="unitId" name="myPayWay.unitId" value="${unitId}"/>
			</td>		
					
		  </tr>	 
		  
		   <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			style="empty-cells:show; display:none" id="formulaTr">
			<td id="t13"  align="right"><font color="red">*</font>设置方式&nbsp;</td>
			<td id="t14" colspan="3">
				<s:radio list="selFormula" name="myPayWay.formula"></s:radio>
			</td>		
				
		  </tr>	 		
		  
		   <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			style="empty-cells:show; display:none" id="pro1" class="pro">
			<td id="t13"  align="right" width="10%"><font color="red">*</font>按揭比例&nbsp;</td>
			<td id="t14" colspan="3">
				<s:radio list="selProportion" name="myPayWay.proportion"></s:radio>
			</td>	
			
		  </tr>	 	
		  
		   <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			style="empty-cells:show; display:none" id="proShow1" class="pro">
			<td id="t13"  align="right" width="30%"><font color="red">*</font>首期比例&nbsp;</td>
			<td id="t14" width="30%">
				<input type="text" style="width:45%" class="readonly" readonly="readonly" id="firstInstallmentShow"/>(%)
			</td>		
			
			<td id="t13"  align="right" width="20%"><font color="red">*</font>按揭比例&nbsp;</td>
			<td id="t14" width="30%">
				<input type="text" style="width:60%" class="readonly" readonly="readonly" id="mortgageShow"/>(%)
			</td>
				
		  </tr>	 	
		  
		   <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			style="empty-cells:show; display:none" id="pro2" class="pro">
			<td id="t13"  align="right" width="30%"><font color="red">*</font>首期比例&nbsp;</td>
			<td id="t14" width="30%">
				<input type="text" style="width:45%" id="firstInstallment" class="easyui-numberbox" max="100" min="0" name="myPayWay.firstInstallment"/>(%)
				
			</td>		
			
			<td id="t13"  align="right" width="20%"><font color="red">*</font>按揭比例&nbsp;</td>
			<td id="t14" width="30%">
				<input type="text" style="width:45%" id="mortgage" class="easyui-numberbox" max="100" min="0" name="myPayWay.mortgage"/>(%)
			</td>
				
		  </tr>	 		
		  
		    <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			style="empty-cells:show; display:none" id="pro3" class="pro">
			<td id="t13"  align="right" width="30%"><font color="red">*</font>首期金额&nbsp;</td>
			<td id="t14" width="30%">
				<input type="text" style="width:45%" id="firstInstallmentMoney" name="myPayWay.firstInstallmentMoney"/>(元)
			</td>		
			
			<td id="t13"  align="right" width="20%"><font color="red">*</font>按揭金额&nbsp;</td>
			<td id="t14" width="30%">
				<input type="text" style="width:60%" id="mortgageMoney" name="myPayWay.mortgageMoney"/>(元)
			</td>
				
		  </tr>	 	  
		 
		</table>
</form>	
	
</body>
</html>
