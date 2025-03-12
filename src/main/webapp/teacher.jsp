<%@page import="com.scheduler.model.TeacherUser"%>
<%@page import="java.util.List"%>
<%@page import="com.scheduler.dao.TeacherUserDaoImpl"%>
<%@page import="com.scheduler.dao.ITeacherUserDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<style type="text/css">
<%@include file="css/home.css"%>
<%@include file="css/disp.css"%>
</style>
</head>
<body>
 <nav class="navbar">
        <ul>
            <li><a href="#">Home</a></li>
            <li><a href="teacher">Teacher</a></li>
             <li><a href="getAllTeacher">TeacherList</a></li>
            <li><a href="subject">Subject</a></li>
             <li><a href="getAllSubject">SubjectList</a></li>
            <li><a href="classroom">Classroom</a></li>
             <li><a href="getAllClassroom">ClassroomList</a></li>
           <li><a href="timing">Timing</a></li>  
         <li><a href="View_Table">viewtable</a></li>
            
        </ul>
    </nav>
	<div class="center">

		<form action="teacher_login" method="post">
			<div class="txt-field">
				<input type="text" placeholder="Enter Teacher Name" name="tname">
			</div>
			<div class="txt-field">
				<input type="text" placeholder="Enter Teacher Id" name="tid">
			</div>
			<div class="txt-field">
				<input type="text" placeholder="Enter Dept" name="tdept">
			</div>
			<div>
				<input type="submit" value="SUBMIT">
			</div>
			<br>
		</form>
		
	</div>
</body>
</html>