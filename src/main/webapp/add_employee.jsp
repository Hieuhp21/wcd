<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Add new Employee</title>
</head>
<body>

<div class="content" style="align-content: center; justify-content: center; display: flex">

    <form method="post" action="/EmployeeServlet?action=create" onsubmit="return validate();">
        <table>
            <tr>
                <td colspan="3">
                    <c:if test="${errMsg != null}">
                        <span style="color: red;"> ${errMsg}</span>
                    </c:if>
                </td>
            </tr>
            <tr>
                <td><label>Employee No: </label></td>
                <td><input type="text" id="empNo" name="empNo" value="${employee.employeeNo}"></td>
                <td><span style="color: red" id="empNoErr"></span></td>
            </tr>
            <tr>
                <td><label>Employee Name: </label></td>
                <td><input type="text" id="empName" name="empName" value="${employee.employeeName}"></td>
                <td><span style="color: red" id="empNameErr"></span></td>
            </tr>
            <tr>
                <td><label>Place of Work: </label></td>
                <td><input type="text" id="empPlace" name="empPlace" value="${employee.placeOfWork}"></td>
                <td><span style="color: red" id="empPlaceErr"></span></td>
            </tr>
            <tr>
                <td><label>Phone No: </label></td>
                <td><input type="text" id="empPhone" name="empPhone" value="${employee.phoneNo}"></td>
                <td><span style="color: red" id="empPhoneErr"></span></td>
            </tr>
            <tr>
                <td><input type="submit" value="Submit Query"></td>
                <td></td>
                <td><input type="reset" value="Reset"></td>
            </tr>
            <tr>
                <td colspan="3"><a href="<c:url value="/EmployeeServlet"/>">Back to list</a> </td>
            </tr>
        </table>
    </form>
</div>
<script>
    function validate() {
        var empNo = document.getElementById("empNo").value;
        var result;
        if (empNo == "") {
            document.getElementById("empNoErr").innerHTML = "You must input employee number"
            result = false;
        } else {
            document.getElementById("empNoErr").innerHTML = ""
            result = true;
        }
        var empName = document.getElementById("empName").value;

        if (empName == "") {
            document.getElementById("empNameErr").innerHTML = "You must input employee name"
            result = false;
        } else {
            document.getElementById("empNameErr").innerHTML = ""
            result = true;
        }

        var placeOfWork = document.getElementById("empPlace").value
        if (placeOfWork == "") {
            document.getElementById("empPlaceErr").innerHTML = "You must input employee place of work"
            result = false;
        } else {
            document.getElementById("empPlaceErr").innerHTML = ""
            result = true;
        }

        var empPhone = document.getElementById("empPhone").value
        if (empPhone == "") {
            document.getElementById("empPhoneErr").innerHTML = "You must input employee phone no"
            result = false;
        } else {
            document.getElementById("empPhoneErr").innerHTML = ""
            result = true;
        }
        return result;
    }
</script>
</body>
</html>
