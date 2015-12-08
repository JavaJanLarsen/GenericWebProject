<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link rel="stylesheet" type="text/css" href="css/generic.css"/>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Environment</title>
</head>
<body>
	<h1>Properties</h1>
	<table class="bordertable">
		<c:forEach var="entry" items="${props}">
			<tr>
				<td><c:out value="${entry.key}" /></td>
				<td><c:out value="${entry.value}" /></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>