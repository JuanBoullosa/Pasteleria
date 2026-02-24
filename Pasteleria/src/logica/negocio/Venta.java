package logica.negocio;

import java.time.LocalDateTime;

import logica.excepciones.AlfanumericoException;
import logica.excepciones.PostreException;
import logica.excepciones.PrecioException;
import logica.valueobjects.VOLight;
import logica.valueobjects.VOPostre;
import logica.colecciones.Es_Vendidos;

public class Venta {
	
	private int numero;
	private LocalDateTime fecha;
	private String direccion;
	private String estado;
	private float montoTotal;
	private Es_Vendidos SecEsVendido;
	
	public Venta(int numero, LocalDateTime fecha, String direccion, String estado, float montoTotal,
			Es_Vendidos secEsVendido) {
		super();
		this.numero = numero;
		this.fecha = fecha;
		this.direccion = direccion;
		this.estado = estado;
		this.montoTotal = montoTotal;
		SecEsVendido = secEsVendido;
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
	public Es_Vendidos getSecEsVendido() {
		return SecEsVendido;
	}
	public void setSecEsVendido(Es_Vendidos secEsVendido) {
		SecEsVendido = secEsVendido;
	}
	
	//Requerimiento 5
	public void altaPostreEnVenta(Postre p, int cantidad)
	{
		SecEsVendido.insertarPostreEs_Vendidos(p, cantidad);
		montoTotal = SecEsVendido.actualizarMontoTotal();
	}

	
}
