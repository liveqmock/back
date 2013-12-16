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
		*{margin:0;padding:0;}
		body{font-size:75%}
		
	</style>
	
	<script type="text/javascript" language="javascript">
		$().ready(function(){
		
			bindPayTypeByFee("payType", "detailNameId");
									
		});
		
	</script>
	
	<script type="text/javascript" language="javascript">
	
	/**
	$.fn.datebox.defaults.formatter = function(date){
		var y = date.getFullYear();
		var m = date.getMonth()+1;
		var d = date.getDate();
		return y+'-'+m+'-'+d;
	}
	*/
	
	function formsubmit (){
		document.getElementById("question_toc_form").submit();
    }
	
	function time1(){
		$("#time1_input").removeAttr('disabled');
		
		$('#time2_input').combo('disable');
		$('#time2_input').datebox('setValue', '');
	}
	
	function time2(){
		
		$("#time1_input").numberspinner('setValue', '');
		$("#time1_input").attr("disabled","disabled");
		
		$('#time2_input').combo('enable');
	}

	function money1(){
	
		$("#money1_input").removeAttr('disabled');
		
		$('#money2_input').numberbox('disable');
		$('#money2_input').numberbox('setValue', '');
	}
	
	function money2(){
	
		$("#money2_input").numberbox('enable');
		
		$("#money1_input").numberspinner('setValue', '');
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

<!--
<form action="./saleunit_setup/payway/dialogPayWayDetailForm.action" id="question_toc_form" method="post">
-->
<form action="./saleunit_setup/payway/dialogPayWayDetailForm.action" id="question_toc_form" method="post">
	
	<table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" class="gbox" style="font-size:12px; line-height:26px">
	
	<tr style="background:#E9F5FF; text-align:left"> 
		<td id="t13" style="width:20%" align="right">
			费用名称
			<input type="hidden" name="wayId" value="${wayId }"/>
		</td>
		<td id="t14" colspan="3"></td>
					
	  </tr>	 
		
	   <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
		style="empty-cells:show">
		<td id="t13" style="width:15%" align="right"><font color="red">*</font>收费类别&nbsp;</td>
		<td id="t14" style="width:30%">
			<s:select list="selPayType" id="payType" name="payWayDetail.payType" value=""></s:select>
		</td>		
		<td id="t15" style="width:15%" align="right"><font color="red">*</font>收款内容&nbsp;</td>
		<td id="t16" style="width:30%">
			<!--
			<input name="payBill.feeType"  id="selFeeTypeId"/>
			-->
			<pt:sel cssStyle="width:auto" id="detailNameId" name="payWayDetail.detailName" typeName=""/>
		</td>			
	  </tr>	 
	  
	  <tr style="background:#E9F5FF; text-align:left"> 
		<td id="t13" style="width:15%" align="right">
			期数
		</td>
		<td id="t14" colspan="3"></td>
					
	  </tr>	 
		
	   <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
		style="empty-cells:show">
		<td id="t13" style="width:15%" align="right">第&nbsp;</td>
		<td id="t14" style="width:30%">
			<input  class="easyui-numberspinner" min="1" max="100"  style="width:80px;"></input>期
		</td>		
		<td id="t15" style="width:15%" align="right"></td>
		<td id="t16" style="width:30%"></td>			
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
			<input type="radio" name="time" value="1" id="time1" checked="checked"/>
			<label for="time1">变动</label>&nbsp;
		</td>
		<td id="t14" colspan="3">
		在<font color="#FF0000">认购日期</font>之后的第<input  id="time1_input"  class="easyui-numberspinner" min="0" max="10000"  style="width:80px;" name="payWayDetail.dayNum" />天
		</td>	
	  </tr>	 
	  
	   <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
		style="empty-cells:show">
		<td id="t13" style="width:15%" align="right">
			<input type="radio" name="time" value="2" id="time2" />
			<label for="time2">固定</label>&nbsp;	
		</td>
		<td id="t14" colspan="3">
		在<input  class="easyui-datebox"  name="payWayDetail.payDate" id="time2_input" />
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
			<input type="radio" name="money" value="1" id="money1" checked="checked"/>
			<label for="money1">固定金额</label>&nbsp;
		</td>
		<td id="t14" colspan="3">
		<input id="money1_input"  name="payWayDetail.payMoney"
			class="easyui-numberspinner" max="999999" min="0" value="1000" increment="100" style="width:120px;" precision="0" groupSeparator=","></input>
		</td>	
	  </tr>	 
	  
	   <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
		style="empty-cells:show">
		<td id="t13" style="width:15%" align="right">
			<input type="radio" name="money" value="2" id="money2" />
			<label for="money2">按总房款比例</label>&nbsp;
		</td>
		<td id="t14" colspan="3">
		<input  id="money2_input" name="payWayDetail.payPercent" 
			class="easyui-numberbox" value="0.0000" max="100" min="0" precision="4" groupSeparator="," suffix=" %" style="width:115px;"></input>
		</td>	
	  </tr>	 
	  
	  <tr style="background:#E9F5FF; text-align:center"> 
		<td colspan="4" style="color: red">${mag }</td>					
	  </tr>	 
	  	  
	  
	</table>
	
 </form>
</body>
</html>