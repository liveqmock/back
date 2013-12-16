<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

	<div class="easyui-layout" style="width:100%;height:201px;">
		<form id="baseDownloadFm" method="post" >
			<div region="north" style="overflow:hidden;height:62px;padding:5px;">
				<div region="north" style="overflow:hidden;height:62px;padding:5px;">
					  <div style="font-weight:bold;" >第一步：选择楼栋</div><br/>
					  <s:select name="buildId" list="buildMap"></s:select> 
				</div>
			</div>
			<div region="center" style="overflow:hidden;height:62px;padding:5px;">
					<div style="font-weight:bold;" >第二步：下载模板 并输入相关内容</div><br/>
					<a href="javascript:void(0);" class="easyui-linkbutton" onclick="return downloadBase()" iconCls="icon-redo">模板下载</a><br />
			</div>
		</form>
		<form id="uploadFm" enctype="multipart/form-data" method="post">
			<div region="south" style="overflow:hidden;height:62px;padding:5px;">
					<div style="font-weight:bold;" >第三步：上传录入好的模板(<font color="red">每次上传都覆盖原有底价，但不覆盖已售单元底价</font>)</div><br/>
					<input type="file" name="upload" value="选择文件"/>
					<a href="javascript:void(0);" class="easyui-linkbutton" onclick="return uploadBase()" iconCls="icon-redo">上传</a><br />
			</div>
		</form>
	</div>
	<div region="center" style="overflow:hidden;">
			<div region="center" style="background:#fafafa;overflow:hidden;padding:5px;">
			<div style="font-weight:bold;" >第四部：上传成功后，请到"明细"中查询底价</div>
				<table id="test"></table>
			</div>
	</div>

