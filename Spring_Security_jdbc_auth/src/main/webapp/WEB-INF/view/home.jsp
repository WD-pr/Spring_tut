<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>

<html>

<head>
<title>Home Page</title>
</head>

<body>
	<h2>Home Page</h2>
	<hr>
	<p>Welcome to the Home Page !!!</p>

	<p>
		User:
		<security:authentication property="principal.username" />
		<br> <br> Roles:
		<security:authentication property="principal.authorities" />
	</p>


	<hr>


	<security:authorize access="hasRole('MANAGER')">
		<!-- Restriction based on authorization using security jsp tags.
	Restricted content not even included in final generated HTML page. -->

		<p>
			<a href="${pageContext.request.contextPath}/leaders"> --
				Leadership -- </a>
		</p>

	</security:authorize>

	<security:authorize access="hasRole('ADMIN')">
		<p>
			<a href="${pageContext.request.contextPath}/systems"> -- Admin --
			</a>
		</p>
	</security:authorize>
	
	
	<!-- Logout button -->
	<form:form action="${pageContext.request.contextPath}/logout"
		method="POST">

		<!-- If pressed spring will send parameter ?logout that can be read -->
		<input type="submit" value="Logout">

	</form:form>

</body>
</html>