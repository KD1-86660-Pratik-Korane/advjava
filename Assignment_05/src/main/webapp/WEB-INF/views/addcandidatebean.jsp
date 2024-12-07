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
        <jsp:useBean id="acnd" class="com.sunbeam.beans.AddCandidateBean"/>
	<jsp:setProperty name="acnd" property="*" />
	${acnd.addCandidate()}
	<c:choose>
		<c:when test="${acnd.count == 1}">
			<jsp:forward page="result.jsp">
				<jsp:param name="msg" value="Candidate Added Successfully." />
			</jsp:forward>
		</c:when>
		<c:otherwise>
			<jsp:forward page="result.jsp">      b
				<jsp:param name="msg" value="Failed to add Candidate" />
			</jsp:forward>		
		</c:otherwise>
	</c:choose>
</body>
</html>