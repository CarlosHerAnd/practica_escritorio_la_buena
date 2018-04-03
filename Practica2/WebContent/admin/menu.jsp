<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<c:if test="${sessionScope.admin == null}">
	<jsp:forward page="login.jsp"></jsp:forward>
</c:if>

<a href="ServletListadoClientesAdmin">gestionar clientes</a>&nbsp;
<a href="registrarCliente.jsp">registrar cliente</a>&nbsp;
<a href="ServletListadoCochesAdmin">gestionar coches</a>&nbsp;
<a href="registrarCoche.jsp">registrar coche</a>&nbsp;
<a href="ServletLogOutAdmin">salir</a>&nbsp;