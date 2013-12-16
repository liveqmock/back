<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
	isELIgnored="false"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="my" uri="/WEB-INF/my.tld" %> 

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>增删改查demo</title>

<s:include value="../../header/header_easyui.jsp"></s:include>
<s:include value="coder_header.jsp"></s:include>

<script type="text/javascript" language="javascript" src="./js/easyui.utils.js"></script>

<script type="text/javascript" language="javascript">
	
	function submitSearch() {
		$("#thisForm").submit();	
	}
	
	function createDiv(){
	
		//openNormalDialog("./demo/easyui/forInput.action", "saveDemoFormId", "新建demo", "400", "300", "true");
		var ids = ["columnInt:number", "columnCode"];
		openNormalIframeDialog("./demo/easyui/forInput.action", "saveDemoFormId", ids, "新建demo", "800", "500");
	}
	
	function updateDiv(demoId){
		
		var ids = ["columnInt:number", "columnCode"];
		openNormalIframeDialog("./demo/easyui/getById.action?id=" + demoId, "updateDemoFormId", ids, "修改demo", 400, 300);
	}
	
	function deleteDiv(demoId){
	
		$.messager.defaults = { ok: "确定", cancel: "取消" };
		$.messager.confirm('Confirm',"确定删除?" ,function(ret){
			if(ret){
				
				//deleteAjax(demoId);
				location.href = "./demo/easyui/deleteData.action?id=" + demoId;
			}
		});
	
	}
	
	function deleteAjax(demoId){
	
		$.ajax({
			type:"get",
			url: "./demo/easyui/deleteData.action",
			data: "id=" + demoId,
			dataType: "json",
			success: function(data){
				
				if(data.type){
				
					submitSearch();
				}else{
				
					$.messager.alert('保存失败,请重试');
				}
			}
			
		});
	}
	
</script>

</head>

<body style="padding:0px;background:white;">

	<div class="right99"></div>

		<table width="100%" border="0" align="left" cellspacing="0">

			<form class="queryform" id="thisForm" method="post">
			<tr>
				<td colspan="6">
					<span>columnInt</span><input type="text" style="width:90px" name="chipCond.chipNo" value="${chipCond.chipNo}" /> 
					<span>columnCode</span><input type="text" style="width:90px" name="chipCond.customerName" value="${chipCond.customerName}" />
					<span>columnVarchar</span><input type="text" style="width:90px" name="chipCond.customerPhone" value="${chipCond.customerPhone}" />

					<span>columnDate</span><input class="easyui-datebox" type="text" style="width:90px" name="chipCond.date1" value="${chipCond.date1}" />
					&nbsp;<input type="button" onclick="return submitSearch()" value=" 查询 " />
					<input type="button" onclick="return createDiv()" value=" 新建 " />
					<div class="right99"></div>
					<div class="blueline"></div>
				</td>
			</tr>
			
			</form>

			<!-- 搜索表单 end -->


			<tr>
				<td colspan="6">

					<div class="gbox1">
						<table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" class="gbox" 
							style="text-align: center;font-size:12px; line-height:26px; white-space:normal">
						
							<tr class="gboxbg">
								<th>columnInt(number)</th>
								<th>columnCode</th>
								<th>columnVarchar(mail)</th>
								<th >columnVarchar2(phone)</th>
								<th >columnVarchar3</th>
								<th >columnText</th>
								<th >columnDate</th>
								<th >columnPrice(money)</th>
								<th colspan="2">操作</th>
							</tr>							
   						<s:iterator value="demoTableList" id="c">   						
						  <tr onMouseOver="this.style.backgroundColor='#f1f9fe';" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF"> 
						   <td>${c.columnInt}</td>
						   <td>${c.columnCode}</td>
						   <td>${c.columnVarchar}</td>
						   <td>${c.columnVarchar2}</td>
						   <td>${c.columnVarchar3}</td>
						   <td>${c.columnText}</td>
						   <td><s:date name="#request.c.columnDate" format="yyyy-MM-dd "/></td>
						   <td><my:format value="${c.columnPrice}"/></td>
						   <td><a href="javascript:void(0)" style="color:#1199FF; text-decoration:underline;" onclick="updateDiv(${c.id})">修改</a></td>
						   <td><a href="javascript:void(0)" style="color:#1199FF; text-decoration:underline;" onclick="deleteDiv(${c.id})">删除</a></td>
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
	
	
	<div id="myIframeDialog" class="easyui-dialog" closed="true" modal="true" title="标题" style="display:block;width:800px; overflow-x:hidden">
		<iframe scrolling="auto" id='openIframe' frameborder="0"  src="./saleunit_new/guangzhou/loading.jsp" style="width:100%;height:400px;"></iframe>
	</div> 	
	
</body>
</html>

