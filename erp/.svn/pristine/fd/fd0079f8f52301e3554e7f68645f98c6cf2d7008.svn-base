<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
	<script type="text/javascript" language="javascript" src="<%=basePath%>js/jquery-1.6.2.min.js"></script>
	<script type="text/javascript" language="javascript" src="./js/jquery-ui-1.8.19.custom.min.js"></script>
	<script type="text/javascript">
	$().ready(function(){
		$("#updateSaleState").click(function(){
			var hh = $("#salestate").val();
			$("#appdiv").html("");
			$("#appdiv").remove();
			$("#closediv").remove();
			$.ajax({
				type:"post",
				url: "./property/unit/update_unit_salestate.action",
				data: "selectUid=${selectUnit.id}&saleState="+hh,
				dataType: "html",
				success: function(data)
					{
						alert(data);
					//	location = location;
					}
				});
		});
		
	});
	</script>
		
  <style>
	tr{background:#ffffff;border: 1px}
</style>
 

<table bgcolor="#1199FF" width="100%">
	<tr >
		<td width="20%">房间号1</td>
		<td width="28%">
			&nbsp;${selectUnit.unitNo}
		</td>
		<td width="20%">栋苑id</td>
		<td width="28%">
			&nbsp;${selectUnit.buildId}
		</td>
	</tr>
<tr>
		<td>楼层号</td>
		<td>
			&nbsp;${selectUnit. floorNum }
		</td>
		<td>单元号</td>
		<td>
			&nbsp;${selectUnit. roomNo}
		</td>
	</tr>
  <tr>
		<td>房间别号</td>
		<td>
			&nbsp;${selectUnit. aliasNo}
		</td>
		<td>户型</td>
		<td>
			&nbsp;${selectUnit. houseType}
		</td>
	</tr>
   <tr>
		<td>房间结构</td>
		<td>
			&nbsp;${selectUnit. roomType}
		</td>
		<td>销售状态</td>
		<td>
		<s:select list="selSaleState" name="selectUnit.saleState" id="salestate"></s:select>
		</td>
	</tr>

    <tr>
		<td>租售类型</td>
		<td>
			&nbsp;${selectUnit. saleType}
		</td>
		<td>朝向</td>
		<td>
			&nbsp;${selectUnit. orientation}
		</td>
	</tr>

       <tr>
		<td>建筑面积</td>
		<td>
			&nbsp;${selectUnit. buildArea}
		</td>
		<td>套内面积</td>
		<td>
			&nbsp;${selectUnit. insideArea}
		</td>
	</tr>
    <tr>
		<td>建筑单价</td>
		<td>
			&nbsp;${selectUnit. buildPrice}
		</td>
		<td>套内单价</td>
		<td>
			&nbsp;${selectUnit. insidePrice}
		</td>
	</tr>

    <tr>
		<td>标准总价</td>
		<td>
			&nbsp;${selectUnit. sumPrice}
		</td>
		<td>计价方式</td>
		<td>
			&nbsp;${selectUnit. priceWay}
		</td>
	</tr>

    <tr>
		<td>面积状态</td>
		<td>
			&nbsp;${selectUnit. areaState}
		</td>
		<td>景观</td>
		<td>
			&nbsp;${selectUnit. scenery}
		</td>
	</tr>

    <tr>
		<td>预售建筑面积</td>
		<td>
			&nbsp;${selectUnit. preBuildArea}
		</td>
		<td>预售套内面积</td>
		<td>
			&nbsp;${selectUnit. preInsideArea}
		</td>
	</tr>


    <tr>
		<td>实测建筑面积</td>
		<td>
			&nbsp;${selectUnit. realBuildArea}
		</td>
		<td>实测套内面积</td>
		<td>
			&nbsp;${selectUnit. realInsideArea}
		</td>
	</tr>

    <tr>
		<td>产品类型</td>
		<td>
			&nbsp;${selectUnit. productType}
		</td>
		<td>装修款</td>
		<td>
			&nbsp;${selectUnit. renovateMoney}
		</td>
	</tr>

    <tr>
		<td>是否样板房</td>
		<td>
			&nbsp;${selectUnit. isSample}
		</td>
		<td>是否附属房产</td>
		<td>
			&nbsp;${selectUnit. isSlave}
		</td>
	</tr>

    <tr>
		<td>抵押状态</td>
		<td>
			&nbsp;${selectUnit. mortgageState}
		</td>
		<td>户型点评</td>
		<td>
			&nbsp;${selectUnit. houseDesc}
		</td>
	</tr>

    <tr>
		<td>装修标准</td>
		<td>
			&nbsp;${selectUnit. renovateDesc}
		</td>
		<td>装修单价</td>
		<td>
			&nbsp;${selectUnit. renovatePrice}
		</td>
	</tr>
    <tr>
		<td>备注</td>
		<td colspan="3">
			&nbsp;${selectUnit. remark}
		</td>
	</tr>
</table>

		<div style="float: right;margin-top: 20px;margin-right: 5px">
			<input value="  改变销售状态  " type="button" id="updateSaleState"/>
	</div>

