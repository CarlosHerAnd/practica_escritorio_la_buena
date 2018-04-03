<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="menu.jsp"></jsp:include>
<form action="ServletGuardarCambiosCoche" method="post">
	marca: <input type="text" name="campoMarca" value="${ cocheAeditar.marca}"/><br/>
	modelo: <input type="text" name="campoModelo"value="${ cocheAeditar.modelo }"/><br/>
	color: <input type="text" name="campoColor"value="${ cocheAeditar.color }"/><br/>
	matricula: <input type="text" name="campoMatricular"value="${ cocheAeditar.matricula }"/><br/>
	numero: <input type="text" name="campoNumero"value="${ cocheAeditar.numero }"/><br/>
	asientos: <input type="text" name="campoAsientos"value="${ cocheAeditar.asientos }"/><br/>
	traccion: <input type="text" name="campoTraccion"value="${ cocheAeditar.traccion }"/><br/>
	<input type="hidden" name="campoId" value="${cocheAeditar.id }"/>
	<br/>
	<input type="submit" value="GUARDAR CAMBIOS"/>

</form>

</body>
</html>