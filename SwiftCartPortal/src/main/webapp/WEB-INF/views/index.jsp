<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%> 
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
<body bgcolor="lightgreen"> 
    <center> 
        <h1>Swift Cart Portal</h1> 
        
        <sf:form method="post" action="registerCustomer" modelAttribute="customer">
            <table>
                <tr>
                    <td><label for="name">Name:</label></td>
                    <td><sf:input path="name" id="name" /></td>
                </tr>
                <tr>
                    <td><label for="emailId">Email Id:</label></td>
                    <td><sf:input path="emailId" id="emailId" /></td>
                </tr>
                <tr>
                    <td><label for="mNumber">Mobile Number:</label></td>
                    <td><sf:input path="mobileNumber" id="mNumber" /></td>
                </tr>
                <tr>
                    <td colspan="2" align="center">
                        <input type="submit" id="submit" value="Register" />
						 <button id="register" style="visibility:hidden; height:0; width:0; border:none; padding:0; margin:0;">Register</button>
					</td>
                </tr>
            </table>
        </sf:form> 
    </center> 
</body> 
</html>