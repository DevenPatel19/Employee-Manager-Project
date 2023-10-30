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
<title>DashBoard</title>
</head>
<body>
	<div class="container mt-5">
		<div class="container mt-5">
		<h1>Current Employees</h1>
		<table class="table table-striped">
		  <thead class="table-dark">
		    <tr>
		      <th scope="col">ID</th>
		      <th scope="col">First</th>
		      <th scope="col">Last</th>
		      <th scope="col">email</th>
		      <th scope="col">Actions</th>    
		    </tr>
		  </thead>
		  <tbody class="table-group-divider">
		   <c:forEach items="${allEmployee}" var="eachEmployee">
		    <tr>
		        <td><a href="/employee/${eachEmployee.id}">${eachEmployee.id}</a></td>
                <td><a href="/employee/${eachEmployee.id}">${eachEmployee.firstName}</a></td>
		        <td><a href="/employee/${eachEmployee.id}">${eachEmployee.lastName}</a></td>
                <td><a href="mailto:${eachEmployee.email}">${eachEmployee.email}</a></td>
                <td><a href="/employee/${eachEmployee.id}/edit" class="btn btn-warning">Edit</a>    
        <form action="/employee/${eachEmployee.id}" method="post">
			<input type="hidden" name="_method" value="delete" />
			<button style="display:inline;" type="submit" class="btn btn-danger">Delete</button>
		</form>
		    </tr>
		    </c:forEach>
		  </tbody>
		</table>
		    <a href="/employee/new" class="btn btn-primary">New Employee</a>
		</div>
		<div class="container mt-5">
		<h1>Current Projects</h1>
		<table class="table table-striped">
		  <thead class="table-dark">
		    <tr>
		      <th scope="col">ID</th>
		      <th scope="col">Project Name</th>
		      <th scope="col">Project Lead</th>
		      <th scope="col">Current Status</th>
		      <th scope="col">Action</th>
		    </tr>
		  </thead>
		  <tbody class="table-group-divider">
		 <c:forEach items="${allProject}" var="eachProject">
		    <tr>
		        <td class="fw-bold">${eachProject.id}</td>
                <td class="fw-bold"><a href="/project/${eachProject.id}">${eachProject.projectName}</a></td>
		        <td class="fw-bold"><a href="/project/${eachProject.id}">${eachProject.projectLead}</a></td>
                <td class="fw-bold">${eachProject.currentStatus}</td>
                <td><a href="/project/${eachProject.id}/edit" class="btn btn-warning">Edit</a>    
                <form action="/project/${eachProject.id}" method="post">
					<input type="hidden" name="_method" value="delete" />
					<button style="display:inline;" type="submit" class="btn btn-danger">Delete</button>
				</form></td>
		    </tr>
		    </c:forEach>
		  </tbody>
		</table>
		   <a href="/project/new" class="btn btn-primary">New Project</a>
		</div>
	</div>
</body>
<!-- For any Bootstrap that uses JS -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</html>