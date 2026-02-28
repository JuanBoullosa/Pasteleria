package logica.valueobjects;

import java.io.Serializable;

public class VOLight extends VOPostre implements Serializable{
	
	
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		private String endulzante;
		private String descripcion;
		
		public VOLight(String codigo, String nombre, float precio, String endulzante, String descripcion) {
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
		
		public String toString() {
		    String resu;

		    resu = "\n Codigo" + " - " +getCodigo();
		    resu = resu + "\n Nombre " + " - "+  getNombre();
		    resu = resu + "\n Precio " + " - " +"$" + getPrecio();
		    /* El Req 2 no pide Mostrar si detalles del Ligth como extra solo el TIPO
		    resu = resu + "\n Endulzante " + " - " + getEndulzante();
		    resu = resu + "\n Descripcion" + " - " + getDescripcion();
		    */
		    resu = resu + "\n Tipo" + " - " + getTipoPostre();
		    return resu;
		}
		
		public String getTipoPostre() {
			return"Light";
		}
		

}