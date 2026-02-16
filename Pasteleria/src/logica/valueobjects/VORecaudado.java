package logica.valueobjects;

import java.time.LocalDateTime;

public class VORecaudado {

	private int numeroVenta;
	private LocalDateTime fecha;
	
	
	
	public VORecaudado(int numeroVenta, LocalDateTime fecha) {
		super();
		this.numeroVenta = numeroVenta;
		this.fecha = fecha;
	}
	public int getNumeroVenta() {
		return numeroVenta;
	}
	public void setNumeroVenta(int numeroVenta) {
		this.numeroVenta = numeroVenta;
	}
	public LocalDateTime getFecha() {
		return fecha;
	}
	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}
	
	
	
}
