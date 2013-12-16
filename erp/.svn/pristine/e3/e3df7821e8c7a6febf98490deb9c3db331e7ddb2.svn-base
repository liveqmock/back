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

	<base href="<%=basePath%>">	
	
	<s:include value="../../header/header_easyui.jsp"></s:include>
	
	<title>修改付款方式明细</title>
	<style type="text/css">
		*{margin:0;padding:0;}
		body{font-size:75%}
		
	</style>
	
	<script type="text/javascript" language="javascript">
		$().ready(function(){
			
			//设置相关级联属性			
			if('${timeRadio}' == '2'){
				$("#time2").attr("checked",'checked'); 
				
				$("#dayNum").numberbox("disable");
				$("#dayNum").numberspinner('setValue', '');
			}else{
				$("#time1").attr("checked",'checked'); 
				
				$("#payDate").datebox('setValue', '');
				$("#payDate").datebox('disable');
			}
			
			if('${moneyRadio}' == '2'){
				$("#money2").attr("checked",'checked'); 
				
				$("#payMoney").numberbox("disable");
				$("#payMoney").numberbox('setValue', '');
			}else{
				$("#money1").attr("checked",'checked'); 
				
				$("#payPercent").numberbox('setValue', '');
				$("#payPercent").numberbox('disable');	
			}
			
			$("#time1").click(function(){
				
				$("#dayNum").numberbox("enable");
				
				$("#payDate").datebox('setValue', '');
				$("#payDate").datebox('disable');				
			});
			
			$("#time2").click(function(){
				
				$("#dayNum").numberbox("disable");
				$("#dayNum").numberspinner('setValue', '');
				
				$("#payDate").datebox('enable');				
			});
			
			$("#money1").click(function(){
				
				$("#payMoney").numberbox("enable");
				
				$("#payPercent").numberbox('setValue', '');
				$("#payPercent").numberbox('disable');	
			});
			
			$("#money2").click(function(){
				
				$("#payMoney").numberbox("disable");
				$("#payMoney").numberbox('setValue', '');

				$("#payPercent").numberbox('enable');	
			});
			
			$('#isInclude').combobox({editable:false,width:50});
			$('#modNum').combobox({editable:false});
												
		});
		
	</script>
	
	</head>
<body>

<form action="./saleunit_setup/payway/updatePayWayDetail.action" id="updateFormId" method="post">
	
	<table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" class="gbox" style="font-size:12px; line-height:26px">
	
	<tr style="background:#E9F5FF; text-align:left"> 
		<td id="t13" style="width:20%" align="right">
			费用名称
			<input type="hidden" name="payWayDetail.wayId" value="${payWayDetail.wayId }"/>
			<input type="hidden" name="payWayDetail.id" value="${payWayDetail.id }"/>
		</td>
		<td id="t14" colspan="3"></td>
					
	  </tr>	 		
	  
	  <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
		style="empty-cells:show">
		<td id="t13" style="width:15%" align="right"><font color="red">*</font>收费类别&nbsp;</td>
		<td id="t14" style="width:30%" colspan="3">
			${payWayDetail.typeName}
			<input type="hidden" name="payWayDetail.typeName" value="${payWayDetail.typeName}" />
		</td>		
	  </tr>	 
	  
	  <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
		style="empty-cells:show">
		<td id="t13" style="width:15%" align="right"><font color="red">*</font>收款内容&nbsp;</td>
		<td style="width:50%" colspan="3">			
			${payWayDetail.feeType}
			<input type="hidden" name="payWayDetail.feeType" value="${payWayDetail.feeType}" />
		</td>
	  </tr>	 
	 	  
	  <tr style="background:#E9F5FF; text-align:left"> 
		<td id="t13" style="width:15%" align="right">
			付款时间
		</td>
		<td id="t14" colspan="3"></td>
					
	  </tr>	 
		
	   <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
		style="empty-cells:show">
		<td id="t13" style="width:15%" align="right">
			<input type="radio" name="time" value="1" id="time1"/>
			<label for="time1">变动</label>&nbsp;
		</td>
		<td id="t14" colspan="3">
		在<font color="#FF0000">认购日期</font>之后的第
			<input id="dayNum" class="easyui-numberspinner" min="0" max="10000"  style="width:50px;" name="payWayDetail.dayNum" value="${payWayDetail.dayNum}"/>天
		</td>	
	  </tr>	 
	  
	   <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
		style="empty-cells:show">
		<td id="t13" style="width:15%" align="right">
			<input type="radio" name="time" value="2" id="time2" />
			<label for="time2">固定</label>&nbsp;	
		</td>
		<td id="t14" colspan="3">
		在<input  class="easyui-datebox" style="width:90px" name="payWayDetail.payDate" id="payDate" 
		value='<s:date name="#request.payWayDetail.payDate" format="yyyy-MM-dd"/>'/>
		</td>	
	  </tr>	 
	  
	  <tr style="background:#E9F5FF; text-align:left"> 
		<td id="t13" style="width:15%" align="right">
			付款金额
		</td>
		<td id="t14" colspan="3"></td>
					
	  </tr>	 
		
	     <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
		style="empty-cells:show">
		<td id="t13" style="width:15%" align="right">
			<input type="radio" name="money" value="1" id="money1"/>
			<label for="money1">固定金额</label>&nbsp;
		</td>
		<td id="t14" colspan="3">
		<input id="payMoney"  name="payWayDetail.payMoney"
			class="easyui-numberspinner" min="0" value="${payWayDetail.payMoney}" increment="100" style="width:120px;" precision="0" groupSeparator=","></input>
		</td>	
	  </tr>	 
	  
	   <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
		style="empty-cells:show">
		<td id="t13" style="width:15%" align="right">
			<input type="radio" name="money" value="2" id="money2" />
			<label for="money2">按总房款比例(%)</label>&nbsp;
		</td>
		<td id="t14" colspan="3">
		<input  id="payPercent" name="payWayDetail.payPercent" 
			class="easyui-numberbox" value="${payWayDetail.payPercent}" max="100" min="0" precision="4" groupSeparator="," suffix=" %" style="width:115px;"></input>
		</td>	
	  </tr>	 

	 <s:if test="#request.payWayDetail.feeType == \"首期\"">
	   <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
		style="empty-cells:show;" id="isIncludeDepositTr">
		<td id="t13" style="width:15%" align="right">是否包含定金&nbsp;</td>
		<td id="t14" style="width:30%" colspan="3">
			<s:select list="selIncludeDeposit" id="isInclude" name="payWayDetail.isInclude"></s:select> 
		</td>		
	  </tr>	 
	  </s:if>
	  
	  <s:if test="#request.payWayDetail.feeType == '按揭'">
	  <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
		style="empty-cells:show;" id="roundingTr">
		<td id="t13" style="width:15%" align="right">取整方式&nbsp;</td>
		<td id="t14" style="width:30%" colspan="3">
			<s:select list="selRounding" id="modNum" name="payWayDetail.modNum"></s:select>
		</td>		
	  </tr>	 
	  </s:if>
	 
	</table>
	
 </form>
</body>
</html>