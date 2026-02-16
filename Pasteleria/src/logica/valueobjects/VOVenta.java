package logica.valueobjects;

import java.time.LocalDateTime;

public class VOVenta extends VOVentaIngreso {
	
	private int numero;
	private float montoTotal;
	String estado;
	
	
	public VOVenta(String direccionEnvio, LocalDateTime fecha, float montoTotal, String estado) {
		super(direccionEnvio, fecha);
		this.montoTotal = montoTotal;
		this.estado = estado;
	}
	
	public float getMontoTotal() {
		return montoTotal;
	}
	public void setMontoTotal(float montoTotal) {
		this.montoTotal = montoTotal;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	

}
