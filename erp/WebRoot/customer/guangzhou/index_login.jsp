<%@ page import="com.ihk.utils.CacheUtils" %>
<%--suppress HtmlUnknownTarget --%>
<%@ page language="java" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page contentType="text/html; charset=utf-8" %>

<%@ taglib prefix="s" uri="/struts-tags" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>

    <title>主页</title>

    <base href="<%=basePath%>">

    <s:include value="header.jsp"></s:include>
    <s:include value="header_left_js.jsp"></s:include>

    <link href="css/main20111105.css"  rel="stylesheet" type="text/css" charset="utf-8"/>

    <script type="text/javascript" language="javascript" src="<%=basePath%>js/customer_guangzhou_project.js"></script>
    <script type="text/javascript" src="<%=basePath%>js/highcharts.js"></script>
    <script type="text/javascript" src="<%=basePath%>js/ui_fix.js"></script>
    <script type="text/javascript" src="<%=basePath%>js/nowtime.js"></script>
    <script type="text/javascript" src="<%=basePath%>js/DD_belatedPNG_0.0.8a-min.js"></script>
    <script type="text/javascript">
        $().ready(function(){
          DD_belatedPNG.fix('.logintitle,.loginbox,.logo');
        });
    </script>
    <script type="text/javascript" language="javascript">
        $().ready(function(){
            nowTime("nowTime");
        });
    </script>

    <script type="text/javascript">
        var chart;
        $(document).ready(function() {
            chart = new Highcharts.Chart({
                chart: {
                    renderTo: 'container',
                    defaultSeriesType: 'line'
                },
                title: {
                    text: '最近7天来访客户情况'
                },
                xAxis: {
                    categories:
                    <s:property value="chartXAxis"  escape="false"/>
                },
                yAxis:
                {
                    allowDecimals: false,min:0,
                    title: {
                        text: '人数'
                    },
                    plotLines: [{
                        value: 0,
                        width: 1,
                        color: '#808080'
                    }]
                }
                ,
                legend: {
                    layout: 'vertical',
                    backgroundColor: '#FFFFFF',
                    align: 'left',
                    verticalAlign: 'top',
                    x: 100,
                    y: 70,
                    floating: true,
                    shadow: true
                },
                tooltip: {
                    formatter: function() {
                        var tips = ''+this.x +' ' + this.series.name +' :'+ commafy(this.y);
                        if(this.series.name=="来电"){
                            tips += '组';
                        }

                        return tips;
                    }
                },
                plotOptions: {
                    column: {
                        pointPadding: 0.2,
                        borderWidth: 0
                    }
                },
                series:
                <s:property value="chartSeriesData"  escape="false"/>
            });

        });

    </script>

    <style type="text/css">
        *{margin:0;padding:0;}
    </style>

</head>

<body>


<%--固定的上部 --%>
<s:include value="body_up_login_index.jsp"></s:include>



<%--主体table top --%>


<table width="100%" border="0" cellspacing="0">
    <tr>
        <td><table width="100%" border="0" align="right" cellspacing="0">
            <tr>
                <td width="3" height="3" class="leftbg01"></td>
                <td class="midbg01"></td>
                <td width="2" height="3" class="rightbg01"></td>
            </tr>
            <tr>
                <td width="3" class="leftbg02"></td>
                <td bgcolor="#FFFFFF">
                    <table width="100%" border="0" align="center" cellspacing="0">
                        <tr>
                            <td width="100%" valign="top">
                                <div class="l" style="width:30%; overflow:hidden;">
                                    <table width="100%" border="0" align="center" cellspacing="0" style="margin-bottom:10px;">
                                        <tr>
                                            <td height="32" colspan="3">
                                                <span class="titleblue1">最新公告</span>
                                                <a href="customer_guangzhou/article/search.action?ts=<%= CacheUtils.getUrlTimeStamp()%>"><span class="more1">更多..</span></a>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td colspan="3" background="images/blueline.jpg" class="blueline20111105"></td>
                                        </tr>
                                        <s:iterator value="#request.listArt" id="b">
                                            <tr>
                                                <td width="1%" height="24"><img src="images/arrow_collapse.gif" width="10" height="10" alt="arrow" /></td>
                                                <td width="89%" valign="middle"><a href="<%=basePath %>customer_guangzhou/article/show.action?id=${id}" target="_self">${title }</a></td>   <%--：${summary }--%>
                                                <td width="20%" align="right">${dayString }</td>
                                            </tr>
                                        </s:iterator>
                                    </table>

                                    <table width="100%" border="0" align="center" cellspacing="0" style="margin-bottom:5px;">
                                        <tr>
                                            <td height="32" colspan="3"><span class="titleblue1">最近来访客户情况<%--(<s:property value="#request.noticeCond.date1"/>到${noticeCond.date2}的录入情况)--%></span> <a href="#"><span class="more1">更多..</span> </a></td>
                                        </tr>
                                        <tr>
                                            <td colspan="3" background="images/blueline.jpg" class="blueline20111105"></td>
                                        </tr>
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
                                <div class="l" style="width:70%; overflow:hidden;" >
                                    <table width="98%" border="0" align="right" cellspacing="0" class="picbox" >
                                        <tr>
                                            <td>
                                                <div id="container" style="min-width:500px ;height: 250px; margin:0;overflow:inherit"></div>
                                            </td>

                                        </tr>
                                    </table>
                                    <%--<table width="98%" border="0" align="right" cellspacing="0" class="picbox" >
                                        <tr>
                                            <td height="28" align="center" bgcolor="#FFFFFF" class="titleblue">广东合盈在售项目</td>
                                        </tr>
                                        <tr>
                                            <td bgcolor="#FFFFFF"><img src="images/pic1.jpg" width="100%" height="168" alt="销售对比图" /></td>
                                        </tr>
                                    </table>--%>
                                </div>
                            </td>
                        </tr>
                    </table>
                </td>
                <td width="3" class="rightbg02"></td>
            </tr>
            <tr>
                <td class="leftbg03"></td>
                <td class="midbg02"></td>
                <td class="rightbg03"></td>
            </tr>
        </table></td>
    </tr>

</table>
<%--</td>--%>
<%--</tr>--%>

<%--<tr>

    <td>

        <table width="100%" border="0" align="right" cellspacing="0">

            <tr>

                <td width="3" height="3" class="leftbg01"></td>

                <td class="midbg01"></td>

                <td width="2" height="3" background="images/righttop.gif"></td>

            </tr>



            <tr>

                <td class="leftbg03"></td>

                <td class="midbg02"></td>

                <td class="rightbg03"></td>

            </tr>

        </table>

    </td>

</tr>--%>

<!--main.end-->



<%--</table>--%>


<%--主体table end --%>



<%--固定的底部 --%>
<s:include value="body_bottom.jsp">
</s:include>
</table>

</body>
</html>

