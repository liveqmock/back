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
	
	<title>收款单据</title>
	
	<s:include value="../../customer/guangzhou/header_min.jsp"></s:include>	  
	
	<link href="./css/unit_table.css"  rel="stylesheet" type="text/css" charset="utf-8"/><!-- unit的样式 -->
	
	<script type="text/javascript" language="javascript" src="<%=basePath%>js/jquery.easyui.min.js"></script>
	<script type="text/javascript" language="javascript" src="<%=basePath%>css/local/easyui-lang-zh_CN.js"></script>
	<link href="./css/easyui.css" rel="stylesheet" type="text/css" charset="utf-8"/>
	<link href="./css/icon.css" rel="stylesheet" type="text/css" charset="utf-8"/>

	<script type="text/javascript" language="javascript" src="./js/saleunit_new_common_min.js"></script>
	<script type="text/javascript" language="javascript" src="./js/common.js"></script>
	<script type="text/javascript" language="javascript" src="./js/project.text.utils.js"></script>
	
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

<form action="./saleunit_financial_manager/guangzhou/updateReceipt.action" method="post" id="updateReceiptFormId">
			  
	<table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" class="gbox" style="font-size:12px; line-height:26px">		
		 
		 <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			style="empty-cells:show">
			<td id="t13" style="width:15%" align="right"><font color="red">*</font>单元编号&nbsp;</td>
			<td id="t14" style="width:25%" colspan="3">
			${unit.allName}
			<input type="hidden" name="receipt.unitId" value="${unit.id}" />
			
			<input type="hidden" name="receipt.id" value="${receipt.id}" />
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
				<input class="easyui-datebox" id="receiptDate" name="receipt.receiptDate" style="width:90px" 
				value='<s:date name="receipt.receiptDate" format="yyyy-MM-dd "/>'/>				</td>					
			<td id="t15" style="width:15%" align="right"><font color="red">*</font>单据编号&nbsp;</td>
			<td id="t16" style="width:25%">
				<input type="text" id="billNo" name="receipt.billNo" value="${receipt.billNo}"/>				</td>	
		  </tr>	 
		  
		   <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			style="empty-cells:show">
			<td id="t13" style="width:15%" align="right">客户姓名&nbsp;</td>
			<td id="t14" style="width:25%">
				<input type="text" id="payMan" name="receipt.payMan" value="${receipt.payMan}"/>				</td>					
			<td id="t13" style="width:15%" align="right"><font color="red">*</font>收款金额&nbsp;</td>
			<td id="t14" style="width:25%">
				<input type="text" id="receiptMoney" name="receipt.receiptMoney" style="width:90px" value="${receipt.receiptMoney}"/>				</td>	
		  </tr>	 
		  
		   <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			style="empty-cells:show">
			<td id="t15" style="width:15%" align="right"><font color="red">*</font>收款人&nbsp;</td>
			<td id="t16" style="width:25%">
				<input type="text" id="inputMan" name="receipt.inputMan" value="${receipt.inputMan}"/>				</td>				
			<td id="t15" style="width:15%" align="right"></td>
			<td id="t16" style="width:25%"></td>	
		  </tr>	 
		  
		 
					
			<%/*
			
			   <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
				<td id="t13" style="width:15%" align="right"><font color="red">*</font>收款日期&nbsp;</td>
                <td id="t14" style="width:25%">
					<input class="Wdate" id="receiptDate" name="receipt.receiptDate" style="width:90px"
					value='<s:date name="receipt.receiptDate" format="yyyy-MM-dd "/>'/>
					
				</td>		
                <td id="t15" style="width:15%" align="right">
					<input type="hidden" name="receipt.id" value="${receipt.id}" />
					<input type="hidden" name="receipt.feeType" value="${receipt.feeType}" />
					<input type="hidden" name="receipt.unitId" value="${unit.id}" />
				</td>
                <td id="t16" style="width:25%"></td>	
				<td id="t15" style="width:15%" align="right"><font color="red">*</font>单据编号&nbsp;</td>
                <td id="t16" style="width:25%">
					<input type="text" id="billNo" name="receipt.billNo" style="" value="${receipt.billNo}"/>				</td>	
              </tr>	 
			  
			   <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
				<td id="t13" style="width:15%" align="right"><font color="red">*</font>缴款人名称&nbsp;</td>
                <td id="t14">
					<input type="text" id="payMan" name="receipt.payMan" value="${receipt.payMan}"/>				</td>		
                <td id="t15" style="width:15%" align="right">单元编号&nbsp;</td>
                <td id="t16" style="width:25%">${unit.allName}</td>			
				<td id="t15" style="width:15%" align="right">建筑面积&nbsp;</td>
                <td id="t16" style="width:25%">${unit.buildArea}</td>	
              </tr>	 
			  
			   <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
				<td id="t13" style="width:15%" align="right">认购书号&nbsp;</td>
                <td id="t14">${unit.confirm.agreeNo}</td>		
                <td id="t15" style="width:15%" align="right">成交价&nbsp;</td>
                <td id="t16" style="width:25%">${unit.sumPrice}</td>			
				<td id="t15" style="width:15%" align="right">合同号&nbsp;</td>
                <td id="t16" style="width:25%">${unit.contract.contractNo}</td>	
              </tr>	 
			  
			   <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
				<td id="t13" style="width:15%" align="right"><font color="red">开票金额&nbsp;</font></td>
                <td id="t14">
					<font color="red"><span id="receiptMoneyShow">${receipt.receiptMoney}</span></font>
					<input type="hidden" id="receiptMoney" name="receipt.receiptMoney" value="${receipt.receiptMoney}"/>
				</td>		
                <td id="t15" style="width:15%" align="right">大写&nbsp;</td>
                <td id="t16" style="width:25%" colspan="3"></td>		
              </tr>	 
			  
			   <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
				<td id="t13" style="width:15%" align="right">现金&nbsp;</td>
                <td id="t14">
					<input type="text" id="cashMoney" name="receipt.cashMoney" value="${receipt.cashMoney}"/>				</td>		
                <td id="t15" style="width:15%" align="right">刷卡&nbsp;</td>
                <td id="t16" style="width:25%">
					<input type="text" id="cardMoney" name="receipt.cardMoney" value="${receipt.cardMoney}"/>				</td>	
				<td rowspan="2" align="right" id="t15" style="width:15%"><font color="red">收入类</font>&nbsp;</td>
                <td rowspan="2" id="t16" style="width:25%"></td>			
              </tr>	 
			  
			   <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
				<td id="t13" style="width:15%" align="right">转账&nbsp;</td>
                <td id="t14">
					<input type="text" id="transferMoney" name="receipt.transferMoney" value="${receipt.transferMoney}"/>				</td>		
                <td id="t15" style="width:15%" align="right">支票&nbsp;</td>
                <td id="t16" style="width:25%">
					<input type="text" id="checkMoney" name="receipt.checkMoney" value="${receipt.checkMoney}"/>				</td>	
			  </tr>	 
			  
			  
			   <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
				<td id="t13" style="width:15%" align="right">转入金额&nbsp;</td>
                <td id="t14">
					<input type="text" id="intoMoney" name="receipt.intoMoney" value="${receipt.intoMoney}"/>				</td>		
                <td id="t15" style="width:15%" align="right">诚意金&nbsp;</td>
                <td id="t16" style="width:25%">
					<input type="text" id="sincerityMoney" name="receipt.sincerityMoney" value="${receipt.sincerityMoney}"/>				</td>			
				<td rowspan="2" align="right" id="t15" style="width:15%"><font color="red">非收入类</font>&nbsp;</td>
                <td rowspan="2" id="t16" style="width:25%"></td>	
              </tr>	 
			  
			   <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
				<td id="t13" style="width:15%" align="right">购房券&nbsp;</td>
                <td id="t14">
					<input type="text" id="couponMoney" name="receipt.couponMoney" value="${receipt.couponMoney}"/>				</td>		
                <td id="t15" style="width:15%" align="right">其他&nbsp;</td>
                <td id="t16" style="width:25%">
					<input type="text" id="otherMoney" name="receipt.otherMoney" value="${receipt.otherMoney}"/>				</td>	
			  </tr>	 
			  
			   <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
				<td id="t13" style="width:15%" align="right"><font color="red">合计</font>&nbsp;</td>
                <td id="t14"><font color="red"><span id="amountMoney">${receipt.receiptMoney}</span></font></td>		
                <td id="t15" style="width:15%" align="right">是否记账&nbsp;</td>
                <td id="t16" style="width:25%">
					
					<s:radio list="selIsKeep" name="receipt.isKeep"></s:radio>
				</td>	
				<td id="t15" style="width:15%" align="right"><font color="red">*</font>收款地点&nbsp;</td>
                <td id="t16" style="width:25%">
				
					<pt:sel cssStyle="width:auto" id="receiptAddress" name="receipt.receiptAddress" typeName="${receiptAddress}" value="${receipt.receiptAddress}"/>
				</td>			
              </tr>	 
			  
			   <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
				<td id="t15" style="width:15%" align="right">支票号码&nbsp;</td>
                <td id="t16" style="width:25%">
					<input type="text" id="checkNo" name="receipt.checkNo" value="${receipt.checkNo}"/>				</td>	
				<td id="t13" style="width:15%" align="right"><font color="red">*</font>付款类型&nbsp;</td>
                <td id="t14">
					
					<pt:sel cssStyle="width:auto" id="payType" name="receipt.payType" typeName="${payType}" value="${receipt.payType}"/>
				</td>		
                <td id="t15" style="width:15%" align="right"><font color="red">*</font>单据类别&nbsp;</td>
                <td id="t16" style="width:25%">
					
					<pt:sel cssStyle="width:auto" id="billType" name="receipt.billType" typeName="${billType}" value="${receipt.billType}"/>
				</td>	
              </tr>	 
			  
			   <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
				<td id="t13" style="width:15%" align="right">财务凭证号&nbsp;</td>
                <td id="t14">
					<input type="text" id="financeCert" name="receipt.financeCert" value="${receipt.financeCert}"/>				</td>		
                <td id="t15" style="width:15%" align="right">凭证日期&nbsp;</td>
                <td id="t16" style="width:25%">
					<input class="Wdate" id="certDate" name="receipt.certDate" style="width:90px"
					value='<s:date name="receipt.certDate" format="yyyy-MM-dd "/>'/>
					
				</td>	
				<td id="t15" style="width:15%" align="right">入账银行&nbsp;</td>
                <td id="t16" style="width:25%">
					<pt:sel cssStyle="width:auto" id="recordedBank" name="receipt.recordedBank" typeName="${recordedBank}" value="${receipt.recordedBank}"/>
				</td>			
              </tr>	 
			  
			   <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
				<td id="t13" style="width:15%" align="right">备注&nbsp;</td>
                <td id="t14" colspan="5">
					<input type="text" id="remark" name="receipt.remark" style="width:76%" value="${receipt.remark}"/>				</td>		
              </tr>	 
					
              </tr>	 
			  
			   <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
				<td id="t13" style="width:15%" align="right">出纳&nbsp;</td>
                <td id="t14">
					<input type="text" id="cashierMan" name="receipt.cashierMan" value="${receipt.cashierMan}"/>				</td>		
                <td id="t15" style="width:15%" align="right">经办人&nbsp;</td>
                <td id="t16" style="width:25%">
					<input type="text" id="inputMan" name="receipt.inputMan" value="${receipt.inputMan}"/>				</td>	
				<td id="t15" style="width:15%" align="right">会计&nbsp;</td>
                <td id="t16" style="width:25%">
					<input type="text" id="accountMan" name="receipt.accountMan" value="${receipt.accountMan}"/>				</td>			
              </tr>	 
			  
			    <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
				 <td colspan="6">
				 
				 <table  border="0" align="center" cellpadding="0" cellspacing="1" class="gbox unit_table" width="100%" id="payBillTableId">
				 
				 	<tr  style="line-height: 20px;background:#E9F5FF" > 
				<th width="100" align="center">类别</th>
				<th width="100" align="center">收费项目</th>
				<th width="100" align="center">期数</th>
				<th width="100" align="center">应收日期</th>
				<th width="100" align="center">应收金额</th>
				<th width="100" align="center">已收金额</th>
				<th width="100" align="center">未收金额</th>
				<th width="100" align="center">本次收款</th>
				<th width="50" align="center">收款</th>
			</tr>
			<tr  style="line-height: 20px;background:#ffffff" > 
				<td width="100" align="center">总计 </td>
				<td width="100" align="center"></td>
				<td width="100" align="center"></td>
				<td width="100" align="center"></td>
				<td width="100" align="center" class="rmb_format"><my:format value="${allShouldPay}"/></td>
				<td width="100" align="center" class="rmb_format"><my:format value="${allHadPay}"/></td>
				<td width="100" align="center" class="rmb_format"><my:format value="${allNotPay}"/></td>
				<td width="50" align="center" id="showAllMoney">${receipt.receiptMoney}</td>
				<td width="100" align="center"></td>
			</tr>
			
			<s:iterator value="unitPayBillList" var="c">
				 <tr bgcolor="#FFFFFF" style="line-height: 20px;" billId="${c.id}" class="isVoid${c.isVoid}">  
					<td width="100" align="center" >${c.typeName} </td>
					<td width="100" align="center">${c.feeType}</td>
					<td width="100" align="center">${c.seqNum}</td>
					<td width="100" align="center"> 
						<s:date name="#request.c.payDate" format="yyyy-MM-dd"/>
					  </td>
					<td width="100" align="center" class="rmb_format"><my:format value="${c.shouldPay}"/></td>
					<td width="100" align="center" class="rmb_format"><my:format value="${c.hadPay}"/></td>
					<td width="100" align="center" class="rmb_format"><my:format value="${c.notPay}"/></td>
					<td align="center"><input type="text" id="pay_${c.id}" name="__receiptDetail__${c.detail.id}" value="${c.thisPay}" 
						class="pay_input" style="width:80%" onchange="changePayMoney()"/></td>
					<td width="100" align="center"><input type="checkbox" id="cb_${c.id}" notPay="${c.notPay}" onclick="initPayMoney(${c.id})"/></td>
				</tr>
			</s:iterator>
			
			</table>
				 
				 </td>
				</tr>
			*/%>
			  
			</table>
</form>	
	
	</div>



</body>
</html>
