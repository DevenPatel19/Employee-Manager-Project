<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>  
<%@ page isErrorPage="true" %>  
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <!-- Include Bootstrap CSS using a CDN -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css">
    <title>Add New Employee</title>
</head>
<body>
    <div class="container">
        <h2>New Employee Form</h2>
        <form:form action="/employee/new" method="POST" modelAttribute="newEmp" class="form-control mt-4">
            <div class="form-group">
                <form:label path="firstName"> First Name: </form:label>
                <form:input path="firstName" type="text" class="form-control" />
                <form:errors path="firstName" class="text-danger" />
            </div>
            <div class="form-group">
                <form:label path="lastName"> Last Name: </form:label>
                <form:input path="lastName" type="text" class="form-control" />
                <form:errors path="lastName" class="text-danger" />
            </div>
            <div class="form-group">
                <form:label path="email"> Email: </form:label>
                <form:input path="email" class="form-control" />
                <form:errors path="email" class="text-danger" />
            </div>
            <button type="submit" class="btn btn-primary mt-3">Submit</button>
        </form:form>
        	<a href="/dashboard" class="btn btn-warning mt-3">Dashboard</a>
    </div>
    <!-- Include Bootstrap JavaScript using a CDN -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
