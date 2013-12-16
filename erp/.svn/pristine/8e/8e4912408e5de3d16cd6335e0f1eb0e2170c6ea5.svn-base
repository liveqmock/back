<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 13-4-15
  Time: 上午11:05
  To change this template use File | Settings | File Templates.
--%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>

<script type="text/javascript">
    var series_value = <s:property value="chartSeriesData"  escape="false"/>;
    var categories_value = <s:property value="chartXAxis"  escape="false"/>;
</script>
<script type="text/javascript" src="<%=basePath%>ui/include/index/js/other.js"></script>

<div id="pp" style="position:relative;width:600px;">
    <div style="width:40%;">
        <div title="最新公告" closable="false" style="height:150px;padding:5px;">

            <s:iterator value="#request.listArt" id="b">
                <div class="t-list">
                    [${dayString }] <a href="<%=basePath %>customer_guangzhou/article/show.action?id=${id}" target="_self" onClick="return showArticle('<%=basePath %>customer_guangzhou/article/show.action?id=${id}')">${title }</a>
                </div>
            </s:iterator>
            <s:if test="#request.listArt.size()==0">
                暂无公告
            </s:if>
        </div>


        <div title="最近来访客户情况" closable="false" style="height:150px;padding:5px;">
            <table width="100%" border="0" align="center" cellspacing="0" style="margin-bottom:5px;">
                <tr>
                    <td colspan="3">
                        <table width="100%" cellpadding="0" cellspacing="1" bgcolor="#a6d8ff">
                            <tr class="gboxbg">
                                <td width="40%" height="24" style="text-align: center">录入日期</td>
                                <td width="20%" style="text-align: center">客户数</td>
                                <td width="40%" style="text-align: center">项目名称</td>
                            </tr>
                            <s:iterator value="#request.noticeList" id="n">
                                <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF">
                                    <td height="24" bgcolor="#FFFFFF" style="text-align: center"><s:date name="#n.created_time" format="yyyy-MM-dd"/></td>
                                    <td bgcolor="#FFFFFF" style="text-align: center"><s:property value="#n.cou"/></td>
                                    <td bgcolor="#FFFFFF" style="text-align: center"><s:property value="#n.project_id"/></td>
                                </tr>
                            </s:iterator>
                        </table>
                    </td>
                </tr>
            </table>

        </div>
    </div>

    <div style="width:60%;">
        <div title="访客户情况" closable="false" style="height:auto;padding:5px;">
            <div id="container" style="margin:0;overflow:inherit"></div>
        </div>
    </div>

</div>

