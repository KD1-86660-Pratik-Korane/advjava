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
      <form method="post" action="login.jsp">
        <h2>LogIn</h2>
        Email : <input type="text" name="email"><br/><br/>
        Password : <input type="password" name="password">
           
           <input type="submit" value="Sign in">
           <p>
              <a href="newuser.jsp">SignUp</a>
           </p>
        
      </form>
</body>
</html>