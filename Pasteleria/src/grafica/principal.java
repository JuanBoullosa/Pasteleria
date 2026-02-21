package grafica;

import logica.colecciones.Postres;
import logica.negocio.Postre;
import logica.negocio.Light;
import java.util.ArrayList;
import fachada.Fachada;
import logica.excepciones.*;
import logica.valueobjects.VOPostre;


public class principal {

	public static void main(String[] args) {
		
		Fachada f = new Fachada();
		
		/*Postres dicPostres = new Postres();
		
		Postre p1 = new Postre("P002", "Torta de Chocolate", 500);
		Postre p2 = new Postre("P001", "Torta de Limon", 333);
		Postre p3 = new Postre("P003", "Torta de Coco", 999);
		Postre p4 = new Light("P004", "Torta de Coco", 887,"Estevia","Bajo en calorias");
		Postre p5 = new Light("A003", "Galleta de avena  ", 250f ,"Miel","Fuerte en fibras");
				dicPostres.insert(p3.getCodigo(), p3);		
				dicPostres.insert(p1.getCodigo(), p1);
				dicPostres.insert(p2.getCodigo(), p2);
				dicPostres.insert(p4.getCodigo(), p4);
				dicPostres.insert(p5.getCodigo(), p5);
				boolean existe = dicPostres.member("P004");
				
				System.out.println(existe);
	
				
				ArrayList<VOPostre> lista = dicPostres.obtenerPostres();

				for (VOPostre p:lista ){
					p.toVOPostre();
				};*/
		
		VOPostre vo = new VOPostre("P010", "Torta de Chocolate", 10);
		
		try {
			f.registrarPostre(vo);
			f.registrarPostre(vo);
			System.out.println("Postre registrado correctamente");
		}
		catch (PrecioException e) {
			System.out.println(e.darMensaje());
		}
		catch (PostreException e) {
            System.out.println(e.darMensaje());
		}
		}
				
						
	}


