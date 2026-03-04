package logica.valueobjects;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import logica.negocio.Postre;
import logica.negocio.Venta;

public class VOVenta extends VOVentaIngreso implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int numero;
	private float montoTotal;
	private String estado;
	
	public VOVenta(String direccionEnvio, LocalDate fecha, int numero, float montoTotal, String estado) {
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
	
	
	
	public String toString() {
	    String resu;

	    resu = "\n Numero" + " - " + getNumero();
	    resu = resu + "\n Fecha " + " - "+  getFecha();
	    resu = resu + "\n Direccion " + " - "  + getDireccionEnvio();
	    resu = resu + "\n Monto total " + " - " +"$" + getMontoTotal();
	    resu = resu + "\n Estado " + " - "  + getEstado();
	    
	    
	    return resu;
	}	

}
