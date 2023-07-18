<jsp:useBean id="employee" scope="request" type="com.example.timeclock.Employee"/>
<%--
  Created by IntelliJ IDEA.
  User: JordanDetwiler
  Date: 7/16/23
  Time: 8:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
  <meta charset="UTF-8">
  <title>Clock In/Out</title>
</head>
<body>
  <b>Welcome, ${employee.firstName} ${employee.lastName}</b>
  <p></p>
  <span>Status: </span>
  <% if(employee.getClockedIn()) { %>
    <span>Clocked In</span>
  <% } else { %>
    <span>Clocked Out</span>
  <% } %>
  <p></p>
  <b>Punch Record:</b>
  <% for(String date : employee.getPunchRecord()) { %>
    <p><%= date %></p>
  <% } %>
  <p></p>
  <button onclick="window.location.href='/users/' + ${employee.id} + '/clockIn';">Clock In</button>
  <button onclick="window.location.href='/users/' + ${employee.id} + '/clockOut';">Clock Out</button>
</body>
</html>