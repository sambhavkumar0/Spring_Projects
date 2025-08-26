<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="utf-8">
    <title>Sign Form</title>
    <link rel="stylesheet" type="text/css" href="/resources/css/style.css"/>
</head>
<body>
    <p>
        <a href="/showPage?language=en">English</a> | 
        <a href="/showPage?language=fr">French</a>
    </p>
    <div id="result"></div>
    <div class="wrapper">
        <div class="title"><spring:message code="title.createAccount" text="Create an Account" /></div>
        
        <sf:form action="signUp" method="post" modelAttribute="account">

            <div class="field">
                <label for="userName"><spring:message code="label.userName" /></label>
                <sf:input path="userName" id="userName" />
            </div>

            <div class="gender-field">
                <label><spring:message code="label.gender" /></label>

                <div class="radio-group">
                    <sf:radiobutton path="gender" value="male" id="male" />
                    <spring:message code="label.male" />
                </div>

                <div class="radio-group">
                    <sf:radiobutton path="gender" value="female" id="female" />
                    <spring:message code="label.female" />
                </div>
            </div>

            <div class="field">
                <label for="phoneNumber"><spring:message code="label.phoneNumber" /></label>
                <sf:input path="phoneNumber" id="phoneNumber" />
            </div>

			<div class="field">
			    <label for="email"><spring:message code="label.email" /></label>
			    <sf:input path="email" id="email" type="email" />
			</div>

            <div class="field">
                <label for="password"><spring:message code="label.password" /></label>
                <sf:password path="password" id="password" />
            </div>

            <div class="field">
                <input type="submit" id="submit" value="Sign" />
            </div>

            <label id="message">${message}</label>

        </sf:form>
    </div>
</body>
</html>