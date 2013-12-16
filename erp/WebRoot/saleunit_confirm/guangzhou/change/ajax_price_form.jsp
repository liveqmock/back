<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page contentType="text/html; charset=utf-8" %>

<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<base href="<%=basePath%>">
<script type="text/javascript" language="javascript" src="<%=path %>/js/jquery-1.6.2.min.js"></script>
<link href="./css/blue_guangzhou.css"  rel="stylesheet" type="text/css" charset="utf-8"/>
	<style>
		tr{background: #ffffff;line-height: 25px;}
		td{padding-left: 5px}
		em{color: red;margin-right: 5px}
	</style>

	<script type="text/javascript">
			$().ready(function(){
				
				$("#submit_for_change_price").click(function(){
				
						var	$str = $.trim($("#change_price_price_way2").val());
						if($str == ""){
							alert("请选择计价方式");
							return false;
							}
						$str= $.trim($("#change_price_pay_type2").val());
						if($str == ""){
								alert("请选择付款方式");
							//	$("#inputAreaName").val("");
							//	$("#inputAreaName").focus();
								return false;
							}
						$str= $.trim($("#change_price_build_price2").val());
						if($str == ""||isNaN($str) || $str < 0 || $str > 99999){
								alert("请填写建筑成交单价");
								$("#change_price_build_price2").val("");
								$("#change_price_build_price2").focus();
								return false;
							}	
						$str= $.trim($("#change_price_inside_unit_price2").val());
						if($str == ""||isNaN($str) || $str < 0 || $str > 99999){
								alert("请填写套内成交单价");
								$("#change_price_inside_unit_price2").val("");
								$("#change_price_inside_unit_price2").focus();
								return false;
							}
						$str= $.trim($("#change_price_sum_money2").val());
						if($str == ""||isNaN($str) || $str < 0 || $str > 99999999999){
								alert("请填写房间总价");
								$("#change_price_sum_money2").val("");
								$("#change_price_sum_money2").focus();
								return false;
							}	
						
						$str= $.trim($("#change_price_reson_type").val());
						if($str == ""){
								alert("请选择变更原因");
						//		$("#change_price_reson_type").val("");
								$("#change_price_reson_type").focus();
								return false;
							}		
						
					});
			});
		</script>
<table bgcolor="#ffffff" style="font-size: 12"  class="gbox" width="100%" align="center" cellspacing="1" cellpadding="0" border="0">
 
  <tr>
    <td style="font-weight: bold" width="18%">销售单</td>
    <td width="30%">${confirm.agreeNo }</td>
    <td style="font-weight: bold" width="18%">申请单状态</td>
    <td width="30%"></td>
  </tr>
   <tr>
    <td >房间</td>
    <td colspan="3">${confirm.unit.unitNo }</td>

  </tr>
   <tr>
    
    <td>客户名称</td>
    <td>${confirm.customerName }</td>
    <td></td>
    <td></td>
  </tr>
   <tr>
    <td>建筑面积</td>
    <td>${confirm.unit.buildArea } </td>
    <td>套内面积</td>
    <td>${confirm.unit.insideArea }</td>
  </tr>
    <tr>
    <td>建筑单价</td>
    <td>${confirm.unit.buildPrice }</td>
    <td>套内单价</td>
    <td>${confirm.unit.insidePrice } </td>
  </tr>
   <tr>
    <td>计价方式</td>
    <td colspan="3">${confirm.priceWay }</td>
  </tr>
  <tr>
    <td>附属房间价格</td>
    <td></td>
    <td>标准总价</td>
    <td>${confirm.sumMoney } </td>
  </tr>
</table>
<div style="font-size: 12;font-weight: bold;background:#f1f9fe " ><br/>变更前的信息</div>
<table bgcolor="#ffffff" style="font-size: 12"  class="gbox" width="100%" align="center" cellspacing="1" cellpadding="0" border="0">
 
  <tr>
    <td width="18%">付款方式</td>
    <td width="30%">${confirm.payType }</td>
    <td width="18%">折扣</td>
    <td width="30%">${confirm.discountPercent }% </td>
  </tr>
   <tr>
    <td>建筑成交单价</td>
    <td>${confirm.buildPrice } </td>
    <td>套内成交单价</td>
    <td>${confirm.insideUnitPrice } </td>
  </tr>
   <tr>
    <td>协议总价</td>
    <td>${confirm.agreeMoney }  </td>
    <td></td>
    <td></td>
  </tr>
</table>

<div style="font-size: 12;font-weight: bold;background:#f1f9fe " ><br/>变更后的信息</div>
  <form action="./saleunit/confirm/guangzhou/addForChangePrice.action" method="post">
<table bgcolor="#ffffff" style="font-size: 12"  class="gbox" width="100%" align="center" cellspacing="1" cellpadding="0" border="0">
   <tr>
		<td width="18%"><em>*</em>计价方式</td>
		<td width="30%">
			<s:select list="selPriceWay" id="change_price_price_way2" name="changePriceForm.priceWay2"></s:select>
		</td>
		<td width="18%"><em>*</em>付款方式</td>
		<td width="30%">
			<s:select list="selPayType" id="change_price_pay_type2" name="changePriceForm.payType2"></s:select>
		</td>
		
	</tr>
	
		
 <tr>
 		<td>折扣百分比</td>
		<td colspan="3">
			<input type="text" id="change_price_discount_percent2" name="changePriceForm.discountPercent2"/>
		</td>
		
		
	</tr>
	<tr>
 		<td>折扣说明</td>
		<td colspan="3">
			<input type="text" id="change_price_discount_desc2" name="changePriceForm.discountDesc2"/>
		</td>
		
		
	</tr>
	<tr>
		<td><em>*</em>建筑成交单价</td>
		<td >
			<input type="text" id="change_price_build_price2" name="changePriceForm.buildPrice2"/>
		</td>
		<td><em>*</em>套内成交单价</td>
		<td >
			<input type="text" id="change_price_inside_unit_price2" name="changePriceForm.insideUnitPrice2"/>
		</td>
	</tr>

  <tr>
		
		<td><em>*</em>房间总价</td>
		<td colspan="3">
			<input type="text" id="change_price_sum_money2" name="changePriceForm.sumMoney2"/>
		</td>
	</tr>
	
	<tr>
		<td>装修标准</td>
		<td colspan="3">
			<input type="text" id="change_price_renovate_desc2" name="changePriceForm.renovateDesc2"/>
		</td>
	</tr>
	
<tr>
		<td>装修单价</td>
		<td >
			<input type="text" id="change_price_renovate_price2" name="changePriceForm.renovatePrice2"/>
		</td>
		<td>是否并入合同</td>
		<td >
			
			<select id="change_price_is_merge2" name="changePriceForm.isMerge2">
				<option value="">请选择</option>
				<option value="1">是</option>
				<option value="0">否</option>
			</select>
		</td>
	</tr>

<tr>
		<td>装修总价</td>
		<td >
			<input type="text" id="change_price_renovate_money2" name="changePriceForm.renovateMoney2"/>
		</td>
		<td>协议编号</td>
		<td >
			<input type="text" id="change_price_agree_no2" name="changePriceForm.agreeNo2"/>
		</td>
	</tr>

<tr>
		<td>应收定金</td>
		<td >
			<input type="text" id="change_price_should_deposit2" name="changePriceForm.shouldDeposit2"/>
		</td>
		<td>协议总价</td>
		<td >
			<input type="text" id="change_price_agree_money2" name="changePriceForm.agreeMoney2"/>
		</td>
	</tr>
</table>
<div style="font-size: 12;font-weight: bold;background:#f1f9fe " ><br/>变更信息</div>
<table bgcolor="#ffffff" style="font-size: 12"  class="gbox" width="100%" align="center" cellspacing="1" cellpadding="0" border="0">
	<tr>
		<td width="18%">手续费</td>
		<td width="30%">
			<input type="text" id="change_price_hand_fee" name="changePriceForm.handFee"/>
		</td>
		<td width="18%"><em>*</em>变更原因</td>
		<td width="30%">
			<select id="change_price_reson_type" name="changePriceForm.resonType">
				<option value="">请选择</option>
				<option value="1">原因1</option>
				<option value="2">原因2</option>
			</select>
		</td>
	</tr>
	
	<tr>
		<td style="padding-left: 5px">原因说明</td>
		<td colspan="3">
			<input type="text" id="change_price_reson_desc" name="changePriceForm.resonDesc" style="width: 100%"/>
		</td>
		
	</tr>
	<tr>
		
		<td colspan="4" align="center">
			<input type="hidden" value="${confirm.id }" name="confirm.id"/>
		<input value="  提交申请  " type="submit"  id = "submit_for_change_price"/></td>
	</tr>
</table>
</form>
	


