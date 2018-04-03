package servletsAdmin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daos.CochesDAO;
import daosImpl.CochesDAOImpl;

@WebServlet("/admin/ServletListadoCochesAdmin")
public class ServletListadoCochesAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("obteniendo coches para gestionarlos en administracion");
		CochesDAO cochesDAO = new CochesDAOImpl();
		request.setAttribute("coches", cochesDAO.obtenerCoches());
		request.getRequestDispatcher("gestionCoches.jsp").forward(request, response);
	
	}//end services

}//end class
