<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page contentType="text/html; charset=utf-8" %>

<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<input type="button" value="清空中间上部11分" id="cl"/>

<ul id="left_tree" url="./customer/guangzhou/tree_data.json" animate="false"></ul>

<ul id="left_tree2" url="./customer_guangzhou/search/tmpTree.action" animate="true"></ul>

