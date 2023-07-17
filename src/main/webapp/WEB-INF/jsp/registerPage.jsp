<%--
  Created by IntelliJ IDEA.
  User: abser
  Date: 7/17/23
  Time: 12:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Register New Employee</title>
    <script>function submitButton() {
        let firstName = document.getElementById("firstName").value;
        let lastName = document.getElementById("lastName").value;
        if(firstName !== "" && lastName !== "")
        window.location.href = "/users/" + firstName + "/" + lastName + "/register";}
    </script>
</head>
<body>
<p>Enter name to register:</p>
<label>First Name:
    <input id="firstName">
</label>
<label>Last Name:
    <input id="lastName">
</label>
<button onclick="submitButton()">Submit</button>
</body>
</html>