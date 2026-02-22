package logica.valueobjects;

import java.time.LocalDateTime;

import logica.negocio.Venta;

public class VOVentaIngreso {
	
	private String direccionEnvio;
	private LocalDateTime fecha;
	
	public VOVentaIngreso(String direccionEnvio, LocalDateTime fecha) {
		this.direccionEnvio = direccionEnvio;
		this.fecha = fecha;
	}
	
	public VOVentaIngreso(Venta v) {
		this.direccionEnvio = v.getDireccion();
		this.fecha = v.getFecha();
	}
	
	public String getDireccionEnvio() {
		return direccionEnvio;
	}
	public void setDireccionEnvio(String direccionEnvio) {
		this.direccionEnvio = direccionEnvio;
	}
	public LocalDateTime getFecha() {
		return fecha;
	}
	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

		
}
