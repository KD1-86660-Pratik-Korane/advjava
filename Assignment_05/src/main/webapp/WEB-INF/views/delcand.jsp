<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
       <jsp:useBean id="dlc" class="com.sunbeam.beans.DeleteCandidateBean"/>
	<jsp:setProperty name="dlc" property="candId" param="id" />
	${dlc.deleteCandidate()}
	<c:choose>
		<c:when test="${dlc.count == 1}">
			<jsp:forward page="result.jsp">
				<jsp:param name="msg" value="Candidate deleted Successfully." />
			</jsp:forward>
		</c:when>
		<c:otherwise>
			<jsp:forward page="result.jsp">
				<jsp:param name="msg" value="Failed." />
			</jsp:forward>		
		</c:otherwise>
	</c:choose>
</body>
</html>