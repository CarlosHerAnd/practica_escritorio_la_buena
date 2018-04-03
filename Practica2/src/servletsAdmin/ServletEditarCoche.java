package servletsAdmin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Coche;
import daos.CochesDAO;
import daosImpl.CochesDAOImpl;

@WebServlet("/admin/ServletEditarCoche")
public class ServletEditarCoche extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		CochesDAO cochesDAO = new CochesDAOImpl();
		Coche cocheAeditar =  cochesDAO.obtenercochePorId(id);
		System.out.println("editamos: " + cocheAeditar.toString());
		request.setAttribute("cocheAeditar", cocheAeditar);
		request.getRequestDispatcher("editarCoche.jsp").forward(request, response);
	}//end service

}//end class
