package logica.negocio;


public class Light extends Postre {
	private String endulzante;
	private String descripcion;
	
	public Light(String codigo,String nombre, float precio, String endulzante, String descripcion) {
		super(codigo, nombre, precio);
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
	


}
