<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page contentType="text/html; charset=utf-8" %>

<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html>

<head>
	
	<base href="<%=basePath%>">
	
	<style type="text/css">
		*{margin:0;padding:0;}
		body{font-size:75%}
		.gbox {
			background: none repeat scroll 0 0 #A9D9FF;
		}
		
		.Wdate{
			border:#999 1px solid;
			height:20px;
			background:#fff url(css/datePicker.gif) no-repeat right;
		}
	</style>
	
	<link href="./dateinput/date_input.css" rel="stylesheet" type="text/css" charset="utf-8"/>	
	
	<script type="text/javascript" language="javascript" src="./js/jquery-1.6.2.min.js"></script>	    
	<script type="text/javascript" language="javascript" src="./js/customer_common.js"></script>
	<script type="text/javascript" language="javascript" src="./js/common.js"></script>
	
	<script type="text/javascript" language="javascript" src="<%=basePath%>js/jquery.easyui.min.js"></script>
	<script type="text/javascript" language="javascript" src="<%=basePath%>css/local/easyui-lang-zh_CN.js"></script>
	<link href="./css/easyui.css" rel="stylesheet" type="text/css" charset="utf-8"/>
	<link href="./css/icon.css" rel="stylesheet" type="text/css" charset="utf-8"/>
	
	<script type="text/javascript" language="javascript" src="./js/saleunit_new_common_min.js"></script>
	
	 <script type="text/javascript" language="javascript">
	 
		 //jQuery.extend(DateInput.DEFAULT_OPTS, dateInputCN);   
		
		 $(document).ready(function(){
		 
		 	 closeIframeDialog("myIframeDialog", "${closeMark}", "", "${suggestion}");
	
			 //$('.Wdate').date_input();
			 
			 $("#extensionDay").numberspinner({
			 	onSpinUp:function(){
					var value = $('#extensionDay').numberspinner("getValue");
					var signDateLong = $("#signDateLong").val();
					//$("#newApplyTime").val(getDateStrDiff(signDateLong, value));
					$("#newApplyTime").datebox("setValue", getDateStrDiff(signDateLong, value));
				},
				
				onSpinDown:function(){
					var value = $('#extensionDay').numberspinner("getValue");
					var signDateLong = $("#signDateLong").val();
					//$("#newApplyTime").val(getDateStrDiff(signDateLong, value));
					$("#newApplyTime").datebox("setValue", getDateStrDiff(signDateLong, value));
				}
			 	
			 });
			
			 $("#extensionDay").blur(function(){
			 	
				 var value = $('#extensionDay').numberspinner("getValue");
				 var signDateLong = $("#signDateLong").val();
				 //$("#newApplyTime").val(getDateStrDiff(signDateLong, value));
				 $("#newApplyTime").datebox("setValue", getDateStrDiff(signDateLong, value));				
			 });
			 
			$("#newApplyTime").datebox({
				onChange: function(newValue, oldValue){
					
					var signDateLong = $("#signDateLong").val();
					$('#extensionDay').numberspinner("setValue", getDayDiff(newValue, signDateLong));	
				}
			});
			  
			  /**
			  $("#newApplyTime").change(function(){
			 	
				 var newApplyTime = $('#newApplyTime').val();
				 var signDateLong = $("#signDateLong").val();
				 $('#extensionDay').numberspinner("setValue", getDayDiff(newApplyTime, signDateLong));				  
				 
			 });
			 */
			
		 });
		 
		 function loadClose(){
			<%
				String loadClose = request.getParameter("loadClose");
				if("true".equals(loadClose)){
			%>			
			window.setTimeout(function(){window.parent.closeExtension();}, 1000);
			<%
				}
			%>		
			
		}
		 
	</script>
		
	
<title>延期签约</title></head>

<body>

	<form id="addExtensionContractForm" action="./saleunit_new/appoint/guangzhou/addExtensionContract.action" method="get">

	<table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" class="gbox" style="font-size:12px; line-height:26px">			

		<tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" style="empty-cells:show">
		<td id="t15" style="width:30%" align="left" colspan="2">1.申请内容&nbsp;&nbsp;<font color="#FF0000"><span id="addSuggestion">${suggestion}</span></font></td>
		</tr>

	  	<tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" style="empty-cells:show">
		<td id="t15" style="width:30%" align="center"><font color="#FF0000">*</font>申请日期</td>
		<td id="t16" style="width:70%">&nbsp;&nbsp;<input class="easyui-datebox" type="text" id="applyTime" style="width:90px" name="extensionContract.applyTime" />
        	<!--
        	<input class="Wdate" id="applyTime" style="width:90px" name="extensionContract.applyTime" />
            -->
           
		</td>
		</tr>
		
		 <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" style="empty-cells:show">
		<td id="t15" style="width:30%" align="center">客户已付金额</td>
		<td id="t16" style="width:70%">&nbsp;&nbsp;${payBill.hadPay}</td>
		</tr>
		
		 <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" style="empty-cells:show">
		<td id="t15" style="width:30%" align="center">原约定签约日期</td>
		<td id="t16" style="width:70%">&nbsp;&nbsp;${signDate}
		<input type="hidden" value="${signDateLong}" id="signDateLong"/>
		<input type="hidden" value="${unit.id}" id="unitId" name="extensionContract.uid"/>
		<input type="hidden" value="${conCustomer.id}" id="customerId" name="extensionContract.cid"/>
		<input type="hidden" value="${signDate}" id="oldSignDate" name="extensionContract.oldSignDate" />
		</td>
		</tr>
		
		 <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" style="empty-cells:show">
		<td id="t15" style="width:30%" align="center"><font color="#FF0000">*</font>延期签约天数</td>
		<td id="t16" style="width:70%">&nbsp;&nbsp;<input name="extensionContract.extensionDay" id="extensionDay" class="easyui-numberspinner" 
			min="0" value="0" required="false" style="width:90px;"></input></td>
		</tr>
		
		 <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" style="empty-cells:show">
		<td id="t15" style="width:30%" align="center"><font color="#FF0000">*</font>改为签约日期</td>
		<td id="t16" style="width:70%">&nbsp;&nbsp;<input class="easyui-datebox" type="text" id="newApplyTime" style="width:90px"/>
        	<!--
        	<input class="Wdate" id="newApplyTime" style="width:90px"/>
            -->
            	
            </td>
		</tr>
		
		 <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" style="empty-cells:show">
		<td id="t15" style="width:30%" align="center"><font color="#FF0000">*</font>是否首次延期</td>
		<td id="t16" style="width:70%">&nbsp;&nbsp;<s:select list="selExtensionFirst" name="extensionContract.extensionFirst" cssStyle="width:auto" id="extensionFirst" />
		</td>
		</tr>
		
		 <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" style="empty-cells:show">
		<td id="t15" style="width:30%" align="center">延期签约原因</td>
		<td id="t16" style="width:70%">&nbsp;&nbsp;<textarea style="font-size:12px; width:80%; height:60px" id="extensionReason" 
        	name="extensionContract.extensionReason" ></textarea></td>
		</tr>
		
		<tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" style="empty-cells:show">
		<td id="t15" style="width:30%" align="left" colspan="2">2.批准内容</td>
		</tr>
		
		 <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" style="empty-cells:show">
		<td id="t15" style="width:30%" align="center">延期批准人</td>
		<td id="t16" style="width:70%">&nbsp;&nbsp;<input type="text" id="approvedMan" name="extensionContract.approvedMan"/></td>
		</tr>
		
		 <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" style="empty-cells:show">
		<td id="t15" style="width:30%" align="center">延期批准日期</td>
		<td id="t16" style="width:70%">&nbsp;&nbsp;<input class="easyui-datebox" type="text" id="approvedDay" style="width:90px" name="extensionContract.approvedDay" />
        	<!--
        	<input class="Wdate" id="approvedDay" name="extensionContract.approvedDay" style="width:90px"/>
            -->
           
            </td>
		</tr>		
		
	</table>
	
	</form>
	
</body>
</html>