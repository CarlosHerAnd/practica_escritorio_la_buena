package daos;

import java.util.List;

import modelo.Cliente;

public interface ClientesDAO {

	void registrarCliente (Cliente cliente);
	
	List <Cliente> obtenerClientes();

	void borrarCliente(int id);

	Cliente obtenerClientePorId(int id);
	
	void guardarCambiosCliente(Cliente cliente);

	boolean identificarAdmin(String email, String pass);



	
}
