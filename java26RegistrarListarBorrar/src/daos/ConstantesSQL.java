package daos;

public class ConstantesSQL {
	final static String sqlInsercionCliente =
		"insert into tabla_clientes (nombre,domicilio,poblacion,codigo_postal,telefono)values (?,?,?,?,?);";
	final static String sqlSeleccionCliente =
			"select * from tabla_clientes";
	final static String sqlInsercionCoche = "insert into tabla_coches (marca,modelo,color,matricula,numero,asientos,traccion)values (?,?,?,?,?,?,?);";
		final static String sqlSeleccionCoche = "select * from tabla_coches";
	final static String sqlBorradoCliente =
				"delete from tabla_clientes where id=? ";
	final static String sqlBorradoCoche =
			"delete from tabla_coches where id=? ";

}