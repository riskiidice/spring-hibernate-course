<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hello World - Input Form</title>
</head>
<body>
	<form:form methodd="GET" action="processForm" modelAttribute="student">
		First name:  <form:input path="firstName" />
		<br/><br/>
		Last name: <form:input path="lastName" />
		<br/><br/>
		<form:select path="country">
			<form:options items="${student.countryOptions}"/>		
		</form:select>	
		<br/><br/>
		Favorite Language:
		Java: <form:radiobutton path="favoriteLanguage" value="Java" />
		Python: <form:radiobutton path="favoriteLanguage" value="Python" />
		PHP: <form:radiobutton path="favoriteLanguage" value="PHP" />
		Ruby: <form:radiobutton path="favoriteLanguage" value="Ruby" />
		<br/><br/>
		Operating Systems:
		Linux: <form:checkbox path="operatingSystems" value="Linux" />
		Mac OS: <form:checkbox path="operatingSystems" value="Mac Os" />
		Ms Windows: <form:checkbox path="operatingSystems" value="Ms Windows" />
		<br/><br/>
		<input type="submit" value="submit" /> 
	</form:form>
</body>
</html>