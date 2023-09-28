<%--
  Created by IntelliJ IDEA.
  User: Mr Hieu
  Date: 28/09/2023
  Time: 12:23 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Employee List</title>
</head>
<body>
<div class="content" >
    <h2 style="text-align: center">Employee Information</h2>
    <div class="tbl-employee" style="display: flex; justify-content: center; align-content: center">
        <table border="1">
            <tr>
                <th>Employee No</th>
                <th>Name</th>
                <th>Place Of Work</th>
                <th>Phone No</th>
                <th>Delete</th>
            </tr>
            <c:forEach var="emp" items="${employees}">
                <tr>
                    <td>${emp.employeeNo}</td>
                    <td>${emp.employeeName}</td>
                    <td>${emp.placeOfWork}</td>
                    <td>${emp.phoneNo}</td>
                    <td><a href="<c:url value="/EmployeeServlet?action=delete&empNo=${emp.employeeNo}"/>">${emp.employeeNo}</a></td>
                </tr>
            </c:forEach>
        </table>

    </div>
    <div style="text-align: center">
        <a href="<c:url value="/EmployeeServlet?action=add"/>">Add New</a>
    </div>
</div>

</body>
</html>

