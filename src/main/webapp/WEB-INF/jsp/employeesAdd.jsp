<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url var="saveUrl" value="/save" />

<h1>Register Employee</h1>

<form:form method="post" action="${saveUrl}" modelAttribute="emp">
	<table>
		<tr>
			<td><form:label path="empName">Employee Name</form:label></td>
			<td><form:input path="empName" /></td>
		</tr>
		<tr>
			<td><form:label path="department">Department Name</form:label></td>
			<td>
				<select id="department" name="department" >
					<c:forEach var="dep" items="${deps}">
							<option value="${dep.deptId}">${dep.deptName}</option>
					</c:forEach>
				</select>
			</td>
		</tr>
		<tr>
			<td><form:label path="salary">salary</form:label></td>
			<td><form:input path="salary" /></td>
		</tr>
		<tr>
			<td><form:label path="dob">Date Of Birth</form:label></td>
			<td><form:input path="dob" /></td>
		</tr>
		<tr>
			<td colspan="2">
			<td><input type="submit" value="Register" /></td>
		</tr>
	</table>
</form:form>