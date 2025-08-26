<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>

<!DOCTYPE html>
<html>
<head>
    <title>PulsePursuit Tournament Registration</title>
</head>
<body style="background-color:lavender">

<h1><center>Welcome to PulsePursuit Tournament</center></h1>

<form:form method="POST" action="register" modelAttribute="registration">

    <table>
        <tr>
            <td>Participant Name:</td>
            <td>
                <form:input path="participantName" id="participantName"/>
                <form:errors path="participantName" cssClass="error"/>
            </td>
        </tr>
        <tr>
            <td>Phone Number:</td>
            <td>
                <form:input path="phoneNumber" id="phoneNumber"/>
                <form:errors path="phoneNumber" cssClass="error"/>
            </td>
        </tr>
        <tr>
            <td>Email:</td>
            <td>
                <form:input path="email" id="email"/>
                <form:errors path="email" cssClass="error"/>
            </td>
        </tr>
        <tr>
            <td>Age:</td>
            <td>
                <form:input path="age" id="age"/>
                <form:errors path="age" cssClass="error"/>
            </td>
        </tr>
        <tr>
            <td>Event Type:</td>
            <td>
                <form:select path="eventType" id="eventType">
                    <form:option value="" label="--Select Event--"/>
                    <form:options items="${eventTypeList}" />
                </form:select>
                <form:errors path="eventType" cssClass="error"/>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" id="submit" value="Register"/>
            </td>
        </tr>
    </table>
</form:form>

<c:if test="${not empty message}">
    <h3 style="color:green">${message}</h3>
</c:if>

</body>
</html>