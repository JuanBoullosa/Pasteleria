package logica.valueobjects;

import java.io.Serializable;

import logica.negocio.Postre;

public class VOPostreDetallado implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String codigo;
	private String nombre;
	private float precio;
	private String tipo;
	
	
	public VOPostreDetallado(String codigo, String nombre, float precio, String tipo) {
		super();
		this.codigo = codigo;	
		this.nombre = nombre;
		this.precio = precio;
		this.tipo = tipo;
	}
	
	public VOPostreDetallado(Postre p, int cant) {
		this.codigo = p.getCodigo();	
		this.nombre = p.getNombre();
		this.precio = p.getPrecio();
		this.tipo = p.getTipoPostre();
	}
	
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public String toString() {
	    String resu;

	    resu = "\n Codigo" + " - " +getCodigo();
	    resu = resu + "\n Nombre " + " - "+  getNombre();
	    resu = resu + "\n Precio " + " - " +"$" + getPrecio();
	    resu = resu + "\n Tipo " + " - "  + getTipo();

	    return resu;
	}

}