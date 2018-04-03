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
<form action="ServletGuardarCambiosCliente" method="post">
	nombre: <input type="text" name="campoNombre" value="${ clienteAeditar.nombre }"/><br/>
	calle: <input type="text" name="campoCalle"value="${ clienteAeditar.calle }"/><br/>
	numeracion: <input type="text" name="campoNumeracion"value="${ clienteAeditar.numeracion }"/><br/>
	codigo_postal: <input type="text" name="campoCodigo_postal"value="${ clienteAeditar.codigo_postal }"/><br/>
	poblacion: <input type="text" name="campoPoblacion"value="${ clienteAeditar.poblacion }"/><br/>
	telefono: <input type="text" name="campoTelefono"value="${ clienteAeditar.telefono }"/><br/>
	email: <input type="text" name="campoEmail"value="${ clienteAeditar.email }"/><br/>
	particularoempresa: <input type="text" name="campoParticularoempresa"value="${ clienteAeditar.particularoempresa }"/><br/>
	<input type="hidden" name="campoId" value="${clienteAeditar.id }"/>
	<br/>
	<input type="submit" value="GUARDAR CAMBIOS"/>

</form>

</body>
</html>