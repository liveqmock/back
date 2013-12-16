<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="my" uri="/WEB-INF/my.tld" %> 

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html>
<head>
	
	<title>客源共享设置</title>
	
	<s:include value="../../customer/guangzhou/header_min.jsp"></s:include>	  
	
	<link href="./css/easyui.css" rel="stylesheet" type="text/css" charset="utf-8"/>
	<link href="./css/icon.css" rel="stylesheet" type="text/css" charset="utf-8"/>
	
	<script type="text/javascript" language="javascript" src="<%=basePath%>js/jquery.easyui.min.js"></script>
	<script type="text/javascript" language="javascript" src="<%=basePath%>css/local/easyui-lang-zh_CN.js"></script>
	
	<script type="text/javascript" language="javascript" src="<%=basePath%>js/easyui.utils.js"></script>
	<script type="text/javascript" language="javascript" src="<%=basePath%>js/customer_guangzhou_user.js"></script>
	
	<script type="text/javascript" language="javascript">
		function deleteOnlyFollow(id){
			
			deletePojo('./customer/only_follow/easyui/deleteOnlyFollow.action?id=' + id, 
				function(){
					location.href = location.href;
				}, 
				'');
		}
	</script>
    
    <script type="text/javascript" language="javascript">
		$().ready(function(e) {
			
            userListForHiddenId("copyUserName", "copyUserId");  //绑定提示框,该方法在customer_guangzhou_user.js
			
			$("#subBt").click(function(){
				
				var copyUserId = $("#copyUserId").val();
				if(copyUserId == ""){
					myAlert("请先选择销售");
					return ;
				}
				
				var customerIds = $("#customerIds").val();
				
				$.ajax({
					type: "get",
					url: "./customer/only_follow/easyui/setUpOnlyFollow.action?copyUserId=" + copyUserId + "&customerIds=" + customerIds,
					dataType: "json",
					success: function(data){
												
						if(data.type == "true"){
							location.href = location.href;
						}else{
							myAlert("操作失败,请重试");
						}
					},
					error: function(XMLHttpRequest, textStatus, errorThrown){						
						myAlert("请求异常");
					}
					
				});
				
				
			});
        });
	</script>
		
	<style type="text/css">
		*{margin:0;padding:0;}
		body{font-size:75%}
		.rmb_format{text-align: right}
		.isVoid1{text-decoration:line-through}
		.isVoid0{}
		.exChangetd{background-color:#EEAD0E}
		.unit_table td {
			line-height: 20px;
			padding-left: 5px;
			padding-right: 5px;
		}
		
	</style>
	
</head>
<body>
<div class="gbox1">			
			  
	<table  border="0" align="center" cellpadding="0" cellspacing="1" class="gbox unit_table" width="100%" id="followListTableId" style="font-size:12px">	
    
    <tr  style="line-height: 20px;background:#E9F5FF" > 
		
		<th width="100%" align="left" colspan="2">把查看客户资料的权限赋给对应的销售人员</th>
		
	</tr>		

	<tr  style="line-height: 20px;background:#FFFFFF" >
		
		<td width="100" align="center">选择销售人员</td>
		
		<td width="100" align="center">
        	<input type='text' id='copyUserName' name='copyUserName'/>
            <input type='hidden' id='copyUserId' name='copyUserId'/>
            <input type="hidden" id="customerIds" name="customerIds" value="${customerIds}"/>
            <input type="button" id="subBt" value="  赋查看权限  "/>
        </td>
		
	</tr>
    
     <tr  style="line-height: 20px;background:#E9F5FF" > 
		
		<th width="100%" align="left" colspan="2">客户信息查看权限</th>
		
	</tr>	
    
    <tr  style="line-height: 20px;background:#FFFFFF" > 
		
		<td width="100" align="center">客户姓名</td>
		
		<td width="100" align="center">有权限查看的销售人员</td>
		
	</tr>
	
    	
	<s:iterator value="showList" var="c">
		 <tr bgcolor="#FFFFFF" style="line-height: 20px;">  
			
			<td width="100" align="center">${c.key.customerName}</td>
			
			<td width="100" align="center" style="white-space:normal;line-height: 30px">
			
				<s:iterator value="#c.value" var="v">
					${v.userRealName}<a href="javascript:void(0)" style="color:#1199FF; text-decoration:underline;padding: 0px 3px 0px 0px;" 
						onclick="deleteOnlyFollow(${v.id})">(删除)</a>		
				</s:iterator>				
				
			</td>
			
		</tr>
	</s:iterator>
	
</table>

	</div>
	
	
</body>
</html>
