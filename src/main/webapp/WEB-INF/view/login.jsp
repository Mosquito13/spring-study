<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Login</title>
<style type="text/css">
* {
	box-sizing: border-box;
	font-family: Arial, Helvetica, sans-serif;
}

html, body {
	margin: 0;
	padding: 0;
	overflow: hidden;
}

.container {
	width: 100%;
	height: 100%;
	display: flex;
	justify-content: center;
}

.form-group {
	margin-top: 2rem;
	border: 2px solid cadetblue;
	border-radius: 10px;
}

.title {
	background-color: cadetblue;
	color: white;
	padding: 1rem;
	font-size: 18px;
}

.message {
	padding: 1rem;
	margin: 1rem 1rem 0 1rem;
	border: 2px solid;
	border-radius: 5px;
	font-weight: 600;
}

.message.error {
	border-color: darkred;
	background-color: darksalmon;
	color: darkred;
}

.message.info {
	border-color: darkolivegreen;
	background-color: lightgreen;
	color: darkolivegreen;
}

.form-control:first-of-type {
	padding-top: 1rem;
}

.form-control {
	width: 100%;
	display: flex;
	flex-direction: column;
	padding: 0 1rem 1rem;
}

.submit {
	width: 100%;
	padding: 1rem;
	background-color: lightblue;
	border: none;
	border-radius: 5px;
	color: midnightblue;
	font-size: 18px;
	cursor: pointer;
	outline: none;
}

.submit:hover {
	background-color: cornflowerblue;
}
</style>
</head>
<body>

	<div class="container">
		<div class="form-group">
			<div class="title">
				<span>Sign in</span>
			</div>
			<c:if test="${param.error != null}">
			<div class="message error">
				<span>Sorry, incorrect credentials</span>
			</div>
			</c:if>
			<c:if test="${param.logout != null}">
			<div class="message info">
				<span>Successfully logged out</span>
			</div>
			</c:if>
			<form:form action="${pageContext.request.contextPath}/authenticate" method="POST">
				<div class="form-control">
					<label for="username">User</label>
					<input type="text" name="username" id="username" />
				</div>
				<div class="form-control">
					<label for="password">Password</label>
					<input type="password" name="password" id="password" />
				</div>
				<div class="form-control">
					<button type="submit" class="submit">Login</button>
				</div>
			</form:form>
		</div>
	</div>

</body>
</html>