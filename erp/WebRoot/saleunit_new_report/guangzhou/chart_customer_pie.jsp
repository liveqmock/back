<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page import="com.ihk.permission.PermissionUtils" %>
<%@ page import="com.ihk.constanttype.EnumPrivCode" %>
<%@ page import="com.ihk.constanttype.EnumDevFlag" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html >
	<head>
		<title>客户分类比例图</title>
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
			location.href = './saleunit_new_report/report/guangzhou/customerPieDownload.action';	   
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
				url:"./saleunit_new_report/report/guangzhou/customerPieAjax.action",
				queryParams:getInputsAsOjbect(["cond.strSearchCompanyIds","cond.strSearchCompanyProjectIds","cond.date1","cond.date2","cond.sort","cond.order","questionId","selCategory"]),
				onLoadSuccess:function (data) {
					if(eval(data).total<=0){
						parent.myAlert("查无数据!"); //DEMO datagrid 没有数据 
					}
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
					
		//显示比例
		function showPie(){
			var rows_length = $('#dg').datagrid('getRows').length;  

			if(rows_length>0){
				new MyAjaxIframeDialog({title:"比例图:客户分类比例(项目)", 
					width:650,
					height:550,
					src:'./saleunit_new_report/report/guangzhou/commonPie.action?flag=CUSTOMER_PIE',
					buttons:false
					});
			}
			else{
				parent.myAlert("列表没有数据,不能显示饼图,请先查询出数据");
			}	
		}
		
		</script>
		
	</head>
<body style="padding:0px;background:white;">
<input type="hidden" id="selectedSelCateGory" />
<input type="hidden" id="selectedQuestionId" />	

		 <table id="dg" style="width:auto;height:612px;"  
            toolbar="#toolbar" pagination="false" striped="true" nowrap="true"
            rownumbers="true" fitColumns="true" singleSelect="true"   
            >  
	        <thead>  
	            <tr>  
	                <th field="category" width="50" sortable="true" align="center" >类别</th>  
	                <th field="sumCount" width="50" sortable="true" align="right">客户数量</th>
	                <th field="pieCount" width="50" sortable="true" align="right">比例</th>  
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
			日期<input class="easyui-datebox" type="text" id="date1" name="cond.date1" style="width:90px" />
			-
			<input class="easyui-datebox" type="text" id="date2" name="cond.date2" style="width:90px" />
			&nbsp;	
			<input type="button" onclick="queryForm();" value=" 查询 "/>	
			<input type="button" onclick="queryFormByWeek();" value=" 查询本周 "/>	
			<input type="button" onclick="queryFormByMonth();" value=" 查询本月 "/>	

            <%if(PermissionUtils.hasPermission(EnumPrivCode.REPORT_PRECUSTOMER_EXCEL, EnumDevFlag.GUANGZHOU) ){%>
				  	  <input type="button" onclick="download()" value=" 导出 " >
            <%} %>
            
			<input type="button" value=" 查看比例 "  onclick="showPie()"/>	
            
	    </div> 
	</body>
</html>



   
   



