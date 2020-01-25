<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>List customers</title>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css" />
</head>
<body>

	<div class="wrapper">
		<div class="header">
			<h2>CRM - Customer Relationship Manager</h2>
		</div>
	</div>

	<div class="container">
		<div class="content">

			<input type="button" value="Add customer" class="add-button"
				onclick="window.location.href = 'add'; return false;" />

			<table>
				<tr>
					<th>First name</th>
					<th>Last name</th>
					<th>E-mail</th>
				</tr>

				<c:forEach var="customer" items="#{customers}">
					<tr>
						<td>${customer.firstName}</td>
						<td>${customer.lastName}</td>
						<td>${customer.email}</td>
					</tr>
				</c:forEach>

			</table>
		</div>
	</div>

</body>
</html>