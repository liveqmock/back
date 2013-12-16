<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>

<s:iterator value="#request.listArt" id="b">
    <div class="t-list">
        <font style="font-size:15px">[${dayString }]</font> <a href="<%=basePath %>customer_guangzhou/article/show.action?id=${id}" target="_self" onClick="return showArticle('<%=basePath %>customer_guangzhou/article/show.action?id=${id}')" style="font-size:15px;color: #1199FF;cursor: pointer;"  >${title }</a><s:if test="showNew==true"><img alt="" src="images/gif091.gif"></s:if>
    </div>
</s:iterator>
<s:if test="#request.listArt.size()==0">
    暂无公告
</s:if>