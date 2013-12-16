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
	
	<link href="./css/easyui.css" rel="stylesheet" type="text/css" charset="utf-8"/>
	<link href="./css/icon.css" rel="stylesheet" type="text/css" charset="utf-8"/>	
	<link href="./css/unit_table.css"  rel="stylesheet" type="text/css" charset="utf-8"/><!-- unit的样式 -->	
	
	<script type="text/javascript" language="javascript" src="<%=basePath%>js/jquery.easyui.min.js"></script>
	<script type="text/javascript" language="javascript" src="<%=basePath%>css/local/easyui-lang-zh_CN.js"></script>

	<script type="text/javascript" language="javascript" src="./js/easyui.utils.js"></script>
	<script type="text/javascript" language="javascript" src="./js/project.text.utils.js"></script>
	
	<title>付款方式明细</title>
	<style type="text/css">
		*{margin:0;padding:0;font-size: 12px}
		th{background-color: #eeeeee ;line-height: 24px}
		td{background-color: #ffffff;line-height: 24px}
		table{background-color: #eeeeee;width: 100%;line-height: 24px}
	</style>
	
	<script type="text/javascript" language="javascript">
		$().ready(function(){

			initProjectTextComboboxForAuto(["detailNameId"]);
			
			$("#payType").combobox({
				editable:false,
				onChange:function(newValue, oldValue){
				
					//$("#selFeeTypeId").combobox();
					
					setHiddenTypeNameValue("detailNameId", newValue);
										
					$("#detailNameId").combobox("reload", "./saleunit_financial_manager/guangzhou/payTypeToFeeType.action?payTypeId=" + newValue);	
					$("#detailNameId").combobox("select", "");
				
				}
			});
									
		});
		
		
	</script>
	
	<script type="text/javascript" language="javascript">
	$.fn.datebox.defaults.formatter = function(date){
		var y = date.getFullYear();
		var m = date.getMonth()+1;
		var d = date.getDate();
		return y+'-'+m+'-'+d;
	}
	
	function formsubmit (){
		document.getElementById("question_toc_form").submit();
    }

	
	function time1(){
		$("#time1_input").removeAttr('disabled');
		$('#time2_input').combo('disable');
	}
	function time2(){
		$("#time1_input").attr("disabled","disabled");
		$('#time2_input').combo('enable');
	}

	function money1(){
		$("#money1_input").removeAttr('disabled');
		$('#money2_input').numberbox('disable');
	}
	function money2(){
		$("#money2_input").numberbox('enable');
		$('#money1_input').attr("disabled","disabled");
	}
    $().ready(function(){
    	
    	
		$("#time1").click(function(){time1()})
		$("#time2").click(function(){time2()})
		$("#money1").click(function(){money1()})
		$("#money2").click(function(){money2()})
		
    	
    	$('#time2_input').combo('disable');
    	$("#money2_input").attr("disabled","disabled");
       })

	</script>
	</head>
<body>
<%-- 
<div class="gbox1" style="">		
<form action="./saleunit_setup/payway/dialogPayWayDetailForm.action" id="question_toc_form" method="post">	
	<table width="100%" border="0" align="center" cellpadding="0" cellspacing="1"  style="font-size:12px; line-height:26px;">
		<tr bgcolor="#ffffff">
			<td width="120px" align="right">款项</td>
			<td width="">
				<input type="hidden" name="wayId" value="${wayId }"/>
				<input name="payWayDetail.detailName" value="${payWayDetail.detailName }"/>
			</td>
		</tr>
		<tr bgcolor="#ffffff">
			<td  align="right">天数</td>
			<td>
					<input name="payWayDetail.dayNum" value="${payWayDetail.dayNum }"/>
			</td>
		</tr>
		<tr bgcolor="#ffffff">
			<td  align="right">基数金额种类</td>
			<td>
					<input name="payWayDetail.baseMoneyType" value="${payWayDetail.baseMoneyType }"/>
			</td>
		</tr>
		<tr bgcolor="#ffffff">
			<td  align="right">金额</td>
			<td>
					<input name="payWayDetail.payMoney" value="${payWayDetail.payMoney }"/>
			</td>
		</tr>
		<tr bgcolor="#ffffff">
			<td  align="right">比例</td>
			<td>
					<input name="payWayDetail.payPercent" value="${payWayDetail.payPercent }"/>
			</td>
		</tr>
		<tr bgcolor="#ffffff">
			<td  align="right">四舍五入位数</td>
			<td>
					<input name="payWayDetail.modNum" value="${payWayDetail.modNum }"/>
			</td>
		</tr>
		<tr bgcolor="#ffffff">
			<td  align="right">是否包含定金</td>
			<td>
			<s:if test="#request.payWayDetail.isInclude = '1'">
			<input name="payWayDetail.isInclude" type="checkbox" value="1"  checked="checked"/>
			</s:if>
			<s:else>
			<input name="payWayDetail.isInclude" type="checkbox" value="1"  />
			</s:else>
					
			</td>
		</tr>
		<tr bgcolor="#ffffff">
			<td  align="right">备注</td>
			<td>
					<input name="payWayDetail.remark" value="${payWayDetail.remark }" />
			</td>
		</tr>
		<tr bgcolor="#ffffff">
			<td  align="center" colspan="2" style="color: red"> ${mag }</td>
			
		</tr>
	</table>
	</form>
</div>
--%>
<form action="./saleunit_setup/payway/dialogPayWayDetailForm.action" id="question_toc_form" method="post">
<table width="100%">
	<tr>
		<th colspan="2" align="left">费用名称
		<input type="hidden" name="wayId" value="${wayId }"/>
		</th>
	</tr>
	<tr>
		<td>收费类别</td>
		<td>
			<!-- 
			<s:select list="selPayType" name="payWayDetail.payType"></s:select>
			-->
			<s:select list="selPayType" id="payType" name="payWayDetail.payType" value=""></s:select>
		</td>
		<td>收款内容</td>
		<td>
			<!--
			<input name="payWayDetail.detailName"/>
			-->
			<pt:sel cssStyle="width:auto" id="detailNameId" name="payWayDetail.detailName" typeName=""/>
		</td>
		
	</tr>
</table>

<table>
	<tr>
		<th colspan="4" align="left">期数</th>
	</tr>
	<tr>
		<td colspan="4">第<input  class="easyui-numberspinner" min="1" max="100"  style="width:80px;"></input>期
		</td>
	</tr>
</table>


<table>
	<tr>
		<th colspan="4" align="left">付款时间</th>
	</tr>
	<tr>
		<td><input type="radio" name="time" value="1" id="time1" checked="checked"/>变动</td>
		<td colspan="3">
			在<select><option>认购日期</option></select>之后的第<input  id="time1_input"  class="easyui-numberspinner" min="0" max="10000"  style="width:80px;" name="payWayDetail.dayNum" />天
		</td>
	</tr>
	<tr>
		<td><input type="radio" name="time" value="2" id="time2" />固定</td>
		<td colspan="3">
			在<input  class="easyui-datebox"  name="payWayDetail.payDate" id="time2_input" />
		</td>
	</tr>
	<%--
	<tr>
		<td><input type="radio" name="time"/>不指定时间</td>
		<td colspan="3">
		</td>
	</tr>
	 --%>
</table>


<table>
	<tr>
		<th colspan="4" align="left">付款金额</th>
	</tr>
	<tr>
		<td><input type="radio" name="money" value="1" id="money1" checked="checked"/>固定金额</td>
		<td colspan="3">
			<input id="money1_input"  name="payWayDetail.payMoney"
			class="easyui-numberspinner" max="999999" min="0" value="1000" increment="100" style="width:120px;" precision="0" groupSeparator=","></input>
		</td>
	</tr>
	<tr>
		<td><input type="radio" name="money" value="2" id="money2" />按总房款比例</td>
		<td colspan="3">
			<input  id="money2_input" name="payWayDetail.payPercent" 
			class="easyui-numberbox" value="0.0000" max="100" min="0" precision="4" groupSeparator="," suffix=" %" style="width:115px;"></input>
		</td>
	</tr>
	<tr>
		<td colspan="4" style="color: red">${mag }</td>
	</tr>
	
	
	<%--
	<tr>
		<td><input type="radio" name="money"/>按贷款比例</td>
		<td colspan="3">
		<input value="100%"/>
		</td>
	</tr>
	<tr>
		<td colspan="4"><input type="radio" name="money"/>按<select><option>套内面积</option> <option>建筑面积</option></select> X <input />
		</td>
	</tr>
	 --%>
</table>
<%--
<table>
	<tr>
		<th colspan="4" align="left">取整方式</th>
	</tr>
	<tr>
		<td colspan="4"><select><option>小数两位</option> </select> </td>
	</tr>
	
</table>
 --%>
 </form>
</body>
</html>