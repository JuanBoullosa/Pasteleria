package logica.valueobjects;

public class VOLight extends VOPostre{
		private String endulzante;
		private String descripcion;
		
		public VOLight(float precio, String nombre, String codigo, String endulzante, String descripcion) {
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
		public void toVOPostre() {
			System.out.println(
					"\nPrecio: "+ getPrecio() + 
					"\nNombre: "+ getNombre() + 
					"\nCodigo: "+ getCodigo() +
					"\nEndulzante: "+ getEndulzante() +
					"\nDescripcion: "+ getDescripcion() 
					);
		}
		
}
