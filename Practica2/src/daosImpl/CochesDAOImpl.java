package daosImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;





import modelo.Coche;
import daos.CochesDAO;
import daos.ConstantesSQL;
import daos.GenericDAO;

public class CochesDAOImpl extends GenericDAO implements CochesDAO{

	@Override
	public void registrarCoche(Coche coche) {
		conectar();
			try {
				PreparedStatement ps = miConexion.prepareStatement(ConstantesSQL.INSERCION_COCHE);
				ps.setString(1, coche.getMarca());
				ps.setString(2, coche.getModelo());
				ps.setString(3, coche.getColor());
				ps.setString(4, coche.getMatricula());
				ps.setString(5, coche.getNumero());
				ps.setString(6, coche.getAsientos());
				ps.setString(7, coche.getTraccion());
				ps.execute();
				ps.close();
				
			} catch (SQLException e) {
				System.out.println("la sql de inseccion de coche esta mal");
			}
			
		
		desconectar();
	}//end registrarcoche

	@Override
	public List<Coche> obtenerCoches() {
		conectar();
		List<Coche> coches = new ArrayList<Coche>();
		try {
			PreparedStatement ps = miConexion.prepareStatement(ConstantesSQL.SELECCION_COCHES);
			ResultSet resultado = ps.executeQuery();
			while(resultado.next()){
				Coche coche = new Coche();
				coche.setMarca(resultado.getString("Marca"));
				coche.setModelo(resultado.getString("Modelo"));
				coche.setColor(resultado.getString("Color"));
				coche.setMatricula(resultado.getString("Matricula"));
				coche.setNumero(resultado.getString("Numero"));
				coche.setAsientos(resultado.getString("Asientos"));
				coche.setTraccion(resultado.getString("Traccion"));
				coche.setId(resultado.getInt("id"));
				coches.add(coche);
				
				
			}//end while
		} catch (SQLException e) {
			System.out.println("SQL select coches esta mal");
		}//end catch
		desconectar();
		return coches;
	}//end obtenercoches



	@Override
	public void borrarcoche(int id) {
		conectar();
		try{
			PreparedStatement ps = miConexion.prepareStatement(ConstantesSQL.BORRAR_COCHE);
			ps.setInt(1, id);
			ps.execute();
			ps.close();
		} catch(SQLException e){
			System.out.println("SQL borrar anuncios esta mal");
		}
		desconectar();
	}

	@Override
	public void guardarCambioscoche(Coche coche) {
		conectar();
		try {
			PreparedStatement ps = miConexion
					.prepareStatement(ConstantesSQL.GUARDAR_CAMBIOS_COCHES);
			ps.setString(1, coche.getMarca());
			ps.setString(2, coche.getModelo());
			ps.setString(3, coche.getColor());
			ps.setString(4, coche.getMatricula());
			ps.setString(5, coche.getNumero());
			ps.setString(6, coche.getAsientos());
			ps.setString(7, coche.getTraccion());
			ps.setInt(8, coche.getId());
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			System.out.println("posiblemente la sql de guardar cambios coche este mal");
			System.out.println(e.getMessage());
		}
		desconectar();
		
	}

	@Override
	public Coche obtenercochePorId(int id) {
		conectar();
		Coche coche = new Coche();
		try {
			PreparedStatement ps = miConexion
					.prepareStatement(ConstantesSQL.OBENER_COCHE_POR_ID);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				coche.setMarca(rs.getString("Marca"));
				coche.setModelo(rs.getString("Modelo"));
				coche.setColor(rs.getString("Color"));
				coche.setMatricula(rs.getString("Matricula"));
				coche.setNumero(rs.getString("Numero"));
				coche.setAsientos(rs.getString("Asientos"));
				coche.setTraccion(rs.getString("Traccion"));
				
				coche.setId(id);
			}// end if
			ps.close();
		} catch (SQLException e) {
			System.out.println("seguramente la SQL este mal");
			System.out.println(e.getMessage());
		}

		desconectar();
		return coche;
	}



}//end class
