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
			
			
			<td align="center">&nbsp;<%--  置业顾问--%></td>
			<td>&nbsp;<%--${sale.realName}--%></td>			
			
			<td align="center"></td>
			<td>&nbsp;</td>
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
			<td align="center">
			</td>
			<td >&nbsp;
			</td>
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
			<td>
				${selectUnit.roomNum}房  ${selectUnit.hallNum}厅  ${selectUnit.toiletNum}卫
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
<%--
		<tr onMouseOver="this.style.backgroundColor='#f1f9fe';" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" style="line-height: 20px;"> 
			<td align="center">
				房间数
			</td>
			<td >
				${selectUnit.roomNum}
			</td>
			<td align="center">
				厅数
			</td>
			<td  >
				${selectUnit.hallNum}
			</td>
			<td align="center">
				洗手间数
			</td>
			<td >
				${selectUnit.toiletNum}
			</td>
			<td align="center">
				样板房
			</td>
			<td>
				<s:if test="#request.selectUnit.isSample == 1">是</s:if>
				<s:elseif test="#request.selectUnit.isSample == 2">否</s:elseif>
			</td>
		</tr>
		<tr onMouseOver="this.style.backgroundColor='#f1f9fe';" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" style="line-height: 20px;"> 
			<td align="center">
					户型点评
			</td>
			<td colspan="7">
				${selectUnit.houseDesc}
			</td>
		</tr>
		--%>
 		<tr onMouseOver="this.style.backgroundColor='#f1f9fe';" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" style="line-height: 20px;"> 
			<td align="center" valign="top">
				备注
			</td>
			<td colspan="7">
				<textarea rows="4" cols="20" style="width: 90%; font-size: 12px" disabled="disabled">${selectUnit.remark}</textarea>
			</td>
		</tr>
		
</table>

</div>

