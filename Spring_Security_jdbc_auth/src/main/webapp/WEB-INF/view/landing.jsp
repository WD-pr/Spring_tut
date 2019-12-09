<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>

<html>

<head>
<title>Landing Page</title>
</head>

<body>
	<h2>Landing Page</h2>
	<hr>
	<p>Welcome to the Landing Page !!!</p>

	<hr>

	<p>
		<a href="${pageContext.request.contextPath}/home"> -- LOGIN -- </a>
	</p>
</body>
</html>