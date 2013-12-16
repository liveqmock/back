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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title></title>
<base href="<%=basePath%>"/>
	<link rel="stylesheet" type="text/css" href="./css/easyui.css" />
	<link rel="stylesheet" type="text/css" href="./css/icon.css" />
	<link rel="stylesheet" type="text/css" href="./css/easydemo.css" />
	<style>
		.btn1_mouseover {
			BORDER-RIGHT: #2C59AA 1px solid; PADDING-RIGHT: 2px; BORDER-TOP: #2C59AA 1px solid; PADDING-LEFT: 2px; FONT-SIZE: 12px;
		    FILTER: progid:DXImageTransform.Microsoft.Gradient(GradientType=0, StartColorStr=#ffffff, EndColorStr=#C3DAF5); BORDER-LEFT: #2C59AA 1px solid;
		    CURSOR: hand; COLOR: black; PADDING-TOP: 2px; BORDER-BOTTOM: #2C59AA 1px solid
		}
	</style>
	<script type="text/javascript" src="./js/jquery-1.6.2.min.js"></script>
	<script type="text/javascript" src="./js/jquery.easyui.min.js"></script>
	<script>
		$(function(){
            $('#tbfollow').datagrid({  
                width: 376,
                height: 'auto',
                nowrap: true,//是否只显示一行，即文本过多是否省略部分。  
                striped: true,  
                sortName: 'parentID',  
                sortOrder: 'desc', 
                idField:'nodeID', 
                loadMsg:'数据加载中...', 
                url: './customer/collection/IniFollowList.action',
                frozenColumns:[[  
                ]],  
                columns:[[
                	{field:'followStr',title:'跟进类型',width:60},
                	{field:'user',title:'跟进人',width:60},
                	{field:'followDate',title:'跟进日期',width:70},
                	{field:'content',title:'跟进内容',width:140}
                ]],  
                pagination:false, //包含分页  
                rownumbers:true,  
                singleSelect:true
            });
            	displayMsg(); 
            });
            
            function save(){
            
            	var followType = document.getElementById("slfollow");
	            var type = followType.options[followType.selectedIndex].value;
	            if(type == null||type ==''){
	            	$.messager.defaults = { ok: '确定'};	
	            	$.messager.alert('提示', '跟进类型不为空', 'info'); 
	            	return;
	            }
	            var followDesc = document.getElementById("followDesc").value;
	            if(followDesc == null||followDesc  ==''){
	            	$.messager.defaults = { ok: '确定'};	
	            	$.messager.alert('提示', '内容不为空', 'info'); 
	            	return;
	            } 
	            var tempStr = $("#followDate").datebox("getValue");
	            if(tempStr == null||tempStr == ''){
	            	$.messager.defaults = { ok: '确定'};	
	            	$.messager.alert('提示', '日期不为空', 'info'); 
	            	return;
	            }
	            
            	$('#followForm').form({
					url:'./customer/collection/addFollowCust.action?dt='+tempStr,    
					success:function(data){
						$('#tbfollow').datagrid({
		           			 url:'./customer/collection/IniFollowList.action'
		        		});
					}
				});
				$('#followForm').submit(); 
				
            }
            
	</script>
</head>

<body>
	<div style="overflow:hidden;">
        <form id="followForm" action="" method="post">
            <table>
                <tr>
                    <td>跟进类型</td>
                    <td><s:select id="slfollow" list="followType" name="vipfollow.followType"></s:select></td>
                </tr>
                <tr>
                    <td>跟进内容</td>
                    <td>
                    	<textarea name="vipfollow.content" class='easyui-validatebox' id='followDesc' rows='3' cols='30'></textarea>
                    </td>
                </tr>
                <tr>
                	<td>跟进日期</td>
                    <td><input id="followDate" class="easyui-datebox" ></td>
                </tr>
                <tr>
                	<td></td>
                	<td><a href="javascript:void(0);" class="easyui-linkbutton" onclick="save()" iconCls="icon-redo">保存</a>
                	</td>
                </tr>
            </table>
            </form>
     </div>
     <div class="easyui-layout" style="width:98%;height:160px;">
     	<div region="center" style="overflow-x:hidden;">
            <table id="tbfollow"></table>
        </div>
     </div>
        
</body>
</html>