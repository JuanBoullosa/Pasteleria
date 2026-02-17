package logica.colecciones;
import java.util.TreeMap;
import logica.negocio.Postre;

public class Postres {
	
	private TreeMap<String,Postre> arbolpostres;
	

	public Postres ()
	{
		arbolpostres= new TreeMap<String, Postre> ();
	}

	public boolean member(String codigo)
	{
		return arbolpostres.containsKey(codigo);
	}
	
	public Postre find (String codigo)
	{
		return arbolpostres.get(codigo);
	}
	
	public void insert (String codigo, Postre P)
	{
		arbolpostres.put(codigo, P);
	}
	
	public void detelet (String codigo)
	{
		arbolpostres.remove(codigo);
	}
	
}
