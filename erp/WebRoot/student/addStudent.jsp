<%@ page language="java"  pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>添加学生</title>
  </head>
  
  <body>
  	<s:property value="tips"/>
    <s:form action="addStudent"  >
    	<s:textfield name="student.studentName" label="姓名"/>
    	<s:textfield name="student.className" label="班级"/>
    		<s:select list="searchEngine"  name="student.schoolId" label="学校"  ></s:select>
    	<s:submit value="添加"/>
    </s:form>
    <a href="<%=request.getContextPath() %>/student/queryStudent.action">查看现有学生</a>
  </body>
</html>
