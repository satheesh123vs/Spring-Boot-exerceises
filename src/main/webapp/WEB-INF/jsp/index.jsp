<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
	$(document).ready(function() {
		
		$("button").click(function() {
 			$("#div1").toggle();
		});
	});
</script>
</head>
<body>
	<h1>Welcome to Jquery sample Application</h1>
	<button>SHOW/HIDE Details</button>
	<div id="div1">
		<h1>List of Employees</h1>
		<table border="1">
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Email</th>
			</tr>
			<c:forEach items="${empList}" var="e">
				<tr>
					<td>${e.id}</td>
					<td>${e.name}</td>
					<td>${e.email}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>