<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <link rel='stylesheet' href='<spring:theme code="styleSheet"/>'  type='text/css'/>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Environment</title>
</head>
<body>
	<h1>Properties</h1>
	<table>
		<c:forEach var="entry" items="${props}">
			<tr>
				<td><c:out value="${entry.key}" /></td>
				<td><c:out value="${entry.value}" /></td>
			</tr>
		</c:forEach>
	</table>
	<h1>Dependencies</h1>
	<table>
		<c:forEach var="dependency" items="${dependencies}">
			<tr>
				<td><c:out value="${dependency}" /></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>