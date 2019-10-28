<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>

<title>Person Registration Page</title>

</head>

<body>

	<form:form action="processForm" modelAttribute="person">

	First name: <form:input path="firstName" />
		<br>
		<br>
	Last name: <form:input path="lastName" />
		<br>
		<br>
		<!-- Manual options -->
		<%-- <form:select path="country">
			<form:option value="Germany"/>
			<form:option value="Poland" label="PL"/>
			<form:option value="Austria" />
			<form:option value="Spain" />
		</form:select> --%>

		<!-- Counties options retrieved from Person -->
		<%-- <form:select path="country">
			<form:options items="${person.countriesList}" />
		</form:select>
		 --%>

		<!-- Counties options retrieved  from properties file using - spring util -->
		<form:select path="country">
			<form:options items="${countriesMap}" />
		</form:select>

		<br>
		<!-- Manual radio buttons -->
		<%-- Java <form:radiobutton path="programmingLanguage" value="Java"/>
		PHP <form:radiobutton path="programmingLanguage" value="PHP"/>
		C# <form:radiobutton path="programmingLanguage" value="C#"/>
		JavaScript <form:radiobutton path="programmingLanguage" value="JavaScript"/> --%>

		<!-- Languages retrieved from properties file using - spring util -->
		<form:radiobuttons path="programmingLanguage"
			items="${programmingLanguagesMap}" />

		<!-- Counties options retrieved from Person -->
		<br>
		<form:checkboxes path="operatingSystems"
			items="${person.operatingSystemsList}" />

		<br>
		<input type="submit" value="Submit">

	</form:form>

</body>
</html>