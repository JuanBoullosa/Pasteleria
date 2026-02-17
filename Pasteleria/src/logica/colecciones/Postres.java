package logica.colecciones;
import java.util.TreeMap;
import logica.negocio.Postre;

public class Postres {
	
	private TreeMap<String,Postre> abb;
	

	public Postres ()
	{
		abb = new TreeMap<String, Postre> ();
	}

	public boolean member(String codigo)
	{
		return abb.containsKey(codigo);
	}
	
	public Postre find (String codigo)
	{
		return abb.get(codigo);
	}
	
	public void insert (String codigo, Postre P)
	{
		abb.put(codigo, P);
	}
	
	public void detelet (String codigo)
	{
		abb.remove(codigo);
	}
	
}
