package modelo;

public class Cliente {
	private String nombre;
	private String domicilio;
	private String poblacion;
	private String codigoPostal;
	private String telefono;
	private int id;
public Cliente() {
}//end Cliente
public Cliente(String nombre, String domicilio, String pobalcion,
		String codigoPostal, String telefono) {
	super();
	this.nombre = nombre;
	this.domicilio = domicilio;
	this.poblacion = pobalcion;
	this.codigoPostal = codigoPostal;
	this.telefono = telefono;
}//end Cliente

public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public String getDomicilio() {
	return domicilio;
}
public void setDomicilio(String domicilio) {
	this.domicilio = domicilio;
}
public String getPobalcion() {
	return poblacion;
}
public void setPobalcion(String pobalcion) {
	this.poblacion = pobalcion;
}
public String getCodigoPostal() {
	return codigoPostal;
}
public void setCodigoPostal(String codigoPostal) {
	this.codigoPostal = codigoPostal;
}
public String getTelefono() {
	return telefono;
}
public void setTelefono(String telefono) {
	this.telefono = telefono;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}

@Override
public String toString() {
	return "Cliente [nombre=" + nombre + ", domicilio=" + domicilio
			+ ", poblacion=" + poblacion + ", codigoPostal=" + codigoPostal
			+ ", telefono=" + telefono + "]";
}


	
}//END CLASE
