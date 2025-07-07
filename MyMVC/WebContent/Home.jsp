<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" session="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Home Page</title>
</head>
<body>
<H1>Welcome <%=session.getAttribute("nm") %></H1><br><br><br>
<a href="FetchDetailsServlet">Click here to view your Details</a>
</body>
</html>