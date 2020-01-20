<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<body>
	<form:form action="processForm" modelAttribute="student">
		First name: <form:input path="firstName" />
		<br />
		<br />
		Last name: <form:input path="lastName" />
		<br />
		<br />
		<form:select path="country">
			<form:options items="${student.countryOptions}" />
		</form:select>
		<br />
		<br />
		Gender:
		Male <form:radiobutton path="gender" value="male" />
		Female <form:radiobutton path="gender" value="female" />
		<br />
		<br />
		OS:
		Linux <form:checkbox path="operatingSystems" value="Linux" />
		MacOS <form:checkbox path="operatingSystems" value="MacOS" />
		Windows <form:checkbox path="operatingSystems" value="Windows" />
		<br />
		<br />
		<button type="submit">Submit</button>
	</form:form>
</body>
</html>