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
    
    <title>My JSP 'dialog_add_unit_group.jsp' starting page</title>

  </head>
  <script>
  function formsubmit (){
		document.getElementById("this_form").submit();
  }

	</script>
  <body>
   <form action="./saleunit_new/unit/group/dialogAddUnitGroupForm.action" id="this_form" method="post">
   	 <table width="100%" style="background-color: #A9D9FF">
   	<tr style="background-color: #ffffff">
   		<td align="right">	组团名称</td><td align="left">	<input name="unitGroup.groupName"/>	<input type="hidden" value="${proId }" name="proId"/></td>
   	</tr>
   </table>
   
   </form>
  </body>
</html>
