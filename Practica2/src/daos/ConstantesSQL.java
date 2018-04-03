package daos;

public class ConstantesSQL {
 
	public static final String INSERCION_COCHE = "insert into tabla_coches(marca,modelo,color,matricula,numero,asientos,traccion)values(?,?,?,?,?,?,?)";
	public static final String INSERCION_CLIENTE = "insert into tabla_clientes(nombre,calle,numeracion,codigo_postal,poblacion,telefono,email,particularoempresa)values(?,?,?,?,?,?,?,?)";
	
	public static final String SELECCION_COCHES ="select * from tabla_coches";
	public static final String SELECCION_CLIENTES ="select * from tabla_clientes";
	public static final String IDENTIFICACION_CLIENTE = "select id from tabla_clientes where email = ? and contraseña= ? ";
	public static final String IDENTIFICACION_ADMIN = "select usuario from tabla_administradores where usuario = ? and pass= ? ";
	public static final String BORRAR_COCHE = "delete from tabla_coches where id = ? ";
	public static final String BORRAR_CLIENTE = "delete from tabla_clientes where id = ? ";
	
	public static final String OBENER_COCHE_POR_ID = "select * from tabla_coches where id = ?";
	public static final String GUARDAR_CAMBIOS_COCHES = "update tabla_coches set marca = ?, modelo = ?, color = ?, matricula = ?, numero = ?, asientos = ?, traccion = ? where id =?";
	
	public static final String OBENER_CLIENTE_POR_ID = "select * from tabla_clientes where id = ?";
	public static final String GUARDAR_CAMBIOS_CLIENTES = "update tabla_clientes set nombre = ?, calle = ?, numeracion = ?, codigo_postal = ?, poblacion = ?, telefono = ?, email = ?, particularoempresa = ? where id =?";
	
	
}
