<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>

<head>
<title>Customn Login Page</title>

<style>
.failed {
	color: red;
	text-transform: capitalize;
}
</style>

</head>

<body>
	<h3>Login Page</h3>
	<hr>

	<!-- Spring Form automatically adds CSRF (Cross-Site Request Forgery) token for security -
	 adds sth like this: 
	 <input type="hidden" name="_csrf" value="f6dc6964-00b5-4e0a-a37f-43daa89f89ca" /> 
	 
	If using plain html form tag have to add csrf to every request manually if not there will be 403 error thrown.
	Manual token when using plain form tag:
	
	<input type="hidden" name="${_csrf.parameterName} value="${_csrf.token}"
	
	 -->
	
	<form:form action="${pageContext.request.contextPath}/authenticateUser"
		method="POST">

		<c:if test="${param.error != null}">

			<i class="failed">Invalid credentials.</i>

		</c:if>

		<p>
			User name: <input type="text" name="username" />
		</p>

		<p>
			Password: <input type="password" name="password" />
		</p>

		<input type="submit" value="Login">

	</form:form>


</body>
</html>