<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Students Details Page</title>
</head>
<body>
<H1>Student Details</H1>
<jsp:useBean id="sb" class="edu.scet.model.StudentBean" scope="request"></jsp:useBean>
<table>
	<tr>
		<td>Student name: <jsp:getProperty property="nm" name="sb"/>
	</tr>
	<tr>
		<td>Student Address: <jsp:getProperty property="addr" name="sb"/>
	</tr>
	<tr>
		<td>Student Contact: <jsp:getProperty property="contact" name="sb"/>
	</tr>
	<tr>
		<td>Student Email ID: <jsp:getProperty property="emailId" name="sb"/>
	</tr>
</table>
</body>
</html>