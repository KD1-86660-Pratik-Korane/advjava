<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
         <jsp:useBean id="Reg1" class="com.sunbeam.beans.RegistrationBean" />
         <jsp:setProperty name="Reg1" property="firstName" param="firstName" />
		 <jsp:setProperty name="Reg1" property="lastName" param="lastName" />
		 <jsp:setProperty name="Reg1" property="email" param="email" />
		 <jsp:setProperty name="Reg1" property="password" param="password" />
		 <jsp:setProperty name="Reg1" property="birth" param="birth" />
		 
		 <p>${Reg1.registerUser()}</p>
		 
		 
		 <c:choose>
		<c:when test="${Reg1.count==1}">
			Registered succesfully: ${Reg1.count}
		</c:when>
		<c:otherwise>
			Registration failed: ${Reg1.count}
		</c:otherwise>
	</c:choose>
		  <a href="index.jsp">Login</a>
</body>
</html>