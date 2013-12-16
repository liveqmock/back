<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>

<table style="width: 100%;line-height: 20px" border="0" align="center" cellpadding="0" cellspacing="1" class="gbox" >
    <s:iterator value="questionDetailList" var="c">
			 <tr style="line-height: 20px" onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
				 
			  	 <td colspan="6" id="t11"  align="left">
			  	 <s:if test="#c.isRequired">
	            	<font color="red">*</font>
	             </s:if>
			  	  ${c.topicName }
			  	  </td>
               
			  </tr>
			   <tr style="line-height: 20px" onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
			   
                	<td  id="t12" colspan="6">
                	${c.inputAndOtherHtml }
					</td>
				
				
			  </tr>
		<input id="formMapProId" type="hidden" name="formMap.proId" value="${proId}"/>
        <input id="formMapquesId" type="hidden" name="formMap.quesId" value="${questId}"/>
	 </s:iterator>
        


</table>


