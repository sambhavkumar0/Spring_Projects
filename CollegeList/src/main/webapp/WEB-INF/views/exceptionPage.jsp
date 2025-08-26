<%@page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>
<body bgcolor="lavender">
<h1><center> Top Colleges List </center></h1>
<center>

<table border="1" cellpadding="10" cellspacing="0">
    <tr bgcolor="lightblue">
        <th>College Name</th>
        <th>Location</th>
        <th>Offering Course</th>
        <th>Annual Fees</th>
    </tr>
    <c:forEach var="college" items="${colleges}">
        <tr>
            <td><c:out value="${college.collegeName}" /></td>
            <td><c:out value="${college.location}" /></td>
            <td><c:out value="${college.offeringCourse}" /></td>
            <td><c:out value="${college.annualFees}" /></td>
        </tr>
    </c:forEach>
</table>

<div>
    <center><a href="showPage"> Back to search</a></center>
</div>
</center>

</body>
</html>