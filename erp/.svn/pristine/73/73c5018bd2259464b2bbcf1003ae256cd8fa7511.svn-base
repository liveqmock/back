<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
	isELIgnored="false"%>
<%@ page contentType="text/html; charset=utf-8"%>

<%@ taglib prefix="s" uri="/struts-tags"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html>
  <head>
	
	<title>批量修改用户所属项目</title>
	
	<base href="<%=basePath%>" />		
		
	<s:include value="../../customer/guangzhou/header.jsp"/>
	
	<link href="./css/easyui.css" rel="stylesheet" type="text/css" charset="utf-8"/>

	<script type="text/javascript" language="javascript" src="<%=basePath%>js/jquery.easyui.min.js"></script>
	<script type="text/javascript" language="javascript" src="<%=basePath%>js/easyui-lang-zh_CN.js"></script>	
	
	<script type="text/javascript" language="javascript" src="./js/easyui.utils.js"></script>
    
    <script type="text/javascript" language="javascript" src="./js/jquery.form.js"></script>

	<script type="text/javascript" language="javascript">
	
		$().ready(function() {
		
			//文件上传
	        $("#batchFileSubmitBt").click(function(){
			
				var fileVal = $("#batchFile").val();
				if(fileVal == ""){
					myAlert("请先选择要上传的文件");					
					return ;
				}
				
				var companyId = $("#companyId").val();
				if(companyId == ""){
					myAlert("请先选择所属公司");
					return ;
				}
				
				$("#batchFileSubmitBt").attr("disabled", "disabled");
				
				$("#uploadFormId").ajaxSubmit({
					//datatype:"json",
					success:function(data){//文件上传成功后执行,msg为服务器端返回的信息
					
						var json = $.parseJSON(data); //解析返回的值为json
						if(json.type == "true"){
							
							ajaxSubmitSearch();
							myAlert("上传成功");
						}else{
							
							myAlert("上传失败,请重试");
						}
						
						$("#batchFileSubmitBt").removeAttr("disabled");
					}					
				});	
				
			});
			
			//下载异常数据
			$("#exceptionBt").click(function(){
				
				$.ajax({
					type: "get",
					url: "./user/manager/ajaxExceptionData.action",
					dataType: "json",
					success: function(data){
						
						if(data.type == "true"){
							
							location.href = "./user/manager/downloadExceptionData.action";
						}else{
							
							myAlert("没有异常数据");
						}
					}
				});
				
			});
			
			//下载模板
			$("#templateBt").click(function(){
				
				location.href = "./user/manager/downloadTemplate.action";				
			});
			
		});
	
		$(function(){		
			
			$("#userAccount_table").datagrid({
				loadMsg:'加载中...',
				pagination:false,  //是否分页
				rownumbers:false,
				singleSelect:true,
				striped:true,
				nowrap:true,
				fitColumns:true,
				fit:false,
				pageSize:20,
				width:$(document).width(),
				height:$(document).height(),
				toolbar:'#table_tb',
				title:'上传文件及显示异常数据'
			});
			
		});
		
		function ajaxSubmitSearch(){
			
			$("#userAccount_table").datagrid({
				url:'./user/manager/ajaxExceptionDataGrid.action',
				onLoadError:function(){
					myAlert("请求异常,请刷新重试");
				}
			});
			
			return false;
		}

	</script>

	
  </head>
  
<body style="padding:0px;background:white;">
        
        <table id="userAccount_table">  
				
			<thead>
				<tr>
                
	            	<th field="projectName" width="100px" align="center">新的项目名(必填)</th> 
					<th field="projectId" width="100px" align="center">新的项目id</th>
                    
	                <th field="jobNumber" width="100px" align="center">工号</th>				                    
	                <th field="realName" width="100px" align="center">姓名(必填)</th>
                                        
                    <th field="exceptionData" width="150px" align="center">异常信息</th>
					
				</tr>
										
			</thead>
		</table>	
       
        
		<div id="table_tb" style="height: auto;padding: 5px">   
        	
            <form class="registerform" id="uploadFormId" method="post" action="./user/manager/batchModifyProject.action" enctype="multipart/form-data">
            
	            <input type="button" value="  下载模板  " id="templateBt" />
			
			    <input type="file" id="batchFile" name="batchFile" />		
                
                <label>
                <input type="checkbox" value="1" checked="checked" name="ignoreFirstRow"/>是否忽略上传文件首行
                </label>
                
                <select id="companyId" name="companyId">
                	${companyOption}
                </select>
                                	
				<input type="button" value="  提交  " id="batchFileSubmitBt" />
                
                <input type="button" value="  下载异常数据  " id="exceptionBt" />
                
            </form>
            
        </div> 		
	    
	</body>
</html>