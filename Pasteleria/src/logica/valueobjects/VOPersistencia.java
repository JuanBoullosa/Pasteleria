package logica.valueobjects;

	import java.io.Serializable;
	import logica.colecciones.*;

	public class VOPersistencia implements Serializable {
	private static final long serialVersionUID = 1L;

	private Postres postres;
	private Ventas ventas;

	public VOPersistencia(Postres postres, Ventas ventas) {
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

