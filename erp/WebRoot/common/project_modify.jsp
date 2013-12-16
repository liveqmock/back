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
	
	<title>选择项目</title>

	<s:include value="../customer/guangzhou/header_min.jsp"></s:include>	  
	
	<script type="text/javascript" language="javascript">
				
		function allChange(){
		
			var projectIds = $("input[name=__project__]");
			$(projectIds).each(function(){
			
				$(this).attr("checked", "checked");
			});
		}
		
		function noChange(){
		
			var projectIds = $("input[name=__project__]");
			$(projectIds).each(function(){
			
				$(this).removeAttr("checked");
			});
		}
		
		$().ready(function(){
			
			$("#companyId").change(function(){
			
				var selectdId = $("#companyId option:selected").val();
				
				if(selectdId == ""){
				
					allChange();
				}else{
				
					var projectIds = $("input[name=__project__]");
					//先移除以前所选的
					$(projectIds).each(function(){
			
						$(this).removeAttr("checked");
					});
					
					//设置对应所选
					$(projectIds).each(function(){
			
						var comId = $(this).attr("comId");
						if(comId == selectdId){
							$(this).attr("checked", "checked");
						}
					});
				}
			});
		});
				
	</script>
	
	<style type="text/css">
		*{margin:0;padding:0;}
		.appendTr{background-color:#D9E5FD;}
	</style>
	
</head>
	
<body>
<div class="gbox1">			
		 
<table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" class="gbox" style="font-size:12px; line-height:26px">	

	<tr bgcolor="#E9F5FF" style="empty-cells:show">
		
		<td id="t15" style="width:25%" align="center"><b>公司</b>&nbsp;</td>
		<td colspan="3">
		<s:select list="#request._selCompanyMap" cssStyle="width:auto" id="companyId" value="#request._selectCompanyId" />
		</td>
	  </tr>
	 
	  <tr bgcolor="#E9F5FF" style="empty-cells:show">
		
		<td id="t15" style="width:25%" align="center"><b>项目</b>&nbsp;</td>
		<td colspan="3">
		<!--
		 <a href="javascript:void(0)" style="padding:0 0 0 10px" onclick="return allChange()"><font color="#5482DE">全选</font></a>
		 -->
		 <a href="javascript:void(0)" style="padding:0 0 0 10px" onclick="return noChange()"><font color="#5482DE">取消</font></a>
		</td>
	  </tr>
	  
	  <s:iterator value="#request.projectBeanTrList" id="c">  
	   <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" style="empty-cells:show">
	  
		<td id="t15" style="width:25%; padding-left:10px" align="left">
			<my:checkbox fieldValue="${c[0].id}" label="${c[0].name}" name="__project__" check="${c[0].check}" comId="${c[0].comId}"/>
		</td>
		<td id="t16" style="width:25%; padding-left:10px" align="left">
			<my:checkbox fieldValue="${c[1].id}" label="${c[1].name}" name="__project__" check="${c[1].check}" comId="${c[1].comId}"/>
		</td>
		<td id="t16" style="width:25%; padding-left:10px" align="left">
			<my:checkbox fieldValue="${c[2].id}" label="${c[2].name}" name="__project__" check="${c[2].check}" comId="${c[2].comId}"/>
		</td>
		<td id="t16" style="width:25%; padding-left:10px" align="left">
			<my:checkbox fieldValue="${c[3].id}" label="${c[3].name}" name="__project__" check="${c[3].check}" comId="${c[3].comId}"/>
		</td>
					
	  </tr>	
	</s:iterator>
	  
</table>
	
</div>


</body>
</html>