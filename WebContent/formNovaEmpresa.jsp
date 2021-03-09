<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/novaEmpresa" var="linkServletNovaEmpresa"/>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Cadastrar nova empresa</title>
</head>
<body>

	<form action="${ linkServletNovaEmpresa }" method="post">
		<label for="nome">Nome: </label>
		<input type="text" name="nome">
		<label for="nome">Data: </label>
		<input type="text" name="data">
		<button>Enviar</button>
	</form>

</body>
</html>