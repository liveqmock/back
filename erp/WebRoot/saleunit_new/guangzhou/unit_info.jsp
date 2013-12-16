<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<style type="text/css">
.unit_table td{
	padding-left: 5px;
	padding-right: 5px;	
	line-height: 20px;
}
</style>
<div style="float: left">

<table style="max-width: 700px;" border="0" align="center" cellpadding="0" cellspacing="1" class="gbox unit_table" >
		<tr style="line-height: 10px;background: #eee" onMouseOver="this.style.backgroundColor='#f1f9fe';" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" >
			<td colspan="8" style="background: #E9F5FF">
			

<div  class='sale_state_${selectUnit.saleState}' style="float: left"></div>
<div style="float: left;width: auto; height:inherit">${selectUnit.unitNo}&nbsp;</div>

<%-- 认购,签约有就查看,没有就新建 --%>
&nbsp;&nbsp;&nbsp;
${selectUnit.confirmContractCreateOrShowHref}

			</td>
		</tr>
		<tr onMouseOver="this.style.backgroundColor='#f1f9fe';" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" style="line-height: 20px;"> 
			<td width="80px"  align="center">
				房间
			</td>
			<td width="100px"  >
				${selectUnit. unitNo}
			</td>
			<td width="80px" align="center">
				楼层
			</td>
			<td width="100x" >
				${selectUnit. floorNum}
			</td>
			<td width="80px" align="center">
				房号
			</td>
			<td width="100px"  >
				${selectUnit.roomNo}
			</td>
			<td width="80px" align="center">				
			</td>
			<td width="100px"  >				
			</td>
		</tr>
		<tr onMouseOver="this.style.backgroundColor='#f1f9fe';" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" style="line-height: 20px;"> 
			<td align="center">
				建筑面积
			</td>
			<td >
				${selectUnit.buildArea}
			</td>
			<td align="center">
				建筑单价
			</td>
			<td  >
				${selectUnit.buildPrice}
			</td>
			<td width="80px" align="center">
				套内面积
			</td>
			<td width="100px"  >
				${selectUnit.insideArea}
			</td>
			<td width="80px" align="center">
				套内单价
			</td>
			<td width="100px"  >
				${selectUnit.insidePrice}
			</td>
		</tr>


	
		<tr onMouseOver="this.style.backgroundColor='#f1f9fe';" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" style="line-height: 20px;"> 
			<td align="center">
				标准总价
			</td>
			<td >
				${selectUnit.sumPrice}
			</td>
			<td align="center">
				计价方式
			</td>
			<td>
				<s:if test="#request.selectUnit.priceWay == 1">建筑面积</s:if>
				<s:elseif test="#request.selectUnit.priceWay == 2">套内面积</s:elseif>
			</td>
			
			
			<td align="center">销售人员</td>
			<td colspan="3">${saleName}</td>			
			
		</tr>

		<tr onMouseOver="this.style.backgroundColor='#f1f9fe';" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" style="line-height: 20px;"> 
			<td align="center">
				装修标准
			</td>
			<td>
				${selectUnit.renovateDesc}
			</td>
			<td align="center">
				装修款
			</td>
			<td >
				${selectUnit.renovateMoney}
			</td>
			
			<td align="center">
				装修单价
			</td>
			<td >
				${selectUnit.renovatePrice}
			</td>
			<td align="center">置业计划</td>
			<td>${calcUrl}</td>
		</tr>

	<tr onMouseOver="this.style.backgroundColor='#f1f9fe';" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" style="line-height: 20px;"> 
			<td align="center">
				朝向
			</td>
			<td>
				${selectUnit.descOrientation}
			</td>
			<td align="center">
				房间结构
			</td>
			<td align="left">
				${selectUnit.roomNum}房 ${selectUnit.hallNum}厅 ${selectUnit.toiletNum}卫
				
			</td>
			<td align="center">
				产品类型
			</td>
			<td colspan="3">
				${selectUnit.productTypeStr}
			</td>
		</tr>
		<tr onMouseOver="this.style.backgroundColor='#f1f9fe';" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" style="line-height: 20px;"> 
			<td align="center">
				景观
			</td>
			<td colspan="7">
				${selectUnit.scenery}
			
			</td>
		</tr>
 		<tr onMouseOver="this.style.backgroundColor='#f1f9fe';" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" style="line-height: 20px;"> 
			<td align="center">
				备注
			</td>
			<td colspan="7">
				<textarea rows="5" cols="" style="width: 90%; font-size: 12px" disabled="disabled">${selectUnit.remark}</textarea>
			</td>
		</tr>
</table>

</div>

