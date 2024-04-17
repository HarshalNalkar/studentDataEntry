<%@page import="org.hibernate.tuple.component.PojoComponentTuplizer"%>
<%@page import="com.jspiders.springmvc.pojo.StudentPOJO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%
List<StudentPOJO> students = (List<StudentPOJO>) request.getAttribute("students");
String msg = (String) request.getAttribute("msg");
%>

<jsp:include page="NavBar.jsp" />
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
body{
	font-family: "Lato", sans-serif;
}
div{
margin-top: 30px;
}
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

.input{
    padding: 5px;
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

fieldset table {
	margin: auto;
	text-align: left;
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
	<div>
		<fieldset>
			<legend>Add Student Details</legend>
			<form action="./add" method="post">
				<table>
					<tr>
						<td>Name</td>
						<td><input type="text" name="name" size="40" class="input" autofocus="autofocus"></td>
					</tr>

					<tr>
						<td>Email</td>
						<td><input type="text" name="email" size="40" class="input"></td>
					</tr>
					<tr>
						<td>Contact</td>
						<td><input type="text" name="contact" size="40" class="input"></td>
					</tr>
					<tr>
						<td>Address</td>
						<td><input type="text" name="address" size="40" class="input"></td>
					</tr>

				</table>
				<button type="submit">ADD</button>
			</form>
		</fieldset>

		<%
		if (msg != null) {
		%>
		<h2><%=msg%></h2>
		<%
		}
		%>
		<%
		if (students != null) {
		%>
		<table id="data">
			<tr>
				<th>ID</th>
				<th>NAME</th>
				<th>EMAIL</th>
				<th>CONTACT</th>
				<th>ADDRESS</th>
			</tr>
			<%
			for (StudentPOJO pojo : students) {
			%>
			<tr>
				<td><%=pojo.getId()%></td>
				<td><%=pojo.getName()%></td>
				<td><%=pojo.getEmail()%></td>
				<td><%=pojo.getContact()%></td>
				<td><%=pojo.getAddress()%></td>
			</tr>
			<%
			}
			%>
		</table>
		<%
		}
		%>
	</div>
</body>
</html>