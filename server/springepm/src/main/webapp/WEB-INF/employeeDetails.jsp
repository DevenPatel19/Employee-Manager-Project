<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>  
<%@ page isErrorPage="true" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/main.css"/>
<title>Employee Details</title>
</head>
<body>
	<div class="container mt-5">
		<h1>Employee Details </h1>
			<h3>First Name: <c:out value="${oneEmp.firstName}"></c:out></h3>
			<h3>Last Name: <c:out value="${oneEmp.lastName}"></c:out></h3>
			<h3>Email: <a href="mailto:${oneEmp.email}">${oneEmp.email}</a></h3>
			<h3>Employee ID#: <c:out value="${oneEmp.id}"></c:out></h3>
		
		<a href="/employee/${oneEmp.id}/assign" class="btn btn-success">Add to a Project</a>
		<a href="/dashboard" class="btn btn-warning">Dashboard</a>
		
		<h3>Current Projects:</h3>
	    <ul>
	    <c:forEach items="${oneEmp.project}" var="project">
		<li><c:out value="${project.projectName}"></c:out></li>
		</c:forEach>
		</ul>
	</div>
	
	
	
</body>
<!-- For any Bootstrap that uses JS -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</html>