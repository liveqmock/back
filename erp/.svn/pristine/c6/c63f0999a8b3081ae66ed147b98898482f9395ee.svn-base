<%@ page language="java"  pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>添加图书</title>
  </head>
  
  <body>
  	<s:property value="tips"/>
    <s:form action="updateSBook">
    	<s:textfield name="sbook.title" label="书名" value="%{sbook.title}" />
    	<s:textfield name="sbook.author" label="作者" value="%{sbook.author}"/>
    	<s:textfield name="sbook.price" label="价格" value="%{sbook.price}"/>
    	<s:textfield name="sbook.total" label="数量" value="%{sbook.total}"/>
    	<s:textfield name="sbook.isbn" label="ISBN号" value="%{sbook.isbn}"/>
    	<s:textfield name="sbook.publisher" label="出版社" value="%{sbook.publisher}"/>
    	<s:hidden name="sbook.id" value="%{sbook.id}"></s:hidden>
    	<s:submit value="修改"/>
    </s:form>
    <a href="<%=request.getContextPath() %>/viewSBook.action">查看现有图书</a>
  </body>
</html>