<%@page import="edu.scet.StudInfoBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Show Stud Information</title>
</head>
<body>

	<table align="center" border="1">
		<thead>
			<tr>
				<td>Stud Id</td>
				<td>Stud Name</td>
				<td>Stud Surname</td>
				<td>Stud Mobile</td>
				<td>Stud Email</td>
				<td>Stud Age</td>
			</tr>
		</thead>
		
		<%
			List<StudInfoBean> studInfo = (List<StudInfoBean>) request.getAttribute("studInfoList");
			for(StudInfoBean stud: studInfo) {
		%>
		<tr>
			<td><%=stud.getStudId()%></td>
			<td><%=stud.getStudName() %></td>
			<td><%=stud.getStudSurname() %></td>
			<td><%=stud.getStudMobile() %></td>
			<td><%=stud.getStudEmail() %></td>
			<td><%=stud.getStudAge() %></td>
		</tr>
		
		<%} %>
	</table>

</body>
</html>