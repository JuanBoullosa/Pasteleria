package logica.valueobjects;

public class VOLight extends VOPostre{
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
		    resu = resu + "\n Endulzante " + " - " + getEndulzante();
		    resu = resu + "\n Descripcion" + " - " + getDescripcion();

		    return resu;
		}
		
		//ESTO ES LO MISMO QUE ARRIBA PERO LO ROBE DEL TEORICO
		public void toVOPostre() {
			System.out.println(
					"\nCodigo: "+ getCodigo() +
					"\nNombre: "+ getNombre() +
					"\nPrecio: "+ getPrecio() + 
					"\nEndulzante: "+ getEndulzante() +
					"\nDescripcion: "+ getDescripcion() 
					);
		}
		
}
