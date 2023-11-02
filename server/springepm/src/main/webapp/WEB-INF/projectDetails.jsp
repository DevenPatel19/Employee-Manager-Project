<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
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
    <link rel="stylesheet" href="/css/main.css" />
    <title>Project Details</title>
</head>
<body>
<div class="container mt-5">
    <h1>Project Details</h1>
    <h3>Project Name: <c:out value="${onePro.projectName}" /></h3>
    <h3>Current Status: <c:out value="${onePro.currentStatus}" /></h3>
    <h3>Project Details: ${onePro.projectdetails}</h3>
    <h3>Project ID#: <c:out value="${onePro.id}" /></h3>

    <a href="/project/${onePro.id}/unassign" class="btn btn-success">Remove an Employee</a>

    <h3>Assigned Employees:</h3>
    <ul>
        <c:forEach items="${onePro.employee}" var="employee">
            <li>${employee.firstName} ${employee.lastName} - ${employee.email}</li>
        </c:forEach>
    </ul>
    
     <a href="/dashboard" class="btn btn-primary">Dashboard</a>
     
     
</div>
</body>
<!-- For any Bootstrap that uses JS -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</html>
