<jsp:useBean id="employee" scope="request" type="com.example.timeclock.Employee"/>
<%--
  Created by IntelliJ IDEA.
  User: abser
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
  <b>Welcome, ${employee.firstName} ${employee.lastName},</b>
  <p>Clocked in? ${employee.clockedIn}</p>
</body>
</html>