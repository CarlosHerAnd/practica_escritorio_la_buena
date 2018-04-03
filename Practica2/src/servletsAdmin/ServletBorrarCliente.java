package servletsAdmin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daos.ClientesDAO;
import daosImpl.ClientesDAOImpl;

@WebServlet("/admin/ServletBorrarCliente")
public class ServletBorrarCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		System.out.println("borrar cliente de id: " + id);
		ClientesDAO clientesDAO = new ClientesDAOImpl();
		
		clientesDAO.borrarCliente(id);
		request.getRequestDispatcher("ServletListadoClientesAdmin").forward(request, response);
	}

}
