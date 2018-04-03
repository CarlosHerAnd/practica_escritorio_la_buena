package servletsAdmin;

import java.io.IOException;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;






import daos.CochesDAO;
import daosImpl.CochesDAOImpl;
import modelo.Coche;

@WebServlet("/admin/ServletRegistroCoche")
public class ServletRegistroCoche extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//protegemos este servlet por si se intenta acceder a el directamente
		//sin estar identificado
		if(request.getSession().getAttribute("admin")==null){
			request.getRequestDispatcher("login.jsp").forward(request, response);
			return;
		}
		
		System.out.println("se ejecuta el post del ServletRegistroCoche");
		//recogemos lo que ha introducido el usuario del formulario
		//campoTitulo es el name del input del que quiero coger la informacion
		String marca = request.getParameter("campoMarca");
		String modelo = request.getParameter("campoModelo");
		String color = request.getParameter("campoColor");
		String matricula = request.getParameter("campoMatricula");
		String numero = request.getParameter("campoNumero");
		String asientos = request.getParameter("campoAsientos");
		String traccion = request.getParameter("campoTraccion");
		
		//parte de validacion de datos
//		String expresionRegularTitulo = "[a-zA-Z·ÈÌÛ˙¡…Õ”⁄Ò—\\s]{3,10}";
//		Pattern pattern = Pattern.compile(expresionRegularTitulo);
//		Matcher matcher = pattern.matcher(titulo);
//		if ( matcher.matches()){
//			System.out.println("titulo ok");
//		}else{
//			System.out.println("titulo no valido");
//			request.setAttribute("mensaje", "titulo no valido");
//			request.getRequestDispatcher("registrarAnuncio.jsp").forward(request, response);
//			return;
//		}
		//lo mismo con el resto de campos a continuacion
		
		
		//fin parte validacion de datos
	Coche nuevoCoche = new Coche(marca, modelo, color, matricula, numero, asientos, traccion);
	//ahora le damos el nuevo anuncio a un dao para que lo registre
	System.out.println("vamos a registrar: " + nuevoCoche.toString());
	CochesDAO cochesDAO = new CochesDAOImpl();
	cochesDAO.registrarCoche(nuevoCoche);
	//desde un servlet no debier mostrarle nada al usuario para eso tenemos las jsp
	//que son las encargadas de realizar la "vista" de la aplicacionr
	//asi digo al server que siga la ejecucion en la siguiente jsp
	request.getRequestDispatcher("registroCocheOK.jsp").forward(request, response);
	}//end doPost

}//end Class