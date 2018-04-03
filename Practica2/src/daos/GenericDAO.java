package daos;

import java.net.ConnectException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import modelo.Cliente;

public abstract class GenericDAO {
	
		protected Connection miConexion = null ;
//esta clase no se puede usar para hacer objetos solo para heredar
	//carga del drier de conexion de jdbc:
	
	static{
		//bloque especial que se ejecuta una unica vez a lo largo de la app la primera vez que esta 
		//clase es usada
		try {
			Class.forName("com.mysql.jdbc.Driver");

		} catch (ClassNotFoundException e) {
			System.out.println("no encuentro el driver ");
		} 
		
	}//end static
	 
	protected void conectar(){
		try {
			miConexion = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/portal_web", "root",
					"jeveris");
		} catch (SQLException e) {
			System.out.println("no puede conectarme a la base de datos");
			System.out.println("comprobar ruta de la base de datos");
			System.out.println("comprobar base de datos y contraseña");
		}
		
	}//end conectar
	 protected void desconectar (){
		 try {
			miConexion.close();
		} catch (SQLException e) {
			System.out.println("no pude realizar la desconexion");
		}
	 }//end desconectar

	
	}//end class
