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
form {
	margin-top: 10px;
}

form table {
	margin: auto;
	width: 100%;
}

tr {
	text-align: center;
}

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

#data {
	background-color: white;
	border: 1px solid black;
	width: 100%;
	border: 1px solid black;
}

#data td {
	border: 1px solid black;
	text-align: center;
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
					<td><input type="text" name="id"></td>
				</tr>
			</table>
			<input type="submit" value="SEARCH">
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