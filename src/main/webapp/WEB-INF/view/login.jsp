<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>Login</title>
<style type="text/css">
	.error {
		color: crimson;
	}
</style>
</head>
<body>

	<h3>Login</h3>

	<form:form action="${pageContext.request.contextPath}/authenticate" method="POST">
		<c:if test="${param.error != null}">
			<i class="error">Sorry, incorrect credentials.</i>
		</c:if>
	
		<p>
			User name: <input type="text" name="username" />
		</p>
		<p>
			Password: <input type="password" name="password" />
		</p>
		
		<input type="submit" value="Login" />
	</form:form>

</body>
</html>