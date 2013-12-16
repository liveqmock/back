<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html>
  <head>
     <base href="<%=basePath%>"/>
    
     <title>组团</title>
     
     <s:include value="../../header/header_easyui.jsp"/>
	 <script type="text/javascript" language="javascript">
		 $.messager.defaults = { ok: "确定", cancel: "取消" };
		var is_check = '0';
		$().ready(function(){
			$("#del_fn_yes").click(function(){is_check = '1'})
			$("#del_fn_no").click(function(){is_check = '0'})
		})
		 
		  function formsubmit (){
			  if(is_check == '1'){
				  $.messager.confirm('确认','是否确定删除?',function(b){
						if(b){
							document.getElementById("this_form").submit();
						}
					})
				}else{
					document.getElementById("this_form").submit();
				}
				
				
		  }
	  </script>
	  
  </head>
  
  <body style="font-size: 12px;margin: 0px;padding: 0px">
  
   <form action="./saleunit_new/unit/group/dialogUpdateUnitGroupForm.action" id="this_form" method="post">
   	 <table width="100%" style="background-color: #A9D9FF">
   			 <tr style="background-color: #eeeeee">
		   		<td colspan="2">修改名称</td>	
		   	</tr>
		   	<tr style="background-color: #ffffff">
		   	
		   		<td align="right">组团名称</td>
		   		<td align="left">
		   			&nbsp;&nbsp;<input name="unitGroup.groupName" value="${unitGroup.groupName}"/>
		   			<input type="hidden" value="${groupId}" name="groupId"/>
		   		</td>
		   		
		   	</tr>
		   	<tr style="background-color: #eeeeee">
		   		<td colspan="2">删除该组团</td>	
		   	</tr>
		   	
	   		<tr style="background-color: #ffffff">
	   	
	   		<td align="right">是否删除</td>
	   		<td align="left">
	   			&nbsp;&nbsp;否<input type="radio" value="0" name="unitGroup.isDeleted" checked="checked" id="del_fn_no"/>
	   			&nbsp;&nbsp;是<input type="radio" value="1" name="unitGroup.isDeleted" id="del_fn_yes"/>
	   		</td>
	   		
	   	</tr>
    </table>
   </form>
   	<p><s:actionmessage escape="false"/></p>
  </body>
</html>
