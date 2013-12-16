<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>查询组团明细</title>
<base href="<%=basePath%>" />	
<s:include value="../../header/header_easyui.jsp"></s:include>
<script type="text/javascript">
	$(document).ready(function(){	
		//做一些初始化，或者是提交之后显示提示的事情
		
	})

    //页面提交
	function submitSearch() {	
		$("#queryForm").submit();	
	}	
</script>
</head>
<body style="padding:0px;">
	<div class="right99"></div>	
			
		<table width="100%" border="0" align="left" cellspacing="0" id="queryTable">
			<tr>
				<td colspan="6">
		        <form class="queryForm" id="queryForm" method="post" action="./saleunit_new/unit/group/searchPropertyGroupDetail.action">
					<font >当前组团:${thisGroup.groupName}</font>&nbsp;&nbsp; <span>单元</span><input type="text" style="width:90px"   name="searchPropertyGroupDetailCond.unitId" value="${searchPropertyGroupDetailCond.unitId}" /> 
					&nbsp;<input type="button" onclick="return submitSearch()" value=" 查询 " />
					<input type="button" id='_dialog_add_unit_group_div'  value=" 添加房间 " />
					<input type="button" onclick="location='./saleunit_new/unit/group/searchPropertyGroup.action'" value=" 返回 " />
					<input type="button" onclick="location='./saleunit_new/unit/group/searchPropertyGroupDetailMap.action?groupId=${groupId}'" value=" 图形 " />
					<input type="hidden" name='groupId' value="${groupId}"/>
					<div class="right99"></div>
					<div class="blueline"></div>					
			    </form>
				</td>
			</tr>
			<tr>
				<td colspan="6">
					<div class="gbox1">
						<table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" class="gbox" 
							style="text-align: center;font-size:12px; line-height:26px; white-space:normal">						
							<tr class="gboxbg">
                                    <!--<th>项目id</th>-->
                                    <th>单元号</th>
                                    <th>所属楼栋</th>
                                    <th>创建人</th>
                                    <th>创建时间</th>
							</tr>							
   						<s:iterator value="searchListPropertyGroupDetail" id="c">   						
						  <tr onMouseOver="this.style.backgroundColor='#f1f9fe';" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF"> 
						  <!-- <td><a href="javascript:;" style="color:#5482de;" onclick="return openDivEditPropertyGroup('<s:property value="id"/>');"><s:property value="projectId"/></a></td> --> 
                            <td> <s:property value="unitId"/>  </td>
                            <td><s:property value="buildId"/></td>
                            <td><s:property value="createdId"/></td>
                            <td><s:property value="createdTime"/></td>
						   </tr>
   						</s:iterator>  
						</table>
					</div></td>
			</tr>			
			 <tr>
              <td colspan="6">
                <div class="manu">
					<s:property value="showPage" escape="false"/>
				</div>                
				</td>
            </tr>			
		</table>	
		 <div id="new_dialog" class="easyui-dialog" closed="true" modal="true" title="标题" style="display:block;width:500px;height:250px; overflow-x:hidden"> 			
    	<iframe name="new_dialog_ifram" scrolling="auto" id='new_dialog_ifram' frameborder="0"  src="./saleunit_new/guangzhou/loading.jsp" style="width:100%;height:100%;"></iframe> 
	</div> 
	<div id="new_dialog_div" class="easyui-dialog" closed="true" modal="true" title="标题" style="display:block;width:500px;height:250px; overflow-y: scroll; "> 			
	</div> 
    <!--弹出新建的div-->
	<s:include value="div_create_propertygroup_detail.jsp"/>
    
   
</body>
</html>


