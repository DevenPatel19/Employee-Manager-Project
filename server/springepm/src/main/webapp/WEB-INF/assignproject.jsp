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
    <title>Assign Employee to Project</title>
</head>
<body>
    <div class="container mt-5">
        <h1>Assign Employee to Project</h1>
        <form:form modelAttribute="assignForm" action="/employee/${id}/assign" method="post">
            <form:hidden path="employeeId" value="${id}" />
            <div class="form-group">
               <h1>Employee Details </h1>
				<h3>First Name: <c:out value="${employee.firstName}"></c:out></h3>
				<h3>Last Name: <c:out value="${employee.lastName}"></c:out></h3>
				<h3>Email: <a href="mailto:${employee.email}">${employee.email}</a></h3>
				<h3>Employee ID#: <c:out value="${employee.id}"></c:out></h3>
            </div>
                
            <div class="form-group">
                <label for="projectId">Select Project to Assign:</label>
                <select id="projectId" name="projectId" class="form-control">
                    <c:forEach items="${allProjects}" var="project">
                        <option value="${project.id}">${project.projectName}</option>
                    </c:forEach>
                </select>
            </div>
            <button type="submit" class="btn btn-success mt-3">Assign</button>
        </form:form>
        <a href="/dashboard" class="btn btn-warning mt-3">Dashboard</a>
    </div>

    <!-- For Bootstrap JS -->
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>


