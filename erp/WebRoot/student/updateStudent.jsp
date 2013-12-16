<%@ page language="java"  pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>添加学生</title>
  </head>
  
  <body>
  	<s:property value="tips"/>
    <s:form action="updateStudent">
    	<s:textfield name="student.studentName" label="姓名" value="%{student.studentName}" />
    	<s:textfield name="student.className" label="班级" value="%{student.className}"/>
    	<s:select list="searchEngine"  name="student.schoolId" label="学校" value="%{student.schoolId}"/>
    	<s:select list="selGender" name="selGender" />
    	<s:checkboxlist list="selGender" name="chkGender" value="defaultGender" />
    		<s:checkboxlist name="interests" theme="simple"  list="#{'lanqiu':'篮球', 'zuqiu':'足球', 'pingpangqiu':'乒乓球'}"  />
    			
    	<s:hidden name="student.id" value="%{student.id}"></s:hidden>
    	<s:submit value="修改"/>
    </s:form>
    <a href="<%=request.getContextPath() %>/student/queryStudent.action">查看现有学生</a>
  </body>
</html>