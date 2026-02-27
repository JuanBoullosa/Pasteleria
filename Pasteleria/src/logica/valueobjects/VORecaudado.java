package logica.valueobjects;

import java.time.LocalDateTime;

public class VORecaudado {

	private float montoRecaudado;
	private int totalUnidades;
	
	
	public VORecaudado(float moontoRecaudado, int totalUnidades) {
		super();
		this.montoRecaudado = moontoRecaudado;
		this.totalUnidades = totalUnidades;
	}
	public float getMontoRecaudado() {
		return montoRecaudado;
	}
	public void setMontoRecaudado(float moontoRecaudado) {
		this.montoRecaudado = moontoRecaudado;
	}
	public int getTotalUnidades() {
		return totalUnidades;
	}
	public void setTotalUnidades(int totalUnidades) {
		this.totalUnidades = totalUnidades;
	}
	
	public String toString() {
	    String resu;

	    resu = "\n Monto total Recacudado" + " - " + getMontoRecaudado();
	    resu = resu + "\n Total Unidades " + " - "+  getTotalUnidades();
	    
	    return resu;
	}	
	
	
	
	
	
}
