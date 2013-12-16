<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="pt" uri="/WEB-INF/projectText.tld" %> 
<%@ taglib prefix="my" uri="/WEB-INF/my.tld" %> 

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<script language="javascript" type="text/javascript">

	$.ed().ready(function(){
		$.ed("#showConfirmDetailFormId").bind('click', function(){
			showConfirmDetail(${confirm.id});
		});
	});

	
</script>


<div class="gbox1">			

<form action="./saleunit_new/appoint/guangzhou/submitTart.action" method="post" id="submitTartFormId">
			  
	<table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" class="gbox" style="font-size:12px; line-height:26px">	
	
		  <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			style="empty-cells:show">
			<td id="t1" style="width:15%" align="right"><font color="red">*</font>单元编号&nbsp;</td>
			<td id="t2" style="width:25%" colspan="3">
			${unit.allName}
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<input type="button" value="  查看详细  "  id="showConfirmDetailFormId"/>
			<input type="hidden" id="checkUnitId" name="tart.unitId" value="${unit.id}" />
			<input type="hidden" name="unitId" value="${unit.id}" />
			<input type="hidden" name="tart.mainId" value="${confirm.id}" />
			</td>						
		  </tr>	 
		  
		  <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
				<td id="t3" style="width:15%" align="right"><font color="red"></font>客户姓名&nbsp;</td>
                <td id="t4" style="width:30%">
					<s:iterator value="contractCustomerList" var="c">
						${c.customerName}
						&nbsp;
					</s:iterator>
				</td>		
                <td id="t5" style="width:15%" align="right"><font color="red"></font>认购日期&nbsp;</td>
                <td id="t6" style="width:30%">
					<s:date name="#request.confirm.signDate" format="yyyy-MM-dd"/>
				</td>			
              </tr>	 
	
		  <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			style="empty-cells:show">
			<td id="t7" style="width:15%" align="right"><font color="red"></font>已收金额&nbsp;</td>
			<td id="t8" style="width:25%">
				${tart.tartMoney}</td>					
			<td id="t9" style="width:15%" align="right"><font color="red"></font>挞定日期&nbsp;</td>
			<td id="t10" style="width:25%">
				<s:date name="#request.tart.tartDate" format="yyyy-MM-dd"/>
		  </tr>	 
		  
		   <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			style="empty-cells:show">
			<td id="t11" style="width:15%" align="right"><font color="red"></font>批准人&nbsp;</td>
			<td id="t12" style="width:25%">
				${tart.approverMan}</td>					
			<td id="t13" style="width:15%" align="right"><font color="red"></font>经办人&nbsp;</td>
			<td id="t14" style="width:25%">
				${tart.inputMan}</td>	
		  </tr>	 
		  
		   <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			style="empty-cells:show">
			<td id="t15" style="width:15%" align="right"><font color="red"></font>备注&nbsp;</td>
			<td id="t16" style="width:25%">
				${tart.remark}				</td>				
			<td id="t17" style="width:15%" align="right"></td>
			<td id="t18" style="width:25%"></td>	
		  </tr>	 
			  
			</table>
</form>	
	
	</div>




