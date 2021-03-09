<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page
	import="java.util.List,br.com.alura.gerenciador.entities.Empresa"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!-- Para isto funcionar, precisa baixar o JSTL e colocar o jar 
dentro de WEB-INF/lib -->

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Java Standard Taglib</title>
</head>

<body>
	<c:if test="${ not empty empresa }">
		<fmt:parseDate value="${ data }" pattern="yyyy-MM-dd" var="parsedDate"/>
		<fmt:formatDate value="${ parsedDate }" pattern="dd/MM/yyyy" var="newDate"/>
		<p>Empresa ${ empresa } cadastrada com sucesso no dia ${ newDate }!</p> 
	</c:if>
	<p>Lista de empresas:</p>
	<ul>
		<c:forEach items="${ empresas }" var="empresa">
		<fmt:parseDate value="${ empresa.dataAbertura }" type="date" pattern="yyyy-MM-dd" var="parsedDate"/>
			<li>${ empresa.nome } - <fmt:formatDate value="${ parsedDate }" pattern="dd/MM/yyyy"/> </li>
		</c:forEach>
	</ul>
</body>
</html>