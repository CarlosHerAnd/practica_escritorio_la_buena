package daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.Coche;



public class CochesDAOImpl implements CochesDAO {

	private Connection miConexion = null;

	public CochesDAOImpl() {
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

	}// end CochesDAOimpl

	@Override
	public void registrarCoche(Coche c) {
		// de esta forma le decimos a la base de datos que esta es
		// la sql que queremos lanzar con este caso 5 variables
		// cuando le digamos a la base de datos cual es cada variable
		// no se podra inyectar sql,porque la base de datos espera
		// valiables del tipo indicado: por ejemplo la primera '?'
		// tiene que ser un marca valido correspondiente al tipo de dato
		// de marca en la base de datos

		PreparedStatement ps;
		try {
			ps = miConexion.prepareStatement(ConstantesSQL.sqlInsercionCoche);

			ps.setString(1, c.getMarca());
			ps.setString(2, c.getModelo());
			ps.setString(3, c.getColor());
			ps.setString(4, c.getMatricula());
			ps.setString(5, c.getNumero());
			ps.setString(6, c.getAsientos());
			ps.setString(7, c.getTraccion());

			ps.execute();
			ps.close();
			System.out.println("Coche insertado correctamente");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		// lo siguiente no vale por ser vulnerable a inyecciones sql

		// statementInsercionCoche.executeUpdate(sqlInsercionCoche);
		// System.out.println("inserccion realizada correctamente");
		// statementInsercionCoche.close();

	}// end registrarCoche

	@Override
	public void borrarCoche(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Coche[] obtenerCoches() {
		Coche[] Coches = null;
		try {
			PreparedStatement ps = miConexion
					.prepareStatement(ConstantesSQL.sqlSeleccionCoche);
			// para sql tipo select debo usar el metodo executequery
			ResultSet resultado = ps.executeQuery();
			List<Coche> listCoches = new ArrayList<Coche>();
			while (resultado.next()) { // Next pasa a la siguiente base de datos
										// que aun no hemos porcesado,si no hay
										// ninigun resultado mas devuelve false
				modelo.Coche c = new Coche();
				c.setMarca(resultado.getString("marca"));
				c.setModelo(resultado.getString("modelo"));
				c.setMatricula(resultado.getString("matricula"));
				c.setColor(resultado.getString("color"));
				c.setNumero(resultado.getString("numero"));
				c.setAsientos(resultado.getString("Asientos"));
				c.setTraccion(resultado.getString("traccion"));
				listCoches.add(c);
			}// end while
				// transformar de list a array
			Coches = listCoches.toArray(new Coche[listCoches.size()]);

		} catch (SQLException e) {
			System.out.println("FALLO EN LA SQL DE SELCCION CocheS");
			// para monstrar errores System.out.println(e.getMessage());
			return null;
		}// END catch
		return Coches;
	}// END obtenerCoches

	@Override
	public void imple() {
		// TODO Auto-generated method stub

	}



}
