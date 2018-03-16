package paneles;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import daos.CochesDAO;
import daos.CochesDAOImpl;
import modelo.Coche;

public class PanelRegistroCoches extends  JPanel
implements ActionListener{
	JTextField campoMarca = new JTextField(15);
	JTextField campoModelo = new JTextField(15);
	JTextField campoColor = new JTextField(15);
	JTextField campoMatricula = new JTextField(15);
	JTextField campoNumero = new JTextField(15);
	JTextField campoAsientos = new JTextField(15);
	JTextField campoTraccion = new JTextField(15);
	public PanelRegistroCoches() {
		// asi asigno un gestor de diseño que me permite
		// colocar las cosas en forma de filas y celdas

		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		// primer elemento
		gbc.gridy = 0;
		gbc.gridx = 0;
		gbc.gridwidth = 2;
		this.add(new JLabel("Introduce los datos del coche"), gbc);
		// vuelvo a decir que cada componente solo ocupe un elemento:
		gbc.gridwidth = 1;
		// segunda fila
		gbc.gridy = 1;
		gbc.gridx = 0;
		this.add(new JLabel("Marca: "), gbc);
		gbc.gridy = 1;
		gbc.gridx = 1;
		this.add(campoMarca, gbc);
		// tercera fila
		gbc.gridy = 2;
		gbc.gridx = 0;
		this.add(new JLabel("Modelo: "), gbc);
		gbc.gridy = 2;
		gbc.gridx = 1;
		this.add(campoModelo, gbc);
		// cuarta fila
		gbc.gridy = 3;
		gbc.gridx = 0;
		this.add(new JLabel("Color: "), gbc);
		gbc.gridy = 3;
		gbc.gridx = 1;
		this.add(campoColor, gbc);
		// quinta fila
		gbc.gridy = 4;
		gbc.gridx = 0;
		this.add(new JLabel("Matricula: "), gbc);
		gbc.gridy = 4;
		gbc.gridx = 1;
		this.add(campoMatricula, gbc);
		// sexta fila
		gbc.gridy = 5;
		gbc.gridx = 0;
		this.add(new JLabel("Numero bastidor: "), gbc);
		gbc.gridy = 5;
		gbc.gridx = 1;
		this.add(campoNumero, gbc);
		// septima fila
		gbc.gridy = 6;
		gbc.gridx = 0;
		this.add(new JLabel("Asientos: "), gbc);
		gbc.gridy = 6;
		gbc.gridx = 1;
		this.add(campoAsientos, gbc);
		// octava fila
		gbc.gridy = 7;
		gbc.gridx = 0;
		this.add(new JLabel("Traccion: "), gbc);
		gbc.gridy = 7;
		gbc.gridx = 1;
		this.add(campoTraccion, gbc);		
		//novena fila
		JButton botonRegistroCoche = new JButton("REGISTRAR");
		botonRegistroCoche.addActionListener(this);//tienes que implementar actionlistener		
		gbc.gridy = 8;
		gbc.gridx = 0;
		gbc.gridwidth = 2;
		this.add(botonRegistroCoche,gbc);
	}// ends PanelRegistro

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("actionPerformed del PanelRegistroCoche");
		String marca = campoMarca.getText();
		String modelo = campoModelo.getText();
		String color = campoColor.getText();
		String matricula = campoMatricula.getText();
		String numero = campoNumero.getText();	
		String asientos = campoAsientos.getText();
		String traccion = campoTraccion.getText();
		//ahora habria que validar estos datos
		//...TODO
		//Una vez validado todos los datos registramos en base de datos:
		Coche CocheAregistrar = new Coche(marca, modelo, color, matricula, numero, asientos, traccion);
			System.out.println("Voy a registrar: " + CocheAregistrar.toString());
			CochesDAOImpl CochesDAO = new CochesDAOImpl();
			CochesDAO.registrarCoche(CocheAregistrar);
		
	}//end actionPerfomed



}// ends class
