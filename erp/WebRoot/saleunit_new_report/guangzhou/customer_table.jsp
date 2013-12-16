<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page import="com.ihk.permission.PermissionUtils" %>
<%@ page import="com.ihk.constanttype.EnumPrivCode" %>
<%@ page import="com.ihk.constanttype.EnumDevFlag" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>客户分类明细表</title>

		<base href="<%=basePath%>"/>
		<s:include value="../../header/header_easyui1.3.4.jsp"></s:include>
		<script type="text/javascript" src="<%=basePath%>js/parent_dialog_by_report.js"></script><!-- 分类分析需要的弹出框 -->
		
		<script type="text/javascript" src="<%=basePath%>js/datetime.utils.js?v=1"></script>
		<script language="javascript" type="text/javascript" src="<%=basePath%>js/project.list.utils.js?v=1.2"></script>	
			
		<script type="text/javascript">
		$(document).ready(function() {
			bindProjectDialogForSQKHOnlyQuestion("projectNames", "projectIds"); //单个项目的选择，并且设置该项目的问卷
		});			
								
		function download(){
			location.href = './saleunit_new_report/report/guangzhou/customerTableDownload.action';	   
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
				url:"./saleunit_new_report/report/guangzhou/customerTableAjax.action",
				queryParams:getInputsAsOjbect(["cond.strSearchCompanyIds","cond.strSearchCompanyProjectIds","cond.visitDate1","cond.visitDate2","cond.sort","cond.order","questionId","selCategory"]),
				onLoadSuccess:function (data) {
					if(eval(data).total<=0){
						parent.myAlert("查无数据!"); //DEMO datagrid 没有数据 
					}
 					$("#dg").datagrid('collapseGroup');    //DEMO groupview折叠所有的分组   
                }
			});
		}				
		
		$().ready(function(){	
			var paraObj = requestParaToObject();
			//根据传入的参数来进行查询
			if(typeof(paraObj["cond.strSearchCompanyIds"])!="undefined"){
				$("#companyIds").val(paraObj["cond.strSearchCompanyIds"]);
				
				$("#date1").datebox("setValue",paraObj["cond.date1"]);
				$("#date2").datebox("setValue",paraObj["cond.date2"]);
				queryForm();
			}
			else{			
				queryFormByMonth();
			}
		});	
					
		
		</script>
		
	</head>
<body style="padding:0px;background:white;">
<input type="hidden" id="selectedSelCateGory" />
<input type="hidden" id="selectedQuestionId" />	
	    <table id="dg" style="width:auto;height:612px;"  
	    toolbar="#toolbar" 
            data-options="
                singleSelect:true,
                collapsible:true,
                rownumbers:false,
                fitColumns:false,
                view:groupview,
                groupField:'category',
                groupFormatter:function(value,rows){
                	var sumCount = 0; 
                	for(var i=0;i<rows.length;i++){
                		sumCount= sumCount+parseInt(rows[i].sumCount);
                	}
                    return value + ' - ' + sumCount + ' 人';
                }
            ">
        <thead>
            <tr>
                <th align="right" data-options="field:'date',width:300">类别(日期)</th>
                <th align="right" data-options="field:'sumCount',width:300">客户数量</th>
            </tr>
        </thead>
    </table>
	    <div id="toolbar" style="padding:5px;height:auto">
	    	
     	&nbsp;项目<input type="text" id="projectNames" size="40"/>
			<input type="hidden" id="projectIds" name="cond.strSearchCompanyProjectIds"/>			
			<input type="hidden" id="companyIds" name="cond.strSearchCompanyIds"/>
            <label>&nbsp;<span>项目问卷</span></label><s:select list="questionList" name="questionId" id="questionList"  />	
            <label>&nbsp;<span>分析类型</span>
			</label><select id="selCategoryList" name="selCategory" style="width:100px"></select>
					
			<input type="hidden" name="cond.sort" value="sumCount"/>
			<input type="hidden" name="cond.order" value="desc"/>	
			日期<input class="easyui-datebox" type="text" id="date1" name="cond.visitDate1" style="width:90px" />
			-
			<input class="easyui-datebox" type="text" id="date2" name="cond.visitDate2" style="width:90px" />
			&nbsp;	
			<input type="button" onclick="queryForm();" value=" 查询 "/>	
			<input type="button" onclick="queryFormByWeek();" value=" 查询本周 "/>	
			<input type="button" onclick="queryFormByMonth();" value=" 查询本月 "/>	

            <%if(PermissionUtils.hasPermission(EnumPrivCode.REPORT_PRECUSTOMER_EXCEL, EnumDevFlag.GUANGZHOU) ){%>
				  	  <input type="button" onclick="download()" value=" 导出 " >
            <%} %>
            
            
	    </div> 
	</body>
</html>

