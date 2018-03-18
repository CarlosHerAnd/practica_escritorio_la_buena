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







import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;

import tableModels.TableModelClientes;
import daos.ClientesDAO;
import daos.ClientesDAOImpl;
import modelo.Cliente;

public class PanelListadoClientes extends JPanel implements ActionListener {
	private ClientesDAO daoClientes = new ClientesDAOImpl();
	private Cliente[] clientes;
	JTable tabla;
	JButton botonBorrar = new JButton("BORRAR");

	public PanelListadoClientes() {
		this.add(new JLabel("Soy el panel de listado de cliente"));
	}// end panellistadoclientes

	public void refrescarClientes() {
		this.clientes = daoClientes.obtenerClientes();
		tabla = new JTable(new TableModelClientes(clientes));
        tabla.setPreferredScrollableViewportSize(new Dimension(750, 500));
        tabla.setFillsViewportHeight(true);
        
        //PARA SOLO PODER SELECCIONAR UNA FILA
       // tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        //Create the scroll pane and add the table to it.
        JScrollPane scrollPane = new JScrollPane(tabla);

        //Add the scroll pane to this panel.
        //add(scrollPane);
		removeAll();//quito todo lo que tenga antes el dentro el panel
		this.add(botonBorrar);
		
		this.add(scrollPane);
		//voy a atender al boton borrar desde la instancia de esta clase
		//botonBorrar.addActionListener(this);
		//voy a atender al boton borrar desde la instancia de esta clase
		botonBorrar.addActionListener(this);
		
	}// end refrescarClientes

	@Override
	public void actionPerformed(ActionEvent e) {
		//por si tanto no se selecciona una fila como si pulso el boton repetidas veces
		if(tabla.getSelectedRow() == -1){
			return;
		}
		
		JOptionPane.showMessageDialog(null, "borrar: " + clientes[tabla.getSelectedRow()].toString());
		
		daoClientes.borrarCliente(clientes[tabla.getSelectedRow()].getId());
		refrescarClientes();
		SwingUtilities.updateComponentTreeUI(this);
		
	}//END PERFORMED

}// end class
