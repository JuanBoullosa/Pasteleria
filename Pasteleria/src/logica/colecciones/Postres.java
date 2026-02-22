package logica.colecciones;
import java.util.TreeMap;
import java.util.ArrayList;
import logica.negocio.Light;
import logica.negocio.Postre;
import logica.valueobjects.VOLight;
import logica.valueobjects.VOPostre;
import logica.valueobjects.VOPostreDetallado;

public class Postres {
	
	private TreeMap<String,Postre> arbolPostres;
	

	public Postres ()
	{
		arbolPostres= new TreeMap<String, Postre> ();
	}

	public boolean member(String codigo)
	{
		return arbolPostres.containsKey(codigo);
	}
	
	public Postre find (String codigo)
	{
		return arbolPostres.get(codigo);
	}
	
	public void insert (String codigo, Postre P)
	{
		arbolPostres.put(codigo, P);
	}
	
	public void detelet (String codigo)
	{
		arbolPostres.remove(codigo);
	}
	
	 // (opcional) para listar en orden en pruebas
	public TreeMap<String, Postre> getArbolPostres()
	{
		return arbolPostres;
	}
	
	///Metodo auxiliar para ver en consola nada mas
		public ArrayList<VOPostreDetallado> obtenerPostresDetallado() {
			ArrayList<VOPostreDetallado> ListaDePostresDetallado = new ArrayList<VOPostreDetallado>();
			for (Postre p: arbolPostres.values()) {
				
				String tipo;
				
				if (p instanceof Light) {
					tipo = "LIGHT";
					
		 
					VOPostreDetallado vopd = new VOPostreDetallado(
							p.getCodigo(),
							p.getNombre(),
			                p.getPrecio(),
			                tipo
							);
						
					ListaDePostresDetallado.add(vopd);
					
				}else {
					tipo = "COMUN";
					
					VOPostreDetallado vopdc = new VOPostreDetallado(
							p.getCodigo(),
							p.getNombre(),
			                p.getPrecio(),
			                tipo
							);
					ListaDePostresDetallado.add(vopdc);
				}		
			}
			return ListaDePostresDetallado;
		}
	
	
    ///Metodo auxiliar para ver en consola nada mas
	public ArrayList<VOPostre> obtenerPostres() {
		ArrayList<VOPostre> ListaDePostres = new ArrayList<VOPostre>();
		for (Postre p: arbolPostres.values()) {
			
			VOPostre vop = new VOPostre(p);
			
			if (p instanceof Light) {
				Light l = (Light) p;
	
				VOLight vopl = new VOLight(
						l.getCodigo(),
						l.getNombre(),
		                l.getPrecio(),
		                l.getEndulzante(),
		                l.getDescripcion()
						);
					
				ListaDePostres.add(vopl);
				
			}else {
				ListaDePostres.add(vop);
			}		
		}
		return ListaDePostres;
	}
	
}
