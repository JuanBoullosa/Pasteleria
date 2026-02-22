package logica.negocio;

import java.time.LocalDateTime;

import logica.excepciones.AlfanumericoException;
import logica.excepciones.PostreException;
import logica.excepciones.PrecioException;
import logica.valueobjects.VOLight;
import logica.valueobjects.VOPostre;

public class Venta {
	
	private int numero;
	private LocalDateTime fecha;
	private String direccion;
	private String estado;
	private float montoTotal;
	
	

	public Venta(int numero, LocalDateTime fecha, String direccion, String estado, float montoTotal) {
		super();
		this.numero = numero;
		this.fecha = fecha;
		this.direccion = direccion;
		this.estado = estado;
		this.montoTotal = montoTotal;
	}
	
	public int getNumero() {
		return numero;
	
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public LocalDateTime getFecha() {
		return fecha;
	}
	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public float getMontoTotal() {
		return montoTotal;
	}
	public void setMontoTotal(float montoTotal) {
		this.montoTotal = montoTotal;
	}
	
}
