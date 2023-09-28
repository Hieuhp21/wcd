<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Student</title>
</head>
<body>
<div class="content" style="align-content: center; justify-content: center; display: flex">

    <form method="post" action="/StudentServlet">
        <table>
            <tr>
                <td><label>Name: </label></td>
                <td><input type="text" id="name" name="name" required></td>
            </tr>
            <tr>
                <td><label>Address: </label></td>
                <td><input type="text" id="address" name="address" required></td>
            </tr>
            <tr>
                <td><label>Phone: </label></td>
                <td><input type="text" id="phone" name="phone" required></td>

            </tr>
            <tr>
                <td><label>Class Name: </label></td>
                <td><input type="text" id="className" name="className" required></td>
            </tr>
            <tr>
                <td><input type="submit" value="Submit Query"></td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
