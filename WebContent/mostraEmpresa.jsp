<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<c:url value="/editarEmpresa" var="linkServletEditaEmpresa"/>
<fmt:parseDate value="${ data }" pattern="yyyy-MM-dd" var="parsedDate"/>
<fmt:formatDate value="${ parsedDate }" pattern="dd/MM/yyyy" var="newDate"/>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Edita empresa</title>
</head>
<body>

	<form action="${ linkServletEditaEmpresa }" method="post">
		<label for="nome">Nome: </label>
		<input type="text" name="nome" value="${ empresa }">
		<label for="nome">Data: </label>
		<input type="text" name="data" value="${ newDate }">
		<button>Enviar</button>
	</form>

</body>
</html>