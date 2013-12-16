<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<style>
.rmb_format{text-align: right}
</style>
		<table  border="0" align="center" cellpadding="0" cellspacing="1" class="gbox unit_table" width="100%">
			<tr  style="line-height: 20px;background:#E9F5FF" > 
				<th width="100" align="center">类别</th>
				<th width="100" align="center">收费项目</th>
				<th width="100" align="center">期数</th>
				<th width="100" align="center">应收日期</th>
				<th width="100" align="center">应收本金</th>
				<th width="100" align="center">已收金额</th>
				<th width="100" align="center">未收金额</th>
				<th width="100" align="center">房款比例</th>
				<th width="100" align="center">备注</th>
				<th width="" align="center"></th>
			</tr>
			<tr  style="line-height: 20px;background:#ffffff" > 
				<td width="100" align="center">总计 </td>
				<td width="100" align="center"></td>
				<td width="100" align="center"></td>
				<td width="100" align="center"></td>
				<td width="100" align="center" class="rmb_format" >${unitPaySum.shouldPayFormat}</td>
				<td width="100" align="center" class="rmb_format">${unitPaySum.hadPayFormat}</td>
				<td width="100" align="center" class="rmb_format">${unitPaySum.notPayFormat}</td>
				<td width="100" align="center">
					
				</td>
				<td width="" align="center"> </td>
				<td width="" align="center"> </td>
			</tr>
			<s:iterator value="unitPayBillList1" var="c">
				<tr  style="line-height: 20px;background:#ffffff" > 
					<td width="100" align="center" >${c.payName} </td>
					<td width="100" align="center">${c.detailName}</td>
					<td width="100" align="center"></td>
					<td width="100" align="center"> 
						<s:date name="#request.c.dayNum" format="yyyy-MM-dd"/>
					  </td>
					<td width="100" align="center" class="rmb_format">${c.shouldPayFormat}</td>
					<td width="100" align="center" class="rmb_format">${c.hadPayFormat}</td>
					<td width="100" align="center" class="rmb_format">${c.notPayFormat}</td>
					<td width="100" align="center" class="rmb_format"> ${c.myPayPercent}</td>
					<td width="" align="center"> </td>
					<td width="" align="center"><a href="#" class="ablue" onclick="createPayUnitDialog(${c.id},${id});return false;">付款</a> </td>
				</tr>
			</s:iterator>
			<s:iterator value="unitPayBillList2" var="c">
				<tr  style="line-height: 20px;background:#ffffff" > 
					<td width="100" align="center" >${c.payName} </td>
					<td width="100" align="center">${c.detailName}</td>
					<td width="100" align="center"></td>
					<td width="100" align="center"> 
						<s:date name="#request.c.dayNum" format="yyyy-MM-dd"/>
					  </td>
					<td width="100" align="center" class="rmb_format">${c.shouldPayFormat}</td>
					<td width="100" align="center" class="rmb_format">${c.hadPayFormat}</td>
					<td width="100" align="center" class="rmb_format">${c.notPayFormat}</td>
					<td width="100" align="center" class="rmb_format"> ${c.myPayPercent}</td>
					<td width="" align="center"> </td>
					<td width="" align="center"><a href="#" class="ablue" onclick="createPayUnitDialog(${c.id},${id});return false;">付款</a>  </td>
				</tr>
			</s:iterator>
			<s:iterator value="unitPayBillList3" var="c">
				<tr  style="line-height: 20px;background:#ffffff" > 
					<td width="100" align="center" >${c.payName} </td>
					<td width="100" align="center">${c.detailName}</td>
					<td width="100" align="center"></td>
					<td width="100" align="center"> 
						<s:date name="#request.c.dayNume" format="yyyy-MM-dd"/>
					  </td>
					<td width="100" align="center" class="rmb_format">${c.shouldPayFormat}</td>
					<td width="100" align="center" class="rmb_format">${c.hadPayFormat}</td>
					<td width="100" align="center" class="rmb_format">${c.notPayFormat}</td>
					<td width="100" align="center" class="rmb_format"> ${c.myPayPercent}</td>
					<td width="" align="center"> </td>
					<td width="" align="center"><a href="#" class="ablue" onclick="createPayUnitDialog(${c.id},${id});return false;">付款</a>  </td>
				</tr>
			</s:iterator>
		</table>
   
				
