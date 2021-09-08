<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">
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

	<div class="container">
		<c:if test="${not empty mensagem}">
			<div class="alert alert-success alert-dismissible">
				<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
				<strong>Successo! </strong>${mensagem}
			</div>
		</c:if>

		<h3>
			<a href="/depto">Incluir um novo departamento</a>
		</h3>

		<c:if test="${not empty deptos}">

			<h2>Lista de Departamentos: ${deptos.size()}</h2>

			<form action="/depto/ordenar" method="post">
				<div class="input-group">

					<select name="sortBy" class="form-control">
						<option value="codDepto">Código</option>
						<option value="descricao">Descrição</option>
					</select>

					<div class="input-group-btn">
						<button class="btn btn-default" type="submit">
							<i class="glyphicon glyphicon-sort-by-alphabet"></i>
						</button>
					</div>
				</div>

			</form>
			<table class="table table-striped">
				<thead>
					<tr>
						<th>Id</th>
						<th>Código</th>
						<th>Descrição</th>
						<th>Status</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="depto" items="${deptos}">
						<tr>
							<td>${depto.id}</td>
							<td>${depto.codDepto}</td>
							<td>${depto.descricao}</td>
							<td>${depto.status.descricao}</td>
							<td><a href="/depto/${depto.id}/excluir">Excluir</a></td>
							<td><a href="/depto/${depto.id}/consultar">Detalhar</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:if>
		<c:if test="${empty deptos}">
			<h2>Não existem departamentos cadastrados!!!</h2>
		</c:if>

	</div>

</body>
</html>