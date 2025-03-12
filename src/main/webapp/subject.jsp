
<%@page import="com.scheduler.dao.ITeacherUserDao"%>
<%@page import="com.scheduler.dao.TeacherUserDaoImpl"%>
<%@page import="java.util.List"%>
<%@page import="com.scheduler.model.TeacherUser"%>


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

	<form action="subject_user" method="post">

		<div class="txt-field">
			<input type="text" placeholder="Enter subject code" name="scode">
		</div>
		<div class="txt-field">
			<input type="text" placeholder="Enter dept" name="sdept">
		</div>
		<div class="txt-field">
			<input type="text" placeholder="Enter semester" name="ssem">
		</div>
		<div class="txt-field">
			<input type="text" placeholder="Enter section" name="ssec">
		</div>
		<div class="form-group">
			<label for="subject">Teacher:</label> <select id="teacherId"
				name="teacherId" required>
				<option value="">Select a teacherid</option>
				<!-- Add options for subjects dynamically here -->
				<%
				ITeacherUserDao teacher = TeacherUserDaoImpl.getTeacherUserDao();
				List<TeacherUser> sub = teacher.getAllTeacher();
				int size = sub.size();
				for (int i = 0; i < size; i++) {
					out.println("<option value=" + sub.get(i).getTid() + ">" + sub.get(i).getTid() + "</option>");
				}
				%>
			</select>
		</div>
        <br>
		<div>
			<input type="submit" value="SUBMIT">
		</div>
		<br>
	</form>
	</div>

</body>
</html>