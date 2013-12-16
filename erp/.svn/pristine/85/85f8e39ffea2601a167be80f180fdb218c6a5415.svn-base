<%@ page import="com.ihk.permission.PermissionUtils" %>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<script type="text/javascript">
    $(function () {
        var data_1 = <s:property value="data"  escape="false" />;
        var data_2 = <s:property value="data2"  escape="false"/>;
        //var data_3 = <s:property value="data3"  escape="false"/>;
        var data_4 = <s:property value="data4"  escape="false"/>;


        <% if (PermissionUtils.isReportOnlySale()) { %>
        data_1 = Math.round((data_1)/100)/100 + "";
        data_2 = Math.round((data_2)/100)/100 + "";
        <% } else {%>
        data_1 = Math.round((data_1)/1000000)/100 + "";
        data_2 = Math.round((data_2)/1000000)/100 + "";
        <% }%>


        $("#data_1").html(milliFormat(data_1));
        $("#data_2").html(milliFormat(data_2));
        //$("#data_3").html(data_3);
        $("#data_4").html(data_4);
    });

    function milliFormat(s){//添加千位符
        if(/[^0-9\.]/.test(s)) return "invalid value";
        s=s.replace(/^(\d*)$/,"$1.");
        s=(s+"00").replace(/(\d*\.\d\d)\d*/,"$1");
        s=s.replace(".",",");
        var re=/(\d)(\d{3},)/;
        while(re.test(s)){
            s=s.replace(re,"$1,$2");
        }
        s=s.replace(/,(\d\d)$/,".$1");
        return s.replace(/^\./,"0.")
    }


</script>

<div id="char_report18" style="height: 210px; margin: 0 10px auto;">
    <table border="0" cellspacing="1" cellpadding="4" width="100%">
        <tbody>
        <% if (PermissionUtils.isReportOnlySale()) { %>

        <tr>
            <td width="100%"  align="left">
                <b>总销量：</b><span id="data_2"></span> 万元
            </td>
        </tr>
        <tr>
            <td width="100%"  align="left">
                <b>售前客户数：</b><span id="data_4"></span> 人
            </td>
        </tr>
        <% } else {%>
        <tr>
            <td width="100%"  align="left">
                <b>总货量：</b><span id="data_1"></span> 亿元
            </td>
        </tr>

        <tr>
            <td width="100%"  align="left">
                <b>总销量：</b><span id="data_2"></span> 亿元
            </td>
        </tr>
        <tr>
            <td width="100%"  align="left">
                <b>售前客户数：</b><span id="data_4"></span> 人
            </td>
        </tr>
        <% } %>
        <%--<tr>
            <td width="100%"  align="left">
                <b>总应收佣金：</b><span id="data_3"></span> 万元
            </td>
        </tr>--%>

        </tbody>
    </table>
</div>
            
            
            
            
