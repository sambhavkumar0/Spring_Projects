<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>

<!DOCTYPE html>
<html>
<body style="background-color:lavender">
<h1><center> Top Colleges List</center></h1>

<form:form method="POST" action="viewCollegeList" modelAttribute="college">
    <table align="center" cellpadding="10">
        <tr>
            <td>Offering Course:</td>
            <td><form:input path="offeringCourse" id="offeringCourse" /></td>
        </tr>
        <tr>
            <td>Annual Fees:</td>
            <td><form:input path="annualFees" id="annualFees" /></td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <input type="submit" value="Search" id="submit" />
            </td>
        </tr>
    </table>
</form:form>

</body>
</html>