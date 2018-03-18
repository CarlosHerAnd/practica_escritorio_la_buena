package paneles;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;

import tableModels.TableModelCoches;
import daos.CochesDAO;
import daos.CochesDAOImpl;
import modelo.Cliente;
import modelo.Coche;

public class PanelListadoCoches extends JPanel implements ActionListener {
	private CochesDAO daoCoches = new CochesDAOImpl();
	private Coche[] Coches;
	JTable tabla;
	JButton botonBorrar = new JButton("BORRAR");

	public PanelListadoCoches() {
		this.add(new JLabel("Soy el panel de listado de coches"));
	}// end panellistadoCoches

	public void refrescarCoches() {
		this.Coches = daoCoches.obtenerCoches();
		tabla = new JTable(new TableModelCoches(Coches));
        tabla.setPreferredScrollableViewportSize(new Dimension(750, 500));
        tabla.setFillsViewportHeight(true);

        //Create the scroll pane and add the table to it.
        JScrollPane scrollPane = new JScrollPane(tabla);		
        
        removeAll();//quito todo lo que tenga antes el dentro el panel 
		this.add(botonBorrar);
		this.add(scrollPane);
		botonBorrar.addActionListener(this);
	}// end refrescarCoches

	public void actionPerformed(ActionEvent e) {
		// por si tanto no se selecciona una fila como si pulso el boton repetidas veces
		if (tabla.getSelectedRow() == -1) {
			return;
		}

		JOptionPane.showMessageDialog(null, "borrar: " + Coches[tabla.getSelectedRow()].toString());
		daoCoches.borrarCoche(Coches[tabla.getSelectedRow()].getId());
		refrescarCoches();
		SwingUtilities.updateComponentTreeUI(this);

	}// END PERFORMED

}// end class