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
	
	<title>新增销售</title>

	<s:include value="../../customer/guangzhou/header_min.jsp"></s:include>	  
	
	<script type="text/javascript" language="javascript">
		$().ready(function(){
		
			baseAutoComplete("companySaleName", "commpanySaleId", "./saleunit_new/appoint/guangzhou/searchSaleForCompany.action", "");		

		});
	</script>
	
	<style type="text/css">
		*{margin:0;padding:0;}
	</style>
	
</head>
	
<body>
<div class="gbox1">			
		 
<table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" class="gbox" style="font-size:12px; line-height:26px">	
	   <tr bgcolor="#E9F5FF" style="empty-cells:show">
		
		<td id="t15" style="width:30%" align="center"><b>公司</b>&nbsp;</td>
		<td>(公司的销售只能单条选择)</td>
	  </tr>

	  <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
		style="empty-cells:show; height:26px">
		<td id="t15" style="width:15%" align="right"></td>
		<td id="t16" style="width:30%">				 				 
		  <input type="text" id="companySaleName"/>
		  <input type="hidden" id="commpanySaleId" /> 
		</td>
		
	  </tr>			  
	 
	  <tr bgcolor="#E9F5FF" style="empty-cells:show">
		
		<td id="t15" style="width:30%" align="center"><b>项目</b>&nbsp;</td>
		<td>(项目的销售可以多条选择)</td>
	  </tr>
	  
	   <s:iterator value="#request.trList" id="c">  
	  
	  <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" style="empty-cells:show">
	  
		<td id="t15" style="width:15%; padding-left:10px" align="left"><my:checkbox fieldValue="${c[0].id}" label="${c[0].realName}" name="sale" check="true"/></td>
		<td id="t16" style="width:30%; padding-left:10px" align="left"><my:checkbox fieldValue="${c[1].id}" label="${c[1].realName}" name="sale"/></td>
					
	  </tr>	
	  
	  </s:iterator>
</table>
	
</div>


</body>
</html>