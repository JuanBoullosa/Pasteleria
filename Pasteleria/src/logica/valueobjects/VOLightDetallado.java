package logica.valueobjects;

import java.io.Serializable;

import logica.negocio.Light;

public class VOLightDetallado extends VOPostreDetallado implements Serializable {
	

	private static final long serialVersionUID = 1L;
	private String endulzante;
	private String descripcion;
	
	
	public VOLightDetallado(String codigo,String nombre,float precio,String tipo,String endulzante, String descripcion) {
		super(codigo, nombre, precio, tipo); 
		this.endulzante = endulzante;
		this.descripcion = descripcion;
	}
	
	public VOLightDetallado(Light l) {
		super(l); 
		this.endulzante = l.getEndulzante() ;
		this.descripcion = l.getDescripcion();
	}
	
	public String getEndulzante() {
		return endulzante;
	}
	public void setEndulzante(String endulzante) {
		this.endulzante = endulzante;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String toString() {
	    String resu = super.toString();
	    resu = resu + "\n Endulzante - " + getEndulzante();
	    resu = resu + "\n Descripcion - " + getDescripcion();
	    return resu;
	}

}
