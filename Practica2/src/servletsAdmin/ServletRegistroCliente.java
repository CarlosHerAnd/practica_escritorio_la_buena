package servletsAdmin;

import java.io.IOException;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;









import daos.ClientesDAO;
import daosImpl.ClientesDAOImpl;
import modelo.Cliente;

@WebServlet("/admin/ServletRegistroCliente")
public class ServletRegistroCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//protegemos este servlet por si se intenta acceder a el directamente
		//sin estar identificado
		System.out.println("llega hasta el dopost");
		if(request.getSession().getAttribute("admin")==null){
			request.getRequestDispatcher("login.jsp").forward(request, response);
			System.out.println("se mete en el session");
			return;
		}
		System.out.println("ha pasado del if");
		System.out.println("se ejecuta el post del ServletRegistroCoche");
		//recogemos lo que ha introducido el usuario del formulario
		//campoTitulo es el name del input del que quiero coger la informacion
		String nombre = request.getParameter("campoNombre");
		String calle = request.getParameter("campoCalle");
		String numeracion = request.getParameter("campoNumeracion");
		String codigo_postal = request.getParameter("campoCodigo_postal");
		String poblacion = request.getParameter("campoPoblacion");
		String telefono = request.getParameter("campoTelefono");
		String email = request.getParameter("campoEmail");
		String particularoempresa = request.getParameter("campoParticularoempresa");
		
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
	Cliente nuevoCliente = new Cliente(nombre, calle, numeracion, codigo_postal, poblacion, telefono, email, particularoempresa);
	//ahora le damos el nuevo anuncio a un dao para que lo registre
	System.out.println("vamos a registrar: " + nuevoCliente.toString());
	ClientesDAO clientesDAO = new ClientesDAOImpl();
	clientesDAO.registrarCliente(nuevoCliente);
	//desde un servlet no debier mostrarle nada al usuario para eso tenemos las jsp
	//que son las encargadas de realizar la "vista" de la aplicacionr
	//asi digo al server que siga la ejecucion en la siguiente jsp
	request.getRequestDispatcher("registroClienteOK.jsp").forward(request, response);
	}//end doPost

}//end Class