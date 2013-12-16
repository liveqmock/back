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
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
	<title>单元操作</title>
	<base href="<%=basePath%>"/>
	
	<script type="text/javascript" language="javascript" src="./js/money.utils.js"></script>
	<script type="text/javascript" language="javascript" src="./js/project.text.utils.js"></script>
	<script type="text/javascript" language="javascript" src="./js/saleunit_new_common_min.js"></script>
	<s:include value="../../header/header_easyui.jsp"></s:include>
	<style type="text/css">
		input,textarea{
			width:130px;
			border:1px solid #ccc;
			padding:2px;
		}
	</style>
	
	<script type="text/javascript" language="javascript">
		$(document).ready(function(){
			
			closeIframeDialog("new_dialog", "${closeMark}", "", "${tip}");
		
			initProjectTextCombobox('renovateDesc','装修标准');

			initProjectTextCombobox('productType','产品类型');
			
			$("#build_price").blur(function(){
				var build_area = $("#build_area").attr("value");
				var build_price = $("#build_price").attr("value");
				
				//$("#sum_price").numberbox("setValue", 1000000);
			});
			
			$("#build_area").blur(function(){
				
				var sum_price = $("#sum_price").attr("value");
				var build_area = $("#build_area").attr("value");
				
				if(inside_area == "0"){
					return;
				}
				var result_build_price = sum_price/build_area;
				$("#build_price").val(result_build_price.toFixed(2));
				
			});
			
			$("#inside_area").blur(function(){
				
				var sum_price = $("#sum_price").attr("value");
				var inside_area = $("#inside_area").attr("value");
				
				if(inside_area == "0"){
					return;
				}
				var result_inside_price = sum_price/inside_area;
				$("#inside_price").val(result_inside_price.toFixed(2));
				
			});

			$("#sum_price").blur(function(){
				
				var sum_price = $("#sum_price").attr("value");
				var inside_area = $("#inside_area").attr("value");
				var build_area = $("#build_area").attr("value");
				if(inside_area == "0" ||inside_area == "0.0000"){
					$("#inside_price").val('0');
				}else{
					var result_inside_price = sum_price/inside_area;
					$("#inside_price").val(result_inside_price.toFixed(2));
				}
				if(build_area == '0' || build_area == "0.0000"){
					$("#build_price").val('0');
				}else{
					var result_build_area = sum_price/build_area;
					$("#build_price").val(result_build_area.toFixed(2));
				}
			});
		});
	
		function tosubmit(){//提交表单
			if($("#init_one_unit_form").form('validate')){ 
				$("#init_one_unit_form").submit();
			}
		};	

	</script>
</head>
<body>
<div class="gbox1">			
<form action="${path }" method="post"  name = "thisform" id="init_one_unit_form">
	<table width="100%" border="0" align="center" cellpadding="0" cellspacing="1"  style="font-size:12px; line-height:20px;background-color: #A9D9FF">		
		 	   <tr bgcolor="#E9F5FF" style="empty-cells:show">
				<td colspan="4" ><b>${topText }</b></td>
			  </tr>
            	<tr bgcolor="#FFFFFF" style="empty-cells:show">
				<td> <span style="color:red">*</span>单元编号</td><td>
				<input name="initUnit.unitNo" value="${initUnit.unitNo }" 
					 class="easyui-validatebox" required="required" missingMessage="必填" maxlength="12"/></td>
				<td></td><td>  </td>
			  </tr>
			  <tr bgcolor="#FFFFFF" style="empty-cells:show">
				
				<td>
				<span style="color:red">*</span>楼层</td>
				<td>
					<input type="text" name="initUnit.floorNum" value="${initUnit.floorNum }" 
					 required="required" missingMessage="必填" max="500" min="-10"/>
				</td>
				
				<td><span style="color:red">*</span>房号</td><td>
					<input name="initUnit.roomNo" value="${initUnit.roomNo }"  
							 required="required" missingMessage="必填" max="500" min="1" /></td>
				 </tr>
				 <tr bgcolor="#FFFFFF" style="empty-cells:show">
				  
				<td>建筑面积</td><td>
					<input name="initUnit.buildArea" value="${initUnit.buildArea }"   precision="4" max="9999" min="0" groupSeparator=" " 
					 id="build_area"   style="background:  url('css/danwei_m2.png') no-repeat right; "/></td>
				 				
				<td>建筑单价</td><td>
					<input precision="2" max="999999" min="0" groupSeparator=" " 
						 name="initUnit.buildPrice" value="${initUnit.buildPrice }" id="build_price" /></td>
			  </tr>
			  
			   <tr bgcolor="#FFFFFF" style="empty-cells:show">
			   
			   <td>套内面积</td><td>
					<input name="initUnit.insideArea" precision="4" max="9999" min="0"  groupSeparator=" " 
						value="${initUnit.insideArea }"   style="background:  url('css/danwei_m2.png') no-repeat right; " id="inside_area"/></td>
				 
				<td>套内单价</td><td>
					<input precision="2" max="999999" min="0" groupSeparator=" " 
						 name="initUnit.insidePrice" value="${initUnit.insidePrice }" id="inside_price"/></td> 
			  </tr>
			  
			    <tr bgcolor="#FFFFFF" style="empty-cells:show">
				<td>计价方式</td>
				<td>
					
					<s:select list="selPriceWay" name="initUnit.priceWay"></s:select>
				</td>
				<td>总价</td><td><input precision="2" max="9999999999999" min="0"  groupSeparator=" " 
					 name="initUnit.sumPrice" value="${initUnit.sumPrice }" id="sum_price" /></td>
			  </tr>
			  <tr bgcolor="#FFFFFF" style="empty-cells:show">
				<td>朝向</td>
				<td>
					<s:select list="selOrientation" name="initUnit.orientation" cssStyle="width: 85%"></s:select>
				</td>
				<td colspan="2">
					<s:select list="selRoomNum" name="initUnit.roomNum"></s:select>房
					<s:select list="selhallNum" name="initUnit.hallNum"></s:select>厅
					<s:select list="seltoiletNum" name="initUnit.toiletNum"></s:select>卫
				</td>
			  </tr>
			  <tr bgcolor="#FFFFFF" style="empty-cells:show">
				<td>销售状态</td>
				<td>
					<s:select list="selSaleState" name="initUnit.saleState" cssStyle="width: 85%" ></s:select>
				</td>
				<td>推货日期</td>
				<td>
				
					<input   class="easyui-datebox" name="initUnit.saleTime" value="<s:date name="#request.initUnit.saleTime" format="yyyy-MM-dd"/>" />
				</td>
			  </tr>
			   <tr bgcolor="#FFFFFF" style="empty-cells:show">
				<td>产品类型</td>
				<td>
					<!-- <s:select list="selProductType" name="initUnit.productType" cssStyle="width: 85%"></s:select>-->
					<pt:sel cssStyle="width:auto" id="productType" name="initUnit.productType" typeName="PRODUCT_TYPE" value="${initUnit.productType}"/>
				</td>
				<td>装修标准</td>
				<td>
				<!-- 	<input 
						name="initUnit.renovateDesc" value="${initUnit.renovateDesc}"  maxlength="50"/> -->
						
						<pt:sel cssStyle="width:auto" id="renovateDesc" name="initUnit.renovateDesc" typeName="RENOVATE_DESC" value="${initUnit.renovateDesc}"/>
				</td>
			  </tr>
			 
			   <tr bgcolor="#FFFFFF" style="empty-cells:show">
				<td>装修单价</td>
				<td>
					<input precision="2" max="999999" min="0" groupSeparator=" "  
						name="initUnit.renovatePrice" value="${initUnit.renovatePrice}" id="renovate_price" />
				</td>
				<td>装修款</td>
				<td>
				   <input precision="2" max="9999999999999" min="0" groupSeparator=" "  
					 name="initUnit.renovateMoney" value="${initUnit.renovateMoney}" id="renovate_money" />
				</td>
			  </tr>
			   <tr bgcolor="#FFFFFF" style="empty-cells:show">
				<td>景观</td>
				<td colspan="3">
					<input name="initUnit.scenery" value="${initUnit.scenery}"  maxlength="40" style="width: 80%"/>
				</td>
				
			  </tr>
			   <tr bgcolor="#FFFFFF" style="empty-cells:show">
				<td>备注</td>
				<td colspan="3">
					<textarea  name="initUnit.remark" rows="" cols="" style="width: 90%; font-size: 12px;height: 40px" >${initUnit.remark}</textarea>
				</td>
				
			  </tr>
			   
			  
			   <tr bgcolor="#E9F5FF" style="empty-cells:show">
				<td colspan="4">
					<input type="hidden" value="${buildId}" name="buildId"/>
					<input type="hidden" value="${unitId}" name="unitId"/>
				<b id="tips" style="color: red">${tip }</b></td>
			  </tr>
			</table>
</form>	
	
	</div>


</body>
</html>