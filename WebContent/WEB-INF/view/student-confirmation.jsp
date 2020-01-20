<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<body>
	<h2>Confirmed: ${student.firstName} ${student.lastName}</h2>
	<h2>${student.gender}</h2>
	<h2>from: ${student.country}</h2>
	<ul>
		<c:forEach  var="xesque" items="${student.operatingSystems}">
			<li>${xesque}</li>
		</c:forEach>
	</ul>
</body>
</html>