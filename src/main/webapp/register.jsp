<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<style type="text/css">
  <%@include file="css/home.css" %>
</style>

</head>
<body>
<center>
<h1 class="page-heading">Flexi Acedmic Schedular</h1>
</center>
<div class="center">

<h1>REGISTER</h1>
	<form action="register_user" method="post">
		<div class="txt-field">
			
		
		
			<input type="text" placeholder="Enter email id" name="username" required>
		</div>
		<div class="txt-field">
			<input type="text" placeholder="Enter password" name="password" required>
		</div>
		<div>
			<input type="submit" value="REGISTER" >
		</div>
	</form>
	<br>
	</div>
	
	
</body>
</html>