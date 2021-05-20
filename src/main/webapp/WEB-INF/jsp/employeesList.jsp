<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>List of Employees</h1>
	<table border = "1">
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Department</th>
			<th>Date of Birth</th>
			<th>Actions</th>
		</tr>
		<c:forEach items="${empList}" var="e">
			<tr>
				<td>${e.empId}</td>
				<td>${e.empName}</td>
				<td>${e.department.deptName}</td>
				<td>${e.dob}</td>
				<td>
					<a href = "${pageContext.request.contextPath}/employee/${e.empId}">Edit</a>
					|
					<a href = "${pageContext.request.contextPath}/delete/${e.empId}">Delete</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	<button onclick="window.location.href='${pageContext.request.contextPath}/openEmployeeView'">Add Employee</button>
</body>
</html>