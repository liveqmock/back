<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">

<head>
	
	<title>新建临定</title>
	
	<s:include value="../../customer/guangzhou/header_min.jsp"></s:include>	  
	
	<link href="./css/unit_table.css"  rel="stylesheet" type="text/css" charset="utf-8"/><!-- unit的样式 -->
	
	<script type="text/javascript" language="javascript" src="<%=basePath%>js/jquery.easyui.min.js"></script>
	<script type="text/javascript" language="javascript" src="<%=basePath%>css/local/easyui-lang-zh_CN.js"></script>
	<link href="./css/easyui.css" rel="stylesheet" type="text/css" charset="utf-8"/>
	<link href="./css/icon.css" rel="stylesheet" type="text/css" charset="utf-8"/>

	<script type="text/javascript" language="javascript" src="./js/easyui.utils.js"></script>
	<script type="text/javascript" language="javascript" src="./js/saleunit_sale.js?v=4.1"></script><!-- 管理销售弹出框 -->
	<script type="text/javascript" language="javascript" src="./js/saleunit_contract_customer.js?v=2"></script><!-- 合同客户弹出框 -->
	
	<script type="text/javascript" language="javascript">
		$().ready(function(){
			
			
			$("#payWayId").change(function(){
				
				var value = this.value;
				if(value != ""){
					
					$.ajax({
						type:"get",
						url: "./saleunit_new/appoint/guangzhou/getDetailTrByPayWayIdForXiaoZhu.action",
						data: "wayId=" + value,
						dataType: "html",
						success: function(data){						
							$("#detailTableId").html(data);							
						}						
					});
					
				}else{
					$("#detailTableId").html("");
				}				
			});
			
			initContractCustomerDataGrid("salesId", "${unit.id}", "${confirmType}", "customerId", "customer_table", "");
			
		});
				
	</script>
		
	<style type="text/css">
		*{margin:0;padding:0;}
		body{font-size:75%}
		
	</style>
	
</head>
<body>

<div class="gbox1">			

<form action="./saleunit_new/appoint/guangzhou/addConfirmBook.action" method="post" id="confirmBookFormId">
			  
	<table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" class="gbox" style="font-size:12px; line-height:26px">	
	
			  <tr bgcolor="#E9F5FF" style="empty-cells:show">
				
				<td id="t15" style="width:15%" align="right"><b>销售及客户</b>&nbsp;</td>
				<td colspan="3"></td>
			  </tr>
			  
			   <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
				<td id="t13" style="width:15%" align="right"><font color="#FF0000">*</font>销售人员&nbsp;</td>
                <td id="t14" colspan="2">				 	
						
				  <input type="text" id="salesName" class="readonly" readonly="readonly" style="width:85%"/>
				  <input type="hidden" id="salesId" name="confirmBook.salesId"/>
				  
				  <input type="hidden" id="customerId" name="customerId" />
				 </td>
				
                <td id="t16" style="width:30%">
				
				  <a href="javascript:void(0)" style="float:left; padding:0 10px 0 0" onclick="return modifySale('salesId', 'salesName', '__appoint__')">
				  <font color="#5482DE">选择销售</font></a>
				 </td>						
              </tr>	 
			  
			  <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" style="empty-cells:show">
			  
			  	<td colspan="4">
					
					<table id="customer_table" style="width:500;height:auto"></table>
				
				</td>
				
              </tr>	
				
			   <tr bgcolor="#E9F5FF" style="empty-cells:show">
				
				<td id="t15" style="width:15%" align="right"><b>基本资料</b>&nbsp;</td>
				<td colspan="3"></td>
			  </tr>
			  
			   <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
				<td id="t15" style="width:15%" align="right">临定日期&nbsp;</td>
                <td id="t16" style="width:30%">				 
					<input class="easyui-datebox" id="signDate" style="width:90px" value="${nowDate}" disabled="disabled"/>		
				 </td>
				<td id="t15" style="width:15%" align="right" colspan="2"></td>
              </tr>		
			  
			    <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
				<td id="t13" style="width:15%" align="right">临定物业&nbsp;</td>
                <td id="t14" colspan="3">
					${unit.allName}
				</td>		
              </tr>	 
			  
			   <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
				<td id="t13" style="width:15%" align="right"></td>
                <td id="t14" colspan="3">
					预售建筑面积约为${unit.preBuildArea}平方米,
					预售套内建筑面积约为${unit.preInsideArea}平方米
				</td>		
              </tr>	 
			  
			   <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
				
				<td id="t13" style="width:15%" align="right">临定物业楼价&nbsp;</td>
                <td id="t14" colspan="3">
					物业定价:￥${unit.sumPrice}元,
					优惠折扣<input name="confirmBook.discountPercent" id="discountPercent" class="easyui-numberspinner" 
			min="1" max="100" value="100" required="false" style="width:43px;"></input>(%)
					<!--,
					房间总价:<input type="text" id="sumMoney" name="confirmBook.sumMoney" value="${unit.sumPrice}"/>
					-->
				</td>		
				
              </tr>	 
			  
			   <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
				<td id="t13" style="width:15%" align="right">折扣说明&nbsp;</td>
                <td id="t14" colspan="3">
					<input id="discountDesc" name="confirmBook.discountDesc" style="width:70%"/>
				</td>		
              </tr>	 
			  
			   <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
				<td id="t13" style="width:15%" align="right">装修标准&nbsp;</td>
                <td id="t14" colspan="3">
					<input style="width:70%" id="renovateDesc" name="confirmBook.renovateDesc" value="${unit.renovateDesc}"/>
				</td>		
              </tr>	 
			  
			  <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
				<td id="t13" style="width:15%" align="right"><font color="#FF0000">*</font>应收订金&nbsp;</td>
                <td id="t14">
				￥<input type="text" class="money" id="bookMoney" name="confirmBook.bookMoney" />元			
				</td>		
                <td id="t15" style="width:15%" align="right">失效日期&nbsp;</td>
                <td id="t16" style="width:30%">
				<input class="easyui-datebox" id="endDate" name="confirmBook.endDate" style="width:90px"/>	
				  <input type="hidden" id="baseUrl" value="<%=basePath%>"/>			
				  <input type="hidden" id="confirmType" name="confirmCustomer.confirmType" value="${confirmType}" />
				  <input type="hidden" name="confirmBook.unitId" value="${unit.id}" />
				</td>			
              </tr>	 
			  
			  
			  <tr bgcolor="#E9F5FF" style="empty-cells:show">
				
				<td id="t15" style="width:15%" align="right"><b>付款方法</b>&nbsp;</td>
				<td colspan="3"></td>
			  </tr>
			 			  
				 <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
				<td id="t13" style="width:15%" align="right">付款方式&nbsp;</td>
                <td id="t14">
					<s:select list="selPayType" name="confirmBook.payWayId" cssStyle="width:auto" id="payWayId" />
				</td>		
                <td id="t15" style="width:15%" align="right"></td>
                <td id="t16" style="width:30%"></td>			
              </tr>	 
			  
			  <tr bgcolor="#E9F5FF" style="empty-cells:show">
			  	<td colspan="4">
					<table style="width:100%" id="detailTableId"></table>
				</td>
			  </tr>
			  							  
			</table>
</form>	
	
	</div>
		

</body>
</html>
