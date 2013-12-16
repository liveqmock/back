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

	<script type="text/javascript" language="javascript" src="<%=basePath%>js/saleunit_new_unit_info.js"></script>
	<script type="text/javascript" language="javascript" src="./js/saleunit_sale.js"></script><!-- 管理销售弹出框 -->
	<script type="text/javascript" language="javascript" src="./js/saleunit_new_common_min.js"></script>
	<script type="text/javascript" language="javascript" src="./js/common.js"></script>
	
	<script type="text/javascript" language="javascript">
		$().ready(function(){
		
			closeIframeDialog("myIframeDialog", "${closeMark}", "", "${suggestion}");
			
			//baseAutoComplete("customerName", "customerHiddenId", "./saleunit_new/appoint/guangzhou/contractCustomerList.action", "confirmType");
			
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
			
			$("#selChipCustomerId").change(function(){
			
				var value = this.value;  //chipId
				if(value != ""){
					
					$.ajax({
						type:"get",
						url: "./saleunit_chip_manager/guangzhou/ajaxChipCustomerFromChipIdForAddTempConfirm.action",
						data: "chipId=" + value,
						dataType: "json",
						success: function(data){
							
							$("#customerName").val(data.customerName);
							$("#customerHiddenId").attr("value", data.id);
							$("#phone").val(data.phone);
							$("#idcardNo").val(data.idcardNo);
							$("#address").val(data.address);
							$("#bookMoney").val(data.bookMoney);
							
						}
						
					});
				
				}else{
				
					$("#customerName").val("");
					$("#customerHiddenId").attr("value", "");
					$("#phone").val("");
					$("#idcardNo").val("");
					$("#address").val("");
					$("#bookMoney").val("");
					
				}
				
				
			});
			
		});
		
	</script>
		
	<style type="text/css">
		*{margin:0;padding:0;}
		body{font-size:75%}
		
	</style>
	
</head>
<body>
<div class="gbox1">			

<form action="./saleunit_new/appoint/guangzhou/saveTempConfirmDialog.action" method="post" id="tempConfirmFormId">
			  
	<table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" class="gbox" style="font-size:12px; line-height:26px">	
	
			  <tr bgcolor="#E9F5FF" style="empty-cells:show">
				
				<td id="t15" style="width:15%" align="right"><b>认筹情况</b>&nbsp;</td>
				<td colspan="3"><font color="#FF0000"><span id="suggestion"><s:property value="#request.session.suggestion"/></span></font></td>
			  </tr>

              <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
				<td id="t15" style="width:15%" align="right">认筹单号+客户姓名&nbsp;</td>
                <td id="t16" style="width:30%">				 
					<s:select list="selChipCustomer" cssStyle="width:auto" id="selChipCustomerId" />					
				 </td>
				<td id="t15" style="width:15%" align="right" colspan="2"></td>
              </tr>			
		 
			  
			  <tr bgcolor="#E9F5FF" style="empty-cells:show">
				
				<td id="t15" style="width:15%" align="right"><b>基本资料</b>&nbsp;</td>
				<td colspan="3"></td>
			  </tr>

              <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
				<td id="t15" style="width:15%" align="right">临定日期&nbsp;</td>
                <td id="t16" style="width:30%">				 
					<input class="Wdate" id="signDate" style="width:90px" value="${nowDate}" disabled="disabled"/>		
				 </td>
				<td id="t15" style="width:15%" align="right" colspan="2"></td>
              </tr>		
				
			   <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
				<td id="t13" style="width:15%" align="right"><font color="#FF0000">*</font>客户名称&nbsp;</td>
                <td id="t14" colspan="3">	

				<input id="customerName" name="confirmCustomer.customerName" type="text" style="width:70%"/>
				<input type="hidden" id="customerHiddenId" name="confirmCustomer.id"/>
			
				</td>			
              </tr>	 
			  
			   <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
				<td id="t13" style="width:15%" align="right"><font color="#FF0000">*</font>联系电话&nbsp;</td>
                <td id="t14">
				<input type="text" id="phone" name="confirmCustomer.phone" style="width:85%"/>
				</td>		
                <td id="t15" style="width:15%" align="right">客户证件号码&nbsp;</td>
                <td id="t16" style="width:30%">
				<input type="text" id="idcardNo" name="confirmCustomer.idcardNo" />
				</td>			
              </tr>	 
			 
			  
			   <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
				<td id="t13" style="width:15%" align="right">通信地址&nbsp;</td>
                <td id="t14" colspan="3">				
				<input type="text" id="address" name="confirmCustomer.address" style="width:70%"/>
				</td>	
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
				<td id="t13" style="width:15%" align="right"></td>
                <td id="t14" colspan="3">
					折扣说明:<input id="discountDesc" name="confirmBook.discountDesc" style="width:70%"/>
				</td>		
              </tr>	 
			  
			   <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
				<td id="t13" style="width:15%" align="right"></td>
                <td id="t14" colspan="3">
					装修标准:<input style="width:70%" id="renovateDesc" 
					name="confirmBook.renovateDesc" value="${unit.renovateDesc}"/>
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
				<input class="Wdate" id="endDate" name="confirmBook.endDate" style="width:90px"/>	
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
			  						  
			  <!--
			  <tr bgcolor="#E9F5FF" style="empty-cells:show">
				
				<td id="t15" style="width:15%" align="right"><b>临定条款</b>&nbsp;</td>
				<td colspan="3"></td>
			  </tr>
			  
			   <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
				<td id="t13" style="width:15%" align="right">&nbsp;</td>
               <td id="t14" colspan="3">
					临定方须于<input class="Wdate" id="endDate" style="width:90px" name="confirmBook.endDate" />或按约定时间前到出售方指定的地点签署&lt;&lt;商品房买卖合同&gt;&gt;有关文件
				</td>		
              </tr>	 
			  
			   <tr bgcolor="#E9F5FF" style="empty-cells:show">
				
				<td id="t15" style="width:15%" align="right">临定方</td>
                <td id="t16" style="width:30%">	
					<input type="text"  />					
				 </td>
				<td id="t15" style="width:15%" align="right">出售方</td>
                <td id="t16" style="width:30%">
					<input type="text"  />
			  </tr>
			  
			   <tr bgcolor="#E9F5FF" style="empty-cells:show">
				
				<td id="t15" style="width:15%" align="right">代理方</td>
                <td id="t16" style="width:30%">	
					合富辉煌(中国)房地产顾问有限公司					
				 </td>
				<td id="t15" style="width:15%" align="right">临定方代理人</td>
                <td id="t16" style="width:30%">
					<input type="text"  />
			  </tr>
			  
			   <tr bgcolor="#E9F5FF" style="empty-cells:show">
				
				<td id="t15" style="width:15%" align="right">销售代表</td>
                <td id="t16" style="width:30%">	
					<input type="text"  />					
				 </td>
				<td id="t15" style="width:15%" align="right">复核人</td>
                <td id="t16" style="width:30%">
					<input type="text"  />
			  </tr>
			  
			   <tr bgcolor="#E9F5FF" style="empty-cells:show">
				
				<td id="t15" style="width:15%" align="right">现场咨询电话</td>
                <td id="t16" style="width:30%">	
					<input type="text"  />					
				 </td>
				<td id="t15" style="width:15%" align="right"></td>
                <td id="t16" style="width:30%"></tr>
				-->
			
			  
			</table>
</form>	
	
	</div>



</body>
</html>
