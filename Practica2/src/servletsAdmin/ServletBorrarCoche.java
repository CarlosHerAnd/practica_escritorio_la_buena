package servletsAdmin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daos.CochesDAO;
import daosImpl.CochesDAOImpl;



@WebServlet("/admin/ServletBorrarCoche")
public class ServletBorrarCoche extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		System.out.println("borrar coche de id: " + id);
		CochesDAO cochesDAO = new CochesDAOImpl();
		
		cochesDAO.borrarcoche(id);
		request.getRequestDispatcher("ServletListadoCochesAdmin").forward(request, response);
	}

}
