package modelo;

/**
 * @author portatil
 *
 */
public class Coche {
	private String marca;
	private String modelo;
	private String color;
	private String matricula;
	private String numero;
	private String asientos;
	private String traccion;
	private int id;

	public Coche() {
	}// end Coche

	public Coche(String marca, String modelo, String color, String matricula,
			String numero, String asientos, String traccion) {
		super();
		this.marca = marca;
		this.modelo = modelo;
		this.color = color;
		this.matricula = matricula;
		this.numero = numero;
		this.asientos = asientos;
		this.traccion = traccion;
	}// end Coche

	
	
	
	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getAsientos() {
		return asientos;
	}

	public void setAsientos(String asientos) {
		this.asientos = asientos;
	}

	public String getTraccion() {
		return traccion;
	}

	public void setTraccion(String traccion) {
		this.traccion = traccion;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Coche [marca=" + marca + ", modelo=" + modelo + ", color="
				+ color + ", matricula=" + matricula + ", numero=" + numero
				+ ", asientos=" + asientos + ", traccion=" + traccion + ", id="
				+ id + "]";
	}


	

}// END CLASE
