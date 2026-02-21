package logica.valueobjects;

import java.time.LocalDateTime;

import logica.negocio.Venta;

public class VOVenta extends VOVentaIngreso {
	
	private int numero;
	private float montoTotal;
	private String estado;
	
	public VOVenta(String direccionEnvio, LocalDateTime fecha, int numero, float montoTotal, String estado) {
		super(direccionEnvio, fecha);
		this.numero = numero;
		this.montoTotal = montoTotal;
		this.estado = estado;
	}
	
	public VOVenta(Venta v) {
		super(v);
		this.numero = v.getNumero();
		this.montoTotal = v.getMontoTotal();
		this.estado = v.getEstado();
	}
	
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
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
	
	public void toVOVenta() {
		System.out.println(
				"\nDireccion Envio: "+ getDireccionEnvio() + 
				"\nFecha: "+ getFecha() + 
				"\nNumero: "+ getNumero() +
				"\nMonto Total: "+ getMontoTotal() +
				"\nEstado: "+ getEstado()
				);
	}
}
