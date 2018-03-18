package daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.omg.CORBA.PUBLIC_MEMBER;

import modelo.Cliente;

public class ClientesDAOImpl implements ClientesDAO {

	private Connection miConexion = null;

	public ClientesDAOImpl() {
		// Preparo driver y conexion

		try {
			Class.forName("com.mysql.jdbc.Driver");
			miConexion = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/practica_escritorio", "root",
					"jeveris");
		} catch (ClassNotFoundException e) {
			System.out.println("no encuentro el driver ");
		} catch (SQLException e) {
			System.out.println("error de conexion o la sql esta mal");
			;
		}

	}// end clientesDaoimpl

	@Override
	public void registrarCliente(Cliente c) {

		// de esta forma le decimos a la base de datos que esta es
		// la sql que queremos lanzar con este caso 5 variables
		// cuando le digamos a la base de datos cual es cada variable
		// no se podra inyectar sql,porque la base de datos espera
		// valiables del tipo indicado: por ejemplo la primera '?'
		// tiene que ser un nombre valido correspondiente al tipo de dato
		// de nombre en la base de datos

		PreparedStatement ps;
		try {
			ps = miConexion.prepareStatement(ConstantesSQL.sqlInsercionCliente);
			ps.setString(5, c.getTelefono());
			ps.setString(1, c.getNombre());
			ps.setString(2, c.getDomicilio());
			ps.setString(3, c.getPobalcion());
			ps.setString(4, c.getCodigoPostal());
			ps.execute();
			ps.close();
			System.out.println("cliente insertado correctamente");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		// lo siguiente no vale por ser vulnerable a inyecciones sql

		// statementInsercionCliente.executeUpdate(sqlInsercionCliente);
		// System.out.println("inserccion realizada correctamente");
		// statementInsercionCliente.close();

	}// end registrarCliente

	@Override
	public void borrarCliente(int id) {
		try {
			PreparedStatement ps = miConexion.prepareStatement(ConstantesSQL.sqlBorradoCliente);
			ps.setInt(1, id);
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			System.out.println("la SQL de borrado esta mal");
			System.out.println(e.getMessage());
		}

	}//end borrar cliente

	@Override
	public Cliente[] obtenerClientes() {
		Cliente[] clientes = null;
		try {
			PreparedStatement ps = miConexion
					.prepareStatement(ConstantesSQL.sqlSeleccionCliente);
			// para sql tipo select debo usar el metodo executequery
			ResultSet resultado = ps.executeQuery();
			List<Cliente> listClientes = new ArrayList<Cliente>();
			while (resultado.next()) { // Next pasa a la siguiente base de datos
										// que aun no hemos porcesado,si no hay
										// ninigun resultado mas devuelve false
				Cliente c = new Cliente();
				c.setNombre(resultado.getString("nombre"));
				c.setDomicilio(resultado.getString("domicilio"));
				c.setCodigoPostal(resultado.getString("Codigo_Postal"));
				c.setPobalcion(resultado.getString("Poblacion"));
				c.setTelefono(resultado.getString("Telefono"));
				c.setId(resultado.getInt("id"));
				listClientes.add(c);
			}// end while
				// transformar de list a array
			clientes = listClientes.toArray(new Cliente[listClientes.size()]);

		} catch (SQLException e) {
			System.out.println("FALLO EN LA SQL DE SELCCION CLIENTES");
			// para monstrar errores System.out.println(e.getMessage());
			return null;
		}// END catch
		return clientes;
	}// END obtenerClientes

	@Override
	public void imple() {
		// TODO Auto-generated method stub

	}

}// end class
