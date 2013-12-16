<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page import="com.ihk.permission.PermissionUtils" %>
<%@ page import="com.ihk.constanttype.EnumPrivCode" %>
<%@ page import="com.ihk.constanttype.EnumDevFlag" %>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>销售分析(按销售 人员)</title>

    <s:include value="../../header/header_easyui.jsp"></s:include>
    <script language="javascript" type="text/javascript" src="<%=basePath%>js/project.list.utils.js?v=1.2"></script>
    <script type="text/javascript" src="<%=basePath%>js/highcharts.js"></script>
    <script type="text/javascript" src="<%=basePath%>js/datetime.utils.js?v=1"></script>
    <script type="text/javascript" src="<%=basePath%>/js/customer_guangzhou_project.js" ></script>

    <script type="text/javascript">
        /**
         * 格式化数字显示方式
         * 用法
         * formatNumber(12345.999,'#,##0.00');
         * formatNumber(12345.999,'#,##0.##');
         * formatNumber(123,'000000');
         * @param num
         * @param pattern

         */
        function formatNumber(num,pattern){
            var strarr = num?num.toString().split('.'):['0'];
            var fmtarr = pattern?pattern.split('.'):[''];
            var retstr='';

            // 整数部分
            var str = strarr[0];
            var fmt = fmtarr[0];
            var i = str.length-1;
            var comma = false;
            for(var f=fmt.length-1;f>=0;f--){
                switch(fmt.substr(f,1)){
                    case '#':
                        if(i>=0 ) retstr = str.substr(i--,1) + retstr;
                        break;
                    case '0':
                        if(i>=0) retstr = str.substr(i--,1) + retstr;
                        else retstr = '0' + retstr;
                        break;
                    case ',':
                        comma = true;
                        retstr=','+retstr;
                        break;
                }
            }
            if(i>=0){
                if(comma){
                    var l = str.length;
                    for(;i>=0;i--){
                        retstr = str.substr(i,1) + retstr;
                        if(i>0 && ((l-i)%3)==0) retstr = ',' + retstr;
                    }
                }
                else retstr = str.substr(0,i+1) + retstr;
            }

            retstr = retstr+'.';
            // 处理小数部分
            str=strarr.length>1?strarr[1]:'';
            fmt=fmtarr.length>1?fmtarr[1]:'';
            i=0;
            for(var f=0;f<fmt.length;f++){
                switch(fmt.substr(f,1)){
                    case '#':
                        if(i<str.length) retstr+=str.substr(i++,1);
                        break;
                    case '0':
                        if(i<str.length) retstr+= str.substr(i++,1);
                        else retstr+='0';
                        break;
                }
            }
            return retstr.replace(/^,+/,'').replace(/\.$/,'');
        }

        //dategrid显示下划线，超链接
        function formatterSalesName(value,row,index){
            if(value == '合计')return value;
            var date1 = $("#date1").datebox('getValue');
            var date2 = $("#date2").datebox('getValue');

            var salesId = row.salesId;
            if(salesId.charAt(0)==","){
                salesId = salesId.substring(1,salesId.length);
            }
            if(salesId.charAt(salesId.length-1)==","){
                salesId = salesId.substring(0,salesId.length-1);
            }

            var strIds=salesId.split(",");
            var strNames=row.salesName.split(",");

            var str = "";
            for (i=0;i<strIds.length ;i++ ){
                str+= formatterSalesName_Url(strIds[i],strNames[i],date1,date2);
                str+=",";
            }
            if(str.charAt(str.length-1)==","){
                str = str.substring(0,str.length-1);
            }

            return 	str;
        }

        function formatterSalesName_Url(salesId,salesName,date1,date2){
            var url = './saleunit_new_report/report/guangzhou/saleReportSaleUnit.action?'+
                    'cond.date1='+date1+
                    '&cond.date2='+date2+
                    '&cond.strSalesId='+salesId+
                    '&selType='+$("#selType").val();
            var url = "<a style='color: #1199FF;cursor: pointer;' class='ablue' onclick=\"parent.OpenAndRefreshTab(" + "\'销售分析(单元明细)_"+salesName+"\',\'" + url + "\')\">" + salesName + "</a>";
            return 	url;
        }

        //查询本周
        function queryFormByWeek(){
            setTwoDatebox("thisweek",$("#date1"),$("#date2"));
            queryForm();
        }

        //查询本月
        function queryFormByMonth(){
            setTwoDatebox("thismonth",$("#date1"),$("#date2"));
            queryForm();
        }

        //查询
        function queryForm(){
            //使用.datagrid的方法设置easyui组件,那么该table的class不要设置为easyui-datagrid，否则会两次加载渲染
            $("#dg").datagrid({
                url:"./saleunit_new_report/report/guangzhou/saleReportSaleAjax.action",
                queryParams:getInputsAsOjbect(["cond.strSearchCompanyProjectIds","cond.date1","cond.date2","cond.strSalesId","cond.sort","cond.order","selType"])
            });
        }

        $().ready(function() {
            var paraObj = requestParaToObject();

            //根据传入的参数来进行查询
            if(typeof(paraObj["cond.strSearchCompanyProjectIds"])!="undefined"){
                $("#projectIds").val(paraObj["cond.strSearchCompanyProjectIds"]);
                $("#date1").datebox("setValue",paraObj["cond.date1"]);
                $("#date2").datebox("setValue",paraObj["cond.date2"]);
                $("#selType").val(paraObj["selType"]);
                queryForm();
            }
            else{
                queryFormByMonth();
            }
            bindProjectDialogForXKZXOnly("projectNames", "projectIds"); //多个项目的选择(单选)

            baseProjectListForHiddenId("saleName", "hiddenUserId", "./customer_guangzhou/search/sales.action", "");
        });

        function download(){
            location.href = './saleunit_new_report/report/guangzhou/saleReportSaleDownload.action';
        }
    </script>
</head>
<body style="padding:0px;background:white;">
<table
        id="dg"
        style="width:auto;height:auto;"
        toolbar="#toolbar"
        pagination="false"
        rownumbers="true" fitColumns="true"
        singleSelect="true"
        showFooter='true'
        striped='true'
        >
    <thead>
    <tr>
        <th field="salesName"  width="100" formatter="formatterSalesName">销售</th>
        <th field="projectName"  width="100" >项目</th>
        <th field="sumAmount" width="100" sortable="true" align="right">套数</th>
        <th field="sumArea" width="100" sortable="true" align="right" >面积(㎡)</th>
        <th field="sumMoney" width="100" sortable="true" align="right">总价(元)</th>
    </tr>
    </thead>
</table>
<div id="toolbar" style="padding:5px;height:auto">
    &nbsp;项目<input type="text" id="projectNames" size="40"/>
    <input type="hidden" id="projectIds" name="cond.strSearchCompanyProjectIds"/>
    &nbsp;销售<input type="text" id="saleName"  name="cond.saleName" title="按空格键可以查找前十条数据"/>
    <input type="hidden" id="hiddenUserId" name="cond.strSalesId" />
    <input type="hidden" name="cond.sort" value="sumMoney"/>
    <input type="hidden" name="cond.order" value="desc"/>
    日期<input class="easyui-datebox" type="text" id="date1" name="cond.date1" style="width:90px" />
    -
    <input class="easyui-datebox" type="text" id="date2" name="cond.date2" style="width:90px" />
    类型<s:select list="#{'confirm':'认购','contract':'签约','confirmBook':'临定'}" id="selType" name="selType" listKey="key" listValue="value" ></s:select>
    &nbsp;<input type="button" onclick="queryForm()" value=" 查询 "/>

    <%if(PermissionUtils.hasPermission(EnumPrivCode.REPORT_SALEUNIT_DOWNLOAD, EnumDevFlag.GUANGZHOU) ){%>
    &nbsp;<input type="button" onclick="download()" value=" 导出 "/>
    <%} %>

</div>
</body>
</html>



   
   



