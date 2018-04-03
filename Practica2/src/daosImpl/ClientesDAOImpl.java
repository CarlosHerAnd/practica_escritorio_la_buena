package daosImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;





import modelo.Cliente;
import daos.ClientesDAO;
import daos.ConstantesSQL;
import daos.GenericDAO;

public class ClientesDAOImpl extends GenericDAO implements ClientesDAO{

	@Override
	public void registrarCliente(Cliente cliente) {
		conectar();
			try {
				PreparedStatement ps = miConexion.prepareStatement(ConstantesSQL.INSERCION_CLIENTE);
				ps.setString(1, cliente.getNombre());
				ps.setString(2, cliente.getCalle());
				ps.setString(3, cliente.getNumeracion());
				ps.setString(4, cliente.getCodigo_postal());
				ps.setString(5, cliente.getPoblacion());
				ps.setString(6, cliente.getTelefono());
				ps.setString(7, cliente.getEmail());
				ps.setString(8, cliente.getParticularoempresa());
				ps.execute();
				ps.close();
				
			} catch (SQLException e) {
				System.out.println("la sql de inseccion de cliente esta mal");
				System.out.println(e.getMessage());
			}
			
		
		desconectar();
	}//end registrarcliente

	@Override
	public List<Cliente> obtenerClientes() {
		conectar();
		List<Cliente> clientes = new ArrayList<Cliente>();
		try {
			PreparedStatement ps = miConexion.prepareStatement(ConstantesSQL.SELECCION_CLIENTES);
			ResultSet resultado = ps.executeQuery();
			while(resultado.next()){
				Cliente cliente = new Cliente();
				cliente.setNombre(resultado.getString("nombre"));
				cliente.setCalle(resultado.getString("calle"));
				cliente.setNumeracion(resultado.getString("numeracion"));
				cliente.setCodigo_postal(resultado.getString("codigo_postal"));
				cliente.setPoblacion(resultado.getString("poblacion"));
				cliente.setTelefono(resultado.getString("telefono"));
				cliente.setEmail(resultado.getString("email"));
				cliente.setParticularoempresa(resultado.getString("particularoempresa"));
				cliente.setId(resultado.getInt("id"));
				clientes.add(cliente);
				
				
			}//end while
		} catch (SQLException e) {
			System.out.println("SQL select clientes esta mal");
		}//end catch
		desconectar();
		return clientes;
	}//end obtenerclientes

	@Override
	public boolean identificarAdmin(String email, String pass) {
		boolean identificado = false;
		conectar();
		try {
			PreparedStatement ps = miConexion.prepareStatement(ConstantesSQL.IDENTIFICACION_ADMIN);
			ps.setString(1, email);
			ps.setString(2, pass);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				//si este if se cumple, eso es que he obtenido un resultado
				//de base de datos
				identificado=true;
			}
			
		} catch (SQLException e) {
		System.out.println("La SQL de identificacion tiene problemas");
		System.out.println(e.getMessage());
		}
		desconectar();
		
		return identificado;
		
	}//end boolean
	
	@Override
	public void borrarCliente(int id) {
		conectar();
		try{
			PreparedStatement ps = miConexion.prepareStatement(ConstantesSQL.BORRAR_CLIENTE);
			ps.setInt(1, id);
			ps.execute();
			ps.close();
		} catch(SQLException e){
			System.out.println("SQL borrar anuncios esta mal");
		}
		desconectar();
	}

	@Override
	public void guardarCambiosCliente(Cliente cliente) {
		conectar();
		try {
			PreparedStatement ps = miConexion
					.prepareStatement(ConstantesSQL.GUARDAR_CAMBIOS_CLIENTES);
			ps.setString(1, cliente.getNombre());
			ps.setString(2, cliente.getCalle());
			ps.setString(3, cliente.getNumeracion());
			ps.setString(4, cliente.getCodigo_postal());
			ps.setString(5, cliente.getPoblacion());
			ps.setString(6, cliente.getTelefono());
			ps.setString(7, cliente.getEmail());
			ps.setString(8, cliente.getParticularoempresa());
			ps.setInt(9, cliente.getId());
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			System.out.println("posiblemente la sql de guardar cambios cliente este mal");
			System.out.println(e.getMessage());
		}
		desconectar();
		
	}

	@Override
	public Cliente obtenerClientePorId(int id) {
		conectar();
		Cliente cliente = new Cliente();
		try {
			PreparedStatement ps = miConexion
					.prepareStatement(ConstantesSQL.OBENER_CLIENTE_POR_ID);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				cliente.setNombre(rs.getString("nombre"));
				cliente.setCalle(rs.getString("calle"));
				cliente.setNumeracion(rs.getString("numeracion"));
				cliente.setCodigo_postal(rs.getString("codigo_postal"));
				cliente.setPoblacion(rs.getString("poblacion"));
				cliente.setTelefono(rs.getString("telefono"));
				cliente.setEmail(rs.getString("email"));
				cliente.setParticularoempresa(rs.getString("particularOempresa"));
				
				cliente.setId(id);
			}// end if
			ps.close();
		} catch (SQLException e) {
			System.out.println("seguramente la SQL este mal");
			System.out.println(e.getMessage());
		}

		desconectar();
		return cliente;
	}




}//end class
