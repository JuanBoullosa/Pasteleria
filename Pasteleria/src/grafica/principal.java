package grafica;

import logica.colecciones.Postres;
import logica.negocio.Postre;
import logica.negocio.Light;
import java.util.ArrayList;
import logica.valueobjects.VOPostre;


public class principal {

	public static void main(String[] args) {
		
		Postres dicPostres = new Postres();
		
		Postre p1 = new Postre("P002", "Torta de Chocolate", 500);
		Postre p2 = new Postre("P001", "Torta de Limon", 333);
		Postre p3 = new Postre("P003", "Torta de Coco", 999);
		Postre p4 = new Light("P004", "Torta de Coco", 887,"Azucar","Muy Dulce");
		
				dicPostres.insert(p3.getCodigo(), p3);		
				dicPostres.insert(p1.getCodigo(), p1);
				dicPostres.insert(p2.getCodigo(), p2);
				dicPostres.insert(p4.getCodigo(), p4);
				
				boolean existe = dicPostres.member("P004");
				
				System.out.println(existe);
				
				ArrayList<VOPostre> lista = dicPostres.obtenerPostres();

				for (VOPostre p:lista ){
					p.toVOPostre();
				};
				
						
	}

}
