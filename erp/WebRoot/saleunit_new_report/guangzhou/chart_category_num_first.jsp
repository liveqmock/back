<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page contentType="text/html; charset=utf-8"%>
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
		<title>分类环比走势图</title>
		<s:include value="header_report.jsp"></s:include>	
				
		<script type="text/javascript">	
			$().ready(function(){				
				$("#saleMonitorCond_companyId").change(function(){
					companyToProject(this.value, "saleMonitorCond_projectId");
				});				
				
				//projectListForHiddenId("projectName", "hiddenId"); //项目的联想框,及用隐藏域保存其id
				
				bindProjectDialogForSQKHOnlyQuestion("projectName", "hiddenId"); //多个项目的选择
				
				submitSearch();
			});
			
			function submitSearch(){
				if($("#hiddenId").val()==""){
					myAlert("请选择项目");
					return;
				}
				$("#thisForm").submit();	
			}
			
			function submitSearch_CustomerPie(){
				if($("#hiddenId").val()==""){
					myAlert("请选择项目");
					return;
				}
				$(window.parent.document).find("#showTitle").text('单项比例分析图');	
				$("#thisForm").attr("action", "./saleunit_new_report/report/guangzhou/customerPie.action").submit();	
			}
			
			function submitSearch_CustomerTable(){
				if($("#hiddenId").val()==""){
					myAlert("请选择项目");
					return;
				}
				$(window.parent.document).find("#showTitle").text('单项数据分析表');	
				$("#thisForm").attr("action", "./saleunit_new_report/report/guangzhou/customerTable.action").submit();	
			}
				
		</script>	 

		
	</head>
<body style="padding:0px;background:white;">

<%--主体导航页头 --%>
<div class="right99"></div>
 	
<form id="thisForm" method="post" action="./saleunit_new_report/report/guangzhou/categoryNum.action">	
	 <table width="100%" border="0" align="left" cellspacing="0">	  
		  
		  <!-- 搜索表单 top -->
       
		  <tr>
     	<td colspan="6">	
     	&nbsp;项目<input type="text" id="projectName" size="40" name="projectName" value="${customerCond.strSearchProjectNames}"/>
		<input type="hidden" id="hiddenId" name="customerCond.strSearchProjectIds" value="${customerCond.strSearchProjectIds}"/>
		
		<label>&nbsp;<span>项目问卷</span></label><s:select list="questionList" name="questionId" id="questionList"  onchange="bindQuestionCategory();" />
		<label>&nbsp;<span>分析类型</span>
			</label><select id="selCategoryList" name="selCategory" style="width:100px"></select>	
				&nbsp;
				日期<input class="easyui-datebox" type="text" id="date1" style="width:90px" name="customerCond.visitDate1" value="${customerCond.visitDate1}"/>
				-
				<input class="easyui-datebox" type="text" id="date2" style="width:90px" name="customerCond.visitDate2" value="${customerCond.visitDate2}"/>
		&nbsp;<input type="button" onclick="return submitSearch()" value=" 查询  "/>	
		
				
		<a style="color:#1199FF;" href="javascript:submitSearch_CustomerPie();">比例分析</a>&nbsp;				
		<a style="color:#1199FF;" href="javascript:submitSearch_CustomerTable();">分析表</a>&nbsp;
			
<div class="right99"></div>		 
<div class="blueline"></div>	 
		<div class="gbox1">	
		<div id="container" style="width: 100%; height:500px; margin: 0 auto"></div>
		  		
</div>

</td>
	 </tr>		  			
          
 </table>
		</form>


   
</body>
</html>

   
   



