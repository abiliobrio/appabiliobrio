<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-BR">
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

	<c:set var="titulo" value="Cadastro de Usuário" />
	<c:set var="rota" value="/usuario/incluir" />
	<c:set var="metodo" value="post" />
	<c:set var="botao" value="Salvar" />

	<c:if test="${not empty usuario}">
		<c:set var="titulo" value="Consulta de Usuário" />
		<c:set var="rota" value="/voltarUser" />
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
				<label>Login:</label> <input type="text" class="form-control"
					placeholder="Informe o login" value="${usuario.loginUsuario}"
					name="loginUsuario" placeholder="Entre com o login de usuário">
			</div>

			<div class="form-group">
				<label>Nome:</label> <input type="text" class="form-control"
					placeholder="Informe o Nome" value="${usuario.nomeUsuario}"
					name="nomeUsuario" placeholder="Entre com o nome do usuário">
			</div>

			<div class="form-group">
				<label>E-mail:</label> <input type="text" class="form-control"
					placeholder="Informe o E-mail" value="${usuario.emailUsuario}"
					name="emailUsuario" placeholder="Entre com o e-mail do usuário">
			</div>

			<c:if test="${empty usuario}">
				<div class="form-group">
					<label>Senha:</label> <input type="password" class="form-control"
						placeholder="Informe a senha" value="${usuario.senhaUsuario}"
						name="senhaUsuario" placeholder="Entre com a Senha do usuário">
				</div>
			</c:if>

			<div class="form-group">
				<label>Tipo do Usuário:</label> <input type="text"
					class="form-control" value="${usuario.tipoUsuario}"
					name="tipoUsuario" placeholder="Entre com o tipo do Usuário">
			</div>

			<c:if test="${not empty usuario}">
				<div class="form-group">
					<label>Data de criação:</label> <input type="text"
						class="form-control" value="${usuario.dataCriacaoUsuario}"
						name="dataCriacaoUsuario">
				</div>
			</c:if>

			<button type="submit" class="btn btn-default">${botao}</button>
		</form>

	</div>

</body>
</html>