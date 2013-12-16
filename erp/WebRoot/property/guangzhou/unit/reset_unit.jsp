<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page import="com.ihk.utils.CacheUtils"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<s:include value="../../../customer/guangzhou/header.jsp"></s:include>	
		<s:include value="../../../customer/guangzhou/header_left_js.jsp"></s:include>	
		<title>批量修改单元</title>
		<style >
			.tb1 input{width:100%}
			.tb1 select{width:100%}
			.tb1 td{padding: 0px 10px; }
			.tb1 tr{background:#FFFFFF}
			.redbor {border: 2px solid red}
			.body_div{width: 100%;height: inherit;float: left;vertical-align: top;}
			.poppng{background:url(<%=basePath%>/images/pop.png) no-repeat}
			.err_input_class{border-color: red;border-width: 2px}
		</style>
		
		<script type="text/javascript" language="javascript" src="<%=basePath%>js/guangzhou_input_valdate.js"></script>
		<script type="text/javascript">
			$().ready(function(){
				
				$("#form_submit").click(function(){	//double 类型val 验证
					var $forminputnum = $("input[class='num']");
					var re = true;
					$forminputnum.each(function(i){
						   var $str = $.trim($(this).val());
						   var $maxval = 1;
						   for(var f = 0;f < ($(this).attr("maxlength")-3);f++){
							   $maxval = $maxval*10;
						   }
						   if(isNaN($str) || $str >= $maxval){
							   $(this).focus();
							   alert("请填写有效的数");
							   re = false;
							  return false;
						   }
					 });

					 
					return re;
				});//double 类型val 验证 end
				/*
				$("#build_area").inputVal({maxlength:7,type:'num'});//
				$("#inside_area").inputVal({maxlength:7,type:'num'});//
				$("#build_price").inputVal({maxlength:9,type:'num'});//
				$("#inside_price").inputVal({maxlength:9,type:'num'});//
				$("#sum_price").inputVal({maxlength:16,type:'num'});//
				$("#pre_build_area").inputVal({maxlength:7,type:'num'});//
				$("#real_build_area").inputVal({maxlength:7,type:'num'});//
				$("#pre_inside_area").inputVal({maxlength:7,type:'num'});//
				$("#real_inside_area").inputVal({maxlength:7,type:'num'});//
				$("#renovate_money").inputVal({maxlength:16,type:'num'});//
				$("#renovate_price").inputVal({maxlength:9,type:'num'});//
				*/
			})
		</script>
	</head>
	<body>
	
<%--固定的上部 --%>

<s:include value="../../../customer/guangzhou/body_up.jsp">
</s:include>	

<%--主体导航页头 --%>
<div class="title01" ><a href="./property/unit/search_list_index.action?ts=<%= CacheUtils.getUrlTimeStamp()%>" target="_self">单元列表</a></div>
<div class="title02" ><a href="./property/unit/show_index.action?ts=<%= CacheUtils.getUrlTimeStamp()%>" target="_self">单元视图</a></div>
<table width="100%" border="0" cellspacing="0" class="d_top">
	<tr>
	  <td bgcolor="#edf8fe">
	  
	<div class="d_out">
		<a href="./property/unit/show_index.action?ts=<%= CacheUtils.getUrlTimeStamp()%>" target="_self">查看单元</a>
	</div>		
	<div class="d_out">
		<a href="./property/unit/reset_index.action?ts=<%=CacheUtils.getUrlTimeStamp()%>" target="_self">调整单元</a>
	</div>	
		<div class="d_over">
		<b><a href="./property/unit/reset_index.action?ts=<%=CacheUtils.getUrlTimeStamp()%>" target="_self">单元信息</a></b>
	</div>		
	 </td>
	</tr>
</table>
<%--主体table --%>
	<div style="width: 1000px;height: inherit;float: left;vertical-align: top;">
		<form action="./property/unit/reset.action" method="post">
		<div style="width: 998px;float: left;">
			<table cellpadding="0" cellspacing="1"  style="vertical-align: top;width: 800px" class="tb1 gbox">
					<tr>
					<td align="right">单元</td>
						<td colspan="3">
						
							<s:iterator value="#session.unitNameList" id="li">
								&nbsp;${unitNo}
								
							</s:iterator>
						
						</td>
					</tr>
				   <tr>
				   	<td width="20%" align="right">户型</td><td width="28%"> <s:select list="selHouseType" name="resetUnit.houseType"></s:select></td>
				   	<td width="20" align="right">房间结构</td><td width="28%"><s:select list="selRoomType" name="resetUnit.roomType"></s:select></td>
				   </tr>
  

   					<tr>
				   	<td align="right">销售状态</td><td><s:select list="selSaleState" name="resetUnit.saleState"></s:select></td>
				   	<td align="right">租售类型</td><td><%--<s:select list="selSaleType" name="resetUnit.saleType"></s:select>--%>
				   
				   		<s:select list="selSaleType" name="resetUnit.saleType"></s:select>
				   	</td>
				   	
				   </tr>

   					<tr>
				   	<td align="right">建筑面积(㎡)</td><td><input id="build_area" maxlength="7" name="resetUnit.buildArea" type="text" class="num"  value="${resetUnit.buildArea}"/> </td>
				   	<td align="right">套内面积(㎡)</td><td><input id="inside_area" maxlength="7" name="resetUnit.insideArea" type="text" class="num"  value="${resetUnit.insideArea}" /></td>
				   </tr>	

   					<tr>
				   	<td align="right">建筑单价</td><td><input id="build_price" maxlength="9" name="resetUnit.buildPrice" type="text" class="num"  value="${resetUnit.buildPrice}" /></td>
				   	<td align="right">套内单价</td><td><input id="inside_price" maxlength="9" name="resetUnit.insidePrice" type="text" class="num"  value="${resetUnit.insidePrice}" /> </td>
				   </tr>	

   					<tr>
				   	<td align="right">标准总价</td><td><input id="sum_price" maxlength="16" name="resetUnit.sumPrice" type="text" class="num"  value="${resetUnit.sumPrice}" /></td>
				   	<td align="right">计价方式</td><td><s:select list="selPriceWay" name="resetUnit.priceWay"></s:select></td>
				   </tr>

   					<tr>
				   	<td align="right">面积状态</td><td><s:select list="selAreaState" name="resetUnit.areaState"></s:select></td>
				   	<td align="right">景观</td><td><input maxlength="20" name="resetUnit.scenery" type="text"  /></td>
				   </tr>
				
   					<tr>
				   	<td align="right">朝向</td><td><s:select list="selOrientation" name="resetUnit.orientation"></s:select></td>
				   	<td align="right">预售建筑面积(㎡)</td><td><input maxlength="7" id="pre_build_area" name="resetUnit.preBuildArea" type="text" class="num"  value="${resetUnit.preBuildArea}" /></td>
				   </tr>

      					<tr>
				   	<td align="right">预售套内面积(㎡)</td><td> <input id="pre_inside_area" maxlength="7" name="resetUnit.preInsideArea" type="text" class="num"  value="${resetUnit.preInsideArea}" /></td>
				   	<td align="right">实测建筑面积(㎡)</td><td> <input id="real_build_area" maxlength="7" name="resetUnit.realBuildArea" type="text" class="num"  value="${resetUnit.realBuildArea}" /></td>
				   </tr>

      					<tr>
				   	<td align="right">实测套内面积(㎡)</td><td><input id="real_inside_area" maxlength="7" name="resetUnit.realInsideArea" type="text" class="num"  value="${resetUnit.realInsideArea}" /></td>
				   	<td align="right">产品类型</td><td><s:select list="selProductType" name="resetUnit.productType"></s:select></td>
				   </tr>

      					<tr>
				   	<td align="right">装修款</td><td><input id="renovate_money" maxlength="16" name="resetUnit.renovateMoney" type="text" class="num"  value="${resetUnit.renovateMoney}" /></td>
				   	<td align="right">是否样板房</td><td>
				   		
				   		<s:select list="selIsSample" name="resetUnit.isSample"></s:select>
				   	</td>
				   </tr>

      					<tr>
				   	<td align="right">是否附属房产</td><td>
				   	
				   		<s:select list="selIsSlave" name="resetUnit.isSlave"></s:select>
				   	</td>
                    <td align="right">抵押状态</td><td><s:select list="selMortgageState" name="resetUnit.mortgageState"></s:select></td>
				   </tr>

      					<tr>
				   	<td align="right">户型点评</td><td><input maxlength="50" name="resetUnit.houseDesc" type="text" class=" " /></td>
				   	<td align="right">装修标准</td><td><input maxlength="100" name="resetUnit.renovateDesc" type="text" class=" " /></td>
				   </tr>

      					<tr>
				   	<td align="right">装修单价</td><td><input id="renovate_price" maxlength="9" name="resetUnit.renovatePrice" type="text" class="num"  value="${resetUnit.renovatePrice}" /></td>
				   	<td align="right">房间数量</td><td><input maxlength="100" name="resetUnit.roomNum" type="text" class="num" value="${resetUnit.roomNum}"/></td>
				   </tr>
				   	<tr>
				   	<td align="right">厅数量</td><td><input maxlength="9" name="resetUnit.hallNum" type="text" class="num"  value="${resetUnit.hallNum}" /></td>
				   	<td align="right">卫生间数量</td><td><input maxlength="100" name="resetUnit.toiletNum" type="text" class="num" value="${resetUnit.toiletNum}"/></td>
				   </tr>
				   
				   <tr>
				   	<td align="right">预售公摊面积</td><td><input  maxlength="9" name="resetUnit.appointPublicArea" type="text" class="num"  value="${resetUnit.appointPublicArea}" /></td>
				   	<td align="right">实测公摊面积</td><td><input maxlength="100" name="resetUnit.realPublicArea" type="text" class="num" value="${resetUnit.realPublicArea}"/></td>
				   </tr>
				   
				   	<tr>
				   	<td align="right">公摊面积</td><td><input  maxlength="9" name="resetUnit.publicArea" type="text" class="num"  value="${resetUnit.publicArea}" /></td>
				   	<td align="right"></td><td></td>
				   </tr>
				   
				   <tr>
				   	<td align="right">备注</td>
				   	<td colspan="3">
				   		<textarea rows="" cols="" name="resetUnit.remark" style="width: 90%">
				   			${resetUnit.remark}
				   		</textarea>
				   	</td>
				   	
				   </tr>
				   
				   <tr>
				   	<td colspan="4" align="center">
				   			<input type="hidden" value="${ids}" name="ids"/>
				   			<input type="submit" value="  修改  " style="width: 50px" id="form_submit"/>
				   			<s:actionmessage cssStyle="color:red"/>
				   	</td>
				   </tr>
				 
		</table>
		
		</div>
		</form>
	</div>
<%--固定的底部 --%>
<s:include value="../../../customer/guangzhou/body_bottom.jsp">
</s:include>
<%--POP --%>
<div id="org_box" class="poppng" style="height:20px; width:250px;
	  position:absolute; display: none;font-size: 12px;padding: 3px; overflow: hidden;"></div>
	</body>
</html>
