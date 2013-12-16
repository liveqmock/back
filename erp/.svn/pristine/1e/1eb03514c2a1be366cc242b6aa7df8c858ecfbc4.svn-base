<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%--这是一个显示房间详细信息的弹出框 --%>
	<div style="float: left;margin-left: 20px;border: solid 2px;border-color: gray;width: 470px;background-color: #eeeeee;padding: 10px">
			<form action="./property/unit/update_unit.action" id="unitform" method="post">
				<table style="border: solid;margin: 2px" width="99%">
					<tr>
						<td>房间</td><td > <p id = "showhouse">${selectUnit.unitNo}</p></td>
						<td></td><td></td>
					</tr>
					<tr>
						<td>建筑面积</td>
						<td>
						<input  name="selectUnit.buildArea" value="${selectUnit.buildArea}" type="text" style="width: 90"/>
						</td>
						<td>套内面积</td>
						<td>
						<input  name="selectUnit.insideArea" value="${selectUnit.insideArea}" type="text" style="width: 90"/>
						</td>
					</tr>
					<tr>
						<td>建筑单价</td>
						<td>
						<input  name="selectUnit.buildPrice"  value="${selectUnit.buildPrice}" type="text" /style="width: 90">
						</td>
						<td>套内单价</td>
						<td>
						<input  name="selectUnit.insidePrice" value="${selectUnit.insidePrice}" type="text" style="width: 90"/>
						</td>
					</tr>
					<tr>
						<td>标准总价</td>
						<td>
						<input  name="selectUnit.sumPrice" value="${selectUnit.sumPrice}" type="text" style="width: 90"/>
						</td>
						<td>计价方式</td>
						<td>
						<s:select list="selPriceWay" name="selectUnit.priceWay"></s:select>
						</td>
					</tr>
					<tr>
						<td>户型</td>
						<td>
				
						</td>
						<td>朝向</td>
						<td>
						<s:select list="selOrientation" name="selectUnit.Orientation"></s:select>
						</td>
					</tr>
				
					<tr>
						<td>状态</td><td>
							<s:select list="selSaleState" name="selectUnit.saleState"></s:select>
						 </td>
						<td></td><td>
						<input type="hidden" name="selectUid" value="${selectUnit.id}"/>
						<input type="hidden" name="buildId" value="${buildId}" id="buildId"/>
						<input type="submit" value="提交" id="close"/> </td>
					</tr>
				</table>
			</form>
		</div>