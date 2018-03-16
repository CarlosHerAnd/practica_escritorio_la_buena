package paneles;

import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;




import tableModels.TableModelCoches;
import daos.CochesDAO;
import daos.CochesDAOImpl;
import modelo.Cliente;
import modelo.Coche;

public class PanelListadoCoches extends JPanel {
	private CochesDAO daoCoches = new CochesDAOImpl();
	private Coche[] Coches;

	public PanelListadoCoches() {
		this.add(new JLabel("Soy el panel de listado de coches"));
	}// end panellistadoCoches

	public void refrescarCoches() {
		this.Coches = daoCoches.obtenerCoches();
		JTable tabla = new JTable(new TableModelCoches(Coches));
        tabla.setPreferredScrollableViewportSize(new Dimension(500, 150));
        tabla.setFillsViewportHeight(true);

        //Create the scroll pane and add the table to it.
        JScrollPane scrollPane = new JScrollPane(tabla);

        //Add the scroll pane to this panel.
        add(scrollPane);
		removeAll();//quito todo lo que tenga antes el dentro el panel 
		this.add(scrollPane);
		
	}// end refrescarCoches

}// end class