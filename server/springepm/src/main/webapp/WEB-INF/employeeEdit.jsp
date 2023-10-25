<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <!-- For Bootstrap CSS -->
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
    <!-- Your own local CSS -->
    <link rel="stylesheet" href="/css/main.css"/>
    <title>Update Employee</title>
</head>
<body>
	<div class="container mt-5">
    <h1>Update Employee</h1>
	     <form:form  modelAttribute="oneEmp" action="/employee/${employee.id}/edit" method="put">
	        <form:hidden path="id" />
			<div class="input-group mb-3">
	        	<form:label path="firstName">First Name:</form:label>
	        	<form:input path="firstName" id="firstName" />
	       	</div>
	
			<div class="input-group mb-3">
	        	<form:label path="lastName">Last Name:</form:label>
	        	<form:input path="lastName" id="lastName" />
			</div>
			
			<div class="input-group mb-3">
	        	<form:label path="email">Email:</form:label>
	        	<form:input path="email" id="email" />
			</div>
			
	        <h2>Projects:</h2>
	        <c:forEach var="project" items="${allProjects}">
	            <div class="form-check">
	                <input type="checkbox" class="form-check-input" id="project-${project.id}" name="projectIds" value="${project.id}"
	                <c:choose>
	                    <c:when test="${employee.projectIds.contains(project.id)}">
	                        checked
	                    </c:when>
	                </c:choose>
	                />
	                <label class="form-check-label" for="project-${project.id}">
	                    ${project.projectName}
	                </label>
	            </div>
	        </c:forEach>
	
	        <!-- Add other fields as needed -->
	
	        <input type="submit" value="Update">
	    </form:form>
	</div>

    <!-- For Bootstrap JS -->
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
