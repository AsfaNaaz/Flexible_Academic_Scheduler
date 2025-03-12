<%@page import="com.scheduler.dao.SubjectUserDaoImpl"%>
<%@page import="com.scheduler.dao.ISubjectUserDao"%>
<%@page import="java.util.List"%>
<%@page import="com.scheduler.model.SubjectUser"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
  <%@include file="css/home.css" %>
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
<form action="classroom_user" method="post">
		<div class="txt-field">
			
			<input type="text" placeholder="classroom no" name="cno" required>
		</div>
		<div class="txt-field">
			<input type="text" placeholder="classroom block" name="cblock" required>
		</div>
		<br>
		<div class="from-group">
		<label for="classroom">Subject:</label>
		<select id="subjectCode" name="subjectCode" required>
		<option value="">Select a subjectCode</option>
		<%
		ISubjectUserDao subject=SubjectUserDaoImpl.getSubjectUserDao();
		List<SubjectUser> clas=subject.getAllSubject();
		//int size=clas.size();
		for(int i=0;i<clas.size();i++)
		{
			out.println("<option value="+ clas.get(i).getScode() + ">"+clas.get(i).getScode()+"</option");
		}
		%>
		</select>
		
		</div>
		
		<div class="txt-field">
			<input type="text" placeholder=" Student dept" name="sdept">
		</div>
		<br>
		<div class="txt-field">
			<input type="text" placeholder="student section" name="ssec">
		</div>
		
		<div>
			<input type="submit" value="SUBMIT" >
		</div>
		<br>
	</form>
	<br>
	</div>
</body>
</html>