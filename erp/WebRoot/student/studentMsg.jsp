<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>修改学生信息</title>
	</head>

	<body>
		<s:form action="/student/updateStudent.action">
			<s:hidden name="student.id">${id}</s:hidden>
			<s:textfield name="student.studentName" label="姓名" readonly="true">${studentName}</s:textfield>
			<s:textfield name="student.className" label="班级">${className}</s:textfield>
			<s:submit/>
		</s:form>
		<s:property value="tips" />
	</body>
</html>
