<%@page import="com.scheduler.model.SubjectSchedule"%>
<%@page import="com.scheduler.model.DayTimeTable"%>
<%@page import="com.scheduler.dao.DayScheduleDaoImpl"%>
<%@page import="com.scheduler.dao.IDayScheduleDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Schedule Viewer</title>
<style type="text/css">
    body {
        font-family: Arial, sans-serif;
        margin: 0;
        padding: 0;
        background-color: #f4f4f4;
    }
    .navbar {
        background-color: #333;
        overflow: hidden;
    }
    .navbar ul {
        list-style-type: none;
        margin: 0;
        padding: 0;
    }
    .navbar ul li {
        float: left;
    }
    .navbar ul li a {
        display: block;
        color: white;
        text-align: center;
        padding: 14px 20px;
        text-decoration: none;
    }
    .navbar ul li a:hover {
        background-color: #575757;
    }
    h2 {
        background-color: #333;
        color: white;
        padding: 10px;
        text-align: center;
    }
    ol {
        background-color: white;
        padding: 20px;
        margin: 20px;
        border-radius: 10px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }
    ol li {
        margin: 10px 0;
        padding: 10px;
        background-color: #f9f9f9;
        border-left: 5px solid #333;
    }
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

<%
    IDayScheduleDao schedule = DayScheduleDaoImpl.getDayScheduleDao();
    String[] weekdays = {"", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};

    for (int i = 1; i <= 5; i++) {
        DayTimeTable daytimetable = schedule.RetrieveSchedule(i);
        if (daytimetable != null && daytimetable.getWeekday() == i) {
            out.println("<h2>" + weekdays[i] + "</h2>");
            out.println("<ol>");
            for (SubjectSchedule s : daytimetable.getSubjects()) {
                out.println("<li>" + "Start Time: " + s.getStime() + " | End Time: " + s.getEtime() + " | Subject: " + s.getSubcode() + "</li>");
            }
            out.println("</ol>");
        } else {
            out.println("<h2>" + weekdays[i] + "</h2>");
            out.println("<p>No schedule available.</p>");
        }
    }
%>

</body>
</html>
