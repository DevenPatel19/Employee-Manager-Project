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
	     <form:form modelAttribute="oneEmp" action="/employee/${oneEmp.id}/edit" method="PUT">
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
			
	        
            <input type="submit" value="Update">
        </form:form>
        <a href="/dashboard" class="btn btn-primary mt-3">Dashboard</a>
    </div>
	

    <!-- For Bootstrap JS -->
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
