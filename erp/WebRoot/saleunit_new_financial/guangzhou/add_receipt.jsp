<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="pt" uri="/WEB-INF/projectText.tld" %> 
<%@ taglib prefix="my" uri="/WEB-INF/my.tld" %> 

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html>
<head>
	
	<title>添加收款单据</title>
	
	<s:include value="../../customer/guangzhou/header_min.jsp"></s:include>	  
	
	<script type="text/javascript" language="javascript" src="<%=basePath%>js/jquery.easyui.min.js"></script>
	<script type="text/javascript" language="javascript" src="<%=basePath%>css/local/easyui-lang-zh_CN.js"></script>
	<link href="./css/easyui.css" rel="stylesheet" type="text/css" charset="utf-8"/>
	<link href="./css/icon.css" rel="stylesheet" type="text/css" charset="utf-8"/>

	<%/*
	<script type="text/javascript" language="javascript">
		$().ready(function(){
		
			closeIframeDialog("myIframeDialog", "${closeMark}", "", "${suggestion}");
			
			var moduleIds = ["receiptAddress","payType","billType","recordedBank"];
			initProjectTextComboboxForAuto(moduleIds);
			
			$("#cashMoney").blur(function(){setAmountMoney()});
			$("#cardMoney").blur(function(){setAmountMoney()});
			$("#transferMoney").blur(function(){setAmountMoney()});
			$("#checkMoney").blur(function(){setAmountMoney()});
			
			$("#intoMoney").blur(function(){setAmountMoney()});
			$("#sincerityMoney").blur(function(){setAmountMoney()});
			$("#couponMoney").blur(function(){setAmountMoney()});
			$("#otherMoney").blur(function(){setAmountMoney()});
									
		});
		
		//点击收款单选框
		function initPayMoney(billId){
			//pay_
			var bill = $("#cb_" + billId);
			var checked = bill.attr("checked");
			if(checked){
				var money = bill.attr("notPay");
				$("#pay_" + billId).val(money);
			}else{
				$("#pay_" + billId).val("");
			}
			
			setAllMoney();			
		}
		
		//本次收款
		function changePayMoney(){
			
			setAllMoney();			
		}
		
		//获取本次收款总和
		function getAllMoney(){
			var allMoney = "0";
			var pay_input = $(".pay_input");
			var length = pay_input.length;
			for(var i=0; i<length; i++){
				var value = pay_input[i].value;
				if(value != ""){
					allMoney = parseInt(allMoney) + parseInt(value);
				}
			}
			return allMoney;
		}
		
		//设置本次收款总和
		function setAllMoney(){
				
			var allMoney = getAllMoney();
			$("#showAllMoney").html(allMoney);
			$("#receiptMoneyShow").html(allMoney);
			$("#receiptMoney").val(allMoney);
				
		}
		
		//获取开票金额总和 amountMoney
		function setAmountMoney(){
			
			var amountMoney = toNumber("cashMoney") + toNumber("cardMoney") + toNumber("transferMoney") + toNumber("checkMoney") + 
				toNumber("intoMoney") + toNumber("sincerityMoney") + toNumber("couponMoney") + toNumber("otherMoney");
				
			$("#amountMoney").html(amountMoney);
			
		}
		
		//空就转为0
		function toNumber(moneyId){
			var money = $("#" + moneyId).val();
			if(money == "" || isNaN(money)){
				$("#" + moneyId).val("");
				return 0;
			}
			
			return parseInt(money);
		}				
		
	</script>
	*/%>
	
	<script type="text/javascript" language="javascript">
	
		$().ready(function(){
			
			$("#typeName").combobox({
				editable:false,
				onChange:function(newValue, oldValue){
					
					var unitId = ${unit.id};
					var url = "./saleunit_financial_manager/guangzhou/getFeeTypeByTypeNameForComboBox.action?unitId=" + unitId + "&typeName=" + newValue;
					
					$("#feeType").combobox("reload", url);
					$("#feeType").combobox("select", ""); 
				},
				onLoadSuccess:function(){					
					
				}
			});		
			
			$("#feeType").combobox({
				editable:false,
				valueField:'projectTextValue',
				textField:'projectTextText',
				
			});
	});
	</script>
		
	<style type="text/css">
		*{margin:0;padding:0;}
		body{font-size:75%}
		.isVoid1{text-decoration:line-through}
		.isVoid0{}
		
	</style>
	
</head>
<body>
<div class="gbox1">			

<form action="./saleunit_financial_manager/guangzhou/addReceipt.action" method="post" id="addReceiptFormId">
			  
	<table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" class="gbox" style="font-size:12px; line-height:26px">	
	
		  <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			style="empty-cells:show">
			<td id="t13" style="width:15%" align="right"><font color="red">*</font>单元编号&nbsp;</td>
			<td id="t14" style="width:25%" colspan="3">
			${unit.allName}
			<input type="hidden" name="receipt.unitId" value="${unit.id}" />
			</td>						
		  </tr>	 
		  
		  <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
				<td id="t13" style="width:15%" align="right"><font color="red">*</font>收款类别&nbsp;</td>
                <td id="t14" style="width:30%">
					<s:select list="selPayType" cssStyle="width:auto" id="typeName" name="receipt.typeName"/>
				</td>		
                <td id="t15" style="width:15%" align="right"><font color="red">*</font>收款内容&nbsp;</td>
                <td id="t16" style="width:30%">
					<s:select list="selFeeType" cssStyle="width:auto" id="feeType" name="receipt.feeType"/>
				</td>			
              </tr>	 
	
		  <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			style="empty-cells:show">
			<td id="t13" style="width:15%" align="right"><font color="red">*</font>收款日期&nbsp;</td>
			<td id="t14" style="width:25%">
				<input class="easyui-datebox" id="receiptDate" name="receipt.receiptDate" style="width:90px" value="${nowDate}"/>				</td>					
			<td id="t15" style="width:15%" align="right"><font color="red">*</font>单据编号&nbsp;</td>
			<td id="t16" style="width:25%">
				<input type="text" id="billNo" name="receipt.billNo"/>				</td>	
		  </tr>	 
		  
		   <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			style="empty-cells:show">
			<td id="t13" style="width:15%" align="right">客户姓名&nbsp;</td>
			<td id="t14" style="width:25%">
				<input type="text" id="payMan" name="receipt.payMan"/>				</td>					
			<td id="t13" style="width:15%" align="right"><font color="red">*</font>收款金额&nbsp;</td>
			<td id="t14" style="width:25%">
				<input type="text" id="receiptMoney" name="receipt.receiptMoney" style="width:90px"/>				</td>	
		  </tr>	 
		  
		   <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			style="empty-cells:show">
			<td id="t15" style="width:15%" align="right"><font color="red">*</font>收款人&nbsp;</td>
			<td id="t16" style="width:25%">
				<input type="text" id="inputMan" name="receipt.inputMan" value="${LOGIN_SESSION.realName}"/>				</td>				
			<td id="t15" style="width:15%" align="right"></td>
			<td id="t16" style="width:25%"></td>	
		  </tr>	 
			  
			</table>
</form>	
	
	</div>



</body>
</html>
