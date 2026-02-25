package logica.negocio;
//import logica.valueobjects.VOPostre;

public class Es_Vendido {
	
	private int cantidad;
	private Postre postre;
	

	public Es_Vendido(Postre p, int cantidad) {
		this.cantidad = cantidad;
		this.postre = p;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	
	public Postre getPostre() {
		return postre;
	}

	public void setPostre(Postre postre) {
		this.postre = postre;
	}

	public void sumarCantidad(int cant) {
		int cantidadActual = this.cantidad;
		int nuevaCantidad = cantidadActual + cant;
		this.cantidad = nuevaCantidad;
	}
	
	public void restarCantidad(int cant) {
		int cantidadActual = this.cantidad;
		int nuevaCantidad = cantidadActual - cant;
		this.cantidad = nuevaCantidad;
	}
	 /*
	//MODIFICAR SOLO PARA PRUEBAS 
	public void toEsVendido (){
		VOPostre p = new VOPostre(getPostre()); 
		// p.toVOPostre();
	};
	*/

}
