package daos;

import modelo.Coche;

//en entorno corporativo lo mas normal del mundo es 
//definir las operaciones que se van a a poder hacer sobre
//base de datos en una interfaz
//
//en este caso,para el interfaz actual, cada metodo
//dira que se puede hacer en base de datos de cara a Coches

public interface CochesDAO {
	void registrarCoche(Coche c);
	void borrarCoche(int id);
	Coche[] obtenerCoches();
	//un array es un conjunto de datos del mismo tipo
	void imple();
}
