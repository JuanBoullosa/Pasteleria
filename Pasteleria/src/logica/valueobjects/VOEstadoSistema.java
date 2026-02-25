package logica.valueobjects;

	import java.io.Serializable;
	import logica.colecciones.*;

	public class VOEstadoSistema implements Serializable {
	private static final long serialVersionUID = 1L;

	private Postres postres;
	private Ventas ventas;

	public VOEstadoSistema(Postres postres, Ventas ventas) {
	    this.postres = postres;
	    this.ventas = ventas;
	}

	public Postres getPostres() {
	    return postres;
	}

	public Ventas getVentas() {
	    return ventas;
	}
	}

