package servletsAdmin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daos.ClientesDAO;
import daosImpl.ClientesDAOImpl;
import modelo.Cliente;

@WebServlet("/admin/ServletGuardarCambiosCliente")
public class ServletGuardarCambiosCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nombre = request.getParameter("campoNombre");
		String calle = request.getParameter("campoCalle");
		String numeracion = request.getParameter("campoNumeracion");
		String codigo_postal = request.getParameter("campoCodigo_postal");
		String poblacion = request.getParameter("campoPoblacion");
		String telefono = request.getParameter("campoTelefono");
		String email = request.getParameter("campoEmail");
		String particularoempresa = request.getParameter("campoParticularoempresa");
		String id = request.getParameter("campoId");
		
		//ahora deberiamos validar todos los datos
		//..
		//fin parte validacion
		Cliente cliente = new Cliente(nombre, calle, numeracion, codigo_postal, poblacion, telefono, email, particularoempresa);
		cliente.setId(Integer.parseInt(id));
		
		ClientesDAO clientesDAO = new ClientesDAOImpl();
		clientesDAO.guardarCambiosCliente(cliente);
		
		request.getRequestDispatcher("ServletListadoClientesAdmin").forward(request, response);
		
		
	}//end service

}//end class
