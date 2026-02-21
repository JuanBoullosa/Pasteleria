package logica.valueobjects;

public class VOLight extends VOPostre{
		private String endulzante;
		private String descripcion;
		
		public VOLight(float precio, String nombre, String codigo, String endulzante, String descripcion) {
			super(precio, nombre, codigo);
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
