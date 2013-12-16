<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ page import="com.ihk.utils.CacheUtils"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
    <title>楼盘建档</title>
    <base href="<%=basePath%>" />
    <s:include value="../../header/header_easyui.jsp"/>
	 <style type="text/css">
        *{margin:0;padding:0;}
        .tb1 td{padding-left: 2px;width:50px; text-align:center; cursor: pointer}
        .tb1 tr{background: #ffffff}
        .seltd{background-color:#FBEC88}
        .add_some{}
        .td_is_check{background: #FBEC88;}
        .text_title_cl{
            display:inline-block;
            width:16px;
            height:18px;
            vertical-align:middle;}
        .re_some{display:inline-block;
        }
        .spanbu{color:#aa1122;cursor: pointer;border: 1px solid;padding: 10px;}
    </style>
	 <link href="./css/unit_table.css"  rel="stylesheet" type="text/css" charset="utf-8"/><!-- unit的样式 -->
	 
	 <script type="text/javascript" language="javascript">	
	 function delSomeUnit(){//批量删除单元
			 $.messager.confirm('确认框','是否确认删除?',function(r){  
			    if (r){  
			    	var click_unit_ids = getIds();
					$.post('./saleunit_new_init/appoint/guangzhou/delSomeUnit.action',{'uids':click_unit_ids},function(date){
						if(date == 'true'){
							alert('操作成功');
							location = location;
						}else{
							alert('请选择可删除的单元');
						}
					});
			    }  
			});  
			
		}

	 function updateState(){//批量修改状态
			var click_unit_ids = getIds();
			var select_state = $('#saleState').val();
			$.post('./saleunit_new_init/appoint/guangzhou/updateSaleStateBySomeUnitIds.action',{'uids':click_unit_ids,'updateState':select_state},function(date){
				if(date == 'true'){
					alert('操作成功');
					location = location;
				}else{
					alert('请选择可删除的单元');
				}
			});
		}

		function getIds(){
			var ids = '';
			$("#updatemap td").each(function(){
				if($(this).hasClass("td_is_check")){ids+=$(this).attr('unitid') + ',';}
			})
			return ids;
		}
		
	 $().ready(function(){


		$("#updatemap td").bind('click',function(){//绑定选择单元事件
				if($(this).text() == ''){return false}
				if(!($(this).hasClass("td_is_check"))){
					$(this).addClass("td_is_check");
					}else{
						$(this).removeClass("td_is_check");
				}
		});
	 })
	</script>
</head>
<body>
<div style="width: 100%;height: 300px;overflow-y: scroll">
		<table  id="updatemap" border="0" align="center" cellpadding="0" class='tb1' cellspacing="1"  style="margin: 0px;width:auto;float: left;background-color: #A9D9FF">
		<s:if test="null!=#request.trList && !#request.trList.isEmpty()">
		<s:iterator value="#request.trList" id="c">  
		${c}
		</s:iterator>
		</s:if>
		<s:else> 
		未创建单元
		</s:else>
		</table>
</div>	
<div style="width: 95%;border: solid #eeeeee 1px;margin: 1px;height: 30px">
	<div style="float: right;">
	<button onclick="delSomeUnit()">删除所选单元</button>
	</div>
	<font color="red">如果已经销售的单元将不能删除</font>
</div>	
<div style="width: 95%;border: solid #eeeeee 1px;margin: 1px;height: 50px">
	<div style="float: right;">
	<label>销售状态: 
	<s:select list="selSaleState" id="saleState"></s:select>
	</label>
	<button onclick="updateState()">批量修改状态</button>
	</div>
	<font color="red">所选单元必须是可修改状态,参考右边下拉框</font>
	
</div>	
</body>
</html>
   

