
<%@page import="com.scheduler.model.SubjectUser"%>
<%@page import="java.util.List"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="com.scheduler.dao.ISubjectUserDao"%>
<%@page import="com.scheduler.dao.SubjectUserDaoImpl"%>





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
<%ISubjectUserDao subject=SubjectUserDaoImpl.getSubjectUserDao(); 
List<SubjectUser>SubjectList=subject.getAllSubject();
out.println("<table>");
out.println("<tr>");
out.println("<th>Sdept</th>");
out.println("<th>Ssem</th>");
out.println("<th>Ssec</th>");
out.println("<th>Scode</th>");
out.println("</tr>");
for(int i=0;i<SubjectList.size();i++){
	out.println("<tr>"+"<td>"+SubjectList.get(i).getSdept()+"</td>"+"<td>"+SubjectList.get(i).getSsem()+"</td>"+"<td>"+SubjectList.get(i).getSsec()+"</td>"+"<td>"+SubjectList.get(i).getScode()+"</td>"+"</tr>");
	//out.println(TeacherList.get(i).getTid());
	//out.println(TeacherList.get(i).getTname());
//	out.println(TeacherList.get(i).getTdept());
}
out.println("</table>");
%>
</div>
</body>
</html>