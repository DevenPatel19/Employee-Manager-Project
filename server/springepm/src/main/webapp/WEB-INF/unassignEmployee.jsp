<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <!-- For Bootstrap CSS -->
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
    <!-- Your own local CSS -->
    <link rel="stylesheet" href="/css/main.css"/>
    <title>Unassign Employee from Project</title>
</head>
<body>
    <div class="container mt-5">
        <h1>Unassign Employee from Project</h1>
        <h1>Project Details</h1>
        <h3>Project Name: <c:out value="${project.projectName}"></c:out></h3>
        <h3>Current Status: <c:out value="${project.currentStatus}"></c:out></h3>
        <h3>Project ID#: <c:out value="${project.id}"></c:out></h3>
      
        <form:form modelAttribute="unassignForm" action="/project/${project.id}/unassign" method="POST">
            <div class="form-group">
                <label for="employeeId">Select Employee to Unassign:</label>
                <select id="employeeId" name="employeeId" class="form-control">
                    <c:forEach items="${assignedEmployees}" var="employee">
                        <option value="${employee.id}">${employee.firstName} ${employee.lastName}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="mt-5">
            <button type="submit" class="btn btn-danger">Unassign</button>
        	<a href="/dashboard" class="btn btn-primary">Dashboard</a>
            </div>
        </form:form>

    </div>

    <!-- For Bootstrap JS -->
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
