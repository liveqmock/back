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
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>公告管理</title>
	    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<s:include value="../../header/header_easyui.jsp"></s:include>
		<script type="text/javascript" src="<%=basePath%>js/list.checkbox.js?v=0712"></script>
		<script type="text/javascript">		
		function queryForm(){
			//使用.datagrid的方法设置easyui组件,那么该table的class不要设置为easyui-datagrid，否则会两次加载渲染			
			$("#dg").datagrid({
				url:"./customer_guangzhou/article/searchArticleAjax.action",
				queryParams:getInputsAsOjbect(["cond.title"])
			});
		}		
		$().ready(function(){				
			queryForm();
		});		
		
		//dategrid显示下划线，超链接
		function formatterTitle(value,row,index){
			var textShow;
			if(row.id!=null){
            	textShow = '<a onclick="editArticle(\''+row.id+'\',\''+value+'\')" style="color: #1199FF;cursor: pointer;" class="ablue">'+value+'</a> ';
			}
			else{
				textShow = value;
			}
        	return textShow;
       	}	
       	
       	function addArticle(){
			new MyAjaxIframeDialog({title:'新建公告', formId:'inputform',
				width:650,
				height:570,
				src:'./customer_guangzhou/article/indexInput.action',
				ids:['title'],
				closeFn:queryForm
				});	
       	}
       	function editArticle(articleId){
			new MyAjaxIframeDialog({title:'查看/修改公告', formId:'inputform',
				width:650,
				height:570,
				src:'./customer_guangzhou/article/indexUpdate.action?articleId='+articleId,
				closeFn:queryForm
				});	
       	}
       	function delArticles(){
       		var ids = getDatagridSelectIds('dg','id','_');
			parent.deletePojoBeforeCheck('./customer_guangzhou/article/deleteArticle.action?ids='+ids,
				queryForm,
				'',
				ids);
       	}
	</script>
</head>
<body>
		 <table id="dg" style="width:auto;height:612px;"  
            toolbar="#toolbar" pagination="true" striped="true" nowrap="true"
            rownumbers="true" fitColumns="true" singleSelect="false"
            pageSize='20'            
            >  
	        <thead>  
	            <tr>  
	            	<th checkbox="true"></th>
	                <th field="title" width="50" formatter="formatterTitle">标题</th> 
	                <th field="companyName" width="50">指定公司</th>   
	                <th field="articleType" width="50">文章类型</th> 
	                <th field="summary" width="50">摘要</th>  
	                <th field="userRealName" width="50">创建人</th> 
	                <th field="createdTime" width="50">创建时间</th> 
	            </tr>  
	        </thead>  
	    </table>  
	    <div id="toolbar" style="padding:5px;height:auto">
            <label><span>标题</span></label>
            <input  type="text" id="title"  name="cond.title" />
            <input type="button" value=" 搜索 " id="searchSubmit" onclick="queryForm();"/>
    		<input  type="button" value=" 新建 "  onclick="addArticle()"/>
    		<input  type="button" value=" 删除 "  onclick="delArticles()"/>
	     </div>  



</body>
</html>
