<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<body>Xesque

<form:form action="${pageContext.request.contextPath}/logout" method="POST">
	<button type="submit">Log out</button>
</form:form>
</body>
</html>