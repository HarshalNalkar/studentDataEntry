<%@page import="com.jspiders.springmvc.pojo.StudentPOJO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<jsp:include page="NavBar.jsp"></jsp:include>
<%
StudentPOJO pojo = (StudentPOJO) request.getAttribute("student");
String msg = (String) request.getAttribute("msg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search Bar</title>
<style type="text/css">
body{
	font-family: "Lato", sans-serif;
}
form {
	margin-top: 10px;
}

form table {
	margin: auto;
	width: 100%;
}
div{
margin-top: 30px;
}

tr {
	text-align: center;
}

fieldset table {
	margin: auto;
	text-align: left;
}

.input{
    padding: 5px;
}

fieldset {
	margin: 15px 420px;
	text-align: center;
    border-radius: 10px;
    font-weight: bold;
}

legend {
	color: white;
	background-color: #333;
	padding: 5px 30px;
    border-radius: 25px;
}

#data {
	background: hsl(204, 15%, 94%);
	border: 1px solid black;
	width: 100%;
	border: 1px solid black;
	padding: 7px;
	margin-top: 30px;
}

#data td {
	border: 1px solid black;
	text-align: center;
	padding: 7px;
}
button{
    padding: 5px 25px;
    margin-top: 15px;
    border-radius: 10px;
    font-weight: bold;
    background: #5bd2f7;
}
button:hover{
    background: #24a7cf;
    cursor: pointer;
    border: 2px solid #24a7cf;
}
</style>

</head>
<body>

	<fieldset>
		<legend>Search Student Details</legend>
		<form action="./search" method="post">
			<table>
				<tr>
					<td>Enter Id</td>
					<td><input type="text" name="id" size="40" class="input"></td>
				</tr>
			</table>
			<button type="submit">SEARCH</button>
		</form>
	</fieldset>

	<%
	if (msg != null) {
	%>
	<h3>
		<%=msg%>
	</h3>
	<%
	}
	%>

	<%
	if (pojo != null) {
	%>
	<table id="data">
		<tr>
			<th>ID</th>
			<th>NAME</th>
			<th>EMAIL</th>
			<th>CONTACT</th>
			<th>ADDRESS</th>
		</tr>
		<tr>
			<td><%= pojo.getId() %></td>
			<td><%= pojo.getName() %></td>
			<td><%= pojo.getEmail() %></td>
			<td><%= pojo.getContact() %></td>
			<td><%= pojo.getAddress() %></td>
		</tr>
	</table>
	<%
	}
	%>
</body>
</html>