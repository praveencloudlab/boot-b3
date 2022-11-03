<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- CSS only -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi"
	crossorigin="anonymous">
</head>
<body class="container">
	<h1>Welcome to one.jsp</h1>
	<hr />

	<h2>Welcome ${user}</h2>

	<hr />

	<table class="table table-hover">

		<thead>
			<tr>
				<th>Product ID</th>
				<th>Product Name</th>
				<th>Price</th>
				<th>Description</th>
				<th>Edit</th>
				<th>Remove</th>
			</tr>
		</thead>

		<tbody>

			<c:forEach items="${products}" var="prod">
				<tr>
					<td>${prod.id}</td>
					<td>${prod.name}</td>
					<td>${prod.price}</td>
					<td>${prod.description}</td>
					<td><button class="btn btn-primary">Edit</button>
					<td><button class="btn btn-danger">Delete</button>
				</tr>
			</c:forEach>

		</tbody>



	</table>

</body>
</html>