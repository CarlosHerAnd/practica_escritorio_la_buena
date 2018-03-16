package tableModels;

import javax.swing.table.AbstractTableModel;

import modelo.Cliente;
import modelo.Coche;

public class TableModelCoches extends AbstractTableModel {
	private String[] columnas = {"marca","modelo","color","matricula","numero","asientos","traccion"};
	private String datos[][] = null;
	
	public TableModelCoches(Coche[] coches) {
		//datos va aser tantos arrays de strings como clientes tenga que listar
		//cada uno de esos array debera tener tantos elementos como
		//queramos monstrar por cada columna
		datos = new String[coches.length][columnas.length];
		for (int i = 0; i < coches.length; i++) {
			Coche c = coches[i];
			datos[i][0] = c.getMarca();
			datos[i][1] = c.getModelo();
			datos[i][2] = c.getColor();
			datos[i][3] = c.getMatricula();
			datos[i][4] = c.getNumero();
			datos[i][5] = c.getAsientos();
			datos[i][6] = c.getTraccion();
		}
	}//ends tablemodelclientes
	
	@Override
	public int getColumnCount() {
		return columnas.length;
	}

	@Override
	public int getRowCount() {
		return datos.length;
	}

	@Override
	public Object getValueAt(int indiceFila , int indiceColumna) {
		return datos[indiceFila][indiceColumna];
	}

}//ends clase
