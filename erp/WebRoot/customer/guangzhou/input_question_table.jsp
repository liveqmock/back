<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<table style="width: 100%;line-height: 20px" border="0" align="center" cellpadding="0" cellspacing="1" class="gbox" >
    <s:iterator value="tocList" id="c" status="status">
        <tr style="background-color: #ffffff;">
            <td>
            <s:if test="#c.isRequired">
            	<font color="red">*</font>
            </s:if> 
            ${c.topicName}
            </td>
        </tr>
        <tr style="background-color: #ffffff;">
            <td>${c.inputAndOtherHtml}</td>
        </tr>
        <input id="formMapProId" type="hidden" name="formMap.proId" value="${proId}"/>
        <input id="formMapquesId" type="hidden" name="formMap.quesId" value="${questId}"/>

    </s:iterator>
</table>


