<%@page import="com.scheduler.model.TeacherUser"%>
<%@page import="com.scheduler.dao.TeacherUserDaoImpl"%>
<%@page import="com.scheduler.dao.ITeacherUserDao"%>
<%@page import="com.scheduler.model.SubjectUser"%>
<%@page import="java.util.List"%>
<%@page import="com.scheduler.dao.SubjectUserDaoImpl"%>
<%@page import="com.scheduler.dao.ISubjectUserDao"%>
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
<form action="timing_user" method="post">
<div>
<select name="deptName">
<option hidden="true" value="">select dept</option>
<option value="CSE">cse</option>
</select>
</div>
<div>
<select name="batchName">
<option hidden="true" value="">select batch</option>
<option value="B1">B1</option>
</select>
</div>
<div class="txt-field">
<label>Enter Start Time</label>
<input type="time"  name="stime">
</div>
<select id="subjectCode" name="subjectCode" required>
		<option value="">Select a subjectCode</option>
		<%
		ISubjectUserDao subject=SubjectUserDaoImpl.getSubjectUserDao();
		List<SubjectUser> clas=subject.getAllSubject();
		int size=clas.size();
		for(int i=0;i<size;i++)
		{
			out.println("<option value="+ clas.get(i).getScode() + ">"+clas.get(i).getScode()+"</option>");
		}
		%>
		</select>
<div>
<select id=stype name=stype>
<option value ="Theory">Theory</option>
<option value ="Lab">Lab</option>
<option value ="Reccess">Reccess</option>
</select>
</div>
<div class="form-group">
			<label for="subject">Teacher:</label> <select id="teacherId"
				name="teacherId" required>
				<option value="">Select a teacherid</option>
				<!-- Add options for subjects dynamically here -->
				<%
				ITeacherUserDao teacher = TeacherUserDaoImpl.getTeacherUserDao();
				List<TeacherUser> sub = teacher.getAllTeacher();
				int size2 = sub.size();
				for (int i = 0; i < size2; i++) {
					out.println("<option value=" + sub.get(i).getTid() + ">" + sub.get(i).getTid() + "</option>");
				}
				%>
			</select>
		</div>
	<div>
<select id=sdate name=sdate>
<option value ="1">MONDAY</option>
<option value ="2">TUESDAY</option>
<option value ="3">WEDNESDAY</option>
<option value ="4">THRUSDAY</option>
<option value ="5">FRIDAY</option>

</select>
</div>	


<div>
<input type="submit" value="SUBMIT">
</div>
<br>
</form>
</div>
</body>
</html>