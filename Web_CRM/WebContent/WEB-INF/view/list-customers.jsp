<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>

<html>

<head>

<title>Customers List</title>

<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css" />
</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>CRM</h2>
		</div>
	</div>

	<div id="container">
		<div id="content">

			<table>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email Address</th>
				</tr>

				<c:forEach var="cust" items="${customers}">

					<tr>
						<td>${cust.firstName}</td>
						<td>${cust.lastName}</td>
						<td>${cust.email}</td>
					</tr>

				</c:forEach>


			</table>

		</div>

	</div>

</body>
</html>