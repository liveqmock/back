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
		
			$("#companyTable .projectTr").show();
		
			var projectIds = $("input[name=projectName]");
			$(projectIds).each(function(){
			
				$(this).attr("checked", "checked");
			});
		}
		
		/**
		function noChange(){
		
			var projectIds = $("input[name=__project__]");
			$(projectIds).each(function(){
			
				$(this).removeAttr("checked");
			});
		}
		
		$().ready(function(){
			
			$("#companyId").change(function(){
			
				var selectedId = $("#companyId option:selected").val();
				
				if(selectedId == ""){
				
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
		*/
		
		function _submit(){
		
			var selectedId = $("#companyId option:selected").val();
			if(selectedId == ""){
				
				allChange();
			}else{
				
				$(".projectTr").each(function(){
					
					var thisId = $(this).attr("id");
					if(thisId == "com_"+selectedId){
					
						var projectIds = $(this).find("input[name=projectName]");
						$(projectIds).each(function(){
						
							$(this).attr("checked", "checked");
						});
						$(this).show();
					}else{
						
						var projectIds = $(this).find("input[name=projectName]");
						$(projectIds).each(function(){
						
							$(this).removeAttr("checked");
						});						
						$(this).hide();
					}
					
				});
				
			}
			
		}
		
		function add(){
		
			var selectedId = $("#companyId option:selected").val();
			if(selectedId == ""){
				
				allChange();
			}else{
				
				var projectIds = $("#com_" + selectedId).find("input[name=projectName]");
				$(projectIds).each(function(){
				
					$(this).attr("checked", "checked");
				});
				$("#com_" + selectedId).show();
			}
		}
				
	</script>
	
	<style type="text/css">
		*{margin:0;padding:0;}
		.appendTr{background-color:#D9E5FD;}
		.check label{margin-right:8px}
	</style>
	
</head>
	
<body>
<div class="gbox1">			
		 
<table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" class="gbox" style="font-size:12px; line-height:26px" id="companyTable">	

	<tr bgcolor="#E9F5FF" style="empty-cells:show">
		
		<td id="t15" style="width:25%" align="center"><b>公司</b>&nbsp;</td>
		<td colspan="3">
		<s:select list="#request._selCompanyMap" cssStyle="width:auto" id="companyId" value="#request._selectCompanyId" />
		 <a href="javascript:void(0)" style="padding:0 0 0 10px" onclick="return _submit()"><font color="#5482DE">确定</font></a>
		 <a href="javascript:void(0)" style="padding:0 0 0 10px" onclick="return add()"><font color="#5482DE">增加</font></a>
		</td>
	  </tr>
	 
	 
	 <!--
	  <tr bgcolor="#E9F5FF" style="empty-cells:show">
		
		<td id="t15" style="width:25%" align="center"></td>
		<td colspan="3">
		
		 <a href="javascript:void(0)" style="padding:0 0 0 10px" onclick="return allChange()"><font color="#5482DE">全选</font></a>
		 
		 <b>项目</b>&nbsp;
		 <a href="javascript:void(0)" style="padding:0 0 0 10px" onclick="return noChange()"><font color="#5482DE">取消</font></a>
		</td>
	  </tr>
	  -->
	  
	  
	  <s:iterator value="#request.map" id="c">  
	   <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" style="empty-cells:show" id="com_${c.key.id}" class="projectTr">
	  
	  		<td id="t15" style="width:25%" align="center"><b>${c.key.companyName}</b>&nbsp;</td>
			
			<td colspan="3" style="white-space:normal;line-height: 30px" class="check">
				<my:checkboxlist list="${c.value}" name="projectName" valueField="id" textField="projectName" selectedId="${_projectId}"/>				
			</td>
					
	  </tr>	
	</s:iterator>
	  
</table>
	
</div>


</body>
</html>