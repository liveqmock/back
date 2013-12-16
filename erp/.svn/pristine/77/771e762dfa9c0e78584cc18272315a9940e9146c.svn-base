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
		<title>修改单元</title>
			
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
				
				$("#submit").click(function(){	//double 类型val 验证
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

					var $forminputint = $("input[class='int']");
					
					$forminputint.each(function(i){
						   var $str = $.trim($(this).val());
						   var $maxval = 1;
						   for(var f = 0;f < ($(this).attr("maxlength"));f++){
							   $maxval = $maxval*10;
						   }
						   if(isNaN($str) || $str >= $maxval){
							   $(this).focus();
							   alert("请填写自然数");
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
<div class="title02" ><a href="./property/unit/search_list_index.action?ts=<%= CacheUtils.getUrlTimeStamp()%>" target="_self">单元列表</a></div>
<div class="title01" ><a href="./property/unit/show_index.action?ts=<%= CacheUtils.getUrlTimeStamp()%>" target="_self">单元视图</a></div>
<div class="right99"></div>
<div class="blueline"></div>
<div class="c"></div>
<div class="c"></div>

<table width="100%" border="0" cellspacing="0" class="d_top">
	<tr>
	  <td bgcolor="#edf8fe">
			<div class="d_out"><a href="./property/unit/search_list_index.action?ts=<%=CacheUtils.getUrlTimeStamp()%>" target="_self">查询单元</a></div>		
			
			<div class="d_out"><a href="./property/unit/index.action?ts=<%=CacheUtils.getUrlTimeStamp()%>" target="_self">初始化单元</a></div>	
			
			<div class="d_over"><b>单元信息</b></div>				
	 </td>
	</tr>
</table>

<%--主体table --%>
	<div class="body_div">
		<form action="./property/unit/update_one_unit_form.action" method="post" id="submit_form">
		<div style="width: 998px;float: left;">
			<table cellpadding="0" cellspacing="1"  style="vertical-align: top;width: 800px" class="tb1 gbox">
					<tr>
					<td align="right">单元</td>
						<td colspan="3">
							${selectUnit.descBuildId}  :  ${selectUnit.unitNo}   (${selectUnit.aliasNo })
							<input name="selectUnit.id" type="hidden" value="${selectUnit.id}"/>
							<input name="selectUnit.descBuildId" type="hidden" value="${selectUnit.buildId}"/>
							<input name="selectUnit.unitNo" type="hidden" value="${selectUnit.unitNo}"/>
							<input name="selectUnit.aliasNo" type="hidden" value="${selectUnit.aliasNo}"/>
						</td>
					</tr>
					
				   <tr>
				   	<td width="20%" align="right">户型</td><td width="28%"> <s:select list="selHouseType" name="selectUnit.houseType"></s:select></td>
				   	<td width="20" align="right">房间结构</td><td width="28%"><s:select list="selRoomType" name="selectUnit.roomType"></s:select></td>
				   </tr>
  
   					<tr>
				   	<td align="right">销售状态</td><td><s:select list="selSaleState" name="selectUnit.saleState"></s:select></td>
				   	<td align="right">租售类型</td><td><%--<s:select list="selSaleType" name="selectUnit.saleType"></s:select>--%>
				   		<s:select list="selSaleType" name="selectUnit.saleType"></s:select>
				   	</td>
				   </tr>

   					<tr>
				   	<td align="right">建筑面积(㎡)</td><td><input id="build_area" maxlength="7" name="selectUnit.buildArea" type="text" class="num" value="${selectUnit. buildArea}"/> </td>
				   	<td align="right">套内面积(㎡)</td><td><input id="inside_area" maxlength="7" name="selectUnit.insideArea" type="text" class="num" value="${selectUnit. insideArea}"/></td>
				   </tr>	

   					<tr>
				   	<td align="right">建筑单价</td><td> <input id="build_price" maxlength="9" name="selectUnit.buildPrice" type="text" class="num"  value="${selectUnit. buildPrice}"/></td>
				   	<td align="right">套内单价</td><td> <input id="inside_price" maxlength="9" name="selectUnit.insidePrice" type="text" class="num"  value="${selectUnit. insidePrice}"/> </td>
				   </tr>	

   					<tr>
				   	<td align="right">标准总价</td><td> <input id="sum_price" maxlength="16" name="selectUnit.sumPrice" type="text" class="num"  value="${selectUnit. sumPrice}"/></td>
				   	<td align="right">计价方式</td><td><s:select list="selPriceWay" name="selectUnit.priceWay"></s:select></td>
				   </tr>

   					<tr>
				   	<td align="right">面积状态</td><td><s:select list="selAreaState" name="selectUnit.areaState"></s:select></td>
				   	<td align="right">景观</td><td> <input maxlength="20" name="selectUnit.scenery" type="text"   value="${selectUnit. scenery}"/></td>
				   </tr>

   					<tr>
				   	<td align="right">朝向</td><td><s:select list="selOrientation" name="selectUnit.orientation"></s:select></td>
				   	<td align="right">预售建筑面积(㎡)</td><td> <input id="pre_build_area" maxlength="7" name="selectUnit.preBuildArea" type="text" class="num"  value="${selectUnit. preBuildArea}"/></td>
				   </tr>

      			   <tr>
				   	<td align="right">预售套内面积(㎡)</td><td> <input id="pre_inside_area" maxlength="7" name="selectUnit.preInsideArea" type="text" class="num"  value="${selectUnit. preInsideArea}"/></td>
				   	<td align="right">实测建筑面积(㎡)</td><td> <input id="real_build_area" maxlength="7" name="selectUnit.realBuildArea" type="text" class="num"  value="${selectUnit. realBuildArea}"/></td>
				   </tr>

      				<tr>
				   	<td align="right">实测套内面积(㎡)</td><td> <input id="real_inside_area" maxlength="7" name="selectUnit.realInsideArea" type="text" class="num"  value="${selectUnit. realInsideArea}"/></td>
				   	<td align="right">产品类型</td><td><s:select list="selProductType" name="selectUnit.productType"></s:select></td>
				   </tr>

      				<tr>
				   	<td align="right">装修款</td><td> <input id="renovate_money" maxlength="16" name="selectUnit.renovateMoney" type="text" class="num"  value="${selectUnit. renovateMoney}"/></td>
				   	<td align="right">是否样板房</td><td>
				   		<s:select list="selIsSample" name="selectUnit.isSample"></s:select>
				   	</td>
				   </tr>

      				<tr>
				   	<td align="right">是否附属房产</td><td>
				   		<s:select list="selIsSlave" name="selectUnit.isSlave"></s:select>
				   	</td>
                    <td align="right"> 抵押状态</td><td><s:select list="selMortgageState" name="selectUnit.mortgageState"></s:select></td>
				   </tr>

      				<tr>
				   	<td align="right">户型点评</td><td> <input maxlength="50" name="selectUnit.houseDesc" type="text" class=""  value="${selectUnit. houseDesc}"/></td>
				   	<td align="right">装修标准</td><td> <input maxlength="100" name="selectUnit.renovateDesc" type="text" class=""  value="${selectUnit. renovateDesc}"/></td>
				   </tr>

      				<tr>
				   	<td align="right">装修单价</td><td><input id="renovate_price" maxlength="9" name="selectUnit.renovatePrice" type="text" class="num"  value="${selectUnit. renovatePrice}"/></td>
				   	<td align="right">房间数量</td><td><input maxlength="2" name="selectUnit.roomNum" type="text" class="int"  value="${selectUnit. roomNum}"/></td>
				   </tr>
				   
				   <tr>
				   	<td align="right">厅数量</td><td><input  maxlength="2" name="selectUnit.hallNum" type="text" class="int"  value="${selectUnit. hallNum}"/></td>
				   	<td align="right">厕所数量</td><td><input  maxlength="2" name="selectUnit.toiletNum" type="text" class="int"  value="${selectUnit. toiletNum}"/></td>
				   </tr>
				   
				   <tr>
				   	<td align="right">备注</td><td colspan="3"><input maxlength="100" name="selectUnit.remark" type="text" class=""  value="${selectUnit. remark}"/></td>
				   </tr>
				   
				   <tr>
				   	<td colspan="4" align="center">
				   			<input type="submit" value="  修改  " style="width: 50px" id="submit"/>
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
