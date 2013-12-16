<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page contentType="text/html; charset=utf-8" %>

<%@ taglib prefix="s" uri="/struts-tags" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html>
<head>

    <title>项目折扣</title>

    <base href="<%=basePath%>">

    <s:include value="../../customer/guangzhou/header.jsp"/>

    <link href="./css/easyui.css" rel="stylesheet" type="text/css" charset="utf-8"/>
    <link href="./css/icon.css" rel="stylesheet" type="text/css" charset="utf-8"/>

    <script type="text/javascript" language="javascript" src="<%=basePath%>js/jquery.easyui.min.js"></script>

    <script type="text/javascript" language="javascript" src="./js/easyui.utils.js"></script>

    <script type="text/javascript" language="javascript">
	
        $().ready(function(){
		
            $("#left_tree").tree({
                animate:false,
                url:'./project_discount/manager/left.action',
                onClick:function(node){
					
					$("#project_manager_name").html(node.text);
					toProjectDiscountManager(node.attributes.id);
                }
            });
        });
		
		function toProjectDiscountManager(projectId){
			$.ajax({
				type:"get",
				url: "./project_discount/manager/toProjectDiscountManager.action",
				data: "projectId=" + projectId,
				dataType: "html",
				success: function(data){
				
					$("#project_manager_main").html(data);
				}
			});			
		}
		
		function formSubmit(){
			
			$('#detail_table').datagrid('endEdit', editIndex);
		
			var allLine = $('#detail_table').datagrid('getRows');
			
			var formStr = "";
			
			var length = allLine.length;
			for(var index=0; index<length; index++){
				
				var typeId = $.trim(allLine[index].typeId);
				var percent = $.trim(allLine[index].percent);
				var remark = $.trim(allLine[index].remark);
				
				formStr += "typeId" + (parseInt(index)+1) + "=" + typeId + "_" 
						+ "percent" + (parseInt(index)+1) + "=" + percent + "_" 
						+ "remark" + (parseInt(index)+1) + "=" + remark + "_";
			}
			
			formStr += "detailCount=" + length;
			
			var node = $("#left_tree").tree("getSelected");
			if(node == null){
				myAlert("请先选择项目");
				return false;
			}
			
			var projectId = node.attributes.id;
			
			$.ajax({
				type:"post",
				url: "./project_discount/manager/discountModify.action",
				data: "someDetail=" + formStr + "&projectId=" + projectId,
				dataType: "html",
				success: function(data){
					//返回true表示保存成功
					if(data == "true"){
						myAlert("操作成功");
						toProjectDiscountManager(projectId);						
					}else{
						myAlert("操作失败,请重试");
					}				
				}
			});
			
			return false;						
		}
    </script>

    <style type="text/css">
        *{margin:0;padding:0;}
        
    </style>

</head>

<body class="easyui-layout">

	<div region="west" split="true" title="楼盘项目" style="width:213px;padding:1px;">
	
		 <ul id="left_tree" url="#" animate="false"></ul>
	
	</div>
	
	<div region="center" style="top:26px" title="<span id='project_manager_name'>&nbsp;</span>" id="project_manager_main">
	</div>
	
	<div region="south" border="false" style="background:#A9FACD;padding:0px;">
		<div style="width: 100%;height: 0px;background: #eeeeee" ></div>
	</div>
	
	<%-- 统一dialog,myDialog表示没有iframe,myIframeDialog表示使用iframe,且iframe的名称统一为openIframe,(如果弹出的iframe中又包含弹出框,就不用变) --%>
	<div id="myDialog" class="easyui-dialog" closed="true" modal="true" title="标题" style="display:block;width:800px;height:500px; overflow-x:hidden">
	</div>
	
	<div id="myIframeDialog" class="easyui-dialog" closed="true" modal="true" title="标题" style="display:block;width:800px;height:500px; overflow-x:hidden">
		<iframe scrolling="auto" id='openIframe' frameborder="0"  src="./saleunit_new/guangzhou/loading.jsp" style="width:100%;height:100%;"></iframe>
	</div>

</body>


</html>
