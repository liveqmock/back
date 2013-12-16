<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<script type="text/javascript">
/*
$().ready(function(){
	refrash_question_customer_div();
})

function refrash_question_customer_div(){
	$("#div_question_by_customer_info").load("./saleunit_new_questions/appoint/guangzhou/doQuestionTable.action?id="+click_unit_id);
}*/
	
</script>
<table border="0" align="center" cellpadding="0" cellspacing="1" class="gbox unit_table" width="100%" >
	<tr  style="line-height: 20px;background:#E9F5FF; text-align:left" >
		<td colspan="10" style="margin-left:15px">
			<s:if test="#request.unit.saleState==8||#request.unit.saleState==5">
			<a href="javascript:void(0)" style="color:#1199FF; text-decoration:underline;padding: 0px 20px 0px" onclick="addCancelContract(${unitId})">新建挞定</a>
			</s:if>
			<s:if test="#request.unit.saleState==8">
			<a href="javascript:void(0)" style="color:#1199FF; text-decoration:underline;padding: 0px 20px 0px" onclick="addChangeCustomerName(${unitId})">新建改名</a>
			</s:if>
			<s:if test="#request.unit.saleState==8">
			<a href="javascript:void(0)" style="color:#1199FF; text-decoration:underline;padding: 0px 20px 0px" onclick="addChangeUnit(${unitId})">新建换房</a>
			</s:if>
			<s:if test="#request.unit.saleState==8||#request.unit.saleState==9">
			<a href="javascript:void(0)" style="color:#1199FF; text-decoration:underline;padding: 0px 20px 0px" onclick="addRejectUnit(${unitId})">新建退房</a>
			</s:if>
			
			<s:elseif test="#request.unit.saleState!=5&&#request.unit.saleState!=8&&#request.unit.saleState!=9">
				<p style="color:red">未选择单元或单元未出售或竞争对手所售的单元
				</p>
			</s:elseif>
		</td>
	</tr>
	
	<tr onMouseOut="this.style.backgroundColor=''" bgcolor="#E9F5FF" style="line-height: 20px;"> 
		<th width="100" align="center">单元编号</th>
		<th width="100" align="center">操作日期</th>
		<th width="100" align="center">创建时间</th>
		<th width="100" align="center">创建人</th>
		<th width="100" align="center">类别</th>
		<th width="100" align="center">操作</th>
		<th width="100" align="center">备注</th>	
		
		<!--  <tr  style="line-height: 20px;background:#ffffff" > 
				<td width="100" align="center">总计 </td>
				<td width="100" align="center"></td>
				<td width="100" align="center">${amount}</td>
				<td width="100" align="center" class="rmb_format"><my:format value="${allShouldPay}"/></td>
				<td width="100" align="center" class="rmb_format"><my:format value="${allHadPay}"/></td>
				<%--<td width="100" align="center"></td>--%>

			</tr>
		-->
		
		<s:iterator value="unitOperRecordList" var="c">
			<tr onMouseOver="this.style.backgroundColor='#f1f9fe';" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" style="line-height: 20px;"> 
				<input type="hidden" id="operUnitId" name="recordId" />
				<input type="hidden" id="operUnitMainId" name="mainId" />
				<td width="100" align="center">${c.unitId}</td>
				<td width="100" align="center"><s:date name="#c.operTime" format="yyyy-MM-dd"/></td>
				<td width="100" align="center"><s:date name="#c.createdTime" format="yyyy-MM-dd HH:mm:ss"/></td>
				<td width="100" align="center">${c.createdIdStr}</td>
				<td width="100" align="center">${c.operTypeStr}</td>
				<td width="150" align="center">
				${c.contUrl}
				</td>
				
				<td width="100" align="center">${c.remark}</td>
			</tr>
		</s:iterator>
	
	
	

	<%-- 
	<tr>
		<td style="background-color: #eeeeee; font-weight: bold;">客户问卷调查</td>
	</tr>
	
	<tr style="margin: 0;padding: 0">
		<td >
			<div id="div_question_by_customer_info" style="padding: 0;margin: 0;height: 100%;width: 100%;background-color: #ffffff"></div>
		</td>
	</tr>
	--%>
</table>

