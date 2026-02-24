package logica.valueobjects;

public class VOLightDetallado extends VOPostreDetallado {
	private String endulzante;
	private String descripcion;
	
	
	public VOLightDetallado(String codigo,String nombre,float precio,String tipo,String endulzante, String descripcion) {
		super(codigo, nombre, precio, tipo); 
		this.endulzante = endulzante;
		this.descripcion = descripcion;
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
