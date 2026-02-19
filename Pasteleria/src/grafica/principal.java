package grafica;

import logica.colecciones.Postres;
import logica.negocio.Postre;


public class principal {

	public static void main(String[] args) {
		
		Postres dicPostres = new Postres();
		
		Postre p1 = new Postre("P001", "Torta de Chocolate", 500);
				
				dicPostres.insert(p1.getCodigo(), p1);
				
				boolean existe = dicPostres.member("P001");
				
				System.out.println(existe);
	}

}
