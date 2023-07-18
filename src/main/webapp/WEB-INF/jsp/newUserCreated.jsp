<jsp:useBean id="employee" scope="request" type="com.example.timeclock.Employee"/>
<%--
  Created by IntelliJ IDEA.
  User: JordanDetwiler
  Date: 7/17/23
  Time: 12:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Registration Successful</title>
</head>
<body>
  <p>Congrats, you are now a registered employee.</p>
  <p>Here is your new Employee ID (please record it for future use):</p>
  <b>${employee.id}</b>
  <p></p>
  <button onclick="window.location.href='/';">Return</button>
</body>
</html>
