<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
         isELIgnored="false"%>
<%@ page import="com.ihk.constanttype.EnumDevFlag" %>
<%@ page import="com.ihk.constanttype.EnumPrivCode" %>
<%@ page import="com.ihk.permission.PermissionUtils" %>
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
    <title>销售货量分析（按价格）</title>
    <s:include value="header_report.jsp"></s:include>
    <script type="text/javascript" src="<%=basePath%>js/highcharts.js"></script>
    <script type="text/javascript">

        $().ready(function() {
            //projectListForHiddenId("projectName", "hiddenId"); //项目的联想框,及用隐藏域保存其id
            bindProjectDialogForXKZX("projectName", "hiddenId"); //多个项目的选择
            parent.hideLoading("销售货量分析(按价格)"); 
        });

        function submitSearch() {
	          $("#thisForm").submit();
        }
        
        function exportMessage(){
				$(function(){
					$('#exportFm').form({
						url:'./saleunit_new_report/report/guangzhou/xshlfxJgdownload.action'
					});
					$('#exportFm').submit();  
				});
		}
			
		//查看项目列定义
		function query() {
			$('#openjgIframe')[0].src="./saleunit_new_report/report/guangzhou/queryXshlfxJgJ.action";
			$('#queryjg').window('open');  
		}
    </script>
</head>
<body  style="padding:0px;background:white;">

<div class="right99"></div>

    <table width="1000px" border="0" align="left" cellspacing="0">

        <tr>
            <td>
            <form class="registerform" id="thisForm" method="post" action="./saleunit_new_report/report/guangzhou/xshlfxJgReport.action">
            	<label>&nbsp;<span>项目</span> </label>
                <input type="text" id="projectName" size="40" name="propertyUnitCond.strSearchProjectNames" value="${propertyUnitCond.strSearchProjectNames}" />
                <input type="hidden" id="hiddenId" name="propertyUnitCond.strSearchProjectIds" value="${propertyUnitCond.strSearchProjectIds}" />

                </select> 截止日期<input
                        class="easyui-datebox" type="text" style="width:90px"
                        name="propertyUnitCond.date2" value="${propertyUnitCond.date2}" /> &nbsp;<input
                        type="button" onclick="return submitSearch()" value=" 查询  " />
                <div class="right99"></div>
                <div class="blueline"></div>
            </form>
            <form id="exportFm" method="post">
                <%if(PermissionUtils.hasPermission(EnumPrivCode.REPORT_SALEUNIT_DOWNLOAD, EnumDevFlag.GUANGZHOU) ){%>
            	<input style="float:left;margin-left:460px;margin-top:-33px;" type="button" onclick="return exportMessage()" value="导出" />
                <%} %>
                <a class="easyui-linkbutton" style="float:left;margin-left:518px;margin-top:-33px;" iconCls="icon-search" href="javascript:void(0);" onclick="query()">查看项目列定义</a>
            </form>            </td>
        </tr>

        <!-- 搜索表单 end -->
    </table>

<!-- 弹出查看项目列定义页面 -->
	<div id="queryjg" class="easyui-window" title="查看项目列定义" style="width: 530px;height:310px;"
    		 closed="true" maximizable="false" minimizable="false" collapsible="false">
    		   <iframe scrolling="yes" id='openjgIframe' frameborder="0"  src="" style="width:100%;height:100%;"></iframe>
    </div>
</body>
</html>
