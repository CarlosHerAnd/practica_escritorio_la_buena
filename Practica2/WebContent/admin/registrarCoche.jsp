<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<a href="index.jsp">volver a inicio</a>
Introduce los datos de anuncio:<br/>
<form action="ServletRegistroCoche" method="post">
	marca <input type ="text" name="campoMarca"/> <br/>
	modelo <input type= "text" name="campoModelo"/> <br/>
	color <input type= "text" name="campoColor"/> <br/>
	matricula <input type= "text" name="campoMatricula"/> <br/>
	numero <input type= "text" name="campoNumero"/> <br/>
	asientos <input type= "text" name="campoAsientos"/> <br/>
	traccion <input type= "text" name="campoTraccion"/> <br/>

	<input type = "submit"	value="Aceptar"/>
</form>	
</body>
</html>