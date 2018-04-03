package servletsAdmin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daos.CochesDAO;
import daosImpl.CochesDAOImpl;
import modelo.Coche;

@WebServlet("/admin/ServletGuardarCambiosCoche")
public class ServletGuardarCambiosCoche extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String marca = request.getParameter("campoMarca");
		String modelo = request.getParameter("campoModelo");
		String color = request.getParameter("campoColor");
		String matricula = request.getParameter("campoMatricula");
		String numero = request.getParameter("campoNumero");
		String asientos = request.getParameter("campoAsientos");
		String traccion = request.getParameter("campoTraccion");
		String id = request.getParameter("campoId");
		
		//ahora deberiamos validar todos los datos
		//..
		//fin parte validacion
		Coche coche = new Coche(marca, modelo, color, matricula, numero, asientos, traccion);
		coche.setId(Integer.parseInt(id));
		System.out.println("voy a guardar : "+coche.toString());
		CochesDAO cochesDAO = new CochesDAOImpl();
		cochesDAO.guardarCambioscoche(coche);
		
		request.getRequestDispatcher("ServletListadoCochesAdmin").forward(request, response);
		
		
	}//end service

}//end class
