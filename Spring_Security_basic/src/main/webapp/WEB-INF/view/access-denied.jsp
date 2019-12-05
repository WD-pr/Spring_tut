<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>

<html>

<head>
<title>Access Denied</title>
</head>

<body>
	<h2>Access Denied</h2>
	<hr>
	<p>You are not authorized to access the resource !</p>

	<hr>

<a href="${pageContext.request.contextPath}/home"> -- > Back to Home</a>
	
</body>
</html>