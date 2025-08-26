<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<style>
#message{
color:green;
font-weight: bold;
}
</style></head>
<body style="background-color:lavender">

<a href="/showPage?language=en">English</a>|<a href="/showPage?language=fr">French</a>
<h1><center><spring:message code="app.title" text="Sports Academy" /></center></h1>
<form:form modelAttribute="registration" action="registration" method="post">
<table style="margin: 0px auto; margin-left: auto; margin-right:auto; border-spacing: 10px;">
		   	
	<tr>
		<td><spring:message code="label.studentName" /></td>
		<td><form:input path="studentName" id="studentName"/></td>
	</tr>
	<tr>
		<td><spring:message code="label.age" /></td>
		<td><form:input path="age" id="age"/></td>
	</tr>
	<tr>
		<td><spring:message code="label.phoneNumber" /></td>
		<td><form:input path="phoneNumber" id="phoneNumber"/></td>
	</tr>
	<tr>
		<td><spring:message code="label.optedSports" /></td>
		<td>
			<form:select path="optedSports" id="optedSports">
				<form:options items="${sportsList}"/>
			</form:select>
		</td>
	</tr>
	<tr>
		<td colspan="2" style="text-align:center;">
			<input type="submit" name="submit" id="submit" value="Register" />
		</td>
	</tr>	   	
		   	
<tr> <td colspan=2><div id="message">${message}</div></td></tr>
</table>
</form:form>


</body>
</html>