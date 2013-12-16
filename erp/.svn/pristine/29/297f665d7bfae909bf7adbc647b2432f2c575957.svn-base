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
	<script type="text/javascript" language="javascript" src="./js/project.text.utils.js?v=1.6"></script>
	
	<title>增加付款方式明细</title>
	<style type="text/css">
		*{margin:0;padding:0;}
		body{font-size:75%}
		
	</style>
	
	<script type="text/javascript" language="javascript">
		$().ready(function(){
		
			//绑定并初始化
			bindPayTypeByFeeEdit("typeName", "feeType", true, "feeTypeFixedId", ${textType}, ${wayId});
			
			//隐藏
			$("#feeType").combobox("textbox").parent().hide();
			
			//设置相关级联属性
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
	
	<script type="text/javascript" language="javascript">
		//其他(新增自定义)
		function modifyFeeType(){
			//typeName feeType
			var typeName = $("#typeName").combobox("getValue");
			if(typeName == ""){
				myAlert("请先选择收费类别");
				return false;
			}
			
			$("#feeType").combobox("textbox").parent().show();
			$("#feeType").combobox("enable");
			cancelRadio();
		}
		
		//取消选择
		function cancelRadio(){
			$("#feeTypeFixedId input[type=radio]").each(function(){
				this.checked = false;
			});
			
			$("#isIncludeDepositTr").hide();
			$("#roundingTr").hide();
		}
		
		//房款固定的收款内容
		function changeRadio(index){
			if(index == "0"){
				//定金
				$("#isIncludeDepositTr").hide();
				$("#roundingTr").hide();
			}else if(index == "1"){
				//首期
				$("#isIncludeDepositTr").show();
				$("#roundingTr").hide();
			}else if(index == "2"){
				//按揭
				$("#isIncludeDepositTr").hide();
				$("#roundingTr").show();
			}
			
			//把自定义选择设为不可选择
			$("#feeType").combobox("setValue", "");
			$("#feeType").combobox("disable");
			$("#feeType").combobox("textbox").parent().hide();
		}
	</script>
	
	</head>
<body>

<!--
<form action="./saleunit_setup/payway/dialogPayWayDetailForm.action" id="question_toc_form" method="post">
-->
<form action="./saleunit_setup/payway/addPayWayDetail.action" id="addFormId" method="post">
	
	<table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" class="gbox" style="font-size:12px; line-height:26px;" id="payWayDetailTable">
	
	<tr style="background:#E9F5FF; text-align:left"> 
		<td id="t13" style="width:20%" align="right">
			费用名称
			<input type="hidden" name="payWayDetail.wayId" value="${wayId}"/>
			<!-- 兼容新的表结构,设置__text_type__及__main_id__-->
			<input type="hidden" id="__text_type__" value="${textType}" />
			<input type="hidden" id="__main_id__" value="${wayId}" />
		</td>
		<td id="t14" colspan="3"></td>
					
	  </tr>	 
		
	   <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
		style="empty-cells:show">
		<td id="t13" style="width:15%" align="right"><font color="red">*</font>收费类别&nbsp;</td>
		<td id="t14" style="width:30%" colspan="3">
			<s:select list="selPayType" id="typeName" name="payWayDetail.typeName"></s:select>
		</td>		
	  </tr>	 
	  
	  <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
		style="empty-cells:show">
		<td id="t13" style="width:15%" align="right"><font color="red">*</font>收款内容&nbsp;</td>
		<td style="width:50%" colspan="3">			
			<span id="feeTypeFixedId"></span>
			<a href="javascript:void(0)" style="color:#5482DE; padding:0 10px 0 0" onclick="modifyFeeType()">(其他)</a>
			<pt:sel cssStyle="width:auto" id="feeType" name="payWayDetail.feeType"/>
		</td>
		<!--		
		<td id="t15" style="width:35%" align="left" colspan="2">
			<pt:sel cssStyle="width:auto" id="feeType" name="payWayDetail.feeType"/>
		</td>
		-->
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
		在<font color="#FF0000">认购日期</font>之后的第
			<input id="dayNum" class="easyui-numberspinner" min="0" max="10000"  style="width:50px;" name="payWayDetail.dayNum" value="0"/>天
		</td>	
	  </tr>	 
	  
	   <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
		style="empty-cells:show">
		<td id="t13" style="width:15%" align="right">
			<input type="radio" name="time" value="2" id="time2" />
			<label for="time2">固定</label>&nbsp;	
		</td>
		<td id="t14" colspan="3">
		在<input  class="easyui-datebox" disabled="true" style="width:90px" name="payWayDetail.payDate" id="payDate" />
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
		<input id="payMoney"  name="payWayDetail.payMoney"
			class="easyui-numberspinner" min="0" value="1000" increment="100" style="width:120px;" precision="0" groupSeparator=","></input>
		</td>	
	  </tr>	 
	  
	   <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
		style="empty-cells:show">
		<td id="t13" style="width:15%" align="right">
			<input type="radio" name="money" value="2" id="money2" />
			<label for="money2">按总房款比例(%)</label>&nbsp;
		</td>
		<td id="t14" colspan="3">
		<input  id="payPercent" name="payWayDetail.payPercent" disabled="true"  
			class="easyui-numberbox" value="0.0000" max="100" min="0" precision="4" groupSeparator="," suffix=" %" style="width:115px;"></input>
		</td>	
	  </tr>	 	  
	  
	 <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
		style="empty-cells:show; display:none" id="isIncludeDepositTr">
		<td id="t13" style="width:15%" align="right">是否包含定金&nbsp;</td>
		<td id="t14" style="width:30%" colspan="3">
			<s:select list="selIncludeDeposit" id="isInclude" name="payWayDetail.isInclude"></s:select> 
		</td>		
	  </tr>	 
	  
	  <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
		style="empty-cells:show; display:none" id="roundingTr">
		<td id="t13" style="width:15%" align="right">取整方式&nbsp;</td>
		<td id="t14" style="width:30%" colspan="3">
			<s:select list="selRounding" id="modNum" name="payWayDetail.modNum"></s:select>
		</td>		
	  </tr>	 
	 
	</table>
	
 </form>
</body>
</html>