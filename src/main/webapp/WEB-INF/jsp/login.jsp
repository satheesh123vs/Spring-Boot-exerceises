<!-- Two jsp files are configured in this application, home.jsp and -->
<!-- login.jsp. The login page contains the login username and password -->
<!-- textbox and login button. On click of the login button, the jsp page -->
<!-- sends request to the controller and process it. After successful login, -->
<!-- the page is redirected too home.jsp. The home.jsp contains the login -->
<!-- success message. -->
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Spring Boot Form Handling Example</title>
</head>
<body>
	<h1>Welcome to Spring Boot Security</h1>

	<h2>Login Page</h2>

	<form method="POST" action="/login">
		User Name : <input type="text" name="username" value=" " /><br>
		<br> Password : <input type="password" name="password" value=" " /><br>
		<br> <input type="submit" name="submit" />
	</form>
</body>
</html>