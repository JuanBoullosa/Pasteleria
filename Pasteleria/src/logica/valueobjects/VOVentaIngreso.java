package logica.valueobjects;

import java.time.LocalDateTime;

public class VOVentaIngreso {
	
	public VOVentaIngreso(String direccionEnvio, LocalDateTime fecha) {
		super();
		this.direccionEnvio = direccionEnvio;
		this.fecha = fecha;
	}
	private String direccionEnvio;
	private LocalDateTime fecha;
	
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
