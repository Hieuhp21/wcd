<%@ page import="com.hieunv.entity.student" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Student Information</title>
</head>
<body>
    <%
        Cookie[] cookies = request.getCookies();
        Cookie studentCookie = null;
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("student")) {
                studentCookie = cookie;
            }
        }
        student student = new student();
        if (studentCookie != null && studentCookie.getValue() != null && !studentCookie.getValue().isEmpty()) {
            student = student.fromCookieValue(studentCookie.getValue());
        }

//        if (studentCookie != null) {
//            student = student.fromCookieValue(studentCookie.getValue());
//        }

    %>
    <h1><%=student.getName()%>, <%=student.getAddress()%>, <%= student.getPhone()%>, <%=student.getClassName()%></h1>
</body>
</html>
