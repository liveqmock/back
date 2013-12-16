<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
         isELIgnored="false"%>
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
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>成交客户背景分析</title>
    <s:include value="header_report.jsp"></s:include>

    <script type="text/javascript" src="<%=basePath%>js/highcharts.js"></script>
    <script type="text/javascript">
		$().ready(function() {
	        bindProjectDialogForXKZX("projectName", "hiddenId"); //多个项目的选择
	        parent.hideLoading("成交客户背景分析");
		});

        function submitSearch(dir){
            
            parent.showLoading();
            $("#thisForm").submit();
           
        }
        
        //function exportMessage(){
		///		location.href='./saleunit_new_report/report/guangzhou/xshlfxLcdownload.action'  
		//}
		
		//查看项目列定义
		//function query() {
		//	$('#openlcIframe')[0].src="./saleunit_new_report/report/guangzhou/queryXshlfxLcL.action";
		//	$('#querylc').window('open');  
		//}
    </script>
</head>
<body  style="padding:0px;background:white;">

<div class="right99"></div>
<form class="registerform" id="thisForm" method="post" action="./saleunit_new_report/report/guangzhou/cjkhbj.action">
    <table width="1200px" border="0" align="left" cellspacing="0">

        <tr>
            <td colspan="6"><label>&nbsp;<span>项目</span> </label>
                <input type="text" id="projectName" size="40" />
                <input type="hidden" id="hiddenId" name="contractCustomerCond.searchProjectIdStr" value="${contractCustomerCond.searchProjectIdStr}" />

                	日期<input class="easyui-datebox" type="text" style="width:90px"
					name="contractCustomerCond.date1" value="${contractCustomerCond.date1}" /> - <input
					class="easyui-datebox" type="text" style="width:90px"
					name="contractCustomerCond.date2" value="${contractCustomerCond.date2}" /> 
				    &nbsp;<input type="button" onclick="return submitSearch('search')" value=" 查询  " />
                        <!--<input type="button" onclick="return submitSearch('export')" value="导出" />
                        <a class="easyui-linkbutton" iconCls="icon-search" href="javascript:void(0);" onclick="query()">查看项目列定义</a>
                --><div class="right99"></div>
                <div class="blueline"></div></td>
        </tr>

        <!-- 搜索表单 end -->
      
    </table>
</form>

</body>
</html>
