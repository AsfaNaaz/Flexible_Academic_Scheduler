<%@page import="com.scheduler.model.ClassroomUser"%>
<%@page import="com.scheduler.dao.ClassroomUserDaoImpl"%>
<%@page import="com.scheduler.dao.IClassroomUserDao"%>
<%@page import="java.util.List"%>
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
    <%IClassroomUserDao classroom=ClassroomUserDaoImpl.getClassroomUserDao();
    List<ClassroomUser>ClassroomList=classroom.getAllClassroom();
    out.println("<table>");
    out.println("<tr>");
    out.println("<th>classroomno</th>");
    out.println("<th>classroomblock</th>");
 //   out.println("<th>tdept</th>");
    out.println("</tr>");
    for(int i=0; i<ClassroomList.size();i++){
    	out.println("<tr>"+"<td>"+ClassroomList.get(i).getCno()+"</td>"+"<td>"+ClassroomList.get(i).getCblock()+"</td>"+"</tr>");
    }
    %>
    </div>
</body>
</html>