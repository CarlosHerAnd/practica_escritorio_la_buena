package daos;

import java.util.List;



import modelo.Coche;

public interface CochesDAO {

	void registrarCoche (Coche Coche);
	
	List <Coche> obtenerCoches();

	void guardarCambioscoche(Coche coche);

	Coche obtenercochePorId(int id);


	void borrarcoche(int id);

	
}