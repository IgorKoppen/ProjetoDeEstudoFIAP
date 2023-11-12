<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista de Usuários</title>
</head>
<body>

    Lista de usuários cadastrados:

    <ol>
        <c:forEach items="${usuarios}" var="usuario">
            <li>${usuario.nome} - ${usuario.email} - <fmt:formatDate value="${usuario.dataCadastro}" /> 
            </li>
        </c:forEach>
    </ol>

    <a href="Home.jsp">Novo</a>

</body>
</html>