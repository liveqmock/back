<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<table>
    <tr>
        <td>
            <form id="receiveFm" method="post" style="margin:0;display: inline;">
                楼栋：
                <s:select id="build_id" list="buildMap" style="width:150px;"></s:select>
                导入日期：
                <input class="easyui-datebox" id="impdate" name="impdate" style="width:90px" value=""/>
                <a class="easyui-linkbutton" onclick="return receiveSearch()">查找</a>
            </form>
            <form id="downloadFm" method="post" style="margin:0;display: inline;">
                <a  class="easyui-linkbutton" onclick="return downloadReceive()">模板导出</a>
            </form>
            <form id="receiveUpload" enctype="multipart/form-data" method="post" style="margin:0;display: inline;">
                <input type="file" name="uploads" value="上传的文件"/>
                <a class="easyui-linkbutton" onclick="return uploadReceive()">模板导入</a>
            </form>
        </td>
    </tr>
    <tr>
        <td>
            <!-- 详细信息列表 -->
            <div region="center" split="false" border="false">
                <table id="tbReceive"></table>
            </div>
        </td>
    </tr>
</table>
<div id="editReceiveIn" class="easyui-window" title="应收编辑" style="width: 300px;height:280px;"
     closed="true" maximizable="false" minimizable="false" collapsible="false">
    <iframe scrolling="no" id='openreceiveIn' frameborder="0"  src="" style="width:100%;height:100%;"></iframe>
</div>