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
<title>Project Details</title>
</head>
<body>
	<div class="container mt-5">
	<h1>Project Details </h1>
		<h3>Porject Name: <c:out value="${oneEmp.firstName}"></c:out></h3>
		<h3>Last Name: <c:out value="${oneEmp.lastName}"></c:out></h3>
		<h3>Email: <a href="mailto:${oneEmp.email}">${oneEmp.email}</a></h3>
		<h3>Employee ID#: <c:out value="${oneEmp.id}"></c:out></h3>
		 <c:set var="employee" value="${employee}" /> <!-- Replace with your employee object -->
    
    <h1>Projects associated with ${employee.firstName} ${employee.lastName}</h1>

    <c:if test="${not empty employee.project}">
         <ul>
                <c:forEach var="project" items="${employee.projects}">
                    <li>${project.name}</li>
                </c:forEach>
            </ul>
    </c:if>

    <c:if test="${empty employee.project}">
        <p>${employee.firstName} ${employee.lastName} is not associated with any projects.</p>
    </c:if>
	</div>
</body>
<!-- For any Bootstrap that uses JS -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</html>