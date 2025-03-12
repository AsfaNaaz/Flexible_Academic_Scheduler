<%@page import="com.scheduler.model.TeacherUser"%>
<%@page import="java.util.List"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="com.scheduler.dao.ITeacherUserDao"%>
<%@page import="com.scheduler.dao.TeacherUserDaoImpl"%>
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
<div class="container">
<%ITeacherUserDao teacher=TeacherUserDaoImpl.getTeacherUserDao(); 
List<TeacherUser>TeacherList=teacher.getAllTeacher();
out.println("<table>");
out.println("<tr>");
out.println("<th>tid</th>");
out.println("<th>tname</th>");
out.println("<th>tdept</th>");
out.println("</tr>");
for(int i=0;i<TeacherList.size();i++){
	out.println("<tr>"+"<td>"+TeacherList.get(i).getTid()+"</td>"+"<td>"+TeacherList.get(i).getTname()+"</td>"+"<td>"+TeacherList.get(i).getTdept()+"</td>"+"</tr>");
	//out.println(TeacherList.get(i).getTid());
	//out.println(TeacherList.get(i).getTname());
//	out.println(TeacherList.get(i).getTdept());
}
out.println("</table>");
%>
</div>
</body>
</html>