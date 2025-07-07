<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<center>
	<form action="InsertName" method="POST">
		<label> Enter name : </label>
		<input type = "text" name="txtname" placeholder="Enter your name">
		
		<input type="submit" value="Insert Data"> <br><br>
	</form>
	
	<form action="UpdateName" method="POST">
		<label> Enter name : </label>
		<input type = "text" name="txtname" placeholder="Enter your name">
		
		<label>Enter Id for update data : </label>
		<input type="text" name="txtid" placeholder="Enter Id Number">
		
		<input type="submit" value="Update Data"> <br><br>
	</form>
	
	<form action="DeleteName" method="POST">
		
		
		<label>Enter Id for Delete data : </label>
		<input type="text" name="txtid" placeholder="Enter Id Number">
		
		<input type="submit" value="delete Data"> <br><br>
	</form>
	
	<form action="ViewName" method="POST">
		
		<label>Click View for Display all Data : 
		<input type="submit" value="View Data"> <br><br>
	</form>
	
</center>
</body>
</html>