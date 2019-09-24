<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>



<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">



<style>
body {
	background-color: lightblue;
	width: 70%;
	margin: auto;
	padding: 50px;
	text-align: center;
}
</style>

</head>
<body>



	<nav>
		<div class="nav-wrapper  grey darken-4 ">
			<ul id="nav-mobile" class="left hide-on-med-and-down">
				<li><a href="login.jsp">Login</a></li>
				<li><a href="add.html">Adicionar</a></li>
				<li><a href="lista.jsp">Clientes</a></li>

			</ul>
		</div>
	</nav>
	<form action="./UpdateClient" method="post">
		<div class="card-panel z-depth-5">
			<h5 class="center">Dados do cliente</h5>
			<%@ page import="java.util.*,techWebP1.*"%>

			<table class="centered">




				<thead>
					<tr>
						<th>ID</th>
						<th>Nome</th>
						<th>Nascimento</th>
						<th>CPF</th>
						<th>Endere�o</th>
						<th>Celular</th>
					</tr>
				</thead>


			</table>



			<%
				Integer ID = Integer.valueOf(request.getParameter("id"));
				DAO dao = new DAO();
				List<Clients> clientes = dao.ShowData(ID);
				for (Clients data : clientes) {
			%>



			<div class="row">


				<div class="col s2">
					<div class="input-field">
						<input type="text" name="id" value="<%=data.getId()%>">

					</div>

				</div>
				<div class="col s2">

					<div class="input-field">
						<input type="text" name="nome" value="<%=data.getName()%>">

					</div>
				</div>


				<div class="col s2">

					<div class="input-field">
						<input type="text" name="nascimento" value="<%=data.getBirth()%>">

					</div>
				</div>


				<div class="col s2">

					<div class="input-field">
						<input type="text" name="CPF" value="<%=data.getCPF()%>">

					</div>
				</div>


				<div class="col s2">


					<div class="input-field">
						<input type="text" name="endere�o" value="<%=data.getAdress()%>">

					</div>
				</div>



				<div class="col s2">


					<div class="input-field">
						<input type="text" name="celular" value="<%=data.getCelphone()%>">

					</div>
				</div>

				<input type="submit" name="submit" value="Alterar"
					class="btn left col s12 blue darken-1">

			</div>


			<%
				}
			%>

		</div>
	</form>


	<script src="https://code.jquery.com/jquery-1.12.0.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>


</body>
</html>