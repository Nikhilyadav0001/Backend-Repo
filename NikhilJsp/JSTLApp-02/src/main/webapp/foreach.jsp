<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.ArrayList, nikhil.beans.Student" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>UI PAGE</title>
</head>

<body>

<%
    ArrayList<Student> stdList = new ArrayList<Student>();

    stdList.add(new Student("1", "nikhil", 19, "hayatpur"));
    stdList.add(new Student("2", "sachin", 19, "rewari"));
    stdList.add(new Student("3", "kunal", 19, "hayatpur"));
    stdList.add(new Student("4", "kartik", 19, "hayatpur"));

    pageContext.setAttribute("studentList", stdList);
%>

<h1 align="center">
    WORKING WITH FOREACH TO PERFORM READ OPERATION ON LIST
</h1>

<c:choose>

    <c:when test="${not empty studentList}">

        <table border="1" align="center">

            <caption>
                <b>STUDENT DATA</b>
            </caption>

            <tr>
                <th>ID</th>
                <th>NAME</th>
                <th>AGE</th>
                <th>ADDRESS</th>
                <th>ACTION</th>
            </tr>

            <c:forEach var="student" items="${studentList}">

                <!-- UPDATE URL -->
                <c:url var="updateLink" value="/student/update">
                    <c:param name="sid" value="${student.sid}" />
                </c:url>

                <!-- DELETE URL -->
                <c:url var="deleteLink" value="/student/delete">
                    <c:param name="sid" value="${student.sid}" />
                </c:url>

                <tr>

                    <td>${student.sid}</td>

                    <td>${student.sname}</td>

                    <td>${student.sage}</td>

                    <td>${student.saddress}</td>

                    <td>
                        <a href="${updateLink}">UPDATE</a>
                        |
                        <a href="${deleteLink}">DELETE</a>
                    </td>

                </tr>

            </c:forEach>

        </table>

    </c:when>

    <c:otherwise>

        <h2 style="color:red; text-align:center">
            No records to display
        </h2>

    </c:otherwise>

</c:choose>

</body>

</html>