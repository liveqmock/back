<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">

<head>
	
	<title>新增成交客户</title>
	
	<s:include value="../../customer/guangzhou/header_min.jsp"></s:include>	  
		
	<script type="text/javascript" language="javascript" src="<%=basePath%>js/jquery.easyui.min.js"></script>
	<script type="text/javascript" language="javascript" src="<%=basePath%>css/local/easyui-lang-zh_CN.js"></script>
	<link href="./css/easyui.css" rel="stylesheet" type="text/css" charset="utf-8"/>
	<link href="./css/icon.css" rel="stylesheet" type="text/css" charset="utf-8"/>
	
	<script type="text/javascript" language="javascript" src="./js/project.list.utils.js?v=1.2"></script>
	<script type="text/javascript" language="javascript" src="./js/customer_value_change.js"></script>
	
	<script type="text/javascript" language="javascript">
		
		$().ready(function(){
			
			$("#gender").combobox({
				editable:false,
				onLoadSuccess:function(node, data){
				
					var module = $("#gender").combotree('textbox');
					$(module).bind('focus', function(){
						$("#gender").combotree('showPanel');	
					}).bind('blur', function(){
						$("#gender").combotree('hidePanel');	
					});					
				}
			});
			
			$("#idcardType").combobox({
				editable:false,
				onLoadSuccess:function(node, data){
				
					var module = $("#idcardType").combotree('textbox');
					$(module).bind('focus', function(){
						$("#idcardType").combotree('showPanel');	
					}).bind('blur', function(){
						$("#idcardType").combotree('hidePanel');	
					});					
				}
			});
			
			$("#mobilePhone").blur(function(){
			
				var mobilePhone = $(this).val();
				if($.trim(mobilePhone) != ""){
					$.ajax({
						type: "get",
						url: "./saleunit_new/appoint/guangzhou/isMobilePhoneExistsByProjectIdAndConfirmType.action",
						data: "mobilePhone=" + mobilePhone + "&confirmType=" + $("#confirmType").val() + "&projectId=" + $("#projectId").val(),
						dataType: "html",
						success: function(data){
						
							if(data == null || data == ""){
								return ;
							}
							
							$("#changeCustomerToCopyDialogHtmlId").html(data);	
							
							$("#changeCustomerToCopyDialog").dialog({
								resizable: true,
								modal:true, //模态窗口,表示不能操作弹出框以外的内容
								maximizable: false, //显示最大化按钮
								width:450,
								height:220,
								buttons:[				 
								{
									text:'选择',
									iconCls:'icon-ok',
									handler:function(){
										//copyCustomerId										
										var checkedModule = $("input:[name='copyCustomerId']:checked");
										
										var customerId = checkedModule.val();
										if(customerId == undefined || customerId == ""){
											parent.myAlert("请选择客户");
											return ;
										}
										
										var preCustomerType = checkedModule.attr("preCustomerType");
										if(preCustomerType == undefined || preCustomerType == ""){
											parent.myAlert("客户类型不合法");
											return ;
										}
										
										//判断二者销售id是否有交集,有交集表示一致,就进行确认框提示
										var copyCustomerSalesId = checkedModule.attr("salesId"); //选择的要复制的客户的销售id
										var contractSalesId = $("#salesId").val(); //对应要新建的成交单选择的销售id
										
										var isIntersect = intersect(copyCustomerSalesId, contractSalesId); //判断是否有交集
										if(!isIntersect){
											parent.myConfirm("前后销售不一致,是否继续?", function(){
												
												$('#changeCustomerToCopyDialog').dialog('close');	
												fillCustomer(customerId, preCustomerType);		
											});
											
										}else{
											
											//刷新整个界面
											$('#changeCustomerToCopyDialog').dialog('close');	
											fillCustomer(customerId, preCustomerType);		
										}
																																					
									}
								},
								{
									text:'跳过',
									iconCls:'icon-cancel',
									handler:function(){
										$('#changeCustomerToCopyDialog').dialog('close');
									}
								}]
							});
											
							$('#changeCustomerToCopyDialog').dialog('open');
							$('#changeCustomerToCopyDialog').dialog('setTitle', '选择客户');
						}
					});					
				}
				
			});
			
		});
		
		
		
	</script>
	
	<script type="text/javascript" language="javascript">
		
		//判断两个字符串分割的数组是否有交集
		function intersect(src, desc){
			
			if($.trim(src) == "" || $.trim(desc) == ""){
				return false;
			}
			
			var srcArr = src.split(",");
			var descArr = desc.split(",");
			
			var isIntersect = false;
			
			$(srcArr).each(function(index){
				
				if(contains(descArr, srcArr[index])){
					
					isIntersect = true;
					return false;
				}
				
			});			
			
			return isIntersect;			
		}
		
		//判断数组是否包含目标字段
		function contains(srcArr, desc){
		
			var isContains = false;
			
			$(srcArr).each(function(index){
				
				if(srcArr[index] == desc){
				
					isContains = true;
					return false;
				}								
			});		
			
			return isContains;
		}
		
		
	</script>
	
	<script type="text/javascript" language="javascript">
		
		function fillCustomer(customerId, preCustomerType){
					
			try{						
				
				var module = $("body");
				var width = module.width();
				var height = module.height();
				
				var mask = '<div id="maskDiv" style="display: block;" class="datagrid-mask"></div>'; // width: 578px; height: 31px;
				var msg = '<div id="msgDiv" style="display: block;" class="datagrid-mask-msg">加载中...</div>'; //left: 242.5px; top: -5.5px; 
				
				$(module).append(mask);
				$(module).append(msg);
				
				$("#maskDiv").width(width).height(height+10);
				$("#msgDiv").css("left", width/3+20).css("top", height/2);
				
			}catch(e){}
			
			location.href = "./saleunit_new/appoint/guangzhou/copyForAddContractCustomer.action?preCustomerType=" + preCustomerType 
				+ "&customerId=" + customerId + "&confirmType=" + $("#confirmType").val() + "&projectId=" + $("#projectId").val();
		}
	</script>
	
	<style type="text/css">
		*{margin:0;padding:0;}
		body{font-size:75%}
		
	</style>
	
</head>
<body>
<div class="gbox1">			

<form action="./saleunit_new/appoint/guangzhou/addContractCustomer.action" method="post" id="contractCustomerFormId">
			  
	<table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" class="gbox" style="font-size:12px; line-height:26px">	
	
		<tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
		style="empty-cells:show">
		<td id="t13" style="width:15%" align="right"><font color="#FF0000">*</font>移动电话&nbsp;</td>
		<td id="t14">			
			
			<input type="text" id="mobilePhone" name="customer.mobilePhone" 
				onkeyup="valueChangeGetCount('mobilePhone', 'phoneCount', 11)" onkeydown="valueChangeGetCount('mobilePhone', 'phoneCount', 11)"/>
			<span id="phoneCount"></span>
			
			<input type="hidden" id="confirmType" name="customer.confirmType" value="${confirmType}"/>
			<input type="hidden" id="projectId" name="customer.projectId" value="${unit.companyProjectId}" />
			<input type="hidden" id="salesId" value="${salesId}" /> <!-- 对应成交单选择的销售,也就是新销售-->
		</td>		
	  </tr>	 
			  
		<tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
		style="empty-cells:show">
		<td id="t13" style="width:15%" align="right"><font color="#FF0000">*</font>客户姓名&nbsp;</td>
		<td id="t14">
			<input type="text" id="customerName" name="customer.customerName" />
		</td>		
	  </tr>	 
	  
	  <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
		style="empty-cells:show">
		<td id="t13" style="width:15%" align="right">性别&nbsp;</td>
		<td id="t14">
			<s:select list="selCustomerGender" cssStyle="width:auto" id="gender" name="customer.gender" />
		</td>		
	  </tr>	 
	  
	  <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
		style="empty-cells:show">
		<td id="t13" style="width:15%" align="right">固定电话&nbsp;</td>
		<td id="t14">
			<input type="text" id="phone" name="customer.phone" />
		</td>		
	  </tr>	 
	  
	  <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
		style="empty-cells:show">
		<td id="t13" style="width:15%" align="right"><font color="#FF0000">*</font>证件类型&nbsp;</td>
		<td id="t14">
			<s:select list="selCustomerIdCardType" cssStyle="width:auto" id="idcardType" name="customer.idcardType"/>
		</td>		
	  </tr>	 
	  
	  <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
		style="empty-cells:show">
		<td id="t13" style="width:15%" align="right"><font color="#FF0000">*</font>证件号码&nbsp;</td>
		<td id="t14">
			
			<input type="text" id="idcardNo" name="customer.idcardNo" 
				onkeyup="valueChangeGetCount('idcardNo', 'idcardNoCount', 30)" onkeydown="valueChangeGetCount('idcardNo', 'idcardNoCount', 30)" onblur="getBirthday();"/>
			<span id="idcardNoCount"></span>
			
		</td>		
	  </tr>
	  
	  <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
		style="empty-cells:show">
		<td id="t13" style="width:15%" align="right"><font color="#FF0000"></font>生日&nbsp;</td>
		<td id="t14">
			<input type="text" id="birthday" style="width:90px" name="customer.birthday"/>
			<span id="birthdaySpan"></span>
			
		</td>		
	  </tr>	 	 
	  
	  <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
		style="empty-cells:show">
		<td id="t13" style="width:15%" align="right"><font color="#FF0000">*</font>通讯地址&nbsp;</td>
		<td id="t14">
			<input type="text" id="address" name="customer.address" style="width:95%"/>
		</td>		
	  </tr>	 
	  
	  <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
		style="empty-cells:show">
		<td id="t13" style="width:15%" align="right">邮编&nbsp;</td>
		<td id="t14">
			<input type="text" id="postcode" name="customer.postcode" />
		</td>		
	  </tr>	 
	  
	</table>
</form>	
	
	</div>
	
	<div id="changeCustomerToCopyDialog">
		<div class="gbox1" id="changeCustomerToCopyDialogHtmlId"></div>
	</div>
	
	<div id='loading' style="position:absolute;z-index:100000;top:0px;left:0px;width:100%;height:45%; background-color:#CCCCCC;text-align:center;padding-top: 20%; display:none">
		<h1><image src='images/loading.gif'/><font color="#15428B"><script type="text/javascript" language="javascript">document.write(parent.myGlobal.loadIng)</script></font></h1>
	</div>

</body>
</html>
