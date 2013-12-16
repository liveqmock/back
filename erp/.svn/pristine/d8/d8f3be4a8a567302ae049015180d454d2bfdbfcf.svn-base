<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html>
  <head>
    <base href="<%=basePath%>" />
    
    <title>addGroupNext</title>

  </head>
  <script>
  var a_unit_id = '';
  function submit_div_sub (){
	 // alert("a_unit_ids =" +a_unit_id+" select_pro= " +select_pro + "buildids= ");
		//document.getElementById("this_form").submit();
	var pro_id = select_pro.substring(1);
	 var add_group_date =  $("#form_add_group").serialize();
	 add_group_date += ('&unitIds='+a_unit_id);
	 add_group_date += ('&proId='+pro_id);
	 
	// alert(add_group_date)

	 $.post('./saleunit_new/unit/group/dialogAddUnitGroupForm.action',add_group_date,function(date){
				$.messager.alert('提示框',date+"","question");
				//flush_group_map(select_group);
				a_unit_id = '';
				pro_id = '';
				add_group_date = '';
				$('#new_dialog_div').dialog('close');
				reload();
			})
  }
  </script>
  <body style="margin: 0;padding: 0">
   <form action="./saleunit_new/unit/group/dialogAddUnitGroupForm.action" id="form_add_group" method="post" style="font-size: 12px;line-height: 24px;">
   <table width="100%" style="background-color: #A9D9FF" id="group_form_table">
   	<tr style="background-color: #eeeeee">
   		<td align="center" width="100px">	组团名称</td><td align="left"> &nbsp;&nbsp;&nbsp;<input name="unitGroup.groupName" />
   		
   		
   		</td>
   	</tr>
   	
   	<s:iterator value="addGroupBuilds" var="c">
   		<tr style="background-color: #ffffff">
   		<td align="center">${c.buildName }</td><td nowrap="nowrap" align="left" style="text-decoration:none;overflow: visible;text-overflow:ellipsis;-o-text-overflow:ellipsis;  -moz-binding: url('ellipsis.xml#ellipsis');"> &nbsp;&nbsp;&nbsp;全选<input type="checkbox" name="buildIds" value="${c.id }"/> <a id="a_${c.id }" buildId="${c.id }" style="outline:aqua;color: #1199FF;cursor: pointer" class="build_a">自定义</a>
   		 </td>
   		</tr>
   	
   	</s:iterator>
   </table>
   </form>
  </body>
</html>
