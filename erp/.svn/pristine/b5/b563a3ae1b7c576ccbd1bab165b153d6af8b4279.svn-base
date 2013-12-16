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
        $(function(){
        	var date1=$("#date1").val();
        	var date2=$("#date2").val();
        	var hiddenId=$("#hiddenId").val();
		$('#tbForm').datagrid({
                width: 1200,
                height: 430,
                nowrap: true,//是否只显示一行，即文本过多是否省略部分。  
                striped: true,  
                sortName: 'parentID',  
                sortOrder: 'desc', 
                idField:'nodeID', 
                loadMsg:'数据加载中...', 
                url:'./customer/report_json/cjkhbjReport.action?date1='+date1+'&date2='+date2+'&hiddenId='+hiddenId,
                rownumbers: true,
                fitColumns: false, //取消自适应列宽
                frozenColumns:[[  
                ]], 
                columns: [[ 
                    {field:'xs0',title:'客户姓名',width:140,align:'center'},
                    {field:'xs1',title:'居住区域',width:140,align:'center'},
                    {field:'xs2',title:'工作区域',width:140,align:'center'},
                    {field:'xs3',title:'购房用途',width:190,align:'center'},
                    {field:'xs4',title:'置业次数',width:240,align:'center'},
                    {field:'xs5',title:'产品类型',width:140,align:'center'},
                    {field:'xs6',title:'客户来源',width:140,align:'center'}
                ]],
                pagination:false, //不包含分页  
                rownumbers:true,  
	            singleSelect:true
            });
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
<form class="registerform" id="thisForm" method="post">
    <table width="1200px" border="0" align="left" cellspacing="0">

        <tr>
            <td colspan="6"><label>&nbsp;<span>项目</span> </label>
                <input type="text" id="projectName" size="40"/>
                <input type="hidden" id="hiddenId" name="contractCustomerCond.searchProjectIdStr" value="${contractCustomerCond.searchProjectIdStr}" />

                	日期<input class="easyui-datebox" type="text" style="width:90px" id="date1"
					name="contractCustomerCond.date1" value="${contractCustomerCond.date1}" /> - <input
					class="easyui-datebox" type="text" style="width:90px" id="date2"
					name="contractCustomerCond.date2" value="${contractCustomerCond.date2}" /> 
				    &nbsp;<input type="button" onclick="return submitSearch('search')" value=" 查询  " />
                        <!--<input type="button" onclick="return submitSearch('export')" value="导出" />
                        <a class="easyui-linkbutton" iconCls="icon-search" href="javascript:void(0);" onclick="query()">查看项目列定义</a>
                --><div class="right99"></div>
                <div class="blueline"></div></td>
        </tr>

        <!-- 搜索表单 end -->


        <tr>
            <td colspan="6">

                <div class="gbox1" style="height:380px;">
						<table id="tbForm" > </table>
                </div>



                <div class="gbox1" >
                    <table>
                        <tr><td>
                            <div id="container1" style=" margin: 0 auto"></div>

                        </td>
                            <td>
                                <div id="container2" style=" margin: 0 auto"></div>
                            </td>
                            <td></td>
                        </tr>
                        <tr>
                        	<td>
                                <div id="container3" style=" margin: 0 auto"></div>
                            </td>
                        </tr>
                    </table>

                </div>
            </td>
        </tr>

    </table>
</form>

<!-- 弹出查看项目列定义页面 -->
	<div id="querylc" class="easyui-window" title="查看项目列定义" style="width: 530px;height:310px;"
    		 closed="true" maximizable="false" minimizable="false" collapsible="false">
    		   <iframe scrolling="yes" id='openlcIframe' frameborder="0"  src="" style="width:100%;height:100%;"></iframe>
    </div>
</body>
</html>
