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

	<div class="container">
		<c:if test="${not empty mensagem}">
			<div class="alert alert-success alert-dismissible">
				<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
				<strong>Successo! </strong>${mensagem}
			</div>
		</c:if>

		<h3>
			<a href="/conta">Incluir uma nova conta</a>
		</h3>

		<c:if test="${not empty contas}">

			<h2>Lista de contas: ${contas.size()}</h2>

			<form action="/conta/ordenar" method="post">
				<div class="input-group">

					<select name="sortBy" class="form-control">
						<option value="descricao">Descrição</option>
						<option value="tipoConta">Tipo da Conta</option>
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
						<th>Conta</th>
						<th>Tipo</th>
						<th>Status</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="conta" items="${contas}">
						<tr>
							<td>${conta.id}</td>
							<td>${conta.descricao}</td>
							<td>${conta.tipoConta.descricao}</td>
							<td>${conta.status.descricao}</td>
							<td><a href="/conta/${conta.id}/excluir">Excluir</a></td>
							<td><a href="/conta/${conta.id}/consultar">Detalhar</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:if>
		<c:if test="${empty contas}">
			<h2>Não existem contas cadastradas!!!</h2>
		</c:if>

	</div>

</body>
</html>