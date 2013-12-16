<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>


<meta http-equiv=Content-Type content="text/html; charset=utf-8" /> 

<link href="../css/blue.css" rel="stylesheet" type="text/css"
	charset="utf-8" />

<script type="text/javascript" language="javascript" src="js/jquery-1.6.2.min.js"></script>

<script type="text/javascript" language="javascript">
	$().ready(function(){
		$("#save").click(function(){
			var customerName = $("#customerName_").val(); 
			var phone = $("#phone_").val();
			
			if(customerName != "" && phone != ""){
				$.ajax({
					type:"post", //get有时会出现乱码
					url: "./customer!quickAddCustomer.action",
					dataType: "html",
					data: "customerName=" + customerName + "&phone=" + phone,
					success: function(data){
						var showText = "";
						if(data == "succ"){
							showText = "创建成功";
						}else{
							showText = "创建失败,请重新创建";
						}
						$('#showText').html(showText);
						setTimeout(function(){clearText();}, 2000);
						
						$("#customerName_").val("");
						$("#phone_").val("");		
					}
				});
			}		
				 
			 return false;		
			
		});
		
		
		function clearText(){
			$('#showText').html("");
		}
		
		$("#customerName_").focus(function(){
			clearText();
		});
			 
	});
</script>

<table width="100%" border="0" cellspacing="0">
	<tr>
		<td width="263">
			<div class="leftmain" id="leftmain">
				
				<div class="lefttitle">
					<!-- <a href="#" title="新建" target="_blank">+ 新建</a> -->
				</div>
				
				<div>
					<div class="leftopenboxtitle">
						具体功能
					</div>
					<div class="leftopenbox">
						<ul>
							<a href="<%=request.getContextPath() %>/customer!doSomeForAddCustomer.action" target="_self">+ 新建客户</a>							
						</ul>
						<ul>
							<a href="<%=request.getContextPath() %>/customer!searchCustomer.action?from=left" target="_self">+ 查询客户 </a>
						</ul>
						
						<s:if test="#session.loginAccount.accountType == 2 ">
							<ul>
								<a href="<%=request.getContextPath() %>/indexUserAccount.action?tips=reset">+ 用户管理</a>	
							</ul>
						</s:if>
											
					</div>
				</div>
				
				<!--
				<div class="leftopenboxtitle01">
					<a href="#"><img src="images/blue/recycle.gif" alt="回收站"
							width="17" height="23" border="0" /> 回收站</a>
				</div>
				-->
				
				
				<!--
				<div class="lefttitle">
					快速创建&nbsp;&nbsp;<span id="showText"></span>
				</div>
				
				<div class="leftcreatenav">
					<div class="leftcreate">
						*客户名称
					</div>
					<div class="leftcreatebox">

						<label for="textfield"></label>
						<input type="text" name="customer.customerName" id="customerName_"
							class="leftcreateinputbox" />

					</div>
				</div>
				<div class="leftcreatenav">
					<div class="leftcreate">
						电话
					</div>
					<div class="leftcreatebox">

						<label for="textfield"></label>
						<input type="text" name="customer.phone" id="phone_"
							class="leftcreateinputbox" />

					</div>
				</div>
				
				
				<div class="leftcreatenav">
					<div class="leftcreatesave iconbg">
						<a href="#" id="save">保 存</a>
					</div>
				</div>
				-->
			</div>
		</td>
		
		
		<td width="23" align="center" valign="middle">

			<img src="<%=request.getContextPath() %>/images/blue/arrow.gif"
					alt="分隔符" width="23" height="31" border="0" id="arrow"/>

		</td>
	</tr>
</table>
