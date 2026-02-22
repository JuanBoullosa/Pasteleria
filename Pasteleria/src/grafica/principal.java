package grafica;

import logica.colecciones.Postres;
import logica.negocio.Postre;
import logica.negocio.Light;

import java.time.LocalDateTime;
import java.util.ArrayList;
import fachada.Fachada;
import logica.excepciones.*;
import logica.valueobjects.*;
import logica.valueobjects.VOPostre;
import logica.colecciones.Ventas;
import logica.negocio.Venta;
import logica.valueobjects.VOVenta;



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
		
		//VOPostre vop = new VOPostre("090", "Torta de Chocolate", 10);
		VOLight vop = new VOLight("P003", "Torta de Coco",887 ,"Estevia","Bajo en calorias");
		
		try {
			f.registrarPostre(vop);
			System.out.println("Postre registrado correctamente");
			
			System.out.println("\nPostres registrado:");
			VOPostre vo = f.ListarPostreDetallado("P003");
			System.out.println(vo);
		}
		catch (AlfanumericoException e) {
			System.out.println(e.darMensaje());
		}
		catch (PrecioException e) {
			System.out.println(e.darMensaje());
		}
		catch (PostreException e) {
            System.out.println(e.darMensaje());
		
		};
	}


		/*
	   //4) Requemiento 4
		
		Ventas SecVentas = new Ventas();
	    LocalDateTime fecha = LocalDateTime.now();	
	    Venta v1 = new Venta(2,fecha,"18 de Julio", "Estado", 300);
	    Venta v2 = new Venta(3,fecha,"16 de Julio", "Pendiente", 999);
	    Venta v3 = new Venta(1,fecha,"17 de Julio", "Finalziada", 666);
	
	    SecVentas.insBack(v3);
	    SecVentas.insBack(v1);
	    SecVentas.insBack(v2);
		
		ArrayList<VOVenta> listaVentas = SecVentas.obtenerVentas();

		for (VOVenta v:listaVentas){
			v.toVOVenta();
		};
		*/

}


