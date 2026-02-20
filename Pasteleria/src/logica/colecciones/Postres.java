package logica.colecciones;
import java.util.TreeMap;
import java.util.ArrayList;
import logica.negocio.Postre;
import logica.valueobjects.VOPostre;

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

	public ArrayList<VOPostre> obtenerPostres() {

	    ArrayList<VOPostre> listPostres = new ArrayList<VOPostre>();
	    for (Postre p : arbolPostres.values()) {
	    	
	    	VOPostre vop = new VOPostre(p);
	    	
	    	listPostres.add(vop);
	    }
	    return listPostres;
	}
}
