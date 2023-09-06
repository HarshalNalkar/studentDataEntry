<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
fieldset table {
	margin: auto;
	text-align: left;
}

fieldset {
	margin: 15px 520px;
	text-align: center;
}

legend {
	color: white;
	background-color: #333;
}

body {
	background-image:
		url('https://www.xmple.com/wallpaper/linear-blue-white-highlight-gradient-1920x1080-c2-ffffff-e0ffff-l-50-a-165-f-21.svg');
	background-size: 100%;
}
</style>
</head>
<body>
	<div align="center">
		<fieldset>
			<legend>Login Page</legend>
			<form action="./home">
				<table>
					<tr>
						<td>Username</td>
						<td><input type="text" value="username"> </td>
					</tr>
					<tr>
						<td>Password</td>
						<td><input type="password" value="password"> </td>
					</tr>
				</table>
				<input type="submit" value="LOGIN">
			</form>
		</fieldset>
	</div>
</body>
</html>