<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>

<title>Person Confirmation Page</title>

</head>

<body>

	Registration confirmed for ${person.firstName} ${person.lastName}.
	<br> Postal Code: ${person.postalCode}
	<br> Country: ${person.country}
	<br> Height: ${person.height}
	<br> Chose programming language: ${person.programmingLanguage}
	<br> Chose operating systems:


	<!-- Looping over an array -->
	<ul>
		<c:forEach var="temp" items="${person.operatingSystems}">
			<li>${temp}</li>
		</c:forEach>
	</ul>


</body>
</html>