<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Bootstrap Example</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>

	<c:import url="/WEB-INF/jsp/menu.jsp" />

	<c:set var="titulo" value="Cadastro de Contas" />
	<c:set var="rota" value="/conta/incluir" />
	<c:set var="metodo" value="post" />
	<c:set var="botao" value="Cadastrar" />

	<c:if test="${not empty conta}">
		<c:set var="titulo" value="Consulta de Contas" />
		<c:set var="rota" value="/voltar" />
		<c:set var="metodo" value="get" />
		<c:set var="botao" value="Voltar" />

	</c:if>

	<div class="container">
		<h2>${titulo}</h2>

		<c:if test="${not empty mensagem}">
			<div class="alert alert-success alert-dismissible">
				<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
				<strong>Successo! </strong>${mensagem}
			</div>
		</c:if>

		<form action="${rota}" method="${metodo}">

			<div class="form-group">
				<label>Conta:</label> <input type="text" class="form-control"
					placeholder="Informe a descri��o" value="${conta.descricao}" name="descricao" placeholder="Entre com o nome da conta">
			</div>

			<div class="form-group">
				<label>Tipo da Conta:</label> <input type="text"
					class="form-control" value="${conta.tipoConta}" name="tipoConta" placeholder="Entre com o tipo da conta">
			</div>
			<button type="submit" class="btn btn-default">${botao}</button>
		</form>

	</div>

</body>
</html>