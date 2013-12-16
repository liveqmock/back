<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>浏览学生</title>
	</head>

	<body>
		<table align="center" border="1" style="width:80%;">
			<tr>
				<th colspan="7" align="center">学生表</th>
			</tr>
			<tr>
				<td align="left" colspan="7"><a href="<%=request.getContextPath()%>/student/newStudent.action">添加学生</a></td>
			</tr>
			<tr>
				<td>姓名</td>
				<td>班级</td>
				<td>操作</td>
			</tr>
			<s:iterator value="studentList">
				<tr>
					<td>
						<s:property value="studentName"/>
					</td>
					<td>
						<s:property value="className"/>
					</td>
					<td>
						<a href="<%=request.getContextPath()%>/student/findStudent.action?id=${id}">修改信息</a>
						<a href="<%=request.getContextPath()%>/student/removeStudent.action?id=${id}">删除</a>
					</td>
				</tr>
			</s:iterator>
			<tr><td colspan="3">分页:
			<s:property value="showPage" escape="false"/>
		</td></tr>
			<s:property value="tips"/>
		</table>
	</body>
</html>
