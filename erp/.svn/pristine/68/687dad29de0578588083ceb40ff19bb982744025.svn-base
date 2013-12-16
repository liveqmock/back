<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 13-4-15
  Time: 上午11:15
  业绩排行榜.
--%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<script type="text/javascript">
    //传值
    var colors = Highcharts.getOptions().colors,name = '业绩排行榜';
    var categories = [<s:property value="categories"  escape="false"/>];
    var data_yeji = [<s:property value="sumlist"  escape="false"/>];
</script>

<script type="text/javascript" src="<%=basePath%>ui/include/index/js/charts_yeji.js"></script>


<div id="pp" style="position:relative;width:600px;">
    <div style="width:60%;">
        <div  title="销售业绩排行榜(截至当前时间)" closable="false" style="height:570px;overflow: hidden;">

            <div id="char_yeji" style="width:100%;height:540px; overflow:inherit;"></div>
        </div>
    </div>

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
    </div>
</div>